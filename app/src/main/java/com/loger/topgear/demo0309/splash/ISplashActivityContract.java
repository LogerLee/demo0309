package com.loger.topgear.demo0309.splash;

import com.loger.topgear.demo0309.mvp.ILifeCircle;
import com.loger.topgear.demo0309.mvp.IMvpView;
import com.loger.topgear.demo0309.mvp.MvpControler;

public interface ISplashActivityContract {

    interface Iview extends IMvpView {
        void setTvTimer(String timer);
    }
    interface IPresenter extends ILifeCircle {
        void initTimer();

    }
    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {
        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
