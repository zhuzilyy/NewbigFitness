package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.appMemberNumReportDetailListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_MEMBERS;
import static com.example.gufei.bigfitness.Constants.CLASSNAMEID;
import static com.example.gufei.bigfitness.Constants.CLASSTYPEID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONLISTBYMEMBERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REPORT_DATAS;
import static com.example.gufei.bigfitness.Constants.REPORT_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.TEACHER_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.TEACHER_REPORT_DATAS;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERLEVELKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.ListUtil.Arr2List;
import static com.example.gufei.bigfitness.util.ListUtil.check;
import static com.example.gufei.bigfitness.util.ListUtil.map2Bean;
import static com.example.gufei.bigfitness.util.TimeUtil.getMyDateKillSeconds;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表数据列表
 */

public class ChartsListActivity extends BaseActivity<ChartsListActivityPresenter> implements ChartsListActivityContract.View, SpinnerPopContract {

    @BindView(R.id.sorting_btn)
    RelativeLayout sortingBtn;
    @BindView(R.id.screening_btn)
    RelativeLayout screeningBtn;
    //    @BindView(R.id.type_department_btn)
//    RelativeLayout departmentBtn;
//    @BindView(R.id.text_department)
//    TextView textDepartment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //    @BindView(R.id.searchView)
//    SearchView searchView;
    @BindView(R.id.sorting_img)
    ImageView sortingImg;
    @BindView(R.id.screening_img)
    ImageView screeningImg;
    @BindView(R.id.sorting_text)
    TextView sortingText;
    //    @BindView(R.id.no_rank_screen_layout)
//    LinearLayout noRankScreenLayout;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.title_num)
    TextView titleNum;
    TextView StartLessonBalanceText;
    TextView EndLessonBalanceText;
    @BindView(R.id.layout_alpha)
    LinearLayout layoutAlpha;

    private int page = 0;

    private int layoutId = 0;

    private String mTypeName = "";


    PostCustomerListBean mPostCustomerListBean;

    private boolean isLoadingMore = true;//加载标志位

    private CommonAdapter<appMemberNumReportDetailListBean.ResultBean> commonAdapter;


    private List<appMemberNumReportDetailListBean.ResultBean> datas = new ArrayList<appMemberNumReportDetailListBean.ResultBean>();

    private List<String> mSelectdatas = new ArrayList<String>();
    private List<String> mMSelectdatas = new ArrayList<String>();//客户数据表

    private SpinnerPopupWindow SpinnerPopupWindowSorting;


    private SpinnerAdapter spinnerAdapter = new SpinnerAdapter();


    //筛选显示标识
    private boolean sortingShow = true;

    //筛选首次运行标识
    private boolean firstSortingShow = true;


    //查找显示标识
    private boolean screeningShow = true;


//    //编辑标识
//    private boolean editShow = false;
//
//    //全选标识
//    private boolean selectAll = false;


    private List<String> mDatas;

//    private List<String> mTDatas;

    private List<String> mInterfaceDatas;

    private List<Integer> mSelectedArr;

    private int mSelectedCount = 0;

//    private int departmentId = TYPE_CLERK;

    private View contentView;

    private PopupWindow popupWindow;

    private int type;
    int departId;

    String UserLevel;
    String personType;
    int IsDepartManager;
    int mType;


    String TeacherId;
    String ManagerId;
    String StartCardCreateTime;
    String EndCardCreateTime;
    String StartLastContactTime;
    String EndLastContactTime;
    String StartExpireTime;
    String EndExpireTime;
    String ClubList;
    String persontype;
    String StartLessonCreateTime;
    String EndLessonCreateTime;
    String StartLessonStopTime;
    String EndLessonStopTime;
    String StartLessonBalance;
    String EndLessonBalance;
    String SexId;
    int ffff = 0;
    String typeName;

    private TimePickerView pvCustomTime;
    private boolean mTouch = true;

    private List<FilterBean.FilterListBean> arrModel = new ArrayList<FilterBean.FilterListBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_activity_charts;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void initView() {
        layoutAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutAlpha.setVisibility(View.GONE);
                if (SpinnerPopupWindowSorting != null) SpinnerPopupWindowSorting.dismissPopWindow();

                mTouch = true;
            }
        });

        mPostCustomerListBean = new PostCustomerListBean();
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("全部会员");
        persontype = (String) SpUtil.get(context, PERSONTYPEKEY, "");
        Intent intent = getIntent();
        type = intent.getIntExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", 0);
        String num = (String) intent.getStringExtra(PUT_STR + "num");
        typeName = (String) intent.getStringExtra(PUT_STR + "typeName");
