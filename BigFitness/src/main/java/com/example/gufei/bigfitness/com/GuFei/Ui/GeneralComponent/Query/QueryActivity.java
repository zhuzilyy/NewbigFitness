package com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.ToastUtil.s;
/**
 * Created by Administrator on 2017/8/4.
 * 筛选页面
 */
public class QueryActivity extends BaseActivity<QueryActivityPresenter> implements QueryActivityContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;


    private int ItemSelected = 0;

    private CommonAdapter<MessageslistBean.ResultBean> commonAdapter;


    private List<MessageslistBean.ResultBean> datas = new ArrayList<MessageslistBean.ResultBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_query;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        if (searchView != null) {
            try {
                //--拿到字节码
                Class<?> argClass = searchView.getClass();
                //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
                Field ownField = argClass.getDeclaredField("mSearchPlate");
                //--暴力反射,只有暴力反射才能拿到私有属性
                ownField.setAccessible(true);
                View mView = (View) ownField.get(searchView);
                //--设置背景
                mView.setBackgroundColor(Color.TRANSPARENT);


                int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
                TextView textView = (TextView) searchView.findViewById(id);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.bottomMargin = -6;
                textView.setLayoutParams(layoutParams);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        Spinner spinner=(Spinner)id(R.id.id_type_spinner) ;
//
//         List<String>   data_list = new ArrayList<String>();
//        data_list.add("北京");
//        data_list.add("上海");
//        data_list.add("广州");
//        data_list.add("深圳");
//
//        //适配器
//        ArrayAdapter<String>    arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
//        //设置样式
//        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //加载适配器
//        spinner.setAdapter(arr_adapter);




        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<MessageslistBean.ResultBean>(R.layout.item_edit_pop,this,  datas) {



            @Override
            protected void convert(final ViewHolder holder, final MessageslistBean.ResultBean listBean, final int i) {

//                holder.setText(R.id.content_text,listBean.getUsername());
//                if (i == ItemSelected) {
//                    holder.getView(R.id.selected_btn).setVisibility(View.VISIBLE);
//                } else {
//                    holder.getView(R.id.selected_btn).setVisibility(View.INVISIBLE);
//                }
//
//                holder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        ItemSelected = i;
//
//                        notifyDataSetChanged();
//
//
//                    }
//                });


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


//                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
//
//                        isLoadingMore = false;
//
//                        loading();
//
//                    }
                }
            });

        }


    }

    public void refresh() {

        int type = 0;

//        switch (titletext.getText().toString()){
//            case "通知":
//                type=1;
//                break;
//            case "预约通知":
//                type=2;
//                break;
//            case "系统通知":
//                type=3;
//                break;
//            case "到期通知":
//                type=4;
//                break;
//            case "变更通知":
//                type=5;
//                break;
//            case "会员生日通知":
//                type=6;
//                break;
//
//        }

        mPresenter.updata(type);


    }

    @Override
    protected void initData() {

        refresh();

    }

    @Override
    public void succeed(MessageslistBean messageslistBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {

            datas = messageslistBean.getResult();

            commonAdapter.replaceData(datas);



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


    @OnClick(R.id.btn_complete)
    public void onViewClicked() {

        Intent intent = QueryActivity.this.getIntent();
        Bundle bundle = intent.getExtras();
//        bundle.putString("aaa", datas.get(ItemSelected).getUsername());//添加要返回给主页面的数据
        intent.putExtras(bundle);
        QueryActivity.this.setResult(Activity.RESULT_OK, intent);//返回主页面
        QueryActivity.this.finish();


    }



}
