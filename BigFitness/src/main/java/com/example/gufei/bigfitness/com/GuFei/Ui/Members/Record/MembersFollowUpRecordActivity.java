package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListByMemberIDBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord.MembersAppointmentRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments.LessonReportDocumentsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments.MedicalReportDocumentsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_REPORT;
import static com.example.gufei.bigfitness.Constants.BASEURL;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.IMAGURL;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/*
*
* 会员,私教
*
* 跟进 预约等入口
* */
public class MembersFollowUpRecordActivity extends BaseActivity<MembersFollowUpRecordActivityPresenter> implements MembersFollowUpRecordActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_customer_type)
    TextView textCustomerType;
    @BindView(R.id.text_customer_name)
    TextView textCustomerName;
    @BindView(R.id.text_customer_img)
    ImageView textCustomerImg;
    @BindView(R.id.btn_appointment)
    ImageView btnAppointment;
    @BindView(R.id.btn_customer_info)
    ImageView btnCustomerInfo;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.btn_report_medical)
    LinearLayout btnReportMedical;
    @BindView(R.id.btn_report_appointment)
    LinearLayout btnReportAppointment;
    @BindView(R.id.btn_class_record)
    LinearLayout btnClassRecord;

    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerId = "";
    private String memberId = "";
    private String CustomerSex = "";
    private String My;
    String personType;

    private View contentView;

    private PopupWindow popupWindow;


    private CommonAdapter<MemberAppointmentListByMemberIDBean.ResultBean> commonAdapter;
    private CommonAdapter<ContactListForCustomerBean.ResultBean> commonAdapter1;


    private List<MemberAppointmentListByMemberIDBean.ResultBean> datas = new ArrayList<MemberAppointmentListByMemberIDBean.ResultBean>();
    private List<ContactListForCustomerBean.ResultBean> datas1 = new ArrayList<ContactListForCustomerBean.ResultBean>();


    @Override

    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_members_follow_up_record;
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
//        tvTitle.setText("这是一个标题");
        Intent intent = getIntent();

        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");
        memberId = intent.getStringExtra(PUT_STR + "memberId");
        My = intent.getStringExtra(PUT_STR + "My");
        if (!My.equals("我的")) {
            floatingActionButton.setVisibility(View.GONE);
        }
        textCustomerType.setText(CustomerType);
        textCustomerName.setText(CustomerName);
        personType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
        if (CustomerSex.equals("男")) {
            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_men);
        } else {
            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_women);
        }

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<MemberAppointmentListByMemberIDBean.ResultBean>(R.layout.cardview_activity_follow_up_record, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final MemberAppointmentListByMemberIDBean.ResultBean listBean, int i) {

                holder.setText(R.id.follow_up_content_create_name_create_user, listBean.getAppointmentTypeName());//名称
                if (listBean.getCreateTime() != null) {
                    final String[] tempArr = listBean.getCreateTime().split(" ");

                    final String[] MonArr = tempArr[0].split("-");

                    holder.setText(R.id.follow_up_content_create_time, tempArr[1]);//操作时间
                    if (MonArr != null) {
//
//                    final String[] tempArr = listBean.getCreateTime1().split("月");
//
                        holder.setText(R.id.follow_up_month, MonArr[1] + "月");//月
                        holder.setText(R.id.follow_up_day, MonArr[2]);//日
//
                    }
                }
                String AppointmentResult = "";
                if (listBean.getSType().equals("2")) {

                    if (personType.equals("教练")) {
                        AppointmentResult += "预约开始时间:" + listBean.getAppointStartTime() + "\n";
                        AppointmentResult += "预约结束时间:" + listBean.getAppointEndTime() + "\n";
                        AppointmentResult += "预约结果:" + listBean.getAppointmentResultName() + "\n";
                        AppointmentResult += "备注:" + listBean.getContactContent() + "\n";
                    } else {
                        AppointmentResult += listBean.getContactContent() + "\n";
                    }
                } else {
                    AppointmentResult += listBean.getContactContent() + "\n";
                }
                holder.setText(R.id.client_follow_up_content, AppointmentResult);//内容
                holder.setText(R.id.follow_up_content_create_name, listBean.getMemberName());
                ViewGroup.LayoutParams Params = (ViewGroup.LayoutParams) holder.getView(R.id.follow_up_iv).getLayoutParams(); //取控件textView当前的布局参数
                Params.height = 300;// 控件的高强制

                holder.getView(R.id.follow_up_iv).setLayoutParams(Params);
                holder.setImage(R.id.img1).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img2).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img3).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img4).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img5).setVisibility(View.INVISIBLE);

                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
