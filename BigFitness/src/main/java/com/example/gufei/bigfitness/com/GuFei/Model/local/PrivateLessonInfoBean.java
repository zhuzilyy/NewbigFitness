package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei on 2018/5/5.
 */

public class PrivateLessonInfoBean {


    /**
     * message :
     * result : [{"BuyRemark":"","LessonTeacherName":"郭富城","BargainNo":"00112","TotalBuyMoney":1000,"RemainCount":"9/10节","SaleTeacherName":"郭富城","Status":"有效","CreateUserName":"周杰伦","LessonName":"减脂课","StopTime":"2019-04-26","Id":1612,"LessonType":"特色课","BuyTime":"2018-04-26"}]
     * code : 0
     */

    private String message;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
         * BuyRemark :
         * LessonTeacherName : 郭富城
         * BargainNo : 00112
         * TotalBuyMoney : 1000
         * RemainCount : 9/10节
         * SaleTeacherName : 郭富城
         * Status : 有效
         * CreateUserName : 周杰伦
         * LessonName : 减脂课
         * StopTime : 2019-04-26
         * Id : 1612
         * LessonType : 特色课
         * BuyTime : 2018-04-26
         */

        private String BuyRemark;
        private String LessonTeacherName;
        private String BargainNo;
        private int TotalBuyMoney;
        private String RemainCount;
        private String SaleTeacherName;
        private String Status;
        private String CreateUserName;
        private String LessonName;
        private String StopTime;
        private int Id;
        private String LessonType;
        private String BuyTime;

        public String getBuyRemark() {
            return BuyRemark;
        }

        public void setBuyRemark(String BuyRemark) {
            this.BuyRemark = BuyRemark;
        }

        public String getLessonTeacherName() {
            return LessonTeacherName;
        }

        public void setLessonTeacherName(String LessonTeacherName) {
            this.LessonTeacherName = LessonTeacherName;
        }

        public String getBargainNo() {
            return BargainNo;
        }

        public void setBargainNo(String BargainNo) {
            this.BargainNo = BargainNo;
        }

        public int getTotalBuyMoney() {
            return TotalBuyMoney;
        }

        public void setTotalBuyMoney(int TotalBuyMoney) {
            this.TotalBuyMoney = TotalBuyMoney;
        }

        public String getRemainCount() {
            return RemainCount;
        }

        public void setRemainCount(String RemainCount) {
            this.RemainCount = RemainCount;
        }

        public String getSaleTeacherName() {
            return SaleTeacherName;
        }

        public void setSaleTeacherName(String SaleTeacherName) {
            this.SaleTeacherName = SaleTeacherName;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getStopTime() {
            return StopTime;
        }

        public void setStopTime(String StopTime) {
            this.StopTime = StopTime;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getLessonType() {
            return LessonType;
        }

        public void setLessonType(String LessonType) {
            this.LessonType = LessonType;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }
    }
}
