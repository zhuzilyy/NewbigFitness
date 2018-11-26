package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.Constants;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details.PublicSeaInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist.PublicSeaSearchListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_CUSTOMER;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_MEMBERS;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_NON_CUSTOMER;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_PRIVATE_MEMBERS;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEID;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUBLIC_SEA_MEMBERS_ORDER_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.PUBLIC_SEA_ORDER_DATAS;
import static com.example.gufei.bigfitness.Constants.PUBLIC_SEA_ORDER_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.ListUtil.Arr2List;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.toidstring;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class PublicSeaListActivity extends BaseActivity<PublicSeaListPresenter> implements PublicSeaListContract.View, SpinnerPopContract {

    @BindView(R.id.sorting_btn)
    RelativeLayout sortingBtn;
    @BindView(R.id.screening_btn)
    RelativeLayout screeningBtn;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.sp_title)
    Spinner title;
    @BindView(R.id.btn_edit)
    Button BtnEdit;
    @BindView(R.id.img_search)
    ImageView search;

    @BindView(R.id.layout_keep_out)
    RelativeLayout layoutKeep0ut;
    @BindView(R.id.sorting_img)
    ImageView sortingImg;
    @BindView(R.id.screening_img)
    ImageView screeningImg;
    @BindView(R.id.sorting_text)
    TextView sortingText;
    @BindView(R.id.no_rank_screen_layout)
    LinearLayout noRankScreenLayout;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.btn_gain_publicsea)
    TextView btnGainPublicsea;

    @BindView(R.id.btn_Change_publicStype)
    TextView btnChangePublicStype;
    @BindView(R.id.btn_Change_OwnManager)
    TextView btnChangeOwnManager;
    @BindView(R.id.btn_Change_coachLesson)
    TextView btnChangeCoachLesson;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.layout_edit_bottom)
    RelativeLayout layoutEditBottom;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.btn_selected_all)
    CheckBox btnSelectedAll;
    @BindView(R.id.layout_alpha)
    LinearLayout layoutAlpha;
    private int page = 0;
    private int layoutId = 0;
    private String mTypeName = "";

    //编辑标识
    private boolean editShow = false;

    //全选标识
    private boolean selectAll = false;

    private List<String> mSelectdatas = new ArrayList<String>();

    private List<FilterBean.FilterListBean> arrModel = new ArrayList<FilterBean.FilterListBean>();


    PostCustomerListBean mPostCustomerListBean;
    private boolean isLoadingMore = true;//加载标志位
    private CommonAdapter<PublicSeaBean.ResultBean> commonAdapter;
    private CommonAdapter<PublicSeaMemberBean.ResultBean> commonMemberAdapter;
    private List<PublicSeaBean.ResultBean> datas = new ArrayList<PublicSeaBean.ResultBean>();
    private List<PublicSeaMemberBean.ResultBean> memberdatas = new ArrayList<>();
    private SpinnerAdapter spinnerAdapter = new SpinnerAdapter();
    private SpinnerPopupWindow s;
    //筛选显示标识
    private boolean sortingShow = true;
    //筛选点击标识
    private boolean ItmeOnClick = true;
    //筛选首次运行标识
    private boolean firstSortingShow = true;
    //查找显示标识
    private boolean screeningShow = true;
    private List<String> mDatas;
    private List<String> mInterfaceDatas;
    private List<Integer> mSelectedArr;
    private int mSelectedCount = 0;
    private View contentView;
    private PopupWindow popupWindow;
    private int type;
    private int mtype = 0;
    int IsDepartManager;
    private TimePickerView pvCustomTime;
    private String[] mItems = {"公海客户列表"};
    private String[] mItems1 = {"公海会员列表"};
    private boolean mTouch = true;
    String Cause;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_publicsealist;
    }

    @Override
    protected void initView() {
        layoutAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutAlpha.setVisibility(View.GONE);
                if (s != null) s.dismissPopWindow();
                mTouch = true;
            }
        });
        mPostCustomerListBean = new PostCustomerListBean();
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        Intent intent = getIntent();
        type = intent.getIntExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", 0);
        mPostCustomerListBean.setPublicSeaId("0");
        String persontype = String.valueOf(SpUtil.get(mContext, PERSONTYPEKEY, ""));
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        if (persontype.equals("会籍")) {
            mtype = 0;
            mTypeName = " 客户";
        } else {
            mItems = mItems1;
            mtype = 1;
            mTypeName = " 会员";
            btnGainPublicsea.setVisibility(View.GONE);
            if (IsDepartManager == 1) {
                BtnEdit.setVisibility(View.VISIBLE);
                btnChangeCoachLesson.setVisibility(View.VISIBLE);
            }

        }


        layoutId = R.layout.pop_view_customer_screening;
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<PublicSeaBean.ResultBean>(R.layout.cardview_publicsea_list, this, datas) {

            @Override
            protected void convert(final ViewHolder holder, final PublicSeaBean.ResultBean listBean, final int i) {


                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.getView(R.id.layout_content).getLayoutParams();

                layoutParams.width = App.SCREEN_WIDTH - 10;

                holder.getView(R.id.layout_content).setLayoutParams(layoutParams);

                CheckBox checkBox = holder.getView(R.id.CheckBox_selset);

                if (editShow) {

                    checkBox.setVisibility(View.VISIBLE);

                } else {

                    checkBox.setVisibility(View.GONE);

                }
                if (selectAll) {


                    checkBox.setChecked(true);


                } else {

                    checkBox.setChecked(false);

                }

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {

                            Log.e("ss",datas.get(i).getCustomerId()+"") ;
                            mSelectdatas.set(i, datas.get(i).getCustomerId()+"");
//                            mSelectdatas.set(i, String.valueOf(datas.get(i).getCustomerId()));
                        } else {
                            mSelectdatas.set(i, "0");
                        }

                    }
                });


                holder.setText(R.id.id_user_name, mTypeName + " " + listBean.getCustomerName());
