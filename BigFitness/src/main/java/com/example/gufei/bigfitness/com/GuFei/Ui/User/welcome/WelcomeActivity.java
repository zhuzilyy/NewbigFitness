package com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.Main2Activity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivityContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivity;
import com.example.gufei.bigfitness.util.PermissionTool;
import com.example.gufei.bigfitness.util.SpUtil;
import com.example.gufei.bigfitness.util.StatusBarCompat;
import com.example.gufei.bigfitness.util.StringUtil;
import com.google.gson.Gson;
import com.igexin.sdk.PushManager;
import com.jaeger.library.StatusBarUtil;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

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
 * Created by Administrator on 2017/8/4.
 * 欢迎页面<br></>
 * 初始化推送<br></>
 * 申请相关权限
 */
@RuntimePermissions
public class WelcomeActivity extends BaseActivity<WelcomeActivityPresenter> implements WelcomeActivityContract.View {

    private Handler handler = new Handler();

    String deviceCode;


    @Override
    public void showEmpty() {


    }

    @Override
    public void Error() {

        Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {

    }

    @Override
    public void succeed(LoginBean loginBean) {

        if (loginBean.getPersonType().equals("会籍") || loginBean.getPersonType().equals("教练")) {

            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 1000);//1秒跳转


        } else {

            mHandler.sendEmptyMessageDelayed(GOTO_MAIN2_ACTIVITY, 1000);//1秒跳转
        }


    }


    @Override
    public void remember(String account, String password, String deviceCoded, LoginBean loginBean, boolean flag) {
        if (flag) {
            SpUtil.put(mContext, ACCOUNTKEY, account);
            SpUtil.put(mContext, PASSWRODKEY, password);
            SpUtil.put(mContext, LOGINKEY, "1");
        }


//        SpUtil.put(mContext, DEVICECODEKEY, deviceCode);
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
        int s = (int) SpUtil.get(mContext, USERLEVELKEY, 9);


    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.white), 0);
        StatusBarCompat.StatusBarLightMode(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
//        needP();
        InitPermissions();

    }

    @Override
    protected void initData() {


    }

    private static final int GOTO_MAIN_ACTIVITY = 0;
    private static final int GOTO_LOGIN_ACTIVITY = 1;
    private static final int GOTO_MAIN2_ACTIVITY = 2;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
/**
 * 判断用户是否为实际业务用户 跳转不同的页面
 */
            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:

                    Intent intent = new Intent();
                    intent.setAction("reciver");
                    sendBroadcast(intent);
                    intent.setClass(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    finish();

                    break;
                case GOTO_LOGIN_ACTIVITY:
                    Intent login = new Intent();
                    login.setAction("reciver");
                    sendBroadcast(login);
                    login.setClass(WelcomeActivity.this, LoginActivity.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    finish();
                    break;
                case GOTO_MAIN2_ACTIVITY:
                    Intent intent1 = new Intent(WelcomeActivity.this, Main2Activity.class);
                    intent1.setAction("reciver");
                    sendBroadcast(intent1);
                    intent1.setClass(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    finish();
                    break;

                default:
                    break;
            }
        }

        ;
    };


    private void init() {




        String name = (String) SpUtil.get(this, ACCOUNTKEY, "");
        String pwd = (String) SpUtil.get(this, PASSWRODKEY, "");
        String login = (String) SpUtil.get(this, LOGINKEY, "");



        if (!StringUtil.isSpace(name) && !StringUtil.isSpace(pwd)) {
            //初始化推送
//            PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);

            deviceCode = (String) SpUtil.get(mContext, CLIENTID, "");
//            if (login.equals("1")) {
            mPresenter.login(name, pwd, deviceCode, true);//设备码未填写 为假数据
//            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 1000);//1秒跳转
//                SpUtil.put(mContext, LOGINKEY, "0");
//            }
        } else {

            mHandler.sendEmptyMessageDelayed(GOTO_LOGIN_ACTIVITY, 1000);//1秒跳转

        }

    }

    //定义请求
    private static final int READ_CONTACTS_REQUEST = 1;

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE})
    void InitPermissions() {

        /**
         * 1)使用ContextCompat.chefkSelfPermission(),因为Context.permission
         * 只在棒棒糖系统中使用
         * 2）总是检查权限（即使权限被授予）因为用户可能会在设置中移除你的权限*/
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //权限为获取，检查用户是否被询问过并且拒绝了，如果是这样的话，给予更多
            //解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                //在界面上展示为什么需要读取联系人
                Toast.makeText(this, "无法使用推送信息,请授权!", Toast.LENGTH_SHORT).show();
            }


            //发起请求获得用户许可,可以在此请求多个权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_PHONE_STATE},
                    READ_CONTACTS_REQUEST);
        } else {
            init();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //确保是我们的请求
        if (requestCode == READ_CONTACTS_REQUEST) {
            if (grantResults.length == 4 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                init();

            } else if (grantResults.length == 3 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "授权失败,请到设置内开启推送权限", Toast.LENGTH_SHORT).show();
            } else if (grantResults.length == 3 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                init();
            } else {
                init();
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        WelcomeActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
