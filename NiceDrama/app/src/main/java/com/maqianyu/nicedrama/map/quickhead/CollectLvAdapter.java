package com.maqianyu.nicedrama.map.quickhead;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.ImageLoaderTool;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;

import java.util.List;

/**
 * Created by dllo on 16/10/25.
 */
public class CollectLvAdapter extends BaseAdapter {
    private Context context;
    private List<LiteOrmBean> datas;

    public CollectLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<LiteOrmBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyCollViewHolder myCollViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.save_item_lv, null);
            myCollViewHolder = new MyCollViewHolder(convertView);
            convertView.setTag(myCollViewHolder);
        } else {
            myCollViewHolder = (MyCollViewHolder) convertView.getTag();
        }
        ImageLoaderTool.loadImage(datas.get(position).getTitle(), myCollViewHolder.imageView);
        myCollViewHolder.textView.setText(datas.get(position).getImgUrl());
        return convertView;
    }

    class MyCollViewHolder {
        ImageView imageView;
        TextView textView;

        public MyCollViewHolder(View view) {

            imageView = (ImageView) view.findViewById(R.id.save_item_img);
            textView = (TextView) view.findViewById(R.id.save_item_tv);
        }
    }
    public void remove(LiteOrmBean liteOrmBean){
        datas.remove(liteOrmBean);
        notifyDataSetChanged();
    }

}