//                if (!listBean.getInPublicSeaTime().equals("")) {
//                }
                holder.setText(R.id.id_time, "抛入时间   " + listBean.getInPublicSeaTime());
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
//                if (false) {

                if (!mTouch)
                    return;
                PublicSeaInfoActivity.startWebActivity(PublicSeaListActivity.this, resultBean.getCustomerId() + "", resultBean.getCustomerName() + "", resultBean.getSex() + "", "客户");
//                }
            }
        });

        commonMemberAdapter = new CommonAdapter<PublicSeaMemberBean.ResultBean>(R.layout.cardview_publicsea_member_list, this, memberdatas) {
            @Override
            protected void convert(final ViewHolder holder, final PublicSeaMemberBean.ResultBean listBean, final int i) {
                holder.setText(R.id.id_user_name, mTypeName + " " + listBean.getMemberName());
                holder.setText(R.id.id_time, "抛入时间:" + listBean.getAbandonTime());

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.getView(R.id.layout_content).getLayoutParams();

                layoutParams.width = App.SCREEN_WIDTH - 10;

                holder.getView(R.id.layout_content).setLayoutParams(layoutParams);

                CheckBox checkBox = holder.getView(R.id.CheckBox_selset);

                if (editShow) {
                    checkBox.setVisibility(View.VISIBLE);
                } else {
                    checkBox.setVisibility(View.GONE);
                }
                if (selectAll) {


                    checkBox.setChecked(true);


                } else {

                    checkBox.setChecked(false);

                }

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {

                            mSelectdatas.set(i, String.valueOf(memberdatas.get(i).getMemberId()));

                        } else {
                            mSelectdatas.set(i, "0");
                        }

                    }
                });


                if (listBean.getSex() != null) {
                    if (listBean.getSex().equals("男")) {
                        holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_men);
                    } else {
                        holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_women);
                    }
                }
