package com.loger.topgear.demo0309;

public class SplashTimerPresenter {

    private final SplashActivity mActivity;

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(SplashActivity activity){
        this.mActivity = activity;
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(2, new CustomCountDownTimer.ICountDownHandler() {//new一个数据回调
            @Override
            public void onTicker(int time) {
                mActivity.setTvTimer(time + "s");

            }

            @Override
            public void onFinish() {
                mActivity.setTvTimer("Skip");

            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }
}
