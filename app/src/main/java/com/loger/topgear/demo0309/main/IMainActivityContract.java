package com.loger.topgear.demo0309.main;

import android.support.v4.app.Fragment;

import com.loger.topgear.demo0309.mvp.ILifeCircle;
import com.loger.topgear.demo0309.mvp.IMvpView;
import com.loger.topgear.demo0309.mvp.MvpControler;

public interface IMainActivityContract {

    interface Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }
    interface IPresenter extends ILifeCircle {

        int getCurrentCheckedId();

        void replaceFragment(int mCurrentFramentIndex);

        void initHomeFragment();
    }
    Iview emptyView = new Iview() {


        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
