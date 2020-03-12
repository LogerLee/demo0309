package com.loger.topgear.demo0309.main.s_shouye.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loger.topgear.demo0309.R;

import java.util.ArrayList;

public class S_shouyeAdapter extends RecyclerView.Adapter{

    private final ArrayList<String> mData;   //数据源

    public S_shouyeAdapter(ArrayList<String> data){
       mData = data;
    }

    @NonNull
    @Override
    //创建View，并放到ViewHolder（用来缓存View）
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //把布局生成View
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_s_fragment, null);
        S_shouyeViewHolder viewHolder = new S_shouyeViewHolder(inflate);
        return viewHolder;
    }

    @Override
    //每个条目都会调用一次这个方法，绑定数据
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((S_shouyeViewHolder)viewHolder).mTv.setText(mData.get(position));
    }

    //条目的数量
    @Override
    public int getItemCount() {   //条目有多少个
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    //缓存View，内存友好设计
    public class S_shouyeViewHolder extends RecyclerView.ViewHolder{

        public TextView mTv;

        public S_shouyeViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shouye_tv);
        }
    }

}
