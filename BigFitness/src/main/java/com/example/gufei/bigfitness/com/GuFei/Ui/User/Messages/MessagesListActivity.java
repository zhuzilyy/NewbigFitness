package com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PushUserMessageInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.LOGINKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 系统通知
 */


public class MessagesListActivity extends BaseActivity<MessagesListActivityPresenter> implements MessagesListActivityContract.View {
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.spinner_select)
    Spinner spinnerSelect;
    @BindView(R.id.titletext)
    TextView titletext;
    @BindView(R.id.ScanImg)
    ImageView ScanImg;
    @BindView(R.id.main_head_layout)
    RelativeLayout mainHeadLayout;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;

    private CommonAdapter<MessageslistBean.ResultBean> commonAdapter;

    private boolean isLoadingMore = false;//加载标志位
    private List<MessageslistBean.ResultBean> datas = new ArrayList<MessageslistBean.ResultBean>();
    private int page = 0;
    private View view;
    private ArrayAdapter adapter = null;
    private String[] spinnerArr;
    private int userid;
    private String token;
    private int clubid;
    private String MsgTypeId;
    private String getDataTag;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_activity_messages;
    }

    @Override
    protected void initView() {

        ScanImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        Intent intent = getIntent();


        final String s = intent.getStringExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.title");


        userid = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        titletext.setText(s);


        switch (titletext.getText().toString()) {
            case "系统通知":
                MsgTypeId = "1";
                break;
            case "到期通知":
                MsgTypeId = "2";
                break;
            case "签到通知":
                MsgTypeId = "3";
                break;
            case "预约通知":
                MsgTypeId = "4";
                break;
            case "变更通知":
                MsgTypeId = "5";
                break;
            case "会员生日通知":
                MsgTypeId = "6";
                break;

        }


        spinnerArr = this.getResources().getStringArray(R.array.MsgSpingArr);

        spinnerSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        break;
                    case 1:
                        mPresenter.updateAllPushUserMessageReadType(userid, token, clubid, MsgTypeId);
                        break;
                    case 2:
                        mPresenter.delAllPushUserMessageRead(userid, token, clubid, MsgTypeId);
                        break;

                }
                //refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

//                Status="";

            }
        });


        adapter = new ArrayAdapter(this, R.layout.spinnerlayout, spinnerArr);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
//                new String[] {"pic", "text"}, new int[]{R.id.id_image, R.id.id_text1});


        spinnerSelect.setAdapter(adapter);

//        spinnerSelect.setOnItemSelectedListener(CourseListActivity.this);

        spinnerSelect.setDropDownVerticalOffset(60);


        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<MessageslistBean.ResultBean>(R.layout.cardview_messgaes_list, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final MessageslistBean.ResultBean listBean, final int i) {
                holder.setText(R.id.id_user_name, listBean.getTitle());//名称

                holder.setText(R.id.id_time, listBean.getCreateTime());//操作时间

                holder.setText(R.id.id_content, listBean.getUserName());//内容

                if (listBean.getIsRead() == 0) {
                    holder.setText(R.id.hint_num, "");//提示数字
                    holder.getView(R.id.hint_num).setVisibility(View.VISIBLE);
                } else {
                    holder.getView(R.id.hint_num).setVisibility(View.GONE);
                }
                holder.getView(R.id.head_img).setVisibility(View.GONE);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        view = v;
                        holder.getView(R.id.hint_num).setVisibility(View.GONE);
                        mPresenter.getPushUserMessageInfo(userid, token, clubid, listBean.getMessageId());
                    }
                });

            }


        }

        ;


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
                datas.clear();
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

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager)

        {


            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            //添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    isLoadingMore = true;
                    //加载更多数据
                    getDataTag = "loadMore";
                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
                    //最后条数的位置
                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
                        Loading();
                    }
                }
            });

        }
      /*  int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
        //最后条数的位置
        int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
        if (dy > 0) {
            if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem) {
                if (tvTitle.getText().toString().equals("预约记录")) {
                    isLoadingMore = false;
                    UpDownMark = "down";
                    DownPage++;
                    IsHistory = 0;
                    UpDownLoading();
                } else {
                    isLoadingMore = false;
                    UpDownMark = "down";
                    DownPage++;
                    IsHistory = 1;
                    UpDownLoading();
                }
            }
        }*/

    }

    private void loading() {

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
        page++;
        mPresenter.getPushUserMessageList(userid, token, clubid, page, MsgTypeId);
    }

    @Override
    public void succeed(MessageslistBean messageslistBean) {
        swipeRefreshLayout.setRefreshing(false);
        try {
            datas = messageslistBean.getResult();
            if (datas.size() == 0 && page == 1) {
                tvNoMore.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setVisibility(View.GONE);
            } else {
                tvNoMore.setVisibility(View.GONE);
                swipeRefreshLayout.setVisibility(View.VISIBLE);
                if (getDataTag.equals("loadMore")) {
                    commonAdapter.insertData(datas);
                } else if (getDataTag.equals("refresh")) {
                    commonAdapter.replaceData(datas);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AllReadsucceed(CodeBean CodeBean) {
        s(this, "成功设置全部已读");
        refresh();
    }

    @Override
    public void AllDelsucceed(CodeBean codeBean) {
        s(this, "成功删除全部已读");
        refresh();
    }

    public void refresh() {
        Log.i("tag","=====1111==========");
        datas.clear();
        getDataTag = "refresh";
        page = 1;
        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        mPresenter.getPushUserMessageList(userid, token, clubid, page, MsgTypeId);

  /*      switch (titletext.getText().toString()) {
            case "通知":
                type = 1;
                break;
            case "预约通知":
                type = 2;
                break;
            case "系统通知":
                type = 3;



                break;
            case "到期通知":
                type = 4;
                break;
            case "变更通知":
                type = 5;
                break;
            case "会员生日通知":
                type = 6;
                break;
*/
//        }
//

    }


    @Override
    public void Infosucceed(PushUserMessageInfoBean pushUserMessageInfoBean) {
        noticePopup(view, pushUserMessageInfoBean);
    }

    public void noticePopup(View v, final PushUserMessageInfoBean pushUserMessageInfoBean) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_notice, null);
        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        ImageView headImg = (ImageView) contentView.findViewById(R.id.head_img);
//        headImg.setVisibility(View.INVISIBLE);
        TextView textTopTitle = (TextView) contentView.findViewById(R.id.text_top_title);
        textTopTitle.setText(titletext.getText().toString());

        TextView titleNameText = (TextView) contentView.findViewById(R.id.title_name_text);
        titleNameText.setText(pushUserMessageInfoBean.getResult().getTitle());


        TextView titleNameTime = (TextView) contentView.findViewById(R.id.title_name_time);
        titleNameTime.setVisibility(View.GONE);

        TextView textTime = (TextView) contentView.findViewById(R.id.text_time);
        textTime.setVisibility(View.GONE);

        TextView NameText = (TextView) contentView.findViewById(R.id.name_text);
        NameText.setText(pushUserMessageInfoBean.getResult().getUserName());
        NameText.setVisibility(View.GONE);
        TextView textContent = (TextView) contentView.findViewById(R.id.text_content);
        textContent.setText(pushUserMessageInfoBean.getResult().getContent());

        final Button button = (Button) contentView.findViewById(R.id.button);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });


                return false;


                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        backgroundAlpha(0.5f);
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }


    @OnClick()
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

