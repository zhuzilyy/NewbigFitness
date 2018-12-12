package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.Constants;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateForOrderBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ClassOverBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ResultBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.TimeUtil.getTime;

public class ListFragment extends BaseFragment<LIstPresenter> implements ListContract.View {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
    Unbinder unbinder;


//    @BindView(R.id.mon_scroll_view)


    private CommonAdapter<AppointmentListByDateForOrderBean.ResultBean> commonAdapter;


    private List<AppointmentListByDateForOrderBean.ResultBean> datas = new ArrayList<AppointmentListByDateForOrderBean.ResultBean>();

    private boolean isLoadingMore = true;//加载标志位

    private int UpPage = 0;

    private int DownPage = 0;

    private String UpDownMark = "up";


    String UserName;

    int UserId;

    String token;

    int ClubId;

    int IsDepartManager;

    int DepartId;
    int MemberId;
    int AppointmentId;
    int IsHistory;// 1是历史记录，0是预约记录
    SimpleDateFormat format;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private Context context;
    private FragMentListening fragMentListening;


    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
        fragMentListening = (FragMentListening) mActivity;
    }
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_schedule_list;
    }


    public void RefreshData() {

        UpDownMark = "down";
        UpPage = 0;
        DownPage = 0;
        UpDownLoading();
    }

    @Override
    protected void initData() {


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragMentListening.BtnBack();
            }
        });
        UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);
        datas = new ArrayList<>();
