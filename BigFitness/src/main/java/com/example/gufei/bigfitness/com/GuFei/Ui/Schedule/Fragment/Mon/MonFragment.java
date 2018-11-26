package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.horizontalexpcalendar.HorizontalExpCalendar;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.horizontalexpcalendar.common.Config;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.horizontalexpcalendar.common.Marks;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import org.joda.time.DateTime;

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

import static android.widget.LinearLayout.VERTICAL;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.TimeUtil.Monstring2Date;
import static com.example.gufei.bigfitness.util.TimeUtil.getMonDateTime;
import static com.example.gufei.bigfitness.util.TimeUtil.getMonTime;
import static com.example.gufei.bigfitness.util.TimeUtil.getTime;
import static com.example.gufei.bigfitness.util.ToastUtil.s;
import static org.joda.time.DateTime.now;


/**
 * @author GuFei
 * @version 2016 10 12 16:07
 */
public class MonFragment extends BaseFragment<MonPresenter> implements MonContract.View {

    private static final String TAG = MonFragment.class.getName();
    //    @BindView(R.id.mon_scroll_view)
//    MyScrollView monScrollView;
    @BindView(R.id.calendar)
    HorizontalExpCalendar horizontalExpCalendar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;

    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private Context context;
    private FragMentListening fragMentListening;




    private CommonAdapter<AppointmentListByDateBean.ReslutBean> commonAdapter;


//    private CommonAdapter.MultiItemTypeSupport<MainMsgBean.ResultBean> mulitItem; // 多类型布局

    private boolean isLoadingMore = true;//加载标志位


    private List<AppointmentListByDateBean.ReslutBean> datas = new ArrayList<AppointmentListByDateBean.ReslutBean>();
    private List<AppointmentListByMonthBean.ResultBean> MonDatas = new ArrayList<AppointmentListByMonthBean.ResultBean>();

    SimpleDateFormat format;
    private boolean Show_Mark = true;


    private String UserName;

    private int UserId;

    private String token;

    private int ClubId;

    private int IsDepartManager;

    private int DepartId;

    private String DateSelected;
//    @Override
//    public void onAttach(Context context) {
//
//        mActivity = (Activity) context;
//
//        mContext = context;
//
//        super.onAttach(context);
//
//        fragMentListening = (FragMentListening) mActivity;
//
//    }


//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//
//            //相当于Fragment的onResume
//            DateSelected=now().toString();
////            initData();
//            refreshMon(getMonTime(new Date()));
//            refresh();
////            recyclerView.scrollToPosition(0);
//        } else {
//            //相当于Fragment的onPause
//        }
//    }

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
        fragMentListening = (FragMentListening) mActivity;
    }
    @Override
    public void onResume() {
        super.onResume();
        //
        //相当于Fragment的onResume
        DateSelected = now().toString();
//            initData();
        refreshMon(getMonTime(new Date()));
        refresh();
//            recyclerView.scrollToPosition(0);
    }

    @Override
    public void loadData(AppointmentListByMonthBean appointmentListByMonthBean) {


        MonDatas = appointmentListByMonthBean.getResult();

        for (int i = 0; i < MonDatas.size(); i++) {

            Date date = Monstring2Date(MonDatas.get(i).getStartTime());
            String[] timeArr = MonDatas.get(i).getStartTime().split("/");
            DateTime dateTime = new DateTime(
                    Integer.parseInt(timeArr[0].toString()),
                    Integer.parseInt(timeArr[1].toString()),
                    Integer.parseInt(timeArr[2].toString()),
                    00, 00, 00);
            Marks.refreshCustomMark(dateTime, Marks.CustomMarks.CUSTOM1, true);

        }
//        appointmentListByMonthBean.getResult().get(0);

        horizontalExpCalendar.updateMarks();

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mon;
    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragMentListening.BtnBack();
            }
        });
        format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        title.setText(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月");
        btnComplete.setText("今天");
        UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        horizontalExpCalendar.setHorizontalExpCalListener(new HorizontalExpCalendar.HorizontalExpCalListener() {
            @Override
            public void onCalendarScroll(DateTime dateTime) {
//                Log.i(TAG, "onCalendarScroll: " + dateTime.toString());
                refreshMon(getMonDateTime(dateTime));
                Calendar calendar = Calendar.getInstance();
                Date date = dateTime.toDate();
                calendar.setTime(date);
                title.setText(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH)) + "月");
            }

            @Override
            public void onDateSelected(DateTime dateTime) {
//                Log.i(TAG, "onDateSelected-----------: " + dateTime.toString());
                DateSelected = dateTime.toString();

                refresh();
            }

            @Override
            public void onChangeViewPager(Config.ViewPagerType viewPagerType) {
                Log.i(TAG, "onChangeViewPager: " + viewPagerType.name());
            }
        });



        datas = new ArrayList<>();


        commonAdapter = new CommonAdapter<AppointmentListByDateBean.ReslutBean>(R.layout.card_appointment_mon, mContext, datas) {



            @Override
            protected void convert(ViewHolder holder, final AppointmentListByDateBean.ReslutBean listBean, int position) {


                holder.setText(R.id.text_time_begin, listBean.getStartTime());
                holder.setText(R.id.text_time_end, listBean.getTitle());
                holder.setText(R.id.text_content, listBean.getTitle());
                int Color=R.color.event_green;
                if (!listBean.getAppointmentResultId().equals("")){
                    Color=  R.color.commit_btn;

                }
                holder.getView(R.id.color_left_line).setBackgroundColor(getResources().getColor(Color));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        if (listBean.getAppType().equals("3")) {
                            intent = new Intent(context, ReservationRecordActivity.class);
                            intent.putExtra(PUT_STR + "Type", "客户");
                        } else {

                            intent = new Intent(context, ReservationRecordMembersActivity.class);
                            intent.putExtra(PUT_STR + "Type", "会员");
                        }
                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getMemberId()));
                        intent.putExtra(PUT_STR + "MemberType", listBean.getMemberType());
