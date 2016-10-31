package com.maqianyu.nicedrama.video.Entity;

import java.util.List;

/**
 * Created by dllo on 16/10/29.
 * 追剧的实体类
 */
public class ChaseEntity {

    /**
     * Result : 0
     * Data : {"pageSize":10,"listLiveCartoon":[{"lcId":1179,"piId":10030,"title":"第14话","coverUrl":"http://qiniu.jnwtv.com/LCP_1000_1179_2_1477377033480.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":14,"createDt":"2016-10-27","isFree":"N","readPermision":"N","visitNo":444,"unlockJpoint":25},{"lcId":1178,"piId":10030,"title":"第13话","coverUrl":"http://qiniu.jnwtv.com/LCP_1000_1178_2_1477374297546.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":13,"createDt":"2016-10-25","isFree":"N","readPermision":"N","visitNo":482,"unlockJpoint":25},{"lcId":1126,"piId":10030,"title":"第12话","coverUrl":"http://qiniu.jnwtv.com/LCP20161010135016173671880.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":12,"createDt":"2016-10-13","isFree":"N","readPermision":"N","visitNo":1513,"unlockJpoint":25},{"lcId":1125,"piId":10030,"title":"第11话","coverUrl":"http://qiniu.jnwtv.com/LCP20161010135016970374360.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":11,"createDt":"2016-10-11","isFree":"N","readPermision":"N","visitNo":1041,"unlockJpoint":25},{"lcId":1103,"piId":10030,"title":"第10话","coverUrl":"http://qiniu.jnwtv.com/LCP20160930094900530623558.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":10,"createDt":"2016-10-06","isFree":"N","readPermision":"N","visitNo":1889,"unlockJpoint":25},{"lcId":1102,"piId":10030,"title":"第9话","coverUrl":"http://qiniu.jnwtv.com/LCP20160930094844998651779.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":9,"createDt":"2016-10-04","isFree":"N","readPermision":"N","visitNo":3291,"unlockJpoint":25},{"lcId":1081,"piId":10030,"title":"第8话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011628841447.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":8,"createDt":"2016-09-29","isFree":"Y","readPermision":"Y","visitNo":5705,"unlockJpoint":25},{"lcId":1080,"piId":10030,"title":"第7话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011759381278.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":7,"createDt":"2016-09-27","isFree":"Y","readPermision":"Y","visitNo":3824,"unlockJpoint":25},{"lcId":1079,"piId":10030,"title":"第6话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011733195915.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":6,"createDt":"2016-09-22","isFree":"Y","readPermision":"Y","visitNo":3894,"unlockJpoint":25},{"lcId":1078,"piId":10030,"title":"第5话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011751616954.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":5,"createDt":"2016-09-20","isFree":"Y","readPermision":"Y","visitNo":3473,"unlockJpoint":25}],"currentSize":10}
     * Desc : \u6210\u529f
     */

