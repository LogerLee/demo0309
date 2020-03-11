package com.loger.topgear.demo0309.main;

import android.support.v4.app.Fragment;

import com.loger.topgear.demo0309.R;
import com.loger.topgear.demo0309.main.e_me.E_meFragment;
import com.loger.topgear.demo0309.main.l_shangcheng.L_shangchengFragment;
import com.loger.topgear.demo0309.main.o_shejiao.O_shejiaoFragment;
import com.loger.topgear.demo0309.main.s_shouye.S_shouyeFragment;
import com.loger.topgear.demo0309.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter{

    //当前Fragment的角标
    private int mCurrentFramentIndex;
    //保存4个Fragment的实例
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrenCheckedId;


    public MainActivityPresenter(IMainActivityContract.Iview view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.Iview getEmptyView() {
        return IMainActivityContract.emptyView; //空View
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrenCheckedId;
    }

    @Override
    public void initHomeFragment() {   //初始化Fragment
        //记录当前是哪一个Fragment（角标）
        mCurrentFramentIndex = 0;
        replaceFragment(mCurrentFramentIndex);
    }




    //切换Fragment的方法
    public void replaceFragment(int mCurrentFramentIndex) {
       for (int i = 0;i<mFragments.length;i++){
           if(mCurrentFramentIndex != i){
               if (mFragments[i] != null){
                   hideFragment(mFragments[i]);
               }
           }
       }

        Fragment mFragment = mFragments[mCurrentFramentIndex];//通过当前的索引拿到当前的实例
        if(mFragment != null){
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFramentIndex);
        }else {   //如果是null
            newCurrentFragment(mCurrentFramentIndex);
            setCurChecked(mCurrentFramentIndex);
        }
    }

    //记录当前的角标
    private void setCurChecked(int mCurrentFramentIndex) {
        this.mCurrentFramentIndex = mCurrentFramentIndex;   //当前的成员变量 = 传进来的值
        switch (mCurrentFramentIndex){
            case 0:
              mCurrenCheckedId = R.id.rb_main_s;
              break;
            case  1:
                mCurrenCheckedId = R.id.rb_main_o;
                break;
            case 2:
                mCurrenCheckedId = R.id.rb_main_l;
                break;
            case  3:
                mCurrenCheckedId = R.id.rb_main_e;
                break;
                
        }
    }

    //创建当前的Fragment
    private void newCurrentFragment(int mCurrentFramentIndex) {
        Fragment fragment = null;
        switch (mCurrentFramentIndex){
            case 0:
                fragment = new S_shouyeFragment();
                break;
            case 1:
                fragment = new O_shejiaoFragment();
                break;
            case 2:
                fragment = new L_shangchengFragment();
                break;
            case 3:
                fragment = new E_meFragment();
        }
        //创建完成后，把Fragment放进集合
        mFragments[mCurrentFramentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    //显示Fragment
    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()){
           getView().showFragment(mFragment);
        }else {
            getView().addFragment(mFragment);
        }
    }

    //隐藏Fragment
    private void hideFragment(Fragment mFragment) {
       if (mFragment != null && mFragment.isVisible()){
           getView().hideFragment(mFragment);
       }

    }
}
