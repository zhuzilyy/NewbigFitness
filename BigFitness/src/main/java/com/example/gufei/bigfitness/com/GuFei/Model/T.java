package com.example.gufei.bigfitness.com.GuFei.Model;

import java.util.List;

/**
 * Created by GuFei on 2018/5/11.
 */

public class T {


    /**
     * message :
     * result : {"contactList":[{"AppointmentTypeName":"会籍预约","contactUserName":"张学友","AppointCreateTime":"2018-05-10","AppointStartTime":"2018-05-11\n\t\t11:50:00","AppointmentResultName":"","AppointmentId":"334","CustomerName":"杨妮娜","appointUserName":"张学友","HeaderURL":"uploadFiles/uploadImgs/20180507/7400d515055d469f86ff36cd6c4fa501.jpg","AppointmentTypeId":"88","imageList":[],"CreateTime":"2018-05-10 13:02","ContactId":553,"AppointEndTime":"2018-05-11 12:50:00","ContactContent":"31231","Content":"","AppointmentResultId":""},{"AppointmentTypeName":"会籍预约","contactUserName":"张学友","AppointCreateTime":"2018-05-10","AppointStartTime":"2018-05-11\n\t\t11:50:00","AppointmentResultName":"","AppointmentId":"334","CustomerName":"杨妮娜","appointUserName":"张学友","HeaderURL":"uploadFiles/uploadImgs/20180507/7400d515055d469f86ff36cd6c4fa501.jpg","AppointmentTypeId":"88","imageList":[],"CreateTime":"2018-05-10 13:02","ContactId":552,"AppointEndTime":"2018-05-11 12:50:00","ContactContent":"123","Content":"","AppointmentResultId":""}],"appointInfo":{"AppointmentTypeName":"会籍预约","sTime":"11:50","CreateUserId":495,"eTime":"12:50","AppointmentResultName":"","AppointmentId":334,"TipStartTime":"","ttime":"","createName":"张学友","CustomerName":"杨妮娜","bgTime":"2018-05-11","AppointmentTypeId":88,"TipInterval":"","CustomerId":33628,"CreateTime":"2018-05-10","Content":"","editType":0,"Sex":"女","AppointmentResultId":""}}
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
         * contactList : [{"AppointmentTypeName":"会籍预约","contactUserName":"张学友","AppointCreateTime":"2018-05-10","AppointStartTime":"2018-05-11\n\t\t11:50:00","AppointmentResultName":"","AppointmentId":"334","CustomerName":"杨妮娜","appointUserName":"张学友","HeaderURL":"uploadFiles/uploadImgs/20180507/7400d515055d469f86ff36cd6c4fa501.jpg","AppointmentTypeId":"88","imageList":[],"CreateTime":"2018-05-10 13:02","ContactId":553,"AppointEndTime":"2018-05-11 12:50:00","ContactContent":"31231","Content":"","AppointmentResultId":""},{"AppointmentTypeName":"会籍预约","contactUserName":"张学友","AppointCreateTime":"2018-05-10","AppointStartTime":"2018-05-11\n\t\t11:50:00","AppointmentResultName":"","AppointmentId":"334","CustomerName":"杨妮娜","appointUserName":"张学友","HeaderURL":"uploadFiles/uploadImgs/20180507/7400d515055d469f86ff36cd6c4fa501.jpg","AppointmentTypeId":"88","imageList":[],"CreateTime":"2018-05-10 13:02","ContactId":552,"AppointEndTime":"2018-05-11 12:50:00","ContactContent":"123","Content":"","AppointmentResultId":""}]
         * appointInfo : {"AppointmentTypeName":"会籍预约","sTime":"11:50","CreateUserId":495,"eTime":"12:50","AppointmentResultName":"","AppointmentId":334,"TipStartTime":"","ttime":"","createName":"张学友","CustomerName":"杨妮娜","bgTime":"2018-05-11","AppointmentTypeId":88,"TipInterval":"","CustomerId":33628,"CreateTime":"2018-05-10","Content":"","editType":0,"Sex":"女","AppointmentResultId":""}
         */

