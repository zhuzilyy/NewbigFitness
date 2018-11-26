package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.CardInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard.TimeCardInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/*
*
*
* 会员卡列表
*
* */
public class CardListActivity extends BaseActivity<CardListPresenter> implements CardListContract.View {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sp_filter)
    Spinner spinner;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;

    private int filter = 0;
    private String memberId;
    private String[] mItems = {"全部", "未开卡", "已开卡", "已冻结", "已到期", "作废"};
    private String[] mItemsid = {"", "0", "1", "2", "3", "4"};
    private List<CardListBean.ResultBean> datas = new ArrayList<CardListBean.ResultBean>();
    private CommonAdapter<CardListBean.ResultBean> commonAdapter;

    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_cardlist;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("会员卡");
        // 获取会员ID
        Intent intent = getIntent();
        memberId = intent.getStringExtra("cardlist");

        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // spinner 选中事件
                filter = position;
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        loading();

        datas=new ArrayList<>();

        commonAdapter = new CommonAdapter<CardListBean.ResultBean>(R.layout.cardview_record_lesson_list, this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final CardListBean.ResultBean listBean, int i) {
                holder.setText(R.id.text_name_lesson, "会员卡号: " + listBean.getMemberCardNo());
                holder.setText(R.id.text_coach, listBean.getSTATUS());
                holder.setText(R.id.text_time_lesson, "卡类型: " + listBean.getConsumeType());
                holder.setText(R.id.text_remaining, "剩余可用值: " + listBean.getCardBalance());
                holder.getView(R.id.text_remaining).setVisibility(View.VISIBLE);
            }
        };

        commonAdapter.setListener(new CommonAdapter.OnItemClickListener<CardListBean.ResultBean>() {
            @Override
            public void onItemClick(CardListBean.ResultBean resultBean, int position) {
                Intent intent1;
                if (resultBean.getConsumeType().equals("次卡")) {
                    intent1 = new Intent(context, CardInfoActivity.class);
                } else {
                    intent1 = new Intent(context, TimeCardInfoActivity.class);
                }

                intent1.putExtra("cardinfo", resultBean.getMemberCardId());

                startActivity(intent1);
            }
        });


        commonAdapter.setShowFooter(false);

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
        Page++;
        getList();
    }

    private void refresh() {
        Page = 1;
        getList();
    }

    private void getList() {
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        mPresenter.getCardList(UserId, UserName,
                token,
                ClubId,
                memberId, mItemsid[filter]);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void succeed(CardListBean cardListBean) {
        swipeRefreshLayout.setRefreshing(false);
        try {
            datas = cardListBean.getResult();
            if (Page == 1) {
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

    }
}
