package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise.AppraiseActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;
/**
 * Created by Administrator on 2017/8/4.
 * 教练信息
 */

public class CoachInfoActivity extends BaseActivity<CoachInfoActivityPresenter> implements CoachInfoActivityContract.View {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_av_btn)
    RelativeLayout userAvBtn;
    @BindView(R.id.user_height_text)
    TextView userHeightText;
    @BindView(R.id.user_height_btn)
    RelativeLayout userHeightBtn;
    @BindView(R.id.user_weight_text)
    TextView userWeightText;
    @BindView(R.id.user_weight_btn)
    RelativeLayout userWeightBtn;
    @BindView(R.id.user_level_text)
    TextView userLevelText;
    @BindView(R.id.user_level_btn)
    RelativeLayout userLevelBtn;
    @BindView(R.id.user_age_text)
    TextView userAgeText;
    @BindView(R.id.user_age_btn)
    RelativeLayout userAgeBtn;
    @BindView(R.id.user_certificate_btn)
    RelativeLayout userCertificateBtn;
    @BindView(R.id.good_btn)
    RelativeLayout goodBtn;
    @BindView(R.id.class_time_text)
    TextView classTimeText;
    @BindView(R.id.class_time_btn)
    RelativeLayout classTimeBtn;
    @BindView(R.id.class_stu_num_text)
    TextView classStuNumText;
    @BindView(R.id.class_stu_num_btn)
    RelativeLayout classStuNumBtn;
    @BindView(R.id.class_total_weight_text)
    TextView classTotalWeightText;
    @BindView(R.id.class_total_weight_btn)
    RelativeLayout classTotalWeightBtn;
    @BindView(R.id.user_introduce_btn)
    RelativeLayout userIntroduceBtn;
    @BindView(R.id.user_evaluation_text)
    TextView userEvaluationText;
    @BindView(R.id.user_evaluation_btn)
    RelativeLayout userEvaluationBtn;
    @BindView(R.id.user_class_btn)
    RelativeLayout userClassBtn;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;

    TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.user_av_img)
    ImageView userAvImg;
    @BindView(R.id.user_height_img)
    ImageView userHeightImg;
    @BindView(R.id.user_weight_img)
    ImageView userWeightImg;
    @BindView(R.id.user_certificate_img)
    ImageView userCertificateImg;
    @BindView(R.id.good_img)
    ImageView goodImg;
    @BindView(R.id.user_introduce_img)
    ImageView userIntroduceImg;
    @BindView(R.id.user_evaluation_img)
    ImageView userEvaluationImg;
    @BindView(R.id.user_class_img)
    ImageView userClassImg;


    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_coach_info;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");

        tvTitle.setText("教练详情");

        btnComplete.setText("编辑");

    }

    @Override
    protected void initData() {

        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        mPresenter.getTeacherInfo(userid, token);


    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void succeed(TeacherInfoBean teacherInfoBean) {

        this.teacherInfoBean = teacherInfoBean;
        userHeightText.setText(String.valueOf(teacherInfoBean.getResult().getHeight()));
        userWeightText.setText(String.valueOf(teacherInfoBean.getResult().getWeight())+"kg'");
        userLevelText.setText(String.valueOf(teacherInfoBean.getResult().getLevel()));
        userAgeText.setText(String.valueOf(teacherInfoBean.getResult().getWorkAge()));
        classTimeText.setText(String.valueOf(teacherInfoBean.getResult().getLessonCount()));
        classStuNumText.setText(String.valueOf(teacherInfoBean.getResult().getStudentCount()));
        classTotalWeightText.setText(String.valueOf(teacherInfoBean.getResult().getHelpCount()));
        userEvaluationText.setText(String.valueOf(teacherInfoBean.getResult().getStarCount() + "人评价"));


    }

    @Override
    public void succeedUpdata(CodeBean codeBean) {

        s(this, "修改信息成功!");
    }

    @Override
    public void outLogin() {

        s(this, "您的帐号在其他设备登录");

        Intent intent = new Intent(context, LoginActivity.class);
        remove();
        startActivity(intent);
        finish();


    }

    @OnClick({R.id.btn_complete, R.id.user_av_btn, R.id.user_height_btn, R.id.user_weight_btn, R.id.user_level_btn, R.id.user_age_btn, R.id.user_certificate_btn, R.id.good_btn, R.id.class_time_btn, R.id.class_stu_num_btn, R.id.class_total_weight_btn, R.id.user_introduce_btn, R.id.user_evaluation_btn, R.id.user_class_btn})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.user_av_btn:
                intent = new Intent(CoachInfoActivity.this, ImgVideoListActivity.class);
                startActivity(intent);
                break;
            case R.id.user_height_btn:
                break;
            case R.id.user_weight_btn:
                break;
            case R.id.user_level_btn:
                break;
            case R.id.user_age_btn:
                break;
            case R.id.user_certificate_btn:
                Certificate(view, 0);
                break;
            case R.id.good_btn:
                Popview(view,teacherInfoBean.getResult().getSpeciality().toString() ,"擅长项目");

                break;
            case R.id.class_time_btn:
                break;
            case R.id.class_stu_num_btn:
                break;
            case R.id.class_total_weight_btn:
                break;
            case R.id.user_introduce_btn:

                Popview(view,teacherInfoBean.getResult().getIntroduce().toString() ,"简介");
                break;
            case R.id.user_evaluation_btn:
                intent = new Intent(CoachInfoActivity.this, AppraiseActivity.class);
                startActivity(intent);
                break;
            case R.id.user_class_btn:

                Popview(view,teacherInfoBean.getResult().getLessonName().toString() ,"课程");
                break;

            case R.id.btn_complete:

                if (btnComplete.getText().toString().equals("完成")) {
                    // 修改提交
                    String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

                    int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                    int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

                    userHeightText.setEnabled(false);
                    userWeightText.setEnabled(false);
//                    sex = userSexText.getText().toString().equals("男")?"1":"0";
//                    UserName=userNameText.getText().toString();
//                    age = userAgeText.getText().toString();
//                    tel = userTelText.getText().toString();
//                    mail = userMailText.getText().toString();
//                    idCard = userIdText.getText().toString();
                    btnComplete.setText("编辑");

                    mPresenter.updateTeacherInfo(UserId,
                            token,
                            ClubId,
                            UserName,
                            userHeightText.getText().toString(),
                            userWeightText.getText().toString());
                } else {


                    btnComplete.setText("完成");

                    userHeightText.setEnabled(true);
                    userWeightText.setEnabled(true);

                }
                break;
        }
    }


    public void Certificate(View v, final int tag) {

        final View contentView = LayoutInflater.from(this).inflate(R.layout.view_certificate, null);

        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 600, true);

