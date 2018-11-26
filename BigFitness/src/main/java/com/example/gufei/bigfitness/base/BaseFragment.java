package com.example.gufei.bigfitness.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gufei.bigfitness.App;

import com.example.gufei.bigfitness.com.GuFei.Component.DaggerFragmentComponent;
import com.example.gufei.bigfitness.com.GuFei.Component.FragmentComponent;
import com.example.gufei.bigfitness.com.GuFei.Moudel.FragmentModule;
import com.example.gufei.bigfitness.util.PermissionHelper;
import com.example.gufei.bigfitness.util.SpUtil;
import com.example.gufei.bigfitness.util.ToastUtil;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.DEVICECODEKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.SEXKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;

/**
 * @author GuFei
 * @version 2016 10 04 9:36
 * Fragment基类
 * 与Activity的基础功能相同  用于Fragment
 *
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    @Inject
    protected T mPresenter;
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    protected int REQUEST_CODE;  //扫描回调接收标识
    //    protected static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;  //系统权限标识
    protected PermissionHelper mHelper=new PermissionHelper(this);//系统权限申请类

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        initInject();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mUnBinder = ButterKnife.bind(this, view);


        if (savedInstanceState == null) {
              initData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //MobclickAgent.onPageStart("Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        //MobclickAgent.onPageEnd("Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    protected abstract void initInject();
    protected abstract int getLayoutId();
    protected abstract void initData();

    @Override
    public void showError(String msg) {
        ToastUtil.s(mContext, msg);
    }

    public void remove() {

        SpUtil.remove(mContext, ACCOUNTKEY);
        SpUtil.remove(mContext, PASSWRODKEY);
        SpUtil.remove(mContext, DEVICECODEKEY);
        SpUtil.remove(mContext, USERIDKEY);
        SpUtil.remove(mContext, USERNAMEKEY);
        SpUtil.remove(mContext, SEXKEY);
        SpUtil.remove(mContext, CLUBIDKEY);
        SpUtil.remove(mContext, TOKENKEY);
        SpUtil.remove(mContext, PERSONTYPEKEY);
        SpUtil.remove(mContext, ISDERPARTMANAGERKEY);
        SpUtil.remove(mContext, DEPARTIDKEY);

    }

}