package com.bm.mspt.http.show;

import android.content.Context;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.EvaluationBean;

/**
 * Created by guoyh on 2015/5/14.
 * 提交评论信息 show data
 */
public class EvaluationShowData implements ShowData<EvaluationBean>{
    private Context context;
    public EvaluationShowData(Context context){
    this.context = context;
    }
    @Override
    public void showData(EvaluationBean evaluationBean) {
        if (evaluationBean.isSuccess()){
            ToastTools.show(context,context.getString(R.string.evaluation_commit_success));
        }else{

        }
    }
}
