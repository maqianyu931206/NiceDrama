package com.maqianyu.nicedrama.map.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/10/20.
 */
public class ColumaView extends View {

    private int XPoint = 60;
    private int YPoint = 260;
    private int XScale = 8; // 刻度长度
    private int YScale = 40;
    private int XLength = 380;
    private int YLength = 240;

    private int MaxDataSize = XLength / XScale;

    private List<Integer> data = new ArrayList<Integer>();

    private String[] YLabel = new String[YLength / YScale];

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x1234) {
                ColumaView.this.invalidate();
            }
        };
    };

    public ColumaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        for (int i = 0; i < YLabel.length; i++) {
            YLabel[i] = (i + 1) + "M/s";
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (data.size() >= MaxDataSize) {
                        data.remove(0);
                    }
                    data.add(new Random().nextInt(4) + 1);
                    handler.sendEmptyMessage(0x1234);
                }
            }
        }).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true); // 去锯齿
        paint.setColor(Color.BLUE);

        // 画Y轴
        canvas.drawLine(XPoint, YPoint - YLength, XPoint, YPoint, paint);

        // Y轴箭头
        canvas.drawLine(XPoint, YPoint - YLength, XPoint - 3, YPoint - YLength
                + 6, paint); // 箭头
        canvas.drawLine(XPoint, YPoint - YLength, XPoint + 3, YPoint - YLength
                + 6, paint);

        // 添加刻度和文字
        for (int i = 0; i * YScale < YLength; i++) {
            canvas.drawLine(XPoint, YPoint - i * YScale, XPoint + 5, YPoint - i
                    * YScale, paint); // 刻度

            canvas.drawText(YLabel[i], XPoint - 50, YPoint - i * YScale, paint);// 文字
        }

        // 画X轴
        canvas.drawLine(XPoint, YPoint, XPoint + XLength, YPoint, paint);

        // 绘折线
        /*
         * if(data.size() > 1){ for(int i=1; i<data.size(); i++){
         * canvas.drawLine(XPoint + (i-1) * XScale, YPoint - data.get(i-1) *
         * YScale, XPoint + i * XScale, YPoint - data.get(i) * YScale, paint); }
         * }
         */
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);

        Paint paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);
        if (data.size() > 1) {
            Path path = new Path();
            Path path2 = new Path();
            path.moveTo(XPoint, YPoint - data.get(0) * YScale);
            path2.moveTo(XPoint, YPoint);
            for (int i = 0; i < data.size(); i++) {
                path.lineTo(XPoint + i * XScale, YPoint - data.get(i) * YScale);
                path2.lineTo(XPoint + i * XScale, YPoint - data.get(i) * YScale);
            }
            path2.lineTo(XPoint + (data.size() - 1) * XScale, YPoint);
            canvas.drawPath(path, paint);
            canvas.drawPath(path2, paint2);
        }
    }

}
