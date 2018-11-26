package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.gufei.bigfitness.Presenter.MainAdapter;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.ActionBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History.TrainingPlanListHistoryFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today.TrainingPlanListTodayFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.TrainingPlanListCopyTodayListener;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.TraingingPlanUnits.resultToTraingPlanBean;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class TrainingPlanListActivity extends BaseActivity<TrainingPlanListActivityPresenter> implements TrainingPlanListActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.switch_today)
    Switch switchToday;
    @BindView(R.id.btn_complete)
    Button btnComplete;

    private List<Fragment> fragments = new ArrayList<>();
    private MainAdapter adapter;
    private List<Integer> datasCount = new ArrayList<Integer>();
    private List<Integer> nullCount = new ArrayList<Integer>();
    private List<Integer> StepArr = new ArrayList<Integer>();
    private CommonAdapter.MultiItemTypeSupport<TrainingPlanBeanM.ListBean> mulitItem; // 多类型布局
    private CommonAdapter<TrainingPlanBeanM.ListBean> commonAdapter;
    private List<TrainingPlanBeanM.ListBean> datas = new ArrayList<TrainingPlanBeanM.ListBean>();


    String MemberId = "";
    String AppointmentId = "";
    String lessonType = "";
    String CustomerName = "";
    String LessonId = "";
    String lessonTime = "";


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_training_plan_list;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("训练计划");
        Intent intent = getIntent();
        MemberId = intent.getStringExtra(PUT_STR + "id");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        LessonId = intent.getStringExtra(PUT_STR + "LessonId");
        lessonType = intent.getStringExtra(PUT_STR + "Type");
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        lessonTime = intent.getStringExtra(PUT_STR + "time");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        final TrainingPlanListTodayFragMent  trainingPlanListTodayFragMent=new TrainingPlanListTodayFragMent();
        trainingPlanListTodayFragMent.MemberId=MemberId;
        trainingPlanListTodayFragMent.AppointmentId=AppointmentId;
        trainingPlanListTodayFragMent.LessonId=LessonId;

        // 添加 Fragment
        fragments.add(trainingPlanListTodayFragMent);

        TrainingPlanListHistoryFragMent trainingPlanListHistoryFragMent = new TrainingPlanListHistoryFragMent();
//        Bundle args = new Bundle();
//        args.putInt("UserId", UserId);
//        args.putString("token", token);
//        args.putInt("ClubId", ClubId);
//        args.putString("MemberId", MemberId);
//        args.putString("AppointmentId", AppointmentId);
//        args.putString("LessonId", LessonId);


        trainingPlanListHistoryFragMent.UserId =UserId;
        trainingPlanListHistoryFragMent.token = token;
        trainingPlanListHistoryFragMent.ClubId =ClubId;
        trainingPlanListHistoryFragMent.MemberId = MemberId;
        trainingPlanListHistoryFragMent.AppointmentId = AppointmentId;
        trainingPlanListHistoryFragMent.LessonId = LessonId;
        trainingPlanListHistoryFragMent.trainingPlanListCopyTodayListener=new TrainingPlanListCopyTodayListener() {
            @Override
            public void mScrollView() {
                switchToday.setChecked(false);
                mViewPager.setCurrentItem(0);
            }
        };


        fragments.add(trainingPlanListHistoryFragMent);
        adapter = new MainAdapter(getSupportFragmentManager(), fragments, null);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(adapter);
        switchToday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //选中时 do some thing
//                    Toast.makeText(TrainingPlanListActivity.this, "enabled",  Toast.LENGTH_SHORT).show();
                    btnComplete.setVisibility(View.GONE);
                    mViewPager.setCurrentItem(1);
                } else {
                    //非选中时 do some thing
//                    Toast.makeText(TrainingPlanListActivity.this, "disabled", Toast.LENGTH_SHORT).show();
                    btnComplete.setVisibility(View.VISIBLE);
                    mViewPager.setCurrentItem(0);
                    trainingPlanListTodayFragMent.datas = resultToTraingPlanBean();
                    trainingPlanListTodayFragMent.refresh();

                }
            }
        });


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
                            if (resultBeen.size() > 0) {
                                if (temp.get(j).getPositionId() .equals( resultBeen.get(resultBeen.size() - 1).getPositionId())) {
                                    listBean.setName("");

                                }
//                            } else {
//                                if (temp.get(j).getPositionId() == datas.get(0).getPositionId()) {
//                                    listBean.setName("");
//
//                                }

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
//

        }

        return resultBeen;
    }

    @Override
    protected void initData() {
        refresh();

    }


    @Override
    public void succeed(TrainingPlanBean trainingPlanBean) {


    }

    public void refresh() {

        mPresenter.get("a");


    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
        s(this, "您的帐号在其他设备登录");

        Intent intent = new Intent(context, LoginActivity.class);
        remove();
        startActivity(intent);
        finish();

    }


    @Override
    public void Loading() {

    }


    @Override
    protected void onDestroy() {
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);
        super.onDestroy();
    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        finish();
    }
}
