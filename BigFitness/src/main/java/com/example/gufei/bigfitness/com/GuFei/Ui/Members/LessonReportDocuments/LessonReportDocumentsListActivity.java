package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CompleteLessonListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport.AddReportActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo.LessonInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CERVIX_DATAS;
import static com.example.gufei.bigfitness.Constants.CERVIX_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.CLASSNAMEID;
import static com.example.gufei.bigfitness.Constants.CLASSTYPEID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ListUtil.Arr2List;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class LessonReportDocumentsListActivity extends BaseActivity<LessonReportDocumentsListActivityPresenter> implements LessonReportDocumentsListActivityContract.View, SpinnerPopContract {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.btn_screen)
    ImageView btnScreen;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
//    @BindView(R.id.text_customer_type)
//    TextView textCustomerType;
//    @BindView(R.id.text_customer_name)
//    TextView textCustomerName;
//    @BindView(R.id.text_customer_img)
//    ImageView textCustomerImg;
//    @BindView(R.id.btn_appointment)
//    ImageView btnAppointment;
//    @BindView(R.id.btn_customer_info)
//    ImageView btnCustomerInfo;
//    @BindView(R.id.fab)
//    FloatingActionButton floatingActionButton;

    private String CustomerName = "";

    private String CustomerType = "";

    private String CustomerId = "";

    private String CustomerSex = "";

    private List<String> mDatas;


    private boolean isLoadingMore = true;//加载标志位


    private List<String> mInterfaceDatas;


    private List<Integer> mSelectedArr;

    //筛选显示标识
    private boolean sortingShow = true;

    //筛选首次运行标识
    private boolean firstSortingShow = true;

    private int mSelectedCount = 0;


    private int Type;

    private int mLayoutId;

    private int Page = 1;

//    private SpinnerAdapter spinnerAdapter = new SpinnerAdapter();

    private SpinnerPopupWindow s;


    private View contentView;

    private PopupWindow popupWindow;


    private CommonAdapter<CompleteLessonListBean.ResultBean> commonAdapter;


    private List<CompleteLessonListBean.ResultBean> datas = new ArrayList<CompleteLessonListBean.ResultBean>();


    PostCustomerListBean mPostCustomerListBean;

    private TimePickerView pvCustomTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_lesson_report_documents_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");

        Intent intent = getIntent();

        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");
        Type = intent.getIntExtra(PUT_STR + "Type", 0);

        mPostCustomerListBean = new PostCustomerListBean();


        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<CompleteLessonListBean.ResultBean>(R.layout.cardview_record_lesson_list, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final CompleteLessonListBean.ResultBean listBean, int i) {

                holder.setText(R.id.text_name_lesson, listBean.getLessonType() + ":" + listBean.getLessonName());
                holder.setText(R.id.text_coach, "教练:" + listBean.getTeacherName());
                holder.setText(R.id.text_time_lesson, "上课时间:" + listBean.getLessonTime());


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(LessonReportDocumentsListActivity.this, LessonInfoActivity.class);


                        intent.putExtra(PUT_STR + "Id", CustomerId);
                        intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId() + "");
                        intent.putExtra(PUT_STR + "Type", listBean.getLessonType());
                        intent.putExtra(PUT_STR + "textType", listBean.getLessonType());
                        intent.putExtra(PUT_STR + "Name", listBean.getLessonName());
                        intent.putExtra(PUT_STR + "coach", listBean.getTeacherName());
                        intent.putExtra(PUT_STR + "time", listBean.getLessonTime());


                        startActivity(intent);


                    }
                });

////

            }


        };


        recyclerView.setAdapter(commonAdapter);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

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

                commonAdapter.setShowFooter(false);
            }
        });


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


                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {

                        isLoadingMore = false;

                        loading();

                    }
                }
            });

        }


    }

    private void loading() {

        Page++;

        getList();
    }

    private void refresh() {


        Page = 1;

        getList();

    }

    private void getList() {


        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);


