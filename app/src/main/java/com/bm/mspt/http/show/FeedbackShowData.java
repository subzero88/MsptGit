package com.bm.mspt.http.show;

import android.content.Context;
import android.widget.EditText;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.FeedbackBean;

/**
 * Created by guoyh on 2015/4/23.
 * 反馈信息 ShowData;
 *
 */
public class FeedbackShowData implements ShowData<FeedbackBean> {
    public static final String TAG = "FeedbackShowData";
    /** 文本输入框*/
    private EditText editText;
    private Context context;
    public FeedbackShowData(Context context,EditText editText){
        this.context = context;
        this.editText = editText;
    }
    @Override
    public void showData(FeedbackBean feedbackBean) {
        if (feedbackBean.isSuccess()){
            editText.setText("");
            ToastTools.show(context,context.getString(R.string.acty_feedback_msg_success));
        }else{
            ToastTools.show(context,context.getString(R.string.acty_feedback_msg_fail));
        }
    }
}