//                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.head_img, holder.setImage(R.id.head_img_iv));//头像
                displayCircleImage(context, listBean.getHeaderURL(), holder.setImage(R.id.head_img_iv), R.mipmap.head_img);//头像

                if (listBean.getImageList().size() > 0) {


                    LinearLayout imgLayput = holder.getView(R.id.img_layout);

                    imgLayput.setTag(listBean.getImageList().get(0).getImageurl());

                    imgLayput.setVisibility(View.VISIBLE);
                    if (listBean.getImageList().get(0).getImageurl() == imgLayput.getTag()) {
                        imgLayput.setVisibility(View.VISIBLE);
                    } else {
                        imgLayput.setVisibility(View.INVISIBLE);
                    }


                    //给ImageView打上Tag作为特有标记
//                    ImageView image = holder.getView(R.id.img1);
//
//
//
////根据tag判断是不是需要设置给ImageView

                    for (int j = 0; j < listBean.getImageList().size(); j++) {

                        try {

                            ImageView imageView = holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null));
                            final String imgUrl = IMAGURL + listBean.getImageList().get(j).getImageurl().trim();
                            Glide
                                    .with(context)
                                    .load(imgUrl)
                                    .error(R.mipmap.null_img)
                                    .placeholder(R.mipmap.null_img)
                                    .into(imageView);


                            imageView.setVisibility(View.VISIBLE);
                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MembersFollowUpRecordActivity.this, ImageActivity.class);

                                    intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", imgUrl);
                                    intent.putExtra("com.example.gufei.bigfitness.com.GuFei.local", true);

                                    startActivity(intent);
                                }
                            });
                        } catch (IllegalAccessException e) {

                            e.printStackTrace();

                        } catch (NoSuchFieldException e) {

                            e.printStackTrace();

                        }

                    }
                }
//                }
                if (listBean.getSType().equals("2")) {
                    holder.getView(R.id.img_layout).setVisibility(View.GONE);



                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (listBean.getAppType().equals("4")) {

                                Intent intent = new Intent(context, ReservationRecordActivity.class);
                                intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                                intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
                                intent.putExtra(PUT_STR + "Type", CustomerType);
                                intent.putExtra(PUT_STR + "Sex", CustomerSex);
                                intent.putExtra(PUT_STR + "My", My);
                                intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());
                                intent.putExtra(mStrType, REFRESHID);
                                startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode

                            } else if (!listBean.getAppType().equals("3")) {

                                Intent intent = new Intent(context, ReservationRecordMembersActivity.class);
                                intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getMemberId()));
                                intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
                                intent.putExtra(PUT_STR + "Type", CustomerType);
                                intent.putExtra(PUT_STR + "Sex", CustomerSex);
                                if (listBean.getAppointmentTypeName().equals("上课预约")) {
                                    intent.putExtra(PUT_STR + "AppointmentType", "2");
                                } else {
                                    intent.putExtra(PUT_STR + "AppointmentType", "1");
                                }
                                intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(listBean.getAppointmentId()));
                                intent.putExtra(mStrType, REFRESHID);
                                startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                            }

                        }


                    });


                }
//
            }


        };

        commonAdapter1 = new CommonAdapter<ContactListForCustomerBean.ResultBean>(R.layout.cardview_activity_follow_up_record, this, datas1) {


            @Override
            protected void convert(final ViewHolder holder, final ContactListForCustomerBean.ResultBean listBean, int i) {

                holder.setText(R.id.follow_up_content_create_name_create_user, listBean.getAppointmentTypeName());//名称
                if (listBean.getCreateTime1() != null) {
                    final String[] tempArr = listBean.getCreateTime1().split("月");

//                    final String[] MonArr = tempArr[0].split("-");

                    holder.setText(R.id.follow_up_content_create_time, listBean.getCreateTime2());//操作时间
                    if (tempArr != null) {
//
//                    final String[] tempArr = listBean.getCreateTime1().split("月");
//
                        holder.setText(R.id.follow_up_month, tempArr[0] + "月");//月
                        holder.setText(R.id.follow_up_day, tempArr[1]);//日
//
                    }
                }
                String AppointmentResult = "";
                if (listBean.getSType().equals("2")) {

//                    if (personType.equals("教练")) {
//                        AppointmentResult += "预约开始时间:" + listBean.get() + "\n";
//                        AppointmentResult += "预约结束时间:" + listBean.getAppointEndTime() + "\n";
//                        AppointmentResult += "预约结果:" + listBean.getAppointmentResultName() + "\n";
//                        AppointmentResult += "备注:" + listBean.getContactContent() + "\n";
//                    } else {
                        AppointmentResult += listBean.getContactContent() + "\n";
//                    }
                } else {
                    AppointmentResult += listBean.getContactContent() + "\n";
                }
                holder.setText(R.id.client_follow_up_content, AppointmentResult);//内容
                holder.setText(R.id.follow_up_content_create_name, listBean.getCustomerName());
                ViewGroup.LayoutParams Params = (ViewGroup.LayoutParams) holder.getView(R.id.follow_up_iv).getLayoutParams(); //取控件textView当前的布局参数
                Params.height = 300;// 控件的高强制

                holder.getView(R.id.follow_up_iv).setLayoutParams(Params);
                holder.setImage(R.id.img1).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img2).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img3).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img4).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img5).setVisibility(View.INVISIBLE);

                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
