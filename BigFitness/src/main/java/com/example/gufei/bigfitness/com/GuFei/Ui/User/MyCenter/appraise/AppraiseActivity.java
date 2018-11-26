package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.StarEvaluateBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.ToastUtil.s;
/**
 * Created by Administrator on 2017/8/4.
 * 评价页面
 */

public class AppraiseActivity extends BaseActivity<AppraiseActivityPresenter> implements AppraiseActivityContract.View {


    @BindView(R.id.five_star_btn)
    LinearLayout fiveStarBtn;
    @BindView(R.id.four_star_btn)
    LinearLayout fourStarBtn;
    @BindView(R.id.three_star_btn)
    LinearLayout threeStarBtn;
    @BindView(R.id.two_star_btn)
    LinearLayout twoStarBtn;
    @BindView(R.id.one_star_btn)
    LinearLayout oneStarBtn;
    @BindView(R.id.content_text)
    TextView contentText;
    @BindView(R.id.show_all_btn)
    TextView showAllBtn;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;
    private int mItemType = 5;
    private int page = 0;
    //    @BindView(R.id.activity_address_details)
//    LinearLayout activityAddressDetails;
    private boolean isLoadingMore = true;//加载标志位

    private CommonAdapter<StarEvaluateBean.ResultBean> commonAdapter;


    private List<StarEvaluateBean.ResultBean> datas = new ArrayList<StarEvaluateBean.ResultBean>();


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_appraise;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("评价");

//        if (searchView != null) {
//            try {        //--拿到字节码
//                Class<?> argClass = searchView.getClass();
//                //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
//                Field ownField = argClass.getDeclaredField("mSearchPlate");
//                //--暴力反射,只有暴力反射才能拿到私有属性
//                ownField.setAccessible(true);
//                View mView = (View) ownField.get(searchView);
//                //--设置背景
//                mView.setBackgroundColor(Color.TRANSPARENT);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<StarEvaluateBean.ResultBean>(R.layout.cardview_appraise_list, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final StarEvaluateBean.ResultBean listBean, final int i) {

//             holder.setImage(R.id.five_star_btn).setImageResource(context.getResources().getIdentifier("evaluate_"+String.valueOf(mItemType), "mipmap", context.getPackageName()));


                try {
                    holder.setImage(R.id.id_start_img).setImageResource(R.mipmap.class.getDeclaredField("evaluate_" + String.valueOf(mItemType)).getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                holder.setImage(R.id.five_star_btn).setImageResource(context.getResources().getIdentifier("evaluate_" + String.valueOf(mItemType), "mipmap", context.getPackageName()));


                holder.setText(R.id.id_user_name, "留言者" + listBean.getMemberName() + "于" + listBean.getCreateTime());//名称

                holder.setText(R.id.id_content, "内容：" + listBean.getEvaluateContent());//内容

//                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.nullimg, holder.setImage(R.id.head_img));//头像
                displayCircleImage(context, listBean.getHeaderURL(), holder.setImage(R.id.head_img), R.mipmap.nullimg);//头像

            }


        };


        recyclerView.setAdapter(commonAdapter);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);


        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                refresh();

            }


        });

        swipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                swipeRefreshLayout.setRefreshing(true);
                commonAdapter.setShowFooter(false);
            }
        });


        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {


            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            //添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    super.onScrolled(recyclerView, dx, dy);

                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;

                    //最后条数的位置
                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();


                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {

                        isLoadingMore = false;

                        loading();

                    }
                }
            });

        }

    }

    private void loading() {


    }

    @Override
    protected void initData() {
        refresh();
    }

    @Override
    public void succeed(StarEvaluateBean starEvaluateBean) {

        swipeRefreshLayout.setRefreshing(false);


        starEvaluateBean.getStarCount().getOneStarCount();

        switch (mItemType) {
            case 5:
                contentText.setText("(5星) 共:" + starEvaluateBean.getStarCount().getFiveStarCount());
                break;
            case 4:
                contentText.setText("(4星) 共:" + starEvaluateBean.getStarCount().getFourStarCount());
                break;
            case 3:
                contentText.setText("(3星) 共:" + starEvaluateBean.getStarCount().getThreeStarCount());
                break;
            case 2:
                contentText.setText("(2星) 共:" + starEvaluateBean.getStarCount().getTwoStarCount());
                break;
            case 1:
                contentText.setText("(1星) 共:" + starEvaluateBean.getStarCount().getOneStarCount());
                break;

          }
        TextView tv1 = (TextView) id(R.id.text_star_1);
        TextView tv2 = (TextView) id(R.id.text_star_2);
        TextView tv3 = (TextView) id(R.id.text_star_3);
        TextView tv4 = (TextView) id(R.id.text_star_4);
        TextView tv5 = (TextView) id(R.id.text_star_5);
        tv1.setText(starEvaluateBean.getStarCount().getOneStarCount() + "人");
        tv2.setText(starEvaluateBean.getStarCount().getTwoStarCount() + "人");
        tv3.setText(starEvaluateBean.getStarCount().getThreeStarCount() + "人");
        tv4.setText(starEvaluateBean.getStarCount().getFourStarCount() + "人");
        tv5.setText(starEvaluateBean.getStarCount().getFiveStarCount() + "人");


        try {

            datas = starEvaluateBean.getResult();

            if (page == 1) {

                commonAdapter.replaceData(datas);


            } else {

                commonAdapter.insertData(datas);
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

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

        page++;

        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        mPresenter.getMyStarEvaluate(userid, token, page, mItemType == 99 ? "" : String.valueOf(mItemType));

    }


    @OnClick({R.id.five_star_btn, R.id.four_star_btn, R.id.three_star_btn, R.id.two_star_btn, R.id.one_star_btn, R.id.show_all_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.five_star_btn:
                onShowContentList(5);
                break;
            case R.id.four_star_btn:
                onShowContentList(4);
                break;
            case R.id.three_star_btn:
                onShowContentList(3);
                break;
            case R.id.two_star_btn:
                onShowContentList(2);
                break;
            case R.id.one_star_btn:
                onShowContentList(1);
                break;
            case R.id.show_all_btn:

                if (showAllBtn.getText().toString().equals("显示所有评论")) {

                    showAllBtn.setText("所有评论");

                    mItemType = 99;

                    showAllBtn.setTextColor(getResources().getColor(R.color.all_back_color));

                    contentText.setText("");

//                    Toast.makeText(AppraiseActivity.this, "这是显示全部", Toast.LENGTH_SHORT).show();

                    refresh();

//                showAllBtn.setEnabled(false);
                }

                break;
        }
    }

    private void onShowContentList(int num) {

//        contentText.setText(String.format("(%s星），共"));


        mItemType = num;

        showAllBtn.setText("显示所有评论");

        showAllBtn.setTextColor(getResources().getColor(R.color.green_btn));

        showAllBtn.setEnabled(true);

        refresh();

    }

    public void refresh() {

        page = 1;

        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        mPresenter.getMyStarEvaluate(userid, token, page, mItemType == 99 ? "" : String.valueOf(mItemType));
    }


}
