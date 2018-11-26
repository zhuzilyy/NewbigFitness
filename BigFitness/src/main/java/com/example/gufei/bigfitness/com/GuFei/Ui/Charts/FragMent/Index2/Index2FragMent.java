package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthAddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberLessonSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthSalesReportByLabelIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ReportMonthComeSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMonthMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.util.SpUtil;
import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.TextStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CLUBLISTKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERLEVELKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.AllString2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
import static com.example.gufei.bigfitness.util.ToastUtil.s;


/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:月报表 实现
 */


public class Index2FragMent extends BaseFragment<Index2FragMentPresenter> implements Index2FragMentContract.View {

    //
    @BindView(R.id.bar)
    RelativeLayout bar;
    @BindView(R.id.webview)
    WebView mWebView;//
    @BindView(R.id.text_time)
    TextView textTime;//

    ProgressDialog dialog = null;
    @BindView(R.id.title_spinner)
    Spinner spinner;
    @BindView(R.id.btn_time)
    LinearLayout btnTime;
    @BindView(R.id.text_user_name)
    TextView textUserName;

    private TimePickerView pvCustomTime;

    private Context context;
    private List<FilterBean.FilterListBean> datas = new ArrayList<FilterBean.FilterListBean>();
    //    private String[] mItems = {"第一个会所", "第二个会所", "第三个会所", "第四个会所", "第五个会所", "第六个会所"};
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

    String UserLevel;
    String SearchData;

    List<LoginBean.ClubListBean> ArrItems = new ArrayList<LoginBean.ClubListBean>();
    reportMonthMemberCardSaleSumBean reportMonthMemberCardSaleSumBean = new reportMonthMemberCardSaleSumBean();
    reportForMonthBean reportformonthBean = new reportForMonthBean();

