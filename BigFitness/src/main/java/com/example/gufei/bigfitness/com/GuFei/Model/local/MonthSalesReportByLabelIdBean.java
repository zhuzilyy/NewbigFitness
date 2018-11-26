package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class MonthSalesReportByLabelIdBean {


    /**
     * message :
     * result : [{"percent":"98.24","dicName":"轮排WI","saleNum":2137755},{"percent":"1.65","dicName":"拉访DI","saleNum":35797},{"percent":"0.1","dicName":"转介BR","saleNum":2095},{"percent":"0.01","dicName":"其他OT","saleNum":300},{"percent":"0","dicName":"低","saleNum":0},{"percent":"0","dicName":"体验GP","saleNum":0},{"percent":"0","dicName":"中","saleNum":0},{"percent":"0","dicName":"约访AP","saleNum":0}]
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
         * percent : 98.24
         * dicName : 轮排WI
         * saleNum : 2137755
         */

        private String percent;
        private String dicName;
        private int saleNum;

        public String getPercent() {
            return percent;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public String getDicName() {
            return dicName;
        }

        public void setDicName(String dicName) {
            this.dicName = dicName;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
