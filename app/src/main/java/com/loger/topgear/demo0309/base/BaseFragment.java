package com.loger.topgear.demo0309.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loger.topgear.demo0309.mvp.view.LifeCircleMvpFragment;

import java.security.PublicKey;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment{


    private Context mContex;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContex = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = null;
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0){
                mView = initFragmentView(inflater,mainlayoutid);
                bindView(mView);
                afterBindView();
            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater,int mainlayoutid) {
        return inflater.inflate(mainlayoutid,null);//父布局 = null

    }

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }*/

    //设计模式：模板方法
    public abstract void afterBindView();

    //View的依赖注入绑定
    private void bindView(View mView) {
        ButterKnife.bind(this,mView);
    }
}
