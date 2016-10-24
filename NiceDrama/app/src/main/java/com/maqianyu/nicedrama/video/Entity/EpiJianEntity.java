package com.maqianyu.nicedrama.video.Entity;

import java.util.List;

/**
 * Created by dllo on 16/10/24.
 * 剧集视频简介的实体类
 */
public class EpiJianEntity {

    /**
     * Result : 0
     * Data : [{"piId":"10030","projectName":"暗恋成婚","projectCoverUrl":"http://qiniu.jnwtv.com/MC2016100913021990379920.jpg?imageView2/1/w/480/h/267&e=2997426444","projectPlayNums":"137709","projectRewardTotal":"0","projectTotalEpisode":"11","projectUpdateEpisode":"8","projectTags":"言情|男神|师生","projectOwnerNick":"有情有义的骆驼","projectLogNums":"82","projectCommentNums":"1402","downloadLinkAndroid":"http://ah2.zhangyue.com/zybook3/app/app.php?ca=Down.Index&p2=116468","downloadLinkIos":"https://itunes.apple.com/app/apple-store/id463150061?pt=531962&ct=tupianju&mt=8","projectOriginalUrl":"http://qiniu.jnwtv.com/POC2016083015303137813194.jpg?e=2997426444","projectAuthor":"卿可归","projectDesc":"一场豪赌，季子默剃光了为喜欢的人留了十年的长发。一夜宿醉，醒来之后，眼前摆了一张红艳艳的结婚证！尤其是：这男人还是个三十岁的老男人！她二十岁的小姑娘怎么能嫁一个比她大十岁的老男人？离婚，这婚一万个得离！\r\n\u201c顾疏白，我们必须离婚，你的年纪都够做我爸爸了！\u201d\r\n\u201c宝贝乖，让老公好好疼你。\u201d重点不应该是离婚吗?\r\n\u201c顾疏白，你瞧瞧你的皱纹！你和我这么一个小姑娘出去不害臊吗？\u201d\r\n\u201c默默，有没有觉得\u2018疏疏\u2019的皱纹很性感\u2026\u2026\u201d\r\n\u201c顾疏白，我要离婚，离婚！离婚！\u201d\r\n\u201c季子默，你再和我说一次离婚，我就抱着你儿子一块跳长江去！\u201d","projectDescOriginal":"《暗恋成婚：男神宠妻如命》","haveLiveCartoon":"Y"}]
     * Desc : \u6210\u529f
     */

    private String Result;
    private String Desc;
    /**
     * piId : 10030
     * projectName : 暗恋成婚
     * projectCoverUrl : http://qiniu.jnwtv.com/MC2016100913021990379920.jpg?imageView2/1/w/480/h/267&e=2997426444
     * projectPlayNums : 137709
     * projectRewardTotal : 0
     * projectTotalEpisode : 11
     * projectUpdateEpisode : 8
     * projectTags : 言情|男神|师生
     * projectOwnerNick : 有情有义的骆驼
     * projectLogNums : 82
     * projectCommentNums : 1402
     * downloadLinkAndroid : http://ah2.zhangyue.com/zybook3/app/app.php?ca=Down.Index&p2=116468
     * downloadLinkIos : https://itunes.apple.com/app/apple-store/id463150061?pt=531962&ct=tupianju&mt=8
     * projectOriginalUrl : http://qiniu.jnwtv.com/POC2016083015303137813194.jpg?e=2997426444
     * projectAuthor : 卿可归
     * projectDesc : 一场豪赌，季子默剃光了为喜欢的人留了十年的长发。一夜宿醉，醒来之后，眼前摆了一张红艳艳的结婚证！尤其是：这男人还是个三十岁的老男人！她二十岁的小姑娘怎么能嫁一个比她大十岁的老男人？离婚，这婚一万个得离！
     “顾疏白，我们必须离婚，你的年纪都够做我爸爸了！”
     “宝贝乖，让老公好好疼你。”重点不应该是离婚吗?
     “顾疏白，你瞧瞧你的皱纹！你和我这么一个小姑娘出去不害臊吗？”
     “默默，有没有觉得‘疏疏’的皱纹很性感……”
     “顾疏白，我要离婚，离婚！离婚！”
     “季子默，你再和我说一次离婚，我就抱着你儿子一块跳长江去！”
     * projectDescOriginal : 《暗恋成婚：男神宠妻如命》
     * haveLiveCartoon : Y
     */

