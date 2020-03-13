package com.loger.topgear.demo0309.main.s_shouye.dto;

import java.util.ArrayList;

public class S_shouyeBean {

    private int mItemType = IS_shouyeItemType.VERTICAL;
    private String mDec;
    private boolean isShowImg;   //是否展示图片
    private ArrayList<S_shouyeBean> data;   //横向列表

    public int getmItemType() {
        return mItemType;
    }

    public S_shouyeBean setmItemType(int mItemType) {
        this.mItemType = mItemType;
        return this;
    }

    public String getmDec() {
        return mDec;
    }

    public S_shouyeBean setmDec(String mDec) {
        this.mDec = mDec;
        return this;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public S_shouyeBean setShowImg(boolean showImg) {
        isShowImg = showImg;
        return this;
    }

    public ArrayList<S_shouyeBean> getData() {
        return data;
    }

    public S_shouyeBean setData(ArrayList<S_shouyeBean> data) {
        this.data = data;
        return this;
    }
    public interface IS_shouyeItemType{
        int VERTICAL = 0;
        int HORIZANTAL = 1;
    }


}
