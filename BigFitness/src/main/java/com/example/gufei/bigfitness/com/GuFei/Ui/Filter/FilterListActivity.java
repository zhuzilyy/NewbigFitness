package com.example.gufei.bigfitness.com.GuFei.Ui.Filter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ALLMEMBERCARDTYPEID;
import static com.example.gufei.bigfitness.Constants.ALLMEMBERCARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.APPOINTMENTRESULTID;
import static com.example.gufei.bigfitness.Constants.CARDTYPEID;
import static com.example.gufei.bigfitness.Constants.CARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.CLASSNAMEID;
import static com.example.gufei.bigfitness.Constants.CLASSTYPEID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERAPPOINTMENTTYPEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERAPPOINTMENTTYPEKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTYPEID;
import static com.example.gufei.bigfitness.Constants.IDENTIFICATIONID;
import static com.example.gufei.bigfitness.Constants.IDENTIFICATIONKEY;
import static com.example.gufei.bigfitness.Constants.LESSONMEMBERLISTID;
import static com.example.gufei.bigfitness.Constants.LESSONTBYMEMBERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MAKEUPCLASSID;
import static com.example.gufei.bigfitness.Constants.MAKEUPCLASSKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEBYID;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEID;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.NOMEMBERID;
import static com.example.gufei.bigfitness.Constants.PERSONLISTID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEID;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_APPID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.SALEMEMBERCARDTYPEID;
import static com.example.gufei.bigfitness.Constants.SALEMEMBERCARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.WARDROBETYPEID;
import static com.example.gufei.bigfitness.Constants.WARDROBETYPEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.AllString2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.FAllString2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.FString2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by Administrator on 2017/8/4.
 * 新页筛选
 */

public class FilterListActivity extends BaseActivity<FilterListActivityPresenter> implements FilterListActivityContract.View {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.tv_nodata)
    TextView tv_nodata;
    public String mId;
    /**
     * id
     */
    public int UserId;
    /**
     * 用户编号
     */
    public String token;
    /**
     * token
     */
    public int ClubId;
    /**
     * 会所ID
     */
    public int type;
    /**
     * 类型
     */
    public String personType;
    /**
     * 人员类型
     */


    private CommonAdapter<FilterBean.FilterListBean> commonAdapter;/*控制器*/


    private List<FilterBean.FilterListBean> datas = new ArrayList<FilterBean.FilterListBean>();/*筛选数据结*/

    private boolean isLoadingMore = true;/*加载标志位*/

    private int page = 0;/*页数*/

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_filter_list;
    }


    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        Intent intent = getIntent();
        type = intent.getIntExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", 0);


   /*     tvTitle.setText("请选择");*/
        mId = intent.getStringExtra(PUT_STR + "id");
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        personType = String.valueOf(SpUtil.get(mContext, PERSONTYPEKEY, ""));
        searchView.setVisibility(View.INVISIBLE);
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
                switch (type) {
                    case CUSTOMERINTRODUCERID:
                        mPresenter.getCustomerIntroducer(UserId, token, ClubId, searchView.getQuery().toString());
                        break;
                    case CUSTOMERSOURCEID:
                        mPresenter.getCustomerSource(UserId, token, ClubId, searchView.getQuery().toString());
                        break;

//                    case APPOINTMENTRESULTID:
//
//                        mPresenter.getCustomerSource(UserId, token, ClubId, searchView.getQuery().toString());
//
//                        break;

//                    case PERSONLISTID:
//
//                        if (mId.equals("3")){
//                            mPresenter.getPersonList(UserId, token, ClubId, "3", personType, searchView.getQuery().toString(),"1");
//                        }else{
//                            mPresenter.getPersonList(UserId, token, ClubId, mId, personType, searchView.getQuery().toString(),"0");
//                        }
//                        break;

                    case LESSONMEMBERLISTID:

                        mPresenter.getLessonMemberListForContactTeacher(UserId, token, ClubId, mId, personType, searchView.getQuery().toString());


                        break;
                }


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