//        mPresenter.getMemberBodyReportList(UserId, token, ClubId, CustomerId, mOrderName,  mOrderType == 1 ? "asc" : "desc");
        mPresenter.getCompleteLessonList(UserId,
                token,
                ClubId,
                CustomerId, Page, mPostCustomerListBean.getClassTypeId(),
                mPostCustomerListBean.getClassName(),
                mPostCustomerListBean.getClassTeacherId(),
                mPostCustomerListBean.getStartCreateTime(), mPostCustomerListBean.getEndCreateTime());


    }

    @Override
    protected void initData() {

        mDatas = Arr2List(CERVIX_DATAS);

        mInterfaceDatas = Arr2List(CERVIX_Interface_DATAS);

        mSelectedArr = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
//            mDatas.add("" + (char) i + (char) i + (char) i + (char) i + (char) i);
            mSelectedArr.add(0);
        }


        refresh();


    }

    @Override
    public void succeed(CompleteLessonListBean completeLessonListBean) {


        for (int i = 0; i < mSelectedArr.size(); i++) {

            mSelectedArr.set(i, 0);

        }
//        datas=memberBodyReportListBean.getResult();

        swipeRefreshLayout.setRefreshing(false);

        try {

            datas = completeLessonListBean.getResult();

//            for (int i = 0; i < datas.size(); i++) {
//
//                mSelectdatas.add("0");
//            }
            if (datas.size() == 0){
                tvNoMore.setVisibility(View.VISIBLE);
            }else {
                if (Page == 1) {

                    commonAdapter.replaceData(datas);


                } else {

                    commonAdapter.insertData(datas);
                }
            }


        } catch (Exception e) {

            e.printStackTrace();

        }


    }


    @OnClick({R.id.btn_up_img, R.id.btn_screen,})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_up_img:

                String personType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
                if (!personType.equals("会籍")) {

                    intent = new Intent(LessonReportDocumentsListActivity.this, AddReportActivity.class);

                    intent.putExtra(PUT_STR + "Id", CustomerId);
                    intent.putExtra(PUT_STR + "Name", CustomerName);
                    intent.putExtra(PUT_STR + "Type", CustomerType);
                    intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());
                    startActivity(intent);
                } else {
                    s(this, "会籍无权此操作");

                }
                break;
            case R.id.btn_screen:

                ScreenPopup(view, 0);

//                if (sortingShow) {
//
//
////                    s = new SpinnerPopupWindow
////                            .Builder(LessonReportDocumentsListActivity.this)
////                            .setmLayoutManager(null)
////                            .setOutsideTouchable(true)
//////                        .setTitleText("性别")
////                            .setmSpinnerPopContract(LessonReportDocumentsListActivity.this)
////                            .setmAdapter(spinnerAdapter)
////
////                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
////                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT)
////                            .build();
////
////                    s.showPopWindowCenter(view);
////                    s.setTitleshow(false);
//
//
//
//                    sortingShow = false;
//
//                }
                break;

        }

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
    public void dismiss() {

//        if (mSelectedArr.get(mSelectedCount) > 0) {
//
////            sortingText.setTextColor(getResources().getColor(R.color.selected_color));
//
//            btnScreen.setImageResource(R.mipmap.sortingsecleted);
//
//        } else {
//
////            sortingText.setTextColor(getResources().getColor(R.color.all_back_color));
//
//             btnScreen.setImageResource(R.mipmap.sorting);
//
//        }
        backgroundAlpha(1f);
        refresh();


        sortingShow = true;
    }

    public void ScreenPopup(View v, final int tag) {


        if (contentView != null) contentView = null;

        if (popupWindow != null) popupWindow = null;

        // 一个自定义的布局，作为显示的内容


        int mHight = App.SCREEN_HEIGHT / 10 * 9;


        contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_class_record_screening, null);

        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, mHight, true);

        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        final TextView textCoursesType = (TextView) contentView.findViewById(R.id.text_courses_type);
        final TextView textCoursesName = (TextView) contentView.findViewById(R.id.text_courses_name);
        final TextView textInstructor = (TextView) contentView.findViewById(R.id.text_instructor);
        final ImageView btnCoursesType = (ImageView) contentView.findViewById(R.id.btn_courses_type);
        final ImageView btnCoursesName = (ImageView) contentView.findViewById(R.id.btn_courses_name);
        final ImageView btnInstructor = (ImageView) contentView.findViewById(R.id.btn_instructor);
        final TextView TimeEnd = (TextView) contentView.findViewById(R.id.second_time_end);
        final TextView TimeBegin = (TextView) contentView.findViewById(R.id.second_time_begin);
        final TextView btnreset = (TextView) contentView.findViewById(R.id.btn_reset);
        final TextView btnconfirm = (TextView) contentView.findViewById(R.id.btn_confirm);
        textCoursesType.setText(mPostCustomerListBean.getClassTypeIdName());
        textCoursesName.setText(mPostCustomerListBean.getClassName());
        textInstructor.setText(mPostCustomerListBean.getClassTeacherName());


        popupWindow.update();


//        backgroundAlpha(0.5f);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                final Intent intent = new Intent(LessonReportDocumentsListActivity.this, FilterListActivity.class);


                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
