package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;
import com.example.gufei.bigfitness.util.SpUtil;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.APPOINTMENTRESULTID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
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
import static com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.TraingingPlanUnits.resultToTraingPlanBean;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class ReservationRecordScheduleActivity extends BaseActivity<ReservationRecordScheduleActivityPresenter> implements ReservationRecordScheduleActivityContract.View {


    @BindView(R.id.btn_add_reservation)
    Button btnAddReservation;
    @BindView(R.id.bottom_layout)
    LinearLayout bottomLayout;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.main_head_layout)
    RelativeLayout mainHeadLayout;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.text_user_name)
    EditText textUserName;
    @BindView(R.id.appointment_type_text)
    EditText appointmentTypeText;
    @BindView(R.id.img_appointment_time_begin)
    ImageView imgAppointmentTimeBegin;
    @BindView(R.id.text_appointment_time_begin)
    TextView textAppointmentTimeBegin;
    @BindView(R.id.img_appointment_time_end)
    ImageView imgAppointmentTimeEnd;
    @BindView(R.id.text_appointment_time_end)
    TextView textAppointmentTimeEnd;
    @BindView(R.id.img_appointment)
    ImageView imgAppointment;
    @BindView(R.id.user_results_text)
    TextView userResultsText;
    @BindView(R.id.text_results)
    TextView textResults;
    @BindView(R.id.btn_appointment)
    RelativeLayout btnAppointment;
    @BindView(R.id.btn_remind_time)
    ImageView btnRemindTime;
    @BindView(R.id.text_remind_time)
    TextView textRemindTime;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.text_remind_interval_time)
    EditText textRemindIntervalTime;
    @BindView(R.id.layout_time)
    RelativeLayout layoutTime;
    @BindView(R.id.id_layout_time)
    LinearLayout idLayoutTime;
    @BindView(R.id.training_plan)
    TextView trainingPlan;
    @BindView(R.id.training_plan_img)
    ImageView trainingPlanImg;
    @BindView(R.id.btn_training_plan)
    RelativeLayout btnTrainingPlan;
    @BindView(R.id.text_training_plan)
    TextView textTrainingPlan;
    @BindView(R.id.layout_training_plan)
    LinearLayout layoutTrainingPlan;
    @BindView(R.id.details_note_text)
    TextView detailsNoteText;
    @BindView(R.id.text_details_note)
    EditText textDetailsNote;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.activity_address_details)
    RelativeLayout activityAddressDetails;
    private TimePickerView pvCustomTime;


    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerSex = "";
    private String CustomerId = "";
    private String CreateUserId = "";
    private String AppointmentId = "";
    private String AppointmentTypeId = "";
    private String resultsId = "";
    private int MemberType;
    private String memberId = "";

    private String resultsName = "";
    private int EditType;
    PostCustomerListBean mPostCustomerListBean;
    private CommonAdapter<AppointmentByIdForMemberBean.ResultBean.ContactListBean> commonAdapter;

    private List<AppointmentByIdForMemberBean.ResultBean.ContactListBean> datas = new ArrayList<AppointmentByIdForMemberBean.ResultBean.ContactListBean>();

    List<TrainingPlanBeanM.ListBean> PostJsonBeen = new ArrayList<TrainingPlanBeanM.ListBean>();


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_booking__member_details;
    }

    @Override
    protected void initView() {
        mPostCustomerListBean = new PostCustomerListBean();
//        toolbar.setNavigationIcon(R.mipmap.left);
//        setToolBar(toolbar, "");
        mainTitle.setText("预约详情");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        Intent intent = getIntent();
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        AppointmentTypeId = intent.getStringExtra(PUT_STR + "AppointmentType");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");
        memberId = intent.getStringExtra(PUT_STR + "memberId");
        CreateUserId = intent.getStringExtra(PUT_STR + "CreateUserId");
        MemberType = intent.getIntExtra(PUT_STR + "CreateUserId", 99);

        switch (MemberType) {
            case 0:
                userName.setText("非私教会员");
                break;
            case 1:
                userName.setText("私教会员");
                break;
            case 2:
                userName.setText("非会员");
                break;
            case 3:
                userName.setText("客户");
                break;
        }

//        if (!CreateUserId==null) {
//            if (!CreateUserId.equals(String.valueOf(UserId))) {
//                btnEdit.setVisibility(View.INVISIBLE);
//            }
//        }
        textUserName.setText(CustomerName);
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<AppointmentByIdForMemberBean.ResultBean.ContactListBean>(R.layout.cardview_booking_details, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final AppointmentByIdForMemberBean.ResultBean.ContactListBean listBean, int i) {
                holder.setText(R.id.text_user_name, listBean.getAppointUserName());//名称
//                holder.setText(R.id.text_content, "内容：" + listBean.getContent());//内容
                holder.setText(R.id.text_content, "内容：" + listBean.getContactContent());//内容
                holder.setText(R.id.text_time, listBean.getCreateTime());//时间

//                loadIntoUseFitWidth(context, listBean.getHeardimg(), R.mipmap.head_img, holder.setImage(R.id.head_img_iv));//头像
//
                if (listBean.getImageList().size() > 0) {
                    for (int j = 0; j < (listBean.getImageList().size() > 5 ? 5 : listBean.getImageList().size()); j++) {
                        try {
                            ImageView iv = holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null));
                            loadIntoUseFitWidth(context, listBean.getImageList().get(j).getImageurl(), R.mipmap.null_img, iv);
//                            holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null)).setVisibility(View.VISIBLE);
                            iv.setVisibility(View.VISIBLE);
                            final Intent intent = new Intent(ReservationRecordScheduleActivity.this, ImageActivity.class);
                            intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", listBean.getImageList().get(j).getImageurl() + "");
                            iv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(intent);
                                }
                            });
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }


                    }


                }else{

                }

            }
        };

        recyclerView.setAdapter(commonAdapter);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
