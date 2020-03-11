package com.loger.topgear.demo0309.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.loger.topgear.demo0309.R;
import com.loger.topgear.demo0309.base.BaseActivity;
import com.loger.topgear.demo0309.base.Viewinject;
import com.loger.topgear.demo0309.main.tools.MainConstantTool;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Viewinject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_main_s)
    RadioButton rbMainS;
    @BindView(R.id.rb_main_o)
    RadioButton rbMainO;
    @BindView(R.id.rb_main_l)
    RadioButton rbMainL;
    @BindView(R.id.rb_main_e)
    RadioButton rbMainE;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.fl_main_content)
    FrameLayout flMainContent;

    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    } */


    @Override
    public void afterBindView() {
        initHomeFragment();
        initCheckListener();
    }

    private void initCheckListener() {
        rbMainS.setChecked(true);
        rgMainTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              if (checkedId == mPresenter.getCurrentCheckedId()){
                   return;
              }
              switch (checkedId){
                  case R.id.rb_main_s:
                      mPresenter.replaceFragment(MainConstantTool.S_SHOUYE);
                      break;
                  case R.id.rb_main_o:
                      mPresenter.replaceFragment(MainConstantTool.O_SHEJIAO);
                      break;
                  case R.id.rb_main_l:
                      mPresenter.replaceFragment(MainConstantTool.L_SHANGCHENG);
                      break;
                  case R.id.rb_main_e:
                      mPresenter.replaceFragment(MainConstantTool.E_ME);
                      break;
              }
            }
        });
    }

    @OnClick(R.id.fac_main_home)
    public void onClick() { }

    //初始化 Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }


    @Override
    public void showFragment(Fragment mFragment) {
        //显示当前的Fragment
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }






}
