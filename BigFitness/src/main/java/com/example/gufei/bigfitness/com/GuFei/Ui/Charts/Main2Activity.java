package com.example.gufei.bigfitness.com.GuFei.Ui.Charts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.Presenter.MainAdapter;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3.Index3FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4.Index4FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivity;
import com.example.gufei.bigfitness.util.MyViewPager.MyViewPager;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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


/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表主页Activity
 * 承载Fragement
 */


public class Main2Activity extends FragmentActivity {


    @BindView(R.id.vp_main)
    MyViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.ScanImg)
    ImageView LeftBtn;


    private String[] tabTitles; // 标题数组
    private List<Fragment> fragments = new ArrayList<>();
    private MainAdapter adapter;
    private static final int REQUEST_CODE = 1;
    private String persontype;
    // Tab 图片
//    private int[] images_selector = {R.mipmap.address_book_btn_selected, R.mipmap.main_btn_selected,
//            R.mipmap.cenet_btn_selected,};
//    private int[] images_normal = {R.mipmap.address_book_btn, R.mipmap.main_btn,
//            R.mipmap.cenet_btn};

    private int closeF = 0;

    long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_charts);
        ButterKnife.bind(this);


        persontype = (String) SpUtil.get(this, PERSONTYPEKEY, "");


        LeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (persontype.equals("会籍") || persontype.equals("教练")) {
                    finish();

                } else {

                    remove();
                    Intent intent = new Intent(Main2Activity.this, LoginActivity.class);
                    finish();
                    startActivity(intent);

                }

            }
        });


        // 从资源文件中获取标题
        tabTitles = getResources().getStringArray(R.array.ChartsTabTitle);

        // 添加 Fragment
//        fragments.add(new AddressListFragMent());


//        fragments.add( new Index2FragMent());
//        fragments.add(new Index2FragMent());
//        fragments.add(new Index2FragMent());
//        fragments.add(new Index2FragMent());

        fragments.add(new Index1FragMent());
        fragments.add(new Index2FragMent());
        fragments.add(new Index3FragMent());
        fragments.add(new Index4FragMent());

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

//        webview.getSettings().setDefaultTextEncodingName("gb2312");
//
//        // 页面缩放控制 去除控制条 http://blog.csdn.net/hanhailong726188/article/details/46717621
//        webview.getSettings().setSupportZoom(true);
//        webview.getSettings().setBuiltInZoomControls(true);
//
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                // 如果是百度页面，则在本页面打开，否则使用系统浏览器
//                if (Uri.parse(url).getHost().contains("baidu.com")) {
//                    // This is my web site, so do not override; let my WebView load the page
//                    Log.d("Host", "Host:" + Uri.parse(url).getHost());
//                    return false;
//                }
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent);
//                return true;
//            }
//        });
//
//
//        webview.loadUrl("http://www.baidu.com");
    }

    private View getTabView(int position) {


        View v = LayoutInflater.from(this).inflate(R.layout.item_tab_charts_layout, null);

//        v.setLayoutParams(new LinearLayout.LayoutParams(windowWidth, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView textView = (TextView) v.findViewById(R.id.tv_tab);

        if (position == 0) {
//            textView.setBackgroundColor(getResources().getColor(R.color.green_btn));
            textView.setBackground(getResources().getDrawable(R.drawable.text_round_rect));
            textView.setTextColor(getResources().getColor(R.color.white));

        } else {
            textView.setBackgroundColor(getResources().getColor(R.color.white));
            textView.setTextColor(getResources().getColor(R.color.gray));

        }
        textView.setText(tabTitles[position]);
        return v;
    }

    public void remove() {

        SpUtil.remove(this, ACCOUNTKEY);
        SpUtil.remove(this, PASSWRODKEY);
        SpUtil.remove(this, DEVICECODEKEY);
        SpUtil.remove(this, USERIDKEY);
        SpUtil.remove(this, USERNAMEKEY);
        SpUtil.remove(this, SEXKEY);
        SpUtil.remove(this, CLUBIDKEY);
        SpUtil.remove(this, TOKENKEY);
        SpUtil.remove(this, PERSONTYPEKEY);
        SpUtil.remove(this, ISDERPARTMANAGERKEY);
        SpUtil.remove(this, DEPARTIDKEY);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (!persontype.equals("会籍") && !persontype.equals("教练") ) {
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
        }
        return super.onKeyDown(keyCode, event);

    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setMessage("确定要退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //AccoutList.this.finish();
                        //System.exit(1);
                        finish();
                        System.exit(0);
                    }
                });
        builder.setNegativeButton("取消",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
