package com.loger.topgear.demo0309;

import android.util.Log;

import com.loger.topgear.demo0309.mvp.IMvpView;
import com.loger.topgear.demo0309.mvp.ISplashActivityContract;
import com.loger.topgear.demo0309.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter{



    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }


    public void initTimer() {
        timer = new CustomCountDownTimer(2, new CustomCountDownTimer.ICountDownHandler() {//new一个数据回调
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "s");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("Skip");

            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("SplashTimerPresenter","onDestroy");
    }

    //防止空指针
    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;   //这样getView()永远不会空指针
    }
}
