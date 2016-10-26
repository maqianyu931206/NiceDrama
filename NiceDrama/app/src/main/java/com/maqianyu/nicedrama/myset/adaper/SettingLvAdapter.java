package com.maqianyu.nicedrama.myset.adaper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsBaseAdapter;
import com.maqianyu.nicedrama.Tools.DataClearUtil;
import com.maqianyu.nicedrama.myset.bean.SettingLvBean;

/**
 * Created by dllo on 16/10/24.
 * 我的 页面ListView的适配器
 * @author 庞美
 */
public class SettingLvAdapter extends AbsBaseAdapter<SettingLvBean,SettingLvAdapter.ViewHolder> {
    private int selectesIndex;
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

    public void setSelectesIndex(int selectesIndex) {
        this.selectesIndex = selectesIndex;
        notifyDataSetChanged();
    }

    @Override
    protected void onBindViewHolder(final ViewHolder viewHolder, SettingLvBean itemData, int position) {
        viewHolder.tv.setText(itemData.getName());
        viewHolder.img.setImageResource(itemData.getImg());
        String cacheSize = "";
        /**
         * 设置缓存大小
         */
        try {
            long b = DataClearUtil.getFolderSize(context.getCacheDir());
            cacheSize = DataClearUtil.getFormatSize(b).toString();
            Log.d("zzz", cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (position != 4){
            viewHolder.cacheTv.setText("");
        }else {
            viewHolder.cacheTv.setText(cacheSize);

        }
        if (position == selectesIndex && position != 0){
            DataClearUtil.cleanInternalCache(context);
            /**
             * 删除该路径下的文件数据
             */
            DataClearUtil.deleteFolderFile(context.getCacheDir().getPath(), false);
            try {
                long b = DataClearUtil.getFolderSize(context.getCacheDir());
                cacheSize = DataClearUtil.getFormatSize(b);

            } catch (Exception e) {
                e.printStackTrace();
            }
            viewHolder.cacheTv.setText(cacheSize);

        }



    }

    class ViewHolder extends AbsBaseAdapter.BaseViewHolder {
        TextView tv;
        ImageView img;
        TextView cacheTv;
        public ViewHolder(View view){
            super(view);
            tv = (TextView) view.findViewById(R.id.item_set_list_tv);
            img = (ImageView) view.findViewById(R.id.item_set_list_img);
            cacheTv = (TextView) view.findViewById(R.id.item_set_list_cache_tv);

        }
    }
}