//        titleNum.setText(typeName + " : " + num + "人");
        type = ACTIVITY_ID_MEMBERS;
        mType = Integer.parseInt(intent.getStringExtra(PUT_STR + "type"));
        ClubList = (String) intent.getStringExtra(PUT_STR + "ClubList");
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        personType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");

//        final int departmentId = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
//        mPostCustomerListBean.setPersonType());

//        departmentBtn.setVisibility(View.GONE);


        if (persontype.equals("教练")) {
            layoutId = R.layout.pop_view_charts_teacher_screening;

        } else {
            layoutId = R.layout.pop_view_charts_screening;
        }

        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<appMemberNumReportDetailListBean.ResultBean>(R.layout.cardview_details_charts_list, this, datas) {
            @Override
            protected void convert(ViewHolder holder, final appMemberNumReportDetailListBean.ResultBean listBean, int i) {
                holder.setText(R.id.id_user_name, mTypeName + listBean.getMemberName());
                if (!datas.get(i).getLastContactTime().equals("")) {
                    holder.setText(R.id.id_time, getMyDateKillSeconds(datas.get(i).getLastContactTime()) + "  最后跟进");
                } else {
                    holder.setText(R.id.id_time, "");
                }
                displayCircleImage(mContext, listBean.getHeaderURL(), (ImageView) holder.setImage(R.id.img_head), R.mipmap.head_img);//头像
                if (listBean.getSex().equals("男")) {
                    holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_men);
                } else {
                    holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_women);
                }
                holder.setImage(R.id.btn_tel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent tel = new Intent(Intent.ACTION_VIEW);
                        Uri teldata = Uri.parse("tel:" + listBean.getTel());
                        tel.setData(teldata);
                        startActivity(tel);

                    }
                });
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }

                });

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


    @Override
    protected void initData() {

        mDatas = Arr2List(TEACHER_REPORT_DATAS);
        mInterfaceDatas = Arr2List(TEACHER_Interface_DATAS);
        if (!persontype.equals("教练")) {
            mDatas = Arr2List(REPORT_DATAS);
            mInterfaceDatas = Arr2List(REPORT_Interface_DATAS);
        }
        mSelectedArr = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
            mSelectedArr.add(0);
        }


        refresh();

    }

    @Override
    public void succeed(appMemberNumReportDetailListBean appMemberNumReportDetailListBean) {
        swipeRefreshLayout.setRefreshing(false);
        if (popupWindow != null)
            popupWindow.dismiss();
//        mPostCustomerListBean = new PostCustomerListBean();
        if (appMemberNumReportDetailListBean.getTotalResult() > 0)
            titleNum.setText("数量" + " : " + appMemberNumReportDetailListBean.getTotalResult() + "人");
        try {
            datas = appMemberNumReportDetailListBean.getResult();
            for (int i = 0; i < datas.size(); i++) {
                mSelectdatas.add("0");
                mMSelectdatas.add("0");
            }
            if (page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loading() {
        page++;
        getList();
    }

    public void refresh() {

        page = 1;
        getList();

    }

    public void getList() {
        if (popupWindow != null)
            popupWindow.dismiss();

//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        UserLevel = String.valueOf((int) SpUtil.get(context, USERLEVELKEY, 0));
        if (persontype.equals("会所管理员"))
            UserLevel="1";
        departId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
        String mOrderName = "";
        int mOrderType = 2;

        for (int i = 0; i < mSelectedArr.size(); i++) {
            if (mSelectedArr.get(i) > 0) {
                mOrderName = mInterfaceDatas.get(i).toString();
                mOrderType = mSelectedArr.get(i);
            }
        }

        mPresenter.appMemberNumReportDetailList(
                UserId,
                token,
                ClubId,
                IsDepartManager,
                departId,
                ClubList,
                UserLevel,
                page,
                mType,
                mOrderName,
                mOrderType == 1 ? "asc" : "desc",
                mPostCustomerListBean.getOwnTeacherId(),
                mPostCustomerListBean.getOwnManagerId(),
                SexId,
                mPostCustomerListBean.getStartCreateTime(),
                mPostCustomerListBean.getEndCreateTime(),
                mPostCustomerListBean.getStartLastContactTime(),
                mPostCustomerListBean.getEndLastContactTime(),
                mPostCustomerListBean.getCollection_time_begin(),
                mPostCustomerListBean.getCollection_time_end(),
                mPostCustomerListBean.getStartLessonCreateTime(),
                mPostCustomerListBean.getEndLessonCreateTime(),
                mPostCustomerListBean.getStartLessonStopTime(),
                mPostCustomerListBean.getEndLessonStopTime(), "", ""

//
//                StartLessonBalanceText.getText()==null?"":StartLessonBalanceText.getText().toString(),
//                EndLessonBalanceText.getText()==null?"":EndLessonBalanceText.getText().toString()

        );

        isLoadingMore = true;
        swipeRefreshLayout.setRefreshing(false);
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

    //
    @OnClick({R.id.sorting_btn, R.id.screening_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sorting_btn:

                sortingText.setTextColor(getResources().getColor(R.color.selected_color));
                sortingImg.setImageResource(R.mipmap.sortingsecleted);
                if (sortingShow) {
                    SpinnerPopupWindowSorting = new SpinnerPopupWindow
                            .Builder(ChartsListActivity.this)
                            .setmLayoutManager(null)
                            .setOutsideTouchable(true)
//                        .setTitleText("性别")
                            .setmSpinnerPopContract(ChartsListActivity.this)
                            .setmAdapter(spinnerAdapter)

                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                            .build();
//                    backgroundAlpha(0.5f);
                    SpinnerPopupWindowSorting.showPopWindowCenter(view);
                    SpinnerPopupWindowSorting.setTitleshow(false);
                    layoutAlpha.setVisibility(View.VISIBLE);
                    sortingShow = false;
//                    if (popupWindow != null) {
//                        popupWindow.dismiss();
//                    }
                    mTouch = false;
                    commonAdapter.notifyDataSetChanged();
                }
                break;

            case R.id.screening_btn:

                ScreenPopup(view, 0);
                layoutAlpha.setVisibility(View.VISIBLE);
                mTouch = false;
                commonAdapter.notifyDataSetChanged();
                break;


        }
    }

    @Override
    public void dismiss() {


        if (mSelectedArr.get(mSelectedCount) > 0) {
            sortingText.setTextColor(getResources().getColor(R.color.selected_color));
            sortingImg.setImageResource(R.mipmap.sortingsecleted);
        } else {
            sortingText.setTextColor(getResources().getColor(R.color.all_back_color));
            sortingImg.setImageResource(R.mipmap.sorting);
        }
        backgroundAlpha(1f);
        refresh();
        layoutAlpha.setVisibility(View.GONE);
        mTouch = true;
        sortingShow = true;

    }


    class SpinnerAdapter extends RecyclerView.Adapter<ChartsListActivity.SpinnerAdapter.MyViewHolder> {
        @Override
        public ChartsListActivity.SpinnerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            ChartsListActivity.SpinnerAdapter.MyViewHolder holder = new ChartsListActivity.SpinnerAdapter.MyViewHolder(LayoutInflater.from(
                    ChartsListActivity.this).inflate(R.layout.item_pop, parent,
                    false));

            return holder;
        }

        @Override
        public void onBindViewHolder(ChartsListActivity.SpinnerAdapter.MyViewHolder holder, final int position) {


            holder.tv.setText(mDatas.get(position).toString());

            switch (mSelectedArr.get(position)) {

                case 0:
                    holder.tv.setTextColor(getResources().getColor(R.color.all_back_color));
                    holder.upBtn.setImageResource(R.mipmap.screening_up);
                    holder.downBtn.setImageResource(R.mipmap.screening_down);
                    break;

                case 1:
                    holder.tv.setTextColor(getResources().getColor(R.color.selected_color));
                    holder.upBtn.setImageResource(R.mipmap.screening_up_selected);
                    holder.downBtn.setImageResource(R.mipmap.screening_down);
                    break;

                case 2:
                    holder.tv.setTextColor(getResources().getColor(R.color.selected_color));
                    holder.upBtn.setImageResource(R.mipmap.screening_up);
                    holder.downBtn.setImageResource(R.mipmap.screening_down_selected);
                    break;

                default:

                    break;


            }

            holder.tv.setTag(position);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    switch (mSelectedArr.get(position)) {

                        case 0:

                            mSelectedArr.set(position, 1);

                            if (!firstSortingShow) {
                                //首次排序  不对上次点击进行修改
                                mSelectedArr.set(mSelectedCount, 0);
                            }

                            firstSortingShow = false;
                            mSelectedCount = position;
                            Log.e("取消", "" + position);

                            break;
                        case 1:

                            mSelectedArr.set(position, 2);
                            Log.e("上", "" + position);
                            break;
                        case 2:
                            mSelectedArr.set(position, 1);
                            Log.e("下", "" + position);
                            break;

                        default:

                            break;


                    }


                    spinnerAdapter.notifyDataSetChanged();
                    layoutAlpha.setVisibility(View.GONE);
                    mTouch = true;
                    SpinnerPopupWindowSorting.dismissPopWindow();
                    dismiss();
//                    Toast.makeText(CustomerListActivity.this, "" + position, Toast.LENGTH_SHORT).show();

                }
            });

        }

        @Override
        public int getItemCount() {

            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            ImageView upBtn;
            ImageView downBtn;
            LinearLayout selected_btn;

            public MyViewHolder(final View view) {

                super(view);
                tv = (TextView) view.findViewById(R.id.test1);
                upBtn = (ImageView) view.findViewById(R.id.up_btn);
                downBtn = (ImageView) view.findViewById(R.id.down_btn);
                selected_btn = (LinearLayout) view.findViewById(R.id.selected_btn);


            }
        }
    }


    /**
     * @param v
     * @param tag
     */
    public void ScreenPopup(View v, final int tag) {


        if (contentView != null)
            contentView = null;
        if (popupWindow != null)
            popupWindow = null;

        // 一个自定义的布局，作为显示的内容
//        int mHight = App.SCREEN_HEIGHT / 10 * 6;
        contentView = LayoutInflater.from(this).inflate(layoutId, null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        if (persontype.equals("教练")) {
            LinearLayout layout = (LinearLayout) contentView.findViewById(R.id.layout_Teacher);
            layout.setVisibility(View.VISIBLE);
        }
        final RadioButton btnSexMen = (RadioButton) contentView.findViewById(R.id.btn_sex_men);
        final RadioButton btnSexWomen = (RadioButton) contentView.findViewById(R.id.btn_sex_women);
        final TextView textConsultant = (TextView) contentView.findViewById(R.id.text_consultant);
        final TextView FollowTimeEnd = (TextView) contentView.findViewById(R.id.first_time_end);
        final TextView FollowTimeBegin = (TextView) contentView.findViewById(R.id.first_time_begin);
        final TextView textCollect = (TextView) contentView.findViewById(R.id.text_collect);
        final TextView TimeEnd = (TextView) contentView.findViewById(R.id.second_time_end);
        final TextView TimeBegin = (TextView) contentView.findViewById(R.id.second_time_begin);
        final TextView CollectionTimeBegin = (TextView) contentView.findViewById(R.id.Collection_time_begin);
        final TextView CollectionTimeEnd = (TextView) contentView.findViewById(R.id.Collection_time_end);
        final TextView btnconfirm = (TextView) contentView.findViewById(R.id.btn_confirm);
        final TextView btnreset = (TextView) contentView.findViewById(R.id.btn_reset);
        StartLessonBalanceText = (TextView) contentView.findViewById(R.id.StartLessonBalance);
        EndLessonBalanceText = (TextView) contentView.findViewById(R.id.EndLessonBalance);
        final RelativeLayout btnConsultant = (RelativeLayout) contentView.findViewById(R.id.btn_consultant);


        final RelativeLayout btnCoachTrackMembersPrivate = (RelativeLayout) contentView.findViewById(R.id.btn_coach_track);
        final TextView textCoachTrack = (TextView) contentView.findViewById(R.id.text_coach_track);
        if (mPostCustomerListBean.getOwnManagerName() != null)
            textConsultant.setText(mPostCustomerListBean.getOwnManagerName());//会籍顾问
        if (mPostCustomerListBean.getOwnTeacherName() != null)
            textCoachTrack.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练

        String userName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        if (IsDepartManager == 0) {
            if (persontype.equals("会籍")) {
                textConsultant.setText(userName);//会籍顾问
                ImageView imageView = (ImageView) contentView.findViewById(R.id.img_consultant);
                imageView.setVisibility(View.INVISIBLE);
                btnConsultant.setEnabled(false);
            } else if (persontype.equals("教练")) {
                textCoachTrack.setText(userName);//会籍顾问
                ImageView imageView = (ImageView) contentView.findViewById(R.id.img_coach_track);
                imageView.setVisibility(View.INVISIBLE);
                btnCoachTrackMembersPrivate.setEnabled(false);

            }
        }


        if (persontype.equals("机构用户")){
            btnConsultant.setVisibility(View.GONE);
            btnCoachTrackMembersPrivate.setVisibility(View.GONE);
        }

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
                layoutAlpha.setVisibility(View.GONE);
                mTouch = true;
            }
        });


        if (SexId != null) {
            if (SexId.equals("1")) {
                btnSexMen.setChecked(true);
            } else {
                btnSexWomen.setChecked(true);
            }
            if (SexId.equals("")) {
                btnSexMen.setChecked(false);
                btnSexWomen.setChecked(false);
            }
        }


        popupWindow.update();

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                final Intent intent = new Intent(ChartsListActivity.this, FilterListActivity.class);
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                btnConsultant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (IsDepartManager == 1) {
                            //会籍顾问
                            intent.putExtra(mStrType, MANGERLISTID);
                            startActivityForResult(intent, MANGERLISTID);//使用时需定义变量requestCode
                        } else if (personType.equals("教练")) {
                            intent.putExtra(mStrType, MANGERLISTID);
                            startActivityForResult(intent, MANGERLISTID);//使用时需定义变量requestCode

                        }
                        ;
                    }
                });

                FollowTimeBegin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(FollowTimeBegin, "开始时间");
                        pvCustomTime.show();

                    }
                });
