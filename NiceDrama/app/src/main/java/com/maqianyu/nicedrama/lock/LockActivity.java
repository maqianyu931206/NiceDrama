package com.maqianyu.nicedrama.lock;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maqianyu.nicedrama.MainActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;

/**
 * Created by dllo on 16/11/2.
 */
public class LockActivity extends AbsActivity {
    public static final String PARAM_PHONE_NUMBER = "PARAM_PHONE_NUMBER";
    private RelativeLayout mTopLayout;
    private ImageView mImgUserLogo;
    private TextView mTextPhoneNumber;
    private TextView mTextTip;
    private FrameLayout mGestureContainer;
    private GestureContentView mGestureContentView;
    private String mParamPhoneNumber;

    @Override
    protected int setLayout() {
        return R.layout.activity_gesture_verify;
    }

    @Override
    protected void initViews() {
        mParamPhoneNumber = getIntent().getStringExtra(PARAM_PHONE_NUMBER);
        mImgUserLogo = byView(R.id.user_logo);
        mTextPhoneNumber = byView(R.id.text_phone_number);
        mTextTip = byView(R.id.text_tip);
        mGestureContainer = byView(R.id.gesture_container);
    }

    @Override
    protected void initDatas() {
        mGestureContentView = new GestureContentView(this, true, "1235789",
                new GestureDrawline.GestureCallBack() {
                    @Override
                    public void onGestureCodeInput(String inputCode) {
                    }
                    @Override
                    public void checkedSuccess() {
                        mGestureContentView.clearDrawlineState(0L);
                        LockActivity.this.finish();
                        Intent intent = new Intent(LockActivity.this, MainActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void checkedFail() {
                        mGestureContentView.clearDrawlineState(1300L);
                        mTextTip.setVisibility(View.VISIBLE);
                        mTextTip.setText("输入错误");
                        Animation shakeAnimation = AnimationUtils.loadAnimation(LockActivity.this, R.anim.shake);
                        mTextTip.startAnimation(shakeAnimation);
                    }
                });
        mGestureContentView.setParentView(mGestureContainer);
    }


    private String getProtectedMobile(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber) || phoneNumber.length() < 11) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(phoneNumber.subSequence(0, 3));
        builder.append("****");
        builder.append(phoneNumber.subSequence(7, 11));
        return builder.toString();
    }
}

