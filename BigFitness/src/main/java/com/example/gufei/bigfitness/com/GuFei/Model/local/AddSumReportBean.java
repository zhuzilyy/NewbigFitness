package com.example.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by Administrator on 2017/9/21.
 */

public class AddSumReportBean {
    /**
     * message :
     * result : {"newCustomerNum":0,"newMemberNum":0}
     * code : 0
     */

    private String message;
    private ResultBean result;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * newCustomerNum : 0
         * newMemberNum : 0
         */

        private int newCustomerNum;
        private int newMemberNum;

        public int getNewCustomerNum() {
            return newCustomerNum;
        }

        public void setNewCustomerNum(int newCustomerNum) {
            this.newCustomerNum = newCustomerNum;
        }

        public int getNewMemberNum() {
            return newMemberNum;
        }

        public void setNewMemberNum(int newMemberNum) {
            this.newMemberNum = newMemberNum;
        }
    }



}
