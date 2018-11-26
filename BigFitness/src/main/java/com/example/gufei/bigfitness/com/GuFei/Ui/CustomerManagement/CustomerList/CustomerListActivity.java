package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record.FollowUpRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record.MembersFollowUpRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter.TeacherFilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SoftKeyBoardListener;
import com.example.gufei.bigfitness.util.SpUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_CUSTOMER;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_MEMBERS;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_NON_CUSTOMER;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_PRIVATE_MEMBERS;
import static com.example.gufei.bigfitness.Constants.CHART_LIST_ORDER_DATAS;
import static com.example.gufei.bigfitness.Constants.CHART_LIST_ORDER_DATAS_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.CLASSNAMEID;
import static com.example.gufei.bigfitness.Constants.CLASSTYPEID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.CUSTOMER_ORDER_DATAS;
import static com.example.gufei.bigfitness.Constants.CUSTOMER_ORDER_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTMENT_DATAS;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONLISTBYMEMBERKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MERBERS_ORDER_DATAS;
import static com.example.gufei.bigfitness.Constants.MERBERS_ORDER_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.PRIVATE_Interface_DATAS;
import static com.example.gufei.bigfitness.Constants.PRIVATE_ORDER_DATAS;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TYPE_CLERK;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.ListUtil.Arr2List;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.check;
import static com.example.gufei.bigfitness.util.ListUtil.map2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.toidstring;
import static com.example.gufei.bigfitness.util.TimeUtil.getMyDateKillYear;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

@RuntimePermissions
public class CustomerListActivity extends BaseActivity<CustomerListPresenter> implements CustomerListContract.View, SpinnerPopContract {

    @BindView(R.id.sorting_btn)
    RelativeLayout sortingBtn;
    @BindView(R.id.screening_btn)
    RelativeLayout screeningBtn;
    @BindView(R.id.type_department_btn)
    RelativeLayout departmentBtn;
    @BindView(R.id.text_department)
    TextView textDepartment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.searchView)
    SearchView searchView;
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
    @BindView(R.id.layout_edit_bottom)
    RelativeLayout linearLayoutBottom;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.btn_complete)
    Button btnEdit;
    @BindView(R.id.btn_selected_all)
    CheckBox btnSelectedAll;
    @BindView(R.id.btn_thrown_public)
    TextView btnThrownPublic;
    @BindView(R.id.btn_Change_membertype)
    TextView btnChangeMembertype;
    @BindView(R.id.btn_Change_coachTrack)
    TextView btnChangeCoachTrack;
    @BindView(R.id.btn_Change_coachLesson)
    TextView btnChangeCoachLesson;
    @BindView(R.id.layout_alpha)
    LinearLayout layoutAlpha;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
    private int page = 0;

    private int layoutId = 0;

    private String mTypeName = "";
    private boolean mTouch = true;
    PostCustomerListBean mPostCustomerListBean;
    private boolean isLoadingMore = true;//加载标志位
    private CommonAdapter<CustomerListBean.ResultBean> commonAdapter;
    private List<CustomerListBean.ResultBean> datas = new ArrayList<CustomerListBean.ResultBean>();
    private List<String> mSelectdatas = new ArrayList<String>();
    private List<String> mMSelectdatas = new ArrayList<String>();//客户数据表
    private List<String> mLessonSelectdatas = new ArrayList<String>();//课程ID数据表
    private SpinnerPopupWindow sortingPopWindows;
    private SpinnerPopupWindow ts;
    private SpinnerAdapter spinnerAdapter = new SpinnerAdapter();
    private TSpinnerAdapter TspinnerAdapter = new TSpinnerAdapter();
    //筛选显示标识
    private boolean sortingShow = true;
    //筛选首次运行标识
    private boolean firstSortingShow = true;
    //查找显示标识
    private boolean screeningShow = true;
    //编辑标识
    private boolean editShow = false;
    //全选标识
    private boolean selectAll = false;
    private List<String> mDatas;
    private List<String> mTDatas;
    private List<String> mInterfaceDatas;
    private List<Integer> mSelectedArr;
    private int mSelectedCount = 0;
    private int departmentId = TYPE_CLERK;
    private int departmentSelected = 0;
    private View contentView;
    private PopupWindow popupWindow;
    private int type;
    private String personType;

    private TimePickerView pvCustomTime;


    private List<FilterBean.FilterListBean> arrModel = new ArrayList<FilterBean.FilterListBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_activity_customer;
    }

    @Override
    protected void onResume() {
        super.onResume();

        refresh();
    }

    @Override
    protected void initView() {
        searchView.setIconified(false);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Log.e("ssssss", "false");
                return false;
            }
        });
        searchView.clearFocus();
        layoutAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutAlpha.setVisibility(View.GONE);
                if (sortingPopWindows != null) sortingPopWindows.dismissPopWindow();
                if (ts != null) ts.dismissPopWindow();
                mTouch = true;
            }
        });
        mPostCustomerListBean = new PostCustomerListBean();
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        btnEdit.setText("编辑");
        btnEdit.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        type = intent.getIntExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", 0);
        departmentId = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        personType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
        mPostCustomerListBean.setPersonType(String.valueOf(SpUtil.get(mContext, PERSONTYPEKEY, "")));
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
                refresh();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });
        departmentBtn.setVisibility(View.GONE);

        switch (type) {

            case ACTIVITY_ID_CUSTOMER:

                layoutId = R.layout.pop_view_customer_screening;

                mTypeName = "客户  ";
                btnThrownPublic.setVisibility(View.VISIBLE);

                if (departmentId == 1) {
//                    btnChangeMembertype.setVisibility(View.VISIBLE);
                    departmentBtn.setVisibility(View.VISIBLE);
                }
                if (personType.equals("会籍")) {
                    btnEdit.setVisibility(View.VISIBLE);
                }


                break;

            case ACTIVITY_ID_NON_CUSTOMER:
                layoutId = R.layout.pop_view_non_customer_screening;
                mTypeName = "过期  ";
                btnThrownPublic.setVisibility(View.VISIBLE);
                if (departmentId == 1) {
                    departmentBtn.setVisibility(View.VISIBLE);
                }
                if (personType.equals("会籍")) {
                    btnEdit.setVisibility(View.VISIBLE);
                }


                break;
            case ACTIVITY_ID_MEMBERS:

                layoutId = R.layout.pop_view_members_screening;
                mTypeName = "会员  ";
                if (departmentId == 1) {
                    departmentBtn.setVisibility(View.VISIBLE);
                    if (personType.equals("会籍")) {
                        btnChangeMembertype.setVisibility(View.VISIBLE);
                        btnEdit.setVisibility(View.INVISIBLE);
                    } else {

                        if (textDepartment.getText().equals("我的")) {
                            btnThrownPublic.setVisibility(View.VISIBLE);//显示抛入公海


                        } else {
                            btnThrownPublic.setVisibility(View.VISIBLE);//显示抛入公海
                            btnChangeCoachTrack.setVisibility(View.VISIBLE);//显示变更跟进教练
//                            btnChangeCoachLesson.setVisibility(View.VISIBLE);
                        }


                    }


                } else {
                    if (personType.equals("会籍")) {

                        btnEdit.setVisibility(View.INVISIBLE);
//                        btnChangeMembertype.setVisibility(View.VISIBLE);
                    } else {
                        btnChangeCoachTrack.setVisibility(View.GONE);//显示变更跟进教练
                        btnThrownPublic.setVisibility(View.VISIBLE);
                    }

                }

                break;

            case ACTIVITY_ID_PRIVATE_MEMBERS:

                layoutId = R.layout.pop_view_private_members_screening;
                mTypeName = "私教  ";
                btnEdit.setVisibility(View.INVISIBLE);
                if (departmentId == 1 && !personType.equals("会籍")) {
                    departmentBtn.setVisibility(View.VISIBLE);
                    btnChangeCoachTrack.setVisibility(View.VISIBLE);
                    btnChangeCoachLesson.setVisibility(View.VISIBLE);
                } else if (departmentId == 0 && !personType.equals("会籍")) {
                    departmentBtn.setVisibility(View.GONE);
                    btnThrownPublic.setVisibility(View.GONE);
                    btnChangeCoachTrack.setVisibility(View.GONE);
                    btnChangeCoachLesson.setVisibility(View.GONE);
                    linearLayoutBottom.setVisibility(View.GONE);
                }


                break;
        }
