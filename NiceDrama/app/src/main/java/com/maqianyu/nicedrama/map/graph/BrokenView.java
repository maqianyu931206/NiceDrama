package com.maqianyu.nicedrama.map.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.maqianyu.nicedrama.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/10/20.
 */
public class BrokenView extends View {

    private int bgColor = Color.rgb(Integer.parseInt("4d", 16),
            Integer.parseInt("af", 16), Integer.parseInt("ea", 16));

    private int singleColumnFillColor = Color.rgb(Integer.parseInt("e7", 16),
            Integer.parseInt("e7", 16), Integer.parseInt("e9", 16));

    private int doubleColumnFillColor = Color.rgb(Integer.parseInt("4d", 16),
            Integer.parseInt("af", 16), Integer.parseInt("ea", 16));

    private int fillDownColor = Color.rgb(Integer.parseInt("45", 16),
            Integer.parseInt("64", 16), Integer.parseInt("bf", 16));

    private int xyLineColor = Color.rgb(Integer.parseInt("a9", 16),
            Integer.parseInt("d8", 16), Integer.parseInt("f5", 16));

    private int chartLineColor = Color.WHITE;

    private int shadowLineColor = Color.rgb(Integer.parseInt("1a", 16),
            Integer.parseInt("49", 16), Integer.parseInt("84", 16));

    private String yUnit = "";

    private boolean isDrawY = false;

    private boolean isDrawX = true;

    private boolean isDrawInsideX = true;

    private boolean isDrawInsedeY = false;

    private boolean isFillDown = false;

    private boolean isFillUp = false;

    private boolean isAppendX = true;

    private boolean isDemo = true;

    private int ScreenX;

    private int ScreenY;

    private int numberOfX = 6;

    private int numberOfY = 5;

    private int paddingTop = 30;

    private int paddingLeft = 70;

    private int paddingRight = 30;

    private int paddingDown = 50;

    private int appendXLength = 10;

    private float maxNumber = 0;

    private List<List<Float>> pointList;

    private List<Integer> bitmapList;
    private List<Integer> lineColorList;

    private List<String> titleXList;

    private List<String> titleYList;

    public BrokenView(Context context) {
        super(context);
        demo();

    }

    public BrokenView(Context context, AttributeSet attr) {
        super(context, attr);
        demo();
    }

    private void demo() {
        if (!isDemo) {
            return;
        }
        pointList = new ArrayList<List<Float>>();
        titleXList = new ArrayList<String>();
        lineColorList = new ArrayList<Integer>();
        lineColorList.add(Color.WHITE);
        lineColorList.add(Color.GREEN);
        lineColorList.add(Color.YELLOW);
        for (int i = 0; i < 3; i++) {
            List<Float> pointInList = new ArrayList<Float>();
            for (int j = 0; j < 6; j++) {
                Random r = new Random();
                Float z = r.nextFloat()*100;
                pointInList.add(z);
                titleXList.add("12." + (i + 1) + "1");
            }
            pointList.add(pointInList);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int measuredHeight = measureHeight(heightMeasureSpec);

        int measuredWidth = measureWidth(widthMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);

        ScreenX = measuredWidth;

        ScreenY = measuredHeight;

    }

    private int measureHeight(int measureSpec) {

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int result = 300;
        if (specMode == MeasureSpec.AT_MOST) {

            result = specSize;
        }
        else if (specMode == MeasureSpec.EXACTLY) {

            result = specSize;
        }

        return result;
    }

    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int result = 450;
        if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        }

