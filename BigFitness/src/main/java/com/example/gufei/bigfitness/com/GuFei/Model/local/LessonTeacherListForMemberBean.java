package com.example.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */

public class LessonTeacherListForMemberBean {


    /**
     * message :
     * result : [{"TeacherName":"李明","TeacherId":497}]
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
         * TeacherName : 李明
         * TeacherId : 497
         */

        private String TeacherName;
        private int TeacherId;

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public int getTeacherId() {
            return TeacherId;
        }

        public void setTeacherId(int TeacherId) {
            this.TeacherId = TeacherId;
        }
    }
}
