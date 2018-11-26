package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.ActionBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainPositionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add.TrainingPlanAddActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.REFRESHID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class SiteSelectionActivity extends BaseActivity<SiteSelectionActivityPresenter> implements SiteSelectionActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.btn_site_add)
    Button btnSiteAdd;
    @BindView(R.id.activity_training_plan_add)
    LinearLayout activityTrainingPlanAdd;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private boolean NoSave = false;
    private View contentView;
    private PopupWindow popupWindow;
    private CommonAdapter<TrainPositionDropListBean.ResultBean> commonAdapter;
    private List<TrainPositionDropListBean.ResultBean> datas = new ArrayList<TrainPositionDropListBean.ResultBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_site_selection;

    }

    @Override
    protected void initView() {
        final Intent intent = getIntent();
        final String MemberId = intent.getStringExtra(PUT_STR + "id");
        final String AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        final String LessonId = intent.getStringExtra(PUT_STR + "LessonId");
        datas = new ArrayList<>();
        btnComplete.setVisibility(View.INVISIBLE);
        commonAdapter = new CommonAdapter<TrainPositionDropListBean.ResultBean>(R.layout.cardview_site_list, this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final TrainPositionDropListBean.ResultBean listBean, int i) {
                holder.setText(R.id.text_name, listBean.getName());//名称
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, TrainingPlanAddActivity.class);
                        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
                        intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getId()));
                        intent.putExtra(PUT_STR + "Name", String.valueOf(listBean.getName()));
                        intent.putExtra(PUT_STR + "id", MemberId);
                        intent.putExtra(PUT_STR + "AppointmentId", AppointmentId);
                        intent.putExtra(PUT_STR + "LessonId", String.valueOf(LessonId));
                        intent.putExtra(mStrType, REFRESHID);
                        startActivityForResult(intent, REFRESHID);//使用时需定义变量requestCode
                    }
                });
////

            }


        };
        commonAdapter.setShowFooter(false);
        recyclerView.setAdapter(commonAdapter);
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
    public void succeed(TrainPositionDropListBean trainPositionDropListBean) {

        try {
            datas = trainPositionDropListBean.getResult();
            commonAdapter.replaceData(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedPreferenceUtil.save(TRAININGPLANKEY, "resultSite", datas);
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
    public void succeedAdd(CodeBean codeBean) {
        refresh();
    }

    private void refresh() {
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
        mPresenter.getTrainPositionDropList(UserName, UserId, token, ClubId);
    }

    @Override
    protected void onDestroy() {
        if (!NoSave) {
//            saveData();
        }
        super.onDestroy();
    }

    public void saveData() {
        List<ActionBean.ListBean> resultlist = new ArrayList<ActionBean.ListBean>();
        for (int i = 0; i < datas.size(); i++) {
            List<ActionBean.ListBean> temp = new ArrayList<ActionBean.ListBean>();
            Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, String.valueOf(datas.get(i).getId()));
            if (object != null) {
                temp = (List<ActionBean.ListBean>) object;
            }

            if (temp.size() > 0) {
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j).isSelected()) {
                        resultlist.add(temp.get(j));
                    }
                }
            }
        }

        SharedPreferenceUtil.save(TRAININGPLANKEY, "result", resultlist);
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_ID, "00");
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);


    }

    public void AddPopup(View v, final int tag) {
        backgroundAlpha(0.5f);
        contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_add_action, null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        final EditText textName = (EditText) contentView.findViewById(R.id.edit_action_name);
        final TextView textTitle = (TextView) contentView.findViewById(R.id.text_title);
        textTitle.setText("添加自定义部位");
        final Button btn = (Button) contentView.findViewById(R.id.btn);
        popupWindow.update();
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                        if (textTitle.getText().toString().equals("")) {
                            s(SiteSelectionActivity.this, "请填写自定义部位名称");
                        } else {
                            mPresenter.saveTrainPosition(UserName, UserId, token, ClubId, textName.getText().toString());
                        }
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
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//            }
        }

        if (requestCode == REFRESHID) {
            if (mId.equals(99 + "")) {
//                saveData();
                NoSave = true;
                finish();
                return;
            }
            refresh();


        }

    }


    @OnClick({R.id.btn_complete, R.id.btn_site_add, R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:
//                saveData();
                finish();
                break;
            case R.id.btn_site_add:
                AddPopup(view, 0);
                break;
            case R.id.btn_back:
//                saveData();
                finish();
                break;
        }
    }


}
