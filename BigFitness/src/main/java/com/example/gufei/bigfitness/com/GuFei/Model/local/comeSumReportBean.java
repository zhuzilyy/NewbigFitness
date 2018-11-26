package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class comeSumReportBean {


    /**
     * message :
     * result : [{"mComeCount":5,"cComeCount":0}]
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
         * MComeCount : 5
         * cComeCount : 0
         */

        private int mComeCount;
        private int cComeCount;

        public int getMComeCount() {
            return mComeCount;
        }

        public void setMComeCount(int MComeCount) {
            this.mComeCount = MComeCount;
        }

        public int getCComeCount() {
            return cComeCount;
        }

        public void setCComeCount(int cComeCount) {
            this.cComeCount = cComeCount;
        }
    }
}
