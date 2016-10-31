package com.maqianyu.nicedrama.Tools;

/**
 * Created by dllo on 16/10/22.
 */
public class Values {
    private Values() {
    }

    /**
     * 新闻网址
     */
    public static final String NEWSURL = "http://c.3g.163.com/recommend/getChanListNews?channel=T" +
            "1457068979049&size=10&offset=0&fn=2&passport=&devId=44t6%2B5mG3ACAOlQOCLuIH" +
            "g%3D%3D&lat=&lon=&version=14.2&net=wifi&ts=1474540981&sign=CSZnTDA7E%2B%2FpWniX0HR" +
            "2j2%2F%2FmXOcKxmUgk8uLzb6ohx48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=wandoujia" +
            "_news&mac=3Fg2bhJMR1xtVeOmVPRkSIe1A3IUPLLdoCiqBVf2Go0%3D";

    /**
     * 剧集详情
     */
    public static final String EPISODEURL = "http://appserver.jnwtv.com:8080/jnwtv-client/movie/getmoviedetail";
    public static final String EPI_KEY1 = "account";
    public static final String EPI_KEY2 = "episodeNo";
    public static final String EPI_KEY3 = "mId";
    public static final String EPI_KEY4 = "token";
    public static final String EPI_KEY5 = "piId";

    public static final String EPI_VALUES1 = "26690576370";
    public static final String EPI_VALUES2 = "1";
//    public static final String EPI_VALUES2_2 = "2";
//    public static final String EPI_VALUES2_3 = "3";
    public static final String EPI_VALUES3 = "1138";
    public static final String EPI_VALUES4 = "2016101715493688672507925614387226690576370";
    public static final String EPI_VALUES5 = "10030";

    /**
     * 剧集简介
     */
    public static final String EPI_JJURL = "http://appserver.jnwtv.com:8080/jnwtv-client/project/getmoreproject";
    public static final String E_JKEY1 = "projectIdList";
    public static final String E_JKEY2 = "account";
    public static final String E_JKEY3 = "token";
    public static final String E_JVALUES1 = "10030%2C10017%2C10003%2C10029%2C10027%2C10006";
    public static final String E_JVALUES2 = "26690576370";
    public static final String E_JVALUES3 = "2016101715493688672507925614387226690576370";


    /**
     * @auther 马迁宇对你说!
     */

    // 快手一级界面接口
    public static final String QUICK_POST_URL = "http://api.gifshow.com/rest/n/feed/list?mod=HUAWEI(HUAWEI%20RIO-AL00)&lon=NaN&country_code=CN&did=ANDROID_8321e8d1b9b162c2&app=0&net=WIFI&oc=HUAWEI&ud=0&c=HUAWEI&sys=ANDROID_5.1&appver=4.51.1.2405&language=zh-cn&lat=NaN&ver=4.51";
    public static final String QUICK_KEY1 = "id";
    public static final String QUICK_VALUE1 = "2";
    public static final String QUICK_KEY2 = "token";
    public static final String QUICK_VALUE2 = "";
    public static final String QUICK_KEY3 = "pv";
    public static final String QUICK_VALUE3 = "false";
    public static final String QUICK_KEY4 = "client_key";
    public static final String QUICK_VALUE4 = "3c2cd3f3";
    public static final String QUICK_KEY5 = "count";
    public static final String QUICK_VALUE5 = "20";
    public static final String QUICK_KEY6 = "page";
    public static final String QUICK_VALUE6 = "1";
    public static final String QUICK_KEY7 = "type";
    public static final String QUICK_VALUE7 = "7";
    public static final String QUICK_KEY8 = "os";
    public static final String QUICK_VALUE8 = "android";
    public static final String QUICK_KEY9 = "sig";
    public static final String QUICK_VALUE9 = "decffcca5ed8febe5390ec5f597e13e7";

    // 快手详情接口
    public static final String QUICK_INFO_KEY1 = "order";
    public static final String QUICK_INFO_VALUE1 = "desc";
    public static final String QUICK_INFO_KEY2 = "token";
    public static final String QUICK_INFO_VALUE2 = "";
    public static final String QUICK_INFO_KEY3 = "client_key";
    public static final String QUICK_INFO_VALUE3 = "3c2cd3f3";
    public static final String QUICK_INFO_KEY4 = "photo_id";
    public static final String QUICK_INFO_VALUE4 = "1184787381";
    public static final String QUICK_INFO_KEY5 = "user_id";
    public static final String QUICK_INFO_VALUE5 = "8348534";
    public static final String QUICK_INFO_KEY6 = "pcursor";
    public static final String QUICK_INFO_VALUE6 = "";
    public static final String QUICK_INFO_KEY7 = "os";
    public static final String QUICK_INFO_VALUE7 = "android";
    public static final String QUICK_INFO_KEY8 = "sig";
    public static final String QUICK_INFO_VALUE8 = "3b2af2e5a17e82b322408c889a665a52";
    //详情接口
    public static final String QUICK_INFO_URL = "http://api.ksapisrv.com/rest/photo/comment/list?lat=38.88336&lon=121.544832&ver=4.51&ud=0&sys=ANDROID_5.1&c=HUAWEI&oc=HUAWEI&net=WIFI&did=ANDROID_8321e8d1b9b162c2&mod=HUAWEI%28HUAWEI+RIO-AL00%29&app=0&language=zh-cn&country_code=CN&appver=4.51.1.2405 ";


    /**
     * 我的   页面的常量
     */
    public static final String baiduUrl = "https://www.baidu.com";//百度网址
    public static final String translateUrl = "http://fanyi.baidu.com/";
    public static final int REQUEST_CODE_SCAN = 0x0000;
    public static final String DECODED_CONTENT_KEY = "codedContent";
    public static final String DECODED_BITMAP_KEY = "codedBitmap";

    /**
     * 下拉刷新的常量
     */
    public static final int RELEASE_TO_REFRESH = 0; // 下拉过程的状态值
    public static final int PULL_TO_REFRESH = 1;  // 从下拉返回到不刷新的状态值
    public static final int REFRESHING = 2;   // 正在刷新的状态值
    public static final int DONE = 3;
    public static final int LOADING = 4;
    public static final int RATIO = 3; // 实际padding的距离与界面上移偏移量的比例

    /**
     * 追剧界面
     */
    public static final String CHASE_URL = "http://appserver.jnwtv.com:8080/jnwtv-client/projectcartoon/getmorelivecartooninfo";
    public static final String CHASE_KEY1 = "sortOrder";
    public static final String CHASE_KEY2 = "account";
    public static final String CHASE_KEY3 = "piId";
    public static final String CHASE_KEY4 = "token";
    public static final String CHASE_KEY5 = "pageNow";
    public static final String CHASE_KEY6 = "upperRange";
    public static final String CHASE_VALUE1 = "desc";
    public static final String CHASE_VALUE2 = "26690576370";
    public static final String CHASE_VALUE3 = "10030";
    public static final String CHASE_VALUE4 = "2016101715493688672507925614387226690576370";
    public static final String CHASE_VALUE5 = "1";
    public static final String CHASE_VALUE6 = "14";
}
