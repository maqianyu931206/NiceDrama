package com.maqianyu.nicedrama.myset.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.MD5Util;
import com.maqianyu.nicedrama.Tools.PhoneNumberUtil;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.myset.bean.LiteOrmLogInBean;

import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by dllo on 16/10/29.
 */
public class RegisterActivity extends AbsActivity implements View.OnClickListener {
    private EditText nameEt, pswEt, phoneEt, rePswEt;
    private TextView registerTv, registerYesTv, getCodeTv;
    private static final int CODE_ING = 1;   //已发送，倒计时
    private static final int CODE_REPEAT = 2;  //重新发送
    private static final int SMSDDK_HANDLER = 3;  //短信回调
    private int TIME = 60;//倒计时60s
    private String userPhone;//手机号码
    private EditText smsCodeEt;//验证码
    private String name;//昵称(加密)
    private String password;//密码(加密)
    private String names;//昵称

    @Override
    protected int setLayout() {
        return R.layout.activity_password_log_in;
    }

    @Override
    protected void initViews() {
        nameEt = byView(R.id.login_name_et);
        pswEt = byView(R.id.login_psw_et);
        registerTv = byView(R.id.register_tv);
        phoneEt = byView(R.id.user_phone_input);
        getCodeTv = byView(R.id.get_code_btn);
        smsCodeEt = byView(R.id.sms_code_et);
        registerYesTv = byView(R.id.register_status);
        rePswEt = byView(R.id.login_re_psw_et);


    }

    @Override
    protected void initDatas() {
        registerYesTv.setOnClickListener(this);
        getCodeTv.setOnClickListener(this);
        registerTv.setOnClickListener(this);
        new TitleBuilder(this).setTitle(getResources().getString(R.string.register_register)).setBackImgGone(false).setMoreImg(false);
        initSDK();

    }

    //    //初始化SDK
    private void initSDK() {
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                msg.what = SMSDDK_HANDLER;
                handler.sendMessage(msg);
            }
        };
        //注册监听回调接口
        SMSSDK.registerEventHandler(eventHandler);
