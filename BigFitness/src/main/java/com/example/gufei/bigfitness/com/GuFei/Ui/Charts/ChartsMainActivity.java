package com.example.gufei.bigfitness.com.GuFei.Ui.Charts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.Presenter.MainAdapter;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivity;
import com.example.gufei.bigfitness.util.PermissionTool;
import com.example.gufei.bigfitness.util.SpUtil;
import com.igexin.sdk.PushManager;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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


public class ChartsMainActivity extends BaseActivity<ChartsMainActivityPresenter> implements ChartsMainActivityContract.View {


    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;

    private String[] tabTitles; // 标题数组

    private List<Fragment> fragments = new ArrayList<>();
    private MainAdapter adapter;
    private static final int REQUEST_CODE = 1;
    // Tab 图片
//    private int[] images_selector = {R.mipmap.address_book_btn_selected, R.mipmap.main_btn_selected,
//            R.mipmap.cenet_btn_selected,};
//    private int[] images_normal = {R.mipmap.address_book_btn, R.mipmap.main_btn,
//            R.mipmap.cenet_btn};

    private int closeF = 0;

    long exitTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main_charts;
    }

    @Override
    protected void initView() {



        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);
        // 从资源文件中获取标题
        tabTitles = getResources().getStringArray(R.array.ChartsTabTitle);
        // 添加 Fragment
//        fragments.add(new AddressListFragMent());
//        fragments.add( new Index2FragMent());
//        fragments.add(new Index2FragMent());
//        fragments.add(new Index2FragMent());
//        fragments.add(new Index2FragMent());

        fragments.add(new Index1FragMent());

        fragments.add(new Index1FragMent());
        fragments.add(new Index1FragMent());
        fragments.add(new Index1FragMent());

//        fragments.add(new IndexFragMent());


        adapter = new MainAdapter(getSupportFragmentManager(), fragments, tabTitles);
        mViewPager.setOffscreenPageLimit(2);
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

        mViewPager.setCurrentItem(0);
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        mViewPager.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        mViewPager.requestDisallowInterceptTouchEvent(false);
                        break;
                }

                return false;
            }
        });

        mTabLayout.getTabAt(0).select();

        // 添加选中状态侦听修改选中图标
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

//                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.green_btn));
                View v = tab.getCustomView();
                TextView textView = (TextView) v.findViewById(R.id.tv_tab);
//                textView.setBackgroundColor(getResources().getColor(R.color.green_btn));
                textView.setBackground(getResources().getDrawable(R.drawable.text_round_rect));
//                ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
                textView.setTextColor(getResources().getColor(R.color.white));
//                imageView.setImageResource(images_selector[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View v = tab.getCustomView();

                TextView textView = (TextView) v.findViewById(R.id.tv_tab);
                textView.setBackgroundColor(getResources().getColor(R.color.white));
//                ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
                textView.setTextColor(getResources().getColor(R.color.gray));
//                imageView.setImageResource(images_normal[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private View getTabView(int position) {


        View v = LayoutInflater.from(this).inflate(R.layout.item_tab_charts_layout, null);

//        v.setLayoutParams(new LinearLayout.LayoutParams(windowWidth, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView textView = (TextView) v.findViewById(R.id.tv_tab);

        if (position == 0) {
            textView.setBackgroundColor(getResources().getColor(R.color.green_btn));
            textView.setTextColor(getResources().getColor(R.color.white));

        } else {
            textView.setBackgroundColor(getResources().getColor(R.color.white));
            textView.setTextColor(getResources().getColor(R.color.gray));

        }
        textView.setText(tabTitles[position]);
        return v;
    }

//    private void refresh() {
//        mPresenter.updata("");
//    }


    @Override
    protected void initData() {

//        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
//        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
//
//        int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//        mPresenter.updata(userid, token, clubid, String.valueOf(IsDepartManager), String.valueOf(DepartId));
//        mPresenter.getCustomerSource(userid, token, clubid);
//        mPresenter.getCustomerIntroducer(userid, token, clubid, "");


    }


    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {


//        s(this, "您的帐号在其他设备登录");
//        Intent intent = new Intent(context, LoginActivity.class);
//        remove();
//
//        startActivity(intent);

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


//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//
//            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
//            {
//                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            } else {
//                finish();
//                System.exit(0);
//            }
//
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    protected void dialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(ChartsMainActivity.this);
//        builder.setMessage("确定要退出吗?");
//        builder.setTitle("提示");
//        builder.setPositiveButton("确认",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        //AccoutList.this.finish();
//                        //System.exit(1);
//                        android.os.Process.killProcess(android.os.Process.myPid());
//                    }
//                });
//        builder.setNegativeButton("取消",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        builder.create().show();
//    }
//

}

