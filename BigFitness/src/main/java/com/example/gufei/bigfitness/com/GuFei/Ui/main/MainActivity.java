package com.example.gufei.bigfitness.com.GuFei.Ui.main;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
//import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.Constants;
import com.example.gufei.bigfitness.Presenter.MainAdapter;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AdddayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ResultBean;
import com.example.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressEditListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomScanActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion.AppUpdate;
import com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion.PermissionUtils;
import com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion.UpdateBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMent;
import com.example.gufei.bigfitness.util.MobileUtil;
import com.example.gufei.bigfitness.util.PermissionTool;
import com.example.gufei.bigfitness.util.SpUtil;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.igexin.sdk.PushManager;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.gufei.bigfitness.App.SCREEN_HEIGHT;
import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityContract.View, FragMentListening, AddressEditListening, View.OnLayoutChangeListener {
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.activity_main)
    LinearLayout activityRootView;

    private String[] tabTitles; // 标题数组
    private List<android.support.v4.app.Fragment> fragments = new ArrayList<>();
    private MainAdapter adapter;
    private static final int REQUEST_CODE = 1;
    private String ScanResult;
    private int userId;
    /**
     * Tab 图片
     */
    private int[] images_selector = {R.mipmap.address_book_btn_selected, R.mipmap.main_btn_selected,
            R.mipmap.cenet_btn_selected,};
    private int[] images_normal = {R.mipmap.address_book_btn, R.mipmap.main_btn,
            R.mipmap.cenet_btn};

    private int closeF = 0;

    long exitTime;
    private AppUpdate appUpdate;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();

        //添加layout大小发生改变监听器
        activityRootView.addOnLayoutChangeListener(MainActivity.this);
    }

    @Override
    public void HiddenTab() {
        mTabLayout.setVisibility(View.GONE);
    }

    @Override
    public void ShowTab() {
//        mTabLayout.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        userId = (int) SpUtil.get(mContext, USERIDKEY,0);
        // 从资源文件中获取标题
        tabTitles = getResources().getStringArray(R.array.tabTitle);
        // 添加 Fragment
        fragments.add(new AddressListFragMent());
        fragments.add(new IndexFragMent());
        fragments.add(new MyCenterMainFragMent());
//        fragments.add(new IndexFragMent());

        adapter = new MainAdapter(getSupportFragmentManager(), fragments, tabTitles);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
        // 将 TabLayout 关联到 ViewPager  TabLayout 从 ViewPager 的 title 中获取文本
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//tab不能滚动，平分屏幕宽度

        // 设置默认图标
        /*mTabLayout.getTabAt(0).setIcon(images_selector[0]);
        mTabLayout.getTabAt(1).setIcon(images_normal[1]);
        mTabLayout.getTabAt(2).setIcon(images_normal[2]);
        mTabLayout.getTabAt(3).setIcon(images_normal[3]);*/

        // 设置自定布局
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {


            mTabLayout.getTabAt(i).setCustomView(getTabView(i));

        }

        mViewPager.setCurrentItem(1);

        mTabLayout.getTabAt(1).select();


        // 添加选中状态侦听修改选中图标
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.green_btn));
                View v = tab.getCustomView();
                v.setBackgroundColor(getResources().getColor(R.color.green_btn));
                TextView textView = (TextView) v.findViewById(R.id.tv_tab);
                ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
                textView.setTextColor(getResources().getColor(R.color.white));
                imageView.setImageResource(images_selector[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View v = tab.getCustomView();
                v.setBackgroundColor(getResources().getColor(R.color.lightgray));
                TextView textView = (TextView) v.findViewById(R.id.tv_tab);
                ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
                textView.setTextColor(getResources().getColor(R.color.gray));
                imageView.setImageResource(images_normal[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void BtnBack() {

    }

    private View getTabView(int position) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_tab_layout, null);

//        v.setLayoutParams(new LinearLayout.LayoutParams(windowWidth, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView textView = (TextView) v.findViewById(R.id.tv_tab);
        ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
        if (position == 1) {
            v.setBackgroundColor(getResources().getColor(R.color.green_btn));
            textView.setTextColor(getResources().getColor(R.color.white));
            imageView.setImageResource(images_selector[position]);
        } else {
            v.setBackgroundColor(getResources().getColor(R.color.lightgray));
            textView.setTextColor(getResources().getColor(R.color.gray));
            imageView.setImageResource(images_normal[position]);
        }
        textView.setText(tabTitles[position]);
        return v;
    }

//    private void refresh() {
//        mPresenter.updata("");
//    }


    @Override
    protected void initData() {

        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);

        int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        mPresenter.updata(userid, token, clubid, String.valueOf(IsDepartManager), String.valueOf(DepartId));
        mPresenter.getCustomerSource(userid, token, clubid);
        mPresenter.getCustomerIntroducer(userid, token, clubid, "");
        //mPresenter.upDateApp("0");
        //没办法后台写的更新的接口 BaseUrl和项目的不一样 不能够用这种请求方式了
        //updateApp();

    }
    //检查新版本
    private void updateApp() {
        RequestParams params = new RequestParams(Constants.UPDATE_CHECK_URL);
        params.addParameter("AppType","0");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Gson gson = new Gson();
                    UpdateBean updateBean = gson.fromJson(result, UpdateBean.class);
                    String version = updateBean.getRows().getVersion();
                    int newVersion = Integer.parseInt(version);
                    int currentVersion = MobileUtil.getVersionCode();
                    if (newVersion > currentVersion){
                        appUpdate = new AppUpdate(MainActivity.this,updateBean);
                        appUpdate.httpCheckUpdate(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //更新的方法
    private void checkPackageVersion(UpdateBean updateBean) {
        //检查或获取权限
        boolean isGranted= PermissionUtils.checkOrRequestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},200,this);
        if(isGranted){
            //权限已经被赋予
            appUpdate = new AppUpdate(MainActivity.this,updateBean);
            appUpdate.httpCheckUpdate(null);
        }else{
            Toast.makeText(this, "权限获取失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right,
                               int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

        //old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值

//      System.out.println(oldLeft + " " + oldTop +" " + oldRight + " " + oldBottom);
//      System.out.println(left + " " + top +" " + right + " " + bottom);


        //现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > SCREEN_HEIGHT / 3)) {
            mTabLayout.setVisibility(View.GONE);

//            Toast.makeText(MainActivity.this, "监听到软键盘弹起...", Toast.LENGTH_SHORT).show();

        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > SCREEN_HEIGHT / 3)) {
            mTabLayout.setVisibility(View.VISIBLE);
//            Toast.makeText(MainActivity.this, "监听到软件盘关闭...", Toast.LENGTH_SHORT).show();

        }
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
    public void update(UpdateBean updateBean) {
        checkPackageVersion(updateBean);
    }

    @Override
    public void Loading() {

    }

    @Override
    public void succeed(MainMsgBean testBean) {

    }


//    @OnClick({R.id.address_btn, R.id.main_btn, R.id.my_btn})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.address_btn:
//                break;
//            case R.id.main_btn:
//                break;
//            case R.id.my_btn:
//                break;
//        }
//    }


    /**
     * 扫描二维码回调方法
     *
     * @param requestCode  请求码
     * @param permissions  请求权限
     * @param grantResults 请求状态
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 8444:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Intent intent = new Intent(mContext, ScanActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    // Permission Denied
                    Toast.makeText(mContext, "无法打开摄像头，缺少必要权限，您应在应用管理中授予权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    /**
     * 处理二维码扫描结果
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK){
            return;
        }
        final IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "内容为空", Toast.LENGTH_LONG).show();
            } else {
//                Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();
                ScanResult = intentResult.getContents();
                gethttp();
//                s(mContext, ScanResult);
//                intentScan.setClass(MainActivity.this, ScanSelection.class);
//                intentScan.putExtra("id", ScanResult);
//                startActivity(intentScan);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE) {
//            //处理扫描结果（在界面上显示）
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(mContext, "无法进行上课打卡!请扫描会员二维码", Toast.LENGTH_LONG).show();
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
//            }
//        }

//        if (requestCode == REQUEST_CODE) {
//            //处理扫描结果（在界面上显示）
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                // 获取扫描结果, 并显示在 webView 中
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(mContext, "无法进行上课打卡!请扫描会员二维码", Toast.LENGTH_LONG).show();
//
////                    webView.loadUrl(result);
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
//            }
//        }
    }

    private void gethttp() {
        int AppointmentTeacherId = userId;
        RequestParams params = new RequestParams(ScanResult + "");
        params.addQueryStringParameter("AppointmentTeacherId",AppointmentTeacherId + "");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                ResultBean resultBean=new Gson().fromJson(result,ResultBean.class);
                if (resultBean.getRet() == 0){
//                    Toast.makeText(mContext, "打卡成功！", Toast.LENGTH_LONG).show();
                    AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                    //获取AlertDialog对象
//                    dialog.setTitle("");//设置标题
                    dialog.setMessage("打卡成功");//设置信息具体内容
                    dialog.setCancelable(false);//设置是否可取消
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
//                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
                    dialog.show();
                }else {
                    Toast.makeText(mContext, resultBean.getMsg(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    /**
     * 扫描
     */

    public void Scan() {

//
//        Intent Scan = new Intent(mContext, CaptureActivity.class);
//        Intent Scan = new Intent(mContext, ScanActivity.class);
        // 6.0版本后 动态权限处理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            new IntentIntegrator(this)
                    .setOrientationLocked(false)
                    .setCaptureActivity(CustomScanActivity.class) // 设置自定义的activity是CustomActivity
                    .initiateScan(); // 初始化扫描
            if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(mContext, new String[]{android.Manifest.permission.CAMERA}, 8444);
                //Activity中的初始化方式

            } else {

//                startActivityForResult(Scan, REQUEST_CODE);
            }
        } else {
            if (PermissionTool.isCameraCanUse()) {

//                startActivityForResult(Scan, REQUEST_CODE);
            } else {
                Toast.makeText(mContext, "无法打开摄像头，缺少必要权限，您应在应用管理中授予权限", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public void BtnScan() {

        Scan();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}