//        departmentSelected=departmentId;

        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<CustomerListBean.ResultBean>(R.layout.cardview_customer_list, this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final CustomerListBean.ResultBean listBean, final int i) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.getView(R.id.layout_content).getLayoutParams();
                layoutParams.width = App.SCREEN_WIDTH - 10;
                holder.getView(R.id.layout_content).setLayoutParams(layoutParams);
                CheckBox checkBox = holder.getView(R.id.CheckBox_selset);
                displayCircleImage(context, listBean.getHeaderURL(), (ImageView) holder.getView(R.id.img_head), R.mipmap.privatememberinfor_03);
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
                            mSelectdatas.set(i, String.valueOf(datas.get(i).getCustomerId()));
                            mMSelectdatas.set(i, String.valueOf(datas.get(i).getMemberId()));
                            mLessonSelectdatas.set(i, String.valueOf(datas.get(i).getId()));

                        } else {
                            mSelectdatas.set(i, "0");
                            mMSelectdatas.set(i, "0");
                            mLessonSelectdatas.set(i, "0");
                        }

                    }
                });


                holder.setText(R.id.id_user_name, mTypeName + listBean.getCustomerName());
                String Tname = "";
                String Mname = "";
                String time = "";
                String showStr = "";
                String userName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                if ("会籍".equals(personType)) {
                    if (departmentId == 1) {
                        if (!listBean.getOwnManagerName().equals(""))
                            Mname = "会籍" + "  " + listBean.getOwnManagerName();
                    } else {
                        Mname = personType + "  " + userName;
                    }
                    ;

                } else {
                    if (departmentId == 1) {
                        if (!listBean.getOwnTeacherName().equals(""))
                            Tname = "教练" + "  " + listBean.getOwnTeacherName();
                    } else {
                        Tname = personType + "  " + userName;
                    }
                    ;

                }

                if (!listBean.getLastContactTime().equals("")) {
                    time = getMyDateKillYear(listBean.getLastContactTime()) + "   最后跟进";
                }

                switch (type) {
                    case ACTIVITY_ID_CUSTOMER:
                        showStr = Mname + "  " + time;
                        holder.getView(R.id.img_head).setVisibility(View.GONE);
                        break;
                    case ACTIVITY_ID_NON_CUSTOMER:
                        showStr = Mname + "  " + time;

//                            if (!listBean.getOwnManagerName().equals(""))
//                                holder.setText(R.id.id_time, "会籍" + "  " + listBean.getOwnManagerName() + "  " + listBean.getLastContactTime() + "   跟进");
                        break;
                    case ACTIVITY_ID_MEMBERS:
                        if (personType.equals("会籍")) {
                            showStr = Mname + "  " + time;
//                                if (!listBean.getOwnManagerName().equals(""))
//                                    holder.setText(R.id.id_time, "会籍" + "  " + listBean.getOwnManagerName() + "  " + listBean.getLastContactTime() + "   跟进");
                        } else {

                            showStr = Tname + "  " + time;
//                                if (!listBean.getOwnTeacherName().equals(""))
//                                    holder.setText(R.id.id_time, "教练" + "  " + listBean.getOwnTeacherName() + "  " + listBean.getLastContactTime() + "   跟进");
                        }
                        break;

                    case ACTIVITY_ID_PRIVATE_MEMBERS:
                        if (personType.equals("会籍")) {
                            showStr = Mname + "  " + time;
//                                if (!listBean.getOwnManagerName().equals(""))
//                                    holder.setText(R.id.id_time, "会籍" + "  " + listBean.getOwnManagerName() + "  " + listBean.getLastContactTime() + "   跟进");
                        } else {
                            showStr = Tname + "  " + time;
//                                if (!listBean.getOwnTeacherName().equals(""))
//                                    holder.setText(R.id.id_time, "教练" + "  " + listBean.getOwnTeacherName() + "  " + listBean.getLastContactTime() + "   跟进");
                        }

                        break;


                }
                holder.setText(R.id.id_time, showStr);


                if (listBean.getSex().

                        equals("男"))

                {
                    holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_men);
                } else

                {
                    holder.setImage(R.id.img_sex).setImageResource(R.mipmap.highseasmembermanage_women);
                }

                holder.setImage(R.id.btn_tel).

                        setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent tel = new Intent(Intent.ACTION_VIEW);
                                Uri teldata = Uri.parse("tel:" + listBean.getTel());
                                tel.setData(teldata);
                                if (ActivityCompat.checkSelfPermission(CustomerListActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    CustomerListActivityPermissionsDispatcher.showToastWithCheck(CustomerListActivity.this);
                                    return;
                                }
                                startActivity(tel);

                            }
                        });


                holder.getView(R.id.layout_content).

                        setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = null;
                                if (editShow)
                                    return;
                                if (!mTouch)
                                    return;
                                switch (type) {

                                    case ACTIVITY_ID_CUSTOMER:


                                        intent = new Intent(context, FollowUpRecordActivity.class);
                                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                                        intent.putExtra(PUT_STR + "My", textDepartment.getText().toString());
                                        intent.putExtra(PUT_STR + "Name", listBean.getCustomerName());
                                        intent.putExtra(PUT_STR + "Type", mTypeName.trim());
                                        break;
                                    case ACTIVITY_ID_NON_CUSTOMER:

//                                        intent = new Intent(context, FollowUpRecordActivity.class);
//                                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
//                                        intent.putExtra(PUT_STR + "memberId", String.valueOf(listBean.getMemberId()));
//                                        intent.putExtra(PUT_STR + "My", textDepartment.getText().toString());
//                                       intent.putExtra(PUT_STR + "Name", listBean.getCustomerName());

                                        intent = new Intent(context, MembersFollowUpRecordActivity.class);
                                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                                        intent.putExtra(PUT_STR + "memberId", String.valueOf(listBean.getMemberId()));
                                        intent.putExtra(PUT_STR + "My", textDepartment.getText().toString());
                                        intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
                                        intent.putExtra(PUT_STR + "Type", mTypeName.trim() + "会员");


                                        break;
                                    case ACTIVITY_ID_MEMBERS:

                                        intent = new Intent(context, MembersFollowUpRecordActivity.class);
                                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                                        intent.putExtra(PUT_STR + "memberId", String.valueOf(listBean.getMemberId()));
                                        intent.putExtra(PUT_STR + "My", textDepartment.getText().toString());
                                        intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
                                        intent.putExtra(PUT_STR + "Type", mTypeName.trim());

                                        break;
                                    case ACTIVITY_ID_PRIVATE_MEMBERS:

                                        intent = new Intent(context, MembersFollowUpRecordActivity.class);
                                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getCustomerId()));
                                        intent.putExtra(PUT_STR + "memberId", String.valueOf(listBean.getMemberId()));
                                        intent.putExtra(PUT_STR + "My", textDepartment.getText().toString());
                                        intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
                                        intent.putExtra(PUT_STR + "Type", mTypeName.trim() + "会员");
                                        intent.putExtra(PUT_STR + "LessonTeacherId", listBean.getLessonTeacherId());

                                        break;
                                }


                                // TODO: 2017/6/21 改过期会员不能为不能点击详情


                                intent.putExtra(PUT_STR + "Sex", listBean.getSex());
//                        if (type!=ACTIVITY_ID_NON_CUSTOMER){
                                startActivity(intent);
                            }

