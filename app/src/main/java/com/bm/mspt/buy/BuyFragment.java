package com.bm.mspt.buy;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bm.mspt.AppKey;
import com.bm.mspt.R;
import com.bm.mspt.buy.list.BuyGoodsListActivity;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.GoodsTypeShowData;
import com.bm.mspt.sell.list.GoodsListActivity;
import com.bm.mspt.sell.SellFragment;

/**
 * 求购
 * Created by zhaol on 2015/4/29.
 */
public class BuyFragment extends SellFragment {

    @Override
    protected void moveToGoodsList(int i) {
        Intent intent = new Intent(getActivity(), BuyGoodsListActivity.class);
        intent.putExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE_ID, adapterTwo.getItem(i).getCategory_id());
        getActivity().startActivity(intent);
    }

    @Override
    protected void getData() {
        new HttpService().goodsTypeList(getActivity(), new GoodsTypeShowData(this, adapterOne), this);
    }

    @Override
    protected void setTitle(View rootView) {
        ((TextView) rootView.findViewById(R.id.head_title)).setText(getString(R.string.buy_goods_type));
    }
}