//                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.head_img, holder.setImage(R.id.head_img_iv));//头像
                displayCircleImage(context, listBean.getHeaderURL(), holder.setImage(R.id.head_img_iv), R.mipmap.head_img);//头像

                if (listBean.getImageList().size() > 0) {


                    LinearLayout imgLayput = holder.getView(R.id.img_layout);

                    imgLayput.setTag(listBean.getImageList().get(0).getImageurl());

                    imgLayput.setVisibility(View.VISIBLE);
                    if (listBean.getImageList().get(0).getImageurl() == imgLayput.getTag()) {
                        imgLayput.setVisibility(View.VISIBLE);
                    } else {
                        imgLayput.setVisibility(View.INVISIBLE);
                    }


                    //给ImageView打上Tag作为特有标记
//                    ImageView image = holder.getView(R.id.img1);
//
//
//
////根据tag判断是不是需要设置给ImageView

                    for (int j = 0; j < listBean.getImageList().size(); j++) {

                        try {

                            ImageView imageView = holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null));
                            final String imgUrl = BASEURL + listBean.getImageList().get(j).getImageurl().trim();
                            Glide
                                    .with(context)
                                    .load(imgUrl)
                                    .error(R.mipmap.null_img)
                                    .placeholder(R.mipmap.null_img)
                                    .into(imageView);


                            imageView.setVisibility(View.VISIBLE);
                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MembersFollowUpRecordActivity.this, ImageActivity.class);

                                    intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", imgUrl);
                                    intent.putExtra("com.example.gufei.bigfitness.com.GuFei.local", true);

                                    startActivity(intent);
                                }
                            });
                        } catch (IllegalAccessException e) {

                            e.printStackTrace();

                        } catch (NoSuchFieldException e) {

                            e.printStackTrace();

                        }

                    }
                }
//                }

//
                if (listBean.getSType().equals("2")) {
                    holder.getView(R.id.img_layout).setVisibility(View.GONE);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, ReservationRecordActivity.class);
                            intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                            intent.putExtra(PUT_STR + "Name", listBean.getCustomerName());
                            intent.putExtra(PUT_STR + "Type", CustomerType);
//                            intent.putExtra(PUT_STR + "Type", "Non");
                            intent.putExtra(PUT_STR + "Sex", CustomerSex);
                            intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());
                            startActivity(intent);

                        }
//
//
                    });

                }
