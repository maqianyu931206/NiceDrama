package com.maqianyu.nicedrama.video.wkvideoplayer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.maqianyu.nicedrama.R;

/**
 * 2048的每个Item
 *
 * @author zhy
 */
public class Game2048Item extends View {
    /**
     * 该View上的数字
     */
    private int mNumber;
    private String mm1;
    private String mmv;
    private String mNumberVal;
    private Paint mPaint;
    private Paint BPaint;
    /**
     * 绘制文字的区域
     */
    private Rect mBound;
    private Bitmap bitmap;

    public Game2048Item(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
        BPaint = new Paint();
        mBound = new Rect();

    }

    public Game2048Item(Context context) {
        this(context, null);
    }

    public Game2048Item(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setNumber(int number) {
        mNumber = number;
        mNumberVal = mNumber + "";
        mPaint.setTextSize(30.0f);

        mPaint.getTextBounds(mNumberVal, 0, mNumberVal.length(), mBound);
        invalidate();
    }

    public int getNumber() {
        return mNumber;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(int id) {
        Canvas canvas = new Canvas();
        float x1 = (getWidth() - mBound.width()) / 4;
        float y1 = getHeight() / 4 + mBound.height() / 4;

        bitmap = BitmapFactory.decodeResource(getResources(), id);
        canvas.drawBitmap(bitmap, x1, y1, BPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int id = 0;
        String mBgColor = "";
        switch (mNumber) {
            case 0:
                mBgColor = "#CCC0B3";
                id = R.mipmap.ic_launcher;
                change(canvas, id);
                break;
            case 2:
                mBgColor = "#EEE4DA";
                id = R.mipmap.yifen;
                change(canvas, id);
                break;
            case 4:
                mBgColor = "#EDE0C8";
                id = R.mipmap.erfen;
                change(canvas, id);
                break;
            case 8:
                mBgColor = "#F2B179";// #F2B179
                id = R.mipmap.wufen;
                change(canvas, id);
                break;
            case 16:
                mBgColor = "#F49563";
                id = R.mipmap.yimao;
                change(canvas, id);
                break;
            case 32:
                mBgColor = "#F5794D";
                id = R.mipmap.ermao;
                change(canvas, id);
                break;
            case 64:
                mBgColor = "#F55D37";
                id = R.mipmap.wumao;
                change(canvas, id);
                break;
            case 128:
                mBgColor = "#EEE863";
                id = R.mipmap.yiyuan;
                change(canvas, id);
                break;
            case 256:
                mBgColor = "#EDB04D";
                id = R.mipmap.eryuan;
                change(canvas, id);
                break;
            case 512:
                mBgColor = "#ECB04D";
                id = R.mipmap.wuyuan;
                change(canvas, id);
                break;
            case 1024:
                mBgColor = "#EB9437";
                id = R.mipmap.shiyuan;
                change(canvas, id);
                break;
            case 2048:
                mBgColor = "#EA7821";
                id = R.mipmap.ershi;
                change(canvas, id);
                break;
            case 4096:
                mBgColor = "#f00000";
                id = R.mipmap.wushi;
                change(canvas, id);
                break;
            case 8192:
                mBgColor = "#f00000";
                id = R.mipmap.yibai;
                change(canvas, id);
                break;

            default:
                mBgColor = "#EA7821";
                break;
        }
        mPaint.setColor(Color.parseColor(mBgColor));
        mPaint.setStyle(Style.FILL);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        if (getNumber() != 0) {
            change(canvas, id);
        }
    }

    private void change(Canvas canvas, int id) {
        float x1 = (getWidth() - mBound.width()) / 4;
        float y1 = getHeight() / 6 + mBound.height() / 2;

        bitmap = BitmapFactory.decodeResource(getResources(), id);
        BPaint.setStyle(Style.FILL_AND_STROKE);
        canvas.drawBitmap(bitmap, -20, y1, BPaint);

//            drawText(canvas);
    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {

        mPaint.setColor(Color.BLACK);
        float x1 = (getWidth() - mBound.width()) / 4;
        float y1 = getHeight() / 4 + mBound.height() / 4;
//        float x = (getWidth() - mBound.width()) / 2;
//        float y = getHeight() / 2 + mBound.height() / 2;
//        canvas.drawText(mNumberVal, x, y, mPaint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Paint mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitPaint.setStyle(Style.FILL);
        canvas.drawBitmap(bitmap, x1, y1, mPaint);
    }

}