//                holder.setText(R.id.text_publicsea_type, listBean.getPublicSeaName());
                holder.getView(R.id.text_publicsea_type).setVisibility(View.GONE);
                displayCircleImage(context, listBean.getHeaderURL(), (ImageView) holder.getView(R.id.img_header), R.mipmap.head_img);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!mTouch)
                            return;
                        PublicSeaInfoActivity.startWebActivity(PublicSeaListActivity.this, listBean.getMemberId() + "", listBean.getMemberName() + "", listBean.getSex() + "", "会员");
//                }
                    }
                });
//                ImageView imageView = holder.getView(R.id.img_header);
//
//                Glide.with(context)
//                        .load(Constants.BASEURL + listBean.getHeaderURL())// 加载图片
//                        .crossFade()// 淡出效果
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存
//                        .into(imageView);
            }
        };

        if (mtype == 0) {
            recyclerView.setAdapter(commonAdapter);
        } else {
            recyclerView.setAdapter(commonMemberAdapter);
        }
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
    }


    @Override
    protected void initData() {
        // TODO: 2017/4/18 测试数据
        mDatas = Arr2List(PUBLIC_SEA_ORDER_DATAS);
        mInterfaceDatas = Arr2List(PUBLIC_SEA_ORDER_Interface_DATAS);
        mSelectedArr = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
//            mDatas.add("" + (char) i + (char) i + (char) i + (char) i + (char) i);
            mSelectedArr.add(0);
        }

        textTitle.setText(mItems[0]);
        refresh();
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
     /*   title.setVisibility(View.INVISIBLE);*/
//        title.setEnabled(false);
        title.setClickable(false);

        title.setAdapter(adapter);
        title.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // spinner 选中事件
