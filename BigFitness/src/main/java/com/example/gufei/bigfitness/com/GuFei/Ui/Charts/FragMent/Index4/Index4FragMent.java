package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ChartsListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherLessonRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.util.SpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

import butterknife.OnClick;


import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CLUBLISTKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERLEVELKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:排名 实现
 */


public class Index4FragMent extends BaseFragment<Index4FragMentPresenter> implements Index4FragMentContract.View {

    //
    @BindView(R.id.bar)
    RelativeLayout bar;


    ProgressDialog dialog = null;
    @BindView(R.id.title_spinner)
    Spinner spinner;
    @BindView(R.id.class_spinner)
    Spinner spinner1;

    @BindView(R.id.text_time)
    TextView textTime;//

    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.btn_time)
    LinearLayout btnTime;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;


    private TimePickerView pvCustomTime;

    private Context context;
    //    private String[] mItems = {"第一个会所", "第二个会所", "第三个会所", "第四个会所", "第五个会所", "第六个会所"};
    private String[] mItems1 = {"会员销售排行", "私教售课排行", "私教上课排行"};
    private String[] mItems2 = {"私教售课排行", "私教上课排行"};
    private CommonAdapter<MonthMemberRankingBean.ResultBean> commonAdapter;
    private CommonAdapter<MonthTeacherRankingBean.ResultBean> commonAdapter1;
    private CommonAdapter<MonthTeacherLessonRankingBean.ResultBean> commonAdapter2;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<MonthMemberRankingBean.ResultBean> datas = new ArrayList<MonthMemberRankingBean.ResultBean>();
    private List<MonthTeacherRankingBean.ResultBean> datas1 = new ArrayList<MonthTeacherRankingBean.ResultBean>();
    private List<MonthTeacherLessonRankingBean.ResultBean> datas2 = new ArrayList<MonthTeacherLessonRankingBean.ResultBean>();
    private String[] mItems;
    private boolean isLoadingMore = true;//加载标志位
    private int userid;
    private String token;
    private int clubid;
    String UserName;
    String persontype;
    String ClubList;
    int ClubId;
    int IsDepartManager;
    int filter = 0;//筛选下拉
    int filter1 = 0;//类型下拉
    List<LoginBean.ClubListBean> ArrItems = new ArrayList<LoginBean.ClubListBean>();
    String UserLevel;
    String SearchData;


//    @Override
//    public void onResume() {
//        super.onResume();
//
////        refresh();
//
//    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index4;
    }


    private void refresh() {

        IsDepartManager = (int) SpUtil.get(context, ISDERPARTMANAGERKEY, 0);
        if(ArrItems.size()>0)
        ClubList = "(" + String.valueOf(ArrItems.get(filter).getClubid()) + ")";
        if (!persontype.equals("教练")) {
            switch (filter1) {
                case 0:
                    mPresenter.getMonthMemberRanking(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData);
                    break;
                case 1:
                    mPresenter.getMonthTeacherRanking(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData);

                    break;
                case 2:
                    mPresenter.getMonthTeacherLessonRanking(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData,ClubId);
                    break;

            }
        } else {

            switch (filter1) {

                case 0:
                    mPresenter.getMonthTeacherRanking(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData);
                    break;
                case 1:
                    mPresenter.getMonthTeacherLessonRanking(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData,ClubId);

                    break;


            }


        }


    }


    @Override
    protected void initData() {
        context = this.getActivity();

        SearchData = getTime(new java.util.Date());
        textTime.setText(SearchData);

        UserName = (String) SpUtil.get(context, USERNAMEKEY, "");
        userid = (int) SpUtil.get(context, USERIDKEY, 0);
        token = (String) SpUtil.get(context, TOKENKEY, "");
        persontype = (String) SpUtil.get(context, PERSONTYPEKEY, "");
        UserLevel = String.valueOf((int) SpUtil.get(context, USERLEVELKEY, 0));
        ClubId = (int) SpUtil.get(context, CLUBIDKEY, 0);
        ArrItems = new ArrayList<LoginBean.ClubListBean>();
        ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
        }.getType());
        mItems = new String[ArrItems.size()];//必须初始化
//        mItems[0] = "全部";
        for (int i = 0; i < ArrItems.size(); i++) {
            mItems[i] = ArrItems.get(i).getClubname();
        }

        // 建立Adapter并且绑定数据源
        SpinnerArrayAdapter adapter = new SpinnerArrayAdapter(context, mItems);
        if (persontype.equals("教练"))
            mItems1 = mItems2;
        SpinnerArrayAdapter adapter1 = new SpinnerArrayAdapter(context, mItems1);
        // 建立Adapter并且绑定数据源
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // spinner 选中事件
                filter = position;
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // spinner 选中事件
                filter1 = position;
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        datas = new ArrayList<>();
        datas1 = new ArrayList<>();
        datas2 = new ArrayList<>();

//        for (int i = 0; i < 6; i++) {
//
//            ChartsListBean.ListBean bean = new ChartsListBean.ListBean();
//            bean.setTitle("asd");
//            datas.add(bean);
//
//        }


        commonAdapter = new CommonAdapter<MonthMemberRankingBean.ResultBean>(R.layout.cardview_charts_mon_list, context, datas) {
//        commonAdapter = new CommonAdapter<MultimediaBean.ResultBean>(R.layout.*appointm ent_main_cardview,this,  datas) {


            @Override
            protected void convert(final ViewHolder holder, final MonthMemberRankingBean.ResultBean listbean, final int i) {

                switch (i) {
                    case 0:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.first);
                        break;
                    case 1:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.second);
                        break;
                    case 2:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.three);
                        break;
                    default:
                        holder.setImage(R.id.img_top3).setVisibility(View.INVISIBLE);
                        holder.setText(R.id.text_top, i + "");
                        holder.getView(R.id.text_top).setVisibility(View.VISIBLE);
                        break;
                }


