package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day;

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
import com.guojunustb.library.WeekDayView;
import com.guojunustb.library.WeekHeaderView;
import com.guojunustb.library.WeekViewEvent;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;

public class DayFragment extends BaseFragment<DayPresenter> implements DayContract.View {

    @BindView(R.id.weekheaderview)
    WeekHeaderView mWeekHeaderView;
    @BindView(R.id.weekdayview)
    WeekDayView mWeekView;
    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    List<WeekViewEvent> mNewEvent = new ArrayList<WeekViewEvent>();
    List<Schedule.ResultBean> list = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    int UserId;
    String token;
    int ClubId;
    int IsDepartManager;

    SimpleDateFormat format;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private Context context;
    private FragMentListening fragMentListening;


    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
        fragMentListening = (FragMentListening) mActivity;
    }
    @Override
    public void loadData(List<Schedule.ResultBean> list) {
        btnComplete.setText("今天");
        mNewEvent.clear();
        this.list = list;
        int i = 0;
        String title;
        for (Schedule.ResultBean resultBean : list) {
            Calendar startTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            try {
                Date sd = dateFormat.parse(resultBean.getBgTime() + ":00");
                Date ed = dateFormat.parse(resultBean.getEdTime() + ":00");
                int Color = R.color.event_green;
                startTime.setTime(sd);
                endTime.setTime(ed);

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
                    if (!resultBean.getData().get(0).getAppointmentResultId().equals("")){
                        Color= R.color.commit_btn;
                    }
                }
                WeekViewEvent event = new WeekViewEvent(i, title, startTime, endTime);
                event.setColor(getResources().getColor(Color));

                mNewEvent.add(event);
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
        return R.layout.fragment_day;
    }


    @Override
    protected void initData() {
        format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        title.setText(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月"+(c.get(Calendar.DAY_OF_MONTH) ) + "日");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragMentListening.BtnBack();
            }
        });
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        //init WeekView
        mWeekView.setMonthChangeListener(new WeekDayView.MonthChangeListener() {


            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {

                /*List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                Calendar endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 1);
                endTime.set(Calendar.MONTH, newMonth - 1);
                WeekViewEvent event = new WeekViewEvent(1, "This is a Event!!", startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_01));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 4);
                endTime.set(Calendar.MINUTE, 30);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(10, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_02));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 4);
                startTime.set(Calendar.MINUTE, 20);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 5);
                endTime.set(Calendar.MINUTE, 0);
                event = new WeekViewEvent(10, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_03));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(2, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_02));
                events.add(event);
                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(2, "dddd", startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_01));
                events.add(event);
                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 1);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(3, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_03));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 15);
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(4, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_04));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 1);
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(5, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_01));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
                startTime.set(Calendar.HOUR_OF_DAY, 15);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(5, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.event_color_02));
                events.add(event);
                events.addAll(mNewEvent);*/


                return mNewEvent;
            }
        });
        mWeekView.setEventLongPressListener(new WeekDayView.EventLongPressListener() {
            @Override
            public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

            }
        });
        mWeekView.setOnEventClickListener(new WeekDayView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
//                ToastUtil.s(mContext,list.get((int)event.getId()).getData().size() +
                Intent ReservationRecordintent;
                Schedule.ResultBean.DataBean dataBean = list.get((int) event.getId()).getData().get(0);
                if (list.get((int) event.getId()).getData().size() > 1) {
                    Intent intent = new Intent(getActivity(), ListActivity.class);
                    intent.putExtra("param", (Serializable) list.get((int) event.getId()).getData());
                    getActivity().startActivity(intent);
                } else {
                    if (dataBean.getAppType().equals("3")) {

                        ReservationRecordintent = new Intent(mContext, ReservationRecordActivity.class);
                        ReservationRecordintent.putExtra(PUT_STR + "Type", "客户");
                    } else {

                        ReservationRecordintent = new Intent(mContext, ReservationRecordMembersActivity.class);
                        ReservationRecordintent.putExtra(PUT_STR + "Type", "会员");
                    }
                    ReservationRecordintent.putExtra(PUT_STR + "Id", String.valueOf(dataBean.getMemberId()));

                    //intent.putExtra(PUT_STR + "Type", dataBean.getCustomerType);
                    ReservationRecordintent.putExtra(PUT_STR + "MemberType", dataBean.getMemberType());
                    ReservationRecordintent.putExtra(PUT_STR + "AppointmentType", dataBean.getAppType());
                    ReservationRecordintent.putExtra(PUT_STR + "AppointmentId", String.valueOf(dataBean.getAppointmentId()));

                    startActivity(ReservationRecordintent);

                }
            }
        });
        mWeekView.setScrollListener(new WeekDayView.ScrollListener() {


            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {
                String date = null;
                if (oldFirstVisibleDay != null && newFirstVisibleDay != null) {


                    if (newFirstVisibleDay.getTime() != oldFirstVisibleDay.getTime()) {

                        date = format.format(newFirstVisibleDay.getTime());

                    }
                } else {

                    date = format.format(newFirstVisibleDay.getTime());

                }

                mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "d");
            }

            @Override
            public void onSelectedDaeChange(Calendar selectedDate) {

                mWeekHeaderView.setSelectedDay(selectedDate);
                title.setText(selectedDate.get(Calendar.YEAR) + "年" + (selectedDate.get(Calendar.MONTH) + 1) + "月"+(selectedDate.get(Calendar.DAY_OF_MONTH) ) + "日");


            }
        });
        mWeekHeaderView.setDateSelectedChangeListener(new WeekHeaderView.DateSelectedChangeListener() {
            @Override
            public void onDateSelectedChange(Calendar oldSelectedDay, Calendar newSelectedDay) {
                mWeekView.goToDate(newSelectedDay);
             title.setText(newSelectedDay.get(Calendar.YEAR) + "年" + (newSelectedDay.get(Calendar.MONTH) + 1) + "月"+(newSelectedDay.get(Calendar.DAY_OF_MONTH)) + "日");

            }
        });
        mWeekHeaderView.setScrollListener(new WeekHeaderView.ScrollListener() {
            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {

                String date = format.format(newFirstVisibleDay.getTime());
                mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "d");
                mWeekView.goToDate(mWeekHeaderView.getSelectedDay());
//                if (newFirstVisibleDay!=null && oldFirstVisibleDay!=null){
//                    if (oldDayNum==0){
//                        oldDate=oldFirstVisibleDay.getTime();
//                    };
//                    oldDayNum++;

//                String str = "";


////                if (str.indexOf("周前") != -1) {
//                if (oldDayNum == 7) {
//                    oldDayNum = 0;
////                    oldDate=newFirstVisibleDay.getTime();

//                }


            }

//        }
        });

        setupDateTimeInterpreter(false);

        String date = format.format(new Date());
        mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "w");
    }

    @Override
    public void showError(String msg) {

    }


    public void RefreshData() {

        String date = format.format(new Date());
        mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "w");
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        getActivity().startActivity(intent);
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
//        Calendar c1 = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
//        c1.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
//        s(context,c.get(Calendar.DAY_OF_WEEK)+"");
//        c.add(Calendar.DATE,1-c.get(Calendar.DAY_OF_WEEK));
        mWeekHeaderView.setSelectedDay(c);
//        c.add(Calendar.DATE,1-c.get(Calendar.DAY_OF_WEEK));
        title.setText(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月"+(c.get(Calendar.DAY_OF_MONTH)) + "日");
        mWeekView.goToToday();
    }
}
