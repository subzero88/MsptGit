package com.bm.mspt.util;

import android.content.Context;
import android.content.DialogInterface;

import com.bm.mspt.view.DoubleBtnDialog;
import com.bm.mspt.view.SingleBtnDialog;

/**
 * 对话框工具类
 * Created by zhaol on 2015/4/20.
 */
public class DialogUtil {

    public interface DialogCallBack {
        public void onClickDialogSureBtn(int dialogId);

        public void onClickDialogCancleBtn(int dialogId);
    }

    /**
     * 单按钮对话框
     * @param context
     * @param callBack:实现接口的类
     * @param dialogId:对话框id
     * @param msg:显示内容
     * @param btnTxt:按钮显示内容
     */
    public static void showSingleBtnDialog(Context context, final DialogCallBack callBack, final int dialogId, String msg, String btnTxt) {
        SingleBtnDialog.Builder builder = new SingleBtnDialog.Builder(context);
        builder.setMessage(msg);
        builder.setPositiveButton(btnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                callBack.onClickDialogSureBtn(dialogId);
            }
        });
        builder.create().show();
    }

    /**
     * 单按钮对话框
     * @param context
     * @param callBack:实现回调接口的类
     * @param dialogId:对话框id
     * @param msgId:显示内容id
     * @param btnMsgId:按钮内容id
     */
    public static void showSingleBtnDialog(Context context, final DialogCallBack callBack, final int dialogId, int msgId, int btnMsgId) {
        SingleBtnDialog.Builder builder = new SingleBtnDialog.Builder(context);
        builder.setMessage(msgId);
        builder.setPositiveButton(btnMsgId, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                callBack.onClickDialogSureBtn(dialogId);
            }
        });
        builder.create().show();
    }

    /**
     * 双按钮对话框
     * @param context:上下文
     * @param callBack:回调类
     * @param dialogId:对话框id
     * @param msg:显示内容
     * @param btnOkTxt:确定按钮text
     * @param btnCancleTxt:取消按钮text
     */
    public static void showDoubleBtnDialog(Context context, final DialogCallBack callBack, final int dialogId, String msg, String btnOkTxt, String btnCancleTxt) {
        DoubleBtnDialog.Builder builder = new DoubleBtnDialog.Builder(context);
        builder.setMessage(msg);
        builder.setPositiveButton(btnOkTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                callBack.onClickDialogSureBtn(dialogId);
            }
        });
        builder.setNegativeButton(btnCancleTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                callBack.onClickDialogCancleBtn(dialogId);
            }
        });
        builder.create().show();
    }
}
