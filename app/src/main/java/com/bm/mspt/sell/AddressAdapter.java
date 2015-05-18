package com.bm.mspt.sell;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.base.LogCat;
import com.bm.base.ToastTools;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.AddressBean;
import com.bm.mspt.http.bean.AddressBean.AddressItemBean;
import com.bm.mspt.http.show.DeleteAddressShowData;
import com.bm.mspt.http.show.SetDefAddressShowData;
import com.bm.mspt.util.DialogUtil;

import java.util.List;

/**
 * Created by guoyh on 2015/4/29.
 * 收货地址管理页面——adapter
 */
public class AddressAdapter extends BaseAdapter {
    private Context context;
    private List<AddressItemBean> list;
    private ListView listView;
    public AddressAdapter(Context context,List<AddressItemBean> list,ListView listView){
        this.context = context;
        this.list = list;
        this.listView = listView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<AddressItemBean> getList() {
        return list;
    }

    public void setList(List<AddressItemBean> list) {
        this.list = list;
    }

    public void removeListItem(int i){
        this.getList().remove(i);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AddressItem item ;
        if (view == null){
            item = new AddressItem();
            view = item.getView(context);
            view.setTag(item);
        }else{
            item = (AddressItem)view.getTag();
        }
        item.setBean(list.get(i),context,i,listView);

        return view;
    }

    /***
     * item 的视图，包括控件
     */
    public class AddressItem{
        /** 第一字段*/
        private TextView textView1;
        /** 第二字段*/
        private TextView textView2;
        /** 第三字段*/
        private TextView textView3;
        /** 手机号*/
        private TextView textViewPhone;
        /** 按钮：设为默认*/
        private Button btnSet;
        /** 按钮：编辑*/
        private Button btnEdit;
        /** 按钮：删除*/
        private Button btnDelete;

        public View getView(Context context){
            View view = LayoutInflater.from(context).inflate(R.layout.item_acty_address,null);
            textView1 = (TextView) view.findViewById(R.id.item_acty_address_textView1);
            textView2 = (TextView) view.findViewById(R.id.item_acty_address_textView2);
            textView3 = (TextView) view.findViewById(R.id.item_acty_address_textView3);
            textViewPhone = (TextView) view.findViewById(R.id.item_acty_address_textView_phone);
            btnSet = (Button) view.findViewById(R.id.item_acty_address_btn_set);
            btnEdit = (Button) view.findViewById(R.id.item_acty_address_btn_edit);
            btnDelete = (Button) view.findViewById(R.id.item_acty_address_btn_delete);
            return  view;
        }

        public void setBean(final AddressItemBean bean, final Context context, final int i,
                            final ListView listView){
            textView1.setText(bean.getName());
            textView2.setText(bean.getRegion_name());
            textView3.setText(bean.getAddress());
            textViewPhone.setText(bean.getMobile());

            //设为默认地址
            btnSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new HttpService().setDefaultAddress(bean.getUserid(),bean.getConsignee_id(),
                            new SetDefAddressShowData(bean.getUserid(),listView));
                }
            });

            //编辑收货地址
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("bean", bean);
                    Intent intent = new Intent(context,AddEditAddressActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

            //删除收货地址
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUtil.showDoubleBtnDialog(context,new DialogUtil.DialogCallBack() {
                        @Override
                        public void onClickDialogSureBtn(int dialogId) {
                                  new HttpService().deleteAddress(bean.getUserid(), bean.getConsignee_id(),
                                          new DeleteAddressShowData(AddressAdapter.this, i));
                        }

                        @Override
                        public void onClickDialogCancleBtn(int dialogId) {

                        }
                    },0,context.getString(R.string.confrm_delete),
                            context.getString(R.string.sure),
                            context.getString(R.string.cancel));
                }
            });
        }

    }
}
