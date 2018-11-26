package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord;

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

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListAllBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment.AddAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;
/*
* 预约列表
*
* */
public class MembersAppointmentRecordActivity extends BaseActivity<MembersAppointmentRecordActivityPresenter> implements MembersAppointmentRecordActivityContract.View {


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
    FloatingActionButton fab;


    private View contentView;

    private PopupWindow popupWindow;

    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerId = "";
    private String memberId = "";
    private String CustomerSex = "";
    private String ActType = "";


    private CommonAdapter<MemberAppointmentListAllBean.ResultBean> commonAdapter;
    private List<MemberAppointmentListAllBean.ResultBean> datas = new ArrayList<MemberAppointmentListAllBean.ResultBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_follow_up_record;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        btnAppointment.setVisibility(View.GONE);
        btnCustomerInfo.setVisibility(View.GONE);
//        tvTitle.setText("这是一个标题");
        Intent intent = getIntent();
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        memberId = intent.getStringExtra(PUT_STR + "Id");


        ActType = intent.getStringExtra(PUT_STR + "ActType");
        CustomerId = intent.getStringExtra(PUT_STR + "CustomerId");

        String My = intent.getStringExtra(PUT_STR + "My");
        if (!My.equals("我的")) {
            fab.setVisibility(View.GONE);
        }

        final String PersonType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
        tvTitle.setText(ActType);
        textCustomerType.setText(CustomerType);
        textCustomerName.setText(CustomerName);
        if (CustomerSex.equals("男")) {
            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_men);
        } else {
            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_women);
        }
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<MemberAppointmentListAllBean.ResultBean>(R.layout.cardview_activity_appointment_up_record, MembersAppointmentRecordActivity.this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final MemberAppointmentListAllBean.ResultBean listBean, int i) {
                holder.setText(R.id.text_user_name, listBean.getMemberName());//名称
                holder.setText(R.id.text_time, listBean.getCreateTime());//操作时间
                holder.setText(R.id.text_type_name, listBean.getAppointmentTypeName());//类型
//                holder.setText(R.id.client_follow_up_content, "内容：" + listBean.getContent());//内容
                String AppointmentResult = "";

                        AppointmentResult += "预约开始时间:" + listBean.getStartTime() + "\n";
                        AppointmentResult += "预约结束时间:" + listBean.getEndTime() + "\n";
                        AppointmentResult += "预约结果:" + listBean.getAppointmentResultName() + "\n";
                        AppointmentResult += "备注:" + listBean.getContent() + "\n";
                holder.setText(R.id.client_follow_up_content, "内容：" +AppointmentResult);//内容
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (PersonType.equals("会籍")) {
                            Intent intent1 = new Intent(context, ReservationRecordActivity.class);
                            intent1.putExtra(PUT_STR + "Id", CustomerId);
                            intent1.putExtra(PUT_STR + "Name", listBean.getMemberName());
                            intent1.putExtra(PUT_STR + "Type", CustomerType);
                            intent1.putExtra(PUT_STR + "Sex", CustomerSex);
                            intent1.putExtra(PUT_STR + "AppointmentId", String.valueOf(listBean.getAppointmentId()));
                            startActivity(intent1);
                        } else {
                            Intent intent = new Intent(context, ReservationRecordMembersActivity.class);
                            intent.putExtra(PUT_STR + "Id", memberId);
                            intent.putExtra(PUT_STR + "Name", CustomerName);

                            intent.putExtra(PUT_STR + "Type", listBean.getAppointmentTypeName());
//                       intent.putExtra(PUT_STR + "Sex", CustomerSex);
                            intent.putExtra(PUT_STR + "Sex", "女");
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(listBean.getAppointmentId()));
//                            intent.putExtra(PUT_STR + "AppointmentType", listBean.getAppointmentTypeName());
                            if (listBean.getAppointmentTypeName().equals("上课预约")) {
                                intent.putExtra(PUT_STR + "AppointmentType", "2");
                            } else {
                                intent.putExtra(PUT_STR + "AppointmentType", "1");
                            }
                            startActivity(intent);
                        }


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
    public void succeed(MemberAppointmentListAllBean memberAppointmentListAllBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {

            datas = memberAppointmentListAllBean.getResult();

            commonAdapter.replaceData(datas);


        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public void refresh() {


        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String PersonType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        mPresenter.getMemberAppointmentListAll(UserName, UserId, token, ClubId, "", memberId, PersonType);


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

                        //标签
                        popupWindow.dismiss();
//                        Intent intent = new Intent(context, AddFollowActivity.class);
//
//                        intent.putExtra(PUT_STR + "Id", memberId);
//                        intent.putExtra(PUT_STR + "Name", CustomerName);
//                        intent.putExtra(PUT_STR + "Type", CustomerType);
//                        intent.putExtra(PUT_STR + "Sex", CustomerSex);
////                        AppointmentId
//                        intent.putExtra(PUT_STR + "AppointmentId", "");
//
//                        intent.putExtra(mStrType, REFRESHID);
//                        startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode

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
                        }else{
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

                        //标签
                        popupWindow.dismiss();

                        Intent intent = new Intent(context, AddMebersAppointmentActivity.class);

                        intent.putExtra(PUT_STR + "Id", CustomerId);
                        intent.putExtra(PUT_STR + "memberId", memberId);
                        intent.putExtra(PUT_STR + "Name", CustomerName);
                        intent.putExtra(PUT_STR + "Type", CustomerType);
                        intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                        AppointmentId
//                        intent.putExtra(PUT_STR + "AppointmentId", "0");

                        intent.putExtra(mStrType, REFRESHID);
                        startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode


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


    @OnClick(R.id.fab)
    public void onViewClicked(View view) {

        AddFollpwAndAppointmentPopup(view, 0);
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
