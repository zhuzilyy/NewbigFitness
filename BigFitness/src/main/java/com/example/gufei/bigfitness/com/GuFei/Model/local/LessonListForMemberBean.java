package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */

public class LessonListForMemberBean {


    /**
     * message :
     * result : [{"LessonId":39,"LessonName":"aaaaaaaaa"}]
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
         * AppointmentId : 446
         * LessonId : 39
         * LessonName : aaaaaaaaa
         */

        private int AppointmentId;
        private int LessonId;
        private String LessonName;

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int appointmentId) {
            AppointmentId = appointmentId;
        }

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }
    }
}