    private String Result;
    /**
     * pageSize : 10
     * listLiveCartoon : [{"lcId":1179,"piId":10030,"title":"第14话","coverUrl":"http://qiniu.jnwtv.com/LCP_1000_1179_2_1477377033480.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":14,"createDt":"2016-10-27","isFree":"N","readPermision":"N","visitNo":444,"unlockJpoint":25},{"lcId":1178,"piId":10030,"title":"第13话","coverUrl":"http://qiniu.jnwtv.com/LCP_1000_1178_2_1477374297546.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":13,"createDt":"2016-10-25","isFree":"N","readPermision":"N","visitNo":482,"unlockJpoint":25},{"lcId":1126,"piId":10030,"title":"第12话","coverUrl":"http://qiniu.jnwtv.com/LCP20161010135016173671880.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":12,"createDt":"2016-10-13","isFree":"N","readPermision":"N","visitNo":1513,"unlockJpoint":25},{"lcId":1125,"piId":10030,"title":"第11话","coverUrl":"http://qiniu.jnwtv.com/LCP20161010135016970374360.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":11,"createDt":"2016-10-11","isFree":"N","readPermision":"N","visitNo":1041,"unlockJpoint":25},{"lcId":1103,"piId":10030,"title":"第10话","coverUrl":"http://qiniu.jnwtv.com/LCP20160930094900530623558.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":10,"createDt":"2016-10-06","isFree":"N","readPermision":"N","visitNo":1889,"unlockJpoint":25},{"lcId":1102,"piId":10030,"title":"第9话","coverUrl":"http://qiniu.jnwtv.com/LCP20160930094844998651779.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":9,"createDt":"2016-10-04","isFree":"N","readPermision":"N","visitNo":3291,"unlockJpoint":25},{"lcId":1081,"piId":10030,"title":"第8话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011628841447.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":8,"createDt":"2016-09-29","isFree":"Y","readPermision":"Y","visitNo":5705,"unlockJpoint":25},{"lcId":1080,"piId":10030,"title":"第7话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011759381278.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":7,"createDt":"2016-09-27","isFree":"Y","readPermision":"Y","visitNo":3824,"unlockJpoint":25},{"lcId":1079,"piId":10030,"title":"第6话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011733195915.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":6,"createDt":"2016-09-22","isFree":"Y","readPermision":"Y","visitNo":3894,"unlockJpoint":25},{"lcId":1078,"piId":10030,"title":"第5话","coverUrl":"http://qiniu.jnwtv.com/LCP2016092012011751616954.jpg?imageView2/1/w/214/h/120&e=2997426444","episodeNo":5,"createDt":"2016-09-20","isFree":"Y","readPermision":"Y","visitNo":3473,"unlockJpoint":25}]
     * currentSize : 10
     */

    private DataBean Data;
    private String Desc;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public static class DataBean {
        private int pageSize;
        private int currentSize;
        /**
         * lcId : 1179
         * piId : 10030
         * title : 第14话
         * coverUrl : http://qiniu.jnwtv.com/LCP_1000_1179_2_1477377033480.jpg?imageView2/1/w/214/h/120&e=2997426444
         * episodeNo : 14
         * createDt : 2016-10-27
         * isFree : N
         * readPermision : N
         * visitNo : 444
         * unlockJpoint : 25
         */

        private List<ListLiveCartoonBean> listLiveCartoon;

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        public void setCurrentSize(int currentSize) {
            this.currentSize = currentSize;
        }

        public List<ListLiveCartoonBean> getListLiveCartoon() {
            return listLiveCartoon;
        }

        public void setListLiveCartoon(List<ListLiveCartoonBean> listLiveCartoon) {
            this.listLiveCartoon = listLiveCartoon;
        }

        public static class ListLiveCartoonBean {
            private int lcId;
            private int piId;
            private String title;
            private String coverUrl;
            private int episodeNo;
            private String createDt;
            private String isFree;
            private String readPermision;
            private int visitNo;
            private int unlockJpoint;

            public int getLcId() {
                return lcId;
            }

            public void setLcId(int lcId) {
                this.lcId = lcId;
            }

            public int getPiId() {
                return piId;
            }

            public void setPiId(int piId) {
                this.piId = piId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public int getEpisodeNo() {
                return episodeNo;
            }

            public void setEpisodeNo(int episodeNo) {
                this.episodeNo = episodeNo;
            }

            public String getCreateDt() {
                return createDt;
            }

            public void setCreateDt(String createDt) {
                this.createDt = createDt;
            }

            public String getIsFree() {
                return isFree;
            }

            public void setIsFree(String isFree) {
                this.isFree = isFree;
            }

            public String getReadPermision() {
                return readPermision;
            }

            public void setReadPermision(String readPermision) {
                this.readPermision = readPermision;
            }

            public int getVisitNo() {
                return visitNo;
            }

            public void setVisitNo(int visitNo) {
                this.visitNo = visitNo;
            }

            public int getUnlockJpoint() {
                return unlockJpoint;
            }

            public void setUnlockJpoint(int unlockJpoint) {
                this.unlockJpoint = unlockJpoint;
            }
        }
    }
}
