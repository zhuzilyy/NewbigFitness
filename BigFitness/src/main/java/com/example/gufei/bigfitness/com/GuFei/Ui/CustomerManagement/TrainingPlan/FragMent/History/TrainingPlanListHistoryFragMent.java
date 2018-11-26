package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.HistoryPlanBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.HistoryPlanListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.EndlessRecyclerOnScrollListener;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.TrainingPlanListCopyTodayListener;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.TraingingPlanUnits.resultToHistoryPlanBean;
import static com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.TraingingPlanUnits.resultToTraingPlanBean;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class TrainingPlanListHistoryFragMent extends BaseFragment<TrainingPlanListHistoryFragMentPresenter> implements TrainingPlanListHistoryFragMentContract.View {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;

    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.btn_copy)
    TextView btnCopy;
    @BindView(R.id.text_title)
    TextView textTitle;


//    private CommonAdapter.MultiItemTypeSupport<HistoryPlanBean.PlanInfoListBean> mulitItem; // 多类型布局

    private CommonAdapter<HistoryPlanBean.PlanInfoListBean> commonAdapter;


    private List<HistoryPlanBean.PlanInfoListBean> datas = new ArrayList<HistoryPlanBean.PlanInfoListBean>();
    private HistoryPlanListBean historyPlanListBean = new HistoryPlanListBean();

    public int UserId = 0;
    public TrainingPlanListCopyTodayListener trainingPlanListCopyTodayListener;
    public String token = "";
    public int ClubId = 0;
    public String MemberId = "";
    public String AppointmentId = "";
    public String LessonId = "";
    int page = 0;
    int selected = 10000;


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_training_plan_list_history;
    }


    @Override
    protected void initData() {

//        if (getArguments() != null) {
//            UserId = getArguments().getInt("UserId");
//            token = getArguments().getString("token");
//            ClubId = getArguments().getInt("ClubId");
//            MemberId = getArguments().getString("MemberId");
//            AppointmentId = getArguments().getString("AppointmentId");
//            LessonId = getArguments().getString("LessonId");
//        }
//
//        context = this.getActivity();


        datas = new ArrayList<>();


        commonAdapter = new CommonAdapter<HistoryPlanBean.PlanInfoListBean>(R.layout.cardview_training_plan_add_history, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final HistoryPlanBean.PlanInfoListBean listBean, final int position) {
                holder.itemView.setTag(position);

                holder.setText(R.id.plan_text_content, listBean.getContent());
                holder.getView(R.id.plan_text_content).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        textTitle.setText(listBean.getTime());
//                        selected = position;
                    }
                });
            }
        };
        commonAdapter.setShowFooter(false);
        commonAdapter.setShowdiy(false);
        recyclerView.setAdapter(commonAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        swipeRefreshLayout.setRefreshing(false);
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

        swipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                swipeRefreshLayout.setRefreshing(true);

            }
        });

        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        final int width = wm.getDefaultDisplay().getWidth();
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onScrollItem(int i) {
//                s(mContext,i+"");
                if (i > 0) {
                    textTitle.setText(datas.get(i - 1).getTime());
                    selected = i - 1;
                }
            }

            @Override
            public void onLoadMore() {

            }
        });

        refresh();
    }

    private void loading() {
        page++;
        mPresenter.getHistoryPlanList(UserId, token, ClubId, MemberId, AppointmentId, LessonId, page);
    }


    @Override
    public void succeed(HistoryPlanListBean historyPlanListBean) {
        this.historyPlanListBean = historyPlanListBean;
        swipeRefreshLayout.setRefreshing(false);
        if (datas.size() > 0)
            datas.clear();
        try {
            List<HistoryPlanListBean.ResultBean> bean = new ArrayList<HistoryPlanListBean.ResultBean>();
            bean = historyPlanListBean.getResult();
            for (int i = 0; i < bean.size(); i++) {
                HistoryPlanBean.PlanInfoListBean listBean = new HistoryPlanBean.PlanInfoListBean();
                listBean.setAppointmentId(bean.get(i).getAppointmentId());
                listBean.setTime(bean.get(i).getCreateTime());
                listBean.setContent(resultToHistoryPlanBean(bean.get(i).getPlanInfoList()));
                datas.add(listBean);

            }


            commonAdapter.replaceData(datas);
            if (datas.size() > 0) {
                textTitle.setText(datas.get(0).getTime());
                selected = 0;
            }


        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public void refresh() {

//
        page = 1;
        mPresenter.getHistoryPlanList(UserId, token, ClubId, MemberId, AppointmentId, LessonId, page);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {

        s(mContext, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);

    }


    @Override
    public void Loading() {

    }

    /**
     *
     */
    @OnClick(R.id.btn_copy)
    public void onViewClicked() {

        if (selected != 10000) {
            List<TrainingPlanBeanM.ListBean> PostJsonBeen = new ArrayList<TrainingPlanBeanM.ListBean>();
            List<HistoryPlanListBean.ResultBean.PlanInfoListBean> list = new ArrayList<HistoryPlanListBean.ResultBean.PlanInfoListBean>();
            list = this.historyPlanListBean.getResult().get(selected).getPlanInfoList();
            for (int i = 0; i < list.size(); i++) {

                TrainingPlanBeanM.ListBean bean = new TrainingPlanBeanM.ListBean();
                bean.setName(list.get(i).getActionName());
                bean.setActionName(list.get(i).getActionName());
                bean.setActionId(String.valueOf(list.get(i).getActionId()));
                bean.setPositionId(String.valueOf(list.get(i).getPositionId()));
                bean.setPositionName(list.get(i).getPositionName());
                bean.setContent(list.get(i).getActionName() +
                        "(" +
                        list.get(i).getAmount() +
                        "个 * " +
                        list.get(i).getGroupCount() + "组)");
                bean.setAmount(String.valueOf(list.get(i).getAmount()));

                bean.setGroupCount(String.valueOf(list.get(i).getGroupCount()));
//
                PostJsonBeen.add(bean);

            }

            resultToTraingPlanBean(PostJsonBeen);


            trainingPlanListCopyTodayListener.mScrollView();
        }


    }


}
