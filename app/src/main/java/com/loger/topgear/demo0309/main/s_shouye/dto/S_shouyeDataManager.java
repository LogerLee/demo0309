package com.loger.topgear.demo0309.main.s_shouye.dto;

import java.util.ArrayList;

public class S_shouyeDataManager {


    //获取竖向数据
    private static ArrayList<S_shouyeBean> getVerData(int len){
        ArrayList<S_shouyeBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            S_shouyeBean bean = new S_shouyeBean();
            bean.setShowImg(false).setmDec("Hello everyone!");
            data.add(bean);
        }
        return data;
    }
    //获取横向数据
    private static ArrayList<S_shouyeBean> getHorData(int len){
        ArrayList<S_shouyeBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            S_shouyeBean bean = new S_shouyeBean();
            bean.setShowImg(true).setmDec("anhaseiyou!");
            data.add(bean);
        }
        return data;
    }
    //将这两个数据整理到一起，再传到Adapter
    public static ArrayList<S_shouyeBean> getData(){
        ArrayList<S_shouyeBean> data = new ArrayList<>();
        data.addAll(getVerData(5));
        data.add(new S_shouyeBean().setData(getHorData(10)).setmItemType(S_shouyeBean.IS_shouyeItemType.HORIZANTAL));
        data.addAll(getVerData(5));
        data.add(new S_shouyeBean().setData(getHorData(10)).setmItemType(S_shouyeBean.IS_shouyeItemType.HORIZANTAL));
        return data;
    }
}
