package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.Main2Activity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Main.CustomerMainActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Main.MembersMainActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List.PublicSeaListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages.MessagesListActivity;
import com.example.gufei.bigfitness.component.GlideCircleTransform;
import com.example.gufei.bigfitness.util.SpUtil;
import com.journeyapps.barcodescanner.CaptureActivity;
//import com.uuzuche.lib_zxing.activity.CaptureActivity;
//import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static android.widget.LinearLayout.VERTICAL;
import static com.example.gufei.bigfitness.Constants.APPOINTMENTRESULTID;
import static com.example.gufei.bigfitness.Constants.BASEURL;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.TimeUtil.getMyDateKillSeconds;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 *
 * 实际业务人员主页
 */

@RuntimePermissions
public class IndexFragMent extends BaseFragment<IndexFragMentPresenter> implements IndexFragMentContract.View {


    @BindView(R.id.ScanImg)
    ImageView ScanBtn;



    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    //    @BindView(R.id.address_btn)
//    LinearLayout addressBtn;
//    @BindView(R.id.main_btn)
//    LinearLayout mainBtn;
//    @BindView(R.id.my_btn)
//    LinearLayout myBtn;
    @BindView(R.id.customer_management_btn)
    LinearLayout customerManagementBtn;
    @BindView(R.id.member_management_btn)
    LinearLayout memberManagementBtn;
    @BindView(R.id.highseas_management_btn)
    LinearLayout highseasManagementBtn;
    @BindView(R.id.programme_btn)
    LinearLayout programmeBtn;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.notice_system_btn)
    LinearLayout noticeSystemBtn;
    @BindView(R.id.notice_Due_btn)
    LinearLayout noticeDueBtn;
    @BindView(R.id.notice_Sign_btn)
    LinearLayout noticeSignBtn;
    @BindView(R.id.notice_appointment_btn)
    LinearLayout noticeAppointmentBtn;
    @BindView(R.id.notice_change_btn)
    LinearLayout noticeChangeBtn;
    @BindView(R.id.notice_birthday_btn)
    LinearLayout noticeBirthdayBtn;
    @BindView(R.id.text_title_system)
    TextView textTitleSystem;
    @BindView(R.id.text_time_system)
    TextView textTimeSystem;

    @BindView(R.id.msg_layout)
    LinearLayout msgLayout;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.btn_hide_list)
    ImageView btnHideList;
    @BindView(R.id.btn_list_head)
    RelativeLayout btnListHead;
    Unbinder unbinder;
    @BindView(R.id.num_result)
    TextView numResult;
    @BindView(R.id.layout_bottom_result)
    LinearLayout layoutBottomResult;
    @BindView(R.id.num_expireresult)
    TextView numExpireresult;
    @BindView(R.id.title_expireresult)
    TextView titleExpireresult;
    @BindView(R.id.time_expireresult)
    TextView timeExpireresult;
    @BindView(R.id.layout_bottom_expireresult)
    LinearLayout layoutBottomExpireresult;
    @BindView(R.id.num_signresult)
    TextView numSignresult;
    @BindView(R.id.title_signresult)
    TextView titleSignresult;
    @BindView(R.id.time_signresult)
    TextView timeSignresult;
    @BindView(R.id.layout_bottom_signresult)
    LinearLayout layoutBottomSignresult;
    @BindView(R.id.num_appointmentresult)
    TextView numAppointmentresult;
    @BindView(R.id.title_appointmentresult)
    TextView titleAppointmentresult;
    @BindView(R.id.time_appointmentresult)
    TextView timeAppointmentresult;
    @BindView(R.id.layout_bottom_appointmentresult)
    LinearLayout layoutBottomAppointmentresult;
    @BindView(R.id.num_changeresult)
    TextView numChangeresult;
    @BindView(R.id.title_changeresult)
    TextView titleChangeresult;
    @BindView(R.id.time_changeresult)
    TextView timeChangeresult;
    @BindView(R.id.layout_bottom_changeresult)
    LinearLayout layoutBottomChangeresult;
    @BindView(R.id.num_birthdayresult)
    TextView numBirthdayresult;
    @BindView(R.id.title_birthdayresult)
    TextView titleBirthdayresult;
    @BindView(R.id.time_birthdayresult)
    TextView timeBirthdayresult;
    @BindView(R.id.layout_bottom_birthdayresult)
    LinearLayout layoutBottomBirthdayresult;
    @BindView(R.id.charts_btn)
    LinearLayout chartsBtn;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private Context context;
    private FragMentListening fragMentListening;
    private CommonAdapter<MainMsgBean.ResultBean> commonAdapter;
    private CommonAdapter.MultiItemTypeSupport<MainMsgBean.ResultBean> mulitItem; // 多类型布局
    private boolean isLoadingMore = true;//加载标志位
    private int userid;
    private String token;
    private int clubid;
    private List<MainMsgBean.ResultBean> datas = new ArrayList<MainMsgBean.ResultBean>();
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
        refresh();
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }
    private void refresh() {
        mPresenter.updata(userid, token, clubid);
        mPresenter.getSineForMainPage(userid, token, clubid);
    }


    @Override
    protected void initData() {

        recyclerView.setVisibility(View.GONE);
        btnHideList.setImageResource(R.mipmap.screening_down);
        context = this.getActivity();
        userid = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        refresh();
        commonAdapter = new CommonAdapter<MainMsgBean.ResultBean>(R.layout.card_appointment_main, context, datas) {
            @Override
            protected void convert(ViewHolder holder, final MainMsgBean.ResultBean msgBean, int position) {
                holder.setText(R.id.text_name, msgBean.getAppointUserName());
                holder.setText(R.id.text_content, msgBean.getContent());
                holder.setText(R.id.text_class, msgBean.getAppointmentTypeName());
//                if (!msgBean.getCreateTime().toString().equals("null")){
//                if (!msgBean.getCreateTime().equals(""))
//                    holder.setText(R.id.id_time, getMyDateKillSeconds(msgBean.getCreateTime()));}
                holder.setText(R.id.text_time, msgBean.getCreateTime());
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
//                loadIntoUseFitWidth(context, msgBean.getHeaderURL(), R.mipmap.head_img, (ImageView) holder.getView(R.id.img_head));
                if (msgBean.getAppType().equals("3")) {
                    holder.getView(R.id.img_head).setVisibility(View.GONE);
                } else {
                    holder.getView(R.id.img_head).setVisibility(View.VISIBLE);
                    displayCircleImage(context,msgBean.getHeaderURL(),(ImageView) holder.getView(R.id.img_head),R.mipmap.privatememberinfor_03);

                }

//
//                AppType	1 会员预约 2会员私教课预约 3客户预约
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (msgBean.getAppType().equals("3")) {
                            Intent intent = new Intent(context, ReservationRecordActivity.class);
                            intent.putExtra(PUT_STR + "Id", String.valueOf(msgBean.getUID()));
                            intent.putExtra(PUT_STR + "Name", msgBean.getAppointUserName());
                        /*    intent.putExtra(PUT_STR + "Sex",msgBean.get );*/
                            intent.putExtra(PUT_STR + "Type", msgBean.getAppointmentTypeName());
                            intent.putExtra(PUT_STR + "Sex", "女");
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(msgBean.getAppointmentId()));
                            intent.putExtra(mStrType, REFRESHID);
                            startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                        } else if (msgBean.getAppType().equals("1")) {

                            Intent intent = new Intent(context, ReservationRecordMembersActivity.class);
                            intent.putExtra(PUT_STR + "Id", String.valueOf(msgBean.getUID()));
                            intent.putExtra(PUT_STR + "Name", msgBean.getAppointUserName());
                            intent.putExtra(PUT_STR + "Type", msgBean.getAppointmentTypeName());
//                            intent.putExtra(PUT_STR + "Sex", CustomerSex);
                            intent.putExtra(PUT_STR + "Sex", "女");
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(msgBean.getAppointmentId()));
                            if (msgBean.getAppointmentTypeName().equals("上课预约")) {
                                intent.putExtra(PUT_STR + "AppointmentType", "2");
                            } else {
                                intent.putExtra(PUT_STR + "AppointmentType", "1");
                            }
                            intent.putExtra(mStrType, REFRESHID);
                            startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                        } else {
                            Intent intent = new Intent(context, ReservationRecordMembersActivity.class);
                            intent.putExtra(PUT_STR + "Id", String.valueOf(msgBean.getUID()));
                            intent.putExtra(PUT_STR + "Name", msgBean.getAppointUserName());
                            intent.putExtra(PUT_STR + "Type", msgBean.getAppointmentTypeName());
//                            intent.putExtra(PUT_STR + "Sex", CustomerSex);
                            intent.putExtra(PUT_STR + "Sex", "女");
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(msgBean.getAppointmentId()));
                            if (msgBean.getAppointmentTypeName().equals("上课预约")) {
                                intent.putExtra(PUT_STR + "AppointmentType", "2");
                            } else {
                                intent.putExtra(PUT_STR + "AppointmentType", "1");
                            }
                            intent.putExtra(mStrType, REFRESHID);
                            startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                        }
                    }
                });


            }


        };


        recyclerView.setAdapter(commonAdapter);

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {


            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            //添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    super.onScrolled(recyclerView, dx, dy);

//                    //总记录条数
//                    //　int totalItemCount = linearLayoutManager.getItemCount();
//                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
//
//                    //最后条数的位置
//                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
//
//
//                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
//
//                        isLoadingMore = false;
//
////                        loading();
//
//                    }
                }
            });
        }
            //刷新时间
        initRefreshListener();

    }

    private void initRefreshListener() {

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);


        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh() {

                refresh();

            }


        });
    }


    @Override
    public void showError(String msg) {

//        noticeSystemBtn.setVisibility(View.GONE);
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


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }


    @OnClick({R.id.charts_btn,R.id.btn_list_head, R.id.notice_birthday_btn, R.id.notice_system_btn, R.id.notice_Due_btn, R.id.notice_Sign_btn, R.id.notice_appointment_btn, R.id.notice_change_btn, R.id.ScanImg,R.id.customer_management_btn, R.id.member_management_btn, R.id.highseas_management_btn, R.id.programme_btn})
    public void onClick(View view) {

        Intent intent;
        String UserType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        switch (view.getId()) {

            case R.id.notice_system_btn:
                intent = new Intent(getActivity(), MessagesListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "系统通知");
               getActivity().startActivity(intent);
                break;
            case R.id.notice_Due_btn:
                intent = new Intent(getActivity(), MessagesListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "到期通知");
               getActivity().startActivity(intent);
                break;
            case R.id.notice_Sign_btn:
                intent = new Intent(getActivity(), MessagesListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "签到通知");
               getActivity().startActivity(intent);

                break;
            case R.id.notice_appointment_btn:
                intent = new Intent(getActivity(), MessagesListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "预约通知");
               getActivity().startActivity(intent);
                break;
            case R.id.notice_change_btn:
                intent = new Intent(getActivity(), MessagesListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "变更通知");
               getActivity().startActivity(intent);
                break;

            case R.id.notice_birthday_btn:
                intent = new Intent(getActivity(), MessagesListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "会员生日通知");
               getActivity().startActivity(intent);
                break;
            case R.id.ScanImg:
                fragMentListening.BtnScan();
                break;
            case R.id.btn_list_head:

                if (recyclerView.getVisibility() == View.GONE) {
                    recyclerView.setVisibility(View.VISIBLE);
                    btnHideList.setImageResource(R.mipmap.screening_up);


                } else {
                    recyclerView.setVisibility(View.GONE);
                    btnHideList.setImageResource(R.mipmap.screening_down);
                }


                break;
//
//
//            case R.id.main_btn:
//                // TODO: 2017/4/17   这是测试用按钮
//                intent = new Intent(context, CustomerInfoCollectionActivity.class);
//
//                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "会员生日通知");
//
//               getActivity().startActivity(intent);
//                break;
//            case R.id.my_btn:
//
//                intent = new Intent(context, ImgVideoListActivity.class);
//
////                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "会员生日通知");
//
//               getActivity().startActivity(intent);
//                break;

            case R.id.customer_management_btn:


                if (UserType.equals("会籍")) {
                    intent = new Intent(getActivity(), CustomerMainActivity.class);

//                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "会员生日通知");

                   getActivity().startActivity(intent);
                } else {

                    s(mContext, "教练无权操作该功能!");
                }

                break;

            case R.id.member_management_btn:

                intent = new Intent(getActivity(), MembersMainActivity.class);

               getActivity().startActivity(intent);

                break;
            case R.id.highseas_management_btn:


                if (UserType.equals("会籍") || IsDepartManager == 1) {

                    intent = new Intent(getActivity(), PublicSeaListActivity.class);

//                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title", "会员生日通知");

                   getActivity().startActivity(intent);
                } else {

                    s(mContext, "教练无权操作该功能!");


                }

                break;

            case R.id.programme_btn:

                intent = new Intent(getActivity(), ScheduleActivity.class);

               getActivity().startActivity(intent);

                break;
            case R.id.charts_btn:

                intent = new Intent(getActivity(), Main2Activity.class);

                getActivity().startActivity(intent);

                break;


        }
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
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


        if (requestCode == REFRESHID) {
            refresh();
        }
    }


    @Override
    public void succeed(MainMsgBean mainMsgBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {

            List<MainMsgBean.ResultBean> list =new ArrayList<MainMsgBean.ResultBean>();
            for (int i=mainMsgBean.getResult().size();i>0;i--){
                   list.add( mainMsgBean.getResult().get(i-1));
            }
//            datas=mainMsgBean.getResult();
            datas=list;
            commonAdapter.replaceData(datas);
//
//            recyclerView.getLayoutManager(new  AddressListActivity(this));
            final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(context, VERTICAL, true, datas.size()) {
                @Override
                public boolean canScrollVertically() {
                    //{｝内部分可以开启滑动
                    return false;
                }
            };

            layoutManager.setAutoMeasureEnabled(false);

            recyclerView.setLayoutManager(layoutManager);

            commonAdapter.setShowFooter(false);


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void MainPagesucceed(SineForMainPageBean sineForMainPageBean) {
        //系统通知
        if (sineForMainPageBean.getResult().getResult().getCountNum() > 0) {
            textTitleSystem.setText(sineForMainPageBean.getResult().getResult().getTitle());
            textTimeSystem.setText(sineForMainPageBean.getResult().getResult().getCreateTime());
            numResult.setText(String.valueOf(sineForMainPageBean.getResult().getResult().getCountNum()));
            layoutBottomResult.setVisibility(View.VISIBLE);
            numResult.setVisibility(View.VISIBLE);
        } else {
            layoutBottomResult.setVisibility(View.GONE);
            numResult.setVisibility(View.GONE);
        }

        //预约通知
        if (sineForMainPageBean.getResult().getAppointmentResult().getCountNum() > 0) {
            titleAppointmentresult.setText(sineForMainPageBean.getResult().getAppointmentResult().getTitle());
            timeAppointmentresult.setText(sineForMainPageBean.getResult().getAppointmentResult().getCreateTime());
            numAppointmentresult.setText(String.valueOf(sineForMainPageBean.getResult().getAppointmentResult().getCountNum()));
            layoutBottomAppointmentresult.setVisibility(View.VISIBLE);
            numAppointmentresult.setVisibility(View.VISIBLE);
        } else {
            layoutBottomAppointmentresult.setVisibility(View.GONE);
            numAppointmentresult.setVisibility(View.GONE);
        }

        //生日通知
        if (sineForMainPageBean.getResult().getBirthdayResult().getCountNum() > 0) {
            titleBirthdayresult.setText(sineForMainPageBean.getResult().getBirthdayResult().getTitle());
            timeBirthdayresult.setText(sineForMainPageBean.getResult().getBirthdayResult().getCreateTime());
            numBirthdayresult.setText(String.valueOf(sineForMainPageBean.getResult().getBirthdayResult().getCountNum()));
            layoutBottomBirthdayresult.setVisibility(View.VISIBLE);
            numBirthdayresult.setVisibility(View.VISIBLE);
        } else {
            layoutBottomBirthdayresult.setVisibility(View.GONE);
            numBirthdayresult.setVisibility(View.GONE);
        }

        //变更通知
        if (sineForMainPageBean.getResult().getChangeResult().getCountNum() > 0) {
            titleChangeresult.setText(sineForMainPageBean.getResult().getChangeResult().getTitle());
            timeChangeresult.setText(sineForMainPageBean.getResult().getChangeResult().getCreateTime());
            numChangeresult.setText(String.valueOf(sineForMainPageBean.getResult().getChangeResult().getCountNum()));
            layoutBottomChangeresult.setVisibility(View.VISIBLE);
            numChangeresult.setVisibility(View.VISIBLE);
        } else {
            layoutBottomChangeresult.setVisibility(View.GONE);
            numChangeresult.setVisibility(View.GONE);
        }

        //签到通知
        if (sineForMainPageBean.getResult().getSignResult().getCountNum() > 0) {
            titleSignresult.setText(sineForMainPageBean.getResult().getSignResult().getTitle());
            timeSignresult.setText(sineForMainPageBean.getResult().getSignResult().getCreateTime());
            numSignresult.setText(String.valueOf(sineForMainPageBean.getResult().getSignResult().getCountNum()));

            layoutBottomSignresult.setVisibility(View.VISIBLE);
            numSignresult.setVisibility(View.VISIBLE);
        } else {
            layoutBottomSignresult.setVisibility(View.GONE);
            numSignresult.setVisibility(View.GONE);
        }
        //到期通知
        if (sineForMainPageBean.getResult().getExpireResult().getCountNum() > 0) {
            titleExpireresult.setText(sineForMainPageBean.getResult().getExpireResult().getTitle());
            timeExpireresult.setText(sineForMainPageBean.getResult().getExpireResult().getCreateTime());
            numExpireresult.setText(String.valueOf(sineForMainPageBean.getResult().getExpireResult().getCountNum()));
            layoutBottomExpireresult.setVisibility(View.VISIBLE);
            numExpireresult.setVisibility(View.VISIBLE);
        } else {
            layoutBottomExpireresult.setVisibility(View.GONE);
            numExpireresult.setVisibility(View.GONE);
        }
    }

}

