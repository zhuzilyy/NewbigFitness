package com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListByMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonTeacherListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
import static com.example.gufei.bigfitness.Constants.LESSONLISTBYMEMBERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONMEMBERLISTID;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERBYMEMBERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEBYID;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEID;
import static com.example.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.PERSONLISTID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEID;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
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
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.Constants.WARDROBETYPEID;
import static com.example.gufei.bigfitness.Constants.WARDROBETYPEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.toidstring;
import static com.example.gufei.bigfitness.util.ToastUtil.s;


public class TeacherFilterListActivity extends BaseActivity<TeacherFilterListActivityPresenter> implements TeacherFilterListActivityContract.View {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private CommonAdapter<FilterBean.FilterListBean> commonAdapter;


    private List<FilterBean.FilterListBean> datas = new ArrayList<FilterBean.FilterListBean>();

    private boolean isLoadingMore = true;//加载标志位

    private int page = 0;

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

        final int type = intent.getIntExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", 0);


        final String mId = intent.getStringExtra(PUT_STR + "id");

        final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        final String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        final int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        final String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        String personType = String.valueOf(SpUtil.get(mContext, PERSONTYPEKEY, ""));


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


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        datas = new ArrayList<>();

        switch (type) {


            case LESSONLISTBYMEMBERKEY:
                mPresenter.getLessonListByMemberId(UserName, UserId, token, ClubId, mId, null);
                break;

            case LESSONTEACHERBYMEMBERKEY:
                mPresenter.getLessonTeacherListForMember(UserId, token, ClubId, "", mId);
                break;

        }


        commonAdapter = new CommonAdapter<FilterBean.FilterListBean>(R.layout.cardview_filter_list, this, datas) {


            @Override
            protected void convert(final ViewHolder holder, final FilterBean.FilterListBean listBean, final int i) {

                holder.setText(R.id.id_user_name, listBean.getName());

                holder.getView(R.id.id_user_name).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                                switch (type) {
                                    case LESSONLISTBYMEMBERKEY:
                                        final Intent intent = new Intent(TeacherFilterListActivity.this, TeacherFilterListActivity.class);
                                        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                                        intent.putExtra(PUT_STR + "id", listBean.getID() + "");
                                        intent.putExtra(mStrType, LESSONTEACHERBYMEMBERKEY);
                                        startActivityForResult(intent, LESSONTEACHERBYMEMBERKEY);//使用时需定义变量requestCode
                                        break;

                                    case LESSONTEACHERBYMEMBERKEY:
                                        final Intent resultIntent = new Intent();
                                        Bundle bundle = new Bundle();
                                        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
                                        bundle.putString(RESULT_ID, String.valueOf(listBean.getID()));
                                        bundle.putString(RESULT_STRING, listBean.getName());
                                        bundle.putString(RESULT_TEL, listBean.getTel());
                                        resultIntent.putExtras(bundle);
                                        TeacherFilterListActivity.this.setResult(RESULT_OK, resultIntent);
                                        mPresenter.updateMemberLessonTeacher(UserId, UserName, token, ClubId, mId, String.valueOf(listBean.getID()));
                                        break;
                                }


//                        finish();


                    }
                });


            }


        };


        recyclerView.setAdapter(commonAdapter);
        commonAdapter.setShowFooter(false);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
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

    @Override
    protected void initData() {

        refresh();
    }


    public void refresh() {
        page = 1;
    }

    @Override
    protected void onDestroy() {
        final Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
        resultIntent.putExtras(bundle);
        TeacherFilterListActivity.this.setResult(RESULT_OK, resultIntent);
        super.onDestroy();
    }

    @Override
    public void succeedLessonListByMember(LessonListByMemberIdBean lessonListByMemberIdBean) {
        for (int i = 0; i < lessonListByMemberIdBean.getResult().size(); i++) {
            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(lessonListByMemberIdBean.getResult().get(i).getId());
            bean.setName(lessonListByMemberIdBean.getResult().get(i).getLessonName());
            datas.add(bean);
        }
        commonAdapter.refreshData(datas);
    }

    @Override
    public void succeedLessonTeacherListForMember(LessonTeacherListForMemberBean lessonTeacherListForMemberBean) {
        for (int i = 0; i < lessonTeacherListForMemberBean.getResult().size(); i++) {
            FilterBean.FilterListBean bean = new FilterBean.FilterListBean();
            bean.setID(lessonTeacherListForMemberBean.getResult().get(i).getTeacherId());
            bean.setName(String.valueOf(lessonTeacherListForMemberBean.getResult().get(i).getTeacherName()));
            datas.add(bean);
        }
        commonAdapter.refreshData(datas);
    }

    @Override
    public void succeedEdit(CodeBean codeBean) {

        finish();
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

        if (requestCode == LESSONTEACHERBYMEMBERKEY) {
            finish();
        }


    }
}
