package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.util.MyImageView.ImageViewPlus;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.LinearLayout.VERTICAL;
import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.APPOINTMENTRESULTID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERAPPOINTMENTTYPEID;
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
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.TimeUtil.string2Milliseconds;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/*
*
* 会员,客户,非会员等列表
*
*
*
*
* */
public class ReservationRecordActivity extends BaseActivity<ReservationRecordActivityPresenter> implements ReservationRecordActivityContract.View {

    @BindView(R.id.main_title)
    TextView tvTitle;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.btn_add_reservation)
    Button btnAddReservation;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.text_user_name)
    TextView textUserName;
    @BindView(R.id.appointment_type_text)
    TextView appointmentTypeText;
    @BindView(R.id.text_appointment_time_begin)
    TextView textAppointmentTimeBegin;
    @BindView(R.id.text_appointment_time_end)
    TextView textAppointmentTimeEnd;
    @BindView(R.id.user_results_text)
    TextView userResultsText;
    @BindView(R.id.text_results)
    TextView textResults;
    @BindView(R.id.btn_remind_time)
    RelativeLayout btnRemindTime;
    @BindView(R.id.text_remind_time)
    TextView textRemindTime;

    @BindView(R.id.text_remind_interval_time)
    TextView textRemindIntervalTime;
    //    @BindView(R.id.details_note_text)
