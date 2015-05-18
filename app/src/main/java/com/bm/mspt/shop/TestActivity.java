package com.bm.mspt.shop;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyh on 2015/4/20.
 * 测试用
 */
public class TestActivity extends BaseActivity{
    private ListView listView;
    private TextView textView;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.acty_test);
////        tv1 = (TextView)findViewById(R.id.textView);
//        tv2 = (TextView)findViewById(R.id.textView2);
////        bn = (Button)findViewById(R.id.button);
//        bn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                test(bool);
//        listView = (ListView) findViewById(R.id.listView);
//        textView = (TextView) findViewById(R.id.textView2);
//        List<Holder> list = new ArrayList<Holder>();
//        for(int i = 0;i<22;i++){
//            Holder holder = new Holder();
//            holder.setCount( (int)(Math.random()*100));
//            list.add(holder);
//        }
//        TestAdapter adapter = new TestAdapter(list,this);
//        listView.setAdapter(adapter);
    }
//    public class TestAdapter extends BaseAdapter{
//        private List<Holder> list;
//        private Context context;
//        public TestAdapter(List<Holder> list,Context context){
//            this.list = list;
//            this.context = context;
//        }
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            final ItemView iv;
//            if (view == null){
//                view = LayoutInflater.from(context).inflate(R.layout.test_layout,null);
//                iv = new ItemView();
//                iv.checkBox = (CheckBox) view.findViewById(R.id.checkBox);
//                iv.textView1 = (TextView)view.findViewById(R.id.textView);
//                view.setTag(iv);
//            }else{
//                iv = (ItemView)view.getTag();
//            }
//
//            iv.textView1.setText(""+list.get(i).getCount());
//            iv.checkBox.setOnCheckedChangeListener(new CheckLinstener(i,list));
//            iv.checkBox.setChecked(list.get(i).isSelect());
//            return view;
//        }
//    }
//
//
//    public class CheckLinstener implements CompoundButton.OnCheckedChangeListener{
//        private int index = -1;
//        private List<Holder> list;
//        public CheckLinstener(int index,List<Holder> list){
//            this.index = index;
//            this.list = list;
//        }
//        @Override
//        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            list.get(index).setSelect(b);
//            count = 0;
//            for(int i =0;i<list.size();i++){
//                if (list.get(i).isSelect()){
//                    count += list.get(i).count;
//                }
//            }
//            setCount(count);
//        }
//    }
//
//    public class Holder{
//        private int count = 0;
//        private boolean select = false;
//        public Holder(){}
//
//        public int getCount() {
//            return count;
//        }
//
//        public void setCount(int count) {
//            this.count = count;
//        }
//
//        public boolean isSelect() {
//            return select;
//        }
//
//        public void setSelect(boolean select) {
//            this.select = select;
//        }
//    }
//    public class ItemView{
//        public TextView textView1;
//        public CheckBox checkBox;
//    }
//
//    public void setCount(int count){
//        textView.setText(""+count);
//    }
}