//
                FollowTimeEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(FollowTimeEnd, "结束时间");
                        pvCustomTime.show();

                    }
                });
//
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
                CollectionTimeBegin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(TimeBegin, "开始时间");
                        pvCustomTime.show();

                    }
                });
                CollectionTimeEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(TimeEnd, "结束时间");
                        pvCustomTime.show();

                    }
                });

                btnCoachTrackMembersPrivate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //跟进教练
                        intent.putExtra(mStrType, CONTACTTEACHERLISTID);
                        startActivityForResult(intent, CONTACTTEACHERLISTID);//使用时需定义变量requestCode


                    }
                });

                btnreset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mPostCustomerListBean != null) {
                            mPostCustomerListBean = null;
                        }
                        mPostCustomerListBean = new PostCustomerListBean();
                        //自动赋值
                        mPostCustomerListBean = (PostCustomerListBean) map2Bean(check(mContext));
                        SexId = "";
                        textConsultant.setText("");//会籍顾问
                        textCoachTrack.setText("");//跟进教练
                        btnSexMen.setChecked(false);
                        btnSexWomen.setChecked(false);
                        textConsultant.setText("");
                        FollowTimeBegin.setText("开始时间");
                        FollowTimeEnd.setText("结束时间");
                        TimeBegin.setText("开始时间");
                        TimeEnd.setText("结束时间");
