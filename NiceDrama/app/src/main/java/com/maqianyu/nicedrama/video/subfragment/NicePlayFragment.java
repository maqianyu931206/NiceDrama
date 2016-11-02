package com.maqianyu.nicedrama.video.subfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.Game2048Layout;

/**
 * Created by dllo on 16/11/2.
 * @author 张宏迪
 * 玩游戏的界面
 */
public class NicePlayFragment extends AbsFragment implements Game2048Layout.OnGame2048Listener {

    private Game2048Layout mGame2048Layout;

    private TextView mScore;
    private TextView mStep;

    public static NicePlayFragment newInstance() {

        Bundle args = new Bundle();

        NicePlayFragment fragment = new NicePlayFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_play_nice;
    }

    @Override
    protected void initViews() {
        mScore = byView(R.id.id_score);
        mStep = byView(R.id.id_step);
        mGame2048Layout =byView(R.id.id_game2048);
    }

    @Override
    protected void initDatas() {
        mGame2048Layout.setOnGame2048Listener(this);
    }

    @Override
    public void onScoreChange(int score) {
        mScore.setText("SCORE: " + score);
    }

    @Override
    public void onStepChange(int step) {
        mStep.setText("Step: " + step);
    }

    @Override
    public void onGameOver() {
        new AlertDialog.Builder(context).setTitle("GAME OVER")
                .setMessage("YOU HAVE GOT " + mScore.getText())
                .setPositiveButton("RESTART", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mGame2048Layout.restart();
                    }
                }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();

    }
}
