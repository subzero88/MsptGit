package com.bm.mspt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bm.mspt.buy.BuyFragment;
import com.bm.mspt.home.IndexFragment;
import com.bm.mspt.my.MyMallFragment;
import com.bm.mspt.sell.SellFragment;
import com.bm.mspt.shop.ShopFragment;


public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {

    private IndexFragment indexFragment; // 首页fragment
    private SellFragment sellFragment; // 供货fragment
    private BuyFragment buyFragment; // 求购fragment
    private ShopFragment shopFragment; // 购物车frag
    private MyMallFragment myMallFragment;  // 我的商城 fragment
    private RadioGroup bottomRadioGroup; // 底部tab切换
    private TextView textViewShopNum; // 购物车商品数量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        bottomRadioGroup = (RadioGroup) findViewById(R.id.index_rg);
        switchContent(getIndexFragment());
        textViewShopNum = (TextView) findViewById(R.id.activity_main_txt_shopnum);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        bottomRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.index_rb_index: // 首页
                        switchContent(getIndexFragment());
                        break;
                    case R.id.index_rb_sell: // 供货
                        switchContent(getSellFragment());
                        break;
                    case R.id.index_rb_buy: // 求购
                        switchContent(getBuyFragment());
                        break;
                    case R.id.index_rb_shop: // 购物车
                        switchContent(getShopFragment());
                        break;
                    case R.id.index_rb_my: // 我的商城
                        switchContent(getMyMallFragment());
                        break;
                }
            }
        });
    }

    /**
     * 切换fragment
     */
    private void switchContent(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.app_content, fragment).commit();
    }

    /**
     * 获取首页fragment
     * @return
     */
    private Fragment getIndexFragment() {
        if (indexFragment == null) {
            indexFragment = new IndexFragment();
        }
        return indexFragment;
    }

    /**
     * 获取供货fragment
     * @return
     */
    private Fragment getSellFragment() {
        if (sellFragment == null) {
            sellFragment = new SellFragment();
        }
        return sellFragment;
    }

    /**
     * 获取求购fragment
     * @return
     */
    private Fragment getBuyFragment() {
        if (buyFragment == null) {
            buyFragment = new BuyFragment();
        }
        return buyFragment;
    }

    /**
     * 获取购物车fragment
     * @return
     */
    private Fragment getShopFragment() {
        if (shopFragment == null) {
            shopFragment = new ShopFragment();
        }
        return shopFragment;
    }

    /**
     * 获取我的商城fragment
     * @return
     */
    private Fragment getMyMallFragment() {
        if (myMallFragment == null){
            myMallFragment = new MyMallFragment();
        }
        return myMallFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