//        final String personType = intent.getStringExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.personType");


        datas = new ArrayList<>();
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);

        switch (type) {
            case CUSTOMERTAGID:
                datas = FString2Bean(SpUtil.get(context, CUSTOMERTAGKEY, "").toString());
                break;
            case CUSTOMERINTENTID:
                datas = FString2Bean(SpUtil.get(context, CUSTOMERINTENTKEY, "").toString());
                break;
            case CARDTYPEID:
                String s = SpUtil.get(context, CARDTYPEKEY, "").toString();
                datas = FString2Bean(s);
                break;
            case WARDROBETYPEID:
                datas = FString2Bean(SpUtil.get(context, WARDROBETYPEKEY, "").toString());
                break;
            case MEMBERINTENTID:
                //datas = FString2Bean(SpUtil.get(context, MEMBERINTENTKEY, "").toString());
                datas = FString2Bean(SpUtil.get(context, CUSTOMERINTENTKEY, "").toString());
                break;
            case MANGERLISTID:
                if (personType.equals("会籍")) {
                    datas = FString2Bean(SpUtil.get(context, MANGERLISTKEY, "").toString());
                } else {
                    datas = FAllString2Bean(SpUtil.get(context, MANGERLISTKEY, "").toString());
                }
                break;

            case POSTEACHERLISTID:

                if (personType.equals("会籍")) {
                    datas = FAllString2Bean(SpUtil.get(context, POSTEACHERLISTKEY, "").toString());
                } else {
                    datas = FString2Bean(SpUtil.get(context, POSTEACHERLISTKEY, "").toString());
                }
                break;

            case CONTACTTEACHERLISTID:

                if (personType.equals("会籍")) {
                    datas = FAllString2Bean(SpUtil.get(context, CONTACTTEACHERLISTKEY, "").toString());
                } else {
                    datas = FString2Bean(SpUtil.get(context, CONTACTTEACHERLISTKEY, "").toString());
                }
                break;

            case LESSONTEACHERLISTID:
                if (personType.equals("会籍")) {
                    datas = FAllString2Bean(SpUtil.get(context, LESSONTEACHERLISTKEY, "").toString());
                } else {
                    datas = FString2Bean(SpUtil.get(context, LESSONTEACHERLISTKEY, "").toString());
                }
                break;

            case SALETEACHERLISTID:

                if (personType.equals("会籍")) {
                    datas = FAllString2Bean(SpUtil.get(context, SALETEACHERLISTKEY, "").toString());
                } else {
                    datas = FString2Bean(SpUtil.get(context, SALETEACHERLISTKEY, "").toString());
                }
                break;
            case PUBLICSEATYPEID:
                datas.clear();
                FilterBean.FilterListBean beanAll = new FilterBean.FilterListBean();
                beanAll.setID(0);
                beanAll.setName("全部公海");
                datas.add(beanAll);
                datas.addAll(FString2Bean(SpUtil.get(context, PUBLICSEATYPEKEY, "").toString()));
                break;

            case CREATEUSERLISTID:

                datas = FString2Bean(SpUtil.get(context, CREATEUSERLISTKEY, "").toString());

                break;
            case ALLMEMBERCARDTYPEID:

                datas = FString2Bean(SpUtil.get(context, ALLMEMBERCARDTYPEKEY, "").toString());

                break;
            case SALEMEMBERCARDTYPEID:

                datas = FString2Bean(SpUtil.get(context, SALEMEMBERCARDTYPEKEY, "").toString());

                break;
            case CUSTOMERAPPOINTMENTTYPEID:

                List<FilterBean.FilterListBean> temp = FAllString2Bean(SpUtil.get(context, CUSTOMERAPPOINTMENTTYPEKEY, "").toString());
//                temp.remove(0);
                if ("会籍".equals(personType)) {
                    for (int i = 0; i < temp.size(); i++) {
                        if (temp.get(i).getName().equals("办卡预约")) {
                            datas.add(temp.get(i));
                        }
                    }
                }


                break;


            case MEMBERAPPOINTMENTTYPEID:

                List<FilterBean.FilterListBean> memberTemp = FAllString2Bean(SpUtil.get(context, MEMBERAPPOINTMENTTYPEKEY, "").toString());
//                memberTemp.remove(0);
                if ("会籍".equals(personType)) {
                    for (int i = 0; i < memberTemp.size(); i++) {
                        if (memberTemp.get(i).getName().equals("续费预约")) {
                            datas.add(memberTemp.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < memberTemp.size(); i++) {
                        if (!memberTemp.get(i).getName().equals("续费预约")) {

                            datas.add(memberTemp.get(i));
                            if (mId != null) {
                                if (mId.equals("99")) {
                                    if (memberTemp.get(i).getName().equals("上课预约") ||
                                            memberTemp.get(i).getName().equals("补课预约")||
                                            memberTemp.get(i).getName().equals("续课预约")) {
                                        datas.remove(datas.size() - 1);
                                    }
                                }
                            }
                        }
                    }
                }


                break;
            case MEMBERAPPOINTMENTTYPEBYID:

                mPresenter.getAppointmentListForMemberId(UserId, token, ClubId, mId, personType);


                break;

            case PERSONLISTID:
                searchView.setVisibility(View.VISIBLE);
                if (mId.equals("3")) {
                    mPresenter.getPersonList(UserId, token, ClubId, "3", personType, searchView.getQuery().toString(), "0");
                } else {
                    mPresenter.getPersonList(UserId, token, ClubId, mId, personType, searchView.getQuery().toString(), "0");
                }


                break;
            case MAKEUPCLASSID:
                searchView.setVisibility(View.VISIBLE);
                mPresenter.getMakeUpMemberListForContactTeacher(UserId, token, ClubId, mId, personType, searchView.getQuery().toString(), "1");
                break;

            case LESSONMEMBERLISTID:
                searchView.setVisibility(View.VISIBLE);
                mPresenter.getLessonMemberListForContactTeacher(UserId, token, ClubId, mId, personType, searchView.getQuery().toString());


                break;
            case CUSTOMERINTRODUCERID:

                searchView.setVisibility(View.VISIBLE);
                mPresenter.getCustomerIntroducer(UserId, token, ClubId, searchView.getQuery().toString());


                break;
            case CUSTOMERSOURCEID:
                searchView.setVisibility(View.VISIBLE);
                mPresenter.getCustomerSource(UserId, token, ClubId, searchView.getQuery().toString());

                break;
            case IDENTIFICATIONID:

                datas = FString2Bean(SpUtil.get(context, IDENTIFICATIONKEY, "").toString());

                break;


            case CLASSTYPEID:


                FilterBean.FilterListBean bean0 = new FilterBean.FilterListBean();
                bean0.setID(0);
                bean0.setName("普通私教课");

                datas.add(bean0);


                FilterBean.FilterListBean bean1 = new FilterBean.FilterListBean();
                bean1.setID(1);
                bean1.setName("特色课");

                datas.add(bean1);


                break;

            case CUSTOMERTYPEID:


                FilterBean.FilterListBean customerbean0 = new FilterBean.FilterListBean();
                customerbean0.setID(CUSTOMERAPPOINTMENTTYPEID);
                customerbean0.setName("客户");
                datas.add(customerbean0);

                FilterBean.FilterListBean customerbean1 = new FilterBean.FilterListBean();
                customerbean1.setID(MEMBERAPPOINTMENTTYPEID);
                customerbean1.setName("会员");
                datas.add(customerbean1);

                if ("会籍".equals(personType)) {
                    FilterBean.FilterListBean customerbean2 = new FilterBean.FilterListBean();
                    customerbean2.setID(NOMEMBERID);
                    customerbean2.setName("非会员");
                    datas.add(customerbean2);
                }

                break;


            case APPOINTMENTRESULTID:
                //预约结果
                mPresenter.getAppointmentresult(UserId, token, ClubId, mId);
                break;

            case CLASSNAMEID:


                mPresenter.updata(UserId, token, ClubId, mId);

                break;

            case LESSONTBYMEMBERKEY:

//私教课程列表
                mPresenter.getLessonListForMember(UserId, token, ClubId, mId);

                break;
                //补课列表
            case MAKEUPCLASSKEY:
                mPresenter.getMakeUpMemberLessonList(UserId, token, ClubId, mId);
                break;

            case NOMEMBERID:

                List<FilterBean.FilterListBean> temp1 = FAllString2Bean(SpUtil.get(context, CUSTOMERAPPOINTMENTTYPEKEY, "").toString());
                temp1.remove(0);
                if ("会籍".equals(personType)) {
                    for (int i = 0; i < temp1.size(); i++) {
                        if (temp1.get(i).getName().equals("办卡预约")) {
                            datas.add(temp1.get(i));
                        }
                    }
                }
                break;
        }
        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter = new CommonAdapter<FilterBean.FilterListBean>(R.layout.cardview_filter_list, this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final FilterBean.FilterListBean listBean, final int i) {
                holder.setText(R.id.id_user_name, listBean.getName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        defaultSelect(listBean);
                        FilterListActivity.this.finish();


                    }
                });


            }


        };


        recyclerView.setAdapter(commonAdapter);

        commonAdapter.setShowFooter(false);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