//
//        //设置进度条的颜色
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
//
//
//        //设置进度条的大小样式
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
//
//
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//
//            @Override
//            public void onRefresh() {
//
//                refresh();
//
//            }
//
//
//        });
//
//        swipeRefreshLayout.post(new Runnable() {
//
//            @Override
//            public void run() {
//
//                swipeRefreshLayout.setRefreshing(true);
//                commonAdapter.setShowFooter(false);
//            }
//        })
        commonAdapter.setShowFooter(false);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {


            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            //添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    super.onScrolled(recyclerView, dx, dy);

                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;

                    //最后条数的位置
                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();


//                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
//
//                        isLoadingMore = false;
//
//                        loading();
//
//                    }
                }
            });

        }


    }

    @Override
    protected void initData() {
        refresh();
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
    public void succeed(final AppointmentByIdForMemberBean appointmentByIdForMemberBean) {

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
 /*       if (!CreateUserId.equals(String.valueOf(UserId)) && !CreateUserId==null) {
            btnEdit.setVisibility(View.INVISIBLE);
        }
*/

        try {

            if (appointmentByIdForMemberBean.getResult().getAppointInfo().getAppointmentTypeName().equals("上课预约")) {
                layoutTrainingPlan.setVisibility(View.VISIBLE);
            } else {
                layoutTrainingPlan.setVisibility(View.GONE);
            }


            for (int i = 0; i < appointmentByIdForMemberBean.getResult().getTrainPlanList().size(); i++) {

                TrainingPlanBeanM.ListBean bean = new TrainingPlanBeanM.ListBean();
                bean.setName(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getActionName());
                bean.setActionName(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getActionName());
                bean.setActionId(String.valueOf(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getActionId()));
                bean.setPositionId(String.valueOf(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getPositionId()));
                bean.setPositionName(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getPositionName());
                bean.setContent(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getActionName() +
                        "(" +
                        appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getAmount() +
                        "个 * " +
                        appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getGroupCount() + "组)");
                bean.setAmount(String.valueOf(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getAmount()));
                bean.setGroupCount(String.valueOf(appointmentByIdForMemberBean.getResult().getTrainPlanList().get(i).getGroupCount()));
                PostJsonBeen.add(bean);

            }
            textTrainingPlan.setText(resultToTraingPlanBean(PostJsonBeen));
//            PostJsonBeen=appointmentByIdForMemberBean.getResult().getTrainPlanList();

            btnEdit.setText("编辑");
            btnEdit.setVisibility(View.VISIBLE);
            btnAppointment.setVisibility(View.VISIBLE);

            EditType = appointmentByIdForMemberBean.getResult().getAppointInfo().getEditType();

            if (EditType == 0) {
                btnRemindTime.setVisibility(View.VISIBLE);
                idLayoutTime.setVisibility(View.VISIBLE);

                layoutTime.setEnabled(true);
            } else {
                btnRemindTime.setVisibility(View.INVISIBLE);
                idLayoutTime.setVisibility(View.GONE);
                layoutTime.setEnabled(false);

            }


            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                    int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                    int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                    if (EditType == 0) {
                        if (btnEdit.getText().equals("完成")) {
                            mPresenter.saveAppointmentResultForMember(UserId, token, ClubId, UserName, AppointmentId, resultsId, appointmentByIdForMemberBean.getResult().getAppointInfo().getAppointmentResultId());
                            btnEdit.setText("编辑");
                        } else {
                            btnEdit.setText("完成");
                            appointmentTypeText.setEnabled(true);
                            appointmentTypeText.setEnabled(true);
                            textAppointmentTimeBegin.setEnabled(true);
                            textAppointmentTimeEnd.setEnabled(true);
                            textDetailsNote.setEnabled(true);
                            btnAppointment.setEnabled(true);

                        }

                    } else {
                        if (btnEdit.getText().equals("完成")) {
                            mPresenter.saveMemberAppiontment(UserName,
                                    UserId,
                                    token,
                                    ClubId,
                                    appointmentByIdForMemberBean.getResult().getAppointInfo().getAppointmentTypeName().equals("上课预约") ? "2" : "1",
                                    String.valueOf(appointmentByIdForMemberBean.getResult().getAppointInfo().getAppointmentTypeId()),
                                    detailsNoteText.getText().toString(),
                                    CustomerId,
                                    textAppointmentTimeEnd.getText().toString(),
                                    textAppointmentTimeBegin.getText().toString(),
                                    textRemindIntervalTime.getText().toString(),
                                    textRemindTime.getText().toString(),
                                    String.valueOf(appointmentByIdForMemberBean.getResult().getAppointInfo().getLessonId()),
                                    new Gson().toJson(PostJsonBeen),
                                    "",
                                    AppointmentId);

// TODO: 2017/7/1 修改提交未完成
//                            mPresenter.appAddCustomerAppoint(UserName,
//                                    UserId,
//                                    token,
//                                    ClubId,
//                                    String.valueOf(appointmentByIdForMemberBean.getResult().getAppointInfo().getAppointmentTypeId()),
//                                    textDetailsNote.getText().toString(),
//                                    CustomerId,
//                                    textAppointmentTimeEnd.getText().toString(),
//                                    textAppointmentTimeBegin.getText().toString(),
//                                    textRemindIntervalTime.getText().toString(),
//                                    textRemindTime.getText().toString(),
//                                    String.valueOf(appointmentByIdForMemberBean.getResult().getAppointInfo().getAppointmentId()));
                            btnEdit.setText("编辑");


                        } else {
                            btnEdit.setText("完成");
//                            btnAppointment.setVisibility(View.GONE);
                            textDetailsNote.setEnabled(true);


                        }

                    }
                }
            });