//    TextView detailsNoteText;

    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.img_appointment)
    ImageView imgAppointment;
    @BindView(R.id.btn_appointment)
    RelativeLayout btnAppointment;
    @BindView(R.id.layout_time)
    RelativeLayout layoutTime;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.id_layout_time)
    LinearLayout idLayoutTime;
    @BindView(R.id.btn_appointment_type)
    RelativeLayout btnAppointmentType;
    @BindView(R.id.btn_appointment_time_begin)
    RelativeLayout btnAppointmentTimeBegin;
    @BindView(R.id.btn_appointment_time_end)
    RelativeLayout btnAppointmentTimeEnd;
    @BindView(R.id.layout_main)
    RelativeLayout layoutMain;
    @BindView(R.id.img_appointment_type)
    ImageView imgAppointmentType;
    @BindView(R.id.img_appointment_time_begin)
    ImageView imgAppointmentTimeBegin;
    @BindView(R.id.img_appointment_time_end)
    ImageView imgAppointmentTimeEnd;
    @BindView(R.id.img_remind_time)
    ImageView imgRemindTime;
    @BindView(R.id.text_details_note)
    EditText textDetailsNote;


    private TimePickerView pvCustomTime;


    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerSex = "";
    private String CustomerId = "";
    private String AppointmentId = "";
    private String AppointmentTypeId = "";
    private String resultsId = "";
    private String resultsName = "";
    private int EditType;
    private boolean EditF = false;

    private CommonAdapter<AppointmentByIdBean.ResultBean.ContactListBean> commonAdapter;

    private List<AppointmentByIdBean.ResultBean.ContactListBean> datas = new ArrayList<AppointmentByIdBean.ResultBean.ContactListBean>();


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_booking_details;
    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//        setToolBar(toolbar, "");
        layoutMain.setVisibility(View.INVISIBLE);
        tvTitle.setText("预约详情");
        Intent intent = getIntent();
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");
        layoutTime.setVisibility(View.GONE);

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<AppointmentByIdBean.ResultBean.ContactListBean>(R.layout.cardview_booking_details, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final AppointmentByIdBean.ResultBean.ContactListBean listBean, int i) {

                holder.setText(R.id.text_user_name, listBean.getAppointUserName());//名称

//                holder.setText(R.id.text_content, "内容：" + listBean.getContent());//内容
                holder.setText(R.id.text_content, "内容：" + listBean.getContactContent());//内容

                holder.setText(R.id.text_time, listBean.getCreateTime());//时间

                ImageViewPlus imageView = (ImageViewPlus) holder.setImage(R.id.head_img);

//                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.head_img, imageView);
//                imageView.invalidate();
                displayCircleImage(context, listBean.getHeaderURL(), imageView, R.mipmap.head_img);
                imageView.invalidate();

//                loadIntoUseFitWidth(context, listBean.getHeardimg(), R.mipmap.head_img, holder.setImage(R.id.head_img_iv));//头像
//
                if (listBean.getImageList().size() > 0) {


                    for (int j = 0; j < (listBean.getImageList().size() > 5 ? 5 : listBean.getImageList().size()); j++) {

                        try {

                            ImageView iv = holder.setImage(R.id.class.getDeclaredField("img" + String.valueOf(j + 1)).getInt(null));
                            loadIntoUseFitWidth(context, listBean.getImageList().get(j).getImageurl(), R.mipmap.null_img, iv);
//                            displayCircleImage(context, listBean.getImageList().get(j).getImageurl(), iv, R.mipmap.null_img);
                            iv.setVisibility(View.VISIBLE);
                            final Intent intent = new Intent(ReservationRecordActivity.this, ImageActivity.class);
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


                } else {

//                        holder.getView(R.id.img_layout).setVisibility(View.GONE);

                }

            }
        };

        recyclerView.setAdapter(commonAdapter);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
//
//        //设置进度条的颜色
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
//
//
//        //设置进度条的大小样式
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
//
//
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//
//            @Override
//            public void onRefresh() {
//
//                refresh();
//
//            }
//
//
//        });
//
//        swipeRefreshLayout.post(new Runnable() {
//
//            @Override
//            public void run() {
//
//                swipeRefreshLayout.setRefreshing(true);
//                commonAdapter.setShowFooter(false);
//            }
//        })
        commonAdapter.setShowFooter(false);
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
    public void succeed(final AppointmentByIdBean appointmentByIdBean) {


        try {

            textUserName.setText(appointmentByIdBean.getResult().getAppointInfo().getCustomerName());
            appointmentTypeText.setText(appointmentByIdBean.getResult().getAppointInfo().getAppointmentTypeName());
            textAppointmentTimeBegin.setText(appointmentByIdBean.getResult().getAppointInfo().getBgTime() + " " + appointmentByIdBean.getResult().getAppointInfo().getSTime());
            textAppointmentTimeEnd.setText(appointmentByIdBean.getResult().getAppointInfo().getBgTime() + " " + appointmentByIdBean.getResult().getAppointInfo().getETime());
            textResults.setText(appointmentByIdBean.getResult().getAppointInfo().getAppointmentResultName());
            textRemindTime.setText(appointmentByIdBean.getResult().getAppointInfo().getTipStartTime() + " " + appointmentByIdBean.getResult().getAppointInfo().getTtime());
            textRemindIntervalTime.setText(appointmentByIdBean.getResult().getAppointInfo().getTipInterval());
            textResults.setText(appointmentByIdBean.getResult().getAppointInfo().getAppointmentResultName());
            textDetailsNote.setText(appointmentByIdBean.getResult().getAppointInfo().getContent());
            AppointmentTypeId = String.valueOf(appointmentByIdBean.getResult().getAppointInfo().getAppointmentTypeId());
            EditType = appointmentByIdBean.getResult().getAppointInfo().getEditType();
            CustomerName=appointmentByIdBean.getResult().getAppointInfo().getCustomerName();
            CustomerSex=appointmentByIdBean.getResult().getAppointInfo().getSex();

            if (EditType == 0) {
                btnRemindTime.setVisibility(View.VISIBLE);
                idLayoutTime.setVisibility(View.VISIBLE);
                btnEdit.setText("编辑");
                btnEdit.setVisibility(View.VISIBLE);
                imgRemindTime.setVisibility(View.INVISIBLE);
                btnAppointment.setVisibility(View.GONE);
            } else {
                btnEdit.setVisibility(View.GONE);
                btnAppointment.setVisibility(View.VISIBLE);
                btnRemindTime.setVisibility(View.INVISIBLE);
                idLayoutTime.setVisibility(View.GONE);
                imgRemindTime.setVisibility(View.INVISIBLE);
                layoutTime.setEnabled(false);
                if (!appointmentByIdBean.getResult().getAppointInfo().getAppointmentResultName().equals("")){
                    imgAppointment.setVisibility(View.INVISIBLE);
                }else{
                    imgAppointment.setVisibility(View.VISIBLE);
                }

            }


            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                    int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                    int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

                    if (EditType == 0) {
                        if (btnEdit.getText().equals("完成")) {

                            if (string2Milliseconds(textAppointmentTimeEnd.getText().toString()) < string2Milliseconds(textAppointmentTimeBegin.getText().toString())) {
                                s(mContext, "预约结束时间小于开始时间!请重新填写");
                            } else if (string2Milliseconds(textRemindTime.getText().toString()) > string2Milliseconds(textAppointmentTimeBegin.getText().toString())) {
                                s(mContext, "提醒时间大于预约开始时间");
                            } else {
                                btnEdit.setEnabled(false);
                                mPresenter.appAddCustomerAppoint(UserName,
                                        UserId,
                                        token,
                                        ClubId,
                                        String.valueOf(appointmentByIdBean.getResult().getAppointInfo().getAppointmentTypeId()),
                                        textDetailsNote.getText().toString(),
                                        CustomerId,
                                        textAppointmentTimeEnd.getText().toString(),
                                        textAppointmentTimeBegin.getText().toString(),
                                        textRemindIntervalTime.getText().toString(),
                                        textRemindTime.getText().toString(),
                                        String.valueOf(appointmentByIdBean.getResult().getAppointInfo().getAppointmentId()));
                                btnEdit.setText("编辑");
                                EditF = false;
                                imgAppointmentTimeEnd.setVisibility(View.INVISIBLE);
                                imgAppointmentTimeBegin.setVisibility(View.INVISIBLE);
                                imgRemindTime.setVisibility(View.INVISIBLE);

//                                imgRemindTime.setVisibility(View.INVISIBLE);
//                                  textRemindTime.setEnabled(false);
//                                textAppointmentTimeBegin.setEnabled(false);
//                                textAppointmentTimeEnd.setEnabled(false);
                                textDetailsNote.setEnabled(false);
                                layoutTime.setEnabled(false);
                            }


                        } else {
                            btnEdit.setText("完成");

                            EditF = true;
                            textDetailsNote.setEnabled(true);
                            layoutTime.setEnabled(true);
//                            textRemindTime.setEnabled(true);
                            imgAppointmentTimeEnd.setVisibility(View.VISIBLE);
                            imgAppointmentTimeBegin.setVisibility(View.VISIBLE);
                            imgRemindTime.setVisibility(View.VISIBLE);
//                            imgRemindTime.setVisibility(View.VISIBLE);

                        }


                    } else {

                        if (btnEdit.getText().equals("完成")) {
                            btnEdit.setText("编辑");

                        } else {
                            btnEdit.setText("完成");


                        }


                    }
                }
            });


            datas = appointmentByIdBean.getResult().getContactList();
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
            commonAdapter.replaceData(datas);
            layoutMain.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void savesucceed(CodeBean codeBean) {
        if (codeBean.getCode() == 0) {
            btnEdit.setEnabled(true);
            s(this, "修改成功");
        }
    }


    public void refresh() {
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        mPresenter.getAppointmentById(UserName, UserId, token, ClubId, AppointmentId, CustomerId);


    }

    @OnClick({R.id.btn_add_reservation, R.id.btn_back, R.id.btn_remind_time, R.id.btn_edit, R.id.btn_appointment, R.id.btn_appointment_type, R.id.btn_appointment_time_begin, R.id.btn_appointment_time_end})
    public void onViewClicked(View view) {

        final Intent intent = new Intent(ReservationRecordActivity.this, FilterListActivity.class);


        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";

        switch (view.getId()) {
            case R.id.btn_add_reservation:
                Intent AddFollow = new Intent(context, AddFollowActivity.class);
                AddFollow.putExtra(PUT_STR + "Id", CustomerId);
                AddFollow.putExtra(PUT_STR + "Name", CustomerName);
                AddFollow.putExtra(PUT_STR + "Type", CustomerType);
                AddFollow.putExtra(PUT_STR + "Sex", CustomerSex);
                AddFollow.putExtra(PUT_STR + "AppointmentId", AppointmentId);
                AddFollow.putExtra(mStrType, REFRESHID);
                startActivityForResult(AddFollow, REFRESHID);//使用时需定义变量requestCode

                break;
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn_remind_time:
                if (EditF) {
                    initCustomTimePicker((TextView) findViewById(R.id.text_remind_time), "");
                    pvCustomTime.show();
                }

                break;
            case R.id.btn_edit:

//                AddFollowActivity
                break;
            case R.id.btn_appointment:

                if (EditType == 1 && imgAppointment.getVisibility()==View.VISIBLE) {
                    intent.putExtra(mStrType, APPOINTMENTRESULTID);
                    intent.putExtra(PUT_STR + "id", AppointmentTypeId);
                    startActivityForResult(intent, APPOINTMENTRESULTID);//使用时需定义变量requestCode
                }
                break;
            case R.id.btn_appointment_type:
//                if (EditF) {
//                    intent.putExtra(mStrType, CUSTOMERAPPOINTMENTTYPEID);
//
//                    intent.putExtra(PUT_STR + "id", CustomerId);
//
////                        startActivity(intent);
//                    startActivityForResult(intent, CUSTOMERAPPOINTMENTTYPEID);//使用时需定义变量requestCode
//                }

                break;
            case R.id.btn_appointment_time_begin:
                if (EditF) {
                    initCustomTimePicker((TextView) findViewById(R.id.text_appointment_time_begin), "");
                    pvCustomTime.show();
                }
                break;
            case R.id.btn_appointment_time_end:
                if (EditF) {
                    initCustomTimePicker((TextView) findViewById(R.id.text_appointment_time_end), "");
                    pvCustomTime.show();
                }
                break;

        }
    }

    private void initCustomTimePicker(final TextView view, String title) {

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

                view.setText(getDataTime(date));

//                switch (view.getId()){
//
//
//
//                }
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
                                view.setText("-");
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
                .setType(TimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.nullcoloer)
                .build();

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
//            }
        }

        if (requestCode == APPOINTMENTRESULTID) {

            resultsId = mId;
            textResults.setText(mName);
            resultsName = mName;
            String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

            int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

            String token = (String) SpUtil.get(mContext, TOKENKEY, "");

            int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
            if (!mId.equals("")){
            mPresenter.saveAppointmentResultForCustomer(UserId, token, ClubId, UserName, AppointmentId, resultsId, "");}
//            if (mId.equals("")){
//                s(this,"")
//                finish();
//            }

        }
        if (requestCode == REFRESHID) {
            refresh();
        }

    }

    @Override
    protected void onDestroy() {
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);
        super.onDestroy();
    }


}
