package com.maqianyu.nicedrama.map.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

import com.maqianyu.nicedrama.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/10/20.
 */
public class ColumaView extends View {

    private List<Double> numbers;
    private List<Point> points;
    private double total;
    private RectF normalOval;
    private RectF selectOval;

    private Paint paint;
    private Context context;

    public static final int[] colors = { android.R.color.holo_blue_light,
            android.R.color.holo_green_light, android.R.color.holo_red_light,
            android.R.color.holo_orange_light, android.R.color.holo_purple ,
            android.R.color.holo_green_light, R.color.statusColor};
    public ColumaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        numbers = new ArrayList<Double>();

        normalOval = new RectF();
        selectOval = new RectF();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.AT_MOST) {
            width = 800;
            height = 800;
        }
        setMeasuredDimension(width, height);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        normalOval.left = (float) (getMeasuredWidth() * 0.1);
        normalOval.top = (float) (getMeasuredHeight() * 0.1);
        normalOval.right = (float) (getMeasuredWidth() * 0.9);
        normalOval.bottom = (float) (getMeasuredHeight() * 0.9);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!numbers.isEmpty()) {
            int startAngle = 0;
            int sweepAngle = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (i == numbers.size() - 1) {
                    sweepAngle = 360 - startAngle;
                } else {
                    sweepAngle = (int) (numbers.get(i) * 1.0f / total * 360);
                }
                if (select >= 0 && i == select) {
                    selectOval.left = (float) (getMeasuredWidth() * 0.1);
                    selectOval.top = (float) (getMeasuredHeight() * 0.1);
                    selectOval.right = (float) (getMeasuredWidth() * 0.9);
                    selectOval.bottom = (float) (getMeasuredHeight() * 0.9);
                    Point point = points.get(select);
                    int middle = (point.x + point.y) / 2;
                    if (middle <= 90) {
                        int top = (int) (Math.sin(Math.toRadians(middle)) * 15);
                        int left = (int) (Math.cos(Math.toRadians(middle)) * 15);
                        selectOval.left += left;
                        selectOval.right += left;
                        selectOval.top += top;
                        selectOval.bottom += top;
                    }
                    if (middle > 90 && middle <= 180) {
                        middle = 180 - middle;
                        int top = (int) (Math.sin(Math.toRadians(middle)) * 15);
                        int left = (int) (Math.cos(Math.toRadians(middle)) * 15);
                        selectOval.left -= left;
                        selectOval.right -= left;
                        selectOval.top += top;
                        selectOval.bottom += top;
                    }
                    if (middle > 180 && middle <= 270) {
                        middle = 270 - middle;
                        int left = (int) (Math.sin(Math.toRadians(middle)) * 15);
                        int top = (int) (Math.cos(Math.toRadians(middle)) * 15);
                        selectOval.left -= left;
                        selectOval.right -= left;
                        selectOval.top -= top;
                        selectOval.bottom -= top;
                    }
                    if (middle > 270 && middle <= 360) {
                        middle = 360 - middle;
                        int top = (int) (Math.sin(Math.toRadians(middle)) * 15);
                        int left = (int) (Math.cos(Math.toRadians(middle)) * 15);
                        selectOval.left += left;
                        selectOval.right += left;
                        selectOval.top -= top;
                        selectOval.bottom -= top;
                    }
                    paint.setColor(getResources().getColor(colors[i]));
                    canvas.drawArc(selectOval, startAngle, sweepAngle, true, paint);
                } else {
                    paint.setColor(getResources().getColor(colors[i]));
                    canvas.drawArc(normalOval, startAngle, sweepAngle, true, paint);
                }
                points.get(i).x = startAngle;
                points.get(i).y = startAngle + sweepAngle;
                startAngle += sweepAngle;
            }
        }
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers.clear();
        this.numbers.addAll(numbers);
        points = new ArrayList<Point>();
        for (Double item : numbers) {
            total += item;
            Point point = new Point();
            points.add(point);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
            int radius = 0;
            // 第一象限
            if (x >= getMeasuredWidth() / 2 && y >= getMeasuredHeight() / 2) {
                radius = (int) (Math.atan((y - getMeasuredHeight() / 2) * 1.0f
                        / (x - getMeasuredWidth() / 2)) * 180 / Math.PI);
            }
            // 第二象限
            if (x <= getMeasuredWidth() / 2 && y >= getMeasuredHeight() / 2) {
                radius = (int) (Math.atan((getMeasuredWidth() / 2 - x)
                        / (y - getMeasuredHeight() / 2))
                        * 180 / Math.PI + 90);
            }
            // 第三象限
            if (x <= getMeasuredWidth() / 2 && y <= getMeasuredHeight() / 2) {
                radius = (int) (Math.atan((getMeasuredHeight() / 2 - y)
                        / (getMeasuredWidth() / 2 - x))
                        * 180 / Math.PI + 180);
            }
            // 第四象限
            if (x >= getMeasuredWidth() / 2 && y <= getMeasuredHeight() / 2) {
                radius = (int) (Math.atan((x - getMeasuredWidth() / 2)
                        / (getMeasuredHeight() / 2 - y))
                        * 180 / Math.PI + 270);
            }
            for (int i = 0; i < points.size(); i++) {
                Point point = points.get(i);
                if (point.x <= radius && point.y >= radius) {
                    select = i;
                    invalidate();
                    return true;
                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    private int select = -1;
}
