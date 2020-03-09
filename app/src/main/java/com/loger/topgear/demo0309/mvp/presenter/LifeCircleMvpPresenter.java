package com.loger.topgear.demo0309.mvp.presenter;

import com.loger.topgear.demo0309.mvp.ILifeCircle;
import com.loger.topgear.demo0309.mvp.IMvpView;
import com.loger.topgear.demo0309.mvp.MvpControler;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    //弱引用的成员变量
    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter(){
     super();
    }
    protected LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);
        MvpControler mvpControler = iMvpView.getMvpControler();//难道当前view层的controler
        mvpControler.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
//确保传进来的参数IMvpView，被p层进行数据的同步
        //这里是弱引用，用来描述非必须对象，当JVM回收时，无论内存是否充足，都会回收被弱引用的对象
        //强引用，JVM无论何时都不会回收被强引用的对象
        if(weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else{
            T view = (T) weakReference.get();//泛型
            if(view != iMvpView){
                weakReference = new WeakReference(iMvpView);
            }
        }
    }
    @Override
    public void onDestroy() {//清空弱引用
        weakReference = null;
    }

    protected  T getView(){//在p层获取view层的引用
        T view = weakReference != null ? (T) weakReference.get() : null;//如果weakReference != null，那么weakReference.get()
        if (view == null){
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();
}