//                ToastUtil.s(PublicSeaListActivity.this, mItems[position]);
                if (position == 0) {
                    // 客户列表
//                    mtype = 0;
//                    mTypeName = "客户";
                    mInterfaceDatas = Arr2List(PUBLIC_SEA_ORDER_Interface_DATAS);
//                    title.setEnabled(true);
                } else {
                    // 会员列表
//                    mtype = 1;
//                    mTypeName = "会员";
                    mPostCustomerListBean.setPublicSeaId("");
                    mPostCustomerListBean.setPublicSeaName("");
                    mInterfaceDatas = Arr2List(PUBLIC_SEA_MEMBERS_ORDER_Interface_DATAS);

                }
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void succeed(PublicSeaBean publicSeaBean) {

        swipeRefreshLayout.setRefreshing(false);

        try {
            datas = publicSeaBean.getResult();
            for (int i = 0; i < datas.size(); i++) {
                mSelectdatas.add("0");
            }
            if (page == 1) {
                if (datas.size() == 0) {
                    BtnEdit.setVisibility(View.INVISIBLE);
                } else {
                    BtnEdit.setVisibility(View.VISIBLE);
                }
                commonAdapter.replaceData(datas);
            } else {
                if (datas.size() > 0)
                    commonAdapter.insertData(datas);
                   isLoadingMore = true;
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void membersucceed(PublicSeaMemberBean publicSeaBean) {

        swipeRefreshLayout.setRefreshing(false);
//        recyclerView.setAdapter(commonMemberAdapter);
        try {
            memberdatas = publicSeaBean.getResult();
            for (int i = 0; i < memberdatas.size(); i++) {
                mSelectdatas.add("0");
            }
            if (page == 1) {
                if (memberdatas.size() == 0) {
                    BtnEdit.setVisibility(View.INVISIBLE);
                } else {
                    BtnEdit.setVisibility(View.VISIBLE);
                }
                commonMemberAdapter.replaceData(memberdatas);
            } else {
                if (memberdatas.size() > 0)
                    commonMemberAdapter.insertData(memberdatas);
                isLoadingMore = true;
            }
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
        ItmeOnClick = true;
        getList();
    }

    public void getList() {
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
        String mOrderName = "";
        int mOrderType = 2;
        for (int i = 0; i < mSelectedArr.size(); i++) {
            if (mSelectedArr.get(i) > 0) {
                mOrderName = mInterfaceDatas.get(i).toString();
                mOrderType = mSelectedArr.get(i);
            }
        }
        if (mtype == 0) {

            mPresenter.appPublicSeaCustomerList(
                    UserName,
                    UserId,
                    token,
                    ClubId,
                    page,
                    mPostCustomerListBean.getStartCreateTime(),
                    mPostCustomerListBean.getEndCreateTime(),
                    mPostCustomerListBean.getPublicSeaId().equals("0") ? null : mPostCustomerListBean.getPublicSeaId(), mOrderName, mOrderType == 1 ? "asc" : "desc"
            );
        } else {

            mPresenter.appPublicSeaMemberList(UserName,
                    UserId,
                    token,
                    ClubId,
                    page,
                    mPostCustomerListBean.getStartCreateTime(),
                    mPostCustomerListBean.getEndCreateTime(),
                    mPostCustomerListBean.getPublicSeaId().equals("0") ? null : mPostCustomerListBean.getPublicSeaId(), mOrderName, mOrderType == 1 ? "asc" : "desc");
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

    @Override
    public void succeedEdit(String msg) {
        s(context, msg);
        btnSelectedAll.setChecked(false);
        selectAll = false;
        mSelectdatas.clear();
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        editShow = false;
        BtnEdit.setText("编辑");
        layoutEditBottom.setVisibility(View.GONE);
//        commonAdapter.notifyDataSetChanged();
        refresh();

    }

    @Override
    public void succeedPubluc(CodeBean codeBean) {
//        s(context, "捞取成功!");
        btnSelectedAll.setChecked(false);
        selectAll = false;
        mSelectdatas.clear();
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        editShow = false;
        BtnEdit.setText("编辑");
        layoutEditBottom.setVisibility(View.GONE);
//        commonAdapter.notifyDataSetChanged();
        refresh();
    }

    @Override
    public void onBackPressed() {
        if (BtnEdit.getText().toString().equals("完成")) {
            editShow = false;
            BtnEdit.setText("编辑");
            layoutEditBottom.setVisibility(View.GONE);
            if (commonAdapter != null)
                commonAdapter.notifyDataSetChanged();
            if (commonMemberAdapter != null)
                commonMemberAdapter.notifyDataSetChanged();
        } else {
            finish();
        }
    }

    @OnClick({R.id.btn_gain_publicsea, R.id.btn_selected_all, R.id.btn_edit, R.id.img_search, R.id.sorting_btn, R.id.screening_btn, R.id.btn_Change_publicStype, R.id.btn_Change_OwnManager, R.id.btn_Change_coachLesson})
    public void onClick(View view) {
        boolean n = false;
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String personType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
        int isDerpart = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        switch (view.getId()) {
            case R.id.btn_edit:
                if (mtype == 0) {
                    if (personType.equals("会籍")) {
                        if (isDerpart == 1) {
                            btnChangePublicStype.setVisibility(View.VISIBLE);
                            btnChangeOwnManager.setVisibility(View.VISIBLE);
                            btnChangeCoachLesson.setVisibility(View.GONE);
                        } else {
                            btnChangePublicStype.setVisibility(View.GONE);
                            btnChangeOwnManager.setVisibility(View.GONE);
                            btnChangeCoachLesson.setVisibility(View.GONE);
                        }
                    } else {
                        if (isDerpart == 1) {
                            btnChangePublicStype.setVisibility(View.GONE);
                            btnChangeOwnManager.setVisibility(View.GONE);
                            btnChangeCoachLesson.setVisibility(View.VISIBLE);
                        }


                    }

                }
                if (BtnEdit.getText().toString().equals("编辑")) {
                    BtnEdit.setText("完成");
                    layoutEditBottom.setVisibility(View.VISIBLE);
                    editShow = true;
                    if (commonAdapter != null)
                        commonAdapter.notifyDataSetChanged();
                    if (commonMemberAdapter != null)
                        commonMemberAdapter.notifyDataSetChanged();
                    break;

                } else {

                    editShow = false;
                    BtnEdit.setText("编辑");
                    layoutEditBottom.setVisibility(View.GONE);
                    if (commonAdapter != null)
                        commonAdapter.notifyDataSetChanged();
                    if (commonMemberAdapter != null)
                        commonMemberAdapter.notifyDataSetChanged();

                    break;
                }


            case R.id.img_search:
                // 搜索
                Intent intent = new Intent(this, PublicSeaSearchListActivity.class);
                intent.putExtra("search", mtype);
//                if (mTypeName.equals("会员")) {
//                    intent.putExtra("search", 1);
//                } else {
//                    intent.putExtra("search", 0);
//
//                }
                startActivity(intent);
                break;
            case R.id.sorting_btn:
                sortingText.setTextColor(getResources().getColor(R.color.selected_color));
                sortingImg.setImageResource(R.mipmap.sortingsecleted);
                if (sortingShow) {
                    s = new SpinnerPopupWindow
                            .Builder(PublicSeaListActivity.this)
                            .setmLayoutManager(null)
                            .setOutsideTouchable(true)
//                        .setTitleText("性别")
                            .setmSpinnerPopContract(PublicSeaListActivity.this)
                            .setmAdapter(spinnerAdapter)
                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                            .build();
//                    layoutKeep0ut.setVisibility(View.VISIBLE);
                    ItmeOnClick = false;
                    layoutAlpha.setVisibility(View.VISIBLE);
                    mTouch = false;
                    s.showPopWindowCenter(view);
                    s.setTitleshow(false);
                    sortingShow = false;
                    layoutEditBottom.setVisibility(View.GONE);
                }
                break;
            case R.id.screening_btn:
                if (s != null) {
                    s.dismissPopWindow();
                }
                layoutEditBottom.setVisibility(View.GONE);
                layoutAlpha.setVisibility(View.VISIBLE);
                mTouch = false;
                editShow = false;
                commonAdapter.notifyDataSetChanged();
                ScreenPopup(view, 0);
                break;
            case R.id.btn_selected_all:
                selectAll = btnSelectedAll.isChecked();
                if (commonAdapter != null) {
                    for (int i = 0; i < datas.size(); i++) {
                        mSelectdatas.set(i, "1");
                    }
                    commonAdapter.notifyDataSetChanged();
                }

                if (commonMemberAdapter != null) {
                    for (int i = 0; i < memberdatas.size(); i++) {

                        mSelectdatas.set(i, "1");
                    }
                    commonMemberAdapter.notifyDataSetChanged();
                }

                break;
            case R.id.btn_gain_publicsea:


                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                }
                if (n) {
                    mPresenter.appGainCustomer(UserId, UserName, token, ClubId, toidstring(mSelectdatas));
                } else {
                    s(mContext, "请选择" + mTypeName);
                }


                break;
            case R.id.btn_Change_publicStype:

                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;

                    ;

                }
                if (n) {
                    UserEditPopup(view, 0);
                } else {

                    s(mContext, "请选择" + mTypeName);
                }


                break;
            case R.id.btn_Change_OwnManager:
                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;


                }
                if (n) {
                    UserEditPopup(view, 1);
                } else {

                    s(mContext, "请选择" + mTypeName);
                }


                break;
            case R.id.btn_Change_coachLesson:
                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;

                    ;

                }
                if (n) {
                    UserEditPopup(view, 2);
                } else {

                    s(mContext, "请选择" + mTypeName);
                }


                break;
        }
    }

    @Override
    public void dismiss() {
        if (mSelectedArr.get(mSelectedCount) > 0) {
            sortingText.setTextColor(getResources().getColor(R.color.selected_color));
            sortingImg.setImageResource(R.mipmap.sortingsecleted);
        } else {
            sortingText.setTextColor(getResources().getColor(R.color.all_back_color));
            sortingImg.setImageResource(R.mipmap.sorting);
        }
        layoutAlpha.setVisibility(View.GONE);
        mTouch = true;

        refresh();
        sortingShow = true;
    }


    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    PublicSeaListActivity.this).inflate(R.layout.item_pop, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas.get(position).toString());
            switch (mSelectedArr.get(position)) {
                case 0:
                    holder.tv.setTextColor(getResources().getColor(R.color.all_back_color));
                    holder.upBtn.setImageResource(R.mipmap.screening_up);
                    holder.downBtn.setImageResource(R.mipmap.screening_down);
                    break;
                case 1:
                    holder.tv.setTextColor(getResources().getColor(R.color.selected_color));
                    holder.upBtn.setImageResource(R.mipmap.screening_up_selected);
                    holder.downBtn.setImageResource(R.mipmap.screening_down);
                    break;
                case 2:
                    holder.tv.setTextColor(getResources().getColor(R.color.selected_color));
                    holder.upBtn.setImageResource(R.mipmap.screening_up);
                    holder.downBtn.setImageResource(R.mipmap.screening_down_selected);
                    break;
                default:
                    break;
            }

            holder.tv.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mSelectedArr.get(position)) {
                        case 0:
                            mSelectedArr.set(position, 1);
                            if (!firstSortingShow) {
                                //首次排序  不对上次点击进行修改
                                mSelectedArr.set(mSelectedCount, 0);
                            }
                            firstSortingShow = false;
                            mSelectedCount = position;
                            Log.e("取消", "" + position);
                            break;
                        case 1:
                            mSelectedArr.set(position, 2);
                            Log.e("上", "" + position);
                            break;
                        case 2:
                            mSelectedArr.set(position, 1);
                            Log.e("下", "" + position);
                            break;
                        default:
                            break;
                    }

                    spinnerAdapter.notifyDataSetChanged();
                    s.dismissPopWindow();
                    ;
                    layoutAlpha.setVisibility(View.GONE);
                    mTouch = true;
