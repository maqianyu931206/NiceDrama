package com.maqianyu.nicedrama.myset;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsBaseAdapter;
import com.maqianyu.nicedrama.myset.speech.SettingLvBean;

/**
 * Created by dllo on 16/10/24.
 */
public class SettingLvAdapter extends AbsBaseAdapter<SettingLvBean,SettingLvAdapter.ViewHolder> {
    public SettingLvAdapter(Context context) {
        super(context);
    }

    @Override
    protected int setItemLayout() {
        return R.layout.item_setting_lv;
    }

    @Override
    protected ViewHolder onCreatViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, SettingLvBean itemData, int position) {
        viewHolder.tv.setText(itemData.getName());
        viewHolder.img.setImageResource(itemData.getImg());

    }

    class ViewHolder extends AbsBaseAdapter.BaseViewHolder {
        TextView tv;
        ImageView img;
        public ViewHolder(View view){
            super(view);
            tv = (TextView) view.findViewById(R.id.item_set_list_tv);
            img = (ImageView) view.findViewById(R.id.item_set_list_img);

        }
    }
}
