package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MonthAddSumReportBean {


    /**
     * message :
     * result : [{"newCustomerNum":0,"day":"2018-05-01","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-02","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-03","newMemberNum":1},{"newCustomerNum":1,"day":"2018-05-04","newMemberNum":2},{"newCustomerNum":1,"day":"2018-05-05","newMemberNum":1},{"newCustomerNum":0,"day":"2018-05-06","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-07","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-08","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-09","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-10","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-11","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-12","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-13","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-14","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-15","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-16","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-17","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-18","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-19","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-20","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-21","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-22","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-23","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-24","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-25","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-26","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-27","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-28","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-29","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-30","newMemberNum":0},{"newCustomerNum":0,"day":"2018-05-31","newMemberNum":0}]
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
         * newCustomerNum : 0
         * day : 2018-05-01
         * newMemberNum : 0
         */

        private int newCustomerNum;
        private String day;
        private int newMemberNum;

        public int getNewCustomerNum() {
            return newCustomerNum;
        }

        public void setNewCustomerNum(int newCustomerNum) {
            this.newCustomerNum = newCustomerNum;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getNewMemberNum() {
            return newMemberNum;
        }

        public void setNewMemberNum(int newMemberNum) {
            this.newMemberNum = newMemberNum;
        }
    }
}
