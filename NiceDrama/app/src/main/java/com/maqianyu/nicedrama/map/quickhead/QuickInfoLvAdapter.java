package com.maqianyu.nicedrama.map.quickhead;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.maqianyu.nicedrama.AbsBaseAdapter;
import com.maqianyu.nicedrama.R;

import java.util.List;

/**
 * Created by dllo on 16/10/22.
 */
public class QuickInfoLvAdapter  extends AbsBaseAdapter<QuickInfoBean.CommentsBean,QuickInfoLvAdapter.MyViewHold>{

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
        myViewHold.textView.setText(itemData.getContent());

    }



    class MyViewHold extends AbsBaseAdapter.BaseViewHolder{
        TextView textView;
        protected MyViewHold(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_quick_info_lv_tv
            );
        }

    }
}
