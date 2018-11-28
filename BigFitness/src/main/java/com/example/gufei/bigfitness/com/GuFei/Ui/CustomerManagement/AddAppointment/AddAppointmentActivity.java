package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment;

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
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERAPPOINTMENTTYPEID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
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
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.TimeUtil.string2Milliseconds;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class AddAppointmentActivity extends BaseActivity<AddAppointmentActivityPresenter> implements AddAppointmentActivityContract.View {


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

    @BindView(R.id.appointment_type_text)
    TextView appointmentTypeText;
    @BindView(R.id.text_name_user)
    TextView textNameUser;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    @BindView(R.id.appointment_type_img)
    ImageView appointmentTypeImg;
    @BindView(R.id.begin_time_img)
    ImageView beginTimeImg;
    @BindView(R.id.end_time_img)
    ImageView endTimeImg;
    @BindView(R.id.remind_time_img)
    ImageView remindTimeImg;
    @BindView(R.id.interval_time_img)
    ImageView intervalTimeImg;
    @BindView(R.id.training_plan)
    TextView trainingPlan;
    @BindView(R.id.training_plan_img)
    ImageView trainingPlanImg;
    @BindView(R.id.btn_training_plan)
    RelativeLayout btnTrainingPlan;
    @BindView(R.id.text_note)
    EditText textNote;

//
//    private String UserNameValue;
//
//
//    private String appointTypeValue="";
//    private String AppointmentTypeIdValue="";
//    private String ContentValue="";
//    private String MemberIdValue="";
//    private String EndTimeValue="";
//    private String StartTimeValue="";
//    private String TipintervalValue="";
//    private String TipstarttimeValue="";
//    private String LessonIdValue="";
//    private String PlanInfoValue="";
    private String AppointmentIdValue="";


    private TimePickerView pvCustomTime;

//    private Button btn_CustomTime;

    private int mTimePv_Id;

    String Customerid="";
    String AppointmentId="";
    String AppointmentTypeId="";
    String lessonType="";
    String CustomerName="";
    String lessonCoach="";
    String lessonTime="";


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

        layoutTrainingPlan.setVisibility(View.GONE);
        intervalTimeBtn.setVisibility(View.GONE);

    }


    @Override
    protected void initData() {


        Intent intent = getIntent();

        Customerid = intent.getStringExtra(PUT_STR + "Id");

        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");

        lessonType = intent.getStringExtra(PUT_STR + "Type");

        CustomerName = intent.getStringExtra(PUT_STR + "Name");

        lessonCoach = intent.getStringExtra(PUT_STR + "coach");

        lessonTime = intent.getStringExtra(PUT_STR + "time");


        textNameUser.setText(CustomerName);
    }


    @Override
    public void showError(String msg) {

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

        finish();


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
//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_END_ID:
                        endTimeText.setText(getDataTime(date));
//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_REMIND_ID:
                        remindTimeText.setText(getDataTime(date));
//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_INTERVAL_ID:

//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        })

                .setDate(selectedDate)
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


                                switch (mTimePv_Id) {

                                    case TIME_BEGIN_ID:
                                        beginTimeText.setText("-");
//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                                        break;
                                    case TIME_END_ID:
                                        endTimeText.setText("-");
//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                                        break;
                                    case TIME_REMIND_ID:
                                        remindTimeText.setText("-");
//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                                        break;
                                    case TIME_INTERVAL_ID:

//                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                                        break;


                                }
                                pvCustomTime.dismiss();
                            }
                        });
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
                .setType(TimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.WHITE)
                .build();

    }


    @OnClick({ R.id.btn_training_plan,R.id.appointment_type_btn, R.id.end_time_btn, R.id.remind_time_btn, R.id.interval_time_btn, R.id.begin_time_btn, R.id.btn_confirm})
    public void onViewClicked(View view) {

        final Intent intent = new Intent(AddAppointmentActivity.this, FilterListActivity.class);


        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";

//        final String personType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.personType";

        initCustomTimePicker();
        switch (view.getId()) {
            case R.id.appointment_type_btn:


                intent.putExtra(mStrType, CUSTOMERAPPOINTMENTTYPEID);

                intent.putExtra(PUT_STR + "id", Customerid);

//                        startActivity(intent);
                startActivityForResult(intent, CUSTOMERAPPOINTMENTTYPEID);//使用时需定义变量requestCode

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

            case R.id.btn_confirm:
                String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

                String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);


                if (AppointmentIdValue.equals("")){
                    s(AddAppointmentActivity.this,"请选择预约种类");
                    break;
                  }

//                if (AppointmentIdValue.equals("")){
//                    s(AddAppointmentActivity.this,"请选择预约种类");
//                    break;
//                }
//AppointmentIdValue
                if (
                        AppointmentIdValue.equals("") ||
                        Customerid.equals("") ||
                        endTimeText.getText().toString().equals("-") ||
                        beginTimeText.getText().toString().equals("-"))
                {
                    s(this, "请填写完整信息!");
                    break;

                }
                if (string2Milliseconds(getDataTimes(new Date())) > string2Milliseconds(beginTimeText.getText().toString() + ":00")) {
                    s(this, "预约开始时间不能置前!请重新填写");
                    break;
                }
                if (string2Milliseconds(endTimeText.getText().toString() + ":00") < string2Milliseconds(beginTimeText.getText().toString() + ":00")) {

                    s(this, "请填写正确时间!");
                    break;
                }
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

                mPresenter.appAddCustomerAppoint(UserName,
                        UserId,
                        token,
                        ClubId,
                        AppointmentIdValue,
                        textNote.getText().toString(),
                        Customerid,
                        endTimeText.getText().toString(),
                        beginTimeText.getText().toString(),
                        intervalTimeText.getText().toString().equals("-")?"": intervalTimeText.getText().toString(),
                        remindTimeText.getText().toString().equals("-")?"": remindTimeText.getText().toString()+":00",
                        AppointmentId);


//                        (UserName,
//                        UserId,
//                        token,
//                        ClubId,
//                        appointTypeValue,
//                        AppointmentTypeIdValue,
//                        ContentValue,
//                        MemberIdValue,
//                        EndTimeValue,
//                        StartTimeValue,
//                        TipintervalValue,
//                        TipstarttimeValue,
//                        LessonIdValue,
//                        PlanInfoValue,
//                        AppointmentIdValue);
                break;

            case R.id.btn_training_plan:
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

        if (requestCode == CUSTOMERAPPOINTMENTTYPEID) {

            AppointmentIdValue = mId;

            appointmentTypeText.setText(mName);

            if (mName.equals("上课预约")) {
                layoutTrainingPlan.setVisibility(View.VISIBLE);
            } else {
                layoutTrainingPlan.setVisibility(View.GONE);
            }


        }
//
//        if (requestCode == MANGERLISTID) {
//
//            mPostCustomerListBean.setOwnManagerId(mId);
//
//            mPostCustomerListBean.setOwnManagerName(mName);
//
//        }
//
//        if (requestCode == CREATEUSERLISTID) {
//
//            mPostCustomerListBean.setCreateUserId(mId);
//
//            mPostCustomerListBean.setCreateUserName(mName);
//
//        }
//        if (requestCode == CUSTOMERINTRODUCERID) {
//
//            mPostCustomerListBean.setIntroduceMemberId(mId);
//
//            mPostCustomerListBean.setIntroduceMemberName(mName);
//
//        }
//        if (requestCode == CUSTOMERSOURCEID) {
//
//            mPostCustomerListBean.setSourceId(mId);
//
//            mPostCustomerListBean.setSourceName(mName);
//
//        }
//        if (requestCode == CUSTOMERINTENTID) {
//
//            mPostCustomerListBean.setIntentId(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }
//        if (requestCode == POSTEACHERLISTID) {
//
//            mPostCustomerListBean.setPOSTeacherId(mId);
//
//            mPostCustomerListBean.setPOSTeacherName(mName);
//
//        }
//        if (requestCode == CONTACTTEACHERLISTID) {
//
//            mPostCustomerListBean.setOwnTeacherId(mId);
//
//            mPostCustomerListBean.setOwnTeacherName(mName);
//
//        }
//
//        if (requestCode == LESSONTEACHERLISTID) {
//
//            mPostCustomerListBean.setClassTeacherId(mId);
//
//            mPostCustomerListBean.setClassTeacherName(mName);
//
//        }
//
//        if (requestCode == SALETEACHERLISTID) {
//
//            mPostCustomerListBean.setSigninTeacherId(mId);
//
//            mPostCustomerListBean.setSigninTeacherName(mName);
//
//        }
//        if (requestCode == CLASSTYPEID) {
//
//            mPostCustomerListBean.setClassTypeId(mId);
//
//            mPostCustomerListBean.setClassTypeIdName(mName);
//
//        }
//        if (requestCode == CLASSNAMEID) {
//
//            mPostCustomerListBean.setClassId(mId);
//
//            mPostCustomerListBean.setClassName(mName);
//
//        }
//
//
//        // TODO: 2017/6/5 办卡类型未实现
//        if (requestCode == ALLMEMBERCARDTYPEID ) {
//
//            mPostCustomerListBean.set(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }


//popupWindow.update();
//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//                ScreenPopup(screeningBtn, 0);
//
//            }
//        };
//        handler.post(runnable);

    }


}