//        tvTitle.setText(string2chianStr(getDayTime(new Date())));
        tvTitle.setText("预约记录");
        btnComplete.setText("历史记录");
        btnComplete.setTag(false);
        commonAdapter = new CommonAdapter<AppointmentListByDateForOrderBean.ResultBean>(R.layout.card_schedule_list, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final AppointmentListByDateForOrderBean.ResultBean listBean, int i) {
                int appointmentStatus = listBean.getAppointmentStatus();
                int appointmentOwner = listBean.getAppointmentOwner();
                holder.setText(R.id.text_create_name, UserName);
                TextView textName = (TextView) holder.getView(R.id.text_class);
                Button btn1 = (Button) holder.getView(R.id.btn1);
                Button btn2 = (Button) holder.getView(R.id.btn2);
                Button btn3 = (Button) holder.getView(R.id.btn3);
                if (listBean.getAppointmentOwner() == 1 && listBean.getAppointmentStatus() == 0) {
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                } else {
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                }
                if (listBean.getIsSignIn() == 0) {
                    btn3.setVisibility(View.GONE);
                } else {
                    btn3.setVisibility(View.VISIBLE);
                }
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getCancelLesson(listBean.getAppointmentId(),
                                token);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getConfirmLesson(listBean.getAppointmentId(),
                                token);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RequestParams params = new RequestParams(Constants.MEMBERURL + "appMember/memberLesson/DeductionClass");
                        params.addQueryStringParameter("AppointmentId", listBean.getAppointmentId() + "");
                        params.addQueryStringParameter("ClubId", ClubId + "");
                        params.addQueryStringParameter("MemberId", listBean.getMemberId() + "");
                        params.addQueryStringParameter("token", token);
                        x.http().get(params, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                listBean.setIsSignIn(0);
                                notifyDataSetChanged();
                                ResultBean resultBean = new Gson().fromJson(result, ResultBean.class);
                                if (resultBean.getRet() == 0) {
                                    Toast.makeText(mContext, "下课结束！", Toast.LENGTH_SHORT).show();
                                    UpDownLoading();
                                } else {
                                    Toast.makeText(mContext, resultBean.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(Throwable ex, boolean isOnCallback) {

                            }

                            @Override
                            public void onCancelled(CancelledException cex) {

                            }

                            @Override
                            public void onFinished() {

                            }
                        });
                        getList();
                    }
                });
                textName.setText(listBean.getTitle());
                SpannableStringBuilder builder = new SpannableStringBuilder(textName.getText().toString());
                ForegroundColorSpan redSpan = new ForegroundColorSpan(0xFF63cd2b);
                if (listBean.getTitle() == null) {
                    Log.e("-----------", listBean.getHeaderURL());
                } else {
                    if (!listBean.getTitle().equals("")) {

                        String[] arr = listBean.getTitle().split("：");

                        builder.setSpan(redSpan, 0, arr.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        if (listBean.getMemberType().toString().equals("2")) {
                            arr[0] = "过期会员";
                            builder = new SpannableStringBuilder(arr[0] + "：" + arr[1]);
                            builder.setSpan(redSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }


                holder.setImage(R.id.img_head).setImageResource(R.mipmap.highseasmembermanage_women);
//                loadIntoUseFitWidth(context, listBean.getHeaderURL(), R.mipmap.head_img, holder.setImage(R.id.img_head));//头像
                displayCircleImage(mContext, listBean.getHeaderURL(), holder.setImage(R.id.img_head), R.mipmap.head_img);

                String tmepStr = "预约开始时间:" + listBean.getStartTime() + "\n";
                tmepStr += "预约结束时间:" + listBean.getEndTime() + "\n";
                tmepStr += "预约结果:" + listBean.getAppointmentResultName() + "\n";
                tmepStr += "备注:" + listBean.getContent() + "\n";

                holder.setText(R.id.text_content, tmepStr);
                holder.setText(R.id.text_time, listBean.getCreateTime());

                textName.setText(builder);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppointmentId = listBean.getAppointmentId();
                        if (!listBean.getMemberType().toString().equals("3")) {


                            Intent intent = new Intent(context, ReservationRecordMembersActivity.class);

                            intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getMemberId()));
//                        intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
//                        intent.putExtra(PUT_STR + "Type", CustomerType);
//                            intent.putExtra(PUT_STR + "CreateUserId", listBean.getCreateUserId());
                            intent.putExtra(PUT_STR + "AppointmentType", listBean.getAppType());
                            intent.putExtra(PUT_STR + "MemberType", listBean.getMemberType());
                            intent.putExtra(PUT_STR + "Sex", "女");
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(listBean.getAppointmentId()));

                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(context, ReservationRecordActivity.class);
                            intent.putExtra(PUT_STR + "Id", String.valueOf(listBean.getMemberId()));
                            intent.putExtra(PUT_STR + "Sex", "女");
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(listBean.getAppointmentId()));
                            startActivity(intent);

                        }

                    }
                });


            }


        };


        recyclerView.setAdapter(commonAdapter);

        commonAdapter.setShowFooter(false);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);

        recyclerView.setLayoutManager(layoutManager);

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);


        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                if (tvTitle.getText().toString().equals("预约记录")) {
                    DownPage = 1;
                    UpPage = 0;
//                UpLoading();
//                    UpDownMark = "down";
                    IsHistory = 0;
                    UpDownLoading();
                } else {
                    DownPage = 1;
                    UpPage = 0;
//                UpLoading();
                    IsHistory = 1;
                    UpDownLoading();

                }

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
                    } else {
                        if (isLoadingMore && totalItemCount - 2 == 0) {
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

//                            UpLoading();
                        }


                    }
                }
            });

        }
        DownPage = 1;
        IsHistory = 0;
        UpDownLoading();
    }

    private void getList() {
//        mPresenter.getClassOver(
//                AppointmentId,
//                ClubId,
//                MemberId,
//                token
//        );
    }

    private void UpLoading() {
        UpDownMark = "up";
        UpPage++;
//        DownPage++;
        UpDownLoading();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(context, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void Loading() {

    }

    @Override
    public void succeed(AppointmentListByDateForOrderBean appointmentListByDateForOrderBean) {
        swipeRefreshLayout.setRefreshing(false);
        isLoadingMore = true;
        try {
            datas = appointmentListByDateForOrderBean.getResult();

//            if (datas.size() == 0){
//                tvNoMore.setVisibility(View.VISIBLE);
//            }else {
//                tvNoMore.setVisibility(View.GONE);
                if (DownPage == 1 && UpPage == 0) {
                    commonAdapter.replaceData(datas);
                } else {
                    if (UpDownMark.equals("down")) {
                        commonAdapter.insertData(datas);
                    } else {
                        commonAdapter.addItems(datas, 0);
                    }
//                tvTitle.setText(string2chianStr(appointmentListByDateForOrderBean.getResult().get(0).getStartTime()));
                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void classsucceed(ClassOverBean classOverBean) {
        Toast.makeText(getActivity(), "下课结束！", Toast.LENGTH_SHORT).show();
        UpDownLoading();
    }

    @Override
    public void cancelsucceed(CodeBean codeBean) {
        Toast.makeText(getActivity(), "取消成功！", Toast.LENGTH_SHORT).show();
        UpDownLoading();
    }

    @Override
    public void confirmsucceed(CodeBean codeBean) {
        Toast.makeText(getActivity(), "确认成功！", Toast.LENGTH_SHORT).show();
        UpDownLoading();
    }


    private void UpDownLoading() {
        mPresenter.getAppointmentListByDateForOrder(
                UserId,
                token,
                ClubId,
                String.valueOf(IsDepartManager),
                getTime(new Date()),
                UpDownMark.equals("down") ? DownPage : UpPage,
                IsHistory,
                "up"
        );
    }


    @OnClick(R.id.btn_complete)
    public void onViewClicked() {

        if (tvTitle.getText().toString().equals("预约记录")) {
            tvTitle.setText("历史记录");
            btnComplete.setText("预约记录");
            btnComplete.setTag(false);
            UpDownMark = "down";
            DownPage = 1;
//            UpPage = 0;
            IsHistory = 1;
            UpDownLoading();

        } else {
            tvTitle.setText("预约记录");
            btnComplete.setText("历史记录");
            btnComplete.setTag(true);
            UpDownMark = "up";
            DownPage = 1;
//            UpPage = 0;
            IsHistory = 0;
            UpDownLoading();

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
