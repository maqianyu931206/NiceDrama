package com.maqianyu.nicedrama.map.graph;

import android.os.Bundle;
import android.widget.SeekBar;

import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/20.
 */
public class SectorFragmert extends AbsFragment implements SeekBar.OnSeekBarChangeListener {

    public static SectorFragmert newInstance() {
        Bundle args = new Bundle();
        SectorFragmert fragment = new SectorFragmert();
        fragment.setArguments(args);
        return fragment;
    }
    private SectorView sectorView;
    private SeekBar seekBar;


    @Override
    protected int setLayout() {
        return R.layout.fragment_sector;
    }

    @Override
    protected void initViews() {
        sectorView = byView(R.id.sectorView);
        seekBar = byView(R.id.seekBar);
    }

    @Override
    protected void initDatas() {
        // seekerBar
        seekBar.setOnSeekBarChangeListener(this);

    }

    private int[] lastData0 = new int[]{70000, 10000, 20000, 40000, 50000, 80000, 40000};
    private int[] thisData0 = new int[]{40000, 10000, 10000, 20000, 30000, 50000, 30000};
    private int[] lastData1 = new int[]{70000, 60000, 60000, 40000, 50000, 80000, 80000};
    private int[] thisData1 = new int[]{40000, 30000, 30000, 20000, 30000, 50000, 30000};
    private int[] lastData2 = new int[]{70000, 50000, 70000, 80000, 80000, 80000, 70000};
    private int[] thisData2 = new int[]{40000, 10000, 40000, 40000, 30000, 40000, 10000};
    private int[] lastData3 = new int[]{70000, 80000, 70000, 40000, 50000, 80000, 40000};
    private int[] thisData3 = new int[]{10000, 10000, 10000, 20000, 30000, 10000, 30000};

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // TODO Auto-generated method stub
        int cc = progress / 4;
        switch (cc) {
            case 0:
                sectorView.updateThisData(lastData0);
                sectorView.updateLastData(thisData0);
                break;
            case 1:
                sectorView.updateThisData(lastData1);
                sectorView.updateLastData(thisData1);
                break;
            case 2:
                sectorView.updateThisData(lastData2);
                sectorView.updateLastData(thisData2);
                break;
            case 3:
                sectorView.updateThisData(lastData3);
                sectorView.updateLastData(thisData3);
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }
}
