package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MultimediaBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.VideoPlayView.VideoPlayActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.MediaMetadata.getVideoThumbnail;
import static com.example.gufei.bigfitness.util.ToastUtil.s;


/**
 * Created by Administrator on 2017/8/4.
 * 图片及视频列表显示
 *
 */


public class ImgVideoListActivity extends BaseActivity<ImgVideoListActivityPresenter> implements ImgVideoListActivityContract.View {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;

    @BindView(R.id.swiperefreshlayoutid)

    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private CommonAdapter<MultimediaBean.ResultBean> commonAdapter;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;


    private List<MultimediaBean.ResultBean> datas = new ArrayList<MultimediaBean.ResultBean>();


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_activity_img_video;
    }

    @Override
    protected void initView() {

//        fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnTouchListener(this);

        datas = new ArrayList<>();
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar,"");
        tvTitle.setText("图片/视频");

        commonAdapter = new CommonAdapter<MultimediaBean.ResultBean>(R.layout.cardview_multimedia_list, this, datas) {
//        commonAdapter = new CommonAdapter<MultimediaBean.ResultBean>(R.layout.*appointm ent_main_cardview,this,  datas) {

            @Override
            protected void convert(final ViewHolder holder, final MultimediaBean.ResultBean listBean, final int i) {

                if (listBean.getResType() == 1) {

                    loadIntoUseFitWidth(context, listBean.getResURL(), R.mipmap.null_img, holder.setImage(R.id.av_view));


                } else {

//如果为视频资源 获取预览图
                    holder.setImage(R.id.av_view).setImageBitmap(getVideoThumbnail(listBean.getResURL()));


                }

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (listBean.getResType() == 1) {

                            Intent intent = new Intent(ImgVideoListActivity.this, ImageActivity.class);

                            intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", listBean.getResURL() + "");

                            startActivity(intent);

                        } else {

                            //// TODO: 2017/6/3  播放视频

                            Intent intent = new Intent(ImgVideoListActivity.this, VideoPlayActivity.class);

                            intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", listBean.getResURL() + "");

                            startActivity(intent);


                        }

                    }
                });


            }


        };


        recyclerView.setAdapter(commonAdapter);


//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);


        //解决列表左右位移的问题
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);


        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);

                //防止第一行到顶部有空白区域
                staggeredGridLayoutManager.invalidateSpanAssignments();
            }
        });

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);


        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

//                refresh();
//                mPresenter.get(0);

            }


        });

        swipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                swipeRefreshLayout.setRefreshing(true);
                commonAdapter.setShowFooter(false);

            }
        });


//        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
//
//
//            //获取列表华东监听器 用于获取当前所在条数
//            final StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();

        //添加滚动条见监听器
//            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//                @Override
//                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//
//                    super.onScrolled(recyclerView, dx, dy);
//
//                    //总记录条数
//                    //　int totalItemCount = linearLayoutManager.getItemCount();
//                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
//
//                    //最后条数的位置
////                    int lastVisubleItem = linearLayoutManager.findLastVisibleItemPosition();
//
//                    int[] lastItems = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
//
//                    int lastVisubleItem = Math.max(lastItems[0], lastItems[1]);
//
//
//                    System.out.println("----------~~>" + dy + "");
//
////                    if (isLoadingMore && totalItemCount - 20 <= lastVisubleItem && dy > 0) {
////
////                        loading();
////
////                    }
//                }
//            });
//
//        }
    }

    @Override
    protected void initData() {


        int userId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        mPresenter.getMyUserTeacherResList(userId, token);


    }

    @Override
    public void succeed(MultimediaBean multimediaBean) {

        swipeRefreshLayout.setRefreshing(false);

        datas = multimediaBean.getResult();

        commonAdapter.replaceData(datas);

//        Log.e("","");
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
