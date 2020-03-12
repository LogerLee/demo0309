package com.loger.topgear.demo0309.main.s_shouye;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loger.topgear.demo0309.R;
import com.loger.topgear.demo0309.base.BaseFragment;
import com.loger.topgear.demo0309.base.Viewinject;
import com.loger.topgear.demo0309.base.BaseFragment;
import com.loger.topgear.demo0309.main.s_shouye.adapter.S_shouyeAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


@Viewinject(mainlayoutid = R.layout.fragment_s)
public class S_shouyeFragment extends BaseFragment {
    @BindView(R.id.tv_nihao)
    TextView tvNihao;
    @BindView(R.id.s_shouye_collapsingToolbarLayout)
    CollapsingToolbarLayout sShouyeCollapsingToolbarLayout;
    @BindView(R.id.s_shouye_appbarlayout)
    AppBarLayout sShouyeAppbarlayout;
    @BindView(R.id.s_shouye_recyclerview)
    RecyclerView sShouyeRecyclerview;


    @Override
    public void afterBindView() {
        initRecyclerView();
        initListener();

    }

    private void initRecyclerView() {
        sShouyeRecyclerview.setLayoutManager(new LinearLayoutManager(mContex));//setLayoutManager一个必要的api,它能做很多布局
        //适配器设计模式，把相应的数据Data展示到不同的布局View
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            data.add("首页欢迎你");
        }
        sShouyeRecyclerview.setAdapter(new S_shouyeAdapter(data));//setAdapter也是一个必要的api
    }

    private void initListener() {
        //监听AppBarLayout
        sShouyeAppbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvNihao.setVisibility(View.INVISIBLE);
                } else {
                    tvNihao.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
