package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

public class AdddayBean {
    /**
     * message :
     * saleResult : [{"pNum":"100.00%","newCustomerNum":2,"UserName":"陈奕迅"}]
     * code : 0
     */

    private String message;
    private int code;
    private List<SaleResultBean> saleResult;

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

    public List<SaleResultBean> getSaleResult() {
        return saleResult;
    }

    public void setSaleResult(List<SaleResultBean> saleResult) {
        this.saleResult = saleResult;
    }

    public static class SaleResultBean {
        /**
         * pNum : 100.00%
         * newCustomerNum : 2
         * UserName : 陈奕迅
         */

        private String pNum;
        private int newCustomerNum;
        private String UserName;

        public String getPNum() {
            return pNum;
        }

        public void setPNum(String pNum) {
            this.pNum = pNum;
        }

        public int getNewCustomerNum() {
            return newCustomerNum;
        }

        public void setNewCustomerNum(int newCustomerNum) {
            this.newCustomerNum = newCustomerNum;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }
    }
}
