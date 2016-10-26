package com.maqianyu.nicedrama.map.quickhead;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.maqianyu.nicedrama.Tools.AbsBaseAdapter;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.ImageLoaderTool;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/10/22.
 */
public class QuickInfoLvAdapter extends AbsBaseAdapter<QuickInfoBean.CommentsBean, QuickInfoLvAdapter.MyViewHold> {
    public QuickInfoLvAdapter(Context context) {
        super(context);
    }


    @Override
    protected int setItemLayout() {
        return R.layout.item_quick_info_lv;
    }

    @Override
    protected MyViewHold onCreatViewHolder(View convertView) {
        return new MyViewHold(convertView);
    }

    @Override
    protected void onBindViewHolder(MyViewHold myViewHold, QuickInfoBean.CommentsBean itemData, int position) {
//        if (itemData.getContent() != null) {
//            myViewHold.content.setText(itemData.getContent());
//        }
//        if (itemData.getAuthor_name() != null) {
//            myViewHold.anthor.setText(itemData.getAuthor_name());
//        }
        ImageLoaderTool.loadImage(itemData.getHeadurl(), myViewHold.imageView);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = itemData.getTime();
        try {
            Date ddtt = format.parse(date);
            long tt1 = System.currentTimeMillis();
            long tt2 = ddtt.getTime();
            long tt3 = tt2 - tt1;
            long tt4 = Math.abs(tt3 / 1000 / 60);
            if (tt4 < 60) {
                myViewHold.time.setText(tt4 + "分钟前");
            } else if (tt4 > 60) {
                myViewHold.time.setText(tt4 / 60 + "小时前");
            }
            if (tt4 / 60 / 60 > 1) {
                myViewHold.time.setText(tt4 / 60 / 60 + "天前");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    class MyViewHold extends AbsBaseAdapter.BaseViewHolder {
        TextView content, anthor, time;
        CircleImageView imageView;

        protected MyViewHold(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.item_quick_info_content_tv);
            anthor = (TextView) itemView.findViewById(R.id.item_quick_info_author_name_tv);
            time = (TextView) itemView.findViewById(R.id.item_quick_info_time_tv);
            imageView = (CircleImageView) itemView.findViewById(R.id.item_quick_info_img);

        }

    }
}