        private AppointInfoBean appointInfo;
        private List<ContactListBean> contactList;

        public AppointInfoBean getAppointInfo() {
            return appointInfo;
        }

        public void setAppointInfo(AppointInfoBean appointInfo) {
            this.appointInfo = appointInfo;
        }

        public List<ContactListBean> getContactList() {
            return contactList;
        }

        public void setContactList(List<ContactListBean> contactList) {
            this.contactList = contactList;
        }

        public static class AppointInfoBean {
            /**
             * AppointmentTypeName : 会籍预约
             * sTime : 11:50
             * CreateUserId : 495
             * eTime : 12:50
             * AppointmentResultName :
             * AppointmentId : 334
             * TipStartTime :
             * ttime :
             * createName : 张学友
             * CustomerName : 杨妮娜
             * bgTime : 2018-05-11
             * AppointmentTypeId : 88
             * TipInterval :
             * CustomerId : 33628
             * CreateTime : 2018-05-10
             * Content :
             * editType : 0
             * Sex : 女
             * AppointmentResultId :
             */

            private String AppointmentTypeName;
            private String sTime;
            private int CreateUserId;
            private String eTime;
            private String AppointmentResultName;
            private int AppointmentId;
            private String TipStartTime;
            private String ttime;
            private String createName;
            private String CustomerName;
            private String bgTime;
            private int AppointmentTypeId;
            private String TipInterval;
            private int CustomerId;
            private String CreateTime;
            private String Content;
            private int editType;
            private String Sex;
            private String AppointmentResultId;

            public String getAppointmentTypeName() {
                return AppointmentTypeName;
            }

            public void setAppointmentTypeName(String AppointmentTypeName) {
                this.AppointmentTypeName = AppointmentTypeName;
            }

            public String getSTime() {
                return sTime;
            }

            public void setSTime(String sTime) {
                this.sTime = sTime;
            }

            public int getCreateUserId() {
                return CreateUserId;
            }

            public void setCreateUserId(int CreateUserId) {
                this.CreateUserId = CreateUserId;
            }

            public String getETime() {
                return eTime;
            }

            public void setETime(String eTime) {
                this.eTime = eTime;
            }

            public String getAppointmentResultName() {
                return AppointmentResultName;
            }

            public void setAppointmentResultName(String AppointmentResultName) {
                this.AppointmentResultName = AppointmentResultName;
            }

            public int getAppointmentId() {
                return AppointmentId;
            }

            public void setAppointmentId(int AppointmentId) {
                this.AppointmentId = AppointmentId;
            }

            public String getTipStartTime() {
                return TipStartTime;
            }

            public void setTipStartTime(String TipStartTime) {
                this.TipStartTime = TipStartTime;
            }

            public String getTtime() {
                return ttime;
            }

