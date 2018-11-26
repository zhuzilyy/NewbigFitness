package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberBodyReportListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport.AddReportActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments.LessonReportDocumentsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_CLASS_RECORD;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_RECORDS_GIVING;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_REPORT;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_REPORT_APPOINTMENT;
import static com.example.gufei.bigfitness.Constants.CERVIX_DATAS;
import static com.example.gufei.bigfitness.Constants.CERVIX_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ListUtil.Arr2List;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class MedicalReportDocumentsListActivity extends BaseActivity<MedicalReportDocumentsListActivityPresenter> implements MedicalReportDocumentsListActivityContract.View, SpinnerPopContract {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.btn_up_img)
    ImageView btnUpImg;
    @BindView(R.id.btn_screen)
    ImageView btnScreen;
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


    private List<String> mInterfaceDatas;


    private List<Integer> mSelectedArr;

    //筛选显示标识
    private boolean sortingShow = true;

    //筛选首次运行标识
    private boolean firstSortingShow = true;

    private int mSelectedCount = 0;


    private int Type;

    private int mLayoutId;

    private SpinnerAdapter spinnerAdapter = new SpinnerAdapter();

    private SpinnerPopupWindow s;


    private View contentView;

    private PopupWindow popupWindow;


    private CommonAdapter<MemberBodyReportListBean.ResultBean> commonAdapter;


    private List<MemberBodyReportListBean.ResultBean> datas = new ArrayList<MemberBodyReportListBean.ResultBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_medical_report_documents_list;
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

        switch (Type) {


            case ACTIVITY_ID_REPORT:

                tvTitle.setText("体测报告记录");

                mLayoutId = R.layout.cardview_record_list;

                btnScreen.setImageResource(R.mipmap.sorting);

                btnUpImg.setImageResource(R.mipmap.testreport01_03);


//                sortingShow = false;


                break;
            case ACTIVITY_ID_REPORT_APPOINTMENT:


                break;
            case ACTIVITY_ID_CLASS_RECORD:


                break;
            case ACTIVITY_ID_RECORDS_GIVING:


                break;


        }


        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<MemberBodyReportListBean.ResultBean>(mLayoutId, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final MemberBodyReportListBean.ResultBean listBean, int i) {

                holder.setText(R.id.text_time_begin, "    操作时间:" + listBean.getReporttime());

                holder.setText(R.id.text_time_end, "    生成时间:" + listBean.getCreatetime());


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MedicalReportDocumentsListActivity.this, ImageActivity.class);

                        intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", listBean.getReporturl());

                        startActivity(intent);


                    }
                });

////
//                    holder.setText(R.id.follow_up_content_create_time, listBean.getCreateTime2());//操作时间
////
//                    holder.setText(R.id.client_follow_up_content, "内容：" + listBean.getContactContent());//内容
////
//                    holder.setText(R.id.follow_up_content_create_name, listBean.getCustomerName());//提示数字
//
//                    if (listBean.getCreateTime1() != null) {
//
//                        final String[] tempArr = listBean.getCreateTime1().split("月");
//
//                        holder.setText(R.id.follow_up_month, tempArr[0] + "月");//月
//
//                        holder.setText(R.id.follow_up_day, tempArr[1]);//日
//
//                    }
//
//
////                holder.setText(R.id.hint_num, listBean.getHint_num());//提示数字
//
////                ViewGroup.LayoutParams Params =(ViewGroup.LayoutParams) holder.getView(R.id.follow_up_iv).getLayoutParams(); //取控件textView当前的布局参数
////
////
////                Params.height =300;// 控件的高强制设成20
////
////
////
////                holder.getView(R.id.follow_up_iv).setLayoutParams(Params);
//
//
////
//                    loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.head_img, holder.setImage(R.id.head_img_iv));//头像
//
//                    if (listBean.getImageList().size() > 0) {
//
//                        for (int j = 0; j < listBean.getImageList().size(); j++) {
//
//                            try {
//
//                                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.null_img, holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null)));
//
//                            } catch (IllegalAccessException e) {
//
//                                e.printStackTrace();
//
//                            } catch  (NoSuchFieldException e) {
//
//                                e.printStackTrace();
//
//                            }
//
//                        }
//
//                    }
//                    if (listBean.getSType() .equals("2")) {
//
//                        holder.itemView.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                                Intent intent = new Intent(context, ReservationRecordActivity.class);
//
//                                intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
//                                intent.putExtra(PUT_STR + "Name", listBean.getCustomerName());
//                                intent.putExtra(PUT_STR + "Type", CustomerType);
//                                intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                                intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());
//
//                                startActivity(intent);
//
//
//                            }
//                        });


