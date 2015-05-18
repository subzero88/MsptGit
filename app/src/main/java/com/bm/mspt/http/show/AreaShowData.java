package com.bm.mspt.http.show;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.base.LogCat;
import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.AreaBean;
import com.bm.mspt.sell.AddEditAddressActivity;
import com.bm.mspt.sell.AddressAreaAdapter;

import java.util.List;


/**
 * Created by guoyh on 2015/5/11.
 * 区域选中
 */
public class AreaShowData implements ShowData<AreaBean> {
    private int count = 0;
    private String[] areas = new String[3];
    private ListView listView;
    private List<AreaBean.AreaItemnBean> list;
    private Activity activity;
    private TextView textView;
    public AreaShowData(Activity activity,ListView listView,TextView textView){
        this.activity = activity;
        this.listView = listView;
        this.textView = textView;
    }
    @Override
    public void showData(AreaBean areaBean) {
        if (areaBean.isSuccess()) {
            list = areaBean.getData().getChild_area_list();
            AddressAreaAdapter adapter = new AddressAreaAdapter(listView.getContext(),list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (count == 2){
                        areas[count] = list.get(i).getRegion_name();
                        Intent intent = new Intent();
                        intent.putExtra(AddEditAddressActivity.AREA_ID,list.get(i).getRegion_id());
                        intent.putExtra(AddEditAddressActivity.AREA_NAME,areas);
//                        count = 0;
                        activity.setResult(0,intent);
                        activity.finish();
                    }else{
                        areas[count] = list.get(i).getRegion_name();
                        new HttpService().getArea(list.get(i).getRegion_id(),AreaShowData.this);
                        count++;
                        ToastTools.show(listView.getContext(),"count = "+count);
                        setAreaInfo(textView,areas);
                    }
                }
            });
        } else {

        }
    }

    /**
     * 显示已选择的区域
     * @param textView  显示的字段
     * @param areas             区域数组
     */
    private void setAreaInfo(TextView textView,String[] areas){
        String info = "";
        for(int i =0;i<areas.length;i++){
            if (areas[i] != null){
                info += areas[i];
            }else{
                break;
            }
        }
        textView.setText(info);
    }
}
