package com.maqianyu.nicedrama.map.quickhead;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/10/21.
 */
public class QuickRvAdapter extends RecyclerView.Adapter<QuickRvAdapter.MyViewHolder>{

    private List<Bean.FeedsBean>datas;
    private Context context;

    public void setDatas(List<Bean.FeedsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public QuickRvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quick_recycview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(datas.get(position).getCover_thumbnail_urls().get(0).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return datas ==null ? 0 :datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.item_quick_img);
        }

    }

}
