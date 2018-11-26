package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.ActionBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainPositionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection.SiteSelectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.Constants.APPOINTMENTRESULTID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class TrainingPlanListTodayFragMent extends BaseFragment<TrainingPlanListTodayFragMentPresenter> implements TrainingPlanListTodayFragMentContract.View {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;

    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;


    @BindView(R.id.btn_null_Training_add)
    LinearLayout btnNullTrainingAdd;

    private Context context;
    private boolean TPDateN = false;
    private List<Integer> datasCount = new ArrayList<Integer>();
    private List<Integer> nullCount = new ArrayList<Integer>();
    private List<Integer> StepArr = new ArrayList<Integer>();
    private CommonAdapter.MultiItemTypeSupport<TrainingPlanBeanM.ListBean> mulitItem; // 多类型布局
    private CommonAdapter<TrainingPlanBeanM.ListBean> commonAdapter;
    public List<TrainingPlanBeanM.ListBean> datas = new ArrayList<TrainingPlanBeanM.ListBean>();
    private String refreshAdd = "88";
    public String MemberId;
    public String AppointmentId;
    public String LessonId;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_training_plan_list_today;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (TPDateN) {
                refresh();
            }
            //相当于Fragment的onResume
        } else {
            //相当于Fragment的onPause

        }
    }

    @Override
    protected void initData() {
        context = this.getActivity();
        datas = new ArrayList<>();
        InitList();
        refresh();
    }


    public void InitList() {

        mulitItem = new CommonAdapter.MultiItemTypeSupport<TrainingPlanBeanM.ListBean>() {
            @Override
            public int getItemViewType(int position, TrainingPlanBeanM.ListBean trainingPlanBeanM) {
                if (datas.get(position).getActionId().equals("")) {
                    return 3;
                } else {
                    if (datas.get(position).getName().equals("")) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }


            @Override
            public int getLayoutId(int itemType) {

                switch (itemType) {

                    case 1:
                        return R.layout.cardview_training_plan_list_top;

                    case 2:
                        return R.layout.cardview_training_plan_list_line;

                    case 3:
                        return R.layout.cardview_training_plan_list_null;

//                    case 4:
//                        return R.layout.card view_training_plan_add_plus;

                    default:

                        return -1;

                }
            }
        };


        commonAdapter = new CommonAdapter<TrainingPlanBeanM.ListBean>(0, context, datas, mulitItem) {
            @Override
            protected void convert(final ViewHolder holder, final TrainingPlanBeanM.ListBean listBean, final int position) {

                holder.itemView.setTag(position);

                if (!listBean.getName().equals("")) {
                    holder.setText(R.id.parts_text, listBean.getName());

                }

                if (listBean.getActionId().equals("")) {


                } else {
                    holder.setText(R.id.plan_text_content, listBean.getContent());
                    holder.getView(R.id.btn_selected).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (position < datas.size()) {

                                if ((!listBean.getName().equals("")) &&
                                        listBean.getPositionId().equals(datas.get(position + 1).getPositionId())) {
                                    datas.get(position + 1).setName(listBean.getName());
                                }


                            }

                            List<ActionBean.ListBean> list = new ArrayList<ActionBean.ListBean>();
                            Object Positionobject = SharedPreferenceUtil.get(TRAININGPLANKEY, datas.get(position).getPositionId());
                            if (Positionobject != null) {
                                list = (List<ActionBean.ListBean>) Positionobject;
                            }


                            if (list.size() > 0) {

                                for (int i = 0; i < list.size(); i++) {
                                    if (Objects.equals(list.get(i).getActionId(), datas.get(position).getActionId())) {
                                        list.get(i).setSelected(false);
                                        list.get(i).setGroupCount("");
                                        list.get(i).setAmount("");
                                    }
                                }
                            }
                            SharedPreferenceUtil.save(TRAININGPLANKEY, datas.get(position).getPositionId(), list);
                            datas.remove(position);
                            List<ActionBean.ListBean> resultlist = new ArrayList<ActionBean.ListBean>();
                            for (int i = 0; i < datas.size(); i++) {
                                if (!datas.get(i).getActionId().equals("")) {
                                    ActionBean.ListBean listBean1 = new ActionBean.ListBean();
                                    listBean1.setActionId(datas.get(i).getActionId());
                                    listBean1.setActionName(datas.get(i).getActionName());
                                    listBean1.setAmount(datas.get(i).getAmount());
                                    listBean1.setGroupCount(datas.get(i).getGroupCount());
                                    listBean1.setPositionId(datas.get(i).getPositionId());
                                    listBean1.setPositionName(datas.get(i).getPositionName());
                                    listBean1.setSelected(true);
                                    resultlist.add(listBean1);

                                }

                            }


//
                            SharedPreferenceUtil.save(TRAININGPLANKEY, "result", resultlist);
                            commonAdapter.notifyDataSetChanged();
//                        Toast.makeText(context, holder.itemView.getTag() + "", Toast.LENGTH_SHORT).show();

                        }
                    });
                }


            }


        };

        commonAdapter.setfootOnClickListener(new CommonAdapter.FootOnClickListener() {
            @Override
            public void OnClick() {
                TPDateN = false;
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
//               Intent intent=new Intent (mContext, TrainingPlanAddActivity.class);
                Intent intent = new Intent(mContext, SiteSelectionActivity.class);
                intent.putExtra(PUT_STR + "id", MemberId);
                intent.putExtra(PUT_STR + "AppointmentId", AppointmentId);
                intent.putExtra(PUT_STR + "LessonId", String.valueOf(LessonId));
                intent.putExtra(mStrType, REFRESHID);
                startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
            }

        });

        commonAdapter.setShowFooter(false);
        commonAdapter.setShowdiy(true);
        recyclerView.setAdapter(commonAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);

        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                refresh();

            }


        });