//                }

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

    private void refresh() {


        String mOrderName = mInterfaceDatas.get(0).toString();

        int mOrderType = 2;


        for (int i = 0; i < mSelectedArr.size(); i++) {
            if (mSelectedArr.get(i) > 0) {

                mOrderName = mInterfaceDatas.get(i).toString();

                mOrderType = mSelectedArr.get(i);


            }

        }


        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);


        switch (Type) {


            case ACTIVITY_ID_REPORT:

                mPresenter.getMemberBodyReportList(UserId, token, ClubId, CustomerId, mOrderName, mOrderType == 1 ? "asc" : "desc");


                break;
            case ACTIVITY_ID_REPORT_APPOINTMENT:


                break;
            case ACTIVITY_ID_CLASS_RECORD:


                break;
            case ACTIVITY_ID_RECORDS_GIVING:


                break;


        }


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
    public void succeed(MemberBodyReportListBean memberBodyReportListBean) {


        for (int i = 0; i < mSelectedArr.size(); i++) {

            mSelectedArr.set(i, 0);

        }
//        datas=memberBodyReportListBean.getResult();

        swipeRefreshLayout.setRefreshing(false);

        try {

            datas = memberBodyReportListBean.getResult();

//            for (int i = 0; i < datas.size(); i++) {
//
//                mSelectdatas.add("0");
//            }

            commonAdapter.replaceData(datas);


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

                    intent = new Intent(MedicalReportDocumentsListActivity.this, AddReportActivity.class);

                    intent.putExtra(PUT_STR + "Id", CustomerId);
                    intent.putExtra(PUT_STR + "Name", CustomerName);
                    intent.putExtra(PUT_STR + "Type", CustomerType);
                    intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());
                    startActivity(intent);

                } else {
                    s(this, "会籍无权此操作");

                }


//                intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());

                break;
            case R.id.btn_screen:

                if (sortingShow) {


                    s = new SpinnerPopupWindow
                            .Builder(MedicalReportDocumentsListActivity.this)
                            .setmLayoutManager(null)
                            .setOutsideTouchable(true)
//                        .setTitleText("性别")
                            .setmSpinnerPopContract(MedicalReportDocumentsListActivity.this)
                            .setmAdapter(spinnerAdapter)

                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                            .build();

                    s.showPopWindowCenter(view);
                    s.setTitleshow(false);

                    sortingShow = false;

                }
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

        if (mSelectedArr.get(mSelectedCount) > 0) {

//            sortingText.setTextColor(getResources().getColor(R.color.selected_color));

            btnScreen.setImageResource(R.mipmap.sortingsecleted);

        } else {

//            sortingText.setTextColor(getResources().getColor(R.color.all_back_color));

            btnScreen.setImageResource(R.mipmap.sorting);

        }
        backgroundAlpha(1f);
        refresh();


        sortingShow = true;
    }


    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MedicalReportDocumentsListActivity.this).inflate(R.layout.item_pop, parent,
                    false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MedicalReportDocumentsListActivity.SpinnerAdapter.MyViewHolder holder, final int position) {


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
                    s.dismissPopWindow();
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
}