//                    }
                        });

            }


        }

        ;

        SoftKeyBoardListener.setListener(CustomerListActivity.this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
//                Toast.makeText(CustomerListActivity.this, "键盘显示 高度" + height, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void keyBoardHide(int height) {
                searchView.clearFocus();
//                Toast.makeText(CustomerListActivit y.this, "键盘隐藏 高度" + height, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(commonAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()

        {

            @Override
            public void onRefresh() {
                refresh();

            }


        });

        swipeRefreshLayout.post(new

                                        Runnable() {

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
        recyclerView.setEnabled(false);
        mTDatas = Arr2List(DEPARTMENT_DATAS);
        // TODO: 2017/4/18 测试数据
        switch (type) {
            case ACTIVITY_ID_CUSTOMER:
                mDatas = Arr2List(CUSTOMER_ORDER_DATAS);

                mInterfaceDatas = Arr2List(CUSTOMER_ORDER_Interface_DATAS);
                break;
            case ACTIVITY_ID_NON_CUSTOMER:
                mDatas = Arr2List(MERBERS_ORDER_DATAS);
                mInterfaceDatas = Arr2List(MERBERS_ORDER_Interface_DATAS);
                break;
            case ACTIVITY_ID_MEMBERS:
                mDatas = Arr2List(CHART_LIST_ORDER_DATAS);
                mInterfaceDatas = Arr2List(CHART_LIST_ORDER_DATAS_Interface_DATAS);
                break;
            case ACTIVITY_ID_PRIVATE_MEMBERS:
                mDatas = Arr2List(PRIVATE_ORDER_DATAS);
                mInterfaceDatas = Arr2List(PRIVATE_Interface_DATAS);
                break;
        }

//        mDatas = Arr2List(CUSTOMER_ORDER_DATAS);
//        mTDatas = Arr2List(DEPARTMENT_DATAS);
        mSelectedArr = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
            mSelectedArr.add(0);
        }


        refresh();

    }

    @Override
    public void succeed(CustomerListBean customerListBean) {
        isLoadingMore = true;
        swipeRefreshLayout.setRefreshing(false);
        try {
            datas = customerListBean.getResult();
            if (page == 1) {
                mSelectdatas.clear();
                mMSelectdatas.clear();
                mLessonSelectdatas.clear();
                for (int i = 0; i < datas.size(); i++) {
                    mSelectdatas.add("0");
                    mMSelectdatas.add("0");
                    mLessonSelectdatas.add("0");
                }
                if (datas.size() == 0) {
                    btnEdit.setVisibility(View.INVISIBLE);
                    tvNoMore.setVisibility(View.VISIBLE);
                } else {
                    tvNoMore.setVisibility(View.GONE);
                    int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);

                    switch (type) {

                        case ACTIVITY_ID_MEMBERS:
                            if ((IsDepartManager == 1 && textDepartment.getText().equals("部门")) || personType.equals("教练")) {
                                btnEdit.setVisibility(View.VISIBLE);
                            }

                            break;

                        case ACTIVITY_ID_PRIVATE_MEMBERS:

                            if (IsDepartManager == 1 && personType.equals("教练") && textDepartment.getText().equals("部门")) {
                                btnEdit.setVisibility(View.VISIBLE);
                            }

                            break;
                    }


                }
                commonAdapter.replaceData(datas);
            } else {
                for (int i = 0; i < datas.size(); i++) {
                    mSelectdatas.add("0");
                    mMSelectdatas.add("0");
                    mLessonSelectdatas.add("0");
                }
                commonAdapter.insertData(datas);

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
        getList();

    }

    public void getList() {

        if (popupWindow != null)
            popupWindow.dismiss();
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
        String mOrderName = "";
        int mOrderType = 2;
        Log.e("mSelectedArr", mInterfaceDatas.size() + "");
        Log.e("mSelectedArr", mSelectedArr.size() + "");
        if (personType.equals("会籍")) {
            for (int i = 0; i < mSelectedArr.size(); i++) {

                if (mSelectedArr.get(i) > 0) {
                    mOrderName = mInterfaceDatas.get(i).toString();
                    mOrderType = mSelectedArr.get(i);
                    Log.e("mOrderName", mOrderName);
                    Log.e("mOrderType", mOrderType + "");
                }

            }
        } else {
            for (int i = 0; i < mInterfaceDatas.size(); i++) {

                if (mSelectedArr.get(i) > 0) {
                    mOrderName = mInterfaceDatas.get(i).toString();
                    mOrderType = mSelectedArr.get(i);
                    Log.e("mOrderName", mOrderName);
                    Log.e("mOrderType", mOrderType + "");
                }

            }
        }


        switch (type) {
            case ACTIVITY_ID_CUSTOMER:
                mPresenter.getCustomerList(
                        UserName,
                        UserId,
                        DepartId,
                        token,
                        ClubId,
                        IsDepartManager,
                        page,
                        departmentSelected,
                        searchView.getQuery().toString(),
                        mPostCustomerListBean.getSex() != "" ? mPostCustomerListBean.getSex() : "",
                        mPostCustomerListBean.getIntentId(),
                        mPostCustomerListBean.getSourceId(),
                        mPostCustomerListBean.getStartCreateTime(),
                        mPostCustomerListBean.getEndCreateTime(),
                        mPostCustomerListBean.getCreateUserId(),
                        mPostCustomerListBean.getIntroduceMemberId(),
                        mPostCustomerListBean.getLabelId(),
                        mPostCustomerListBean.getOwnManagerId(),
                        mPostCustomerListBean.getStartLastContactTime(),
                        mPostCustomerListBean.getEndLastContactTime(),
                        mOrderName,
                        mOrderType == 1 ? "asc" : "desc");
                break;

            case ACTIVITY_ID_NON_CUSTOMER:
                mPresenter.getNoMemberList(
                        UserName,
                        UserId,
                        DepartId,
                        token,
                        ClubId,
                        IsDepartManager,
                        page,
                        departmentSelected,
                        searchView.getQuery().toString(),
                        mPostCustomerListBean.getSex() != "" ? mPostCustomerListBean.getSex() : "",
                        mPostCustomerListBean.getIntentId(),
                        mPostCustomerListBean.getSourceId(),
                        mPostCustomerListBean.getStartCreateTime(),
                        mPostCustomerListBean.getEndCreateTime(),
                        mPostCustomerListBean.getCreateUserId(),
                        mPostCustomerListBean.getIntroduceMemberId(),
                        mPostCustomerListBean.getLabelId(),
                        mPostCustomerListBean.getOwnManagerId(),
                        mPostCustomerListBean.getStartLastContactTime(),
                        mPostCustomerListBean.getEndLastContactTime(),
                        mPostCustomerListBean.getPOSTeacherId(),
                        mPostCustomerListBean.getOwnTeacherId(),
                        mOrderName,
                        mOrderType == 1 ? "asc" : "desc");

                break;
            case ACTIVITY_ID_MEMBERS:
                mPresenter.getMemberList(
                        UserName,
                        UserId,
                        DepartId,
                        token,
                        ClubId,
                        IsDepartManager,
                        page,
                        departmentSelected,
                        searchView.getQuery().toString(),
                        "",
                        mPostCustomerListBean.getSex() != "" ? mPostCustomerListBean.getSex() : "",
                        mPostCustomerListBean.getIntentId(),
                        mPostCustomerListBean.getSourceId(),
                        mPostCustomerListBean.getStartCreateTime(),
                        mPostCustomerListBean.getEndCreateTime(),
                        mPostCustomerListBean.getCreateUserId(),
                        mPostCustomerListBean.getIntroduceMemberId(),
                        mPostCustomerListBean.getLabelId(),
                        mPostCustomerListBean.getOwnManagerId(),
                        mPostCustomerListBean.getOwnTeacherId(),
                        mPostCustomerListBean.getPOSTeacherId(),
                        mPostCustomerListBean.getStartCreateTime(),
                        mPostCustomerListBean.getEndCreateTime(),
                        mPostCustomerListBean.getStartLastContactTime(),
                        mPostCustomerListBean.getEndLastContactTime(),
                        personType,
                        mOrderName,
                        mOrderType == 1 ? "asc" : "desc");

                break;
            case ACTIVITY_ID_PRIVATE_MEMBERS:
//                mPresenter.getLessonMemberList(
//                        UserName,
//                        UserId,
//                        token,
//                        ClubId,
//                        IsDepartManager,
//                        page,
//                        departmentSelected,
//                        DepartId,
//                        searchView.getQuery().toString(),
//                        mPostCustomerListBean.getClassTypeId(),
//                        mPostCustomerListBean.getSex() != "" ? mPostCustomerListBean.getSex() : "",
//                        mPostCustomerListBean.getIntentId(),
//                        mPostCustomerListBean.getSourceId(),
//                        mPostCustomerListBean.getStartCreateTime(),
//                        mPostCustomerListBean.getEndCreateTime(),
//                        mPostCustomerListBean.getCreateUserId(),
//                        mPostCustomerListBean.getIntroduceMemberId(),
//                        mPostCustomerListBean.getLabelId(),
//                        mPostCustomerListBean.getOwnManagerId(),
//                        mPostCustomerListBean.getStartLastContactTime(),
//                        mPostCustomerListBean.getEndLastContactTime(),
//                        mPostCustomerListBean.getStartCreateTime(),
//                        mPostCustomerListBean.getEndCreateTime(),
//                        mPostCustomerListBean.getStartLastContactTime(),
//                        mPostCustomerListBean.getEndLastContactTime(),
//                        mPostCustomerListBean.getPersonType(),
//                        mOrderName,
//                        mOrderType == 1 ? "asc" : "desc");
                mPresenter.getLessonMemberList(
                        UserName,
                        UserId,
                        token,
                        ClubId,
                        IsDepartManager,
                        page,
                        departmentSelected,
                        DepartId,
                        searchView.getQuery().toString(),
                        mPostCustomerListBean.getClassTypeId(),
                        mPostCustomerListBean.getSex() != "" ? mPostCustomerListBean.getSex() : "",
                        mPostCustomerListBean.getIntentId(),
                        mPostCustomerListBean.getSourceId(),
                        mPostCustomerListBean.getClassName(),
                        mPostCustomerListBean.getClassId(),
                        mPostCustomerListBean.getSigninTeacherId(),
                        mPostCustomerListBean.getClassTeacherId(),
                        mPostCustomerListBean.getLabelId(),
                        mPostCustomerListBean.getOwnManagerId(),
                        mPostCustomerListBean.getOwnTeacherId(),
                        mPostCustomerListBean.getPOSTeacherId(),
                        mPostCustomerListBean.getStartLessonStopTime(),
                        mPostCustomerListBean.getEndLessonStopTime(),
                        mPostCustomerListBean.getStartLastContactTime(),
                        mPostCustomerListBean.getEndLastContactTime(),
                        personType,
                        mOrderName,
                        mOrderType == 1 ? "asc" : "desc");

                break;

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


    @OnClick({R.id.btn_thrown_public, R.id.btn_Change_coachTrack, R.id.btn_Change_coachLesson, R.id.btn_Change_membertype, R.id.sorting_btn, R.id.screening_btn, R.id.btn_complete, R.id.btn_selected_all, R.id.type_department_btn, R.id.fab})
    public void onClick(View view) {
        boolean n = false;
        switch (view.getId()) {
            case R.id.sorting_btn:

                sortingText.setTextColor(getResources().getColor(R.color.selected_color));
                sortingImg.setImageResource(R.mipmap.sortingsecleted);
                if (sortingShow) {
                    sortingPopWindows = new SpinnerPopupWindow
                            .Builder(CustomerListActivity.this)
                            .setmLayoutManager(null)
                            .setOutsideTouchable(true)
//                        .setTitleText("性别")
                            .setmSpinnerPopContract(CustomerListActivity.this)
                            .setmAdapter(spinnerAdapter)
                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                            .build();

                    sortingPopWindows.showPopWindowCenter(view);
                    sortingPopWindows.setTitleshow(false);
                    layoutAlpha.setVisibility(View.VISIBLE);
                    mTouch = false;
                    sortingShow = false;
                    editShow = false;
                    commonAdapter.notifyDataSetChanged();

                }

                break;

            case R.id.screening_btn:

                ScreenPopup(view, 0);

                layoutAlpha.setVisibility(View.VISIBLE);
                mTouch = false;
                editShow = false;
                commonAdapter.notifyDataSetChanged();

                break;
            case R.id.type_department_btn:

                if (sortingShow) {
                    ts = new SpinnerPopupWindow
                            .Builder(CustomerListActivity.this)
                            .setmLayoutManager(null)
                            .setOutsideTouchable(true)
//                          .setTitleText("性别")
                            .setmSpinnerPopContract(CustomerListActivity.this)
                            .setmAdapter(TspinnerAdapter)
                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                            .build();

                    ts.showPopWindowCenter(view);
                    layoutAlpha.setVisibility(View.VISIBLE);
                    mTouch = false;
                    ts.setTitleshow(false);
                    sortingShow = false;

                }

                break;

            case R.id.btn_selected_all:

                selectAll = btnSelectedAll.isChecked();

                for (int i = 0; i < datas.size(); i++) {

                    mSelectdatas.set(i, datas.get(i).getCustomerId() + "");
                    mMSelectdatas.set(i, datas.get(i).getMemberId() + "");
                    mLessonSelectdatas.set(i, datas.get(i).getId() + "");
                }

                commonAdapter.notifyDataSetChanged();

                break;
            case R.id.btn_complete:

                if (btnEdit.getText().toString().equals("编辑")) {

                    btnEdit.setText("完成");

                    linearLayoutBottom.setVisibility(View.VISIBLE);

                    editShow = true;

                    commonAdapter.notifyDataSetChanged();

                    break;

                } else {

                    editShow = false;
                    btnEdit.setText("编辑");
                    linearLayoutBottom.setVisibility(View.GONE);
                    commonAdapter.notifyDataSetChanged();

                    break;
                }
            case R.id.fab:

//                   AddFollpwAndAppointmentPopup(view,0);

                break;
            case R.id.btn_thrown_public:

                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    if (!mMSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    ;
                    if (!mLessonSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;

                }
                if (n) {
                    UserEditPopup(view, 0);
                } else {

                    s(mContext, "请选择" + mTypeName);
                }


                break;
            case R.id.btn_Change_membertype:

                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    if (!mMSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    if (!mLessonSelectdatas.get(i).equals("0")) {
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
            case R.id.btn_Change_coachTrack:

                for (int i = 0; i < mSelectdatas.size(); i++) {
                    if (!mSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    if (!mMSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    if (!mLessonSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;

                }
                if (n) {
                    UserEditPopup(view, 2);
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
                    if (!mMSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;
                    if (!mLessonSelectdatas.get(i).equals("0")) {
                        n = true;
                    }
                    ;

                }
                if (n) {
                    if (toidstring(mMSelectdatas).indexOf(",") > 0) {
                        s(this, "只能逐个变更上课教练");
                        break;
                    } else {
                        final Intent intent = new Intent(CustomerListActivity.this, TeacherFilterListActivity.class);
                        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                        intent.putExtra(PUT_STR + "id", toidstring(mMSelectdatas));
                        intent.putExtra(mStrType, LESSONLISTBYMEMBERKEY);
                        startActivityForResult(intent, LESSONLISTBYMEMBERKEY);//使用时需定义变量requestCode
                    }
                } else {
                    s(mContext, "请选择" + mTypeName);
                }

                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
        }
        return false;
    }
//    @Override
//    public void onBackPressed() {
//        if (searchView.isShown()){
//            searchView.onActionViewCollapsed();//collapse your ActionView
//            searchView.setQuery("",false);//clears your query without submit
////            isClosed = true;//needed to handle closed by back
//        } else{
//            super.onBackPressed();
//        }
//    }


    @Override
    public void onBackPressed() {

        if (btnEdit.getText().toString().equals("完成")) {


            editShow = false;
            btnEdit.setText("编辑");
            linearLayoutBottom.setVisibility(View.GONE);
            commonAdapter.notifyDataSetChanged();
        } else {
            finish();
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
        backgroundAlpha(1f);
        refresh();
        layoutAlpha.setVisibility(View.GONE);
        mTouch = true;
        sortingShow = true;

    }

    @NeedsPermission(Manifest.permission.CALL_PHONE)
    void showToast() {
    }

    @OnPermissionDenied(Manifest.permission.CALL_PHONE)
//一旦用户拒绝了
    void denied() {
    }

    @OnNeverAskAgain(Manifest.permission.CALL_PHONE)
//用户选择的不再询问
    void notAsk() {
        s(this, "如想继续使用,请到设置-程序-开放拨打电话权限");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        CustomerListActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    CustomerListActivity.this).inflate(R.layout.item_pop, parent,
                    false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {


            holder.tv.setText(mDatas.get(position).toString());
            for (int i = 0; i < mDatas.size(); i++) {
                Log.e("ss", mDatas.get(i).toString());
            }
            for (int i = 0; i < mInterfaceDatas.size(); i++) {
                Log.e("ff", mInterfaceDatas.get(i).toString());
            }
            for (int i = 0; i < mSelectedArr.size(); i++) {
                Log.e("zz", mSelectedArr.get(i).toString());
            }

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
                    layoutAlpha.setVisibility(View.GONE);
                    mTouch = true;
                    sortingPopWindows.dismissPopWindow();
                    dismiss();
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

    class TSpinnerAdapter extends RecyclerView.Adapter<TSpinnerAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    CustomerListActivity.this).inflate(R.layout.item_pop, parent,
                    false));
            holder.upBtn.setVisibility(View.INVISIBLE);
            holder.downBtn.setVisibility(View.INVISIBLE);

            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.tv.setText(mTDatas.get(position).toString());
            holder.tv.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    departmentSelected = position;
                    switch (type) {

                        case ACTIVITY_ID_CUSTOMER:
                            layoutId = R.layout.pop_view_customer_screening;
                            mTypeName = "客户  ";
                            btnThrownPublic.setVisibility(View.VISIBLE);
                            if (departmentId == 1) {
                                btnChangeMembertype.setVisibility(View.VISIBLE);
                                departmentBtn.setVisibility(View.VISIBLE);
                                if (position == 0) {
                                    btnChangeMembertype.setVisibility(View.GONE);
                                }
                            }
                            break;

                        case ACTIVITY_ID_NON_CUSTOMER:

                            layoutId = R.layout.pop_view_non_customer_screening;
                            mTypeName = "过期  ";
                            btnThrownPublic.setVisibility(View.VISIBLE);
                            if (departmentId == 1) {
                                btnChangeMembertype.setVisibility(View.VISIBLE);
                                departmentBtn.setVisibility(View.VISIBLE);
                                if (position == 0) {

                                    btnChangeMembertype.setVisibility(View.GONE);
                                }
                            }


                            break;
                        case ACTIVITY_ID_MEMBERS:

                            layoutId = R.layout.pop_view_members_screening;
                            mTypeName = "会员  ";
                            btnEdit.setVisibility(View.INVISIBLE);
                            if (departmentId == 1) {
                                departmentBtn.setVisibility(View.VISIBLE);
                                if (personType.equals("会籍")) {
                                    btnChangeMembertype.setVisibility(View.VISIBLE);
                                    if (position == 0) {
                                        btnEdit.setVisibility(View.INVISIBLE);
                                    } else {
                                        btnEdit.setVisibility(View.VISIBLE);
                                    }
                                } else {
                                    if (personType.equals("会籍")) {
                                        btnEdit.setVisibility(View.INVISIBLE);
                                    }
                                    if (position == 0) {
                                        btnThrownPublic.setVisibility(View.VISIBLE);//显示抛入公海
                                        btnChangeCoachTrack.setVisibility(View.GONE);//显示变更跟进教练
                                    } else {
                                        btnThrownPublic.setVisibility(View.VISIBLE);//显示抛入公海
                                        btnChangeCoachTrack.setVisibility(View.VISIBLE);//显示变更跟进教练
//                            btnChangeCoachLesson.setVisibility(View.VISIBLE);
                                    }


                                }


                            } else {
                                if (personType.equals("会籍")) {

                                    btnEdit.setVisibility(View.INVISIBLE);
//                        btnChangeMembertype.setVisibility(View.VISIBLE);
                                } else {
                                    btnChangeCoachTrack.setVisibility(View.GONE);//显示变更跟进教练
                                    btnThrownPublic.setVisibility(View.VISIBLE);
                                }

                            }

                            break;

                        case ACTIVITY_ID_PRIVATE_MEMBERS:

                            layoutId = R.layout.pop_view_private_members_screening;
                            mTypeName = "私教  ";
                            if (departmentId == 1 && !personType.equals("会籍")) {

                                if (position == 1) {
                                    departmentBtn.setVisibility(View.VISIBLE);
                                    btnChangeCoachTrack.setVisibility(View.VISIBLE);
                                    btnChangeCoachLesson.setVisibility(View.VISIBLE);
                                    btnEdit.setVisibility(View.VISIBLE);
                                    btnEdit.setText("编辑");

                                } else {

                                    btnEdit.setVisibility(View.INVISIBLE);
                                    btnThrownPublic.setVisibility(View.INVISIBLE);
                                    btnChangeCoachTrack.setVisibility(View.INVISIBLE);
                                    btnChangeCoachLesson.setVisibility(View.INVISIBLE);
                                    linearLayoutBottom.setVisibility(View.GONE);
                                }


                            } else if (departmentId == 0 && !personType.equals("会籍")) {
                                departmentBtn.setVisibility(View.GONE);
                                btnEdit.setVisibility(View.INVISIBLE);
                                btnThrownPublic.setVisibility(View.INVISIBLE);
                                btnChangeCoachTrack.setVisibility(View.INVISIBLE);
                                btnChangeCoachLesson.setVisibility(View.INVISIBLE);
                                linearLayoutBottom.setVisibility(View.GONE);
                            } else if (departmentId == 0 && personType.equals("会籍")) {
                                departmentBtn.setVisibility(View.GONE);
                                btnEdit.setVisibility(View.INVISIBLE);
                                btnThrownPublic.setVisibility(View.INVISIBLE);
                                btnChangeCoachTrack.setVisibility(View.INVISIBLE);
                                btnChangeCoachLesson.setVisibility(View.INVISIBLE);
                                linearLayoutBottom.setVisibility(View.GONE);
                            }
                            if (holder.tv.getText().equals("我的")) {
                                btnEdit.setVisibility(View.INVISIBLE);

                            }
                            break;
                    }


                    textDepartment.setText(mTDatas.get(position).toString());
                    refresh();
                    ts.dismissPopWindow();
                    layoutAlpha.setVisibility(View.GONE);
                    mTouch = true;
                    TspinnerAdapter.notifyDataSetChanged();
                    dismiss();
//                    Toast.makeText(CustomerListActivity.this, "" + position, Toast.LENGTH_SHORT).show();

                }
            });

        }

        @Override
        public int getItemCount() {

            return mTDatas.size();
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

        if (sortingPopWindows != null) {
            sortingPopWindows.dismissPopWindow();
        }
        if (ts != null) {
            ts.dismissPopWindow();
        }

        int mHight = 0;
        switch (type) {
            case ACTIVITY_ID_CUSTOMER:
                mHight = App.SCREEN_HEIGHT / 10 * 6;
                break;
            case ACTIVITY_ID_NON_CUSTOMER:
                mHight = App.SCREEN_HEIGHT / 10 * 6;
                break;
            case ACTIVITY_ID_MEMBERS:
                mHight = ViewGroup.LayoutParams.WRAP_CONTENT;
                break;
            case ACTIVITY_ID_PRIVATE_MEMBERS:
                mHight = App.SCREEN_HEIGHT / 10 * 8;
                break;
        }

        contentView = LayoutInflater.from(this).inflate(layoutId, null);
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
        final String userName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        final int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        final RadioButton btnSexMen = (RadioButton) contentView.findViewById(R.id.btn_sex_men);
        final RadioButton btnSexWomen = (RadioButton) contentView.findViewById(R.id.btn_sex_women);
        final RadioButton btnSexNull = (RadioButton) contentView.findViewById(R.id.btn_sex_null);
        final TextView textReferences = (TextView) contentView.findViewById(R.id.text_references);
        final TextView textIntention = (TextView) contentView.findViewById(R.id.text_intention);
        final TextView textConsultant = (TextView) contentView.findViewById(R.id.text_consultant);
        final TextView FollowTimeEnd = (TextView) contentView.findViewById(R.id.first_time_end);
        final TextView FollowTimeBegin = (TextView) contentView.findViewById(R.id.first_time_begin);
        final TextView textCollect = (TextView) contentView.findViewById(R.id.text_collect);
        final TextView TimeEnd = (TextView) contentView.findViewById(R.id.second_time_end);
        final TextView TimeBegin = (TextView) contentView.findViewById(R.id.second_time_begin);
        final TextView textSource = (TextView) contentView.findViewById(R.id.text_source);
        final TextView textLabel = (TextView) contentView.findViewById(R.id.text_label);
        final TextView btnreset = (TextView) contentView.findViewById(R.id.btn_reset);
        final TextView btnconfirm = (TextView) contentView.findViewById(R.id.btn_confirm);
        final ImageView btnReferences = (ImageView) contentView.findViewById(R.id.btn_references);
        final ImageView btnSource = (ImageView) contentView.findViewById(R.id.btn_source);
        final ImageView btnIntention = (ImageView) contentView.findViewById(R.id.btn_intention);
        final ImageView btnLabel = (ImageView) contentView.findViewById(R.id.btn_label);
        final ImageView btnConsultant = (ImageView) contentView.findViewById(R.id.btn_consultant);
        final ImageView btnCollect = (ImageView) contentView.findViewById(R.id.btn_collect);
        textLabel.setText(mPostCustomerListBean.getLabelName());//标签
        textConsultant.setText(mPostCustomerListBean.getOwnManagerName());//会籍顾问
        textReferences.setText(mPostCustomerListBean.getIntroduceMemberName());//介绍人
        textIntention.setText(mPostCustomerListBean.getIntentName());//意向
        textSource.setText(mPostCustomerListBean.getSourceName());//来源
        if (mPostCustomerListBean.getSex() != null) {
            if (mPostCustomerListBean.getSex().equals("1")) {
                btnSexMen.setChecked(true);
            } else if (mPostCustomerListBean.getSex().equals("2")) {
                btnSexWomen.setChecked(true);
            } else {
                btnSexNull.setChecked(true);
            }
        } else {
            btnSexMen.setChecked(false);
            btnSexWomen.setChecked(false);
        }


        switch (layoutId) {
            case R.layout.pop_view_customer_screening:
                TextView btnCollectMembers = (TextView) contentView.findViewById(R.id.text_collect);
                btnCollectMembers.setText(mPostCustomerListBean.getCreateUserName());
                //客户列表
                break;
            case R.layout.pop_view_non_customer_screening:
                //过期会员列表
                TextView textCoachPos = (TextView) contentView.findViewById(R.id.text_coach_pos);
                TextView textCoachTrack = (TextView) contentView.findViewById(R.id.text_coach_track);
                textCoachPos.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
                textCoachTrack.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
                btnCollectMembers = (TextView) contentView.findViewById(R.id.text_collect);
                btnCollectMembers.setText(mPostCustomerListBean.getCreateUserName());

                // TODO: 2018/5/11  修改为在我的情况下 只显示为我的名字 所以取消隐藏 
//                if (personType.equals("会籍") && departmentId == 0) {
//                    RelativeLayout layoutConsultant = (RelativeLayout) contentView.findViewById(R.id.layout_consultant);
//                    layoutConsultant.setVisibility(View.GONE);
//
//                }

                break;
            case R.layout.pop_view_members_screening:
                //会员列表
                TextView textCoachPosMembers = (TextView) contentView.findViewById(R.id.text_coach_pos);
                TextView textCoachTrackMembers = (TextView) contentView.findViewById(R.id.text_coach_track);
                btnCollectMembers = (TextView) contentView.findViewById(R.id.text_collect);
                textCoachPosMembers.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
                textCoachTrackMembers.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
                btnCollectMembers.setText(mPostCustomerListBean.getCreateUserName());
                RelativeLayout LayoutCollect = (RelativeLayout) contentView.findViewById(R.id.layout_collect);
                LayoutCollect.setVisibility(View.GONE);
                final RelativeLayout layoutConsultant = (RelativeLayout) contentView.findViewById(R.id.layout_consultant);
//                if ((departmentId == 1 && textDepartment.getText().equals("部门") || personType.equals("教练"))) {
//                    layoutConsultant.setVisibility(View.VISIBLE);
//                } else {
//                    layoutConsultant.setVisibility(View.GONE);
//                }
                break;

            case R.layout.pop_view_private_members_screening:
                TextView textCoachPosMembersPrivate = (TextView) contentView.findViewById(R.id.text_coach_pos);
                TextView textCoachTrackMembersPrivate = (TextView) contentView.findViewById(R.id.text_coach_track);
                TextView textNameClass = (TextView) contentView.findViewById(R.id.text_name_class);//课程名称
                TextView textTypeClass = (TextView) contentView.findViewById(R.id.text_type_class);//课程类型
                TextView textCoachSigning = (TextView) contentView.findViewById(R.id.text_coach_signing);//预约教练
                TextView textCoachClass = (TextView) contentView.findViewById(R.id.text_coach_class);//上课教练
                textCoachPosMembersPrivate.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
                textCoachTrackMembersPrivate.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
                textNameClass.setText(mPostCustomerListBean.getClassName());//课程名称

                textTypeClass.setText(mPostCustomerListBean.getClassTypeIdName());//课程类型

                textCoachSigning.setText(mPostCustomerListBean.getSigninTeacherName());//预约教练

                textCoachClass.setText(mPostCustomerListBean.getClassTeacherName());//上课教练


//                btnCollectMembersPrivate.setText(mPostCustomerListBean.getCreateUserName());

                break;


        }


        popupWindow.update();


//       backgroundAlpha(0.5f);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Intent intent = new Intent(CustomerListActivity.this, FilterListActivity.class);
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                btnLabel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //标签


                        intent.putExtra(mStrType, CUSTOMERTAGID);

//                        startActivity(intent);
                        startActivityForResult(intent, CUSTOMERTAGID);//使用时需定义变量requestCode
//                        popupWindow.dismiss();

                    }
                });
                btnConsultant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (departmentId == 1 && textDepartment.getText().equals("部门")) {
                            //会籍顾问

                            intent.putExtra(mStrType, MANGERLISTID);
                            startActivityForResult(intent, MANGERLISTID);//使用时需定义变量requestCode
//                            popupWindow.dismiss();
                        } else if (personType.equals("教练")) {

                            intent.putExtra(mStrType, MANGERLISTID);
                            startActivityForResult(intent, MANGERLISTID);//使用时需定义变量requestCode

                        }
                    }
                });
                if (type != ACTIVITY_ID_PRIVATE_MEMBERS) {

                    btnCollect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //采集人

                            intent.putExtra(mStrType, CREATEUSERLISTID);
                            startActivityForResult(intent, CREATEUSERLISTID);//使用时需定义变量requestCode
//                            popupWindow.dismiss();


                        }
                    });
                }

                FollowTimeBegin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(FollowTimeBegin, "开始时间");
                        pvCustomTime.show();

                    }
                });

                FollowTimeEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        initCustomTimePicker(FollowTimeEnd, "结束时间");
                        pvCustomTime.show();

                    }
                });

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

                switch (layoutId) {

                    case R.layout.pop_view_customer_screening:

                        break;


                    case R.layout.pop_view_non_customer_screening:
                        ImageView btnCoachPos = (ImageView) contentView.findViewById(R.id.btn_coach_pos);
                        ImageView btnCoachTrack = (ImageView) contentView.findViewById(R.id.btn_coach_track);


//                        ImageView btnTypeCard = (ImageView) contentView.findViewById(R.id.btn_type_card);
                        btnCoachPos.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //pos教练

                                intent.putExtra(mStrType, POSTEACHERLISTID);
                                startActivityForResult(intent, POSTEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();


                            }
                        });

                        btnCoachTrack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //跟进教练

                                intent.putExtra(mStrType, CONTACTTEACHERLISTID);
                                startActivityForResult(intent, CONTACTTEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();

                            }
                        });


                        break;


                    case R.layout.pop_view_members_screening:
                        ImageView btnCoachPosMembers = (ImageView) contentView.findViewById(R.id.btn_coach_pos);
                        ImageView btnCoachTrackMembers = (ImageView) contentView.findViewById(R.id.btn_coach_track);
                        ImageView btnCollect = (ImageView) contentView.findViewById(R.id.btn_collect);

