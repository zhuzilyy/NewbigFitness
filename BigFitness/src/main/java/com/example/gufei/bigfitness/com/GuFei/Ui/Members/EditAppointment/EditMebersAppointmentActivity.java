package com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.ActionBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List.TrainingPlanListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
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
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEBYID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TIME_BEGIN_ID;
import static com.example.gufei.bigfitness.Constants.TIME_END_ID;
import static com.example.gufei.bigfitness.Constants.TIME_INTERVAL_ID;
import static com.example.gufei.bigfitness.Constants.TIME_REMIND_ID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TPREFRESHID;
import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.TimeUtil.string2Milliseconds;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class EditMebersAppointmentActivity extends BaseActivity<EditMebersAppointmentActivityPresenter> implements EditMebersAppointmentActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.details_note_text)
    TextView detailsNoteText;
    @BindView(R.id.begin_time_text)
    TextView beginTimeText;
    @BindView(R.id.end_time_text)
    TextView endTimeText;
    @BindView(R.id.remind_time_text)
    TextView remindTimeText;
    @BindView(R.id.interval_time_text)
    TextView intervalTimeText;
    @BindView(R.id.appointment_type_btn)
    RelativeLayout appointmentTypeBtn;
    @BindView(R.id.end_time_btn)
    RelativeLayout endTimeBtn;
    @BindView(R.id.remind_time_btn)
    RelativeLayout remindTimeBtn;
    @BindView(R.id.interval_time_btn)
    RelativeLayout intervalTimeBtn;
    @BindView(R.id.begin_time_btn)
    RelativeLayout beginTimeBtn;
    @BindView(R.id.layout_training_plan)
    LinearLayout layoutTrainingPlan;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    @BindView(R.id.appointment_type_text)
    TextView appointmentTypeText;
    @BindView(R.id.text_name_user)
    TextView textNameUser;
    @BindView(R.id.training_plan)
    TextView trainingPlan;
    @BindView(R.id.btn_training_plan)
    RelativeLayout btnTrainingPlan;
    @BindView(R.id.begin_time_img)
    ImageView beginTimeImg;
    @BindView(R.id.end_time_img)
    ImageView endTimeImg;
    @BindView(R.id.remind_time_img)
    ImageView remindTimeImg;
    @BindView(R.id.interval_time_img)
    ImageView intervalTimeImg;
    @BindView(R.id.training_plan_img)
    ImageView trainingPlanImg;
    @BindView(R.id.text_training_plan)
    TextView textTrainingPlan;
    @BindView(R.id.text_note)
    EditText textNote;


    private String UserNameValue;


    private String appointTypeValue="";
    private String AppointmentTypeIdValue="";
    private String ContentValue="";
    private String MemberIdValue="";
    private String EndTimeValue="";
    private String StartTimeValue="";
    private String TipintervalValue="";
    private String TipstarttimeValue="";


    private String LessonIdValue = "";
    private String PlanInfoValue;
    private String AppointmentIdValue;


    private TimePickerView pvCustomTime;

    private Button btn_CustomTime;

    private int mTimePv_Id;


    List<TrainingPlanBeanM.ListBean> PostJsonBeen = new ArrayList<TrainingPlanBeanM.ListBean>();

    String Customerid;
    String AppointmentId;
    String lessonType;
    String CustomerName;
    String lessonCoach;
    String lessonTime;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_appointment_add;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");

