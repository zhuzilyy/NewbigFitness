package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.About.AboutActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.VideoPlayView.VideoPlayActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.DEVICECODEKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.SEXKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.StringUtil.isSpace;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by Administrator on 2017/8/4.
 * 设置页面
 */

public class SetingActivity extends BaseActivity<SetingActivityPresenter> implements SetingActivityContract.View {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.change_password_btn)
    TextView changePasswordBtn;
    @BindView(R.id.about_btn)
    TextView aboutBtn;
    @BindView(R.id.login_out_btn)
    Button loginOutBtn;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;
    private int i=1;
    protected void initInject() {
        getActivityComponent().inject(this);
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_seting;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        toolbar.setTitle("");
        tvTitle.setText("设置");
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.change_password_btn, R.id.about_btn, R.id.login_out_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_password_btn:
                //修改密码

                changePsw(view, 0);

                break;
            case R.id.about_btn:
                //关于我们


                Intent intent = new Intent(SetingActivity.this, AboutActivity.class);


                startActivity(intent);


                break;
            case R.id.login_out_btn:
                if (i==1) {
                    //退出登录
                    int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                    String name = (String) SpUtil.get(mContext, USERNAMEKEY, "");

                    int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

                    mPresenter.outLogin(userid, token, clubid, name);
                    i=2;
                }

                break;
        }
    }

/*
* 弹窗修改密码
*
* */
    public void changePsw(View v, final int tag) {

        final View contentView = LayoutInflater.from(this).inflate(R.layout.change_pwd_view, null);

        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 700, true);

//        popupWindow.setAnimationStyle(R.style.PopupWindowStyle);//设置动画


        popupWindow.update();

        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        backgroundAlpha(0.3f);
//        mShowMorePopupWindowWidth = content.getMeasuredWidth();

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                final EditText pswOld = (EditText) contentView.findViewById(R.id.password_old);
//
                final EditText pswNew = (EditText) contentView.findViewById(R.id.password_new);

                final EditText pswConfirm = (EditText) contentView.findViewById(R.id.password_confirm);

                Button btn = (Button) contentView.findViewById(R.id.btn_change);

                Button btnClose = (Button) contentView.findViewById(R.id.btn_close);

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (isSpace(pswOld.getText().toString()) ||
                                isSpace(pswNew.getText().toString()) ||
                                isSpace(pswConfirm.getText().toString()) ||
                                !pswConfirm.getText().toString().equals(pswNew.getText().toString())) {
                            s(SetingActivity.this, "请确认密码输入正确！");
                        } else {
                            int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);
                            String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                            String name = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                            int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                            mPresenter.changPsw(userid, token, clubid, name, pswOld.getText().toString(), pswNew.getText().toString());
                        }
                    }
                });


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

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = SetingActivity.this.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        SetingActivity.this.getWindow().setAttributes(lp);
    }


    @Override
    public void succeed() {

        s(this, "您的帐号在其他设备登录");

        Intent intent = new Intent(context, LoginActivity.class);
        remove();
        startActivity(intent);
        finish();

    }

    @Override
    public void outLogin() {

        s(SetingActivity.this, "退出成功");


        SpUtil.remove(mContext, ACCOUNTKEY);
        SpUtil.remove(mContext, PASSWRODKEY);
        SpUtil.remove(mContext, DEVICECODEKEY);
        SpUtil.remove(mContext, USERIDKEY);
        SpUtil.remove(mContext, USERNAMEKEY);
        SpUtil.remove(mContext, SEXKEY);
        SpUtil.remove(mContext, CLUBIDKEY);
        SpUtil.remove(mContext, TOKENKEY);
        SpUtil.remove(mContext, PERSONTYPEKEY);
        SpUtil.remove(mContext, ISDERPARTMANAGERKEY);
        SpUtil.remove(mContext, DEPARTIDKEY);

        finish();
        Intent intent = new Intent(SetingActivity.this, LoginActivity.class);
        startActivity(intent);


    }


    @Override
    public void showEmpty() {

    }


    @Override
    public void Loading() {

    }
}
