package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei on 2018/5/5.
 */

public class GroupLesssonInfoBean {


    /**
     * message :
     * result : [{"BargainNo":"46465","TotalBuyMoney":1000,"UserName":"周杰伦","RemainCount":"4/4节","Status":"未开课","ClassTimes":"2018-05-26  13:00:00--14:00:00  ,2018-06-02  13:00:00--14:00:00  ,2018-06-16  13:00:00--14:00:00  ,2018-06-26  13:02:00--14:02:00  ","ExpireTime":"2018-06-26","LessonName":"测试小团体课","Id":107,"LessonType":"小团体课","StartTime":"2018-05-26","BuyTime":"2018-05-05","Remark":"","LessonteacherName":"李明,郭富城"}]
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
         * BargainNo : 46465
         * TotalBuyMoney : 1000
         * UserName : 周杰伦
         * RemainCount : 4/4节
         * Status : 未开课
         * ClassTimes : 2018-05-26  13:00:00--14:00:00  ,2018-06-02  13:00:00--14:00:00  ,2018-06-16  13:00:00--14:00:00  ,2018-06-26  13:02:00--14:02:00
         * ExpireTime : 2018-06-26
         * LessonName : 测试小团体课
         * Id : 107
         * LessonType : 小团体课
         * StartTime : 2018-05-26
         * BuyTime : 2018-05-05
         * Remark :
         * LessonteacherName : 李明,郭富城
         */

        private String BargainNo;
        private int TotalBuyMoney;
        private String UserName;
        private String RemainCount;
        private String Status;
        private String ClassTimes;
        private String ExpireTime;
        private String LessonName;
        private int Id;
        private String LessonType;
        private String StartTime;
        private String BuyTime;
        private String Remark;
        private String LessonteacherName;

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

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getRemainCount() {
            return RemainCount;
        }

        public void setRemainCount(String RemainCount) {
            this.RemainCount = RemainCount;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getClassTimes() {
            return ClassTimes;
        }

        public void setClassTimes(String ClassTimes) {
            this.ClassTimes = ClassTimes;
        }

        public String getExpireTime() {
            return ExpireTime;
        }

        public void setExpireTime(String ExpireTime) {
            this.ExpireTime = ExpireTime;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
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

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getLessonteacherName() {
            return LessonteacherName;
        }

        public void setLessonteacherName(String LessonteacherName) {
            this.LessonteacherName = LessonteacherName;
        }
    }
}
