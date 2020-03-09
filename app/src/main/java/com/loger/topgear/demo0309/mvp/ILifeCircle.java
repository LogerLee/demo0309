package com.loger.topgear.demo0309.mvp;

import android.os.Bundle;
import android.content.Intent;

public interface ILifeCircle {

    //Activity或者Fragment生命周期的方法

    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);//getArguments是Fragment会用到

    void onActivityCreated(Bundle savedInstanceState,Intent intent,Bundle getArguments);//Fragment的生命周期的方法

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);//界面的跳转，传递数据

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
