package com.loger.topgear.demo0309.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loger.topgear.demo0309.mvp.IMvpView;
import com.loger.topgear.demo0309.mvp.MvpControler;

public class LifeCircleMvpFragment extends Fragment implements IMvpView{


    private MvpControler mvpControler;//这个controler持有p层

    @Override
    public MvpControler getMvpControler() {
        if(this.mvpControler == null){
            this.mvpControler = new MvpControler();
        }
        return this.mvpControler;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if(bundle == null){
            bundle = new Bundle();
        }
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onCreate(savedInstanceState,null,bundle);//调用p层
            mvpControler.onActivityCreated(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle == null){
            bundle = new Bundle();
        }
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityCreated(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onViewDestroy();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler =this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityResult(requestCode,resultCode,data);
        }
    }
}