//        popupWindow.setAnimationStyle(R.style.PopupWindowStyle);//设置动画

        popupWindow.update();

        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        final TextView textContent = (TextView) contentView.findViewById(R.id.text_content);

        textContent.setText(teacherInfoBean.getResult().getCertificate().toString());


        backgroundAlpha(0.5f);
//        mShowMorePopupWindowWidth = content.getMeasuredWidth();

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {


//
//                final EditText pswNew = (EditText) contentView.findViewById(R.id.password_new);
//
//                final EditText pswConfirm = (EditText) contentView.findViewById(R.id.password_confirm);


                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.nulcolor));


        // 设置好参数之后再show
        //获取点击View的坐标
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


    }
    public void Popview(View v, final String s,final  String title) {

        final View contentView = LayoutInflater.from(this).inflate(R.layout.view_certificate, null);

        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 600, true);

//        popupWindow.setAnimationStyle(R.style.PopupWindowStyle);//设置动画

        popupWindow.update();

        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        final TextView textContent = (TextView) contentView.findViewById(R.id.text_content);
        final TextView textTitle = (TextView) contentView.findViewById(R.id.textTitle);

        textContent.setText(s);
        textTitle.setText(title);


        backgroundAlpha(0.5f);
//        mShowMorePopupWindowWidth = content.getMeasuredWidth();

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {


//
//                final EditText pswNew = (EditText) contentView.findViewById(R.id.password_new);
//
//                final EditText pswConfirm = (EditText) contentView.findViewById(R.id.password_confirm);


                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.nulcolor));


        // 设置好参数之后再show
        //获取点击View的坐标
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


    }


}
