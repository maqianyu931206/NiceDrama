package com.maqianyu.nicedrama.map.quickhead;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/22.
 */
public class QuickHeadBean {

    private int result;
    private String pcursor;
    private int new_notify;
    private String llsid;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getPcursor() {
        return pcursor;
    }

    public void setPcursor(String pcursor) {
        this.pcursor = pcursor;
    }

    public int getNew_notify() {
        return new_notify;
    }

    public void setNew_notify(int new_notify) {
        this.new_notify = new_notify;
    }

    public String getLlsid() {
        return llsid;
    }

    public void setLlsid(String llsid) {
        this.llsid = llsid;
    }

    private List<FeedsBean> feeds;

    public static QuickHeadBean objectFromData(String str) {

        return new Gson().fromJson(str, QuickHeadBean.class);
    }

    public static QuickHeadBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), QuickHeadBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<QuickHeadBean> arrayBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<QuickHeadBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<QuickHeadBean> arrayBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<QuickHeadBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }


    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

    public static class FeedsBean {
        private int following;
        private String caption;
        private boolean verified;
        private boolean hasMagicFaceTag;
        private String time;
        private long timestamp;
        private int type;
        private int user_id;
        private int comment_count;
        private int photo_id;
        private String exp_tag;
        private String user_sex;
        private int photo_status;
        private int us_m;
        private int view_count;
        private int like_count;
        private int unlike_count;
        private int forward_count;
        /**
         * mtype : 3
         * color : BAB489
         * w : 480
         * sound : 16927
         * h : 640
         * interval : 5
         * video : 16850
         */

        private ExtParamsBean ext_params;
        private int tag_hash_type;
        private String user_name;
        private int liked;
        private int us_c;
        private int us_d;
        /**
         * et : 1_a/1548847878074806273_h85
         */

        private ForwardStatsParamsBean forward_stats_params;
        private String reco_reason;
        private List<?> comments;
        private List<?> tags;
        /**
         * cdn : tx2.a.yximgs.com
         * url : http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z.mp4?tag=1-1477096443-h-0-dihsna4uyv-c7b45c8d94907f5c
         */

        private List<MainMvUrlsBean> main_mv_urls;
        private List<MainMvUrlsBean> cover_thumbnail_urls;
        /**
         * cdn : js.a.yximgs.com
         * url : http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg
         * urlPattern : http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate
         */

        private List<HeadurlsBean> headurls;

        public static FeedsBean objectFromData(String str) {

            return new Gson().fromJson(str, FeedsBean.class);
        }

        public static FeedsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), FeedsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<FeedsBean> arrayFeedsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<FeedsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<FeedsBean> arrayFeedsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<FeedsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getFollowing() {
            return following;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public boolean isHasMagicFaceTag() {
            return hasMagicFaceTag;
        }

        public void setHasMagicFaceTag(boolean hasMagicFaceTag) {
            this.hasMagicFaceTag = hasMagicFaceTag;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getPhoto_id() {
            return photo_id;
        }

        public void setPhoto_id(int photo_id) {
            this.photo_id = photo_id;
        }

        public String getExp_tag() {
            return exp_tag;
        }

        public void setExp_tag(String exp_tag) {
            this.exp_tag = exp_tag;
        }

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public int getPhoto_status() {
            return photo_status;
        }

        public void setPhoto_status(int photo_status) {
            this.photo_status = photo_status;
        }

        public int getUs_m() {
            return us_m;
        }

        public void setUs_m(int us_m) {
            this.us_m = us_m;
        }

        public int getView_count() {
            return view_count;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getUnlike_count() {
            return unlike_count;
        }

        public void setUnlike_count(int unlike_count) {
            this.unlike_count = unlike_count;
        }

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }

        public ExtParamsBean getExt_params() {
            return ext_params;
        }

        public void setExt_params(ExtParamsBean ext_params) {
            this.ext_params = ext_params;
        }

        public int getTag_hash_type() {
            return tag_hash_type;
        }

        public void setTag_hash_type(int tag_hash_type) {
            this.tag_hash_type = tag_hash_type;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getLiked() {
            return liked;
        }

        public void setLiked(int liked) {
            this.liked = liked;
        }

        public int getUs_c() {
            return us_c;
        }

        public void setUs_c(int us_c) {
            this.us_c = us_c;
        }

        public int getUs_d() {
            return us_d;
        }

        public void setUs_d(int us_d) {
            this.us_d = us_d;
        }

        public ForwardStatsParamsBean getForward_stats_params() {
            return forward_stats_params;
        }

        public void setForward_stats_params(ForwardStatsParamsBean forward_stats_params) {
            this.forward_stats_params = forward_stats_params;
        }

        public String getReco_reason() {
            return reco_reason;
        }

        public void setReco_reason(String reco_reason) {
            this.reco_reason = reco_reason;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<MainMvUrlsBean> getMain_mv_urls() {
            return main_mv_urls;
        }

        public void setMain_mv_urls(List<MainMvUrlsBean> main_mv_urls) {
            this.main_mv_urls = main_mv_urls;
        }

        public List<MainMvUrlsBean> getCover_thumbnail_urls() {
            return cover_thumbnail_urls;
        }

        public void setCover_thumbnail_urls(List<MainMvUrlsBean> cover_thumbnail_urls) {
            this.cover_thumbnail_urls = cover_thumbnail_urls;
        }

        public List<HeadurlsBean> getHeadurls() {
            return headurls;
        }

        public void setHeadurls(List<HeadurlsBean> headurls) {
            this.headurls = headurls;
        }

        public static class ExtParamsBean {
            private int mtype;
            private String color;
            private int w;
            private int sound;
            private int h;
            private int interval;
            private int video;

            public static ExtParamsBean objectFromData(String str) {

                return new Gson().fromJson(str, ExtParamsBean.class);
            }

            public static ExtParamsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ExtParamsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ExtParamsBean> arrayExtParamsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ExtParamsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ExtParamsBean> arrayExtParamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ExtParamsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public int getMtype() {
                return mtype;
            }

            public void setMtype(int mtype) {
                this.mtype = mtype;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getSound() {
                return sound;
            }

            public void setSound(int sound) {
                this.sound = sound;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public int getVideo() {
                return video;
            }

            public void setVideo(int video) {
                this.video = video;
            }
        }

        public static class ForwardStatsParamsBean {
            private String et;

            public static ForwardStatsParamsBean objectFromData(String str) {

                return new Gson().fromJson(str, ForwardStatsParamsBean.class);
            }

            public static ForwardStatsParamsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ForwardStatsParamsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ForwardStatsParamsBean> arrayForwardStatsParamsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ForwardStatsParamsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ForwardStatsParamsBean> arrayForwardStatsParamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ForwardStatsParamsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getEt() {
                return et;
            }

            public void setEt(String et) {
                this.et = et;
            }
        }

        public static class MainMvUrlsBean {
            private String cdn;
            private String url;

            public static MainMvUrlsBean objectFromData(String str) {

                return new Gson().fromJson(str, MainMvUrlsBean.class);
            }

            public static MainMvUrlsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), MainMvUrlsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<MainMvUrlsBean> arrayMainMvUrlsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<MainMvUrlsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<MainMvUrlsBean> arrayMainMvUrlsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<MainMvUrlsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getCdn() {
                return cdn;
            }

            public void setCdn(String cdn) {
                this.cdn = cdn;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class HeadurlsBean {
            private String cdn;
            private String url;
            private String urlPattern;

            public static HeadurlsBean objectFromData(String str) {

                return new Gson().fromJson(str, HeadurlsBean.class);
            }

            public static HeadurlsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), HeadurlsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<HeadurlsBean> arrayHeadurlsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<HeadurlsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<HeadurlsBean> arrayHeadurlsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<HeadurlsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getCdn() {
                return cdn;
            }

            public void setCdn(String cdn) {
                this.cdn = cdn;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrlPattern() {
                return urlPattern;
            }

            public void setUrlPattern(String urlPattern) {
                this.urlPattern = urlPattern;
            }
        }
    }
}