    private List<DataBean> Data;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        private String piId;
        private String projectName;
        private String projectCoverUrl;
        private String projectPlayNums;
        private String projectRewardTotal;
        private String projectTotalEpisode;
        private String projectUpdateEpisode;
        private String projectTags;
        private String projectOwnerNick;
        private String projectLogNums;
        private String projectCommentNums;
        private String downloadLinkAndroid;
        private String downloadLinkIos;
        private String projectOriginalUrl;
        private String projectAuthor;
        private String projectDesc;
        private String projectDescOriginal;
        private String haveLiveCartoon;

        public String getPiId() {
            return piId;
        }

        public void setPiId(String piId) {
            this.piId = piId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getProjectCoverUrl() {
            return projectCoverUrl;
        }

        public void setProjectCoverUrl(String projectCoverUrl) {
            this.projectCoverUrl = projectCoverUrl;
        }

        public String getProjectPlayNums() {
            return projectPlayNums;
        }

        public void setProjectPlayNums(String projectPlayNums) {
            this.projectPlayNums = projectPlayNums;
        }

        public String getProjectRewardTotal() {
            return projectRewardTotal;
        }

        public void setProjectRewardTotal(String projectRewardTotal) {
            this.projectRewardTotal = projectRewardTotal;
        }

        public String getProjectTotalEpisode() {
            return projectTotalEpisode;
        }

        public void setProjectTotalEpisode(String projectTotalEpisode) {
            this.projectTotalEpisode = projectTotalEpisode;
        }

        public String getProjectUpdateEpisode() {
            return projectUpdateEpisode;
        }

        public void setProjectUpdateEpisode(String projectUpdateEpisode) {
            this.projectUpdateEpisode = projectUpdateEpisode;
        }

        public String getProjectTags() {
            return projectTags;
        }

        public void setProjectTags(String projectTags) {
            this.projectTags = projectTags;
        }

        public String getProjectOwnerNick() {
            return projectOwnerNick;
        }

        public void setProjectOwnerNick(String projectOwnerNick) {
            this.projectOwnerNick = projectOwnerNick;
        }

        public String getProjectLogNums() {
            return projectLogNums;
        }

        public void setProjectLogNums(String projectLogNums) {
            this.projectLogNums = projectLogNums;
        }

        public String getProjectCommentNums() {
            return projectCommentNums;
        }

        public void setProjectCommentNums(String projectCommentNums) {
            this.projectCommentNums = projectCommentNums;
        }

        public String getDownloadLinkAndroid() {
            return downloadLinkAndroid;
        }

        public void setDownloadLinkAndroid(String downloadLinkAndroid) {
            this.downloadLinkAndroid = downloadLinkAndroid;
        }

        public String getDownloadLinkIos() {
            return downloadLinkIos;
        }

        public void setDownloadLinkIos(String downloadLinkIos) {
            this.downloadLinkIos = downloadLinkIos;
        }

        public String getProjectOriginalUrl() {
            return projectOriginalUrl;
        }

        public void setProjectOriginalUrl(String projectOriginalUrl) {
            this.projectOriginalUrl = projectOriginalUrl;
        }

        public String getProjectAuthor() {
            return projectAuthor;
        }

        public void setProjectAuthor(String projectAuthor) {
            this.projectAuthor = projectAuthor;
        }

        public String getProjectDesc() {
            return projectDesc;
        }

        public void setProjectDesc(String projectDesc) {
            this.projectDesc = projectDesc;
        }

        public String getProjectDescOriginal() {
            return projectDescOriginal;
        }

        public void setProjectDescOriginal(String projectDescOriginal) {
            this.projectDescOriginal = projectDescOriginal;
        }

        public String getHaveLiveCartoon() {
            return haveLiveCartoon;
        }

        public void setHaveLiveCartoon(String haveLiveCartoon) {
            this.haveLiveCartoon = haveLiveCartoon;
        }
    }
}
