package com.example.gufei.bigfitness.com.GuFei.Model.Post;

import com.example.gufei.bigfitness.com.GuFei.Model.local.HistoryPlanListBean;

import java.util.List;

/**
 * Created by GuFei on 2018/5/2.
 */

public class HistoryPlanBean {

    private List<HistoryPlanListBean.ResultBean.PlanInfoListBean> PlanInfoList;
    public List<HistoryPlanListBean.ResultBean.PlanInfoListBean> getPlanInfoList() {
        return PlanInfoList;
    }

    public void setPlanInfoList(List<HistoryPlanListBean.ResultBean.PlanInfoListBean> PlanInfoList) {
        this.PlanInfoList = PlanInfoList;
    }

    public static class PlanInfoListBean {
        private String content;
        private int AppointmentId;
        private String Time;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int appointmentId) {
            AppointmentId = appointmentId;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }
    }

}
