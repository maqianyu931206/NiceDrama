package com.maqianyu.nicedrama.myset.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maqianyu.nicedrama.MainActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.MD5Util;
import com.maqianyu.nicedrama.Tools.ThreadPoolInstance;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.myset.bean.LiteOrmLogInBean;

import java.util.List;

/**
 * Created by dllo on 16/10/28.
 */
public class LogInActivity extends AbsActivity implements View.OnClickListener{
    private EditText nameEt, passwordEt;
    private Button loginBtn;
    private TextView registerTv;
    private ProgressDialog progressDialog;

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

    }

    @Override
    protected void initDatas() {
        loginBtn.setOnClickListener(this);
        registerTv.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        new TitleBuilder(this).setTitle("登陆").setBackImgGone(false).setMoreImg(false);
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
                    Toast.makeText(this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                } else if (names.isEmpty()) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (!names.isEmpty() && psws.isEmpty()) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (!names.isEmpty() && !psws.isEmpty()) {
                    if (LitOrmIntance.getIntance().queryByName(name).size() > 0) {
                        boolean flag1 = LitOrmIntance.getIntance().queryByName(name).get(0).getPassword().equals(password);
                        progressDialog.setMessage("正在登陆中...");
                        progressDialog.show();

                            if (flag1) {
                                String number = LitOrmIntance.getIntance().queryByName(name).get(0).getNumber();
                                LitOrmIntance.getIntance().deleteByName(name);
                                LitOrmIntance.getIntance().insert(new LiteOrmLogInBean(name, password, number, true));
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                        progressDialog.dismiss();
                                        Looper.prepare();
                                        Toast.makeText(LogInActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                                        Intent intent1 = new Intent(LogInActivity.this, MainActivity.class);
                                        intent1.putExtra("id", 1);
                                        intent1.putExtra("name", names);
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
                                            progressDialog.dismiss();
                                            Looper.prepare();
                                            Toast.makeText(LogInActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                                            Looper.loop();

                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();



                        }
                    } else {
                        Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
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
