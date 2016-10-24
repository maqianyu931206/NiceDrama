package com.maqianyu.nicedrama.myset;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.AlarmClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.iflytek.sunflower.FlowerCollector;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.TitleBuilder;
import com.maqianyu.nicedrama.myset.speech.setting.IatSettings;
import com.maqianyu.nicedrama.myset.speech.util.ApkInstaller;
import com.maqianyu.nicedrama.myset.speech.util.FucUtil;
import com.maqianyu.nicedrama.myset.speech.util.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by dllo on 16/10/20.
 * 语音听写页面
 *
 * @author 庞美
 */

public class LisAndWriActivity extends AbsActivity implements View.OnClickListener {
    private String TAG = LisAndWriActivity.class.getSimpleName();

    private String[] setAlarmClock = {"闹钟", "设闹钟", "设置闹钟", "定闹钟", "去闹钟页面", "去闹钟界面", "我想定闹钟", "我要定闹钟", "定个闹钟"};
    private String[] call = {"打电话", "拨打电话", "打一个电话","我要打电话","我想打电话","电话","去电话页面", "去拨打电话页面", "打个电话", "电话", "去打电话", "去打个电话", "去拨号"};
    private String[] liulan = {"去浏览器页面", "打开浏览器", "百度", "我想百度一下", "我想搜索东西", "我要搜索东西", "去搜索", "浏览器", "来个百度", "去百度"};


    private RadioGroup group;
    int ret = 0; // 函数调用返回值
    // 语音听写对象
    private SpeechRecognizer mIat;
    // 语音听写UI
    private RecognizerDialog mIatDialog;
    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

    private EditText mResultText;
    private Toast mToast;
    private SharedPreferences mSharedPreferences;
    // 引擎类型
    private String mEngineType = SpeechConstant.TYPE_CLOUD;
    // 语记安装助手类
    ApkInstaller mInstaller;
    private LinearLayout callLl, sendSmsLl, setAlarmLl, searchLl;
    private ListView listView;
    private List<LWListBean>datas;
    private LWListAdapter adapter;

    @SuppressLint("ShowToast")
    @Override
    protected int setLayout() {
        return R.layout.activity_lisandwri;
    }

    @Override
    protected void initViews() {
        group = byView(R.id.radioGroup1);
        mResultText = byView(R.id.iat_text);
        callLl = byView(R.id.lw_call__ll);
        searchLl = byView(R.id.lw_search_ll);
        sendSmsLl = byView(R.id.lw_sendsms_ll);
        setAlarmLl = byView(R.id.lw_set_alarm_ll);
        listView = byView(R.id.info_list);


    }

    @Override
    protected void initDatas() {
        callLl.setOnClickListener(this);
        sendSmsLl.setOnClickListener(this);
        setAlarmLl.setOnClickListener(this);
        searchLl.setOnClickListener(this);
        new TitleBuilder(this).setTitle("语音助手").setBackImgGone(false);



        //  初始化识别无UI识别对象
        // 使用SpeechRecognizer对象，可根据回调消息自定义界面；
        mIat = SpeechRecognizer.createRecognizer(LisAndWriActivity.this, mInitListener);

        // 初始化听写Dialog，如果只使用有UI听写功能，无需创建SpeechRecognizer
        // 使用UI听写功能，请根据sdk文件目录下的notice.txt,放置布局文件和图片资源
        mIatDialog = new RecognizerDialog(LisAndWriActivity.this, mInitListener);

        mSharedPreferences = getSharedPreferences(IatSettings.PREFER_NAME,
                Activity.MODE_PRIVATE);
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        mInstaller = new ApkInstaller(LisAndWriActivity.this);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.iatRadioCloud:
                        mEngineType = SpeechConstant.TYPE_CLOUD;
                        break;
                    case R.id.iatRadioLocal:
                        mEngineType = SpeechConstant.TYPE_LOCAL;
                        /**
                         * 选择本地听写 判断是否安装语记,未安装则跳转到提示安装页面
                         */
                        if (!SpeechUtility.getUtility().checkServiceInstalled()) {
                            mInstaller.install();
                        } else {
                            String result = FucUtil.checkLocalResource();
                            if (!TextUtils.isEmpty(result)) {
                                showTip(result);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        adapter = new LWListAdapter(this);
        datas = new ArrayList<>();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 开始听写
            // 如何判断一次听写结束：OnResult isLast=true 或者 onError
            case R.id.lw_call__ll:
                Toast.makeText(this, "例如:给XXX打电话", Toast.LENGTH_SHORT).show();
                startLw();
                break;
            case   R.id.lw_sendsms_ll:
                Toast.makeText(this, "例如:给XXX发短信说XXX", Toast.LENGTH_SHORT).show();
                startLw();
                break;
            case R.id.lw_set_alarm_ll:
                Toast.makeText(this, "例如:定闹钟", Toast.LENGTH_SHORT).show();
                startLw();
                break;
            case R.id.lw_search_ll:
                Toast.makeText(this, "例如:浏览器", Toast.LENGTH_SHORT).show();
               startLw();
                break;
        }
    }

    private void startLw() {
        Log.d("zzz", "点击开始");
        // 移动数据分析，收集开始听写事件
        FlowerCollector.onEvent(LisAndWriActivity.this, "iat_recognize");

        mResultText.setText(null);// 清空显示内容
        mIatResults.clear();
        // 设置参数
        setParam();
        boolean isShowDialog = mSharedPreferences.getBoolean(
                getString(R.string.pref_key_iat_show), true);
        if (isShowDialog) {
//                     显示听写对话框
            mIatDialog.setListener(mRecognizerDialogListener);
            mIatDialog.show();
            showTip(getString(R.string.text_begin));
        } else {
            // 不显示听写对话框
            ret = mIat.startListening(mRecognizerListener);
            if (ret != ErrorCode.SUCCESS) {
                showTip(getResources().getString(R.string.lwfailed_code) + ret);//听写失败,错误码
            } else {
                showTip(getString(R.string.text_begin));
            }
        }
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            if (code != ErrorCode.SUCCESS) {
                showTip(getResources().getString(R.string.lw_start_fail_code) + code);//初始化失败的错误码
            }
        }
    };

