package com.maqianyu.nicedrama;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.maqianyu.nicedrama.map.MapFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.main_map_rbt:
                        transaction.replace(R.id.frameLayout, MapFragment.newInstance());
                        break;
                    case R.id.main_video_rbt:
                        transaction.replace(R.id.frameLayout, MapFragment.newInstance());
                        break;
                    case R.id.main_my_rbt:
                        transaction.replace(R.id.frameLayout, MapFragment.newInstance());
                        break;
                }
                transaction.commit();
            }
        });
        radioGroup.check(R.id.main_map_rbt);
    }
}