//        datas=resultToTraingPlanBean();
//        commonAdapter.notifyDataSetChanged();
        datas = resultToTraingPlanBean();
        commonAdapter.replaceData(datas);
    }


    @Override
    public void onResume() {
        super.onResume();
//
//        datas=resultToTraingPlanBean();
//        commonAdapter.notifyDataSetChanged();

    }

    @Override
    public void succeed1PostionList(TrainPositionDropListBean trainPositionDropListBean) {

        if (trainPositionDropListBean.getResult().size() > 0) {

//            for (int i=0 ;i<trainPositionDropListBean.getResult().size();i++){
//
//                SharedPreferenceUtil.remove(TRAININGPLANKEY,i+"");
//
//            }

        }


    }

    @Override
    public void succeed(TrainingPlanBean trainingPlanBean) {

        swipeRefreshLayout.setRefreshing(false);


        try {

            List<TrainingPlanBean.ResultBean> bean = new ArrayList<TrainingPlanBean.ResultBean>();

            bean = trainingPlanBean.getResult();

            for (int i = 0; i < bean.size(); i++) {

                for (int j = 0; j < bean.get(i).getList().size() + 1; j++) {

                    TrainingPlanBeanM.ListBean listBean = new TrainingPlanBeanM.ListBean();


                    Log.e(">>>", j + "-------" + bean.get(i).getList().size());


                    if (j == bean.get(i).getList().size()) {

                        listBean.setActionId("");

                        listBean.setName("");

                        listBean.setContent("");


//                        Log.e(">>>",i+"-------"+j);
                    } else {

                        if (j == 0) {


                            listBean.setActionId(i + "");

                            listBean.setName(bean.get(i).getName());

                            listBean.setContent(bean.get(i).getList().get(j).getContent());


                        } else {

                            listBean.setActionId(i + "");

                            listBean.setName("");

                            listBean.setContent(bean.get(i).getList().get(j).getContent());

                        }
//

//
                    }


                    datas.add(listBean);

                }


            }

//            datas = trainingPlanBean.getResult();


            if (datas.size() == 0) {

                recyclerView.setVisibility(View.VISIBLE);

                btnNullTrainingAdd.setVisibility(View.INVISIBLE);


            } else {


                recyclerView.setVisibility(View.INVISIBLE);

                btnNullTrainingAdd.setVisibility(View.VISIBLE);


            }
            commonAdapter.replaceData(datas);


        } catch (Exception e) {

            e.printStackTrace();

        }
        if (TPDateN) {
            refresh();
            TPDateN = false;
        }


    }

    public void refresh() {

        swipeRefreshLayout.setRefreshing(false);
//        mPresenter.get("a");
//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
//        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
//         mPresenter.getTrainPositionDropList(UserName, UserId, token, ClubId);
        datas = resultToTraingPlanBean();
        commonAdapter.replaceData(datas);
//        datas = resultToTraingPlanBean();
    }

    @Override
    public void showEmpty() {

    }


    @Override
    public void outLogin() {

        s(mContext, "您的帐号在其他设备登录");
        Intent intent = new Intent(context, LoginActivity.class);
        startActivity(intent);

    }


    @Override
    public void Loading() {

    }


    @OnClick(R.id.btn_null_Training_add)
    public void onViewClicked() {
        TPDateN = false;
        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
        Intent intent = new Intent(mContext, SiteSelectionActivity.class);
        intent.putExtra(PUT_STR + "id", MemberId);
        intent.putExtra(PUT_STR + "AppointmentId", AppointmentId);
        intent.putExtra(PUT_STR + "LessonId", String.valueOf(LessonId));
        intent.putExtra(mStrType, REFRESHID);
        startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
    }


    private List<TrainingPlanBeanM.ListBean> resultToTraingPlanBean() {

        List<ActionBean.ListBean> temp = new ArrayList<ActionBean.ListBean>();
        List<TrainingPlanBeanM.ListBean> resultBeen = new ArrayList<TrainingPlanBeanM.ListBean>();
        List<String> SiteArr = new ArrayList<String>();
        Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, "result");
        if (object != null) {
            temp = (List<ActionBean.ListBean>) object;
        }
        if (temp.size() > 0) {
            for (int i = 0; i < temp.size(); i++) {
                if (!SiteArr.contains(temp.get(i).getPositionId())) {
                    SiteArr.add(temp.get(i).getPositionId());
                }

            }
            for (int i = 0; i < SiteArr.size(); i++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (SiteArr.get(i).toString().equals(temp.get(j).getPositionId().toString())) {
                        TrainingPlanBeanM.ListBean listBean = new TrainingPlanBeanM.ListBean();
                        listBean.setName(temp.get(j).getPositionName());
                        listBean.setPositionId(temp.get(j).getPositionId());
                        listBean.setActionId(temp.get(j).getActionId());
                        listBean.setAmount(temp.get(j).getAmount());
                        listBean.setActionName(temp.get(j).getActionName());
                        listBean.setGroupCount(temp.get(j).getGroupCount());
                        listBean.setPositionName(temp.get(j).getPositionName());
                        listBean.setContent(temp.get(j).getActionName() + "(" + temp.get(j).getAmount() + "个 * " + temp.get(j).getGroupCount() + "组)");
                        if (resultBeen != null) {
                            if (j > 0) {
                                if (listBean.getPositionId().equals(temp.get(j - 1).getPositionId())) {
                                    listBean.setName("");
                                }
                            }
                        }
                        resultBeen.add(listBean);
                    }
                }
                TrainingPlanBeanM.ListBean nullBean = new TrainingPlanBeanM.ListBean();
                nullBean.setActionId("");
                nullBean.setName("");
                nullBean.setContent("");
                nullBean.setPositionId("");
                resultBeen.add(nullBean);
            }

        }
        if (resultBeen.size() == 0) {
            recyclerView.setVisibility(View.INVISIBLE);
            btnNullTrainingAdd.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            btnNullTrainingAdd.setVisibility(View.INVISIBLE);
        }
        return resultBeen;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        this.view_result.setText(data.getStringExtra("NewStringInIntent"));
        super.onActivityResult(requestCode, resultCode, data);

        String mId = "";
        String mName = "";
        String mTel = "";


        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }

            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {
                mId = bundle.getString(RESULT_ID);

            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == REFRESHID) {
//            datas = resultToTraingPlanBean();
            TPDateN = true;
            refresh();
        }

    }

}