//                        FollowTimeEnd.setText("");
//                        FollowTimeBegin.setText("");
                        textCollect.setText("");
//                        TimeEnd.setText("");
//                        TimeBegin.setText("");
//                        CollectionTimeBegin.setText("");
//                        CollectionTimeEnd.setText("");
//                        popupWindow.dismiss();
//                        ScreenPopup(screeningBtn,0);

//                        popupWindow.dismiss();

//                        refresh();
                    }
                });

                btnconfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        refresh();


                    }
                });


                btnSexMen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SexId = "1";

                    }
                });

                btnSexWomen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SexId = "0";

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

//        popupWindow.showAtLocation(v, Gravity.TOP, 0, point[1] + v.getHeight());
//        popupWindow.showAsDropDown(v,0,0);



//        popupWindow.showAtLocation(v, Gravity.TOP, 0, point[1] + v.getHeight());
//        popupWindow.showAsDropDown(v,0,0);
        if (Build.VERSION.SDK_INT != 24) {
            //只有24这个版本有问题，好像是源码的问题
            popupWindow.showAsDropDown(v,0,2);
        } else {

            int[] location = new int[2];
            v.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, (int) (y + v.getHeight()+2));
        }


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


        if (requestCode == CONTACTTEACHERLISTID) {
            mPostCustomerListBean.setOwnTeacherId(mId);
            mPostCustomerListBean.setOwnTeacherName(mName);
        }
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                if (popupWindow != null)
                    popupWindow.dismiss();
                ScreenPopup(screeningBtn, 0);
