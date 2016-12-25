package com.syc.an36_designui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/9/26 14:57
 * 备注:
 */

class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> {

    private List<Map<String, String>> mGirls;
    private Context mContext;

    interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    private static OnRecyclerViewItemClickListener mListener;

    void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener listener) {
        mListener = listener;
    }

    ContentAdapter(Context context, List<Map<String, String>> girls) {
        this.mContext = context;
        this.mGirls = girls;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Map<String, String> map = mGirls.get(position);
        String name = map.get("name");
        holder.tvName.setText(name);
        String logoName = map.get("logo");
        int mipmap = mContext.getResources().getIdentifier(logoName, "mipmap", mContext.getPackageName());
        holder.ivShow.setImageResource(mipmap);
    }

    @Override
    public int getItemCount() {
        return mGirls.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private ImageView ivShow;

        MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            ivShow = (ImageView) itemView.findViewById(R.id.iv_show);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
