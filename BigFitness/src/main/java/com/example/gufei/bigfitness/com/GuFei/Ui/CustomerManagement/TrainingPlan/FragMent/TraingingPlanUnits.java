package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent;

import com.example.gufei.bigfitness.com.GuFei.Model.Post.ActionBean;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.TrainingPlanBeanPOST;
import com.example.gufei.bigfitness.com.GuFei.Model.local.HistoryPlanListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;

/**
 * Created by GuFei on 2018/5/1.
 */

public class TraingingPlanUnits {


    public static String resultToTraingPlanBean(List<TrainingPlanBeanM.ListBean> PostJsonBeen) {

        SharedPreferenceUtil.remove(TRAININGPLANKEY);
        SharedPreferenceUtil.clear();
        List<TrainingPlanBeanM.ListBean> resultBeen = new ArrayList<TrainingPlanBeanM.ListBean>();
        List<String> SiteArr = new ArrayList<String>();
        List<String> SiteNmaeArr = new ArrayList<String>();
        String resultStr = "";
        if (PostJsonBeen.size() > 0) {
            for (int i = 0; i < PostJsonBeen.size(); i++) {
                if (!SiteArr.contains(PostJsonBeen.get(i).getPositionId())) {
                    SiteArr.add(PostJsonBeen.get(i).getPositionId());
                    SiteNmaeArr.add(PostJsonBeen.get(i).getPositionName());
                }

            }
            for (int i = 0; i < SiteArr.size(); i++) {

                resultStr += (SiteNmaeArr.get(i) + "    ");

                for (int j = 0; j < PostJsonBeen.size(); j++) {

                    if (SiteArr.get(i).toString().equals(PostJsonBeen.get(j).getPositionId().toString())) {
                        TrainingPlanBeanM.ListBean listBean = new TrainingPlanBeanM.ListBean();
                        listBean.setName(PostJsonBeen.get(j).getActionName());
                        listBean.setPositionId(PostJsonBeen.get(j).getPositionId());
                        listBean.setActionId(PostJsonBeen.get(j).getActionId());
                        listBean.setGroupCount(PostJsonBeen.get(j).getGroupCount());
                        listBean.setPositionName(SiteNmaeArr.get(i));
                        listBean.setAmount(PostJsonBeen.get(j).getAmount());
                        listBean.setActionName(PostJsonBeen.get(j).getActionName());
                        listBean.setContent(PostJsonBeen.get(j).getActionName() + "(" + PostJsonBeen.get(j).getAmount() + "个 * " + PostJsonBeen.get(j).getGroupCount() + "组)");
                        String nullstr = "";
                        if (PostJsonBeen != null) {
                            if (j > 0) {
                                if (PostJsonBeen.get(j).getPositionId() .equals(PostJsonBeen.get(j - 1).getPositionId())) {
                                    listBean.setName("");
                                    nullstr = "    " + "        ";
                                }
                            }
                        }


                        resultStr += (nullstr + listBean.getContent() + "\n");
                        resultBeen.add(listBean);
                    }

                }
                resultStr += "\n";


            }
            List<ActionBean.ListBean> list = new ArrayList<ActionBean.ListBean>();
            if (PostJsonBeen.size() > 0) {
                for (int i = 0; i < PostJsonBeen.size(); i++) {
                    ActionBean.ListBean listBean = new ActionBean.ListBean();
                    if (!SiteArr.contains(PostJsonBeen.get(i).getPositionId())) {
                        SiteArr.add(PostJsonBeen.get(i).getPositionId());
                    }
                    listBean.setAmount(PostJsonBeen.get(i).getAmount());
                    listBean.setGroupCount(PostJsonBeen.get(i).getGroupCount());
                    listBean.setSelected(true);
                    listBean.setPositionName(PostJsonBeen.get(i).getPositionName());
                    listBean.setActionName(PostJsonBeen.get(i).getActionName());
                    listBean.setPositionId(PostJsonBeen.get(i).getPositionId());
                    listBean.setActionId(PostJsonBeen.get(i).getActionId());
                    list.add(listBean);
                }
                for (int j = 0; j < SiteArr.size(); j++) {
                    List<ActionBean.ListBean> list1 = new ArrayList<ActionBean.ListBean>();

                    for (int i = 0; i < PostJsonBeen.size(); i++) {
                        if (PostJsonBeen.get(i).getPositionId().equals(SiteArr.get(j).toString())) {
                            ActionBean.ListBean listBean = new ActionBean.ListBean();
                            listBean.setAmount(PostJsonBeen.get(i).getAmount());
                            listBean.setGroupCount(PostJsonBeen.get(i).getGroupCount());
                            listBean.setSelected(true);
                            listBean.setPositionName(PostJsonBeen.get(i).getPositionName());
                            listBean.setActionName(PostJsonBeen.get(i).getActionName());
                            listBean.setPositionId(PostJsonBeen.get(i).getPositionId());
                            listBean.setActionId(PostJsonBeen.get(i).getActionId());
                            listBean.setSelected(true);
                            list1.add(listBean);
                        }
                    }
                    SharedPreferenceUtil.save(TRAININGPLANKEY, SiteArr.get(j).toString(), list1);

                }


            }
            SharedPreferenceUtil.save(TRAININGPLANKEY, "result", list);

        }

        return resultStr;


    }