//                    Toast.makeText(CustomerListActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            ImageView upBtn;
            ImageView downBtn;
            LinearLayout selected_btn;

            public MyViewHolder(final View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.test1);
                upBtn = (ImageView) view.findViewById(R.id.up_btn);
                downBtn = (ImageView) view.findViewById(R.id.down_btn);
                selected_btn = (LinearLayout) view.findViewById(R.id.selected_btn);
            }
        }
    }


    public void ScreenPopup(View v, final int tag) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

//        switch (type) {
//            case ACTIVITY_ID_CUSTOMER:
//                mHight = App.SCREEN_HEIGHT / 10 * 9;
//                break;
//            case ACTIVITY_ID_NON_CUSTOMER:
        int mHight = App.SCREEN_HEIGHT / 10 * 5;
//                break;
//        }

        contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_publicsea_screening, null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
                layoutAlpha.setVisibility(View.GONE);
                mTouch = true;
            }
        });

        final RelativeLayout btnPublicSea = (RelativeLayout) contentView.findViewById(R.id.btn_publicsea);
        final TextView TimeEnd = (TextView) contentView.findViewById(R.id.second_time_end);
        final TextView TimeBegin = (TextView) contentView.findViewById(R.id.second_time_begin);
        final TextView textPublicSea = (TextView) contentView.findViewById(R.id.text_publicsea);
        if (mPostCustomerListBean.getStartCreateTime() != null)
            TimeBegin.setText(mPostCustomerListBean.getStartCreateTime());
        if (mPostCustomerListBean.getEndCreateTime() != null)
            TimeEnd.setText(mPostCustomerListBean.getEndCreateTime());
        btnPublicSea.setVisibility(mtype != 0 ? View.GONE : View.VISIBLE);
        final TextView btnreset = (TextView) contentView.findViewById(R.id.btn_reset);
        final TextView btnconfirm = (TextView) contentView.findViewById(R.id.btn_confirm);

        textPublicSea.setText(mPostCustomerListBean.getPublicSeaName());

