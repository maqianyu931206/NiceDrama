package com.maqianyu.nicedrama.map.graph;

import java.util.List;

/**
 * Created by dllo on 16/10/27.
 */
public class BrokenBean {

    private String reason;



    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * realtime : {"city_code":"101210701","city_name":"温州","date":"2016-10-28","time":"08:00:00","week":5,"moon":"九月廿八","dataUptime":1477615027,"weather":{"temperature":"24","humidity":"96","info":"多云","img":"1"},"wind":{"direct":"北风","power":"0级","offset":null,"windspeed":null}}
         * life : {"date":"2016-10-28","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行各种健身休闲运动，若坚持户外运动，须注意保暖并携带雨具。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]}}
         * weather : [{"date":"2016-10-28","info":{"day":["3","阵雨","31","东北风","微风","06:06"],"night":["3","阵雨","19","东北风","微风","17:16"]},"week":"五","nongli":"九月廿八"},{"date":"2016-10-29","info":{"dawn":["3","阵雨","19","东北风","微风","17:16"],"day":["3","阵雨","23","东北风","微风","06:06"],"night":["2","阴","18","东北风","微风","17:15"]},"week":"六","nongli":"九月廿九"},{"date":"2016-10-30","info":{"dawn":["2","阴","18","东北风","微风","17:15"],"day":["1","多云","21","东北风","微风","06:07"],"night":["1","多云","17","东北风","微风","17:14"]},"week":"日","nongli":"九月三十"},{"date":"2016-10-31","info":{"dawn":["1","多云","17","东北风","微风","17:14"],"day":["1","多云","24","东北风","微风","06:08"],"night":["2","阴","16","东北风","微风","17:13"]},"week":"一","nongli":"十月初一"},{"date":"2016-11-01","info":{"dawn":["2","阴","16","东北风","微风","17:13"],"day":["1","多云","19","东北风","微风","06:08"],"night":["1","多云","13","东北风","微风","17:13"]},"week":"二","nongli":"十月初二"}]
         * f3h : {"temperature":[{"jg":"20161028080000","jb":"24"},{"jg":"20161028110000","jb":"28"},{"jg":"20161028140000","jb":"27"},{"jg":"20161028170000","jb":"24"},{"jg":"20161028200000","jb":"22"},{"jg":"20161028230000","jb":"20"},{"jg":"20161029020000","jb":"19"},{"jg":"20161029050000","jb":"19"},{"jg":"20161029080000","jb":"19"}],"precipitation":[{"jg":"20161028080000","jf":"0"},{"jg":"20161028110000","jf":"0"},{"jg":"20161028140000","jf":"0.1"},{"jg":"20161028170000","jf":"0.4"},{"jg":"20161028200000","jf":"0.4"},{"jg":"20161028230000","jf":"1.2"},{"jg":"20161029020000","jf":"1.5"},{"jg":"20161029050000","jf":"0.7"},{"jg":"20161029080000","jf":"0.1"}]}
         * pm25 : {"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"82","pm25":"55","pm10":"111","level":2,"quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"},"dateTime":"2016年10月28日08时","cityName":"温州"}
         * jingqu :
         * jingqutq :
         * date :
         * isForeign : 0
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * city_code : 101210701
             * city_name : 温州
             * date : 2016-10-28
             * time : 08:00:00
             * week : 5
             * moon : 九月廿八
             * dataUptime : 1477615027
             * weather : {"temperature":"24","humidity":"96","info":"多云","img":"1"}
             * wind : {"direct":"北风","power":"0级","offset":null,"windspeed":null}
             */

            private RealtimeBean realtime;
            /**
             * date : 2016-10-28
             * info : {"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行各种健身休闲运动，若坚持户外运动，须注意保暖并携带雨具。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]}
             */

            private LifeBean life;
            private F3hBean f3h;
            /**
             * key : Wenzhou
             * show_desc : 0
             * pm25 : {"curPm":"82","pm25":"55","pm10":"111","level":2,"quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"}
             * dateTime : 2016年10月28日08时
             * cityName : 温州
             */

            private Pm25Bean pm25;
            private String jingqu;
            private String jingqutq;
            private String date;
            private String isForeign;
            /**
             * date : 2016-10-28
             * info : {"day":["3","阵雨","31","东北风","微风","06:06"],"night":["3","阵雨","19","东北风","微风","17:16"]}
             * week : 五
             * nongli : 九月廿八
             */

            private List<WeatherBean> weather;

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public F3hBean getF3h() {
                return f3h;
            }

            public void setF3h(F3hBean f3h) {
                this.f3h = f3h;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getJingqu() {
                return jingqu;
            }

            public void setJingqu(String jingqu) {
                this.jingqu = jingqu;
            }

            public String getJingqutq() {
                return jingqutq;
            }

            public void setJingqutq(String jingqutq) {
                this.jingqutq = jingqutq;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }

            public List<WeatherBean> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBean> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean {
                private String city_code;
                private String city_name;
                private String date;
                private String time;
                private int week;
                private String moon;
                private int dataUptime;
                /**
                 * temperature : 24
                 * humidity : 96
                 * info : 多云
                 * img : 1
                 */

                private WeatherBean weather;
                /**
                 * direct : 北风
                 * power : 0级
                 * offset : null
                 * windspeed : null
                 */

                private WindBean wind;

                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public static class WeatherBean {
                    private String temperature;
                    private String humidity;
                    private String info;
                    private String img;

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }

                public static class WindBean {
                    private String direct;
                    private String power;
                    private Object offset;
                    private Object windspeed;

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public Object getOffset() {
                        return offset;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }

                    public Object getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(Object windspeed) {
                        this.windspeed = windspeed;
                    }
                }
            }

            public static class LifeBean {
                private String date;
                private InfoBean info;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> chuanyi;
                    private List<String> ganmao;
                    private List<String> kongtiao;
                    private List<String> xiche;
                    private List<String> yundong;
                    private List<String> ziwaixian;

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }
                }
            }

            public static class F3hBean {
                /**
                 * jg : 20161028080000
                 * jb : 24
                 */

                private List<TemperatureBean> temperature;
                /**
                 * jg : 20161028080000
                 * jf : 0
                 */

                private List<PrecipitationBean> precipitation;

                public List<TemperatureBean> getTemperature() {
                    return temperature;
                }

                public void setTemperature(List<TemperatureBean> temperature) {
                    this.temperature = temperature;
                }

                public List<PrecipitationBean> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<PrecipitationBean> precipitation) {
                    this.precipitation = precipitation;
                }

                public static class TemperatureBean {
                    private String jg;
                    private String jb;

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJb() {
                        return jb;
                    }

                    public void setJb(String jb) {
                        this.jb = jb;
                    }
                }

                public static class PrecipitationBean {
                    private String jg;
                    private String jf;

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJf() {
                        return jf;
                    }

                    public void setJf(String jf) {
                        this.jf = jf;
                    }
                }
            }

            public static class Pm25Bean {
                private String key;
                private int show_desc;
                /**
                 * curPm : 82
                 * pm25 : 55
                 * pm10 : 111
                 * level : 2
                 * quality : 良
                 * des : 可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。
                 */

                private mPm25Bean pm25;
                private String dateTime;
                private String cityName;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public mPm25Bean getPm25() {
                    return pm25;
                }

                public void setPm25(mPm25Bean pm25) {
                    this.pm25 = pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public static class mPm25Bean {
                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }
                }
            }

            public static class WeatherBean {
                private String date;
                private InfoBean info;
                private String week;
                private String nongli;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBean {
                    private List<String> day;
                    private List<String> night;

                    public List<String> getDay() {
                        return day;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }
                }
            }
        }
    }
}