        else if (specMode == MeasureSpec.EXACTLY) {

            result = specSize;
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        maxNumber = 0;
        List<Point> listX = initNumberOfX();
        List<Point> listY = initNumberOfY();
        canvas.drawColor(bgColor);
        fillColor(listX, canvas);

        Paint paint = new Paint();
        paint.setColor(xyLineColor);
        if (isDrawX) {
            int appendX = 0;
            if (isAppendX) {
                appendX = appendXLength;
            }
            canvas.drawLine(paddingLeft - appendX, paddingTop + listY.get(0).y, listY.get(0).x
                            + paddingLeft,
                    paddingTop + listY.get(0).y, paint);
        }
        if (isDrawY) {
            canvas.drawLine(listX.get(0).x, paddingTop, listX.get(0).x, listX.get(0).y + paddingTop
                    , paint);
        }
        if (isDrawInsedeY) {
            for (Point point : listX) {
                if (!isDrawX) {
                    isDrawX = !isDrawX;
                    continue;
                }
                canvas.drawLine(point.x, paddingTop, point.x, point.y + paddingTop, paint);
            }
        }
        if (isDrawInsideX) {
            for (Point point : listY) {
                if (!isDrawY) {
                    isDrawY = !isDrawY;
                    continue;
                }
                int appendX = 0;
                if (isAppendX) {
                    appendX = appendXLength;
                }
                canvas.drawLine(paddingLeft - appendX, paddingTop + point.y, point.x + paddingLeft,
                        paddingTop + point.y, paint);
            }
        }

        setYTitle(listY, canvas);

        List<List<Point>> positionList = countListPosition(listX);
        drawFill(canvas, positionList);
        drawChart(canvas, positionList);
        drawCicle(canvas, positionList);

        setXTitle(listX, canvas);

    }

