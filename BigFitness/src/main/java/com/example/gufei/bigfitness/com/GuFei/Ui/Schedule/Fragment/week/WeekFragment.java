package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Model.local.Schedule;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.activity.ListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;
import com.guojunustb.library.DateTimeInterpreter;
import com.guojunustb.library.WeekDView;
import com.guojunustb.library.WeekViewEvent;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class WeekFragment extends BaseFragment<WeekPresenter> implements WeekContract.View {

    //    @BindView(R.id.weekheaderdview)
//    WeekHeaderDView mWeekHeaderView;
    @BindView(R.id.weekdaydview)
    WeekDView mWeekView;
    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.btn_complete)
    Button btnComplete;

    List<WeekViewEvent> mNewEvent = new ArrayList<WeekViewEvent>();
    List<Schedule.ResultBean> list = new ArrayList<>();
    List<Integer> marks = new ArrayList<Integer>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    int UserId;
    String token;
    int ClubId;
    int FirstShow = 0;
    int IsDepartManager;
    SimpleDateFormat format;
    Calendar selectedoldDate;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private Context context;
    private FragMentListening fragMentListening;
    private boolean mLoding=false;


    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
        fragMentListening = (FragMentListening) mActivity;
    }

    @Override
    public void loadData(List<Schedule.ResultBean> list) {
        mNewEvent.clear();
        this.list = list;
        int i = 0;

        String title;
        for (Schedule.ResultBean resultBean : list) {
            Calendar startTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            int Color = R.color.event_green;
            try {
                startTime.setTime(dateFormat.parse(resultBean.getBgTime() + ":00"));
                endTime.setTime(dateFormat.parse(resultBean.getEdTime() + ":00"));

                if (resultBean.getData().size() > 1) {
                    title = resultBean.getData().size() + "个预约";
                    Color = R.color.commit_btn;
                    for (int j = 0; j < resultBean.getData().size(); j++) {
                        if (resultBean.getData().get(0).getAppointmentResultId().equals("")) {
                            Color = R.color.event_green;
                            break;
                        }
                    }


                } else {
                    title = "预约";
                    if (!resultBean.getData().get(0).getAppointmentResultId().equals("")) {
                        Color = R.color.commit_btn;
                    }

                }

                WeekViewEvent event = new WeekViewEvent(i, title, startTime, endTime);
                event.setColor(getResources().getColor(Color));


                mNewEvent.add(event);

//                mWeekHeaderView.setFocusSameDayBackgroundColor(R.color.red);
//                mWeekHeaderView.invalidate();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            i++;
        }


        mWeekView.notifyDatasetChanged();

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_week;
    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragMentListening.BtnBack();
            }
        });
        selectedoldDate = new GregorianCalendar();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        btnComplete.setText("本周");
        if (FirstShow == 0) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            title.setText(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月  " + (c.get(Calendar.WEEK_OF_YEAR)) + "周");
        }
        FirstShow++;
