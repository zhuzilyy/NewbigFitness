package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Model.ApkUpdataModel;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddressBookBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressEditListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.MyEditText.MyEditText;
import com.example.gufei.bigfitness.util.SpUtil;
import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 通讯录列表实现层
 */

public class AddressListFragMent extends BaseFragment<AddressListFragMentPresenter> implements AddressListFragMentContract.View {

    @BindView(R.id.edit_search)
    EditText edit_search;
    @BindView(R.id.phone_listview)
    PinnedSectionListView listView;
    @BindView(R.id.phone_LetterIndexView)
    LetterIndexView letterIndexView;
    @BindView(R.id.phone_txt_center)
    TextView txt_center;
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refresh_layout;

    private Context context;
    private AddressEditListening addressEditListening;
    private String searchText = "";
//    /**
//     * 搜索栏
//     */
//    EditText edit_search;
//    /**
//     * 列表
//     */
//    PinnedSectionListView listView;
//
//
//    /**
//     * 右边字母列表
//     */
//    LetterIndexView letterIndexView;
//    /**
//     * 中间显示右边按的字母
//     */
//    TextView txt_center;

    /**
     * 所有名字集合
     */
    private ArrayList<PhoneBean> list_all;
    /**
     * 显示名字集合
     */
    private ArrayList<PhoneBean> list_show;
    /**
     * 列表适配器
     */
    private PhoneAdapter adapter;
    /**
     * 保存名字首字母
     */
    public HashMap<String, Integer> map_IsHead;
    /**
     * item标识为0
     */
    public static final int ITEM = 0;
    /**
     * item标题标识为1
     */
    public static final int TITLE = 1;


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {

        return R.layout.list_activity_address;
    }


    /**
     * 成功回调
     *
     * @return
     */
    @Override
    public void succeed(AddressBookBean addressBookBean) {
        refresh_layout.finishRefreshing();
        init();

//        String[] str = getResources().getStringArray(R.array.phone_all);

        for (int i = 0; i < addressBookBean.getResult().size(); i++) {

            PhoneBean phoneBean = new PhoneBean();

            phoneBean.setName(addressBookBean.getResult().get(i).getUserName());

            phoneBean.setHeadimg(addressBookBean.getResult().get(i).getHeaderURL());

            phoneBean.setTel(addressBookBean.getResult().get(i).getTel());

            phoneBean.setOfficeName(addressBookBean.getResult().get(i).getOfficeName());

            phoneBean.setPosition(addressBookBean.getResult().get(i).getDepartName());

            phoneBean.setSex(addressBookBean.getResult().get(i).getSex());

//            phoneBean.setPosition(addressBookBean.getResult().get(i).getna());


            list_all.add(phoneBean);

        }

        //按拼音排序

        MemberSortUtil sortUtil = new MemberSortUtil();

        Collections.sort(list_all, sortUtil);

        // 初始化数据，顺便放入把标题放入map集合
        for (int i = 0; i < list_all.size(); i++) {
            PhoneBean phoneBean = list_all.get(i);
            if (!map_IsHead.containsKey(phoneBean.getHeadChar())) {// 如果不包含就添加一个标题

                PhoneBean phoneBean1 = new PhoneBean();
                // 设置名字
                phoneBean1.setName(phoneBean.getName());
                // 设置标题type
                phoneBean1.setType(AddressListFragMent.TITLE);

                list_show.add(phoneBean1);

                // map的值为标题的下标
                map_IsHead.put(phoneBean1.getHeadChar(), list_show.size() - 1);
            }
            list_show.add(phoneBean);
        }
        adapter.notifyDataSetChanged();


    }

    @Override