////        backgroundAlpha(0.5f);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Intent intent = new Intent(PublicSeaListActivity.this, FilterListActivity.class);
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
////                //要传递的值
////                intent.putExtra("reValue", "Main Send Data!");
//                //启动Activity
                btnPublicSea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //标签
                        popupWindow.dismiss();
                        intent.putExtra(mStrType, PUBLICSEATYPEID);
//                        startActivity(intent);
                        startActivityForResult(intent, PUBLICSEATYPEID);//使用时需定义变量requestCode
                    }
                });

//
                TimeBegin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initCustomTimePicker(TimeBegin, "开始时间");
                        pvCustomTime.show();
                    }
                });
                TimeEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initCustomTimePicker(TimeEnd, "结束时间");
                        pvCustomTime.show();
                    }
                });

                btnreset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mPostCustomerListBean != null) {
                            mPostCustomerListBean = null;
                            mPostCustomerListBean = new PostCustomerListBean();

                            mPostCustomerListBean.setPublicSeaId("0");
                            TimeBegin.setText("开始时间");
                            TimeEnd.setText("结束时间");
                            textPublicSea.setText("");


                        }
                        refresh();
                    }
                });
//
                btnconfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refresh();
                        popupWindow.dismiss();
                    }
                });


                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标
        int[] point = {0, 0};

        v.getLocationOnScreen(point);

