package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ChartsListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberNumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MultimediaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List.ChartsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.VideoPlayView.VideoPlayActivity;
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

import java.util.ArrayList;
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
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERLEVELKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.AllString2Bean;
import static com.example.gufei.bigfitness.util.ListUtil.String2Bean;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.MediaMetadata.getVideoThumbnail;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:统计报表 实现
 */


public class Index3FragMent extends BaseFragment<Index3FragMentPresenter> implements Index3FragMentContract.View {

    //
    @BindView(R.id.bar)
    RelativeLayout bar;


    ProgressDialog dialog = null;
    @BindView(R.id.title_spinner)
    Spinner spinner;
    @BindView(R.id.btn_time)
    LinearLayout btnTime;

    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_user_name)
    TextView textUserName;

    private Context context;
    private CommonAdapter<MemberNumReportBean.ResultBean> commonAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<MemberNumReportBean.ResultBean> datas = new ArrayList<MemberNumReportBean.ResultBean>();
    private List<FilterBean.FilterListBean> mItemData = new ArrayList<FilterBean.FilterListBean>();
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
        return R.layout.fragment_index3;
    }


    private void refresh() {


        if (persontype.equals("会籍") || persontype.equals("教练")) {

            ClubList = "(";
            ClubList +=ClubId;
            ClubList += ")";
            String  id="";

            if (filter != 0) {
                id=  String.valueOf( ArrItems.get(filter-1).getClubid());
            }

            if (IsDepartManager == 1) {
                if (persontype.equals("会籍")) {
                    mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid,SearchData, id, token, SearchData);
                } else {
                    mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, id, SearchData, token, SearchData);
                }
            } else {
                mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, "", "", token, SearchData);
            }


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

            if (IsDepartManager == 1) {
                if (persontype.equals("会籍")) {
                    mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, "", SearchData, token, SearchData);
                } else {
                    mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, SearchData,"", token, SearchData);
                }
            } else {
                mPresenter.updata(String.valueOf(IsDepartManager), persontype, ClubList, UserLevel, userid, "", "", token, SearchData);
            }

        }



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
        textUserName.setText(UserName);
        ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
        }.getType());


        if (persontype.equals("机构用户") || persontype.equals("会所管理员")) {
            UserLevel="1";
            ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
            }.getType());
        } else if (persontype.equals("教练")) {
            if (IsDepartManager == 0) {
                spinner.setVisibility(View.INVISIBLE);
                textUserName.setVisibility(View.VISIBLE);
            } else {
                mItemData = AllString2Bean(SpUtil.get(context, CONTACTTEACHERLISTKEY, "").toString());
            }
        } else if (persontype.equals("会籍")) {
            if (IsDepartManager == 0) {
                spinner.setVisibility(View.INVISIBLE);
                textUserName.setVisibility(View.VISIBLE);
            } else {
                mItemData = String2Bean(SpUtil.get(context, MANGERLISTKEY, "").toString());
            }
        } else {
            ArrItems = new Gson().fromJson(String.valueOf(SpUtil.get(context, CLUBLISTKEY, "")), new TypeToken<List<LoginBean.ClubListBean>>() {
            }.getType());
        }
        if (mItemData.size() > 0) {
            ArrItems.clear();
            for (int i = 0; i < mItemData.size(); i++) {
                LoginBean.ClubListBean bean = new LoginBean.ClubListBean();
                bean.setClubid(mItemData.get(i).getID());
                bean.setClubname(mItemData.get(i).getName());
                ArrItems.add(bean);
            }
        }
        mItems = new String[ArrItems.size() + 1];//必须初始化+1
        mItems[0] = "全部";
        for (int i = 0; i < ArrItems.size(); i++) {
            mItems[i + 1] = ArrItems.get(i).getClubname();
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


        datas = new ArrayList<>();


        commonAdapter = new CommonAdapter<MemberNumReportBean.ResultBean>(R.layout.cardview_charts_list, context, datas) {
//        commonAdapter = new CommonAdapter<MultimediaBean.ResultBean>(R.layout.*appointm ent_main_cardview,this,  datas) {


            @Override
            protected void convert(final ViewHolder holder, final MemberNumReportBean.ResultBean listBean, final int i) {
                TextView textTitle = (TextView) holder.getView(R.id.text_title);
                TextView textContent = (TextView) holder.getView(R.id.text_content);
                TextView textVol = (TextView) holder.getView(R.id.text_vol);
                try {
                    holder.itemView.setBackground(getResources().getDrawable(R.drawable.class.getDeclaredField("text_round_rect_" + String.valueOf(i + 1)).getInt(null)));
                    textTitle.setTextColor(getResources().getColor(R.color.class.getDeclaredField("charts_list_" + String.valueOf(i + 1) + "_color").getInt(null)));
                    textContent.setTextColor(getResources().getColor(R.color.class.getDeclaredField("charts_list_" + String.valueOf(i + 1) + "_color").getInt(null)));
                    textVol.setTextColor(getResources().getColor(R.color.class.getDeclaredField("charts_list_" + String.valueOf(i + 1) + "_color").getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                holder.setText(R.id.text_title, listBean.getTitle());
                holder.setText(R.id.text_content, listBean.getDetail());
                holder.setText(R.id.text_vol, listBean.getMemberNum() + "");


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ChartsListActivity.class);
                        intent.putExtra(PUT_STR + "ClubList", ClubList);
                        intent.putExtra(PUT_STR + "type", listBean.getType());
                        intent.putExtra(PUT_STR + "num", listBean.getMemberNum());
                        intent.putExtra(PUT_STR + "typeName", listBean.getTitle());
                        startActivity(intent);
                    }
                });


            }


        };
        recyclerView.setAdapter(commonAdapter);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //解决列表左右位移的问题
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);

                //防止第一行到顶部有空白区域
                staggeredGridLayoutManager.invalidateSpanAssignments();
            }
        });
        commonAdapter.setShowFooter(false);
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
    public void succeed(MemberNumReportBean memberNumReportBean) {
        datas = memberNumReportBean.getResult();
        commonAdapter.replaceData(datas);
    }


}

