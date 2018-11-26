package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.PlanArrBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.PlanSettle.PlanSettle2Bean;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class LessonInfoActivity extends BaseActivity<LessonInfoActivityPresenter> implements LessonInfoActivityContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView title;
    @BindView(R.id.user_name_text)
    TextView userNameText;
    @BindView(R.id.text_type_lesson)
    TextView textTypeLesson;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.collection_user_tel_text)
    TextView collectionUserTelText;
    @BindView(R.id.text_coach_lesson)
    TextView textCoachLesson;
    @BindView(R.id.references_text)
    TextView referencesText;
    @BindView(R.id.text_time_lesson)
    TextView textTimeLesson;
    @BindView(R.id.customer_source_text)
    TextView customerSourceText;
    @BindView(R.id.customer_source)
    TextView customerSource;
    @BindView(R.id.note_text)
    TextView noteText;
    @BindView(R.id.note_content)
    TextView noteContent;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_lesson_details_documents_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");

        title.setText("上课详情");

    }


    @Override
    protected void initData() {
        refresh();
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
    public void succeed(LessonInfoBean lessonInfoBean) {

        customerSource.setText(lessonInfoBean.getResult().getRemainder());

        PlanArrBean planArrBean = PlanSettle2Bean(lessonInfoBean);


        String str = "";

        if (planArrBean.getArr().size() > 0) {

            for (int i = 0; i < planArrBean.getArr().size(); i++) {

                if (i == 0) {
                    str += planArrBean.getArr().get(i).getName() + "  ";
                } else {
                    for (int k = 0; k < planArrBean.getArr().get(i).getName().toString().length() + 1; k++) {
                        str += "  ";
                    }


                }
                for (int j = 0; j < planArrBean.getArr().get(i).getList().size(); j++) {

                    str+= planArrBean.getArr().get(i).getList().get(j).getActionName()+
                            "("+
                            planArrBean.getArr().get(i).getList().get(j).getGroupCount()+"组*"+
                            planArrBean.getArr().get(i).getList().get(j).getAmount()+
                            ")\n";
                }


            }


        }

        noteContent.setText(str);
    }

    public void refresh() {


        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);


        Intent intent = getIntent();

        String Customerid = intent.getStringExtra(PUT_STR + "Id");

        String AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");

        String lessonType = intent.getStringExtra(PUT_STR + "Type");
        String lessonName = intent.getStringExtra(PUT_STR + "Name");
        String lessonCoach = intent.getStringExtra(PUT_STR + "coach");
        String lessonTime = intent.getStringExtra(PUT_STR + "time");


        textTypeLesson.setText(lessonType);
        textNameLesson.setText(lessonName);
        textTimeLesson.setText(lessonTime);
        textCoachLesson.setText(lessonCoach);
        mPresenter.getLessonInfoFromApponitment(UserId, token, ClubId, Customerid, lessonType, AppointmentId);


    }


//    @OnClick({R.id.appointment_type_btn, R.id.end_time_btn, R.id.remind_time_btn, R.id.interval_time_btn, R.id.begin_time_btn})
//    public void onViewClicked(View view) {
//
//
//        switch (view.getId()) {
//            case R.id.appointment_type_btn:
//                break;
//            case R.id.begin_time_btn:
//
//
//                break;
//            case R.id.end_time_btn:
//
//
//                break;
//            case R.id.remind_time_btn:
//
//
//                break;
//            case R.id.interval_time_btn:
//
//
//                break;
//        }
//    }


}