//                }
//
            }


        };
        recyclerView.setAdapter(commonAdapter);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        commonAdapter.setShowFooter(false);
        commonAdapter1.setShowFooter(false);

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
    public void succeed(MemberAppointmentListByMemberIDBean memberAppointmentListByMemberID) {
        swipeRefreshLayout.setRefreshing(false);
        try {
            datas = memberAppointmentListByMemberID.getResult();
            recyclerView.setAdapter(commonAdapter);
            commonAdapter.replaceData(datas);

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    public void succeed1(ContactListForCustomerBean contactListForCustomerBean) {
        swipeRefreshLayout.setRefreshing(false);
        try {
            datas1 = contactListForCustomerBean.getResult();
            recyclerView.setAdapter(commonAdapter1);
            commonAdapter1.replaceData(datas1);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void refresh() {
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        String PersonType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
        if (CustomerType.equals("过期会员")) {
            mPresenter.getContactListForCustomer(UserName, UserId, token, ClubId, "", CustomerId, PersonType);
        } else {
            mPresenter.getMemberAppointmentListByMemberID(UserName, UserId, token, ClubId, String.valueOf(IsDepartManager), memberId, PersonType);
        }
    }


    @OnClick({R.id.btn_customer_info, R.id.btn_appointment, R.id.fab, R.id.btn_report_medical, R.id.btn_report_appointment, R.id.btn_class_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_report_appointment:

                //预约记录
                Intent intent = new Intent(context, MembersAppointmentRecordActivity.class);
                intent.putExtra(PUT_STR + "Id", memberId);
                intent.putExtra(PUT_STR + "CustomerId", CustomerId);
                intent.putExtra(PUT_STR + "ActType", "预约列表");
                intent.putExtra(PUT_STR + "Name", CustomerName);
                intent.putExtra(PUT_STR + "Type", CustomerType);
                intent.putExtra(PUT_STR + "My", My);
                intent.putExtra(PUT_STR + "Sex", CustomerSex);
                startActivity(intent);
                break;
            case R.id.btn_customer_info:

                //会员信息
                Intent CustomerInfo = new Intent(context, MembersInfoActivity.class);
                CustomerInfo.putExtra(PUT_STR + "Id", memberId);
                CustomerInfo.putExtra(PUT_STR + "Name", CustomerName);
                CustomerInfo.putExtra(PUT_STR + "Type", CustomerType);
                CustomerInfo.putExtra(PUT_STR + "Sex", CustomerSex);
                startActivity(CustomerInfo);
                break;
            case R.id.fab:

                AddFollpwAndAppointmentPopup(view, 0);
                break;
            case R.id.btn_class_record:

                if (personType.equals("会籍")) {
                    s(this, "会籍无权查看上课记录");
                    break;
                }

                //课程信息
                Intent LessonReport = new Intent(context, LessonReportDocumentsListActivity.class);
                LessonReport.putExtra(PUT_STR + "Id", memberId);
                LessonReport.putExtra(PUT_STR + "Name", CustomerName);
                LessonReport.putExtra(PUT_STR + "Type", CustomerType);
                LessonReport.putExtra(PUT_STR + "Sex", CustomerSex);
                startActivity(LessonReport);
                break;

            case R.id.btn_report_medical:

                //体测报告
                Intent MedicalReportDocumentsList = new Intent(context, MedicalReportDocumentsListActivity.class);
                MedicalReportDocumentsList.putExtra(PUT_STR + "Id", memberId);
                MedicalReportDocumentsList.putExtra(PUT_STR + "Name", CustomerName);
                MedicalReportDocumentsList.putExtra(PUT_STR + "Type", CustomerType);
                MedicalReportDocumentsList.putExtra(PUT_STR + "Sex", CustomerSex);
                MedicalReportDocumentsList.putExtra(PUT_STR + "Type", ACTIVITY_ID_REPORT);
                startActivity(MedicalReportDocumentsList);

                break;


        }
    }

    public void AddFollpwAndAppointmentPopup(View v, final int tag) {


        if (contentView != null) contentView = null;

        if (popupWindow != null) popupWindow = null;


        contentView = LayoutInflater.from(this).inflate(R.layout.pop_add_follow_appointent, null);

        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        popupWindow.update();


        backgroundAlpha(0.5f);


        final LinearLayout btnFollowAdd = (LinearLayout) contentView.findViewById(R.id.btn_follow_add);

        final LinearLayout btnAppointmentAdd = (LinearLayout) contentView.findViewById(R.id.btn_appointment_add);

        final TextView btnClose = (TextView) contentView.findViewById(R.id.btn_close);
        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //标签
                        popupWindow.dismiss();
                    }
                });


                btnFollowAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //跟进
                        popupWindow.dismiss();

                        if (!CustomerType.equals("过期会员")) {

                            Intent intent = new Intent(context, AddMembersFollowActivity.class);

                            intent.putExtra(PUT_STR + "Id", CustomerId);
                            intent.putExtra(PUT_STR + "memberId", memberId);
                            intent.putExtra(PUT_STR + "Name", CustomerName);
                            intent.putExtra(PUT_STR + "Type", CustomerType);
                            intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                        AppointmentId
                            intent.putExtra(PUT_STR + "AppointmentId", "");

                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(context, AddFollowActivity.class);

                            intent.putExtra(PUT_STR + "Id", CustomerId);
                            intent.putExtra(PUT_STR + "Name", CustomerName);
                            intent.putExtra(PUT_STR + "Type", CustomerType);
                            intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                        AppointmentId
                            intent.putExtra(PUT_STR + "AppointmentId", "");

                            intent.putExtra(mStrType, REFRESHID);
                            startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                        }


                    }
                });
                btnAppointmentAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //预约
                        popupWindow.dismiss();
                        Intent intent = new Intent(context, AddMebersAppointmentActivity.class);

                        intent.putExtra(PUT_STR + "Id", CustomerId);
                        intent.putExtra(PUT_STR + "memberId", memberId);
                        intent.putExtra(PUT_STR + "Name", CustomerName);
                        intent.putExtra(PUT_STR + "Type", CustomerType);
                        intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                        AppointmentId
//                        intent.putExtra(PUT_STR + "AppointmentId", "0") ;

                        startActivity(intent);


                    }
                });


                return false;


            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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


            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == REFRESHID) {
            refresh();

        }

    }
}