//init WeekView
        mWeekView.setMonthChangeListener(new WeekDView.MonthChangeListener() {
            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {

                return mNewEvent;
            }
        });
        mWeekView.setEventLongPressListener(new WeekDView.EventLongPressListener() {
            @Override
            public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

            }
        });
        mWeekView.setEmptyViewClickListener(new WeekDView.EmptyViewClickListener() {
            @Override
            public void onEmptyViewClicked(Calendar time) {


            }
        });
        mWeekView.setOnEventClickListener(new WeekDView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                String PersonType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
                Calendar calendar = mWeekView.getTimeFromPoint(eventRect.centerX(), eventRect.centerY());
//                title.setText(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + (calendar.get(Calendar.DATE)) + "日");
                if (list.get((int) event.getId()).getData().size() > 1) {
                    Intent intent = new Intent(mContext, ListActivity.class);
                    intent.putExtra("param", (Serializable) list.get((int) event.getId()).getData());
                    startActivity(intent);
                } else {

                    Schedule.ResultBean.DataBean dataBean = list.get((int) event.getId()).getData().get(0);
                    if ((dataBean.getMemberType() == 0 || dataBean.getMemberType() == 1) && !PersonType.equals("会籍")) {

                        Intent intent = new Intent(mContext, ReservationRecordMembersActivity.class);
                        intent.putExtra(PUT_STR + "Id", String.valueOf(dataBean.getMemberId()));
                        //intent.putExtra(PUT_STR + "Name", dataBean.getMemberName());
                        //intent.putExtra(PUT_STR + "Type", dataBean.getCustomerType);
                        intent.putExtra(PUT_STR + "MemberType", dataBean.getMemberType());
//                        if(dataBean.getMemberType() == 0)
//
//                        if(dataBean.getMemberType() == 1)
                        intent.putExtra(PUT_STR + "Type", "会员");
                        String UserType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
                        intent.putExtra(PUT_STR + "AppointmentType", UserType.equals("会籍") ? "1" : dataBean.getAppType());
                        intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(dataBean.getAppointmentId()));
                        startActivity(intent);


                    } else {
                        Intent intent = new Intent(mContext, ReservationRecordActivity.class);
                        intent.putExtra(PUT_STR + "Id", String.valueOf(dataBean.getMemberId()));
                        intent.putExtra(PUT_STR + "Type", "客户");

                        intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(dataBean.getAppointmentId()));
                        startActivity(intent);

                    }

                }
            }
        });


        mWeekView.setScrollListener(new WeekDView.ScrollListener() {
            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {


                if (oldFirstVisibleDay != null && newFirstVisibleDay != null) {

                    Log.d("--------新时间",format.format(newFirstVisibleDay.getTime()));
                    Log.d("--------- --------","");
                    Log.d("--------旧时间",format.format(oldFirstVisibleDay.getTime()));

                    if (!format.format(selectedoldDate.getTime()).equals(format.format(oldFirstVisibleDay.getTime()))){
                          title.setText(newFirstVisibleDay.get(Calendar.YEAR) + "年" + (newFirstVisibleDay.get(Calendar.MONTH) + 1) + "月  " + (newFirstVisibleDay.get(Calendar.WEEK_OF_YEAR)) + "周");
                          Calendar tmp=newFirstVisibleDay;
                          tmp.add(Calendar.DAY_OF_YEAR,2);
                          String time = format.format(tmp.getTime());
                          RefreshData(time);

                      }
                    selectedoldDate = oldFirstVisibleDay;

////
//                }


                }


            }

            @Override
            public void onSelectedDaeChange(Calendar selectedDate) {
//                mWeekHeaderView.setSelectedDay(selectedDate);
                //滚动改变头部部分
                Log.e("------~~~^~~~~~------>>", selectedDate.getTime() + "");

                if (selectedoldDate.before(selectedDate)) {


                    Log.e("小于结束时间", selectedDate.getTime() + "");

                } else {
                    Log.e("大于结束时间", selectedDate.getTime() + "");

                }


            }
        });
//        mWeekHeaderView.setDateSelectedChangeListener(new WeekHeaderDView.DateSelectedChangeListener() {
//            @Override
//            public void onDateSelectedChange(Calendar oldSelectedDay, Calendar newSelectedDay) {
////                     mWeekView.goToDate(newSelectedDay);
//
//            }
//        });
//        mWeekHeaderView.setScrollListener(new WeekHeaderDView.ScrollListener() {
//            @Override
//            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {
////                mWeekView.goToDate(mWeekHeaderView.getSelectedDay());
////                String date = format.format(newFirstVisibleDay.getTime());
////                mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "w");
//            }
//        });
        setupDateTimeInterpreter(false);


        String date = format.format(new Date());
        mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "w");


    }


    public void RefreshData(String time) {

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), time, "w");
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }


    @Override
    public void outLogin() {
        s(mContext, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();
        startActivity(intent);
    }

    @Override
    public void Loading() {

    }

    private void setupDateTimeInterpreter(final boolean shortDate) {

        final String[] weekLabels = {"日", "一", "二", "三", "四", "五", "六"};
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat("d", Locale.getDefault());
                return format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour) {
                return String.format("%02d:00", hour);

            }

            @Override
            public String interpretWeek(int date) {
                if (date > 7 || date < 1) {
                    return null;
                }
                return weekLabels[date - 1];
            }
        });
    }

    private String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH) + 1, time.get(Calendar.DAY_OF_MONTH));
    }


    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
//        s(context,c.get(Calendar.DAY_OF_WEEK)+"");
        c.add(Calendar.DATE, 1 - c.get(Calendar.DAY_OF_WEEK));
//        mWeekHeaderView.setSelectedDay(c);
        title.setText(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月  " + (c.get(Calendar.WEEK_OF_YEAR)) + "周");
        mWeekView.goToDate(c);
    }


}
