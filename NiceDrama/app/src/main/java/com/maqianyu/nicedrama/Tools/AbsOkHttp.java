package com.maqianyu.nicedrama.Tools;


import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class AbsOkHttp {

     OkHttpClient mOkHttpClient = new OkHttpClient();
//    protected Request request;
//    protected String url;
//    protected String tag;
//    protected Map<String,String>params;
//    protected Map<String ,String>headers;
//    protected OkHttpRequest(String url,String tag,Map<String,String>params,Map<String,String>headers){
//        this.url = url;
//        this.tag =tag;
//        this.params =params;
//        this.headers = headers;
//    }
//    protected abstract Request buildRequest();
//    protected abstract RequestBody buildRequestBody();


    // 异步请求
    public void daAsynGet(String geturl){
        Request request = new Request.Builder().url(geturl).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


            }
        });
    }
}
