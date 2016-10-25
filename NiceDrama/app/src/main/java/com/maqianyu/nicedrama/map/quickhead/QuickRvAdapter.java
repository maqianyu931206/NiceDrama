package com.maqianyu.nicedrama.map.quickhead;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.ImageLoaderTool;
import com.maqianyu.nicedrama.Tools.ScreenSizeUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *快手详情,RecyclerView的适配器
  *@auther 马迁宇对你说!
 */
public class QuickRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LoadStatus mLoadStatus = LoadStatus.CLICK_LOAD_MORE;//上拉加载的状态
    private static final int VIEW_TYPE_FOOTER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private List<Bean.FeedsBean> datas;
    private Context context;
    private RecyclerInstance recyclerInstance;

    public void setRecyclerInstance(RecyclerInstance recyclerInstance) {
        this.recyclerInstance = recyclerInstance;
    }

    public void setDatas(List<Bean.FeedsBean> datas) {
        this.datas = datas;
        Log.d("ggg", "datas.size():" + datas.size());
        notifyDataSetChanged();
    }

    public QuickRvAdapter(Context context) {
        this.context = context;
    }

    public void setLoadStatus(LoadStatus loadStatus) {

        this.mLoadStatus = loadStatus;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==VIEW_TYPE_FOOTER){
            return  onCreateFooterViewHolder(parent,viewType);
        }else if (viewType ==VIEW_TYPE_ITEM){
            return onCreateItemViewHolder(parent,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_ITEM:
                onBindItemViewHolder(holder, position);
                break;
            case VIEW_TYPE_FOOTER:
                onBindFooterViewHolder(holder, position, mLoadStatus);
                break;
            default:
                break;
        }
    }

    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder myviewHolder = (MyViewHolder) holder;
        ScreenSizeUtils.setWidthScreen(myviewHolder.imageView, 2);
        Picasso.with(context).load(datas.get(position).getCover_thumbnail_urls().get(0).getUrl()).into(myviewHolder.imageView);
        if (datas.get(position).getLike_count() + "" != "") {
            myviewHolder.textView.setText(datas.get(position).getLike_count() + "");
        }
        if (datas.get(position).getHeadurls().size() !=  0) {
//            Picasso.with(context).load(datas.get(position).getHeadurls().get(0).getUrl()).into(myviewHolder.cirimg);
            ImageLoaderTool.loadImage(datas.get(position).getHeadurls().get(0).getUrl(),myviewHolder.imageView);
        }else {
            myviewHolder.cirimg.setImageResource(R.mipmap.ic_launcher);
        }

        myviewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = myviewHolder.getLayoutPosition();
                String str = datas.get(p).getMain_mv_urls().get(0).getUrl();
                recyclerInstance.OnRnItemClikListener(p, str);
            }
        });
    }

    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position, LoadStatus loadStatus) {
        FooterViewHolder viewHolder = (FooterViewHolder) holder;
        switch (loadStatus) {
            case CLICK_LOAD_MORE:
                viewHolder.mLoadingLayout.setVisibility(View.GONE);
                viewHolder.mClickLoad.setVisibility(View.VISIBLE);
                break;
            case LOADING_MORE:
                viewHolder.mLoadingLayout.setVisibility(View.VISIBLE);
                viewHolder.mClickLoad.setVisibility(View.GONE);
                break;
        }
    }
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_footview, parent,false);
        return new FooterViewHolder(view);
    }

    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quick_recycview, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return VIEW_TYPE_FOOTER;
        }
        return VIEW_TYPE_ITEM;
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
   class FooterViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLoadingLayout;
        public TextView mClickLoad;

        public FooterViewHolder(View itemView) {
            super(itemView);
            mLoadingLayout = (LinearLayout) itemView.findViewById(R.id.loading);
            mClickLoad = (TextView) itemView.findViewById(R.id.click_load_txt);

        }
    }


    public enum LoadStatus {

        CLICK_LOAD_MORE,//点击加载更多
        LOADING_MORE//正在加载更多
    }

}
