package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberwardrobeListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details.CourseDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class CourseListActivity extends BaseActivity<CourseListActivityPresenter> implements CourseListActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.spinner_select)
    Spinner spinnerSelect;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;

    private int itemLayoutId;

    private String[] spinnerArr;

    private String Type;

    private String mId;

    private String Status = "";


    private ArrayAdapter adapter = null;

    private SimpleAdapter simpleAdapter = null;


    private CommonAdapter<MemberwardrobeListBean.ResultBean> commonAdapter;


    private List<MemberwardrobeListBean.ResultBean> datas = new ArrayList<MemberwardrobeListBean.ResultBean>();


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_course_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");

        Intent intent = getIntent();
//        CustomerName = intent.getStringExtra(PUT_STR + "Name");
//        CustomerType = intent.getStringExtra(PUT_STR + "Type");
//        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        mId = intent.getStringExtra(PUT_STR + "Id");
        Type = intent.getStringExtra(PUT_STR + "Type");

        tvTitle.setText(Type);

        switch (Type) {


            case ("课程"):

                spinnerArr = this.getResources().getStringArray(R.array.CardSpingArr);

                itemLayoutId = android.R.layout.simple_spinner_dropdown_item;

                break;

            case ("衣柜"):

                spinnerArr = this.getResources().getStringArray(R.array.CabinetSpingArr);

                itemLayoutId = android.R.layout.simple_spinner_dropdown_item;

                break;
            case ("会员卡"):

                spinnerArr = this.getResources().getStringArray(R.array.CardSpingArr);

                itemLayoutId = android.R.layout.simple_spinner_dropdown_item;

                break;


        }

        spinnerSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0) {

                    Status = String.valueOf(position - 1);

                } else {


                    Status = "";
                }


                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

//                Status="";

            }
        });


        adapter = new ArrayAdapter(this, R.layout.spinnerlayout, spinnerArr);

        adapter.setDropDownViewResource(itemLayoutId);
//
//        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
//                new String[] {"pic", "text"}, new int[]{R.id.id_image, R.id.id_text1});


        spinnerSelect.setAdapter(adapter);

//        spinnerSelect.setOnItemSelectedListener(CourseListActivity.this);

        spinnerSelect.setDropDownVerticalOffset(60);

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<MemberwardrobeListBean.ResultBean>(R.layout.cardview_course_list, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final MemberwardrobeListBean.ResultBean listBean, final int i) {

                if (!Type.equals("课程")) {

                    holder.setText(R.id.text_title, "衣柜编号:  " + listBean.getWardrobeNo());//

//
                    holder.setText(R.id.text_type, listBean.getStatus());//
//
                    holder.setText(R.id.text_content, "可用值:  " + listBean.getWardrobeBalance());//
//
                    holder.setText(R.id.text_time, "");//
//t
//                loadIntoUseFitWidth(context, listBean.getImg(), R.mipmap.nullimg, holder.setImage(R.id.head_img));//头像

                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(CourseListActivity.this, CourseDetailsActivity.class);
                            intent.putExtra(PUT_STR + "Id", mId);
                            intent.putExtra(PUT_STR + "WardrobeId", listBean.getWardrobeId());
                            startActivity(intent);
                        }
                    });

                }else{



                    holder.setText(R.id.text_title,listBean.getWardrobeNo());//
                    holder.setText(R.id.text_type, listBean.getStatus());//
                    holder.setText(R.id.text_content, listBean.getWardrobeBalance());//
                    holder.setText(R.id.text_time,listBean.getOther() );//
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


//                            Intent intent = new Intent(CourseListActivity.this, CourseDetailsActivity.class);
//
//                            intent.putExtra(PUT_STR + "Id", mId);
//
//                            intent.putExtra(PUT_STR + "WardrobeId", listBean.getWardrobeId());
//
//                            startActivity(intent);


                        }
                    });



                }
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


    @Override
    protected void initData() {
        refresh();
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
    public void Loading() {

    }


    @Override
    public void succeed(MemberwardrobeListBean memberwardrobeListBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {

            datas = memberwardrobeListBean.getResult();

            commonAdapter.replaceData(datas);


        } catch (Exception e) {

            e.printStackTrace();

        }


    }


    @Override
    public void succeedLessonListForMember(LessonListForMemberBean lessonListForMemberBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {



            for(int i=0; i<lessonListForMemberBean.getResult().size();i++){

//                MemberwardrobeListBean.ResultBean bean=new MemberwardrobeListBean.ResultBean();
//
//                bean.setWardrobeNo( "课程种类:  "+String.valueOf(lessonListForMemberBean.getResult().get(i).getLessonType()));
//                bean.setStatus(String.valueOf(lessonListForMemberBean.getResult().get(i).getStatus()));
//                bean.setWardrobeBalance( "剩余节数:  "+String.valueOf(lessonListForMemberBean.getResult().get(i).getRemainCount()));
//                bean.setOther("课程名称:   "+String.valueOf(lessonListForMemberBean.getResult().get(i).getLessonName()));
////                bean.set(String.valueOf(lessonListForMemberBean.getResult().get(i).getLessonId()));


//                datas.add(bean);
            }

            commonAdapter.replaceData(datas);


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void refresh() {

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        switch (Type) {


            case ("课程"):

//                mPresenter.getLessonListForMember(UserId, token, ClubId, mId);
                break;

            case ("衣柜"):

                mPresenter.getMemberwardrobeList(UserId, token, ClubId, mId, Status);

                break;
            case ("会员卡"):


                break;


        }

//        mPresenter.get(Type);


    }


}