//                loadIntoUseFitWidth(mContext, listbean.getHeaderURL(), R.mipmap.null_img,(ImageView) holder.getView(R.id.img_head));
                displayCircleImage(mContext, listbean.getHeaderURL(), (ImageView) holder.getView(R.id.img_head), R.mipmap.head_img);
                holder.setText(R.id.text_name, listbean.getUserName());
                holder.setText(R.id.text_money, "￥" + listbean.getSaleMoney());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });


            }

        };
        commonAdapter1 = new CommonAdapter<MonthTeacherRankingBean.ResultBean>(R.layout.cardview_charts_mon_list, context, datas1) {
            @Override
            protected void convert(final ViewHolder holder, final MonthTeacherRankingBean.ResultBean listbean, final int i) {

                switch (i) {
                    case 0:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.first);
                        break;
                    case 1:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.second);
                        break;
                    case 2:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.three);
                        break;
                    default:
                        holder.setImage(R.id.img_top3).setVisibility(View.INVISIBLE);
                        holder.setText(R.id.text_top, i + "");
                        holder.getView(R.id.text_top).setVisibility(View.VISIBLE);
                        break;
                }


//                loadIntoUseFitWidth(mContext, listbean.getHeaderURL(), R.mipmap.null_img,(ImageView) holder.getView(R.id.img_head));
                displayCircleImage(context, listbean.getHeaderURL(), (ImageView) holder.getView(R.id.img_head), R.mipmap.head_img);
                holder.setText(R.id.text_name, listbean.getUserName());
                holder.setText(R.id.text_money, "￥" + listbean.getSaleMoney());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });


            }


        };

        commonAdapter2 = new CommonAdapter<MonthTeacherLessonRankingBean.ResultBean>(R.layout.cardview_charts_mon_list, context, datas2) {
            @Override
            protected void convert(final ViewHolder holder, final MonthTeacherLessonRankingBean.ResultBean listbean, final int i) {

                switch (i) {
                    case 0:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.first);
                        break;
                    case 1:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.second);
                        break;
                    case 2:
                        holder.setImage(R.id.img_top3).setImageResource(R.mipmap.three);
                        break;
                    default:
                        holder.setImage(R.id.img_top3).setVisibility(View.INVISIBLE);
                        holder.setText(R.id.text_top, i + "");
                        holder.getView(R.id.text_top).setVisibility(View.VISIBLE);
                        break;
                }


//                loadIntoUseFitWidth(mContext, listbean.getHeaderURL(), R.mipmap.null_img,(ImageView) holder.getView(R.id.img_head));
                displayCircleImage(mContext, listbean.getHeaderURL(), (ImageView) holder.getView(R.id.img_head), R.mipmap.head_img);
                holder.setText(R.id.text_name, listbean.getUserName());
                holder.setText(R.id.text_money, listbean.getLessonSum() + "");

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });


            }


        };


        recyclerView.setAdapter(commonAdapter);


        commonAdapter.setShowFooter(false);
        commonAdapter1.setShowFooter(false);
        commonAdapter2.setShowFooter(false);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                refresh();

            }


        });
        refresh();

    }

    @Override
    public void showError(String msg) {

//        noticeSystemBtn.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
//        Intent intent = new Intent(context, LoginActivity.class);
//        startActivity(intent);
    }


    @Override
    public void Loading() {

    }


//    }

    @Override
    public void succeed(MonthMemberRankingBean monthMemberRankingBean) {

        recyclerView.setAdapter(commonAdapter);
        swipeRefreshLayout.setRefreshing(false);
        datas = monthMemberRankingBean.getResult();
        commonAdapter.replaceData(datas);

    }

    @Override
    public void succeed1(MonthTeacherRankingBean monthTeacherRankingBean) {
        recyclerView.setAdapter(commonAdapter1);
        swipeRefreshLayout.setRefreshing(false);
        datas1 = monthTeacherRankingBean.getResult();
        commonAdapter1.replaceData(datas1);
    }

    @Override
    public void succeed2(MonthTeacherLessonRankingBean monthTeacherLessonRankingBean) {
        recyclerView.setAdapter(commonAdapter2);
        swipeRefreshLayout.setRefreshing(false);
        datas2 = monthTeacherLessonRankingBean.getResult();
        commonAdapter2.replaceData(datas2);

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
        pvCustomTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调

                view.setText(getTime(date));
                SearchData = getTime(date);
                refresh();



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
                .setLayoutRes(R.layout.pickerview_charts_mon_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        TextView ivClear = (TextView) v.findViewById(R.id.iv_clear);
                        ivClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SearchData = getTime(new java.util.Date());
                                view.setText(SearchData);
                                refresh();
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
                .setType(TimePickerView.Type.YEAR_MONTH)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.nullcoloer)
                .build();

    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }


    @OnClick(R.id.btn_time)
    public void onViewClicked() {
        initCustomTimePicker(textTime, "开始时间");
        pvCustomTime.show();
    }
}

