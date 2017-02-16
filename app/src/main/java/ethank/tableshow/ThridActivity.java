package ethank.tableshow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import ethank.tableshow.adapter.GoodsDetailAdapter;
import ethank.tableshow.adapter.GoodsNameAdapter;
import ethank.tableshow.modle.Good;
import ethank.tableshow.view.LinkedHorizontalScrollView;
import ethank.tableshow.view.NoScrollHorizontalScrollView;

/**
 * Created by ping on 2017/2/16.
 */

public class ThridActivity extends Activity {
    private static final String TAG = "ThridActivity";

    private NoScrollHorizontalScrollView mHz_title;
    private RecyclerView mRecyclerview_name;
    private LinkedHorizontalScrollView mHz_good_detail;
    private RecyclerView mRecyclerview_detail;
    String[] typeNameArray = new String[]{"商品条码", "商品分类", "规格", "单位", "供应商", "零售价", "保质期", "进货日期", "进货价"};
    List<String> goodsNameList = new ArrayList<>();
    List<Good> goods = new ArrayList<>();
    private boolean isNameScroll = false;
    private boolean isDetailScroll = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        GoodsNameAdapter goodsNameAdapter = new GoodsNameAdapter(goods);
        GoodsDetailAdapter goodsDetailAdapter = new GoodsDetailAdapter(goods);

        mRecyclerview_name.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview_name.setAdapter(goodsNameAdapter);

        mRecyclerview_detail.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview_detail.setAdapter(goodsDetailAdapter);
    }


    private void initViews() {
        mHz_title = (NoScrollHorizontalScrollView) findViewById(R.id.hz_title);
        mRecyclerview_name = (RecyclerView) findViewById(R.id.recyclerview_name);
        mHz_good_detail = (LinkedHorizontalScrollView) findViewById(R.id.hz_good_detail);
        mRecyclerview_detail = (RecyclerView) findViewById(R.id.recyclerview_detail);
        correlationViews(mHz_title, mRecyclerview_name, mHz_good_detail, mRecyclerview_detail);
    }

    /**
     * 关联views的滑动
     *
     * @param mHz_title
     * @param mRecyclerview_name
     * @param mHz_good_detail
     * @param mRecyclerview_detail
     */
    private void correlationViews(final NoScrollHorizontalScrollView mHz_title, final RecyclerView mRecyclerview_name, LinkedHorizontalScrollView mHz_good_detail, final RecyclerView mRecyclerview_detail) {
        //mHz_good_detail 滑动 -- mHz_title滑动
        mHz_good_detail.setMyScrollChangeListener(new LinkedHorizontalScrollView.LinkScrollChangeListener() {
            @Override
            public void onscroll(LinkedHorizontalScrollView view, int l, int t, int oldl, int oldt) {
                mHz_title.scrollTo(l, t);
            }
        });
        mRecyclerview_name.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e(TAG, "name--onScrolled"+"DX:" + dx + "-----dy:" + dy);
                if (!isDetailScroll && dy != 0) {
                    Log.e(TAG,"isNameScroll设为true了");
                    isNameScroll = true;
                }
                if (isNameScroll) {
                    mRecyclerview_detail.scrollBy(0, dy);
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e(TAG, "name--onScrollStateChanged"+"newState:" + newState);
                if (newState == 0) {
                    isNameScroll = false;
                    isDetailScroll = false;
                }
            }
        });
        mRecyclerview_detail.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e(TAG, "detail--onScrollStateChanged"+"newState:" + newState);
                if (newState == 0) {
                    isNameScroll = false;
                    isDetailScroll = false;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e(TAG, "detail--onScrolled"+"DX:" + dx + "-----dy:" + dy);
                //为了标示 是先从哪侧滑动的
                if (!isNameScroll && dy != 0) {
                    isDetailScroll = true;
                }
                Log.e(TAG,"isNameScroll:"+isNameScroll+"---isDetailScroll:"+isDetailScroll);
                if (isDetailScroll) {
                    Log.e(TAG, "detail--onScrolled name开始滑动啦 "+"DX:" + dx + "-----dy:" + dy);
                    mRecyclerview_name.scrollBy(0, dy);
                }
            }
        });

    }


    private void initData() {
        initGoodsType();
        initGoods();
    }

    private void initGoodsType() {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        NoScrollHorizontalScrollView.LayoutParams ll_params = new NoScrollHorizontalScrollView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(ll_params);
        LinearLayout.LayoutParams tv_params = new LinearLayout.LayoutParams(UICommonUtil.dip2px(this, 70), ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < typeNameArray.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(typeNameArray[i]);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(tv_params);
            ll.addView(textView);
        }
        mHz_title.addView(ll);
    }

    private void initGoods() {
        for (int i = 0; i < 40; i++) {
            Good good = new Good();
            good.setGoodName("iphone" + i);
            good.setGoodBar("100011" + i);
            good.setGoodBuyPrice(i + "");
            good.setGoodClasses("类型" + i);
            good.setGoodPurchaseDate("2017-02-1" + i);
            good.setGoodUnit("个");
            good.setGoodPrice("" + 10 + i);
            good.setGoodQuality("保质期" + i);
            good.setGoodStandard("规格" + i);
            good.setGoodSupplier("中南海" + i);
            goods.add(good);
        }
    }
}
