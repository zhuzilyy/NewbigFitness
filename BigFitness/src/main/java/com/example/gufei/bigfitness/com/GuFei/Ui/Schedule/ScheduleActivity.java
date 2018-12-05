package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gufei.bigfitness.Presenter.MainAdapter;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment.AddAppointmentScheduleActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon.MonFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day.DayFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list.ListFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week.WeekFragment;
import com.example.gufei.bigfitness.component.CustomViewPager;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.util.ToastUtil.s;


public class ScheduleActivity extends BaseActivity<ScheduleActivityPresenter> implements ScheduleActivityContract.View,FragMentListening {


    @BindView(R.id.vp_main)
    CustomViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;

    /*@BindView(R.id.nav)
    BottomNavigationView nav;*/

    private String[] tabTitles; // 标题数组
    private List<Fragment> fragments = new ArrayList<>();
    private MainAdapter adapter;


    WeekFragment weekFragmentNo;
    WeekFragment weekFragment;
    MonFragment monFragment;
    DayFragment dayFragment;
    ListFragment listFragment;
    int firstLoad = 0;
    int page = 2;

    // Tab 图片
    private int[] images_selector = {
            R.mipmap.scheduleweek_03,
            R.mipmap.schedule_03,
            R.mipmap.scheduleweek_08,
            R.mipmap.scheduleday_05,
            R.mipmap.schedulelist_03,};


    private int[] images_normal = {
            R.mipmap.scheduleweek_03,
            R.mipmap.scheduleweek_06,
            R.mipmap.scheduleday_03,
            R.mipmap.scheduleweek_10,
            R.mipmap.scheduleweek_13};

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {


        return R.layout.activity_schedule;

    }


    /**
     *
     */
    @Override
    protected void initView() {
        firstLoad = 1;

        // 从资源文件中获取标题
        tabTitles = getResources().getStringArray(R.array.ScheduleTabTitle);

        // 添加 Fragment
        weekFragmentNo = new WeekFragment();
        monFragment = new MonFragment();
        weekFragment = new WeekFragment();
        dayFragment = new DayFragment();
        listFragment = new ListFragment();
        fragments.add(weekFragmentNo);
        fragments.add(monFragment);
        fragments.add(weekFragment);
        fragments.add(dayFragment);
        fragments.add(listFragment);
        adapter = new MainAdapter(getSupportFragmentManager(), fragments, tabTitles);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(adapter);
        // 将 TabLayout 关联到 ViewPager  TabLayout 从 ViewPager 的 title 中获取文本
        mTabLayout.setupWithViewPager(mViewPager);

        // 设置默认图标
        mTabLayout.getTabAt(0).setIcon(images_selector[0]);
        mTabLayout.getTabAt(1).setIcon(images_normal[1]);
        mTabLayout.getTabAt(2).setIcon(images_normal[2]);
        mTabLayout.getTabAt(3).setIcon(images_normal[3]);


        // 设置自定布局
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(getTabView(i));
        }

//

        mTabLayout.getTabAt(0).getCustomView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddAppointmentScheduleActivity.class);
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                intent.putExtra(mStrType, REFRESHID);
                startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
            }
        });
        // 添加选中状态侦听修改选中图标
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View v = tab.getCustomView();
                TextView textView = (TextView) v.findViewById(R.id.tv_tab);
                ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
                textView.setTextColor(getResources().getColor(R.color.event_green));
                imageView.setImageResource(images_selector[tab.getPosition()]);
                page = tab.getPosition();
                if (tab.getPosition() == 0) {

//                    mViewPager.setCurrentItem(page);


                    TabLayout.Tab t = mTabLayout.getTabAt(page);
                    if (tab != null) {
                        tab.select();
                        tab.getCustomView().findViewById(R.id.tv_tab).setSelected(true);
                        ((ImageView) tab.getCustomView().findViewById(R.id.iv_tab)).setImageResource(images_selector[tab.getPosition()]);
                    }


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View v = tab.getCustomView();
                TextView textView = (TextView) v.findViewById(R.id.tv_tab);
                ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
                textView.setTextColor(getResources().getColor(R.color.gray));
                imageView.setImageResource(images_normal[tab.getPosition()]);

                String str = "1.2.3";
                List<String> list = new ArrayList<String>();
                String[] arr = str.split(".");
                for (int i = 0; i < arr.length - 1; i++) {
                    list.add(arr[i]);
                }


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    //    public void setRefreshDataListening(RefreshDataListening refreshDataListening) {
//          this.refreshDataListening = refreshDataListening;
//    }
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
    public void Loading() {

    }

    @Override
    public void outLogin() {

    }

    @Override
    public void succeed(TrainingPlanBean trainingPlanBean) {

    }

    @Override
    public void BtnScan() {

    }

    @Override
    public void BtnBack() {
finish();
    }

    private View getTabView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_tab_layout, null);
        TextView textView = (TextView) v.findViewById(R.id.tv_tab);
        ImageView imageView = (ImageView) v.findViewById(R.id.iv_tab);
        if (position == 0) {
            textView.setTextColor(getResources().getColor(R.color.blue));
            imageView.setImageResource(images_selector[position]);
        } else {
            textView.setTextColor(getResources().getColor(R.color.gray));
            imageView.setImageResource(images_normal[position]);
        }
        textView.setText(tabTitles[position]);
        return v;
    }

    @Override
    protected void onResume() {
        super.onResume();

        mViewPager.setCurrentItem(page);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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

            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == REFRESHID) {
            SimpleDateFormat   format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String date = format.format(new Date());
            mViewPager.setCurrentItem(2);
            if (!(weekFragment ==null))
                weekFragment.RefreshData(date);
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (firstLoad == 1) {
                    SimpleDateFormat   format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    String date = format.format(new Date());
                    if (!(monFragment ==null))
                        monFragment.RefreshData();
                    if (!(weekFragment ==null))
                        weekFragment.RefreshData(date);
                    if (!(dayFragment ==null))
                        dayFragment.RefreshData();
                    if (!(listFragment ==null))
                        listFragment.RefreshData();

                }
            }
        });
        }


//    }
}