    public static String resultToHistoryPlanBean(List<HistoryPlanListBean.ResultBean.PlanInfoListBean> HistoryJsonBeen) {

        List<HistoryPlanListBean.ResultBean.PlanInfoListBean> resultBeen = new ArrayList<HistoryPlanListBean.ResultBean.PlanInfoListBean>();
        List<Integer> SiteArr = new ArrayList<Integer>();
        List<String> SiteNmaeArr = new ArrayList<String>();
        String resultStr = "";
        if (HistoryJsonBeen.size() > 0) {
            for (int i = 0; i < HistoryJsonBeen.size(); i++) {
                if (!SiteArr.contains(HistoryJsonBeen.get(i).getPositionId())) {
                    SiteArr.add(HistoryJsonBeen.get(i).getPositionId());
                    SiteNmaeArr.add(HistoryJsonBeen.get(i).getPositionName());
                }

            }
            for (int i = 0; i < SiteArr.size(); i++) {

                resultStr += (SiteNmaeArr.get(i) + "\n");

                for (int j = 0; j < HistoryJsonBeen.size(); j++) {

                    if (SiteArr.get(i) == HistoryJsonBeen.get(j).getPositionId()) {
                        HistoryPlanListBean.ResultBean.PlanInfoListBean listBean = new HistoryPlanListBean.ResultBean.PlanInfoListBean();
                        listBean.setPositionId(HistoryJsonBeen.get(j).getPositionId());
                        listBean.setActionId(HistoryJsonBeen.get(j).getActionId());
                        listBean.setGroupCount(HistoryJsonBeen.get(j).getGroupCount());
                        listBean.setPositionName(SiteNmaeArr.get(i));
                        listBean.setAmount(HistoryJsonBeen.get(j).getAmount());
                        listBean.setActionName(HistoryJsonBeen.get(j).getActionName());
                        listBean.setContent(HistoryJsonBeen.get(j).getActionName() + "(" + HistoryJsonBeen.get(j).getAmount() + "个 * " + HistoryJsonBeen.get(j).getGroupCount() + "组)");
                        if (HistoryJsonBeen != null) {
                            if (j > 0) {
                                if (HistoryJsonBeen.get(j).getPositionId() == HistoryJsonBeen.get(j- 1).getPositionId()) {
                                    listBean.setPositionName("");
                                }
                            }
                        }

//                        String nullstr = "";
//                        if (!listBean.getPositionName().toString().equals("")) {
//                              nullstr = "\n";
//                        }else{
                        String nullstr = "      ";
//                        }
                        resultStr += nullstr + listBean.getContent() + "\n";
                        resultBeen.add(listBean);
                    }
                }


                resultStr += "\n";
            }


//
        }

        return resultStr;


    }

