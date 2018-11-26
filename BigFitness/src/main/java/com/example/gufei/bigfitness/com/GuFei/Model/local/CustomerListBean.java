package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/3
 */

public class CustomerListBean {

    /**
     * result : [{"LastContactTime":"2017/05/26 15:29","CustomerId":41,"CreateTime":"2017/05/17 14:43","CustomerName":"2","Tel":"234234234","Sex":"男"},{"LastContactTime":"2017/06/01 13:11","CustomerId":49,"CreateTime":"2017/05/23 10:57","CustomerName":"jhhgh","Tel":"4444","Sex":"男"}]
     * meaage :
     * code : 0
     */

    private String meaage;
    private int code;
    private List<ResultBean> result;

    public String getMeaage() {
        return meaage;
    }

    public void setMeaage(String meaage) {
        this.meaage = meaage;
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
         * LastContactTime : 2017/05/26 15:29
         * CustomerId : 41
         * CreateTime : 2017/05/17 14:43
         * CustomerName : 2
         * Tel : 234234234
         * Sex : 男
         */


        private String LastContactTime;
        private int CustomerId;
        private String CreateTime;
        private String CustomerName;
        private String OwnManagerName;
        private String OwnTeacherName;
        private String MemberName = "";
        private String IntentName;
        private String POSTeacherName;
        private String MemberCardNo;
        private String StopTime;
        private String Id;


        public String getHeaderURL() {
            return HeaderURL;
        }
        public void setHeaderURL(String headerURL) {
            HeaderURL = headerURL;
        }
        private String HeaderURL;
        private int MemberId;
        private String Tel;
        private String Sex;
        private long LessonTeacherId;

        public long getLessonTeacherId() {
            return LessonTeacherId;
        }

        public void setLessonTeacherId(long lessonTeacherId) {
            LessonTeacherId = lessonTeacherId;
        }

        public String getLastContactTime() {
            return LastContactTime;
        }

        public void setLastContactTime(String LastContactTime) {
            this.LastContactTime = LastContactTime;
        }

        public String getStopTime() {
            return StopTime;
        }

        public void setStopTime(String stopTime) {
            StopTime = stopTime;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public int getCustomerId() {
       /*     if (CustomerId == 0) {
                return MemberId;
            }
            */
            return CustomerId;
        }

        public String getIntentName() {
            return IntentName;
        }

        public void setIntentName(String intentName) {
            IntentName = intentName;
        }

        public String getPOSTeacherName() {
            return POSTeacherName;
        }

        public void setPOSTeacherName(String POSTeacherName) {
            this.POSTeacherName = POSTeacherName;
        }

        public String getMemberCardNo() {
            return MemberCardNo;
        }

        public void setMemberCardNo(String memberCardNo) {
            MemberCardNo = memberCardNo;
        }

        public void setCustomerId(int CustomerId) {
            this.CustomerId = CustomerId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getCustomerName() {
            if (MemberName.equals("")) {
                return CustomerName;
            }
                return MemberName;
        }

        public String getOwnTeacherName() {
            return OwnTeacherName;
        }

        public void setOwnTeacherName(String ownTeacherName) {
            OwnTeacherName = ownTeacherName;
        }

        public String getOwnManagerName() {
            return OwnManagerName;
        }

        public void setOwnManagerName(String ownManagerName) {
            OwnManagerName = ownManagerName;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int memberId) {
            MemberId = memberId;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
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

        public String getMemberName() {

            return MemberName;
        }

        public void setMemberName(String memberName) {
            this.MemberName = memberName;


        }
    }
}