// TODO: 2017/6/24 返回信息错误`暂时不对datas赋值
//            datas = appointmentByIdForMemberBean.getResult().getContactList();

            commonAdapter.replaceData(datas);


        } catch (
                Exception e)

        {

            e.printStackTrace();

        }

    }

    @Override
    public void savesucceed(CodeBean codeBean) {

        if (codeBean.getCode() == 0) {


            s(this, "修改成功");

        }


    }

//    private List<TrainingPlanBeanM.ListBean> resultToTraingPlanBean() {
//        SharedPreferenceUtil.clear();
////        List<ActionBean.ListBean> temp = new ArrayList<ActionBean.ListBean>();
//
//        List<TrainingPlanBeanM.ListBean> resultBeen = new ArrayList<TrainingPlanBeanM.ListBean>();
//
//        List<String> SiteArr = new ArrayList<String>();
//
//        List<String> SiteNmaeArr = new ArrayList<String>();
//
//        String resultStr = "";
//
//        Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, "result");
//
////        if (object != null) {
////            temp = (List<ActionBean.ListBean>) object;
////        }
//
//
//
//        if (PostJsonBeen.size() > 0) {
//            for (int i = 0; i < PostJsonBeen.size(); i++) {
//
//                if (!SiteArr.contains(PostJsonBeen.get(i).getPositionId())) {
//                    SiteArr.add(PostJsonBeen.get(i).getPositionId());
//                    SiteNmaeArr.add(PostJsonBeen.get(i).getPositionName());
//                }
//
//            }
//
//            for (int i = 0; i < SiteArr.size(); i++) {
//
//                resultStr += SiteNmaeArr.get(i);
//
//                for (int j = 0; j < PostJsonBeen.size(); j++) {
//
//                    if (SiteArr.get(i).toString().equals(PostJsonBeen.get(j).getPositionId().toString())) {
//
//                        TrainingPlanBeanM.ListBean listBean = new TrainingPlanBeanM.ListBean();
//                        listBean.setName(PostJsonBeen.get(j).getActionName());
//                        listBean.setPositionId(PostJsonBeen.get(j).getPositionId());
//                        listBean.setActionId(PostJsonBeen.get(j).getActionId());
//                        listBean.setGroupCount(PostJsonBeen.get(j).getGroupCount());
//                        listBean.setPositionName(SiteNmaeArr.get(i));
//                        listBean.setAmount(PostJsonBeen.get(j).getAmount());
//                        listBean.setActionName(PostJsonBeen.get(j).getActionName());
//                        listBean.setContent(PostJsonBeen.get(j).getActionName() + "(" + PostJsonBeen.get(j).getAmount() + "个 * " + PostJsonBeen.get(j).getGroupCount() + "组)");
//
//                        if (resultBeen != null) {
//                            if (resultBeen.size() > 0) {
//                                if (PostJsonBeen.get(j).getPositionId() == resultBeen.get(resultBeen.size() - 1).getPositionId()) {
//                                    listBean.setName("");
//                                }
//
//                            }
//                        }
//
//                        String nullstr = "  ";
//
////
//                        if (listBean.getName().toString().equals("")) {
////
//                            nullstr = "          ";
////
//                        }
//
//                        resultStr += nullstr + listBean.getContent() + "\n";
//                        resultBeen.add(listBean);
//                    }
//                }
//                resultStr += "\n";
//                textTrainingPlan.setText(resultStr);
////                TrainingPlanBeanM.ListBean nullBean = new TrainingPlanBeanM.ListBean();
////                nullBean.setActionId("");
////                nullBean.setName("");
////                nullBean.setContent("");
////                nullBean.setPositionId("");
////                resultBeen.add(nullBean);
//
//
//            }
////
//
//        }
//
//        return resultBeen;
//    }

    public void refresh() {


        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        mPresenter.getAppointmentByIdForMember(UserId, token, ClubId, AppointmentId, AppointmentTypeId, CustomerId);


    }


    private void initCustomTimePicker(final TextView view, String title) {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调

                view.setText(getDataTime(date));

                switch (view.getId()) {

                    case R.id.first_time_begin:

                        mPostCustomerListBean.setStartLastContactTime(getDataTime(date));

                        break;
                    case R.id.first_time_end:

                        mPostCustomerListBean.setEndLastContactTime(getDataTime(date));

                        break;
                    case R.id.second_time_begin:

                        mPostCustomerListBean.setStartCreateTime(getDataTime(date));

                        break;
                    case R.id.second_time_end:

                        mPostCustomerListBean.setEndCreateTime(getDataTime(date));

                        break;
                }
                pvCustomTime.dismiss();
            }
        })

                .setDate(selectedDate)
                .isDialog(true)
                .setTitleText(title)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        TextView ivClear = (TextView) v.findViewById(R.id.iv_clear);
                        ivClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                switch (view.getId()) {

                                    case R.id.first_time_begin:
                                        view.setText("开始时间");
                                        mPostCustomerListBean.setStartLastContactTime("");

                                        break;
                                    case R.id.first_time_end:
                                        view.setText("结束时间");
                                        mPostCustomerListBean.setEndLastContactTime("");

                                        break;
                                    case R.id.second_time_begin:
                                        view.setText("开始时间");
                                        mPostCustomerListBean.setStartCreateTime("");

                                        break;
                                    case R.id.second_time_end:
                                        view.setText("结束时间");
                                        mPostCustomerListBean.setEndCreateTime("");

                                        break;


                                }
                                pvCustomTime.dismiss();
                            }
                        });
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.nullcoloer)
                .build();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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

                mName = bundle.getString(RESULT_STRING);

                mTel = bundle.getString(RESULT_TEL);


            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == APPOINTMENTRESULTID) {

            resultsId = mId;
            textResults.setText(mName);
            resultsName = mName;

        }