            public void setTtime(String ttime) {
                this.ttime = ttime;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public String getCustomerName() {
                return CustomerName;
            }

            public void setCustomerName(String CustomerName) {
                this.CustomerName = CustomerName;
            }

            public String getBgTime() {
                return bgTime;
            }

            public void setBgTime(String bgTime) {
                this.bgTime = bgTime;
            }

            public int getAppointmentTypeId() {
                return AppointmentTypeId;
            }

            public void setAppointmentTypeId(int AppointmentTypeId) {
                this.AppointmentTypeId = AppointmentTypeId;
            }

            public String getTipInterval() {
                return TipInterval;
            }

            public void setTipInterval(String TipInterval) {
                this.TipInterval = TipInterval;
            }

            public int getCustomerId() {
                return CustomerId;
            }

            public void setCustomerId(int CustomerId) {
                this.CustomerId = CustomerId;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public int getEditType() {
                return editType;
            }

            public void setEditType(int editType) {
                this.editType = editType;
            }

            public String getSex() {
                return Sex;
            }

            public void setSex(String Sex) {
                this.Sex = Sex;
            }

            public String getAppointmentResultId() {
                return AppointmentResultId;
            }

            public void setAppointmentResultId(String AppointmentResultId) {
                this.AppointmentResultId = AppointmentResultId;
            }
        }

        public static class ContactListBean {
            /**
             * AppointmentTypeName : 会籍预约
             * contactUserName : 张学友
             * AppointCreateTime : 2018-05-10
             * AppointStartTime : 2018-05-11
             11:50:00
             * AppointmentResultName :
             * AppointmentId : 334
             * CustomerName : 杨妮娜
             * appointUserName : 张学友
             * HeaderURL : uploadFiles/uploadImgs/20180507/7400d515055d469f86ff36cd6c4fa501.jpg
             * AppointmentTypeId : 88
             * imageList : []
             * CreateTime : 2018-05-10 13:02
             * ContactId : 553
             * AppointEndTime : 2018-05-11 12:50:00
             * ContactContent : 31231
             * Content :
             * AppointmentResultId :
             */

            private String AppointmentTypeName;
            private String contactUserName;
            private String AppointCreateTime;
            private String AppointStartTime;
            private String AppointmentResultName;
            private String AppointmentId;
            private String CustomerName;
            private String appointUserName;
            private String HeaderURL;
            private String AppointmentTypeId;
            private String CreateTime;
            private int ContactId;
            private String AppointEndTime;
            private String ContactContent;
            private String Content;
            private String AppointmentResultId;
            private List<?> imageList;

            public String getAppointmentTypeName() {
                return AppointmentTypeName;
            }

            public void setAppointmentTypeName(String AppointmentTypeName) {
                this.AppointmentTypeName = AppointmentTypeName;
            }

            public String getContactUserName() {
                return contactUserName;
            }

            public void setContactUserName(String contactUserName) {
                this.contactUserName = contactUserName;
            }

            public String getAppointCreateTime() {
                return AppointCreateTime;
            }

            public void setAppointCreateTime(String AppointCreateTime) {
                this.AppointCreateTime = AppointCreateTime;
            }

            public String getAppointStartTime() {
                return AppointStartTime;
            }

            public void setAppointStartTime(String AppointStartTime) {
                this.AppointStartTime = AppointStartTime;
            }

            public String getAppointmentResultName() {
                return AppointmentResultName;
            }

            public void setAppointmentResultName(String AppointmentResultName) {
                this.AppointmentResultName = AppointmentResultName;
            }

            public String getAppointmentId() {
                return AppointmentId;
            }

            public void setAppointmentId(String AppointmentId) {
                this.AppointmentId = AppointmentId;
            }

            public String getCustomerName() {
                return CustomerName;
            }

            public void setCustomerName(String CustomerName) {
                this.CustomerName = CustomerName;
            }

            public String getAppointUserName() {
                return appointUserName;
            }

            public void setAppointUserName(String appointUserName) {
                this.appointUserName = appointUserName;
            }

            public String getHeaderURL() {
                return HeaderURL;
            }

            public void setHeaderURL(String HeaderURL) {
                this.HeaderURL = HeaderURL;
            }

            public String getAppointmentTypeId() {
                return AppointmentTypeId;
            }

            public void setAppointmentTypeId(String AppointmentTypeId) {
                this.AppointmentTypeId = AppointmentTypeId;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public int getContactId() {
                return ContactId;
            }

            public void setContactId(int ContactId) {
                this.ContactId = ContactId;
            }

            public String getAppointEndTime() {
                return AppointEndTime;
            }

            public void setAppointEndTime(String AppointEndTime) {
                this.AppointEndTime = AppointEndTime;
            }

            public String getContactContent() {
                return ContactContent;
            }

            public void setContactContent(String ContactContent) {
                this.ContactContent = ContactContent;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public String getAppointmentResultId() {
                return AppointmentResultId;
            }

            public void setAppointmentResultId(String AppointmentResultId) {
                this.AppointmentResultId = AppointmentResultId;
            }

            public List<?> getImageList() {
                return imageList;
            }

            public void setImageList(List<?> imageList) {
                this.imageList = imageList;
            }
        }
    }
}
