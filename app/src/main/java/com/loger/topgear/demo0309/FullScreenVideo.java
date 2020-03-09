package com.loger.topgear.demo0309;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullScreenVideo extends VideoView {

    //主要用于直接new出来的对象
    public FullScreenVideo(Context context) {
        super(context);
    }

    //主要用于xml文件，支持自定义属性
    public FullScreenVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //主要用于xml文件，支持自定义属性，也支持style样式
    public FullScreenVideo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//widthMeasureSpec宽度，heightMeasureSpec高度
        //widthMeasureSpec 包含两个主要的内容 1.测量模式 2.测量大小
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width,height);
    }
}
