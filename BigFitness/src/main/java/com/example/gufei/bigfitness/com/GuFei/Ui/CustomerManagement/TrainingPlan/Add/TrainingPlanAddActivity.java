package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add;

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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.ActionBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainActionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBeanM;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection.SiteSelectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List.TrainingPlanListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.LinearLayout.VERTICAL;
import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TPREFRESHID;
import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class TrainingPlanAddActivity extends BaseActivity<TrainingPlanAddActivityPresenter> implements TrainingPlanAddActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;

    @BindView(R.id.activity_training_plan_add)

    LinearLayout activityTrainingPlanAdd;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.btn)
    Button btn;

    private View contentView;
    private boolean EditN = true;

    private PopupWindow popupWindow;
    String PositionId = "";
    String PositionName = "";


//    List<Boolean> selectArr = new ArrayList<Boolean>();

    private CommonAdapter<TrainActionDropListBean.ResultBean> commonAdapter;


    private List<TrainActionDropListBean.ResultBean> datas = new ArrayList<TrainActionDropListBean.ResultBean>();
    private List<ActionBean.ListBean> list = null;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_training_plan_add;
    }


    @Override
    protected void initView() {

        EditN = true;
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("选择动作");
        btnComplete.setText("确定");
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<TrainActionDropListBean.ResultBean>(R.layout.cardview_training_plan_add, this, datas) {
            @Override
            protected void convert(final ViewHolder holder, final TrainActionDropListBean.ResultBean listBean, final int i) {
                holder.setText(R.id.plan_text_content, listBean.getName());

                if (!(listBean.getNumber().equals("") && listBean.getGroup().equals(""))) {
                    holder.setText(R.id.plan_text_num, listBean.getNumber() + "*" + listBean.getGroup() + "组");
                } else {
                    holder.setText(R.id.plan_text_num, "");
                }


                if (listBean.isSelected()) {
                    holder.setImage(R.id.btn_Training_add_select).setImageResource(R.mipmap.addaction_selected);
                } else {
                    holder.setImage(R.id.btn_Training_add_select).setImageResource(R.mipmap.addaction_select);
                }

                holder.getView(R.id.btn_Training_add_select).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (datas.get(i).getGroup().equals("") || datas.get(i).getNumber().equals("")) {
                            s(mContext,"请填写计划的数量与组数");
                        } else {
                            listBean.setSelected(!listBean.isSelected());

                            commonAdapter.notifyDataSetChanged();
                        }



                    }
                });


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditPopup(v, i);


                    }
                });

            }


        };


        recyclerView.setAdapter(commonAdapter);

        final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(this, VERTICAL, true, datas.size()) {
            @Override
            public boolean canScrollVertically() {

                //{｝内部分可以开启滑动
                return false;
            }
        };

        layoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        commonAdapter.setShowFooter(false);
