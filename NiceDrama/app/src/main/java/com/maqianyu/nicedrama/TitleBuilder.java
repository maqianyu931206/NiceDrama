package com.maqianyu.nicedrama;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by dllo on 16/10/22.
 */
public class TitleBuilder {
    ImageView imgback;
    TextView title;
    ImageView moreimg;
    RelativeLayout relativeLayout;

    public TitleBuilder(Activity context){
        imgback = (ImageView) context.findViewById(R.id.include_back);
        title = (TextView) context.findViewById(R.id.include_title);
        moreimg = (ImageView) context.findViewById(R.id.includer_more_img);
        relativeLayout = (RelativeLayout) context.findViewById(R.id.relativeLayout);
    }
    public TitleBuilder setTitle(String str){
        title.setText(str);
        return this;
    }
    public TitleBuilder setBackImg(View.OnClickListener listener){
        imgback.setOnClickListener(listener);
        return this;
    }

    public TitleBuilder setMoreImg(View.OnClickListener listener){
        moreimg.setOnClickListener(listener);
        return this;
    }
    public TitleBuilder setViewColor(int color){
        relativeLayout.setBackgroundColor(color);
        return this;
    }
    public TitleBuilder setBackImgGone(Boolean is){
        if (is == true) {
            imgback.setVisibility(View.GONE);
        }else {
            imgback.setVisibility(View.VISIBLE);
        }
        return this;
    }
}
