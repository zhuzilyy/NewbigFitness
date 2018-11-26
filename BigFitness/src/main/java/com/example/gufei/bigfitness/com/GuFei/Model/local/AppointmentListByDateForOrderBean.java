package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class AppointmentListByDateForOrderBean {


    /**
     * result : [{"AppointmentResultId":"","AppointmentResultName":"","UserName":"郭小晏","EndTime":"2018/10/15 14:00","CreateTime":"10/15 12:42","AppointmentOwner":1,"StartTime":"2018/10/15 13:00","AppointmentCata":0,"AppointmentStatus":0,"title":"会员：lsy 上课预约","content":"","IsSignIn":0,"MemberId":45183,"MemberType":"0","AppointmentId":419,"appType":"2","HeaderURL":"uploadFiles/uploadImgs/20180928/54d5b48742a149138ff5ee19287fee99.jpg"},{"AppointmentResultId":"","AppointmentResultName":"","UserName":"郭小晏","EndTime":"2018/11/13 20:56","CreateTime":"09/13 21:02","AppointmentOwner":1,"StartTime":"2018/10/13 20:56","AppointmentCata":1,"AppointmentStatus":1,"title":"会员：穆宏宇 上课预约","content":"","IsSignIn":0,"MemberId":44149,"MemberType":"1","AppointmentId":267,"appType":"2","HeaderURL":"uploadFiles/uploadImgs/20180928/54d5b48742a149138ff5ee19287fee99.jpg"}]
     * code : 0
     * message :
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * AppointmentResultId :
         * AppointmentResultName :
         * UserName : 郭小晏
         * EndTime : 2018/10/15 14:00
         * CreateTime : 10/15 12:42
         * AppointmentOwner : 1
         * StartTime : 2018/10/15 13:00
         * AppointmentCata : 0
         * AppointmentStatus : 0
         * title : 会员：lsy 上课预约
         * content :
         * IsSignIn : 0
         * MemberId : 45183
         * MemberType : 0
         * AppointmentId : 419
         * appType : 2
         * HeaderURL : uploadFiles/uploadImgs/20180928/54d5b48742a149138ff5ee19287fee99.jpg
         */

        private String AppointmentResultId;
        private String AppointmentResultName;
        private String UserName;
        private String EndTime;
        private String CreateTime;
        private int AppointmentOwner;
        private String StartTime;
        private int AppointmentCata;
        private int AppointmentStatus;
        private String title;
        private String content;
        private int IsSignIn;
        private int MemberId;
        private String MemberType;
        private int AppointmentId;
        private String appType;
        private String HeaderURL;

        public String getAppointmentResultId() {
            return AppointmentResultId;
        }

        public void setAppointmentResultId(String AppointmentResultId) {
            this.AppointmentResultId = AppointmentResultId;
        }

        public String getAppointmentResultName() {
            return AppointmentResultName;
        }

        public void setAppointmentResultName(String AppointmentResultName) {
            this.AppointmentResultName = AppointmentResultName;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getAppointmentOwner() {
            return AppointmentOwner;
        }

        public void setAppointmentOwner(int AppointmentOwner) {
            this.AppointmentOwner = AppointmentOwner;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public int getAppointmentCata() {
            return AppointmentCata;
        }

        public void setAppointmentCata(int AppointmentCata) {
            this.AppointmentCata = AppointmentCata;
        }

        public int getAppointmentStatus() {
            return AppointmentStatus;
        }

        public void setAppointmentStatus(int AppointmentStatus) {
            this.AppointmentStatus = AppointmentStatus;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIsSignIn() {
            return IsSignIn;
        }

        public void setIsSignIn(int IsSignIn) {
            this.IsSignIn = IsSignIn;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }

        public String getMemberType() {
            return MemberType;
        }

        public void setMemberType(String MemberType) {
            this.MemberType = MemberType;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }
    }
}
