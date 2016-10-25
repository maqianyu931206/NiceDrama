package com.maqianyu.nicedrama.map.quickhead;

import android.app.Dialog;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

import java.util.List;

/**
 * Created by dllo on 16/10/24.
 * @author 马迁宇
 *
 */
public class CollectionActivity extends AbsActivity {
    private ListView listView;
    private CollectLvAdapter collectLvAdapter;
    private SuperVideoPlayer superVideoPlayer;
    private List<LiteOrmBean> aa;

    @Override
    protected int setLayout() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initViews() {
        listView =byView(R.id.collect_listView);
    }

    @Override
    protected void initDatas() {
        collectLvAdapter = new CollectLvAdapter(this);
        listView.setAdapter(collectLvAdapter);
        aa = LitOrmIntance.getIntance().getQueryAll(LiteOrmBean.class);
        collectLvAdapter.setDatas(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Dialog dialog = new Dialog(CollectionActivity.this);
                View dview = LayoutInflater.from(CollectionActivity.this).inflate(R.layout.quickinfoheadview,null);
                superVideoPlayer = (SuperVideoPlayer) dview.findViewById(R.id.quick_info_superPlayer);
                superVideoPlayer.loadAndPlay(Uri.parse(aa.get(position).getUrl()),0);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setContentView(dview);
                dialog.show();
            }
        });
        new TitleBuilder(this).setMoreImg(false).setTitle(getResources().getString(R.string.save));


    }
}