    public static String ReadEditTraingPlanBean() {

        List<ActionBean.ListBean> PostJsonBeen = new ArrayList<ActionBean.ListBean>();
        Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, "result");
        if (object != null) {
            PostJsonBeen = (List<ActionBean.ListBean>) object;
        }
        List<String> SiteArr = new ArrayList<String>();
        List<String> SiteNmaeArr = new ArrayList<String>();
        String resultStr = "";
        if (PostJsonBeen.size() > 0) {
            for (int i = 0; i < PostJsonBeen.size(); i++) {
                if (!SiteArr.contains(PostJsonBeen.get(i).getPositionId())) {
                    SiteArr.add(PostJsonBeen.get(i).getPositionId());
                    SiteNmaeArr.add(PostJsonBeen.get(i).getPositionName());
                }

            }
            for (int i = 0; i < SiteArr.size(); i++) {
                resultStr += SiteNmaeArr.get(i);
                for (int j = 0; j < PostJsonBeen.size(); j++) {
                    PostJsonBeen.get(j).setFirst(true);
                    if (SiteArr.get(i).equals(PostJsonBeen.get(j).getPositionId())) {

                            if (j > 0) {
                                if (!PostJsonBeen.get(j - 1).getPositionName().equals("")) {
                                    if (PostJsonBeen.get(j).getPositionId() .equals(PostJsonBeen.get(j - 1).getPositionId())) {
                                        PostJsonBeen.get(j).setPositionName("");
//                                        PostJsonBeen.get(j).setFirst(false);
                                    }
                                }
                            }

                        String nullstr = "  ";

//
                        if (PostJsonBeen.get(j).getPositionName().toString().equals("")) {
//
                            nullstr = "          ";
//
                        }

                        resultStr += nullstr +  PostJsonBeen.get(j).getActionName() + "(" + PostJsonBeen.get(j).getAmount() + "个 * " + PostJsonBeen.get(j).getGroupCount() + "组)" + "\n";

                    }
                }
                  resultStr += "\n";

            }

        }
        return resultStr;


    }

    public static List<TrainingPlanBeanPOST.ListBean> ReadPostTraingPlanBean() {

        List<TrainingPlanBeanPOST.ListBean> PostJsonBeen = new ArrayList<TrainingPlanBeanPOST.ListBean>();
        List<ActionBean.ListBean> JsonBeen = new ArrayList<ActionBean.ListBean>();
        Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, "result");
        if (object != null) {
            JsonBeen = (List<ActionBean.ListBean>) object;
        }
//        List<String> SiteArr = new ArrayList<String>();
//        List<String> SiteNmaeArr = new ArrayList<String>();
//        String resultStr = "";
        if (JsonBeen.size() > 0) {
            for (int i = 0; i < JsonBeen.size(); i++) {

                TrainingPlanBeanPOST.ListBean listBean = new TrainingPlanBeanPOST.ListBean();
                listBean.setActionId(Integer.parseInt(JsonBeen.get(i).getActionId()));
                listBean.setActionName(JsonBeen.get(i).getActionName());
                listBean.setAmount(Integer.parseInt(JsonBeen.get(i).getAmount()));
                listBean.setGroupCount(Integer.parseInt(JsonBeen.get(i).getGroupCount()));
                listBean.setPositionId(Integer.parseInt(JsonBeen.get(i).getPositionId()));
                listBean.setPositionName(JsonBeen.get(i).getPositionName());
//                listBean.setName(JsonBeen.get(i).getActionName());
                PostJsonBeen.add(listBean);

            }
        }
        return PostJsonBeen;


    }
}