//        layoutTrainingPlan.setVisibility(View.GONE);


    }


    @Override
    protected void initData() {
        intervalTimeBtn.setVisibility(View.GONE);

        Intent intent = getIntent();

        Customerid = intent.getStringExtra(PUT_STR + "Id");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        lessonType = intent.getStringExtra(PUT_STR + "Type");
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        lessonCoach = intent.getStringExtra(PUT_STR + "coach");
        lessonTime = intent.getStringExtra(PUT_STR + "time");
        LessonIdValue = intent.getStringExtra(PUT_STR + "LessonId");
        textNameUser.setText(CustomerName);
    }


    @Override
    public void showError(String msg) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        PostJsonBeen = resultToTraingPlanBean();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferenceUtil.remove(TRAININGPLANKEY);

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
    public void succeed(CodeBean codeBean) {

        SharedPreferenceUtil.remove(TRAININGPLANKEY);
        finish();

    }

    @Override
    public void SaveSucceed(CodeBean codeBean) {

    }

    private void initCustomTimePicker() {

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

                switch (mTimePv_Id) {

                    case TIME_BEGIN_ID:
                        beginTimeText.setText(getDataTime(date));
//                        Toast.makeText(EditMebersAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_END_ID:
                        endTimeText.setText(getDataTime(date));
//                        Toast.makeText(EditMebersAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_REMIND_ID:
                        remindTimeText.setText(getDataTime(date));
//                        Toast.makeText(EditMebersAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_INTERVAL_ID:

//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.gravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
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
                .setType(TimePickerView.Type.ALL)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.WHITE)
                .build();

    }


    @OnClick({R.id.btn_training_plan, R.id.appointment_type_btn, R.id.end_time_btn, R.id.remind_time_btn, R.id.interval_time_btn, R.id.begin_time_btn, R.id.btn_confirm})
    public void onViewClicked(View view) {

        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        final Intent intent = new Intent(EditMebersAppointmentActivity.this, FilterListActivity.class);


        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";

//        final String personType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.personType";

        initCustomTimePicker();
        switch (view.getId()) {
            case R.id.appointment_type_btn:

                layoutTrainingPlan.setVisibility(View.GONE);
                intent.putExtra(mStrType, MEMBERAPPOINTMENTTYPEBYID);

                intent.putExtra(PUT_STR + "id", Customerid);

//                        startActivity(intent);
                startActivityForResult(intent, MEMBERAPPOINTMENTTYPEBYID);//使用时需定义变量requestCode

                break;
            case R.id.begin_time_btn:

                mTimePv_Id = TIME_BEGIN_ID;

                pvCustomTime.show();

                break;
            case R.id.end_time_btn:

                mTimePv_Id = TIME_END_ID;

                pvCustomTime.show();

                break;
            case R.id.remind_time_btn:

                mTimePv_Id = TIME_REMIND_ID;

                pvCustomTime.show();

                break;
            case R.id.interval_time_btn:

                mTimePv_Id = TIME_INTERVAL_ID;

                break;
            case R.id.btn_training_plan:

                final Intent TrainingPlanAdd = new Intent(EditMebersAppointmentActivity.this, TrainingPlanListActivity.class);
                TrainingPlanAdd.putExtra(mStrType, MEMBERAPPOINTMENTTYPEBYID);


                TrainingPlanAdd.putExtra(PUT_STR + "id", Customerid);
//                TrainingPlanAdd.putExtra(PUT_STR + "AppointmentId", AppointmentId);
////                TrainingPlanAdd.putExtra(PUT_STR + "MemberId", AppointmentId);
//                TrainingPlanAdd.putExtra(PUT_STR + "LessonId", AppointmentIdValue);
                TrainingPlanAdd.putExtra(PUT_STR + "AppointmentId", AppointmentTypeIdValue);
                TrainingPlanAdd.putExtra(PUT_STR + "LessonId", String.valueOf(LessonIdValue));
                TrainingPlanAdd.putExtra(mStrType, TPREFRESHID);
                startActivityForResult(TrainingPlanAdd, TPREFRESHID);//使用时需定义变量requestCode
//                startActivityForResult(intent, MEMBERAPPOINTMENTTYPEBYID);//使用时需定义变量requestCode
                break;

            case R.id.btn_confirm:

                if ((appointTypeValue==null ||
                        AppointmentTypeIdValue==null ||
                        Customerid==null ||
                        endTimeText.getText().toString()==null ||
                        beginTimeText.getText().toString()==null)

                        ) {
                    s(this, "请填写完整信息!");
                    break;
                }
                if (appointTypeValue.equals("") ||
                        AppointmentTypeIdValue.equals("") ||
                        Customerid.equals("") ||
                        endTimeText.getText().toString().equals("-") ||
                        beginTimeText.getText().toString().equals("-"))
            {

                s(this, "请填写完整信息!");
                break;

            }

            if (string2Milliseconds(endTimeText.getText().toString()+":00") < string2Milliseconds(beginTimeText.getText().toString()+":00")) {

                s(this, "‘请填写正确时间!");
                break;
            }

               String mremindTimeText=remindTimeText.getText().toString()+":00";
               String mbeginTimeText=beginTimeText.getText().toString()+":00";


                if (!remindTimeText.getText().toString().equals("") && !remindTimeText.getText().toString().equals("-")) {

                    if (intervalTimeText.getText().toString().equals("")) {
                        s(this, "请填写提醒间隔!");
                        break;
                    }

                    if (string2Milliseconds(remindTimeText.getText().toString() + ":00") > string2Milliseconds(beginTimeText.getText().toString() + ":00")) {

                        s(this, "提醒时间大于预约开始时间");
                        break;
                    }
                }


            //LessonIdValue 为可选  私教课 修改
            mPresenter.saveMemberAppiontment(UserName,
                    UserId,
                    token,
                    ClubId,
                    appointTypeValue,
                    AppointmentTypeIdValue,
                    textNote.getText().toString(),
                    Customerid,
                    endTimeText.getText().toString(),
                    beginTimeText.getText().toString()+":00",
                    intervalTimeText.getText().toString(),
                    remindTimeText.getText().toString()+":00",
                    LessonIdValue,
                    new Gson().toJson(PostJsonBeen),
                    "",
                    AppointmentId);
            break;
        }
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

        if (requestCode == MEMBERAPPOINTMENTTYPEBYID) {

            AppointmentTypeIdValue = mId;

            appointmentTypeText.setText(mName);

            if (mName.equals("上课预约")) {
                layoutTrainingPlan.setVisibility(View.VISIBLE);
                appointTypeValue = "2";
            } else {
                layoutTrainingPlan.setVisibility(View.GONE);
                appointTypeValue = "1";
            }


        }
    if (requestCode ==  TPREFRESHID) {

        resultToTraingPlanBean();

        }

    }

    private List<TrainingPlanBeanM.ListBean> resultToTraingPlanBean() {

        List<ActionBean.ListBean> temp = new ArrayList<ActionBean.ListBean>();

        List<TrainingPlanBeanM.ListBean> resultBeen = new ArrayList<TrainingPlanBeanM.ListBean>();

        List<String> SiteArr = new ArrayList<String>();

        List<String> SiteNmaeArr = new ArrayList<String>();

        String resultStr = "";

        Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, "result");

        if (object != null) {
            temp = (List<ActionBean.ListBean>) object;
        }

        if (temp.size() > 0) {


            for (int i = 0; i < temp.size(); i++) {

                if (!SiteArr.contains(temp.get(i).getPositionId())) {
                    SiteArr.add(temp.get(i).getPositionId());
                    SiteNmaeArr.add(temp.get(i).getPositionName());
                }

            }

            for (int i = 0; i < SiteArr.size(); i++) {

                resultStr += SiteNmaeArr.get(i);

                for (int j = 0; j < temp.size(); j++) {

                    if (SiteArr.get(i).toString().equals(temp.get(j).getPositionId().toString())) {

                        TrainingPlanBeanM.ListBean listBean = new TrainingPlanBeanM.ListBean();
                        listBean.setName(temp.get(j).getActionName());
                        listBean.setPositionId(temp.get(j).getPositionId());
                        listBean.setActionId(temp.get(j).getActionId());
                        listBean.setGroupCount(temp.get(j).getGroupCount());
                        listBean.setPositionName(SiteNmaeArr.get(i));
                        listBean.setAmount(temp.get(j).getAmount());
                        listBean.setActionName(temp.get(j).getActionName());
                        listBean.setContent(temp.get(j).getActionName() + "(" + temp.get(j).getAmount() + "个 * " + temp.get(j).getGroupCount() + "组)");

                        if (resultBeen != null) {
                            if (resultBeen.size() > 0) {
                                if (temp.get(j).getPositionId() .equals( resultBeen.get(resultBeen.size() - 1).getPositionId())) {
                                    listBean.setName("");
                                }

                            }
                        }

                        String nullstr = "  ";

//
                        if (listBean.getName().toString().equals("")) {
//
                            nullstr = "          ";
//
                        }

                        resultStr += nullstr + listBean.getContent() + "\n";
                        resultBeen.add(listBean);
                    }
                }
                resultStr += "\n";
                textTrainingPlan.setText(resultStr);
//                TrainingPlanBeanM.ListBean nullBean = new TrainingPlanBeanM.ListBean();
//                nullBean.setActionId("");
//                nullBean.setName("");
//                nullBean.setContent("");
//                nullBean.setPositionId("");
//                resultBeen.add(nullBean);


            }
//

        }

        return resultBeen;
    }


    @OnClick(R.id.text_training_plan)
    public void onViewClicked() {
    }
}

