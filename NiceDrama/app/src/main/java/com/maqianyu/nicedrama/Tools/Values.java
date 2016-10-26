package com.maqianyu.nicedrama.Tools;

/**
 * Created by dllo on 16/10/22.
 */
public class Values {
    private Values(){}

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
}
