package com.maqianyu.nicedrama.map.graph;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.TitleBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/17.
 * 地图页面的Fragment
 *
 * @author 马迁宇
 */
public class ChartActivity extends AbsActivity{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private VPAdapter vpAdapter;
    String str[] = new String[]{"折线图","扇形图","柱状图"};
    @Override
    protected int setLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.viewPager);
        tabLayout = byView(R.id.tableLayout);
    }

    @Override
    protected void initDatas() {
        List<Fragment>datas = new ArrayList<>();
        datas.add(new BrokenFragment());
        datas.add(new SectorFragmert());
        datas.add(new ColunmarFragment());
        tabLayout.setupWithViewPager(viewPager);
        vpAdapter = new VPAdapter(getSupportFragmentManager(),datas);
        viewPager.setAdapter(vpAdapter);
        for (int i = 0; i < str.length; i++) {
            tabLayout.getTabAt(i).setText(str[i]);
        }
        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);

        new TitleBuilder(this).setTitle(this.getResources().getString(R.string.chart)).setViewColor(Color.YELLOW).setMoreImg(false);

    }


}