//
        if (requestCode == REFRESHID) {
            refresh();
        }


    }


    @OnClick({R.id.btn_add_reservation, R.id.btn_back, R.id.btn_edit, R.id.img_appointment_time_begin, R.id.img_appointment_time_end, R.id.img_appointment, R.id.btn_appointment, R.id.btn_remind_time, R.id.btn_training_plan})
    public void onViewClicked(View view) {

        final Intent intent =
                new Intent(ReservationRecordScheduleActivity.this, FilterListActivity.class);


        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";

        switch (view.getId()) {
            case R.id.btn_add_reservation:
                Intent AddFollow = new Intent(context, AddMembersFollowActivity.class);

                AddFollow.putExtra(PUT_STR + "Id", CustomerId);
                AddFollow.putExtra(PUT_STR + "memberId", memberId);
                AddFollow.putExtra(PUT_STR + "Name", CustomerName);
                AddFollow.putExtra(PUT_STR + "Type", CustomerType);
                AddFollow.putExtra(PUT_STR + "Sex", CustomerSex);
                AddFollow.putExtra(PUT_STR + "AppointmentId", AppointmentId);
                AddFollow.putExtra(mStrType, REFRESHID);
                startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                break;
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn_remind_time:

                initCustomTimePicker((TextView) findViewById(R.id.text_remind_time), "");
                pvCustomTime.show();

                break;
            case R.id.btn_edit:

//                AddFollowActivity
                break;
            case R.id.btn_appointment:
                if (EditType == 1 && imgAppointment.getVisibility()==View.VISIBLE) {
                    intent.putExtra(mStrType, APPOINTMENTRESULTID);

                    intent.putExtra(PUT_STR + "id", AppointmentTypeId);

                    startActivityForResult(intent, APPOINTMENTRESULTID);//使用时需定义变量requestCode

                }
//                AddFollowActivity
                break;

            case R.id.img_appointment_time_begin:
                initCustomTimePicker((TextView) findViewById(R.id.text_appointment_time_begin), "");
                pvCustomTime.show();
                break;
            case R.id.img_appointment_time_end:
                initCustomTimePicker((TextView) findViewById(R.id.text_appointment_time_end), "");
                pvCustomTime.show();
                break;
            case R.id.img_appointment:
                break;
            case R.id.btn_training_plan:
                break;
        }
    }
}