    MonthMemberLessonSumReportBean monthMemberLessonSumReportBean = new MonthMemberLessonSumReportBean();
    ReportMonthComeSumBean reportMonthComeSumBean = new ReportMonthComeSumBean();
    MonthAddSumReportBean monthAddSumReportBean = new MonthAddSumReportBean();
    MonthSalesReportByLabelIdBean monthSalesReportByLabelIdBean = new MonthSalesReportByLabelIdBean();


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
        return R.layout.fragment_index1;
    }


    private void refresh() {
        String ReadUserId = "";
        if (filter > 0 && !persontype.equals("机构用户") && IsDepartManager == 1 && !persontype.equals("会所管理员")) {
            ReadUserId = ArrItems.get(filter - 1).getClubid() + "";

        }

        if (IsDepartManager == 1) {

//            mPresenter.updata(String.valueOf(IsDepartManager), persontype, "", UserLevel, userid, token, SearchData, String.valueOf(ArrItems.get(filter).getClubid()));
            mPresenter.updata(String.valueOf(IsDepartManager), persontype, "(" + String.valueOf(ClubId) + ")", UserLevel, userid, token, SearchData, ReadUserId, ClubId != 0 ? String.valueOf(ClubId) : "");


        } else {

            if (filter == 0) {
                ClubList = "(";
                for (int i = 0; i < ArrItems.size(); i++) {
                    String f = ",";
                    if (i == ArrItems.size() - 1) {
                        f = "";
                    }
                    ClubList += ArrItems.get(i).getClubid() + f;
                }
                ClubList += ")";
            } else {
                ClubList = "(" + String.valueOf(ArrItems.get(filter - 1).getClubid()) + ")";
            }

            mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData, ReadUserId, ClubId != 0 ? String.valueOf(ClubId) : "");


        }


    }


    @Override
    protected void initData() {
        context = this.getActivity();

        UserName = (String) SpUtil.get(context, USERNAMEKEY, "");
        userid = (int) SpUtil.get(context, USERIDKEY, 0);
        token = (String) SpUtil.get(context, TOKENKEY, "");
        persontype = (String) SpUtil.get(context, PERSONTYPEKEY, "");
        Log.e("ss",persontype);
        UserLevel = String.valueOf((int) SpUtil.get(context, USERLEVELKEY, 0));
        ClubId = (int) SpUtil.get(context, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(context, ISDERPARTMANAGERKEY, 0);
        SearchData = getTime(new java.util.Date());
        textUserName.setText(UserName);
        textTime.setText(SearchData);
        datas = new ArrayList<FilterBean.FilterListBean>();
        ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
        }.getType());
        if (persontype.equals("机构用户") || persontype.equals("会所管理员")) {
            UserLevel = "1";
            ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
            }.getType());

        } else if (persontype.equals("教练")) {
            if (IsDepartManager == 0) {
                spinner.setVisibility(View.INVISIBLE);
                textUserName.setVisibility(View.VISIBLE);
            } else {
                datas = AllString2Bean(SpUtil.get(context, CONTACTTEACHERLISTKEY, "").toString());
            }


        } else if (persontype.equals("会籍")) {
            if (IsDepartManager == 0) {
                spinner.setVisibility(View.INVISIBLE);
                textUserName.setVisibility(View.VISIBLE);
            } else {
                datas = String2Bean(SpUtil.get(context, MANGERLISTKEY, "").toString());
            }


        } else {
            ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
            }.getType());
        }

        if (datas.size() > 0) {
            ArrItems.clear();
            for (int i = 0; i < datas.size(); i++) {
                LoginBean.ClubListBean bean = new LoginBean.ClubListBean();
                bean.setClubid(datas.get(i).getID());
                bean.setClubname(datas.get(i).getName());
                ArrItems.add(bean);
            }
        }

        if (!persontype.equals("会所管理员")) {
            mItems = new String[ArrItems.size() + 1];//必须初始化
            mItems[0] = "全部";

            for (int i = 0; i < ArrItems.size(); i++) {
                mItems[i + 1] = ArrItems.get(i).getClubname();
            }
        } else {
            mItems = new String[ArrItems.size()];//必须初始化
            for (int i = 0; i < ArrItems.size(); i++) {
                mItems[i] = ArrItems.get(i).getClubname();
            }

        }
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, mItems);
        // 建立Adapter并且绑定数据源

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner.setAdapter(adapter);
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

        dialog = new ProgressDialog(context);
        dialog.setMessage("正在查询...");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        mWebView.setVerticalScrollBarEnabled(false); //垂直不显示
        mWebView.addJavascriptInterface(new WebAppInterface(context), "Android");

        refresh();
    }


    @Override
    public void succeed(reportMonthMemberCardSaleSumBean reportMonthMemberCardSaleSumBean) {
        this.reportMonthMemberCardSaleSumBean = reportMonthMemberCardSaleSumBean;
        refreshWeb();

    }

    @Override
    public void succeed0(reportForMonthBean reportForMonthBean) {
        this.reportformonthBean = reportForMonthBean;
        refreshWeb();
    }

    @Override
    public void succeed1(MonthMemberLessonSumReportBean monthMemberLessonSumReportBean) {
        this.monthMemberLessonSumReportBean = monthMemberLessonSumReportBean;
        refreshWeb();

    }

    @Override
    public void succeed2(ReportMonthComeSumBean reportMonthComeSumBean) {
        this.reportMonthComeSumBean = reportMonthComeSumBean;
        refreshWeb();
    }

    @Override
    public void succeed3(MonthAddSumReportBean monthAddSumReportBean) {
        this.monthAddSumReportBean = monthAddSumReportBean;
        refreshWeb();
    }

    @Override
    public void succeed4(MonthAddSumReportBean MonthAddSumReportBean) {

    }

    @Override
    public void succeed5(MonthSalesReportByLabelIdBean monthSalesReportByLabelIdBean) {
        this.monthSalesReportByLabelIdBean = monthSalesReportByLabelIdBean;
        refreshWeb();

    }

    private void refreshWeb() {
        mWebView.loadUrl("file:///android_asset/jsWeb/echart2.html");

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
    public void MainPagesucceed(SineForMainPageBean sineForMainPageBean) {


    }

    private void showDialog() {
        dialog.show();
    }

    private void dismissDialog() {
        dialog.dismiss();
    }


    @OnClick(R.id.btn_time)
    public void onViewClicked() {

        initCustomTimePicker(textTime, "开始时间");
        pvCustomTime.show();

    }

    /**
     * 注入到JS里的对象接口
     */
    class WebAppInterface {
        Context mContext;

        public WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * 获取
         *
         * @return
         */
        @JavascriptInterface
        public String getLineChartOptions(int type) {
//            GsonOption option = markLineChartOptions();
//            LogUtils.d(option.toString());
            return markLineChartOptions(type);
        }

        @JavascriptInterface
        public void showToast(String msg) {
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }


        @JavascriptInterface
        public int get2data() {

//            if (reportformonthBean.getSaleResult()==null){
//
//                return 0;
//            }
//
//            int c = 0;
//            for (int i = 0; i < reportformonthBean.getSaleResult().size(); i++) {
//                c += (reportformonthBean.getSaleResult().get(i).getNumCardSaleNum() + reportformonthBean.getSaleResult().get(i).getTimeCardSaleNum() + reportformonthBean.getSaleResult().get(i).getRBuyMoney());
//            }
            if (reportMonthMemberCardSaleSumBean.getResult() == null) {

                return 0;
            }

            int c = 0;
            for (int i = 0; i < reportMonthMemberCardSaleSumBean.getResult().size(); i++) {

                if (persontype.equals("会籍")) {
                    c += (reportMonthMemberCardSaleSumBean.getResult().get(i).getNumCardSaleNum() +
                            reportMonthMemberCardSaleSumBean.getResult().get(i).getTimeCardSaleNum());
                } else if (persontype.equals("教练")) {
                    c += reportMonthMemberCardSaleSumBean.getResult().get(i).getRBuyMoney();
                } else {
                    c += (reportMonthMemberCardSaleSumBean.getResult().get(i).getNumCardSaleNum() +
                            reportMonthMemberCardSaleSumBean.getResult().get(i).getTimeCardSaleNum() +
                            reportMonthMemberCardSaleSumBean.getResult().get(i).getRBuyMoney());
                }
                ;
            }

            return c;


        }

        ;

        @JavascriptInterface
        public int get2data1() {

            if (monthMemberLessonSumReportBean.getResult() == null) {

                return 0;
            }

            int c = 0;
            for (int i = 0; i < monthMemberLessonSumReportBean.getResult().size(); i++) {
                c += monthMemberLessonSumReportBean.getResult().get(i).getLessonSum();
            }

            return c;
        }

        ;

        @JavascriptInterface
        public String get2data2() {

//            if (reportformonthBean.getCountResult() == null) {
//
//                return "0";
//            }
//            int c = 0;
//            int d = 0;
//
//            for (int i = 0; i < reportformonthBean.getCountResult().size(); i++) {
//                c += reportformonthBean.getCountResult().get(i).getMComeCount();
//                d += reportformonthBean.getCountResult().get(i).getCComeCount();
//            }
            if (reportMonthComeSumBean.getResult() == null) {
                return "0";
            }
            int c = 0;
            int d = 0;

            for (int i = 0; i < reportMonthComeSumBean.getResult().size(); i++) {
                c += reportMonthComeSumBean.getResult().get(i).getMComeCount();
                d += reportMonthComeSumBean.getResult().get(i).getCComeCount();
            }


            return c + "+" + d;
//            return  comeSumReportBean.getResult().get(0).getMComeCount() +" + "+comeSumReportBean.getResult().get(0).getCComeCount();
        }

        ;

        @JavascriptInterface
        public String get2data3() {
//
//            if (reportformonthBean.getHumanResult() == null) {
//
//                return "0";
//            }
//            int c = 0;
//            int d = 0;
//            for (int i = 0; i < reportformonthBean.getHumanResult().size(); i++) {
//                c += reportformonthBean.getHumanResult().get(i).getNewMemberNum();
//                d += reportformonthBean.getHumanResult().get(i).getNewCustomerNum();
//            }
            if (monthAddSumReportBean.getResult() == null) {

                return "0";
            }
            int c = 0;
            int d = 0;
            for (int i = 0; i < monthAddSumReportBean.getResult().size(); i++) {
                c += monthAddSumReportBean.getResult().get(i).getNewMemberNum();
                d += monthAddSumReportBean.getResult().get(i).getNewCustomerNum();
            }

            return c + "+" + d;
//            return  addSumReportBean.getResult().get(0).getNewMemberNum()  +" + "+ addSumReportBean.getResult().get(0).getNewCustomerNum();
        }

        ;

//        @JavascriptInterface
//        public String get2data4() {
//            return "";
////            return  addSumReportBean.getResult().get(0).getNewMemberNum()  +" + "+ addSumReportBean.getResult().get(0).getNewCustomerNum();
//        }

        @JavascriptInterface
        public String get2data5() {
            if (persontype.equals("机构用户"))
                return "全体员工";
            return filter == 0 ? "全体员工" : ArrItems.get(filter - 1).getClubname();
//            return  addSumReportBean.getResult().get(0).getNewMemberNum()  +" + "+ addSumReportBean.getResult().get(0).getNewCustomerNum();
        }

        ;

        @JavascriptInterface
        public String Persontype() {
//            return  addSumReportBean.getResult().get(0).getNewMemberNum()  +" + "+ addSumReportBean.getResult().get(0).getNewCustomerNum();
            return persontype;
        }


        /**
         * PieChart 或者柱状图数据示例
         *
         * @param type 1 - 饼状图数据； 2 - 柱状图数据
         * @return
         */
        @JavascriptInterface
        public String getPieChartOptions(int type) {
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //地址：http://echarts.baidu.com/doc/example/pie7.html
            GsonOption option = new GsonOption();
            // 设置标题
            if (type == 2) {
                option.setTooltip(new Tooltip().trigger(Trigger.item).formatter("{b}:{c}({d}%)"));

            } else if (type == 1) {
                option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}");
            }


            // 是否可以拖动以计算
//            option.calculable(true);

            if (type == 1001) {
                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(60).borderWidth(0));

                option.legend().data("").orient(Orient.horizontal).x(X.center).y(Y.bottom);
                CategoryAxis categoryAxis = new CategoryAxis().name("数据").axisLabel(new AxisLabel().show(true));
//                for (int i = 0; i < (reportformonthBean.getSaleResult() != null ? reportformonthBean.getSaleResult().size()+1 : 32); i++) {
//                    if (i > 0) {
//                        if (i % 2 != 0) {
//                            categoryAxis.data().add(i);
//                        } else {
//                            categoryAxis.data().add("");
//                        }
//                    }
//
//                }

                for (int i = 0; i < (reportMonthMemberCardSaleSumBean.getResult() != null ? reportMonthMemberCardSaleSumBean.getResult().size() + 1 : 32); i++) {
                    if (i > 0) {
                        if (i % 2 != 0) {
                            categoryAxis.data().add(i);
                        } else {
                            categoryAxis.data().add("");
                        }
                    }

                }
                option.xAxis(categoryAxis);
                option.yAxis(new ValueAxis());
                option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
                option.dataZoom().show(false).realtime(true).start(0).end(100).xAxisIndex(0);
                Bar bar = new Bar("私教课");
                bar.type(SeriesType.bar);
                bar.stack("num");
                bar.setItemStyle(new ItemStyle()
                        .normal(new Normal()
                                .color("#FBA72D")
                                .label(new Label().show(false))));


//             bar.data(335, 310, 234, 310, 234, 310, 234, 310, 234, 310, 234, 310, 234, 310, 234);

                Bar bar1 = new Bar("会员卡");
                bar1.type(SeriesType.bar);
                bar1.stack("num");
                bar1.setItemStyle(new ItemStyle()
                        .normal(new Normal()
                                .color("#FFDC4A")
                                .label(new Label().show(false).color("#FFDC4A"))));

//                for (int i = 0; i < (reportformonthBean.getSaleResult() != null ? reportformonthBean.getSaleResult().size() : 31); i++) {
//
//                    if (reportformonthBean.getSaleResult() != null) {
//
//                        if (!persontype.equals("会籍")) {
//                            bar.data().add(reportformonthBean.getSaleResult().get(i).getRBuyMoney());
//                        }
//                        bar1.data().add(reportformonthBean.getSaleResult().get(i).getNumCardSaleNum() + reportformonthBean.getSaleResult().get(i).getTimeCardSaleNum());
//                    } else
//
//                    {
//
//                        if (!persontype.equals("会籍")) {
//                            bar.data().add(0);
//                        }
//                        bar1.data().add(0);
//
//                    }

                for (int i = 0; i < (reportMonthMemberCardSaleSumBean.getResult() != null ? reportMonthMemberCardSaleSumBean.getResult().size() : 31); i++) {
                    if (reportMonthMemberCardSaleSumBean.getResult() != null) {
                        bar.data().add(reportMonthMemberCardSaleSumBean.getResult().get(i).getRBuyMoney());
                        bar1.data().add(reportMonthMemberCardSaleSumBean.getResult().get(i).getNumCardSaleNum() + reportMonthMemberCardSaleSumBean.getResult().get(i).getTimeCardSaleNum());
                    } else {
                        bar.data().add(0);
                        bar1.data().add(0);

                    }


                }

//             bar1.data(200, 400, 500, 400, 500, 400, 500, 400, 500, 400, 500, 400, 500, 400, 500);
//                if (!persontype.equals("会籍")) {
                option.series(bar);
                option.series(bar1);
            } else if (type == 1002) {

                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(60).borderWidth(0));
                option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
                option.legend().data("").orient(Orient.horizontal).x(X.center).y(Y.bottom);
                CategoryAxis categoryAxis = new CategoryAxis().name("数据").axisLabel(new AxisLabel().show(true));


//                for (int i = 0; i < (reportformonthBean.getLessonResult() != null ? reportformonthBean.getLessonResult().size() + 1 : 32); i++) {
//                    if (i > 0) {
//                        if (i % 2 != 0) {
//                            categoryAxis.data().add(i);
//                        } else {
//                            categoryAxis.data().add("");
//                        }
//
//                    }
//                }

                for (int i = 0; i < (monthMemberLessonSumReportBean.getResult() != null ? monthMemberLessonSumReportBean.getResult().size() + 1 : 32); i++) {
                    if (i > 0) {
                        if (i % 2 != 0) {
                            categoryAxis.data().add(i);
                        } else {
                            categoryAxis.data().add("");
                        }

                    }
                }


                option.xAxis(categoryAxis);
                option.yAxis(new ValueAxis());


                option.dataZoom().show(false).realtime(true).start(0).end(100).xAxisIndex(0);
                Bar bar = new Bar("私教扣课");
                bar.type(SeriesType.bar);
                bar.stack("num");
                bar.setItemStyle(new ItemStyle()
                        .normal(new Normal()
                                .color("#FBA72D")

                                .label(new Label().show(false))));


                Bar bar1 = new Bar("私教剩余");
                bar1.type(SeriesType.bar);
                bar1.stack("num");
                bar1.setItemStyle(new ItemStyle()
                        .normal(new Normal()
//                                .color("#FFDC4A")
                                .color("#FFFFFF")
                                .label(new Label().show(false).color("#FFDC4A"))));


//
//                for (int i = 0; i < (reportformonthBean.getLessonResult() != null ? reportformonthBean.getLessonResult().size() : 31); i++) {
//                    if (reportformonthBean.getLessonResult() != null) {
//                        bar.data().add(reportformonthBean.getLessonResult().get(i).getLessonSum());
//                        bar1.data().add(reportformonthBean.getLessonResult().get(i).getLeLessonSum());
//                    } else {
//                        bar.data().add(0);
//                        bar1.data().add(0);
//                    }
                for (int i = 0; i < (monthMemberLessonSumReportBean.getResult() != null ? monthMemberLessonSumReportBean.getResult().size() : 31); i++) {
                    if (monthMemberLessonSumReportBean.getResult() != null) {
                        bar.data().add(monthMemberLessonSumReportBean.getResult().get(i).getLessonSum());
                        bar1.data().add(monthMemberLessonSumReportBean.getResult().get(i).getLeLessonSum());
                    } else {
                        bar.data().add(0);
                        bar1.data().add(0);
                    }
                }

                option.series(bar);
                option.series(bar1);
            } else if (type == 1005) {


                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(0).borderWidth(0));
