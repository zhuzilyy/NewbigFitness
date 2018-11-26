package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MonthMemberLessonSumReportBean {


    /**
     * message :
     * result : [{"LeLessonSum":0,"day":"2018-05-01","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-02","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-03","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-04","LessonSum":0},{"LeLessonSum":80,"day":"2018-05-05","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-06","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-07","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-08","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-09","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-10","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-11","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-12","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-13","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-14","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-15","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-16","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-17","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-18","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-19","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-20","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-21","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-22","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-23","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-24","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-25","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-26","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-27","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-28","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-29","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-30","LessonSum":0},{"LeLessonSum":0,"day":"2018-05-31","LessonSum":0}]
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
         * LeLessonSum : 0
         * day : 2018-05-01
         * LessonSum : 0
         */

        private int LeLessonSum;
        private String day;
        private int LessonSum;

        public int getLeLessonSum() {
            return LeLessonSum;
        }

        public void setLeLessonSum(int LeLessonSum) {
            this.LeLessonSum = LeLessonSum;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getLessonSum() {
            return LessonSum;
        }

        public void setLessonSum(int LessonSum) {
            this.LessonSum = LessonSum;
        }
    }
}
