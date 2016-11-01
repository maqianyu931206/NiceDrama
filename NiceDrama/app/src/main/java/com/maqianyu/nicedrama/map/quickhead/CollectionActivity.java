package com.maqianyu.nicedrama.map.quickhead;

import android.app.Dialog;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

import java.util.List;

/**
 * Created by dllo on 16/10/24.
 *我的收藏页面
 * @author 马迁宇
 */
public class CollectionActivity extends AbsActivity {
    private DeleteListView listView;
    private CollectLvAdapter collectLvAdapter;
    private SuperVideoPlayer superVideoPlayer;
    private List<LiteOrmBean> aa;
    private Dialog dialog;

    @Override
    protected int setLayout() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.collect_listView);
    }

    @Override
    protected void initDatas() {
        collectLvAdapter = new CollectLvAdapter(this);
        listView.setAdapter(collectLvAdapter);
        aa = LitOrmIntance.getIntance().getQueryAll(LiteOrmBean.class);
        collectLvAdapter.setDatas(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                dialog = new Dialog(CollectionActivity.this);
                View dview = LayoutInflater.from(CollectionActivity.this).inflate(R.layout.quickinfoheadview, null);
                superVideoPlayer = (SuperVideoPlayer) dview.findViewById(R.id.quick_info_superPlayer);
                superVideoPlayer.loadAndPlay(Uri.parse(aa.get(position).getUrl()), 0);
                superVideoPlayer.setVideoPlayCallback(new SuperVideoPlayer.VideoPlayCallbackImpl() {
                    @Override
                    public void onCloseVideo() {

                    }

                    @Override
                    public void onSwitchPageType() {

                    }

                    @Override
                    public void onPlayFinish() {
                        aa = LitOrmIntance.getIntance().getQueryAll(LiteOrmBean.class);
                        collectLvAdapter.setDatas(aa);
                        superVideoPlayer.loadAndPlay(Uri.parse(aa.get(position).getUrl()), 0);

                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.setContentView(dview);
                dialog.show();
                LiteOrmBean bean = (LiteOrmBean) parent.getItemAtPosition(position);
                collectLvAdapter.remove(bean);
            }
        });
        new TitleBuilder(this).setMoreImg(false).setTitle(getResources().getString(R.string.save));
        // 滑动删除的监听
        listView.setRemoveListener(new DeleteListView.RemoveListener() {
            @Override
            public void removeItem(DeleteListView.RemoveDirection direction, int position) {
                LitOrmIntance.getIntance().deleteOne(((LiteOrmBean) collectLvAdapter.getItem(position)).getTitle());
                collectLvAdapter.remove((LiteOrmBean) collectLvAdapter.getItem(position));
            }
        });
    }
}