//                option.legend().data("").orient(Orient.horizontal).x(X.center).y(Y.bottom);

                CategoryAxis categoryAxis = new CategoryAxis().name("数据").show(true);

                ValueAxis valueAxis = new ValueAxis().show(true);
                for (int i = 0; i <= 100; i++) {
                    valueAxis.data().add(i, i);
                }

                option.xAxis(valueAxis);
                Bar bar = new Bar("访问来源");
                bar.type(SeriesType.bar).barWidth(30);
                bar.setItemStyle(new ItemStyle()
                        .normal(new Normal()
//                                .color(jsStr)
//                                .color("rgba(193,35,43,1)")
                                .label(new Label().textStyle(new TextStyle().color("#000000")).show(true).position("insideLeft").formatter("{b} {c}%"))));
//
//                if (monthSalesReportByLabelIdBean.getResult() != null) {
//                    for (int i = monthSalesReportByLabelIdBean.getResult().size() - 1; i >= 0; i--) {
//                    double m = Double.parseDouble((Math.round((Float.parseFloat(monthSalesReportByLabelIdBean.getResult().get(i).getPercent())) * 100)) / 100 + "");
//                    bar.data().add(m);
//                    categoryAxis.data().add(monthSalesReportByLabelIdBean.getResult().get(i).getDicName() + "   ¥ " + monthSalesReportByLabelIdBean.getResult().get(i).getSaleNum() + "   ");
//                }
//            } else {
//
//
//                bar.data().add("");
//                categoryAxis.data().add("");
//            }
                if (monthSalesReportByLabelIdBean.getResult() != null) {
                    for (int i = monthSalesReportByLabelIdBean.getResult().size() - 1; i >= 0; i--) {
                        double m = Double.parseDouble((Math.round((Float.parseFloat(monthSalesReportByLabelIdBean.getResult().get(i).getPercent())) * 100)) / 100 + "");
                        bar.data().add(m);
                        categoryAxis.data().add(monthSalesReportByLabelIdBean.getResult().get(i).getDicName() + "   ¥ " + monthSalesReportByLabelIdBean.getResult().get(i).getSaleNum() + "   ");
//                        categoryAxis.data().add(monthSalesReportByLabelIdBean.getResult().get(i).getDicName() + "   ¥ " + monthSalesReportByLabelIdBean.getResult().get(i).getSaleNum() + "   ");
                    }
                } else {
                    bar.data().add("");
                    categoryAxis.data().add("");
                }


                option.series(bar);
                option.yAxis(categoryAxis);