    /**
     * 重新加载
     *
     * @return
     */
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);


        addressEditListening = (AddressEditListening) mActivity;

    }


        /**
         * 初始化
         */
    public void init() {

        context = this.getActivity();
        list_all = new ArrayList<PhoneBean>();
        list_show = new ArrayList<PhoneBean>();
        map_IsHead = new HashMap<String, Integer>();
        adapter = new PhoneAdapter(context, list_show, map_IsHead);
        listView.setAdapter(adapter);


        // 开启异步加载数据
//        new Thread(runnable).start();

        edit_search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                s(context,event.getKeyCode()+"");
                if ((event.getAction() == KeyEvent.ACTION_UP) && (keyCode == KeyEvent.KEYCODE_BACK)) {

                    addressEditListening.ShowTab();
                    return true;
                }
                return false;
            }
        });
        edit_search.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    addressEditListening.HiddenTab();
                    // 获得焦点

                } else {
                    addressEditListening.ShowTab();
                    // 失去焦点

                }

            }


        });

        // 输入监听
        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i,
                                          int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1,
                                      int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                list_show.clear();
                map_IsHead.clear();
                //把输入的字符改成大写
                String search = editable.toString().trim().toUpperCase();

                if (TextUtils.isEmpty(search)) {
                    for (int i = 0; i < list_all.size(); i++) {
                        PhoneBean bean = list_all.get(i);
                        //中文字符匹配首字母和英文字符匹配首字母
                        if (!map_IsHead.containsKey(bean.getHeadChar())) {// 如果不包含就添加一个标题
                            PhoneBean bean1 = new PhoneBean();
                            // 设置名字
                            bean1.setName(bean.getName());
                            // 设置标题type
                            bean1.setType(AddressListFragMent.TITLE);
                            list_show.add(bean1);
                            // map的值为标题的下标
                            map_IsHead.put(bean1.getHeadChar(),
                                    list_show.size() - 1);
                        }
                        // 设置Item type
                        bean.setType(AddressListFragMent.ITEM);
                        list_show.add(bean);
                    }
                } else {
                    for (int i = 0; i < list_all.size(); i++) {
                        PhoneBean bean = list_all.get(i);
                        //中文字符匹配首字母和英文字符匹配首字母
                        if (bean.getName().indexOf(search) != -1 || bean.getName_en().indexOf(search) != -1) {
                            if (!map_IsHead.containsKey(bean.getHeadChar())) {// 如果不包含就添加一个标题
                                PhoneBean bean1 = new PhoneBean();
                                // 设置名字
                                bean1.setName(bean.getName());
                                // 设置标题type
                                bean1.setType(AddressListFragMent.TITLE);
                                list_show.add(bean1);
                                // map的值为标题的下标
                                map_IsHead.put(bean1.getHeadChar(),
                                        list_show.size() - 1);
                            }
                            // 设置Item type
                            bean.setType(AddressListFragMent.ITEM);
                            list_show.add(bean);
                        }
                    }
                }

                adapter.notifyDataSetChanged();

            }
        });

        // 右边字母竖排的初始化以及监听
        letterIndexView.init(new LetterIndexView.OnTouchLetterIndex() {
            //实现移动接口
            @Override
            public void touchLetterWitch(String letter) {
                // 中间显示的首字母
                txt_center.setVisibility(View.VISIBLE);
                txt_center.setText(letter);
                // 首字母是否被包含
                if (adapter.map_IsHead.containsKey(letter)) {
                    // 设置首字母的位置
                    listView.setSelection(adapter.map_IsHead.get(letter));
                }
            }

            //实现抬起接口
            @Override
            public void touchFinish() {
                txt_center.setVisibility(View.GONE);
            }
        });

        /** listview点击事件 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (list_show.get(i).getType() == AddressListFragMent.ITEM) {// 标题点击不给操作
                    Intent intent = new Intent(getContext(), AddressDetailsActivity.class);
                    Gson gson = new Gson();
                    intent.putExtra("com.example.gufei.bigfitness", gson.toJson(list_show.get(i)));
                    getActivity().startActivity(intent);
//                    Toast.makeText(context, list_show.get(i).getName(), Toast.LENGTH_LONG).show();
                }
            }
        });

        // 设置标题部分有阴影
        // listView.setShadowVisible(true);
        refresh_layout.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

                String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                String search = searchText;

                int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);


                mPresenter.getAddressBook(userid, token, search, clubid);
            }
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
             refreshLayout.finishLoadmore();
            }
        });

    }

    @Override
    public void initData() {

        context = this.getActivity();


        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        String search = searchText;

        int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        mPresenter.getAddressBook(userid, token, search, clubid);
    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {


        Intent intent = new Intent(getActivity(), LoginActivity.class);


        getActivity().
        startActivity(intent);

    }


    @Override
    public void Loading() {

    }

    /**
     * 按拼音排序
     */
    public class MemberSortUtil implements Comparator<PhoneBean> {

        @Override
        public int compare(PhoneBean lhs, PhoneBean rhs) {
            Comparator<Object> cmp = Collator
                    .getInstance(Locale.CHINA);
            return cmp.compare(lhs.getName_en(), rhs.getName_en());
        }
    }

}