//


                btnCoursesType.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //课程类型
                        popupWindow.dismiss();

                        intent.putExtra(mStrType, CLASSTYPEID);

                        startActivityForResult(intent, CLASSTYPEID);//使用时需定义变量requestCode


                    }
                });
                btnCoursesName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //课程种类

                        if (mPostCustomerListBean.getClassTypeId() == null) {

                            s(context, "请先选择课程种类");


                        } else {
                            popupWindow.dismiss();
                            intent.putExtra(mStrType, CLASSNAMEID);

                            intent.putExtra(PUT_STR + "id", mPostCustomerListBean.getClassTypeId());

                            startActivityForResult(intent, CLASSNAMEID);//使用时需定义变量requestCode

                        }


                    }
                });
                btnInstructor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //上课教练
                        popupWindow.dismiss();
                        intent.putExtra(mStrType, LESSONTEACHERLISTID);

//                        startActivity(intent);
                        startActivityForResult(intent, LESSONTEACHERLISTID);//使用时需定义变量requestCode


                    }
                });

                TimeBegin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(TimeBegin, "开始时间");

                        pvCustomTime.show();

                    }
                });
                TimeEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(TimeEnd, "结束时间");

                        pvCustomTime.show();

                    }
                });


                btnreset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mPostCustomerListBean != null) {
                            mPostCustomerListBean = null;
                            mPostCustomerListBean = new PostCustomerListBean();

                            textCoursesType.setText(mPostCustomerListBean.getClassTypeIdName());

                            textCoursesName.setText(mPostCustomerListBean.getClassName());

                            textInstructor.setText(mPostCustomerListBean.getClassTeacherName());


                            TimeBegin.setText("开始时间");

                            TimeEnd.setText("结束时间");


                        }


                    }
                });

                btnconfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        refresh();
                        popupWindow.dismiss();

                    }
                });


                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

        popupWindow.showAtLocation(v, Gravity.TOP, 0, point[1] + v.getHeight());


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
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

        if (requestCode == CUSTOMERTAGID) {
            mPostCustomerListBean.setLabelId(mId);
            mPostCustomerListBean.setLabelName(mName);

        }

        if (requestCode == MANGERLISTID) {
            mPostCustomerListBean.setOwnManagerId(mId);
            mPostCustomerListBean.setOwnManagerName(mName);

        }

        if (requestCode == CREATEUSERLISTID) {
            mPostCustomerListBean.setCreateUserId(mId);
            mPostCustomerListBean.setCreateUserName(mName);

        }
        if (requestCode == CUSTOMERINTRODUCERID) {

            mPostCustomerListBean.setIntroduceMemberId(mId);

            mPostCustomerListBean.setIntroduceMemberName(mName);

        }
        if (requestCode == CUSTOMERSOURCEID) {

            mPostCustomerListBean.setSourceId(mId);

            mPostCustomerListBean.setSourceName(mName);

        }
        if (requestCode == CUSTOMERINTENTID) {

            mPostCustomerListBean.setIntentId(mId);

            mPostCustomerListBean.setIntentName(mName);

        }
        if (requestCode == POSTEACHERLISTID) {

            mPostCustomerListBean.setPOSTeacherId(mId);

            mPostCustomerListBean.setPOSTeacherName(mName);

        }
        if (requestCode == CONTACTTEACHERLISTID) {

            mPostCustomerListBean.setOwnTeacherId(mId);

            mPostCustomerListBean.setOwnTeacherName(mName);

        }

        if (requestCode == LESSONTEACHERLISTID) {

            mPostCustomerListBean.setClassTeacherId(mId);

            mPostCustomerListBean.setClassTeacherName(mName);

        }

        if (requestCode == SALETEACHERLISTID) {

            mPostCustomerListBean.setSigninTeacherId(mId);

            mPostCustomerListBean.setSigninTeacherName(mName);

        }
        if (requestCode == CLASSTYPEID) {

            mPostCustomerListBean.setClassTypeId(mId);

            mPostCustomerListBean.setClassTypeIdName(mName);

        }
        if (requestCode == CLASSNAMEID) {

            mPostCustomerListBean.setClassId(mId);

            mPostCustomerListBean.setClassName(mName);

        }


        //// TODO: 2017/6/5 办卡类型未实现
//        if (requestCode == ALLMEMBERCARDTYPEID ) {
//
//            mPostCustomerListBean.set(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }


//popupWindow.update();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                ScreenPopup(btnScreen, 0);

            }
        };
        handler.post(runnable);

    }


    private void initCustomTimePicker(final TextView view, final String title) {

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

                view.setText(getTime(date));

                switch (view.getId()) {

                    case R.id.first_time_begin:

                        mPostCustomerListBean.setStartLastContactTime(getTime(date));

                        break;
                    case R.id.first_time_end:

                        mPostCustomerListBean.setEndLastContactTime(getTime(date));

                        break;
                    case R.id.second_time_begin:

                        mPostCustomerListBean.setStartCreateTime(getTime(date));

                        break;
                    case R.id.second_time_end:

                        mPostCustomerListBean.setEndCreateTime(getTime(date));

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
                                view.setText(title);
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
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.nullcoloer)
                .build();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