//
    }

    @Override
    public void onClick(View v) {
        userPhone = phoneEt.getText().toString();
        switch (v.getId()) {
            case R.id.get_code_btn://获取验证码
                /**
                 * 在数据库中查询是否有该手机号,如果有,提示该手机号码已注册
                 */
                if (LitOrmIntance.getIntance().queryByNumber(MD5Util.encrypt(userPhone)).size() > 0) {
                    Toast.makeText(this, getResources().getString(R.string.register_phone_ed), Toast.LENGTH_SHORT).show();
                } else {
                    /**
                     * 当输入的手机号码不是11位或不是以1开头的,提示手机号码错误,
                     * 否则就弹出Dialog确认是否发送短信,
                     * 发送短信后,需要倒计时60秒后才能再次发送短信,在倒计时过程中,发送短信按钮不可再次点击
                     */
                    names = nameEt.getText().toString();
                    String psws = pswEt.getText().toString();
                    String rePsws = rePswEt.getText().toString();
                    password = MD5Util.encrypt(psws);
                    name = MD5Util.encrypt(names);
                    if (names.isEmpty()) {
                        Toast.makeText(this, getResources().getString(R.string.register_name_p), Toast.LENGTH_SHORT).show();
                    } else if (LitOrmIntance.getIntance().queryByName(name).size() != 0) {
                        Toast.makeText(this, getResources().getString(R.string.register_name_again), Toast.LENGTH_SHORT).show();
                    } else if (!psws.equals(rePsws)) {
                        Toast.makeText(this, getResources().getString(R.string.register_phone_dis_p), Toast.LENGTH_SHORT).show();
                    } else if (psws.isEmpty() && rePsws.isEmpty()) {
                        Toast.makeText(this, getResources().getString(R.string.login_psw_p), Toast.LENGTH_SHORT).show();
                    } else if (!PhoneNumberUtil.isPhoneNum(userPhone)) {
                        Toast.makeText(this, getResources().getString(R.string.register_error_phine), Toast.LENGTH_SHORT).show();
                    } else {
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle(getResources().getString(R.string.register_send_msg))
                                .setMessage(getResources().getString(R.string.register_send_phone) + "\n" + "+86:" + userPhone)
                                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SMSSDK.getVerificationCode("86", userPhone);
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                for (int i = 60; i > 0; i--) {
                                                    handler.sendEmptyMessage(CODE_ING);
                                                    if (i <= 0) {
                                                        break;
                                                    }
                                                    try {
                                                        Thread.sleep(1000);
                                                    } catch (InterruptedException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                                handler.sendEmptyMessage(CODE_REPEAT);
                                            }
                                        }).start();
                                    }
                                }).setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                                .create()
                                .show();
                    }
                }
                break;

            case R.id.register_tv://注册
                searchSQ();
                break;
            default:
                break;
        }

    }

    private void searchSQ() {
        names = nameEt.getText().toString();
        String psws = pswEt.getText().toString();
        String rePsws = rePswEt.getText().toString();
        password = MD5Util.encrypt(psws);
        String passwwods = MD5Util.encrypt(rePsws);
        name = MD5Util.encrypt(names);

        /**
         * 当两次输入的密码相同且不为空,并且昵称不为空的时候,根据名字查询数据库,
         * 如果数据库里没有该昵称,对验证码进行验证,
         * 当没有昵称时,提示请输入昵称,
         * 当两次密码不一致,提示密码输入不一致,请重新输入,
         * 当密码为空时,提示请输入密码
         *
         */

        if (psws.equals(rePsws) && !psws.isEmpty() && !names.isEmpty()) {
            if (LitOrmIntance.getIntance().queryByName(name).size() != 0) {
                Toast.makeText(this, getResources().getString(R.string.register_name_again), Toast.LENGTH_SHORT).show();

            } else {
                SMSSDK.submitVerificationCode("86", userPhone, smsCodeEt.getText().toString());//对验证码进行验证->回调函数
            }
        } else if (names.isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.register_name_p), Toast.LENGTH_SHORT).show();
        } else if (LitOrmIntance.getIntance().queryByName(name).size() != 0) {
            Toast.makeText(this, getResources().getString(R.string.register_name_again), Toast.LENGTH_SHORT).show();
        } else if (!psws.equals(rePsws)) {
            Toast.makeText(this, getResources().getString(R.string.register_phone_dis_p), Toast.LENGTH_SHORT).show();
        } else if (psws.isEmpty() && rePsws.isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.login_psw_p), Toast.LENGTH_SHORT).show();
        }
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CODE_ING://已发送,倒计时
                    getCodeTv.setText("重新发送(" + --TIME + "s)");
                    getCodeTv.setEnabled(false);
                    getCodeTv.setClickable(false);
                    break;
                case CODE_REPEAT://重新发送
                    getCodeTv.setEnabled(true);
                    getCodeTv.setText(getResources().getString(R.string.register_get_code));
                    getCodeTv.setClickable(true);
                    break;
                case SMSDDK_HANDLER:
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    //回调完成
                    if (result == SMSSDK.RESULT_COMPLETE) {
                        //验证码验证成功
                        if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                            boolean type = false;
                            Toast.makeText(RegisterActivity.this, getResources().getString(R.string.reister_yanzheng_sus), Toast.LENGTH_LONG).show();
                            String userPhones = MD5Util.encrypt(userPhone);
                            LitOrmIntance.getIntance().insert(new LiteOrmLogInBean(name, password, userPhones, type));
                            Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                            intent.putExtra("userPhone", userPhone);
                            startActivity(intent);
                            finish();
                        }
                        //已发送验证码
                        else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.register_code_sended), Toast.LENGTH_SHORT).show();
                        } else {
                            ((Throwable) data).printStackTrace();
                        }
                    }
                    if (result == SMSSDK.RESULT_ERROR) {
                        try {
                            Throwable throwable = (Throwable) data;
                            throwable.printStackTrace();
                            JSONObject object = new JSONObject(throwable.getMessage());
                            String des = object.optString("detail");//错误描述
                            int status = object.optInt("status");//错误代码
                            if (status > 0 && !TextUtils.isEmpty(des)) {
                                Toast.makeText(getApplicationContext(), des, Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
            }
        }
    };
}
