package com.loger.topgear.demo0309;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Viewinject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @OnClick(R.id.fac_main_home)
    public void onViewClicked() {
    }
}
