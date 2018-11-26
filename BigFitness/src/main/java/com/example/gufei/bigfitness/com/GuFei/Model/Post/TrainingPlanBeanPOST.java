package com.example.gufei.bigfitness.com.GuFei.Model.Post;

import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;

import java.util.List;

/**
 * Created by GuFei on 2018/5/2.
 */

public class TrainingPlanBeanPOST {

    private List<TrainingPlanBeanM.ListBean> list;

    public List<TrainingPlanBeanM.ListBean> getList() {
        return list;
    }

    public void setList(List<TrainingPlanBeanM.ListBean> list) {
        this.list = list;
    }

    public static class ListBean {


        /**
         * name : 胸部
         * content : 0哑铃仰卧飞鸟(4组*10)0
         */

        private int PositionId;
        public String getPositionName() {
            return PositionName;
        }
        public void setPositionName(String positionName) {
            PositionName = positionName;
        }
        private String PositionName;
        private int ActionId;
//        private String name;
//        private String content;
        private String ActionName;
        private int GroupCount;
        private int Amount;

        public String getActionName() {
            return ActionName;
        }
        public void setActionName(String actionName) {
            ActionName = actionName;
        }
        public int getGroupCount() {
            return GroupCount;
        }
        public void setGroupCount(int groupCount) {
            GroupCount = groupCount;
        }
        public int getAmount() {
            return Amount;
        }
        public void setAmount(int amount) {
            Amount = amount;
        }







        public int getPositionId() {
            return PositionId;
        }

        public void setPositionId(int PositionId) {
            this. PositionId = PositionId;
        }

//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }

        public int getActionId() {
            return ActionId;
        }

        public void setActionId(int ActionId) {
            this.ActionId = ActionId;
        }
    }
}
