package com.maqianyu.nicedrama.video.wkvideoplayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by dllo on 16/10/26.
 * 自定义View标签
 */
public class EudemonTextView extends TextView {

    private Paint paint;

    public EudemonTextView(Context context) {
        super(context);
    }

    public EudemonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.rgb(231,65,27));
        Rect rect3 = new Rect(-100, 35, 120, 65);
//        //设置画笔的填充方式
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.rotate(-45);
        canvas.drawRect(rect3, paint);
//        canvas.restore();
        Path path = new Path();
        path.moveTo(10, 55);
        path.lineTo(55, 10);
        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setTextSize(15);
        canvas.drawTextOnPath("守护神",path,10,10,paint1);
    }
}
