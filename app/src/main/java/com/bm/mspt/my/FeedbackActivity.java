package com.bm.mspt.my;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.FeedbackShowData;

import java.text.BreakIterator;

/**
 * Created by guoyh on 2015/4/15.
 * 意见反馈页面
 */
public class FeedbackActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    /** 反馈信息最小长度*/
    private static final int MIN_LENGTH = 1;
    /** 反馈信息最大长度*/
    private static final int MAX_LENGTH = 500;
    /** 输入长度提示*/
    private static final String TIP_LENGTH ="/500";
    /** 用户id，测试用，以后会通过方法获取*/
    private static final String USER_ID = "1";
    /** 文字输入框*/
    private EditText editTextFeedback;
    /** 已输入的长度提示*/
    private TextView textViewLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle(getString(R.string.acty_feedback_title));
        editTextFeedback = (EditText) findViewById(R.id.activity_feedback_edittext);
        textViewLength = (TextView)findViewById(R.id.activity_feedback_input_length);
        (findViewById(R.id.activity_feedback_btn)).setOnClickListener(this);
        editTextFeedback.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_feedback_btn: // 提交
                String strFeedback = editTextFeedback.getText().toString();
                if(strFeedback == null){
                    ToastTools.show(this,getString(R.string.feedback_can_not_empty));
                    break;
                }
                if(strFeedback.length() < MIN_LENGTH){
                    ToastTools.show(this,getString(R.string.feedback_too_little));
                    break;
                }
                if(strFeedback.length() > MAX_LENGTH){
                    ToastTools.show(this,getString(R.string.feedback_too_much));
                    break;
                }
                new HttpService().sendFeedbackMsg2Server(USER_ID,strFeedback,new FeedbackShowData(this,editTextFeedback));
                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

    @Override
    public void afterTextChanged(Editable editable) {
        textViewLength.setText(editable.toString().length()+TIP_LENGTH);
    }
}
