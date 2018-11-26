package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */

public class appMemberNumReportDetailListBean {


    /**
     * message :
     * result : [{"HeaderURL":"","LastContactTime":"","MemberName":"6601","Tel":"13665466023","Sex":"男","MemberId":32388},{"HeaderURL":"","LastContactTime":"","MemberName":"669696","Tel":"15800456654","Sex":"男","MemberId":32387},{"HeaderURL":"","LastContactTime":"","MemberName":"1996","Tel":"13865563220","Sex":"男","MemberId":32386},{"HeaderURL":"","LastContactTime":"","MemberName":"4122","Tel":"13400000002","Sex":"男","MemberId":32384},{"HeaderURL":"uploadFiles/uploadImgs/20180426/80723fbc08eb4afd823bc2ae85e35704.png","LastContactTime":"","MemberName":"测试426","Tel":"15300080006","Sex":"男","MemberId":32378},{"HeaderURL":"","LastContactTime":"2018-04-26 16:54:06","MemberName":"4261","Tel":"13600000001","Sex":"男","MemberId":32377},{"HeaderURL":"","LastContactTime":"","MemberName":"4242","Tel":"17011111112","Sex":"女","MemberId":32375},{"HeaderURL":"","LastContactTime":"2018-05-04 15:09:17","MemberName":"4133","Tel":"13311111114","Sex":"女","MemberId":32371},{"HeaderURL":"","LastContactTime":"","MemberName":"4102","Tel":"13322222224","Sex":"男","MemberId":32358},{"HeaderURL":"","LastContactTime":"","MemberName":"4.10","Tel":"13322222222","Sex":"男","MemberId":32356}]
     * totalResult : 26
     * code : 0
     */

    private String message;
    private int totalResult;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * HeaderURL :
         * LastContactTime :
         * MemberName : 6601
         * Tel : 13665466023
         * Sex : 男
         * MemberId : 32388
         */

        private String HeaderURL;
        private String LastContactTime;
        private String MemberName;
        private String Tel;
        private String Sex;
        private int MemberId;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getLastContactTime() {
            return LastContactTime;
        }

        public void setLastContactTime(String LastContactTime) {
            this.LastContactTime = LastContactTime;
        }

        public String getMemberName() {
            return MemberName;
        }

        public void setMemberName(String MemberName) {
            this.MemberName = MemberName;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }
    }
}
