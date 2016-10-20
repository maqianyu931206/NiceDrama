package com.maqianyu.nicedrama.map.graph;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/20.
 */
public class SectorFragmert extends AbsFragment {
    private SectorView sectorView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_sector;
    }

    @Override
    protected void initViews() {
        sectorView = byView(R.id.sectorView);
    }

    @Override
    protected void initDatas() {

    }
}
