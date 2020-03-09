package com.loger.topgear.demo0309;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0){
                setContentView(mainlayoutid);
                ButterKnife.bind(this);
            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
    }
}