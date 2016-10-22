package com.maqianyu.nicedrama.map.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.maqianyu.nicedrama.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 *@auther 马迁宇对你说!
 */
public class BrokenView extends View {

    private int width;// 宽
    private int height;// 高
    private int spacing;// 纵线间距
    private int leftRightMargin;
    private int topMargin;
    private int bottomMargin;
    private Paint alphaLinePaint;// 半透明画笔
    private Paint linePaint;// 线条画笔
    private Paint textPaint;// 横坐标画笔
    private Paint textEmptyPaint;// 空提示

    private List<String> xValues = new ArrayList<String>();
    private List<String> yValues = new ArrayList<String>();
    private List<Point> points = new ArrayList<Point>();
    private List<Rect> rects = new ArrayList<Rect>();

    // private LineChartPop lineChartPop;

    private String popTitle;

    private Context context;

    /**
     * 设置value的提示标语
     *
     * @param popTitle
     */
    public void setPopTitle(String popTitle) {
        this.popTitle = popTitle;
    }

    public void setData(List<String> xValues, List<String> yValues) {
        this.xValues.clear();
        this.yValues.clear();
        points.clear();
        rects.clear();

        this.xValues.addAll(xValues);
        this.yValues.addAll(yValues);
        for (int i = 0; i < xValues.size(); i++) {
            Point point = new Point();
            points.add(point);

            Rect rect = new Rect();
            rects.add(rect);
        }
        invalidate();
    }

    public BrokenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        alphaLinePaint = new Paint();
        alphaLinePaint.setStyle(Paint.Style.FILL);
        alphaLinePaint.setColor(context.getResources().getColor(
                android.R.color.white));
        alphaLinePaint.setAntiAlias(true);
        alphaLinePaint.setAlpha(150);

        linePaint = new Paint();
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setColor(context.getResources().getColor(android.R.color.holo_blue_dark));
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth((float) 2.0);

        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(context.getResources().getColor(
                android.R.color.holo_green_dark));
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(Tool.dip2px(context, 10));

        textEmptyPaint = new Paint();
        textEmptyPaint.setTextAlign(Paint.Align.CENTER);
        textEmptyPaint.setStyle(Paint.Style.FILL);
        textEmptyPaint.setColor(context.getResources().getColor(android.R.color.holo_orange_light));
        textEmptyPaint.setAntiAlias(true);
        textEmptyPaint.setTextSize(Tool.dip2px(context, 20));

        leftRightMargin = Tool.dip2px(context, 15);
        topMargin = Tool.dip2px(context, 5);
        bottomMargin = Tool.dip2px(context, 20);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        int widthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(height,
                MeasureSpec.EXACTLY);
        setMeasuredDimension(widthSpec, heightSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!xValues.isEmpty() && !yValues.isEmpty()) {
            spacing = (width - 60) / (xValues.size() - 1);
            drawRect(canvas);
            drawHorizontalAxis(canvas);
            drawValues(canvas);
            drawLine(canvas);
        } else {
            canvas.drawText("暂无数据", width / 2, (topMargin + height - bottomMargin) / 2, textEmptyPaint);
        }
    }

    private void drawRect(Canvas canvas) {
        // 画横坐标
        canvas.drawLine(0, topMargin, width, topMargin, alphaLinePaint);
        canvas.drawLine(0, (topMargin + height - bottomMargin) / 2, width,
                (topMargin + height - bottomMargin) / 2, alphaLinePaint);
        canvas.drawLine(0, height - bottomMargin, width, height - bottomMargin,
                alphaLinePaint);
        // 画纵坐标
        for (int i = 0; i < xValues.size(); i++) {
            canvas.drawLine(leftRightMargin + spacing * i, topMargin,
                    leftRightMargin + spacing * i, height - bottomMargin,
                    alphaLinePaint);
        }
    }

    private void drawHorizontalAxis(Canvas canvas) {
        for (int i = 0; i < xValues.size(); i++) {
            canvas.drawText(xValues.get(i), leftRightMargin + spacing * i,
                    height - bottomMargin / 4, textPaint);
        }
    }

    /**
     * 画代表数值的小圆点
     *
     * @param canvas
     */
    private void drawValues(Canvas canvas) {
        List<Float> list = new ArrayList<Float>();
        for (int i = 0; i < yValues.size(); i++) {
            list.add(Float.parseFloat(yValues.get(i)));
        }
        float maxValue = Collections.max(list);
        for (int i = 0; i < yValues.size(); i++) {
            int cx = 30 + spacing * i;
            int cy = 0;
            if (maxValue == 0.0) {
                cy = (int) (height - bottomMargin);
            } else if (Float.parseFloat(yValues.get(i)) < 0) {
                cy = (int) (height - bottomMargin);
            } else {
                cy = (int) (height - (height - topMargin - bottomMargin)
                        / maxValue * Float.parseFloat(yValues.get(i)) - bottomMargin);
            }

            Point point = points.get(i);
            point.x = cx;
            point.y = cy;
            canvas.drawCircle(cx, cy, 5, linePaint);

            Rect rect = rects.get(i);
            rect.left = cx - 20;
            rect.top = cy - 20;
            rect.right = cx + 20;
            rect.bottom = cy + 20;
        }
    }

    /**
     * 画小圆点间的连线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        for (int i = 0; i < yValues.size() - 1; i++) {
            Point pointOne = points.get(i);
            Point pointTwo = points.get(i + 1);
            canvas.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y, linePaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            for (int i = 0; i < rects.size(); i++) {
                Rect rect = rects.get(i);
                if (rect.contains(x, y)) {
                    LineChartPop lineChartPop = new LineChartPop(context);
                    lineChartPop.setText(popTitle, yValues.get(i));
                    if (height - rect.bottom < lineChartPop.getHeight()) {
                        lineChartPop.showAsDropDown(BrokenView.this,
                                (rect.left + rect.right) / 2 - lineChartPop.getWidth() / 2, -height + rect.top - lineChartPop.getHeight());
                    } else {
                        lineChartPop.showAsDropDown(BrokenView.this, (rect.left + rect.right) / 2 - lineChartPop.getWidth() / 2, -height + rect.bottom);
                    }

                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    public class LineChartPop extends PopupWindow {

        private TextView tvValue;
        private TextView tvDesc;

        public LineChartPop(Context context) {
            super(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_chart_valule_pop, null);
            tvValue = (TextView) view.findViewById(R.id.tv_value);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            this.setContentView(view);
            int width = 0;
            if (TextUtils.isEmpty(popTitle)) {
                width = Tool.dip2px(context, 46);
            } else {
                width = (int) Tool.getTextWidth(context, popTitle) + 6;
            }
            this.setWidth(width);
            this.setHeight(Tool.dip2px(context, 30));
            this.setOutsideTouchable(true);
            this.setFocusable(true);
            ColorDrawable dw = new ColorDrawable(0x05600500);
            this.setBackgroundDrawable(dw);
        }

        public void setText(String desc, String textValue) {
            tvDesc.setText(desc);
            tvValue.setText(textValue);
        }
    }
}
