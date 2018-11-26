package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.example.gufei.bigfitness.Constants;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AdddayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.comeSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForDayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.tDailyMemberLessonSumReportBean;
import com.example.gufei.bigfitness.util.SpUtil;
import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.SelectedMode;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.TextStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CLUBLISTKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERLEVELKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.AllString2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
//

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:日报表 实现层
 */


public class Index1FragMent extends BaseFragment<Index1FragMentPresenter> implements Index1FragMentContract.View {

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


    private Context context;

    //    private String[] mItems = {"第一个会所", "第二个会所", "第三个会所", "第四个会所", "第五个会所", "第六个会所"};
    private String[] mItems;
    private boolean isLoadingMore = true;//加载标志位
    private int userid;
    private String token;
    private int clubid;
    String UserName;
    String persontype;
    String ReadUserId;
    String ClubList;
    int ClubId;
    int IsDepartManager;
    int filter = 0;//筛选下拉
    String UserLevel;
    String SearchData;
    List<LoginBean.ClubListBean> ArrItems = new ArrayList<LoginBean.ClubListBean>();
    private List<FilterBean.FilterListBean> datas = new ArrayList<FilterBean.FilterListBean>();
    reportMemberCardSaleSumBean reportDayBean = new reportMemberCardSaleSumBean();
    reportForDayBean reportForDayBean = new reportForDayBean();
    tDailyMemberLessonSumReportBean DailyMemberLessonSumReportbean = new tDailyMemberLessonSumReportBean();
    comeSumReportBean comeSumReportBean = new comeSumReportBean();
    AddSumReportBean addSumReportBean = new AddSumReportBean();
    AdddayBean adddayBean = new AdddayBean();
    private TimePickerView pvCustomTime;

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
            mPresenter.updata(String.valueOf(IsDepartManager), persontype, "(" + String.valueOf(ClubId) + ")", UserLevel, userid, token, SearchData, ReadUserId);
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
            mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, token, SearchData, ReadUserId);
            http();
        }
    }
    private void http(){
        RequestParams params = new RequestParams(Constants.BASEURL+"appReport/getDayAddCustomerReportForManager");
        params.addQueryStringParameter("IsDepartManager",IsDepartManager+"");
        params.addQueryStringParameter("personType",  persontype);
        params.addQueryStringParameter("ClubList","(" + String.valueOf(ClubId) + ")");
        params.addQueryStringParameter("UserLevel",UserLevel);
        params.addQueryStringParameter("UserId",userid+"");
        params.addQueryStringParameter("token",token);
        params.addQueryStringParameter("SearchData",SearchData);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("result",result);

                AdddayBean adddayBean=new  Gson().fromJson(result,AdddayBean.class);

                ArrayList<String> list=new ArrayList<String>();
                String aa="";
                if(adddayBean.getSaleResult().size()!=0) {
                    for (int i = 0; i < adddayBean.getSaleResult().size(); i++) {
                        if (adddayBean.getSaleResult().get(i).getPNum() == null) {
                            adddayBean.getSaleResult().get(i).setPNum("");
                        }
//                   aa=aa+adddayBean.getSaleResult().get(i).getUserName()+":&nbsp;&nbsp;&nbsp;&nbsp;"+adddayBean.getSaleResult().get(i).getNewCustomerNum()+"    条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+adddayBean.getSaleResult().get(i).getPNum()+"               "+",";
                        aa = aa + adddayBean.getSaleResult().get(i).getUserName() + ":;" + adddayBean.getSaleResult().get(i).getNewCustomerNum() + "条;" + adddayBean.getSaleResult().get(i).getPNum() + ";,";

                    }
                    aa= aa.substring(0,aa.length()-2);
                }else if (adddayBean.getSaleResult().size()==0){
                    Log.e("iii",aa.toString());
                }

                Log.e("iii",aa.toString());
                mWebView.loadUrl("javascript:loadData('"+aa+"')");
//                go();

            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ss",ex+"");

            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {

            }
            @Override
            public void onFinished() {

            }
        });


    }

    @Override
    protected void initData() {
        context = this.getActivity();

        UserName = (String) SpUtil.get(context, USERNAMEKEY, "");
        userid = (int) SpUtil.get(context, USERIDKEY, 0);
        token = (String) SpUtil.get(context, TOKENKEY, "");
        persontype = (String) SpUtil.get(context, PERSONTYPEKEY, "");
        UserLevel = String.valueOf((int) SpUtil.get(context, USERLEVELKEY, 0));
        ClubId = (int) SpUtil.get(context, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(context, ISDERPARTMANAGERKEY, 0);
        SearchData = getTime(new Date());
        textTime.setText(SearchData);
        datas = new ArrayList<FilterBean.FilterListBean>();
        textUserName.setText(UserName);
        String s = String.valueOf(SpUtil.get(context, CLUBLISTKEY, ""));

        ArrItems = new Gson().fromJson(s, new TypeToken<List<LoginBean.ClubListBean>>() {
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
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
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

        dialog = new
                ProgressDialog(context);
        dialog.setMessage("正在查询...");
        mWebView.setVerticalScrollBarEnabled(false); //垂直不显示
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setVerticalScrollbarOverlay(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        mWebView.addJavascriptInterface(new
                WebAppInterface(context), "Android");
        mWebView.addJavascriptInterface(new JsInterface(getContext()), "AndroidWebView");
        Toast.makeText(context, "数据加载中", Toast.LENGTH_LONG).show();
        mWebView.setWebChromeClient(new WebChromeClient(){

        });


        refresh();
        mWebView.loadUrl("file:///android_asset/jsWeb/echart.html");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                http();
            }
        });

        getActivity().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("djy","onclicl");
                go();
            }
        });
    }


    private String str="beyondamani";
    public void  go() {
//        mWebView.evaluateJavascript("javascript:loadData("+str+")", null);
        //javascript:loadData('beyondamani')
        mWebView.loadUrl("javascript:loadData('"+str+"')");

    }
    private class JsInterface {
        private Context mContext;

        public JsInterface(Context context) {
            this.mContext = context;
        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void showInfoFromJs(String name) {
            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        }
    }
    //在java中调用js代码
    public void sendInfoToJs(View view) {

        //调用js中的函数：showInfoFromJava(msg)

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
    public void succeed(reportMemberCardSaleSumBean reportDayBean, int type) {
        this.reportDayBean = reportDayBean;
        refreshWeb();

    }

    @Override
    public void succeed0(reportForDayBean reportForDayBean, int Type) {
        this.reportForDayBean = reportForDayBean;

        refreshWeb();
    }

    @Override
    public void succeed1(tDailyMemberLessonSumReportBean tDailyMemberLessonSumReportBean, int Type) {
        this.DailyMemberLessonSumReportbean = tDailyMemberLessonSumReportBean;
        refreshWeb();

    }

    @Override
    public void succeed2(comeSumReportBean comeSumReportBean, int Type) {
        this.comeSumReportBean = comeSumReportBean;
        refreshWeb();
    }

    @Override
    public void succeed3(AddSumReportBean addSumReportBean, int Type) {
        this.addSumReportBean = addSumReportBean;
        refreshWeb();
    }

    @Override
    public void succeed4(AdddayBean adddayBean, int Type) {
        this.adddayBean = adddayBean;
        refreshWeb();
    }

    private void refreshWeb() {
        mWebView.loadUrl("file:///android_asset/jsWeb/echart.html");
    }

    private void showDialog() {
        dialog.show();
    }

    private void dismissDialog() {
        dialog.dismiss();
    }


    @OnClick(R.id.btn_time)
    public void onViewClicked(View v) {
        initCustomTimePicker(textTime, "开始时间");
        pvCustomTime.show();
    }

    /**
     * 注入到JS里的对象接口
     */
    class WebAppInterface {
        Context context;

        public WebAppInterface(Context c) {
            context = c;
        }

        /**
         * 获取
         *
         * @return
         */
        @JavascriptInterface
        public String getLineChartOptions() {
//            GsonOption option = markLineChartOptions();
//            LogUtils.d(option.toString());
            return markLineChartOptions();
        }

        @JavascriptInterface
        public void showToast(String msg) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public int getdata() {

            if (reportDayBean.getResult() == null) return 0;
            return reportDayBean.getResult().get(0).getNumCardSaleNum() + reportDayBean.getResult().get(0).getRBuyMoney() + reportDayBean.getResult().get(0).getTimeCardSaleNum();


            //            return reportForDayBean.getSaleResult().get(0).getNumCardSaleNum() + reportForDayBean.getSaleResult().get(0).getRBuyMoney() + reportForDayBean.getSaleResult().get(0).getTimeCardSaleNum();
        }

        ;

        @JavascriptInterface
        public int getdata1() {
            if (DailyMemberLessonSumReportbean.getResult() == null) return 0;
            return DailyMemberLessonSumReportbean.getResult().get(0).getLeLessonSum() + DailyMemberLessonSumReportbean.getResult().get(0).getLessonSum();
//            return reportForDayBean.getLessonResult().get(0).getLeLessonSum() + reportForDayBean.getLessonResult().get(0).getLessonSum();
        }

        ;

        @JavascriptInterface
        public String getdata2() {
            if (comeSumReportBean.getResult() == null) return "0+0";
            return comeSumReportBean.getResult().get(0).getMComeCount() + " + " + comeSumReportBean.getResult().get(0).getCComeCount();
//            return reportForDayBean.getCountResult().get(0).getMComeCount() + " + " + reportForDayBean.getCountResult().get(0).getCComeCount();
        }

        ;

        @JavascriptInterface
        public String getdata3() {
            if (addSumReportBean.getResult() == null) return "0+0";
            return addSumReportBean.getResult().getNewMemberNum() + " + " + addSumReportBean.getResult().getNewCustomerNum();
//            return addSumReportBean.getResult().get(0).getNewMemberNum() + " + " + addSumReportBean.getResult().get(0).getNewCustomerNum();
//            return reportForDayBean.getHumanResult().get(0).getNewCustomerNum() + " + " + reportForDayBean.getHumanResult().get(0).getNewMemberNum();
        }
        @JavascriptInterface
        public String getdata4() {

            return "全部员工";
//            return addSumReportBean.getResult().get(0).getNewMemberNum() + " + " + addSumReportBean.getResult().get(0).getNewCustomerNum();
//            return reportForDayBean.getHumanResult().get(0).getNewCustomerNum() + " + " + reportForDayBean.getHumanResult().get(0).getNewMemberNum();
        }
        @JavascriptInterface
        public String Persontype() {
            return addSumReportBean.getResult().getNewMemberNum() + " + " + addSumReportBean.getResult().getNewCustomerNum();
//            return addSumReportBean.getResult().get(0).getNewMemberNum() + " + " + addSumReportBean.getResult().get(0).getNewCustomerNum();
//            return persontype;
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
            if (type == 1001) {
//                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(0).borderWidth(0).width("100%").height("100%").padding(0).backgroundColor("#f0f0f0"));
                option.calculable(false).backgroundColor("#f0f0f0");
                option.setTooltip(new Tooltip().trigger(Trigger.item).formatter("{b}:{c}({d}%)"));
                List<Object> mColor = new ArrayList<>();
                mColor.add("#FFDC4A");
                mColor.add("#77C967");
                mColor.add("#6EBBFF");

                // 设置颜色
                option.setColor(mColor);
                // 构造数据
                option.legend().data("次卡", "私教课", "时卡").orient(Orient.horizontal).x(X.center).y(Y.bottom);
                Pie pie1 = new Pie("");
                String[] str = new String[]{"30%", "55%"};
                pie1.type(SeriesType.pie)
                        .radius(str)
                        .center("50%", "45%").setSelectedMode(SelectedMode.single);
                pie1.setSelectedOffset(5);

                if (reportDayBean.getResult() == null) {

                    pie1.data(new Data("次卡", 0),
                            new Data("私教课", 0),
                            new Data("时卡", 0));

                } else {
                    pie1.data(new Data("次卡", reportDayBean.getResult().get(0).getNumCardSaleNum()),
                            new Data("私教课", reportDayBean.getResult().get(0).getRBuyMoney()),
                            new Data("时卡", reportDayBean.getResult().get(0).getTimeCardSaleNum()));
                }


//                pie1.data(new Data("次卡", reportForDayBean.getSaleResult().get(0).getNumCardSaleNum()),
//                        new Data("时卡", reportForDayBean.getSaleResult().get(0).getRBuyMoney()),
//                        new Data("私教课", reportForDayBean.getSaleResult().get(0).getTimeCardSaleNum())
//
//                );
                option.series(pie1);


            } else if (type == 1002) {

//                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(0).borderWidth(0).width("100%").height("100%").padding(0).backgroundColor("#f0f0f0"));

                option.calculable(false).backgroundColor("#f0f0f0");
                option.setTooltip(new Tooltip().trigger(Trigger.item).formatter("{b}:{c}({d}%)"));
                List<Object> mColor = new ArrayList<>();
                mColor.add("#FFDC4A");
                mColor.add("#77C967");
                // 设置颜色
                option.setColor(mColor);
                // 构造数据
                option.legend().data("私教扣课", "私教剩余").orient(Orient.horizontal).x(X.center).y(Y.bottom);
                Pie pie1 = new Pie("");
                String[] str = new String[]{"30%", "55%"};
                pie1.type(SeriesType.pie)
                        .radius(str)
                        .center("50%", "45%").setSelectedMode(SelectedMode.single);
                pie1.setSelectedOffset(5);
                if (persontype.equals("会籍")) {
                    pie1.data(new Data("私教扣课", 0),
                            new Data("私教剩余", 0)
                    );
                } else {
                    pie1.data(new Data("私教扣课", DailyMemberLessonSumReportbean.getResult().get(0).getLessonSum()),
                            new Data("私教剩余", DailyMemberLessonSumReportbean.getResult().get(0).getLeLessonSum())
                    );
                }


//                pie1.data(new Data("私教扣课", reportForDayBean.getLessonResult().get(0).getLessonSum()),
//                        new Data("私教剩余", reportForDayBean.getLessonResult().get(0).getLeLessonSum())
//                );
                option.series(pie1);

            } else if (type == 1003) {


                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(0).borderWidth(0));
                option.legend().data("").orient(Orient.horizontal).x(X.center).y(Y.bottom);
                option.yAxis(new CategoryAxis().name("访问来源").data("客户", "会员").show(false));
                option.xAxis(new ValueAxis().show(false));
                Bar bar = new Bar("访问来源");
                bar.type(SeriesType.bar);
                bar.setItemStyle(new ItemStyle()
                        .normal(new Normal()

                                .label(new Label().textStyle(new TextStyle().color("#000000")).show(true).position("insideLeft").formatter("{b} {c}"))));
//                bar.data(reportForDayBean.getCountResult().get(0).getCComeCount(), reportForDayBean.getCountResult().get(0).getMComeCount());

                bar.data(comeSumReportBean.getResult().get(0).getCComeCount() > 0 ? comeSumReportBean.getResult().get(0).getCComeCount() : 0,
                        comeSumReportBean.getResult().get(0).getMComeCount() > 0 ? comeSumReportBean.getResult().get(0).getMComeCount() : 0);
//                bar.data(Integer.valueOf(reportForDayBean.getCountResult().get(0).getCComeCount()) > 0 ? reportForDayBean.getCountResult().get(0).getCComeCount() : 0,
//                        Integer.valueOf(reportForDayBean.getCountResult().get(0).getMComeCount()) > 0 ? reportForDayBean.getCountResult().get(0).getMComeCount() : 0);
                option.series(bar);

            } else if (type == 1004) {

                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(0).borderWidth(0));
                option.legend().data("").orient(Orient.horizontal).x(X.center).y(Y.bottom);

                option.yAxis(new CategoryAxis().name("访问来源").data("新增客户", "新增会员").show(false));
                option.xAxis(new ValueAxis().show(false));

//                option.dataZoom().show(true).realtime(true).start(0).end(30);
                Bar bar = new Bar("访问来源");
                bar.type(SeriesType.bar);
//                bar.stack("num");
                bar.setItemStyle(new ItemStyle()
                        .normal(new Normal()
//                                .color(jsStr)
                                .color("rgba(193,35,43,1)")
                                .label(new Label().textStyle(new TextStyle().color("#000000")).show(true).position("insideLeft").formatter("{b}  {c} "))));

//                bar.data(addSumReportBean.getResult().get(0).getNewCustomerNum(), addSumReportBean.getResult().get(0).getNewMemberNum());
                bar.data(Integer.valueOf(addSumReportBean.getResult().getNewCustomerNum()) > 0 ? addSumReportBean.getResult().getNewCustomerNum() : 0,
                        Integer.valueOf(addSumReportBean.getResult().getNewMemberNum()) > 0 ? addSumReportBean.getResult().getNewMemberNum() : 0);

//                bar.data(Integer.valueOf(addSumReportBean.getResult().get(0).getNewCustomerNum()) > 0 ? addSumReportBean.getResult().get(0).getNewCustomerNum() : 0,
//                        Integer.valueOf(addSumReportBean.getResult().get(0).getNewMemberNum()) > 0 ? addSumReportBean.getResult().get(0).getNewMemberNum() : 0);
//                bar.data(Integer.valueOf(reportForDayBean.getHumanResult().get(0).getNewCustomerNum()) > 0 ? reportForDayBean.getHumanResult().get(0).getNewCustomerNum() : 0,
//                        Integer.valueOf(reportForDayBean.getHumanResult().get(0).getNewMemberNum()) > 0 ? reportForDayBean.getHumanResult().get(0).getNewMemberNum() : 0);
                option.series(bar);

            }else  if (type == 1005){
                option.calculable(false).grid(new Grid().x(0).x2(0).y(0).y2(0).borderWidth(0));
                option.legend().data("").orient(Orient.horizontal).x(X.center).y(Y.bottom);

                option.yAxis(new CategoryAxis().name("访问来源").data("新增客户", "新增会员").show(false));
                option.xAxis(new ValueAxis().show(false));

//                option.dataZoom().show(true).realtime(true).start(0).end(30);
                Bar bar = new Bar("访问来源");
                bar.type(SeriesType.bar);
//                bar.stack("num");
                bar.setItemStyle(new ItemStyle()
                        .normal(new Normal()
//                                .color(jsStr)
                                .color("rgba(193,35,43,1)")
                                .label(new Label().textStyle(new TextStyle().color("#000000")).show(true).position("insideLeft").formatter("{b}  {c} "))));

//                bar.data(addSumReportBean.getResult().get(0).getNewCustomerNum(), addSumReportBean.getResult().get(0).getNewMemberNum());
                bar.data(Integer.valueOf(addSumReportBean.getResult().getNewCustomerNum()) > 0 ? addSumReportBean.getResult().getNewCustomerNum() : 0,
                        Integer.valueOf(addSumReportBean.getResult().getNewMemberNum()) > 0 ? addSumReportBean.getResult().getNewMemberNum() : 0);

//                bar.data(Integer.valueOf(addSumReportBean.getResult().get(0).getNewCustomerNum()) > 0 ? addSumReportBean.getResult().get(0).getNewCustomerNum() : 0,
//                        Integer.valueOf(addSumReportBean.getResult().get(0).getNewMemberNum()) > 0 ? addSumReportBean.getResult().get(0).getNewMemberNum() : 0);
//                bar.data(Integer.valueOf(reportForDayBean.getHumanResult().get(0).getNewCustomerNum()) > 0 ? reportForDayBean.getHumanResult().get(0).getNewCustomerNum() : 0,
//                        Integer.valueOf(reportForDayBean.getHumanResult().get(0).getNewMemberNum()) > 0 ? reportForDayBean.getHumanResult().get(0).getNewMemberNum() : 0);
                option.series(bar);
            }


            Log.d("TAG", option.toString());


            String s = null;
            try {
                JSONObject myJsonObject = new JSONObject(option.toString());

                s = myJsonObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return s;
        }

        @JavascriptInterface
        public String markLineChartOptions() {
            GsonOption option = new GsonOption();
            option.calculable(false).grid(new Grid().x(5).x2(20).y(5).y2(20).borderWidth(0));
            List<Object> mColor = new ArrayList<>();
            mColor.add("#FFDC4A");
            mColor.add("#77C967");
            mColor.add("#6EBBFF");
            // 设置颜色
            option.setColor(mColor);
            option.legend("测试图标");

//            option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);

            option.calculable(true);
            option.tooltip().trigger(Trigger.axis);

            ValueAxis valueAxis = new ValueAxis();
            valueAxis.axisLabel().formatter("{value}");//X轴坐标
            option.yAxis(valueAxis.show(false));

            CategoryAxis categoryAxis = new CategoryAxis();
            categoryAxis.axisLine().onZero(false);
            categoryAxis.axisLabel().formatter("{value}");//Y轴坐标名称

            categoryAxis.boundaryGap(false);
            categoryAxis.data(0, 1, 2, 3, 4, 5, 6, 7, 8);

            option.xAxis(categoryAxis.show(true));
            Line line = new Line();

            line.smooth(true).symbol("emptyCircle").name("会员").data(0, 1, 2, 3, 4, 5, 6, 7, 8).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
            option.series(line);

            Line line1 = new Line();
            line1.smooth(false).symbol("emptyCircle").name("客户").data(1, 6, 13, 9, 7, 1, 0, 10, 8).itemStyle().normal().lineStyle().shadowColor("rgba(100,0,0,0.4)");
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
                .setLayoutRes(R.layout.pickerview_charts_day_time, new CustomListener() {

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
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.nullcoloer)
                .build();

    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}

