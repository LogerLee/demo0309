package com.loger.topgear.demo0309.main.s_shouye;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loger.topgear.demo0309.R;
import com.loger.topgear.demo0309.base.BaseFragment;
import com.loger.topgear.demo0309.base.Viewinject;

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
    Unbinder unbinder;

    @Override
    public void afterBindView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