//                        ImageView btnTypeCard = (ImageView) contentView.findViewById(R.id.btn_type_card);


                        btnCoachPosMembers.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //pos教练

                                intent.putExtra(mStrType, POSTEACHERLISTID);
                                startActivityForResult(intent, POSTEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();

                            }
                        });


                        btnCoachTrackMembers.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (departmentId == 1 && textDepartment.getText().equals("部门")) {
                                    //跟进教练
                                    intent.putExtra(mStrType, CONTACTTEACHERLISTID);
                                    startActivityForResult(intent, CONTACTTEACHERLISTID);//使用时需定义变量requestCode
//                                    popupWindow.dismiss();
                                } else if (personType.equals("会籍")) {
                                    intent.putExtra(mStrType, CONTACTTEACHERLISTID);
                                    startActivityForResult(intent, CONTACTTEACHERLISTID);//使用时需定义变量requestCode

                                }
                            }
                        });

                        btnCollect.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //采集人

                                intent.putExtra(mStrType, CREATEUSERLISTID);
                                startActivityForResult(intent, CREATEUSERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();

                            }
                        });

                        break;

                    case R.layout.pop_view_private_members_screening:


                        ImageView btnCoachPosMembersPrivate = (ImageView) contentView.findViewById(R.id.btn_coach_pos);

                        ImageView btnCoachTrackMembersPrivate = (ImageView) contentView.findViewById(R.id.btn_coach_track);

                        ImageView btnNameClass = (ImageView) contentView.findViewById(R.id.btn_name_class);//课程名称

                        ImageView btnTypeClass = (ImageView) contentView.findViewById(R.id.btn_type_class);//课程类型

                        ImageView btnCoachSigning = (ImageView) contentView.findViewById(R.id.btn_coach_signing);//预约教练

                        ImageView btnCoachClass = (ImageView) contentView.findViewById(R.id.btn_coach_class);//上课教练

