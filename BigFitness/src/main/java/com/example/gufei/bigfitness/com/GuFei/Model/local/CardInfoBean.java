package com.example.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Description
 *
 * @author Song.gl
 * @version 2017 06 21 22:58
 */
public class CardInfoBean {


    /**
     * message :
     * result : {"BuyRemark":"","BargainNo":"56454","STATUS":"已开卡","MemberCardTypeName":"单年卡","CardBalance":"359天","MemberNameList":"","MemberCardId":134664,"ConsumeType":"时卡","BuyMoney":1000,"PayMoney":1000,"CreateUserName":"周杰伦","UseTime":"2018/04/29","ExpireTime":"2019/04/29","FixedUseTime":null,"BuyTime":"2018/04/29","MemberCardNo":"1564854","RemainLockedCount":2}
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
         * BuyRemark :
         * BargainNo : 56454
         * STATUS : 已开卡
         * MemberCardTypeName : 单年卡
         * CardBalance : 359天
         * MemberNameList :
         * MemberCardId : 134664
         * ConsumeType : 时卡
         * BuyMoney : 1000
         * PayMoney : 1000
         * CreateUserName : 周杰伦
         * UseTime : 2018/04/29
         * ExpireTime : 2019/04/29
         * FixedUseTime : null
         * BuyTime : 2018/04/29
         * MemberCardNo : 1564854
         * RemainLockedCount : 2
         */

        private String BuyRemark;
        private String BargainNo;
        private String STATUS;
        private String MemberCardTypeName;
        private String CardBalance;
        private String MemberNameList;
        private int MemberCardId;
        private String ConsumeType;
        private int BuyMoney;
        private int PayMoney;
        private String CreateUserName;
        private String UseTime;
        private String ExpireTime;
        private Object FixedUseTime;
        private String BuyTime;
        private String MemberCardNo;
        private int RemainLockedCount;

        public String getBuyRemark() {
            return BuyRemark;
        }

        public void setBuyRemark(String BuyRemark) {
            this.BuyRemark = BuyRemark;
        }

        public String getBargainNo() {
            return BargainNo;
        }

        public void setBargainNo(String BargainNo) {
            this.BargainNo = BargainNo;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getCardBalance() {
            return CardBalance;
        }

        public void setCardBalance(String CardBalance) {
            this.CardBalance = CardBalance;
        }

        public String getMemberNameList() {
            return MemberNameList;
        }

        public void setMemberNameList(String MemberNameList) {
            this.MemberNameList = MemberNameList;
        }

        public int getMemberCardId() {
            return MemberCardId;
        }

        public void setMemberCardId(int MemberCardId) {
            this.MemberCardId = MemberCardId;
        }

        public String getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(String ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public int getBuyMoney() {
            return BuyMoney;
        }

        public void setBuyMoney(int BuyMoney) {
            this.BuyMoney = BuyMoney;
        }

        public int getPayMoney() {
            return PayMoney;
        }

        public void setPayMoney(int PayMoney) {
            this.PayMoney = PayMoney;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getUseTime() {
            return UseTime;
        }

        public void setUseTime(String UseTime) {
            this.UseTime = UseTime;
        }

        public String getExpireTime() {
            return ExpireTime;
        }

        public void setExpireTime(String ExpireTime) {
            this.ExpireTime = ExpireTime;
        }

        public Object getFixedUseTime() {
            return FixedUseTime;
        }

        public void setFixedUseTime(Object FixedUseTime) {
            this.FixedUseTime = FixedUseTime;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public String getMemberCardNo() {
            return MemberCardNo;
        }

        public void setMemberCardNo(String MemberCardNo) {
            this.MemberCardNo = MemberCardNo;
        }

        public int getRemainLockedCount() {
            return RemainLockedCount;
        }

        public void setRemainLockedCount(int RemainLockedCount) {
            this.RemainLockedCount = RemainLockedCount;
        }
    }
}