    /**
     * 听写监听器。
     */
    private RecognizerListener mRecognizerListener = new RecognizerListener() {

        @Override
        public void onBeginOfSpeech() {
            // 此回调表示：sdk内部录音机已经准备好了，用户可以开始语音输入
            showTip(getResources().getString(R.string.lw_start_say));//开始说话
        }

        @Override
        public void onError(SpeechError error) {
            // Tips：
            // 错误码：10118(您没有说话)，可能是录音机权限被禁，需要提示用户打开应用的录音权限。
            // 如果使用本地功能（语记）需要提示用户开启语记的录音权限。
            showTip(error.getPlainDescription(true));
        }

        @Override
        public void onEndOfSpeech() {
            // 此回调表示：检测到了语音的尾端点，已经进入识别过程，不再接受语音输入
            showTip(getResources().getString(R.string.lw_end));//结束说话

        }

        @Override
        public void onResult(RecognizerResult results, boolean isLast) {
            printResult(results);

            if (isLast) {
                // TODO 最后的结果
            }
        }

        //getResources().getString(R.string.app_id)
        @Override
        public void onVolumeChanged(int volume, byte[] data) {
            showTip(getResources().getString(R.string.lw_voice_size) + volume);//音量
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}
        }
    };

    private void printResult(RecognizerResult results) {
        String text = JsonParser.parseIatResult(results.getResultString());

        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mIatResults.put(sn, text);

        StringBuffer resultBuffer = new StringBuffer();
        for (String key : mIatResults.keySet()) {
            resultBuffer.append(mIatResults.get(key));
        }

        mResultText.setText(resultBuffer.toString());
        mResultText.setSelection(mResultText.length());
    }

    /**
     * 判断数组中是否含有某一字符串
     *
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }

    /**
     * 听写UI监听器
     */
    private RecognizerDialogListener mRecognizerDialogListener = new RecognizerDialogListener() {
        public void onResult(RecognizerResult results, boolean isLast) {
            printResult(results);
            if (isLast == true){
                goToAtherView();
               datas.clear();
            }

        }

        /**
         * 识别回调错误.
         */
        public void onError(SpeechError error) {
            showTip(error.getPlainDescription(true));
        }

    };

    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
    }

    /**
     * 参数设置
     *
     * @param
     * @return
     */
    public void setParam() {
        // 清空参数
        mIat.setParameter(SpeechConstant.PARAMS, null);

        // 设置听写引擎
        mIat.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
        // 设置返回结果格式
        mIat.setParameter(SpeechConstant.RESULT_TYPE, "json");

        String lag = mSharedPreferences.getString("iat_language_preference",
                "mandarin");
        if (lag.equals("en_us")) {
            // 设置语言
            mIat.setParameter(SpeechConstant.LANGUAGE, "en_us");
        } else {
            // 设置语言
            mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            // 设置语言区域
            mIat.setParameter(SpeechConstant.ACCENT, lag);
        }

        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mIat.setParameter(SpeechConstant.VAD_BOS, mSharedPreferences.getString("iat_vadbos_preference", "4000"));

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mIat.setParameter(SpeechConstant.VAD_EOS, mSharedPreferences.getString("iat_vadeos_preference", "1000"));

        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
        mIat.setParameter(SpeechConstant.ASR_PTT, mSharedPreferences.getString("iat_punc_preference", "1"));

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mIat.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mIat.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/iat.wav");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出时释放连接
        mIat.cancel();
        mIat.destroy();
    }

    @Override
    protected void onResume() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onResume(LisAndWriActivity.this);
        FlowerCollector.onPageStart(TAG);
        super.onResume();
    }

    @Override
    protected void onPause() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onPageEnd(TAG);
        FlowerCollector.onPause(LisAndWriActivity.this);
        super.onPause();
    }
    private void createSmsDialog(final String smsNumber, final String smsBody) {
        Log.d("zzz", "1111");
        new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star)
                .setTitle("是否给" + smsNumber + "发以下内容的短信?").setMessage(smsBody)
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Uri smsToUri = Uri.parse("smsto:" + smsNumber);
                        Intent mIntent = new Intent(Intent.ACTION_SENDTO, smsToUri );
                        mIntent.putExtra("sms_body", smsBody);
                        startActivity(mIntent );
                    }
                })
                .setNeutralButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                }).show();// show很关键
    }
    private void createDialogAN(String what, final String actionSetAlarm) {
        /**
         * 判断关键词是什么
         */
        String title = "";
        if (what.equals(getResources().getString(R.string.lw_alarmclock))) {
            title = getResources().getString(R.string.lw_set_alarmclock);//闹钟
        } else if (what.equals(getResources().getString(R.string.lw_call))) {
            title = getResources().getString(R.string.lw_set_call);//拨号
        } else if (what.equals(getResources().getString(R.string.lw_search))) {
            title = getResources().getString(R.string.lw_set_search);//浏览器
        }
        new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star)
                .setTitle(title)
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(actionSetAlarm);
                        startActivity(intent);
                    }
                })
                .setNeutralButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                }).show();// show很关键
    }
    private void createDialog(final String action, final String number) {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star)
                .setTitle("是否给" + number + "发以下内容的短信?")
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(action, Uri.parse("tel:" + number));
                        startActivity(intent);
                    }
                })
                .setNeutralButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                }).show();// show很关键
    }

    /**
     * 点击跳转到需要的页面
     */
    private void goToAtherView() {
        String str = "";
        if (mResultText != null) {
            if (mResultText.getText().length() > 1) {
                str = mResultText.getText().toString().substring(0, mResultText.getText().toString().length() - 1) + "";//将字符串后面的符号去掉
            }

            /**
             * 闹钟
             */

            boolean clock = useLoop(setAlarmClock, str);
            if (clock == true) {
                createDialogAN("闹钟",AlarmClock.ACTION_SET_ALARM);
            }
            /**
             * 拨打电话
             */
            boolean calling = useLoop(call, str);
            if (calling == true) {
                createDialogAN("拨打电话",Intent.ACTION_CALL_BUTTON);
            }
            /**
             * 打开浏览器
             */
            boolean search = useLoop(liulan, str);
            if (search == true) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(StaticUtil.baiduUrl));
                startActivity(intent);
            }
            if (str.contains("搜索")||str.contains("找")) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                if (str.contains("搜索")&&str.length() >=2) {
                    String search1 = str.substring(2) + "";
                    intent.putExtra(SearchManager.QUERY, search1);
                }
                if (str.contains("找")&&str.length() >=1){
                    String search2 = str.substring(1,str.length());
                    intent.putExtra(SearchManager.QUERY, search2);
                }
                startActivity(intent); //启动浏览器
            }
        }
        String number = "";
        /**
         * 给指定号码打电话
         */
        if (str.contains("给") && str.contains("打电话")) {
//            number = mResultText.getText().toString().substring(1, str.indexOf("打"));
//            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
//            startActivity(intent);
            createDialog(Intent.ACTION_DIAL,number);

        }
        /**
         * 给指定号码发送指定短信
         */
        String smsNumber = "";

        String smsBody = "";

        boolean flag1 = str.contains("发短信");
        boolean flag2 = str.contains("给") && str.contains("发短信");
        boolean flag3 = str.contains("发短信") && str.contains("说");

        boolean flag4 = str.contains("给") && str.contains("发短信") && str.contains("说");
        if (flag2 || flag4) {
            smsNumber = str.substring(1, str.indexOf("发"));
        }
        if (flag4) {
            if (str.substring(str.indexOf("说") + 1).length() > 0) {
                smsBody = str.substring(str.indexOf("说") + 1);
            }
            createSmsDialog(smsNumber,smsBody);

        }
        datas.add(new LWListBean(mResultText.getText().toString()));
        Log.d("vvv", "datas:" + datas);
        listView.setAdapter(adapter);
        adapter.setDatas(datas);
        str = "";
    }

}