//                        ImageView btnTypeCard = (ImageView) contentView.findViewById(R.id.btn_type_card);


                        btnCoachPosMembersPrivate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                //pos教练


                                intent.putExtra(mStrType, POSTEACHERLISTID);


                                startActivityForResult(intent, POSTEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();


                            }
                        });
                        btnCoachTrackMembersPrivate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //跟进教练


                                intent.putExtra(mStrType, CONTACTTEACHERLISTID);

                                startActivityForResult(intent, CONTACTTEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();

                            }
                        });
                        btnCoachClass.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //上课教练


                                intent.putExtra(mStrType, LESSONTEACHERLISTID);

                                startActivityForResult(intent, LESSONTEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();

                            }
                        });
                        btnCoachSigning.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //上课教练


                                intent.putExtra(mStrType, SALETEACHERLISTID);

                                startActivityForResult(intent, SALETEACHERLISTID);//使用时需定义变量requestCode
//                                popupWindow.dismiss();

                            }
                        });

                        btnTypeClass.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //课程类型


                                intent.putExtra(mStrType, CLASSTYPEID);

                                startActivityForResult(intent, CLASSTYPEID);//使用时需定义变量requestCode

//                                popupWindow.dismiss();
                            }
                        });
                        btnNameClass.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //课程名称


                                if (mPostCustomerListBean.getClassTypeId() == null) {

                                    s(context, "请先选择课程种类");


                                } else {

                                    intent.putExtra(mStrType, CLASSNAMEID);

                                    intent.putExtra(PUT_STR + "id", mPostCustomerListBean.getClassTypeId());

                                    startActivityForResult(intent, CLASSNAMEID);//使用时需定义变量requestCode
//                                    popupWindow.dismiss();

                                }


                            }
                        });

                        break;


                }


                btnReferences.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //介绍人


                        intent.putExtra(mStrType, CUSTOMERINTRODUCERID);


