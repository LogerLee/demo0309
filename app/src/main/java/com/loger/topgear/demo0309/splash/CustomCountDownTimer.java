package com.loger.topgear.demo0309.splash;

import android.os.Handler;

public class CustomCountDownTimer implements Runnable{
    private  int time;
    private int countDowntime;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    //1.实时回调剩余时间(观察者设计模式)
    //2.支持动态传入总时间
    //3.每过一秒，秒数减一
    //4.总时间倒计时为零时，要回调完成的状态
    public  CustomCountDownTimer (int time,ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
    }

    //实现的具体逻辑
    @Override
    public void run() {
        if (isRun){
            if(countDownHandler != null){
               countDownHandler.onTicker(countDowntime);
            }
            if (countDowntime == 0){
                if (countDownHandler != null){
                    countDownHandler.onFinish();
                }
            }else {
                countDowntime = time--;
                handler.postDelayed(this,1000);
            }
        }
    }
    //开启倒计时
    public void start(){
        isRun = true;
        handler.post(this);
    }

    //跳出循环终止
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);//取消
    }

    //观察者回调接口（IOC数据回调）
    public interface ICountDownHandler{
        //倒计时回调
        void onTicker(int time);//把当前跑了几秒回调出去

        //完成时回调
        void onFinish();
    }
}
