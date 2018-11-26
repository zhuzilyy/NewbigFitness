package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.gufei.bigfitness.Constants;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd.CourseAppointmentAddActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;
import com.yanzhenjie.album.Album;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_REQUEST_SELECT_PHOTO;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TIME_BEGIN_ID;
import static com.example.gufei.bigfitness.Constants.TIME_END_ID;
import static com.example.gufei.bigfitness.Constants.TIME_INTERVAL_ID;
import static com.example.gufei.bigfitness.Constants.TIME_REMIND_ID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.BitmapUtil.Bitmap2StrByBase64;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.TimeUtil.getCurTimeString;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class AddReportActivity extends BaseActivity<AddReportActivityPresenter> implements AddReportActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btn_complete)
    Button btnRelease;

    @BindView(R.id.text_customer_type)
    TextView textCustomerType;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.text_customer_img)
    ImageView textCustomerImg;
    //    @BindView(R.id.text_content)
//    EditText textContext;
    @BindView(R.id.btn_select_img)
    ImageView btnSelectImg;
    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerId = "";
    private String CustomerSex = "";
    private String AppointmentId = "";
    private String imgsrc = "";

    boolean f = true;

    private TimePickerView pvCustomTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_report_add;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");

        tvTitle.setText("上传体测报告");

        btnRelease.setText("上传");

        Intent intent = getIntent();

        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");

        textTime.setText(getCurTimeString());
//        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");

//        textCustomerType.setText(CustomerType);

//        textCustomerName.setText(CustomerName);


//        if (CustomerSex.equals("男")) {
//
//            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_men);
//
//        } else {
//
//            textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_women);
//
//        }


    }


    @Override
    protected void initData() {
    }


    @Override
    public void showError(String msg) {

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
    public void succeed(CodeBean codeBean) {
        s(this, "添加成功");
        this.finish();
    }

    @OnClick({R.id.btn_complete, R.id.btn_select_img, R.id.text_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:
                if (f) {
                    f = false;
                    String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                    int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                    int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                    mPresenter.saveMemberBodyReport(UserId, token, ClubId, UserName, CustomerId, imgsrc, textTime.getText().toString());

//                mPresenter.saveMemberBodyReport(UserName,
//                        UserId,
//                        token,
//                        ClubId,
//                        AppointmentId,textContext.getText().toString(),CustomerId,imgsrc);
                }
                break;
            case R.id.btn_select_img:

                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 1                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。

                break;
            case R.id.text_time:
                initCustomTimePicker();
                pvCustomTime.show();

                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) { // 判断是否成功。
                // 拿到用户选择的图片路径List：
                List<String> pathList = Album.parseResult(data);
                imgsrc = "";
                for (int i = 0; i < pathList.size(); i++) {
                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                    try {

                        ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));

                        imageView.setVisibility(View.VISIBLE);

//                        loadIntoUseFitWidth(context, pathList.get(i), R.mipmap.null_img,imageView);

                        Glide.with(context)
                                .load(pathList.get(i))// 加载图片
                                .crossFade()// 淡出效果
                                .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存
                                .into(imageView);


                    } catch (IllegalAccessException e) {

                        e.printStackTrace();

                    } catch (NoSuchFieldException e) {

                        e.printStackTrace();

                    }

                }


            } else if (resultCode == RESULT_CANCELED) { // 用户取消选择。
                // 根据需要提示用户取消了选择。
            }
        }
    }

    private void initCustomTimePicker() {

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

                textTime.setText(getTimes(date));

//                switch (mTimePv_Id) {
//
//                    case TIME_BEGIN_ID:
//                        beginTimeText.setText(getTime(date));
//                        Toast.makeText(CourseAppointmentAddActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
//                        break;
//                    case TIME_END_ID:
//                        endTimeText.setText(getTime(date));
//                        Toast.makeText(CourseAppointmentAddActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
//                        break;
//                    case TIME_REMIND_ID:
//                        remindTimeText.setText(getTime(date));
//                        Toast.makeText(CourseAppointmentAddActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
//                        break;
//                    case TIME_INTERVAL_ID:
//
////                        Toast.makeText(AddAppointmentActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
//                        break;


//                }


            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
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
                                textTime.setText(getTime(new java.util.Date()));
                                pvCustomTime.dismiss();
                            }
                        });

                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
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
                .setDividerColor(Color.WHITE)
                .build();

    }
}