//                       intent.putExtra(PUT_STR + "Sex", listBean.get());
                        intent.putExtra(PUT_STR + "AppointmentType", listBean.getAppType());
                        intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(listBean.getAppointmentId()));
                        startActivity(intent);


                    }
                });

            }


        };

        commonAdapter.setShowFooter(false);

        recyclerView.setAdapter(commonAdapter);


        final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(context, VERTICAL, true, datas.size()) {
            @Override
            public boolean canScrollVertically() {

                //{｝内部分可以开启滑动
                return true;
            }
        };

        layoutManager.setAutoMeasureEnabled(true);
//
        recyclerView.setLayoutManager(layoutManager);




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

                    //当前条数的位置
                    int Item = RecycViewlayoutManager.findFirstVisibleItemPosition();

                    Log.i(TAG, " 显示 " + (totalItemCount - Item));
                    if (Show_Mark && totalItemCount - 5 > lastVisubleItem && dy > 0) {

                        Show_Mark = false;
//                        horizontalExpCalendar.switchToView(Config.ViewPagerType.WEEK);
//                        recyclerView.scrollToPosition(0);
//                        loading();

                    } else if (!Show_Mark && Item == 0 && dy < 0) {

                        Show_Mark = true;
//                        horizontalExpCalendar.switchToView(Config.ViewPagerType.MONTH);
//                        recyclerView.scrollToPosition(0);
                    }
                }


            });
        }


    }

    private void refreshMon(String time) {


//        DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);

        mPresenter.getAppointmentListByMonth(
                UserId, token, ClubId, String.valueOf(IsDepartManager), time
        );


    }


    public void RefreshData() {
//        //
//        //相当于Fragment的onResume
//        DateSelected = now().toString();
////            initData();
//        refreshMon(getMonTime(new Date()));
        refresh();
    }

    private void refresh() {

        DateTime d = new DateTime(DateSelected);

//        Date date=  d.minusDays(1).toDate();
        Date date = d.toDate();
        UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        mPresenter.getAppointmentListByDate(
                UserId, token, ClubId, String.valueOf(IsDepartManager), getTime(date)
        );


    }

    @Override
    public void loadList(AppointmentListByDateBean appointmentListByDateBean) {
//        swipeRefreshLayout.setRefreshing(false);
        isLoadingMore = true;
        try {

            if (!(appointmentListByDateBean.getReslut() ==null)) {

                datas = appointmentListByDateBean.getReslut();

                commonAdapter.replaceData(datas);
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Override
    public void showError(String msg) {
//        SnackbarUtil.s(mView, msg);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {

        s(mContext, "您的帐号在其他设备登录");
        Intent intent = new Intent(context, LoginActivity.class);
        remove();
        startActivity(intent);

    }


    @Override
    public void Loading() {

    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        DateTime date = new DateTime();//取时间
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        title.setText(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月");
//        horizontalExpCalendar.scrollToDate(date, false);
        horizontalExpCalendar.onDayClick(date);

        mPresenter.getAppointmentListByMonth(
                UserId, token, ClubId, String.valueOf(IsDepartManager), getMonTime(new Date())
        );


//        horizontalExpCalendar.updateMarks();
    }


}