//                        startActivity(intent);
                        startActivityForResult(intent, CUSTOMERINTRODUCERID);//使用时需定义变量requestCode
//                        popupWindow.dismiss();

                    }
                });
                btnSource.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //

                        intent.putExtra(mStrType, CUSTOMERSOURCEID);

//                        startActivity(intent);
                        startActivityForResult(intent, CUSTOMERSOURCEID);//使用时需定义变量requestCode
//                        popupWindow.dismiss();

                    }
                });
                btnIntention.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //客户意向

                        intent.putExtra(mStrType, CUSTOMERINTENTID);

//                        startActivity(intent);
                        startActivityForResult(intent, CUSTOMERINTENTID);//使用时需定义变量requestCode
//                        popupWindow.dismiss();

                    }
                });


                btnreset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mPostCustomerListBean != null) {
                            mPostCustomerListBean = null;
                        }
                        mPostCustomerListBean = new PostCustomerListBean();
                        //自动赋值
                        mPostCustomerListBean = (PostCustomerListBean) map2Bean(check(mContext));

                        final TextView FollowTimeEnd = (TextView) contentView.findViewById(R.id.first_time_end);
                        final TextView FollowTimeBegin = (TextView) contentView.findViewById(R.id.first_time_begin);

                        final TextView TimeEnd = (TextView) contentView.findViewById(R.id.second_time_end);
                        final TextView TimeBegin = (TextView) contentView.findViewById(R.id.second_time_begin);


                        FollowTimeBegin.setText("开始时间");
                        FollowTimeEnd.setText("结束时间");
                        TimeBegin.setText("开始时间");
                        TimeEnd.setText("结束时间");


                        textLabel.setText(mPostCustomerListBean.getLabelName());//标签
                        textConsultant.setText(mPostCustomerListBean.getOwnManagerName());//会籍顾问
                        textReferences.setText(mPostCustomerListBean.getIntroduceMemberName());//介绍人
                        textIntention.setText(mPostCustomerListBean.getIntentName());//意向
                        textSource.setText(mPostCustomerListBean.getSourceName());//来源
                        btnSexNull.setChecked(true);
                        if (IsDepartManager == 0 || (IsDepartManager == 1 && textDepartment.getText().equals("我的"))) {
                            if (personType.equals("会籍")) {
                                textConsultant.setText(userName);//会籍顾问
                                ImageView imageView = (ImageView) contentView.findViewById(R.id.btn_consultant);
                                imageView.setVisibility(View.INVISIBLE);
                                btnConsultant.setEnabled(false);
                            } else if (personType.equals("教练")) {
                                if (layoutId != R.layout.pop_view_customer_screening) {
                                    TextView textView = (TextView) contentView.findViewById(R.id.text_coach_track);
                                    textView.setText(userName);//会籍顾问
                                    ImageView imageView = (ImageView) contentView.findViewById(R.id.btn_coach_track);
                                    imageView.setVisibility(View.INVISIBLE);

                                }

                            }
                        }
