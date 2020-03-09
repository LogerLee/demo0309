package com.loger.topgear.demo0309;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.loger.topgear.demo0309.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0){
                setContentView(mainlayoutid);
                bindView();
                afterBindView();
            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
    }
    //设计模式：模板方法
    public abstract void afterBindView();

    //View的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }
}
