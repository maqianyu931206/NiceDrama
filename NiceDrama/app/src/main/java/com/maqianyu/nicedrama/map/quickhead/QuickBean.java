package com.maqianyu.nicedrama.map.quickhead;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/21.
 */
public class QuickBean {

    private List<FeedsBean> feedsBean;

    public List<FeedsBean> getFeedsBean() {
        return feedsBean;
    }

    public void setFeedsBean(List<FeedsBean> feedsBean) {
        this.feedsBean = feedsBean;
    }

    public static class FeedsBean{
        private String caption;
        private String time;
        private List<ForwardStatsParamsBean>forward_stats_params;
        private List<MainmvurlsBean>main_mv_urls;
        private List<CoverThumbnailUrlsBean>cover_thumbnail_urls;
        private int user_id;
        private int comment_count;

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<ForwardStatsParamsBean> getForward_stats_params() {
            return forward_stats_params;
        }

        public void setForward_stats_params(List<ForwardStatsParamsBean> forward_stats_params) {
            this.forward_stats_params = forward_stats_params;
        }

        public List<MainmvurlsBean> getMain_mv_urls() {
            return main_mv_urls;
        }

        public void setMain_mv_urls(List<MainmvurlsBean> main_mv_urls) {
            this.main_mv_urls = main_mv_urls;
        }

        public List<CoverThumbnailUrlsBean> getCover_thumbnail_urls() {
            return cover_thumbnail_urls;
        }

        public void setCover_thumbnail_urls(List<CoverThumbnailUrlsBean> cover_thumbnail_urls) {
            this.cover_thumbnail_urls = cover_thumbnail_urls;
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

        public static class ForwardStatsParamsBean{
            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class CoverThumbnailUrlsBean{
            private String url;

            public String getUrl() {

                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class MainmvurlsBean{
            private String url;

            public String getUrl() {

                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

}
