package com.maqianyu.nicedrama.map.quickhead;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.util.ScreenSizeUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/10/21.
 */
public class QuickRvAdapter extends RecyclerView.Adapter<QuickRvAdapter.MyViewHolder> {

    private List<Bean.FeedsBean> datas;
    private Context context;
    private RecyclerInstance recyclerInstance;

    public void setRecyclerInstance(RecyclerInstance recyclerInstance) {
        this.recyclerInstance = recyclerInstance;
    }

    public void setDatas(List<Bean.FeedsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public QuickRvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quick_recycview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ScreenSizeUtils.setWidthScreen(holder.imageView, 2);
        Picasso.with(context).load(datas.get(position).getCover_thumbnail_urls().get(0).getUrl()).into(holder.imageView);
        if (datas.get(position).getLike_count() + "" != "") {
            holder.textView.setText(datas.get(position).getLike_count() + "");
        }
        if (datas.get(position).getHeadurls().get(0).getUrl() != "") {
            Picasso.with(context).load(datas.get(position).getHeadurls().get(0).getUrl()).into(holder.cirimg);
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = holder.getLayoutPosition();
                String str = datas.get(p).getMain_mv_urls().get(0).getUrl();
                recyclerInstance.OnRnItemClikListener(p, str);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, cirimg;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.item_quick_img);
            cirimg = (ImageView) view.findViewById(R.id.item_quick_cir_img);
            textView = (TextView) view.findViewById(R.id.item_quick_tv);
        }

    }

}
