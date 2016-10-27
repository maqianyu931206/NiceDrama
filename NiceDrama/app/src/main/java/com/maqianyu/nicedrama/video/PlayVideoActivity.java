package com.maqianyu.nicedrama.video;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.Tools.ThreadPoolInstance;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

/**
 * Created by dllo on 16/10/26.
 */
public class PlayVideoActivity extends AbsActivity {

    private SuperVideoPlayer svp;
    private ImageView backImg;
    private TextView titleTv;
    private RelativeLayout upRl;
    public static final String DETAIL_URL = "url";
    public static final String DETAIL_TITLE = "title";
    private String detailUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_play_land;
    }

    @Override
    protected void initViews() {
        svp = byView(R.id.act_play_land_svp);
        backImg = byView(R.id.act_play_land_back_img);
        titleTv = byView(R.id.act_play_land_title_tv);
        upRl = byView(R.id.act_play_land_rl);
    }

    @Override
    protected void initDatas() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        titleTv.setText(bundle.getString(DETAIL_TITLE));
        detailUrl = bundle.getString(DETAIL_URL);
        svp.loadAndPlay(Uri.parse(detailUrl), 0);

        ThreadPoolInstance.getInstance().startThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                upRl.setVisibility(View.VISIBLE);
            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