//                    popupWindow.update();

            }
        };
        handler.post(runnable);

//        if (requestCode == CUSTOMERTAGID) {
//            mPostCustomerListBean.setLabelId(mId);
//            mPostCustomerListBean.setLabelName(mName);
//        }
//
//        if (requestCode == MANGERLISTID) {
//            mPostCustomerListBean.setOwnManagerId(mId);
//            mPostCustomerListBean.setOwnManagerName(mName);
//        }
//
//        if (requestCode == CREATEUSERLISTID) {
//            mPostCustomerListBean.setCreateUserId(mId);
//            mPostCustomerListBean.setCreateUserName(mName);
//        }
//        if (requestCode == CUSTOMERINTRODUCERID) {
//            mPostCustomerListBean.setIntroduceMemberId(mId);
//            mPostCustomerListBean.setIntroduceMemberName(mName);
//        }
//        if (requestCode == CUSTOMERSOURCEID) {
//            mPostCustomerListBean.setSourceId(mId);
//            mPostCustomerListBean.setSourceName(mName);
//        }
//        if (requestCode == CUSTOMERINTENTID) {
//            mPostCustomerListBean.setIntentId(mId);
//            mPostCustomerListBean.setIntentName(mName);
//        }
//        if (requestCode == POSTEACHERLISTID) {
//            mPostCustomerListBean.setPOSTeacherId(mId);
//            mPostCustomerListBean.setPOSTeacherName(mName);
//        }
//
//
//        if (requestCode == LESSONTEACHERLISTID) {
//            mPostCustomerListBean.setClassTeacherId(mId);
//            mPostCustomerListBean.setClassTeacherName(mName);
//        }
//
//        if (requestCode == SALETEACHERLISTID) {
//            mPostCustomerListBean.setSigninTeacherId(mId);
//            mPostCustomerListBean.setSigninTeacherName(mName);
//        }
//        if (requestCode == CLASSTYPEID) {
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
//        if (requestCode == LESSONLISTBYMEMBERKEY) {
//
//            mPostCustomerListBean.setLessonTeacherId(mId);
//
//            mPostCustomerListBean.setLessonTeacherName(mName);
//
//
////            btnEdit.setText("编辑");
////
////            linearLayoutBottom.setVisibility(View.GONE);
//
////            editShow = false;
//
//            commonAdapter.notifyDataSetChanged();
//
//
//        }


        //// TODO: 2017/6/5 办卡类型未实现
