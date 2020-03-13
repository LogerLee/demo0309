package com.loger.topgear.demo0309.main.s_shouye.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loger.topgear.demo0309.R;
import com.loger.topgear.demo0309.main.s_shouye.dto.S_shouyeBean;

import java.security.PublicKey;
import java.util.ArrayList;

public class S_shouyeAdapter extends RecyclerView.Adapter{

    private final ArrayList<S_shouyeBean> mData;   //数据源
    private final Context mContext;
    private final boolean mIsHor;
    private final RecyclerView.RecycledViewPool recycledViewPool;

    public S_shouyeAdapter(Context context,ArrayList<S_shouyeBean> data,boolean isHor){
       recycledViewPool = new RecyclerView.RecycledViewPool();
       mData = data;
       mContext = context;
       mIsHor = isHor;
    }

    @NonNull
    @Override
    //创建View，并放到ViewHolder（用来缓存View）//根据不同的类型填充不同的View
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == S_shouyeBean.IS_shouyeItemType.VERTICAL){
            if (mIsHor){
                Log.e("onCreateViewHolder","VERTICAL");
            }

            //把布局生成View
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_s_fragment, viewGroup,false);
            S_shouyeViewHolder viewHolder = new S_shouyeViewHolder(inflate);
            return viewHolder;
        }else if(viewType == S_shouyeBean.IS_shouyeItemType.HORIZANTAL){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_s_fragment_hor_rv, null);
            S_shouyeViewHolderRv viewHolder = new S_shouyeViewHolderRv(inflate);
            return viewHolder;
        }
          return null;
    }

    @Override
    //每个条目都会调用一次这个方法，绑定数据（根据不同类型进行绑定）
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        S_shouyeBean s_shouyeBean = mData.get(position);
        if (viewHolder instanceof S_shouyeViewHolder) {//instanceof判断其左边对象是否为其右边类的实例，返回boolean类型的数据。
            ((S_shouyeViewHolder) viewHolder).mTv.setText(s_shouyeBean.getmDec());   //s_shouyeBean.getmDec()描述
            ((S_shouyeViewHolder) viewHolder).mIv.setVisibility(s_shouyeBean.isShowImg()?View.VISIBLE:View.GONE);//先判断一下S_shouyeBean是否显示图片
            ((S_shouyeViewHolder) viewHolder).itemView.setTag(position);

        }else if (viewHolder instanceof S_shouyeViewHolderRv){
            //((S_shouyeViewHolderRv) viewHolder).mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            ((S_shouyeViewHolderRv) viewHolder).mRecyclerView.setAdapter(new S_shouyeAdapter(mContext,s_shouyeBean.getData(),true));//true为标记（表示为横向的recycleview）
        }
    }

    //条目的数量
    @Override
    public int getItemCount() {   //条目有多少个
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {

        return mData.get(position).getmItemType();
    }

    //缓存View，内存友好设计
    public class S_shouyeViewHolder extends RecyclerView.ViewHolder{

        public TextView mTv;
        public ImageView mIv;


        public S_shouyeViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shouye_tv);
            mIv = itemView.findViewById(R.id.item_shouye_hor_iv);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int)v.getTag();
                    Toast.makeText(mContext,"我被点击了 position =" + position,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public class S_shouyeViewHolderRv extends RecyclerView.ViewHolder{

        public RecyclerView mRecyclerView;

        public S_shouyeViewHolderRv(@NonNull View itemView) {
            super(itemView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView = itemView.findViewById(R.id.item_shouye_hor_rv);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setRecycledViewPool(recycledViewPool);
        }
    }

}
