package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record;

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
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment.AddAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord.AppointmentRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo.CustomerInfoCollectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_SEX;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class FollowUpRecordActivity extends BaseActivity<FollowUpRecordActivityPresenter> implements FollowUpRecordActivityContract.View {


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

    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerId = "";
    private String CustomerSex = "";
    private String memberId = "";
    private String My;
    private String  mType ;


    private View contentView;

    private PopupWindow popupWindow;


    private CommonAdapter<ContactListForCustomerBean.ResultBean> commonAdapter;


    private List<ContactListForCustomerBean.ResultBean> datas = new ArrayList<ContactListForCustomerBean.ResultBean>();

    @Override

    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_follow_up_record;
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


        if (CustomerType.trim().equals("客户")) {
            btnAppointment.setVisibility(View.VISIBLE);
        } else {
            btnAppointment.setVisibility(View.GONE);
        }


        if (CustomerSex.equals("男")) {
            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_men);
        } else {
            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_women);
        }

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<ContactListForCustomerBean.ResultBean>(R.layout.cardview_activity_follow_up_record, this, datas) {

            @Override
            protected void convert(final ViewHolder holder, final ContactListForCustomerBean.ResultBean listBean, int i) {

                holder.setText(R.id.follow_up_content_create_name_create_user, listBean.getAppointmentTypeName());//名称
                holder.setText(R.id.follow_up_content_create_time, listBean.getCreateTime2());//操作时间
                holder.setText(R.id.client_follow_up_content, listBean.getContactContent());//内容
                holder.setText(R.id.follow_up_content_create_name, listBean.getCustomerName());//提示数字
                if (listBean.getCreateTime1() != null) {
                    final String[] tempArr = listBean.getCreateTime1().split("月");
                    holder.setText(R.id.follow_up_month, tempArr[0] + "月");//月
                    holder.setText(R.id.follow_up_day, tempArr[1]);//日

                }

//                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.head_img, holder.setImage(R.id.head_img_iv));//头像
                displayCircleImage(context, listBean.getHeaderURL(), holder.setImage(R.id.head_img_iv), R.mipmap.head_img);//头像

                holder.setImage(R.id.img1).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img2).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img3).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img4).setVisibility(View.INVISIBLE);
                holder.setImage(R.id.img5).setVisibility(View.INVISIBLE);


                if (listBean.getImageList().size() > 0) {
                    LinearLayout imgLayput = holder.getView(R.id.img_layout);
                    imgLayput.setTag(listBean.getImageList().get(0).getImageurl());
                    imgLayput.setVisibility(View.VISIBLE);
                    if (listBean.getImageList().get(0).getImageurl() == imgLayput.getTag()) {
                        imgLayput.setVisibility(View.VISIBLE);
                    } else {
                        imgLayput.setVisibility(View.INVISIBLE);
                    }
                    for (int j = 0; j < listBean.getImageList().size(); j++) {
                        try {
                            ImageView iv = holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null));
                            iv.setVisibility(View.VISIBLE);
//                            if (tag.equals(iv.getTag())) {
                            loadIntoUseFitWidth(context, listBean.getImageList().get(j).getImageurl(), R.mipmap.null_img, iv);
//                            }
//                            holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null)).setVisibility(View.VISIBLE);
                            iv.setVisibility(View.VISIBLE);
                            final Intent intent = new Intent(FollowUpRecordActivity.this, ImageActivity.class);
                            intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", listBean.getImageList().get(j).getImageurl() + "");

                            iv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
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



                                Intent intent = new Intent(context, ReservationRecordActivity.class);
                                intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                                intent.putExtra(PUT_STR + "Name", listBean.getCustomerName());
                                intent.putExtra(PUT_STR + "Type", CustomerType);
//                            intent.putExtra(PUT_STR + "Type", "Non");
                                intent.putExtra(PUT_STR + "Sex", CustomerSex);
                                intent.putExtra(PUT_STR + "AppointmentId", listBean.getAppointmentId());

                                startActivity(intent);






                        }
                    });


                }

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
    public void succeed(ContactListForCustomerBean contactListForCustomerBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {

            datas = contactListForCustomerBean.getResult();

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

        mPresenter.getContactListForCustomer(UserName, UserId, token, ClubId, "", CustomerId, PersonType);


    }

    @OnClick({R.id.btn_customer_info, R.id.btn_appointment, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_appointment:
                Intent intent = new Intent(context, AppointmentRecordActivity.class);
                intent.putExtra(PUT_STR + "Id", CustomerId);
                intent.putExtra(PUT_STR + "ActType", "预约列表");
                intent.putExtra(PUT_STR + "Name", CustomerName);
                intent.putExtra(PUT_STR + "Type", CustomerType);
                intent.putExtra(PUT_STR + "My", My);
                intent.putExtra(PUT_STR + "Sex", CustomerSex);
                startActivity(intent);


                break;
            case R.id.btn_customer_info:

                if (CustomerType.equals("客户")){
                    Intent CustomerInfo = new Intent(context, CustomerInfoCollectionActivity.class);
                    CustomerInfo.putExtra(PUT_STR + "Id", CustomerId);
                    CustomerInfo.putExtra(PUT_STR + "Name", CustomerName);
                    CustomerInfo.putExtra(PUT_STR + "Type", CustomerType);
                    CustomerInfo.putExtra(PUT_STR + "Sex", CustomerSex);
                    CustomerInfo.putExtra(PUT_STR + "CustomerId", CustomerId);

                    CustomerInfo.putExtra("info", 4444);

//                        startActivity(intent);
                    startActivityForResult(CustomerInfo, 4444);//使用时需定义变量requestCode

                }else{
                    //会员信息
                    Intent CustomerInfo = new Intent(context, MembersInfoActivity.class);
                    CustomerInfo.putExtra(PUT_STR + "Id", memberId);
                    CustomerInfo.putExtra(PUT_STR + "Name", CustomerName);
                    CustomerInfo.putExtra(PUT_STR + "Type", CustomerType);
                    CustomerInfo.putExtra(PUT_STR + "Sex", CustomerSex);
                    startActivity(CustomerInfo);

                }

//                startActivity(CustomerInfo);
                break;
            case R.id.fab:

                AddFollpwAndAppointmentPopup(view, 0);

                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        this.view_result.setText(data.getStringExtra("NewStringInIntent"));
        super.onActivityResult(requestCode, resultCode, data);

//        String mId = "";
        String mName = "";
        String mSex = "";


        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }

            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {

//                mId = bundle.getString(RESULT_ID);

                mName = bundle.getString(RESULT_STRING);

                mSex = bundle.getString(RESULT_SEX);


            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == 4444) {
            textCustomerName.setText(mName);
            if (mSex.equals("男")) {
                textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_men);
            } else {
                textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_women);
            }
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
                });
                btnAppointmentAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //预约
                        popupWindow.dismiss();
                        Intent intent = new Intent(context, AddAppointmentActivity.class);

                        intent.putExtra(PUT_STR + "Id", CustomerId);
                        intent.putExtra(PUT_STR + "Name", CustomerName);
                        intent.putExtra(PUT_STR + "Type", CustomerType);
                        intent.putExtra(PUT_STR + "Sex", CustomerSex);
//                        AppointmentId
                        intent.putExtra(PUT_STR + "AppointmentId", "0");

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


    }
}
