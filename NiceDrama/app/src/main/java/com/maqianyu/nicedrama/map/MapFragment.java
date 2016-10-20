package com.maqianyu.nicedrama.map;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.map.graph.BrokenFragment;
import com.maqianyu.nicedrama.map.graph.ColunmarFragment;
import com.maqianyu.nicedrama.map.graph.SectorFragmert;
import com.maqianyu.nicedrama.map.graph.VPAdapter;
import com.maqianyu.nicedrama.map.map_aty.MapActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/17.
 * 地图页面的Fragment
 *
 * @author 马迁宇
 */
public class MapFragment extends AbsFragment{
   private Button btnmap;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private VPAdapter vpAdapter;
    String str[] = new String[]{"折线图","柱状图","饼状图"};

    public static MapFragment newInstance() {
        Bundle args = new Bundle();
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_map;

    }

    @Override
    protected void initViews() {
        btnmap =byView(R.id.map_btn);
        viewPager = byView(R.id.viewPager);
        tabLayout = byView(R.id.tableLayout);
    }

    @Override
    protected void initDatas() {
       btnmap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context,MapActivity.class);
               startActivity(intent);
           }
       });
        List<Fragment>datas = new ArrayList<>();
        datas.add(new BrokenFragment());
        datas.add(new SectorFragmert());
        datas.add(new ColunmarFragment());
        tabLayout.setupWithViewPager(viewPager);
        vpAdapter = new VPAdapter(getChildFragmentManager(),datas);
        viewPager.setAdapter(vpAdapter);
        for (int i = 0; i < str.length; i++) {
            tabLayout.getTabAt(i).setText(str[i]);
        }
        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);
    }

}