    private void drawFill(Canvas canvas, List<List<Point>> positionList) {
        if (!isFillDown) {
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(fillDownColor);
        paint.setAlpha(76);
        for (int i = 0; i < positionList.size(); i++) {
            Path path = new Path();
            path.moveTo(paddingLeft, ScreenY - paddingDown);
            for (int j = 0; j < positionList.get(i).size(); j++) {
                path.lineTo(positionList.get(i).get(j).x, positionList.get(i).get(j).y);
            }
            path.lineTo(ScreenX - paddingRight, ScreenY - paddingDown);
            path.close();
            canvas.drawPath(path, paint);
        }
    }

    private void drawCicle(Canvas canvas, List<List<Point>> positionList) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
        // R.drawable.comm_chart_point);
        int resouceId;
        for (int i = 0; i < positionList.size(); i++) {
            // canvas.drawCircle(positionList.get(i).x, positionList.get(i).y,
            // 7, paint);

            if (bitmapList != null && bitmapList.get(i) != null) {
                resouceId = bitmapList.get(i);
            } else {
                resouceId = R.drawable.comm_chart_point;
            }
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                    resouceId);
            for (int j = 0; j < positionList.get(i).size(); j++) {
                canvas.drawBitmap(bitmap, positionList.get(i).get(j).x + 0.5f - bitmap.getWidth()
                                / 2,
                        positionList.get(i).get(j).y + 0.5f - bitmap.getHeight() / 2, paint);
            }
        }
    }

    private List<List<Point>> countListPosition(List<Point> listX) {
        List<List<Point>> positionList = new ArrayList<List<Point>>();
        if (pointList == null) {
            pointList = new ArrayList<List<Float>>();
            List<Float> pointInList = new ArrayList<Float>();
            for (int i = 0; i < numberOfX; i++) {
                pointInList.add(0f);
            }
            pointList.add(pointInList);
        }
        for (int i = 0; i < pointList.size(); i++) {
            List<Point> positionInList = new ArrayList<Point>();
            for (int j = 0; j < pointList.get(i).size(); j++) {
                Point point = new Point();
                Float z = pointList.get(i).get(j);
                point.x = listX.get(j).x;
                point.y = listX.get(j).y + paddingTop
                        - (int) ((listX.get(j).y) * (float) z / (float) maxNumber);
                positionInList.add(point);
            }
            positionList.add(positionInList);
        }
        return positionList;
    }

    private void drawChart(Canvas canvas, List<List<Point>> positionList) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(chartLineColor);
        paint.setStrokeWidth(3);// ƒ¨»œœﬂøÌŒ™3£¨µΩ ±∫ÚÃ·…˝µΩ»´æ÷±‰¡ø£¨”√”⁄…Ë÷√
        Paint shadowPaint = new Paint();
        shadowPaint.setAntiAlias(true);
        shadowPaint.setColor(shadowLineColor);
        shadowPaint.setStrokeWidth(1);// ƒ¨»œœﬂøÌŒ™3£¨µΩ ±∫ÚÃ·…˝µΩ»´æ÷±‰¡ø£¨”√”⁄…Ë÷√
        shadowPaint.setAlpha(178);
        for (int i = 0; i < positionList.size(); i++) {
            if (lineColorList != null && lineColorList.get(i) != null) {
                paint.setColor(lineColorList.get(i));
            }
            for (int j = 0; j < positionList.get(i).size() - 1; j++) {
                canvas.drawLine(positionList.get(i).get(j).x, positionList.get(i).get(j).y + 2,
                        positionList.get(i).get(j + 1).x, positionList.get(i).get(j + 1).y + 2,
                        shadowPaint);
                canvas.drawLine(positionList.get(i).get(j).x, positionList.get(i).get(j).y,
                        positionList.get(i).get(j + 1).x, positionList.get(i).get(j + 1).y, paint);
            }
        }
    }

    private void fillColor(List<Point> listX, Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < numberOfX - 1; i++) {
            if (i % 2 == 0) {
                paint.setColor(singleColumnFillColor);
                paint.setAlpha(102);
            } else {
                paint.setColor(doubleColumnFillColor);
                paint.setAlpha(255);
            }
            canvas.drawRect(listX.get(i).x, paddingTop, listX.get(i + 1).x, ScreenY - paddingDown,
                    paint);
        }
    }

    private void setYTitle(List<Point> listY, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        if (pointList == null) {
            titleYList = new ArrayList<String>();
            for (int i = 1; i <= numberOfY; i++) {
                titleYList.add(String.valueOf(100 / i));
            }
        } else {
            for (int i = 0; i < pointList.size(); i++) {
                for (int j = 0; j < pointList.get(i).size(); j++) {

                    if (pointList.get(i).get(j) > maxNumber) {
                        maxNumber = pointList.get(i).get(j);
                    }
                }
            }
            maxNumber = maxNumber + maxNumber / 3;
            titleYList = new ArrayList<String>();
            for (int i = 0; i < numberOfY; i++) {
                titleYList.add(String.valueOf((int) (0 + i * (maxNumber / (numberOfY - 1)))));
            }
        }
        for (int i = 0; i < numberOfY; i++) {
            int appendX = 0;
            if (isAppendX) {
                appendX = appendXLength;
            }
            if (i != 0) {
                canvas.drawText(titleYList.get(i), paddingLeft - appendX - paddingLeft / 3,
                        paddingTop
                                + listY.get(i).y, paint);
            } else {
                canvas.drawText(titleYList.get(i) + yUnit,
                        paddingLeft - appendX - paddingLeft / 3, paddingTop
                                + listY.get(i).y, paint);
            }
        }
    }

    private void setXTitle(List<Point> listX, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        if (titleXList == null) {
            titleXList = new ArrayList<String>();
            for (int i = 1; i <= numberOfX; i++) {
                titleXList.add("title" + i);
            }
        }
        for (int i = 0; i < numberOfX; i++) {
            canvas.save();
            canvas.rotate(30, listX.get(i).x,
                    listX.get(i).y + paddingTop + paddingDown / 2);
            canvas.drawText(titleXList.get(i), listX.get(i).x,
                    listX.get(i).y + paddingTop + paddingDown / 2
                    , paint);
            canvas.restore();
        }
    }

    private List<Point> initNumberOfX() {
        int num = (ScreenX - paddingLeft - paddingRight) / (numberOfX - 1);
        List<Point> list = new ArrayList<Point>();
        for (int i = 0; i < numberOfX; i++) {
            Point point = new Point();
            point.y = ScreenY - paddingDown - paddingTop;
            point.x = paddingLeft + num * i;
            list.add(point);
        }
        return list;
    }

    private List<Point> initNumberOfY() {
        int num = (ScreenY - paddingDown - paddingTop) / (numberOfY - 1);
        List<Point> list = new ArrayList<Point>();
        for (int i = 0; i < numberOfY; i++) {
            Point point = new Point();
            point.x = ScreenX - paddingLeft - paddingRight;
            point.y = ScreenY - paddingDown - paddingTop - num * i;
            list.add(point);
        }
        return list;
    }

    public boolean isDrawY() {
        return isDrawY;
    }

    public void setDrawY(boolean isDrawY) {
        this.isDrawY = isDrawY;
    }

    public boolean isDrawX() {
        return isDrawX;
    }

    public void setDrawX(boolean isDrawX) {
        this.isDrawX = isDrawX;
    }

    public boolean isFillDown() {
        return isFillDown;
    }

    public void setFillDown(boolean isFillDown) {
        this.isFillDown = isFillDown;
    }

    public boolean isFillUp() {
        return isFillUp;
    }

    public void setFillUp(boolean isFillUp) {
        this.isFillUp = isFillUp;
    }

    public int getScreenX() {
        return ScreenX;
    }

    public void setScreenX(int screenX) {
        ScreenX = screenX;
    }

    public int getScreenY() {
        return ScreenY;
    }

    public void setScreenY(int screenY) {
        ScreenY = screenY;
    }

    public int getNumberOfX() {
        return numberOfX;
    }

    public void setNumberOfX(int numberOfX) {
        this.numberOfX = numberOfX;
    }

    public int getNumberOfY() {
        return numberOfY;
    }

    public void setNumberOfY(int numberOfY) {
        this.numberOfY = numberOfY;
    }

    public boolean isDrawInsideX() {
        return isDrawInsideX;
    }

    public void setDrawInsideX(boolean isDrawInsideX) {
        this.isDrawInsideX = isDrawInsideX;
    }

    public boolean isDrawInsedeY() {
        return isDrawInsedeY;
    }

    public void setDrawInsedeY(boolean isDrawInsedeY) {
        this.isDrawInsedeY = isDrawInsedeY;
    }

    public boolean isAppendX() {
        return isAppendX;
    }

    public void setAppendX(boolean isAppendX) {
        this.isAppendX = isAppendX;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public int getPaddingDown() {
        return paddingDown;
    }

    public void setPaddingDown(int paddingDown) {
        this.paddingDown = paddingDown;
    }

    public int getAppendXLength() {
        return appendXLength;
    }

    public void setAppendXLength(int appendXLength) {
        this.appendXLength = appendXLength;
    }

    public float getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(float maxNumber) {
        this.maxNumber = maxNumber;
    }

    public List<String> getTitleXList() {
        return titleXList;
    }

    public void setTitleXList(List<String> titleXList) {
        this.titleXList = titleXList;
    }

    public List<String> getTitleYList() {
        return titleYList;
    }

    public void setTitleYList(List<String> titleYList) {
        this.titleYList = titleYList;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getSingleColumnFillColor() {
        return singleColumnFillColor;
    }

    public void setSingleColumnFillColor(int singleColumnFillColor) {
        this.singleColumnFillColor = singleColumnFillColor;
    }

    public int getDoubleColumnFillColor() {
        return doubleColumnFillColor;
    }

    public void setDoubleColumnFillColor(int doubleColumnFillColor) {
        this.doubleColumnFillColor = doubleColumnFillColor;
    }

    public int getFillDownColor() {
        return fillDownColor;
    }

    public void setFillDownColor(int fillDownColor) {
        this.fillDownColor = fillDownColor;
    }

    public int getXyLineColor() {
        return xyLineColor;
    }

    public void setXyLineColor(int xyLineColor) {
        this.xyLineColor = xyLineColor;
    }

    public int getShadowLineColor() {
        return shadowLineColor;
    }

    public void setShadowLineColor(int shadowLineColor) {
        this.shadowLineColor = shadowLineColor;
    }

    public int getChartLineColor() {
        return chartLineColor;
    }

    public void setChartLineColor(int chartLineColor) {
        this.chartLineColor = chartLineColor;
    }

    public String getyUnit() {
        return yUnit;
    }

    public void setyUnit(String yUnit) {
        this.yUnit = yUnit;
    }

    public List<List<Float>> getPointList() {
        return pointList;
    }

    public void setPointList(List<List<Float>> pointList) {
        this.pointList = pointList;
    }

    public List<Integer> getBitmapList() {
        return bitmapList;
    }

    public void setBitmapList(List<Integer> bitmapList) {
        this.bitmapList = bitmapList;
    }

    public List<Integer> getLineColorList() {
        return lineColorList;
    }

    public void setLineColorList(List<Integer> lineColorList) {
        this.lineColorList = lineColorList;
    }
}