//        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
//            //获取列表华东监听器 用于获取当前所在条数
//            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//
//            //添加滚动条见监听器
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
//                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
//
//
////                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
////
////                        isLoadingMore = false;
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
    public void succeed(TrainActionDropListBean trainActionDropListBean) {

        Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, PositionId);
        if (object != null) {
            list = (List<ActionBean.ListBean>) object;
        }
        try {
            datas = trainActionDropListBean.getResult();
//            for (int i = 0; i < datas.size(); i++) {
//                selectArr.add(false);
//            }
            if (list != null) {
                if (list.size() > 0) {
                    for (int j = 0; j < datas.size(); j++) {
                        for (int i = 0; i < list.size(); i++) {
                     /*       datas.get(j).setSelected(false);*/
                            if (list.get(i).getActionId().equals(datas.get(j).getId() + "")) {
                                datas.get(j).setSelected(list.get(i).isSelected());
                                datas.get(j).setGroup(list.get(i).getGroupCount());
                                datas.get(j).setNumber(list.get(i).getAmount());
                            }

                        }


                    }
                }
            }
            commonAdapter.replaceData(datas);


        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    @Override
    public void succeedAdd(CodeBean codeBean) {
        refresh();
    }

    public void refresh() {


        Intent intent = getIntent();
        PositionId = intent.getStringExtra(PUT_STR + "Id");
        PositionName = intent.getStringExtra(PUT_STR + "Name");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        mPresenter.getTrainActionDropList(UserName, UserId, token, ClubId, PositionId);


    }


    @Override
    protected void initData() {

        refresh();

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
    protected void onDestroy() {
        super.onDestroy();

        List<ActionBean.ListBean> resultlist = new ArrayList<ActionBean.ListBean>();

        for (int i = 0; i < datas.size(); i++) {
//            if (selectArr.get(i).booleanValue()) {
            ActionBean.ListBean bean = new ActionBean.ListBean();
            bean.setPositionId(PositionId);//部位ID
            bean.setPositionName(PositionName);//部位名称
            bean.setActionId(String.valueOf(datas.get(i).getId()));//动作ID
            bean.setActionName(String.valueOf(datas.get(i).getName()));//动作名称
            bean.setGroupCount(String.valueOf(datas.get(i).getGroup()));
            bean.setAmount(String.valueOf(datas.get(i).getNumber()));
            if (!(bean.getGroupCount().toString().equals("") && bean.getAmount().toString().equals(""))) {
                bean.setSelected(true);
            } else {
                bean.setSelected(false);
            }
            resultlist.add(bean);

//            }
        }

//        if (EditN) {
           SharedPreferenceUtil.save(TRAININGPLANKEY, PositionId, resultlist);
     //   }
//
////        SharedPreferenceUtil.save(TRAININGPLANKEY, "result", resultlist);
//        Intent resultIntent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putString(RESULT_ID, "00");
//        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
//        resultIntent.putExtras(bundle);
//        this.setResult(RESULT_OK, resultIntent);

    }

    @OnClick({R.id.btn_complete, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:
                EditN = false;
                List<ActionBean.ListBean> resultlist = new ArrayList<ActionBean.ListBean>();
                Object object = SharedPreferenceUtil.get(TRAININGPLANKEY, "result");
                List<String> SiteArr = new ArrayList<String>();
//                List<Integer> SiteArrId = new ArrayList<Integer>();
                if (object != null) {
                    resultlist = (List<ActionBean.ListBean>) object;
                } else {

                }

                for (int i = 0; i < resultlist.size(); i++) {
                    if (!SiteArr.contains(resultlist.get(i).getActionId())) {
                        SiteArr.add(resultlist.get(i).getActionId());
//                            SiteArrId.add(i);
                    }

                }

                for (int i = 0; i < datas.size(); i++) {
                    if (datas.get(i).isSelected()) {
                        ActionBean.ListBean bean = new ActionBean.ListBean();
                        bean.setPositionId(PositionId);//部位ID
                        bean.setPositionName(PositionName);//部位名称
                        bean.setActionId(String.valueOf(datas.get(i).getId()));//动作ID
                        bean.setActionName(String.valueOf(datas.get(i).getName()));//动作名称
                        bean.setGroupCount(String.valueOf(datas.get(i).getGroup()));
                        bean.setAmount(String.valueOf(datas.get(i).getNumber()));
                        if (!(bean.getGroupCount().toString().equals("") && bean.getAmount().toString().equals(""))) {
                            bean.setSelected(true);
                        } else {
                            bean.setSelected(false);
                        }
                        boolean b = false;
                        int n = 9999;
                        for (int j = 0; j < resultlist.size(); j++) {
                            if (String.valueOf(datas.get(i).getId()).equals(resultlist.get(j).getActionId())) {
                                b = true;
                                n = j;
                                break;
                            }
                        }

                        if (b) {
                            resultlist.set(n, bean);
                        } else {
                            resultlist.add(bean);
                        }

                    }
                }


                SharedPreferenceUtil.save(TRAININGPLANKEY, "result", resultlist);
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(RESULT_ID, "99");
                bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
                resultIntent.putExtras(bundle);
                this.setResult(RESULT_OK, resultIntent);

                finish();
                break;
            case R.id.btn:
                AddPopup(view, 0);
                break;
        }
    }

    public void EditPopup(View v, final int tag) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        backgroundAlpha(0.5f);
        contentView = LayoutInflater.from(this).inflate(R.layout.pop_view_add_action_num, null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        final EditText editActionGroup = (EditText) contentView.findViewById(R.id.edit_action_group);
        final EditText editActionNum = (EditText) contentView.findViewById(R.id.edit_action_num);
        final TextView textCause = (TextView) contentView.findViewById(R.id.text_cause);
        final Button btn = (Button) contentView.findViewById(R.id.btn);
        String GroupNum = "0";
        String ActionNum = "0";
        GroupNum = datas.get(tag).getGroup().equals("") ? "" : datas.get(tag).getGroup();
        ActionNum = datas.get(tag).getNumber().equals("") ? "" : datas.get(tag).getNumber();

        editActionGroup.setText(GroupNum);
        editActionNum.setText(ActionNum);

        popupWindow.update();
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datas.get(tag).setGroup(editActionGroup.getText().toString());
                        datas.get(tag).setNumber(editActionNum.getText().toString());
                        commonAdapter.notifyDataSetChanged();
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


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
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
        textTitle.setText("添加自定义动作");
//
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
                            s(TrainingPlanAddActivity.this, "请填写自定义动作名称");
                        } else {
                            mPresenter.saveTrainAction(UserName, UserId, token, ClubId, textName.getText().toString(), PositionId);
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


}
