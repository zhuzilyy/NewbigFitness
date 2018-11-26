package com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.TIME_BEGIN_ID;
import static com.example.gufei.bigfitness.Constants.TIME_END_ID;
import static com.example.gufei.bigfitness.Constants.TIME_INTERVAL_ID;
import static com.example.gufei.bigfitness.Constants.TIME_REMIND_ID;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class CourseAppointmentAddActivity extends BaseActivity<CourseAppointmentAddActivityPresenter> implements CourseAppointmentAddActivityContract.View {


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


    private TimePickerView pvCustomTime;

    private Button btn_CustomTime;

    private int mTimePv_Id;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_appointment_course_add;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");
        intervalTimeBtn.setVisibility(View.GONE);
    }


    @Override
    protected void initData() {
        refresh();
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
    public void succeed(MessageslistBean messageslistBean) {


    }

    public void refresh() {

//
//        mPresenter.get("a");


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
//                        Toast.makeText(CourseAppointmentAddActivity.this, getDataTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_END_ID:
                        endTimeText.setText(getDataTime(date));
//                        Toast.makeText(CourseAppointmentAddActivity.this, getDataTime(date), Toast.LENGTH_SHORT).show();
                        break;
                    case TIME_REMIND_ID:
                        remindTimeText.setText(getDataTime(date));
//                        Toast.makeText(CourseAppointmentAddActivity.this, getDataTime(date), Toast.LENGTH_SHORT).show();
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
//                        Toast.makeText(CourseAppointmentAddActivity.this, getDataTime(date), Toast.LENGTH_SHORT).show();
                                        break;
                                    case TIME_END_ID:
                                        endTimeText.setText("-");
//                        Toast.makeText(CourseAppointmentAddActivity.this, getDataTime(date), Toast.LENGTH_SHORT).show();
                                        break;
                                    case TIME_REMIND_ID:
                                        remindTimeText.setText("-");
//                        Toast.makeText(CourseAppointmentAddActivity.this, getDataTime(date), Toast.LENGTH_SHORT).show();
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
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "","","","") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.WHITE)
                .build();

    }





    @OnClick({R.id.appointment_type_btn, R.id.end_time_btn, R.id.remind_time_btn, R.id.interval_time_btn,R.id.begin_time_btn})
    public void onViewClicked(View view) {
        initCustomTimePicker();

        switch (view.getId()) {
            case R.id.appointment_type_btn:
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
        }
    }


}