//
//                        if (layoutId != R.layout.pop_view_customer_screening) {
//                            TextView textCoachTrack = (TextView) contentView.findViewById(R.id.text_coach_track);
//                            textCoachTrack.setText(mPostCustomerListBean.getOwnTeacherName());//跟蹤教練
//                        }
                        //客户列表

//                        textLabel.setText(mPostCustomerListBean.getLabelName());//标签
//                        textConsultant.setText(mPostCustomerListBean.getOwnManagerName());//会籍顾问
//                        textReferences.setText(mPostCustomerListBean.getIntroduceMemberName());//介绍人
//                        textIntention.setText(mPostCustomerListBean.getIntentName());//意向
//                        textSource.setText(mPostCustomerListBean.getSourceName());//来源
                        switch (layoutId) {

                            case R.layout.pop_view_customer_screening:

                                textCollect.setText(mPostCustomerListBean.getCreateUserId());//采集人
                                break;
                            case R.layout.pop_view_non_customer_screening:
                                //过期会员列表
                                TextView textCoachPos = (TextView) contentView.findViewById(R.id.text_coach_pos);
//                                    TextView textCoachTrack = (TextView) contentView.findViewById(R.id.text_coach_track);
                                textCoachPos.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
//                                    textCoachTrack.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练

                                textCollect.setText(mPostCustomerListBean.getCreateUserId());//采集人
                                break;
                            case R.layout.pop_view_members_screening:
                                //会员列表
                                TextView textCoachPosMembers = (TextView) contentView.findViewById(R.id.text_coach_pos);
//                                    TextView textCoachTrackMembers = (TextView) contentView.findViewById(R.id.text_coach_track);
                                TextView btnCollectMembers = (TextView) contentView.findViewById(R.id.text_collect);
                                textCoachPosMembers.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
//                                    textCoachTrackMembers.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
                                btnCollectMembers.setText(mPostCustomerListBean.getCreateUserName());
                                break;

                            case R.layout.pop_view_private_members_screening:
                                TextView textCoachPosMembersPrivate = (TextView) contentView.findViewById(R.id.text_coach_pos);
//                                    TextView textCoachTrackMembersPrivate = (TextView) contentView.findViewById(R.id.text_coach_track);
                                TextView textNameClass = (TextView) contentView.findViewById(R.id.text_name_class);//课程名称
                                TextView textTypeClass = (TextView) contentView.findViewById(R.id.text_type_class);//课程类型
                                TextView textCoachSigning = (TextView) contentView.findViewById(R.id.text_coach_signing);//预约教练
                                TextView textCoachClass = (TextView) contentView.findViewById(R.id.text_coach_class);//上课教练
                                textCoachPosMembersPrivate.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
//                                    textCoachTrackMembersPrivate.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
                                textNameClass.setText(mPostCustomerListBean.getClassName());//课程名称
                                textTypeClass.setText(mPostCustomerListBean.getClassTypeIdName());//课程类型
                                textCoachSigning.setText(mPostCustomerListBean.getSigninTeacherName());//预约教练
                                textCoachClass.setText(mPostCustomerListBean.getClassTeacherName());//上课教练
                                break;

                        }


                        popupWindow.update();
