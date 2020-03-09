package com.loger.topgear.demo0309;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.activity_splash)

public class SplashActivity extends BaseActivity {

    @BindView(R.id.vv_play)
    FullScreenVideo mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView mTvTimer;


    private SplashTimerPresenter timerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initTimerPresenter();

        //被整合、抽到onCreate出去的函数
        initListener();
        initView();
        //可以把初始化Timer及相关内容抽离到Presenter层
       // initTimer();

    }

    private void initTimerPresenter() {
        //因为view层持有p层的引用
        //所以在view层创建一个p层的强引用对象
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }

   /* private void initTimer() {
        timer = new CustomCountDownTimer(2, new CustomCountDownTimer.ICountDownHandler() {//new一个数据回调
            @Override
            public void onTicker(int time) {
                mTvTimer.setText(time + "s");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("Skip");
            }
        });
        timer.start();
    }*/

    private void initView() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        //IOC数据回调，观察者设计模式
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    private void initListener() {

        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    protected void onDestroy(){
        super.onDestroy();
        timerPresenter.cancel();
    }

    public void setTvTimer(String s) {
        mTvTimer.setText(s);
    }
}