//                s(context, new Gson().toJson(option));
                Log.d("TAG++++", option.toString());


            }


            String s = null;
            try {
                JSONObject myJsonObject = new JSONObject(option.toString());
                JSONObject splitLine = new JSONObject();
                splitLine.put("show", false);

                myJsonObject.getJSONArray("xAxis").getJSONObject(0).put("splitLine", splitLine);
                myJsonObject.getJSONArray("yAxis").getJSONObject(0).put("splitLine", splitLine);
                s = myJsonObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return s;
        }

        @JavascriptInterface
        public String markLineChartOptions(int type) {
            GsonOption option = new GsonOption();
            option.calculable(false).grid(new Grid().x(5).x2(20).y(5).y2(20).borderWidth(0));
            List<Object> mColor = new ArrayList<>();
            mColor.add("#FFDC4A");
            mColor.add("#77C967");
            mColor.add("#6EBBFF");
            // 设置颜色
            option.setColor(mColor);


//            option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);

            option.calculable(true);
            option.tooltip().trigger(Trigger.axis);

            ValueAxis valueAxis = new ValueAxis();
            valueAxis.axisLabel().formatter("{value}");//X轴坐标
            option.yAxis(valueAxis.show(false));
            CategoryAxis categoryAxis = new CategoryAxis();
            categoryAxis.axisLine().onZero(true);
            categoryAxis.axisLabel().formatter("{value}");//Y轴坐标名称
            categoryAxis.boundaryGap(false);
            Line line = new Line();
            line.smooth(true).symbol("emptyCircle").name("会员").itemStyle().normal().color("#B8E2B2").lineStyle().color("#B8E2B2");
            Line line1 = new Line();
            line1.smooth(false).symbol("emptyCircle").name("客户").itemStyle().normal().color("#FEBE63").lineStyle().color("#FEBE63");

            switch (type) {
                case 0:
//                    for (int i = 0; i < (reportformonthBean.getCountResult() != null ? reportformonthBean.getCountResult().size() + 1 : 32); i++) {
//                        if (i > 0) {
//                            if (i % 2 != 0) {
//                                categoryAxis.data().add(i);
//                            } else {
//                                categoryAxis.data().add("");
//                            }
//                            if (reportformonthBean.getCountResult() != null) {
//                                line.data().add(reportformonthBean.getCountResult().get(i - 1).getMComeCount());
//                                line1.data().add(reportformonthBean.getCountResult().get(i - 1).getCComeCount());
//                            } else {
//                                line.data().add(0);
//                                line1.data().add(0);
//                            }
//                        }
//
//                    }

                    for (int i = 0; i < (reportMonthComeSumBean.getResult() != null ? reportMonthComeSumBean.getResult().size() + 1 : 32); i++) {
                        if (i > 0) {
                            if (i % 2 != 0) {
                                categoryAxis.data().add(i);
                            } else {
                                categoryAxis.data().add("");
                            }
                            if (reportMonthComeSumBean.getResult() != null) {
                                line.data().add(reportMonthComeSumBean.getResult().get(i - 1).getMComeCount());
                                line1.data().add(reportMonthComeSumBean.getResult().get(i - 1).getCComeCount());
                            } else {
                                line.data().add(0);
                                line1.data().add(0);
                            }
                        }

                    }
                    break;
                case 1:


//                    for (int i = 0; i < (reportformonthBean.getHumanResult() != null ? reportformonthBean.getHumanResult().size() : 32); i++) {
//
//                        if (i > 0) {
//                            if (i % 2 != 0) {
//                                categoryAxis.data().add(i);
//                            } else {
//                                categoryAxis.data().add("");
//                            }
//
//                            if (reportformonthBean.getHumanResult() != null) {
//
//                                line.data().add(reportformonthBean.getHumanResult().get(i - 1).getNewMemberNum());
//                                line1.data().add(reportformonthBean.getHumanResult().get(i - 1).getNewCustomerNum());
//                            } else {
//                                line.data().add(0);
//                                line1.data().add(0);
//
//                            }
//
//                        }
//                    }
                    for (int i = 0; i < (monthAddSumReportBean.getResult() != null ? monthAddSumReportBean.getResult().size() : 32); i++) {
                        if (i > 0) {
                            if (i % 2 != 0) {
                                categoryAxis.data().add(i);
                            } else {
                                categoryAxis.data().add("");
                            }

                            if (monthAddSumReportBean.getResult() != null) {
                                line.data().add(monthAddSumReportBean.getResult().get(i - 1).getNewMemberNum());
                                line1.data().add(monthAddSumReportBean.getResult().get(i - 1).getNewCustomerNum());
                            } else {
                                line.data().add(0);
                                line1.data().add(0);

                            }

                        }
                    }


                    break;

            }


            option.xAxis(categoryAxis.show(true));
            option.series(line);
            option.series(line1);
            String s = null;
            try {

                JSONObject myJsonObject = new JSONObject(option.toString());
                JSONObject splitLine = new JSONObject();
                splitLine.put("show", false);

                myJsonObject.getJSONArray("xAxis").getJSONObject(0).put("splitLine", splitLine);
                myJsonObject.getJSONArray("yAxis").getJSONObject(0).put("splitLine", splitLine);
                s = myJsonObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return s;
        }
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

//                switch (view.getId()) {
//
//                    case R.id.first_time_begin:
//
////                        mPostCustomerListBean.setStartLastContactTime(getTime(date));
//
//                        break;
//                    case R.id.first_time_end:
//
////                        mPostCustomerListBean.setEndLastContactTime(getTime(date));
//
//                        break;
//                    case R.id.second_time_begin:
//
////                        mPostCustomerListBean.setStartCreateTime(getTime(date));
//
//                        break;
//                    case R.id.second_time_end:
//
////                        mPostCustomerListBean.setEndCreateTime(getTime(date));
//
//                        break;
//
//
//                }


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
}

