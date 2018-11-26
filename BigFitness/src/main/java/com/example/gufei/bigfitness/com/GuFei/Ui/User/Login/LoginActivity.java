package com.example.gufei.bigfitness.com.GuFei.Ui.User.Login;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.Main2Activity;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivity;
import com.example.gufei.bigfitness.component.ActivityCollector;
import com.example.gufei.bigfitness.util.LoadingDialog;
import com.example.gufei.bigfitness.util.SpUtil;
import com.example.gufei.bigfitness.util.StatusBarCompat;
import com.example.gufei.bigfitness.util.StringUtil;
import com.google.gson.Gson;
import com.igexin.sdk.PushManager;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.example.gufei.bigfitness.Constants.CLIENTID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CLUBLISTKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.DEVICECODEKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.LOGINKEY;
import static com.example.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.SEXKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERLEVELKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 *
 */


public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements LoginActivityContract.View {


    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.invisible_password)
    ImageView invisiblePassword;
    @BindView(R.id.remberCheckBox)
    CheckBox remberCheckBox;
    @BindView(R.id.login_btn)
    Button loginBtn;
    private LoadingDialog loadingDialog;
    private boolean isHidden = true;

    String clientId;
    long exitTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
//        http();
        //初始化推送   SpUtil.clear(this);
//
//        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.no_back), 0);
//        StatusBarCompat.StatusBarLightMode(this);
//        StatusBarUtil.setTranslucent(this);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                Window window = getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                attributes.flags |= flagTranslucentNavigation;
//                window.setAttributes(attributes);
//                getWindow().setStatusBarColor(Color.TRANSPARENT);
//            } else {
//                Window window = getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
//                window.setAttributes(attributes);
//            }
//        }
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);
        loadingDialog=new LoadingDialog(this);
//        deviceCode = (String) SpUtil.get(mContext, CLIENTID, "");
        clientId = (String) SpUtil.get(mContext, CLIENTID, "");

        if (clientId.equals("")){
            clientId=PushManager.getInstance().getClientid(this);

        }
        String name = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
        String pwd = (String) SpUtil.get(mContext, PASSWRODKEY, "");
        String login = (String) SpUtil.get(mContext, LOGINKEY, "");

        if (!StringUtil.isSpace(name) && !StringUtil.isSpace(pwd)) {
            username.setText(name);
            password.setText(pwd);
            remberCheckBox.setChecked(true);
            if (login.equals("1")) {
//                mPresenter.login(name, pwd, clientId, remberCheckBox.isChecked());//设备码未填写 为假数据/
                SpUtil.put(mContext, LOGINKEY, "0");
            }
        }
    }

    /**
     *
     * 固化用户信息
     * @param account 帐号
     * @param password 密码
     * @param deviceCode 设备号
     * @param loginBean 登录返回信息
     * @param flag 记录标识
     */
    @Override
    public void remember(String account, String password, String deviceCode, LoginBean loginBean, boolean flag) {

        if (flag) {
            SpUtil.put(mContext, ACCOUNTKEY, account);
            SpUtil.put(mContext, PASSWRODKEY, password);
            SpUtil.put(mContext, LOGINKEY, "1");
        }


        SpUtil.put(mContext, DEVICECODEKEY, deviceCode);
        SpUtil.put(mContext, USERLEVELKEY, loginBean.getUserLevel());
        SpUtil.put(mContext, USERIDKEY, loginBean.getUserId());
        SpUtil.put(mContext, USERNAMEKEY, loginBean.getUserName());
        SpUtil.put(mContext, SEXKEY, loginBean.getSex());
        SpUtil.put(mContext, CLUBIDKEY, loginBean.getClubId());
        SpUtil.put(mContext, TOKENKEY, loginBean.getToken());
        SpUtil.put(mContext, PERSONTYPEKEY, loginBean.getPersonType());
        SpUtil.put(mContext, ISDERPARTMANAGERKEY, loginBean.getIsdepartmanager());
        SpUtil.put(mContext, DEPARTIDKEY, loginBean.getDepartId());
        SpUtil.put(mContext, CLUBLISTKEY, new Gson().toJson(loginBean.getClubList()));
//        String s = (String) SpUtil.get(mContext, CLUBLISTKEY, "");
    }


    @Override
    public void remove() {

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

    }

    @Override
    protected void initData() {

//        JPushInterface.init(getApplicationContext());

    }



    @Override
    public void showError(String msg) {
        loadingDialog.dismiss();
        s(this, msg);

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {


    }


    @Override
    public void Loading() {

    }


    @Override
    public void succeed(LoginBean loginBean) {
        loadingDialog.dismiss();
        Intent intent;
        if (loginBean.getPersonType().equals("会籍") || loginBean.getPersonType().equals("教练")) {
            intent = new Intent(LoginActivity.this, MainActivity.class);
//        Intent intent = new Intent(LoginActivity.this, ChartsMainActivity.class);

        } else {

            intent = new Intent(LoginActivity.this, Main2Activity.class);
        }
        startActivity(intent);
        finish();
    }

    @OnClick({R.id.invisible_password, R.id.remberCheckBox, R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.invisible_password:

                if (isHidden) {
                    //设置EditText文本为可见的
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置EditText文本为隐藏的
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHidden = !isHidden;
                if (!isHidden) {
                    invisiblePassword.setImageResource(R.mipmap.signin07);
                } else {
                    invisiblePassword.setImageResource(R.mipmap.signin_07);
                }

                password.postInvalidate();

                //切换后将EditText光标置于末尾
                CharSequence charSequence = password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());

                }
                break;

            case R.id.remberCheckBox:
                break;
            case R.id.login_btn:

                String name = username.getText().toString();
                String pwd = password.getText().toString();
                if (StringUtil.isSpace(name)) {
                    username.requestFocus();
                    s(mContext, "请输入帐户");
                    return;
                }
                if (StringUtil.isSpace(pwd)) {
                    password.requestFocus();
                    s(mContext, "请输入密码");
                    return;
                }
                // TODO: 2017/4/10
                if (StringUtil.length(pwd) < 1) {
                    password.requestFocus();
                    s(mContext, "密码不得小于六位");
                    return;
                }
                mPresenter.login(name, pwd, clientId, remberCheckBox.isChecked());//设备码未填写 为假数据
                loadingDialog.show();
                break;
        }
    }

//    @Override
//    public void onBackPressed() {
////        super.onBackPressed();
//
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    System.exit(0);
                } else {// android2.1
                    ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                    am.restartPackage(getPackageName());
                }
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
