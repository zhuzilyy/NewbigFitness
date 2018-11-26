package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details.PublicSeaInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SoftKeyBoardListener;
import com.example.gufei.bigfitness.util.SpUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class PublicSeaSearchListActivity extends BaseActivity<PublicSeaSearchListPresenter> implements PublicSeaSearchListContract.View {

    /*    @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.searchView)
        SearchView searchView;*/
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_complete)
    Button btnComplete;

    private int page = 0;
    private int layoutId = 0;
    private String mTypeName = "";
    private String mquery;
    PostCustomerListBean mPostCustomerListBean;
    private boolean isLoadingMore = true;//加载标志位
    private CommonAdapter<PublicSeaBean.ResultBean> commonAdapter;
    private List<PublicSeaBean.ResultBean> datas = new ArrayList<PublicSeaBean.ResultBean>();
    private CommonAdapter<PublicSeaMemberBean.ResultBean> commonMemberAdapter;
    private List<PublicSeaMemberBean.ResultBean> memberdatas = new ArrayList<>();
    int type;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_publicseasearchlis;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        searchView . setIconified ( false ) ;
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Log.e("ssssss","false");
                return false;
            }
        });
        searchView.clearFocus();
        setToolBar(toolbar, "");
        if (searchView != null) {
            try {        //--拿到字节码
                Class<?> argClass = searchView.getClass();

                //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
                Field ownField = argClass.getDeclaredField("mSearchPlate");

                //--暴力反射,只有暴力反射才能拿到私有属性
                ownField.setAccessible(true);

                View mView = (View) ownField.get(searchView);

                //--设置背景
                mView.setBackgroundColor(Color.TRANSPARENT);

            } catch (Exception e) {

                e.printStackTrace();

            }
        }


        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);

        TextView textView = (TextView) searchView.findViewById(id);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();

        layoutParams.bottomMargin = -8;

        textView.setLayoutParams(layoutParams);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                final String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                final String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                final int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                // 点击搜索事件
                mquery = query;
                getList();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


      /*  //设置显示提交按钮
        searchView.setSubmitButtonEnabled(false);
        //拿到提交图标的imageview,
//        ImageView iv_submit = (ImageView) searchView.findViewById(R.id.search_go_btn);
        ImageView iv_submit = (ImageView) searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/search_go_btn", null, null));
        //这样就可以修改图片了
        iv_submit.setVisibility(View.GONE);*/
//        iv_submit.setImageResource(null);
//        MenuItem search=menu.findItem(R.id.search);//自定义样式
//        search.collapseActionView();
//        SearchView searchview=(SearchView) search.getActionView();


        layoutId = R.layout.pop_view_customer_screening;


        mPostCustomerListBean = new PostCustomerListBean();
        Intent intent = getIntent();
        type = intent.getIntExtra("search", 1);

        if (type == 0) {
            mTypeName = "客户  ";
        } else {
            mTypeName = "会员  ";
        }

        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<PublicSeaBean.ResultBean>(R.layout.cardview_publicsea_list, this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final PublicSeaBean.ResultBean listBean, final int i) {
                holder.setText(R.id.id_user_name, mTypeName + listBean.getCustomerName());
                holder.setText(R.id.id_time, "抛入时间:" + listBean.getInPublicSeaTime());
                if (listBean.getSex() != null) {
                    if (listBean.getSex().equals("男")) {
                        holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_men);
                    } else {
                        holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_women);
                    }
                }
                holder.setText(R.id.text_publicsea_type, listBean.getPublicSeaName());
            }
        };

        commonAdapter.setListener(new CommonAdapter.OnItemClickListener<PublicSeaBean.ResultBean>() {
            @Override
            public void onItemClick(PublicSeaBean.ResultBean resultBean, int position) {
                PublicSeaInfoActivity.startWebActivity(PublicSeaSearchListActivity.this, resultBean.getCustomerId() + "", resultBean.getCustomerName() + "", "","客户");

            }
        });




        commonMemberAdapter = new CommonAdapter<PublicSeaMemberBean.ResultBean>(R.layout.cardview_publicsea_member_list, this, memberdatas) {
            @Override
            protected void convert(final ViewHolder holder, final PublicSeaMemberBean.ResultBean listBean, final int i) {
                holder.setText(R.id.id_user_name, mTypeName + listBean.getMemberName());
                holder.setText(R.id.id_time, "抛入时间:" + listBean.getAbandonTime());

                if (listBean.getSex() != null) {
                    if (listBean.getSex().equals("男")) {
                        holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_men);
                    } else {
                        holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_women);
                    }
                }
//                holder.setText(R.id.text_publicsea_type, listBean.getPublicSeaName());
                holder.getView(R.id.text_publicsea_type).setVisibility(View.GONE);
//                ImageView imageView = holder.getView(R.id.img_header);
                displayCircleImage(context, listBean.getHeaderURL(), (ImageView) holder.getView(R.id.img_header), R.mipmap.head_img);
//                Glide.with(context)
//                        .load(Constants.BASEURL + listBean.getHeaderURL())// 加载图片
//                        .crossFade()// 淡出效果
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存
//                        .into(imageView);
            }
        };

        if (type == 0) {
            recyclerView.setAdapter(commonAdapter);
        } else {
            recyclerView.setAdapter(commonMemberAdapter);
        }
        commonAdapter.setShowFooter(false);
        commonMemberAdapter.setShowFooter(false);
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
                swipeRefreshLayout.setRefreshing(false);
                commonAdapter.setShowFooter(false);
                commonMemberAdapter.setShowFooter(false);
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


        SoftKeyBoardListener.setListener(PublicSeaSearchListActivity.this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
//                Toast.makeText(PublicSeaSearchListActivity.this, "键盘显示 高度" + height, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void keyBoardHide(int height) {
                searchView.clearFocus();
//                Toast.makeText(CustomerListActivity.this, "键盘隐藏 高度" + height, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void succeed(PublicSeaBean publicSeaBean) {
        swipeRefreshLayout.setRefreshing(false);
        recyclerView.setAdapter(commonAdapter);

        try {
            datas = publicSeaBean.getResult();
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
    public void membersucceed(PublicSeaMemberBean publicSeaBean) {

        swipeRefreshLayout.setRefreshing(false);
        recyclerView.setAdapter(commonMemberAdapter);
        try {
            memberdatas = publicSeaBean.getResult();
            //if (page == 1) {
            commonMemberAdapter.replaceData(memberdatas);
            //} else {
            //    commonMemberAdapter.insertData(memberdatas);
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loading() {
        page++;
        getList();
    }

    public void refresh() {
        page = 1;
        getList();
    }

    public void getList() {
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        if (type == 1) {
            mPresenter.appPublicSeaMemberList(UserName,
                    UserId,
                    token,
                    ClubId, page, "", "", "", "", "", mquery);
        } else {
            mPresenter.appPublicSeaCustomerList(UserName,
                    UserId,
                    token,
                    ClubId, page, "", "", "", "", "", mquery);
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



    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        refresh();
    }
}