//        if (requestCode == ALLMEMBERCARDTYPEID ) {
//
//            mPostCustomerListBean.set(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }


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
                    case R.id.Collection_time_begin:
                        mPostCustomerListBean.setCollection_time_begin(getTime(date));
                        break;
                    case R.id.Collection_time_end:
                        mPostCustomerListBean.setCollection_time_end(getTime(date));
                        break;
                    case R.id.StartLessonCreateTime:
                        mPostCustomerListBean.setStartLessonCreateTime(getTime(date));
                        break;
                    case R.id.EndLessonCreateTime:
                        mPostCustomerListBean.setEndLessonCreateTime(getTime(date));
                        break;

                    case R.id.StartLessonStopTime:
                        mPostCustomerListBean.setStartLessonStopTime(getTime(date));
                        break;
                    case R.id.EndLessonStopTime:
                        mPostCustomerListBean.setEndLessonStopTime(getTime(date));
                        break;


                }


                pvCustomTime.dismiss();
            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)

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
                                        mPostCustomerListBean.setStartLastContactTime("");
                                        break;
                                    case R.id.first_time_end:
                                        mPostCustomerListBean.setEndLastContactTime("");
                                        break;
                                    case R.id.second_time_begin:
                                        mPostCustomerListBean.setStartCreateTime("");
                                        break;
                                    case R.id.second_time_end:
                                        mPostCustomerListBean.setEndCreateTime("");
                                        break;
                                    case R.id.Collection_time_begin:
                                        mPostCustomerListBean.setCollection_time_begin("");
                                        break;
                                    case R.id.Collection_time_end:
                                        mPostCustomerListBean.setCollection_time_end("");
                                        break;
                                    case R.id.StartLessonCreateTime:
                                        mPostCustomerListBean.setStartLessonCreateTime("");
                                        break;
                                    case R.id.EndLessonCreateTime:
                                        mPostCustomerListBean.setEndLessonCreateTime("");
                                        break;

                                    case R.id.StartLessonStopTime:
                                        mPostCustomerListBean.setStartLessonStopTime("");
                                        break;
                                    case R.id.EndLessonStopTime:
                                        mPostCustomerListBean.setEndLessonStopTime("");
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


}
