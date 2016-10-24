package com.maqianyu.nicedrama.myset;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.maqianyu.nicedrama.AbsBaseAdapter;
import com.maqianyu.nicedrama.R;

import java.util.List;

/**
 * Created by dllo on 16/10/24.
 */
public class LWListAdapter extends AbsBaseAdapter<LWListBean,LWListAdapter.ViewHolder>{
    public LWListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int setItemLayout() {
        return R.layout.item_lw_list;
    }

    @Override
    protected ViewHolder onCreatViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, LWListBean itemData, int position) {
        viewHolder.tv.setText(itemData.getTv());

    }

    class ViewHolder extends AbsBaseAdapter.BaseViewHolder{
        TextView tv;
        public ViewHolder(View view){
            super(view);
            tv = (TextView) view.findViewById(R.id.item_lw_list_tv);

        }
    }
}