//        popupWindow.showAtLocation(v, Gravity.TOP, 0, point[1] + v.getHeight());
//        popupWindow.showAsDropDown(v,0,0);
        if (Build.VERSION.SDK_INT != 24) {
            //只有24这个版本有问题，好像是源码的问题
            popupWindow.showAsDropDown(v, 0, 2);
        } else {

            int[] location = new int[2];
            v.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, (int) (y + v.getHeight() + 2));
        }

//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }

    public void UserEditPopup(View v, final int tag) {


//        if (contentView != null) contentView = null;
//
//        if (popupWindow != null) popupWindow = null;

        final String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        final String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        final int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);

        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);


        final int[] mID = new int[1];

        // 一个自定义的布局，作为显示的内容

        String userType = "";


        datas = new ArrayList<>();
        memberdatas = new ArrayList<>();

        backgroundAlpha(0.5f);


        contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_publicsea_thrown, null);

        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        final TextView textTitle = (TextView) contentView.findViewById(R.id.text_title);
        final Spinner list = (Spinner) contentView.findViewById(R.id.list);
        final TextView textCause = (TextView) contentView.findViewById(R.id.text_cause);
        final Button btn = (Button) contentView.findViewById(R.id.button);

        String titleStr = "";
        textTitle.setText((tag == 0 ? " 抛入公海" : " 变更会籍"));

        switch (tag) {
            case 0:
                arrModel = String2Bean(SpUtil.get(context, PUBLICSEATYPEKEY, "").toString());
                titleStr = "变更客户公海类别";

                break;
            case 1:
                arrModel = String2Bean(SpUtil.get(context, MANGERLISTKEY, "").toString());
                titleStr = "变更会籍顾问";
                textCause.setVisibility(View.INVISIBLE);
                break;
            case 2:
                String s = SpUtil.get(context, CONTACTTEACHERLISTKEY, "").toString();
                arrModel = String2Bean(s);
                titleStr = "变更跟进教练";
                textCause.setVisibility(View.GONE);
                break;


        }

        textTitle.setText(titleStr);
        String[] arrM = new String[arrModel.size()];//


        for (int i = 0; i < arrModel.size(); i++) {
            arrM[i] = arrModel.get(i).getName().toString();
        }

        mID[0] = arrModel.get(0).getID();

//将可选内容与ArrayAdapter连接起来
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrM);
//设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        list.setAdapter(adapter);//将adapter 添加到spinner中
//        list.setVisibility(View.VISIBLE);//设置默认值


        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mID[0] = arrModel.get(position).getID();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        popupWindow.update();


//        backgroundAlpha(0.5f);


        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


