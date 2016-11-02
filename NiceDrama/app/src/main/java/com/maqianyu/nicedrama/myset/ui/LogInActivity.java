package com.maqianyu.nicedrama.myset.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maqianyu.nicedrama.MainActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.MD5Util;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.myset.bean.LiteOrmLogInBean;
import com.maqianyu.nicedrama.myset.load.NewtonCradleLoading;

/**
 * Created by dllo on 16/10/28.
 */
public class LogInActivity extends AbsActivity implements View.OnClickListener {
    private EditText nameEt, passwordEt;
    private Button loginBtn;
    private TextView registerTv;
    private NewtonCradleLoading newtonCradleLoading;
    private Handler handler;

    @Override
    protected int setLayout() {
        return R.layout.activity_log_in;
    }

    @Override
    protected void initViews() {
        nameEt = byView(R.id.signin_name_et);
        passwordEt = byView(R.id.signin_psw_et);
        loginBtn = byView(R.id.signin_login_btn);
        registerTv = byView(R.id.signin_register_tv);
        newtonCradleLoading = byView(R.id.newton_cradle_loading);
    }

    @Override
    protected void initDatas() {
        loginBtn.setOnClickListener(this);
        registerTv.setOnClickListener(this);
        new TitleBuilder(this).setTitle(getResources().getString(R.string.login_login)).setBackImgGone(false).setMoreImg(false);
        newtonCradleLoading.setVisibility(View.INVISIBLE);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                switch (msg.what) {
                    case 0:
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = (float) 1.0; //0.0-1.0
                        getWindow().setAttributes(lp);
                        newtonCradleLoading.stop();
                        newtonCradleLoading.setVisibility(View.INVISIBLE);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin_login_btn:
                final String names = nameEt.getText().toString();
                String psws = passwordEt.getText().toString();
                String name = MD5Util.encrypt(names);
                String password = MD5Util.encrypt(psws);
                if (names.isEmpty() && psws.isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.login_name_psw_p), Toast.LENGTH_SHORT).show();
                } else if (names.isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.login_name_p), Toast.LENGTH_SHORT).show();
                } else if (!names.isEmpty() && psws.isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.login_psw_p), Toast.LENGTH_SHORT).show();
                } else if (!names.isEmpty() && !psws.isEmpty()) {
                    if (LitOrmIntance.getIntance().queryByName(name).size() > 0) {
                        boolean flag1 = LitOrmIntance.getIntance().queryByName(name).get(0).getPassword().equals(password);
                        newtonCradleLoading.setVisibility(View.VISIBLE);
                        newtonCradleLoading.start();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = (float) 0.7; //0.0-1.0
                        getWindow().setAttributes(lp);


                        if (flag1) {
                            String number = LitOrmIntance.getIntance().queryByName(name).get(0).getNumber();
                            LitOrmIntance.getIntance().deleteByName(name);
                            LitOrmIntance.getIntance().insert(new LiteOrmLogInBean(name, password, number, true));
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                        handler.sendEmptyMessage(0);
                                        Looper.prepare();
                                        Toast.makeText(LogInActivity.this, getResources().getString(R.string.login_success), Toast.LENGTH_SHORT).show();

                                        Intent intent1 = new Intent(LogInActivity.this, MainActivity.class);
                                        intent1.putExtra(MainActivity.ID, 1);
                                        intent1.putExtra(MainActivity.NAME, names);
                                        startActivity(intent1);
                                        Looper.loop();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();


                        } else {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                        Looper.prepare();
                                        handler.sendEmptyMessage(0);
                                        Toast.makeText(LogInActivity.this, getResources().getString(R.string.login_error_psw), Toast.LENGTH_SHORT).show();
                                        Looper.loop();

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();


                        }
                    } else {
                        Toast.makeText(this, getResources().getString(R.string.login_erroe_name), Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.signin_register_tv:
                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }


}