//        //设置进度条的颜色
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
//
//
//        //设置进度条的大小样式
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
//
//
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//
//            @Override
//            public void onRefresh() {
//
//                refresh();
//
//            }
//
//
//        });
//
//        swipeRefreshLayout.post(new Runnable() {
//
//            @Override
//            public void run() {
//
//                swipeRefreshLayout.setRefreshing(true);
//                commonAdapter.setShowFooter(false);
//            }
//        });


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

//                        loading();

                    }
                }
            });

        }


    }


    private void defaultSelect(FilterBean.FilterListBean listBean) {

        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
        if (listBean.getName().equals("请选择")) {

            bundle.putString(RESULT_ID, "");
            bundle.putString(RESULT_APPID, "");
            bundle.putString(RESULT_STRING, "");
            bundle.putString(RESULT_TEL, "");
        } else {
            bundle.putString(RESULT_ID, String.valueOf(listBean.getID()));
            bundle.putString(RESULT_APPID, String.valueOf(listBean.getAppId()));
            bundle.putString(RESULT_STRING, listBean.getName());
            bundle.putString(RESULT_TEL, listBean.getTel());
        }

        resultIntent.putExtras(bundle);
        FilterListActivity.this.setResult(RESULT_OK, resultIntent);
    }

    @Override
    protected void initData() {

        refresh();
    }

    @Override
    public void succeedLessonListForMember(LessonListForMemberBean lessonListForMemberBean) {
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < lessonListForMemberBean.getResult().size(); i++) {

            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(lessonListForMemberBean.getResult().get(i).getLessonId());
            bean.setName(lessonListForMemberBean.getResult().get(i).getLessonName());
            bean.setAppId(lessonListForMemberBean.getResult().get(i).getAppointmentId());
            datas.add(bean);
        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();
    }

    public void refresh() {

        page = 1;

//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//
//        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
//
//        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
//
//        String mOrderName = "";
//
//        int mOrderType = 2;
//
//        for (int i = 0; i < mSelectedArr.size(); i++) {
//
//            if (mSelectedArr.get(i) > 0) {
//
//
//                mOrderName = mInterfaceDatas.get(i).toString();
//
//                mOrderType = mSelectedArr.get(i);
//
//
//            }
//        }
//
//
//        mPresenter.getCustomerList(UserName, UserId, DepartId, token, ClubId, IsDepartManager, page, TYPE_MANAGER, "", "", "", "", "", "", "", "", "", "", "", "", mOrderName, mOrderType == 1 ? "asc" : "desc");

    }


    @Override
    public void succeed(LessonListForDropBean lessonListForDropBean) {
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < lessonListForDropBean.getResult().size(); i++) {

            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(lessonListForDropBean.getResult().get(i).getLessonid());
            bean.setName(lessonListForDropBean.getResult().get(i).getLessonname());


            datas.add(bean);


        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();
    }

    @Override
    public void succeedPersonListBean(PersonListBean personListBean) {
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < personListBean.getResult().size(); i++) {

            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(personListBean.getResult().get(i).getPersonId());
            bean.setName(personListBean.getResult().get(i).getPersonName() + " " + personListBean.getResult().get(i).getTel());
            datas.add(bean);


        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();
    }

    @Override
    public void succeedAppointmentresult(AppointmentresultBean appointmentresultBean) {
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < appointmentresultBean.getResult().size(); i++) {
            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(appointmentresultBean.getResult().get(i).getID());
            bean.setName(appointmentresultBean.getResult().get(i).getName());
            datas.add(bean);
        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();

    }


    @Override
    public void succeedAppointmentListForMemberIdBean(AppointmentListForMemberIdBean appointmentListForMemberIdBean) {
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < appointmentListForMemberIdBean.getResult().size(); i++) {

            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(appointmentListForMemberIdBean.getResult().get(i).getAppointmenttypeid());
            bean.setName(appointmentListForMemberIdBean.getResult().get(i).getAppointmenttypename());
            datas.add(bean);


        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();


    }

    @Override
    public void succeedCustomerIntroducerBean(CustomerIntroducerBean customerIntroducerBean) {

        /*List<FilterBean.FilterListBean> datas = new ArrayList<FilterBean.FilterListBean>();*/
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < customerIntroducerBean.getResult().size(); i++) {
            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(customerIntroducerBean.getResult().get(i).getID());
            bean.setName(customerIntroducerBean.getResult().get(i).getName() + " " + customerIntroducerBean.getResult().get(i).getTel());
            datas.add(bean);
        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();
    }

    @Override
    public void succeedCustomerSource(CustomerSourceBean customerSourceBean) {
            /*List<FilterBean.FilterListBean> datas = new ArrayList<FilterBean.FilterListBean>();*/
        datas.clear();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        datas.add(FirstBean);
        for (int i = 0; i < customerSourceBean.getResult().size(); i++) {

            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(customerSourceBean.getResult().get(i).getID());
            bean.setName(customerSourceBean.getResult().get(i).getName());
            datas.add(bean);
        }

        if (datas.size() > 0) {
            defaultSelect(datas.get(0));
        }
        commonAdapter.notifyDataSetChanged();
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

        switch (type) {

            case CUSTOMERINTRODUCERID:
                mPresenter.getCustomerIntroducer(UserId, token, ClubId, searchView.getQuery().toString());
                break;
            case CUSTOMERSOURCEID:
                mPresenter.getCustomerSource(UserId, token, ClubId, searchView.getQuery().toString());
                break;

//                    case APPOINTMENTRESULTID:
//
//                        mPresenter.getCustomerSource(UserId, token, ClubId, searchView.getQuery().toString());
//
//                        break;

            case PERSONLISTID:

                if (mId.equals("3")) {
                    mPresenter.getPersonList(UserId, token, ClubId, mId, personType, searchView.getQuery().toString(), "1");
                } else {
                    mPresenter.getPersonList(UserId, token, ClubId, mId, personType, searchView.getQuery().toString(), "0");
                }


                break;

            case LESSONMEMBERLISTID:

                mPresenter.getLessonMemberListForContactTeacher(UserId, token, ClubId, mId, personType, searchView.getQuery().toString());


                break;
        }

    }
}
