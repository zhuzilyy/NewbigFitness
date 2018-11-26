package com.example.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by Administrator on 2017/7/11.
 */

public class MyInfoBean {

    /**
     * message :
     * result : {"HeaderURL":"","PersonType":"教练","UserId":40,"Sex":"男"}
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
         * HeaderURL :
         * PersonType : 教练
         * UserId : 40
         * Sex : 男
         */

        private String HeaderURL;
        private String UserName;
        private String PersonType;
        private int UserId;
        private String Sex;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getPersonType() {
            return PersonType;
        }

        public void setPersonType(String PersonType) {
            this.PersonType = PersonType;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }
    }
}