//                        refresh();

                    }
                });

                btnconfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        popupWindow.dismiss();
                        refresh();


                    }
                });


                btnSexMen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mPostCustomerListBean.setSex("1");
                        btnSexMen.setChecked(true);
                        btnSexWomen.setChecked(false);
                        popupWindow.update();

                    }
                });


                btnSexWomen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mPostCustomerListBean.setSex("0");
                        btnSexWomen.setChecked(true);
                        btnSexMen.setChecked(false);
                        popupWindow.update();
                    }
                });


                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });


        if (IsDepartManager == 0 || (IsDepartManager == 1 && textDepartment.getText().equals("我的"))) {
            if (personType.equals("会籍")) {
                textConsultant.setText(userName);//会籍顾问
                ImageView imageView = (ImageView) contentView.findViewById(R.id.btn_consultant);
                imageView.setVisibility(View.INVISIBLE);
                btnConsultant.setEnabled(false);
            } else if (personType.equals("教练")) {
                if (layoutId != R.layout.pop_view_customer_screening) {
                    TextView textView = (TextView) contentView.findViewById(R.id.text_coach_track);
                    textView.setText(userName);//会籍顾问
                    ImageView imageView = (ImageView) contentView.findViewById(R.id.btn_coach_track);
                    imageView.setVisibility(View.INVISIBLE);

                }

            }
        }


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

    public void UserEditPopup(View v, final int
            tag) {


        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
        final int[] mID = new int[1];

        // 一个自定义的布局，作为显示的内容
        String userType = "";
        datas = new ArrayList<>();
        backgroundAlpha(0.5f);


        contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_publicsea_thrown, null);

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

        final TextView textTitle = (TextView) contentView.findViewById(R.id.text_title);
        final Spinner list = (Spinner) contentView.findViewById(R.id.list);
        final TextView textCause = (TextView) contentView.findViewById(R.id.text_cause);
        final Button btn = (Button) contentView.findViewById(R.id.button);
        textTitle.setText((tag == 0 ? " 抛入公海" : " 变更会籍"));

        if (tag == 2) textTitle.setText("变更跟进教练");

        switch (tag) {
            case 0:
                arrModel = String2Bean(SpUtil.get(context, PUBLICSEATYPEKEY, "").toString());
                if (personType.equals("教练")) {
                    list.setVisibility(View.GONE);
                }
                break;
            case 1:
                arrModel = String2Bean(SpUtil.get(context, MANGERLISTKEY, "").toString());
                textCause.setVisibility(View.GONE);
                break;
            case 2:
                arrModel = String2Bean(SpUtil.get(context, CONTACTTEACHERLISTKEY, "").toString());
                textCause.setVisibility(View.GONE);
                break;


        }

        String[] arrM = new String[arrModel.size()];//


        for (int i = 0; i < arrModel.size(); i++) {
            arrM[i] = arrModel.get(i).getName().toString();
        }

//         mID[0] = arrModel.get(0).getID();

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

        final String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        final String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        final int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Intent intent = new Intent(CustomerListActivity.this, FilterListActivity.class);
                final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        switch (type) {

                            case ACTIVITY_ID_CUSTOMER:
                                if (tag == 0) {
                                    mPresenter.appThrowCustomerPublicSea(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]), textCause.getText().toString());
                                } else {
                                    mPresenter.appUpdateOwnManagerId(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]));
                                }

                                break;

                            case ACTIVITY_ID_NON_CUSTOMER:

                                if (tag == 0) {
                                    mPresenter.appThrowCustomerPublicSea(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]), textCause.getText().toString());
                                } else {
                                    mPresenter.appUpdateOwnManagerId(UserId, UserName, token, ClubId, toidstring(mSelectdatas), String.valueOf(mID[0]));
                                }
                                break;
                            case ACTIVITY_ID_MEMBERS:

                                if (tag == 0) {
                                    mPresenter.appThrowMemberPublicSea(UserId, UserName, token, ClubId, toidstring(mMSelectdatas), String.valueOf(mID[0]), textCause.getText().toString());
                                } else if (tag == 2) {
                                    mPresenter.updateMemberOwnTeacherBatch(UserId, UserName, token, ClubId, toidstring(mMSelectdatas), String.valueOf(mID[0]));
                                } else {
                                    mPresenter.updateMemberOwnManagerBatch(UserId, UserName, token, ClubId, toidstring(mMSelectdatas), String.valueOf(mID[0]));
                                }


                                break;

                            case ACTIVITY_ID_PRIVATE_MEMBERS:

                                if (tag == 0) {
                                    mPresenter.appThrowMemberPublicSea(UserId, UserName, token, ClubId, toidstring(mMSelectdatas), String.valueOf(mID[0]), textCause.getText().toString());
                                } else if (tag == 2) {
                                    mPresenter.updateLessonMemberOwnTeacherBatch(UserId, UserName, token, ClubId, toidstring(mLessonSelectdatas), String.valueOf(mID[0]));
                                } else {
                                    mPresenter.updateMemberOwnManagerBatch(UserId, UserName, token, ClubId, toidstring(mMSelectdatas), String.valueOf(mID[0]));
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
    public void PublicSeasucceed(String Msg) {
        s(this, Msg);
        for (int i = 0; i < mSelectedArr.size(); i++) {
            mSelectedArr.set(i, 0);
        }
        popupWindow.dismiss();
        editShow = false;
        btnEdit.setText("编辑");
        linearLayoutBottom.setVisibility(View.GONE);

        refresh();
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

        if (requestCode == CUSTOMERTAGID) {

            mPostCustomerListBean.setLabelId(mId);

            mPostCustomerListBean.setLabelName(mName);

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

        if (requestCode == LESSONTEACHERLISTID) {

            mPostCustomerListBean.setClassTeacherId(mId);

            mPostCustomerListBean.setClassTeacherName(mName);

        }

        if (requestCode == SALETEACHERLISTID) {

            mPostCustomerListBean.setSigninTeacherId(mId);

            mPostCustomerListBean.setSigninTeacherName(mName);

        }
        if (requestCode == CLASSTYPEID) {

            mPostCustomerListBean.setClassTypeId(mId);

            mPostCustomerListBean.setClassTypeIdName(mName);

        }
        if (requestCode == CLASSNAMEID) {

            mPostCustomerListBean.setClassId(mId);

            mPostCustomerListBean.setClassName(mName);

        }
        if (requestCode == LESSONLISTBYMEMBERKEY) {

            mPostCustomerListBean.setLessonTeacherId(mId);

            mPostCustomerListBean.setLessonTeacherName(mName);


            btnEdit.setText("编辑");

            linearLayoutBottom.setVisibility(View.GONE);

            editShow = false;

            commonAdapter.notifyDataSetChanged();

            for (int i = 0; i < mSelectdatas.size(); i++) {
                mSelectdatas.set(i, "0");
                mMSelectdatas.set(i, "0");
                mLessonSelectdatas.set(i, "0");

            }


            refresh();


        } else {

            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    ScreenPopup(screeningBtn, 0);
//                    popupWindow.update();

                }
            };
            handler.post(runnable);
        }


        //// TODO: 2017/6/5 办卡类型未实现
//        if (requestCode == ALLMEMBERCARDTYPEID ) {
//
//            mPostCustomerListBean.set(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }


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
