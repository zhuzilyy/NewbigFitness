package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment;

import android.content.Intent;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Model.local.IndexData;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.PUT_STR;


/**
 * @author GuFei
 * @version 2016 10 12 16:07
 */
public class IndexFragment extends BaseFragment<IndexPresenter> implements IndexContract.View  ,FragMentListening {

//    @BindView(R.id.vp_index)
//    ViewPager mViewPager;
//    @BindView(R.id.topBar) LinearLayout topBar;
//    //@BindView(R.id.dot_group) LinearLayout dotGroup; // 引导圆点
//    @BindView(R.id.rv_dailySpecials)
//    RecyclerView mRecyclerView; // 猜你喜欢列表
//    @BindView(R.id.pb_refresh) ProgressBar mProgressBar; // 换一批进度条
//    @BindView(R.id.iv_refresh) ImageView iv_refresh; // 刷新图片按钮
//    @BindView(R.id.tv_change) TextView tv_change; // 换一批
//    @BindView(R.id.iv_indexTop) ImageView iv_top; // banner图片
//    @BindView(R.id.city_selector) TextView cityName; // 城市名称
//    @BindView(R.id.pb_city) ProgressBar pb_city; // 城市进度条
//    @BindView(R.id.iv_free) ImageView iv_free; // 免费区
//    @BindView(R.id.iv_business) ImageView iv_business; // 商家
//    @BindView(R.id.iv_Entrepreneurs) ImageView iv_Entrepreneurs; // 创业者
//
//    private List<Fragment> fragments = new ArrayList<>();
//    private IndexPagerAdapter indexPagerAdapter;
//    //private int preDotPosition = 0; // 圆点索引
//    private CommonAdapter<DailySpecials> rvAdapter;
//    private List<DailySpecials> data;
//    private int currentPage = 1; // 当前页数
//
//    /*@Inject
//    LocationClient client; // 百度定位
//    private BDLocationListener bdLocationListener; // 百度定位回调
//    private boolean location = true;*/

    @Override
    public void loadData(IndexData indexData) {

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_null;
    }


    @Override
    protected void initData() {


    }

    @Override
    public void BtnBack() {

    }

    @Override
    public void showError(String msg) {
//        SnackbarUtil.s(mView, msg);
    }

    @Override
    public void BtnScan() {

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


//    /**
//     * 换一批
//     */
//    @OnClick(R.id.tv_change)
//    public void change(View view) {
//        mProgressBar.setVisibility(View.VISIBLE);
//        iv_refresh.setVisibility(View.GONE);
//        mPresenter.change(currentPage % 3 + 1);
//        currentPage++;
//    }

//    @OnClick({R.id.iv_free, R.id.iv_business, R.id.iv_Entrepreneurs})
//    public void list(View view) {
//        Intent intent = new Intent(mActivity, ListActivity.class);
//
//        switch (view.getId()) {
//            case R.id.iv_free:
//                intent.putExtra(ListActivity.LIST_TYPE, Constants.FREE_LIST);
//                intent.putExtra(ListActivity.LIST_NAME, "亿票消费区");
//                startActivity(intent);
//                break;
//            case R.id.iv_business:
//                if (App.LONGITUDE == 0 || App.LATITUDE == 0) {
//                    ToastUtil.s(App.getInstance(),"无法定位当前所在位置信息,请重新定位后再试!");
//                    break;
//                }
//                intent.putExtra(ListActivity.LIST_TYPE, Constants.BUSINESS_LIST);
//                intent.putExtra(ListActivity.LIST_NAME, "联盟商家");
//                startActivity(intent);
//                break;
//            case R.id.iv_Entrepreneurs:
//                intent.putExtra(ListActivity.LIST_TYPE, Constants.ENTREPRENEURS_LIST);
//                intent.putExtra(ListActivity.LIST_NAME, "金牌创业者");
//                startActivity(intent);
//                break;
//        }
//    }

//    @Override
//    public void loadData(IndexData indexData) {
////        iv_refresh.setVisibility(View.VISIBLE);
////        mProgressBar.setVisibility(View.GONE);
////        rvAdapter.replaceData(indexData.getList());
//    }

//    @Override
//    public void updateList(List<DailySpecials> list) {
////        rvAdapter.replaceData(list);
////        iv_refresh.setVisibility(View.VISIBLE);
////        mProgressBar.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void updateCity(String name) {
//
////        cityName.setText(name);
//    }

    /*@Override
    public void onStop() {
        super.onStop();
        if (bdLocationListener != null) {
            client.unRegisterLocationListener(bdLocationListener);
        }
        client.stop();
    }*/


}