//                final Intent intent = new Intent(PublicSeaListActivity.this, FilterListActivity.class);
//
//
//                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cause = textCause.getText().toString();

                        switch (mtype) {

                            case 0:
                                switch (tag) {
                                    case 0:
                                        mPresenter.appUpdateCustomerPublicSeaType(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]), Cause);
                                        break;
                                    case 1:
                                        mPresenter.appUpdateOwnManagerId(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]));
                                        break;
                                    case 2:
                                        mPresenter.updateMemberOwnTeacherBatch(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]));
                                        break;

                                }
                                break;

                            case 1:

                                switch (tag) {
                                    case 0:
                                        mPresenter.appUpdateCustomerPublicSeaType(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]), Cause);
                                        break;
                                    case 1:
                                        mPresenter.appUpdateOwnManagerId(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]));
                                        break;
                                    case 2:
                                        mPresenter.updateMemberOwnTeacherBatch(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]));
                                        break;

                                }
                                break;

                        }


                    }
                });


                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }


    @Override
    public void succeedoperate() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        this.view_result.setText(data.getStringExtra("NewStringInIntent"));
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
                mName = bundle.getString(RESULT_STRING);
                mTel = bundle.getString(RESULT_TEL);


            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == PUBLICSEATYPEID) {

            mPostCustomerListBean.setPublicSeaId(mId);

            mPostCustomerListBean.setPublicSeaName(mName);


        }

        if (requestCode == MANGERLISTID) {

            mPostCustomerListBean.setOwnManagerId(mId);

            mPostCustomerListBean.setOwnManagerName(mName);

        }

        if (requestCode == CREATEUSERLISTID) {

            mPostCustomerListBean.setCreateUserId(mId);

            mPostCustomerListBean.setCreateUserName(mName);

        }
        if (requestCode == CUSTOMERINTRODUCERID) {

            mPostCustomerListBean.setIntroduceMemberId(mId);

            mPostCustomerListBean.setIntroduceMemberName(mName);

        }
        if (requestCode == CUSTOMERSOURCEID) {

            mPostCustomerListBean.setSourceId(mId);

            mPostCustomerListBean.setSourceName(mName);

        }
        if (requestCode == CUSTOMERINTENTID) {

            mPostCustomerListBean.setIntentId(mId);

            mPostCustomerListBean.setIntentName(mName);

        }
        if (requestCode == POSTEACHERLISTID) {

            mPostCustomerListBean.setPOSTeacherId(mId);

            mPostCustomerListBean.setPOSTeacherName(mName);

        }
        if (requestCode == CONTACTTEACHERLISTID) {

            mPostCustomerListBean.setOwnTeacherId(mId);

            mPostCustomerListBean.setOwnTeacherName(mName);

        }

        //// TODO: 2017/6/5 办卡类型未实现
//        if (requestCode == ALLMEMBERCARDTYPEID ) {
//
//            mPostCustomerListBean.set(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }


        popupWindow.update();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                ScreenPopup(screeningBtn, 0);

            }
        };
        handler.post(runnable);

    }

    private void initCustomTimePicker(final TextView view, String title) {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);

        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调

                view.setText(getTime(date));

                switch (view.getId()) {

                    case R.id.first_time_begin:

                        mPostCustomerListBean.setStartLastContactTime(getTime(date));

                        break;
                    case R.id.first_time_end:

                        mPostCustomerListBean.setEndLastContactTime(getTime(date));

                        break;
                    case R.id.second_time_begin:

                        mPostCustomerListBean.setStartCreateTime(getTime(date));

                        break;
                    case R.id.second_time_end:

                        mPostCustomerListBean.setEndCreateTime(getTime(date));

                        break;


                }


                pvCustomTime.dismiss();
            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)

                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.gravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
                .isDialog(true)
                .setTitleText(title)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_charts_day_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        TextView ivClear = (TextView) v.findViewById(R.id.iv_clear);
                        ivClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                switch (view.getId()) {

                                    case R.id.first_time_begin:
                                        view.setText("开始时间");
                                        mPostCustomerListBean.setStartLastContactTime("");

                                        break;
                                    case R.id.first_time_end:
                                        view.setText("结束时间");
                                        mPostCustomerListBean.setEndLastContactTime("");

                                        break;
                                    case R.id.second_time_begin:
                                        view.setText("开始时间");
                                        mPostCustomerListBean.setStartCreateTime("");

                                        break;
                                    case R.id.second_time_end:
                                        view.setText("结束时间");
                                        mPostCustomerListBean.setEndCreateTime("");

                                        break;


                                }
                                pvCustomTime.dismiss();
                            }
                        });
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.nullcoloer)
                .build();

    }
}
