package com.example.gufei.bigfitness.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.com.GuFei.Component.ActivityComponent;
import com.example.gufei.bigfitness.com.GuFei.Component.DaggerActivityComponent;
import com.example.gufei.bigfitness.com.GuFei.Push.PushService;
import com.example.gufei.bigfitness.component.ActivityCollector;
import com.example.gufei.bigfitness.util.PermissionHelper;
import com.example.gufei.bigfitness.util.SpUtil;
import com.example.gufei.bigfitness.util.ToastUtil;
import com.igexin.sdk.PushManager;
import com.jph.takephoto.app.TakePhotoActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

public abstract class Base2Activity<T extends BasePresenter> extends TakePhotoActivity implements BaseView {

    @Inject
    protected T mPresenter;/**presenter MVP的P*/
    protected Activity mContext;
    protected String TAG;/**TAG 标签*/
    private Unbinder mUnBinder;/**ButterKnife绑定对象,用于解绑.*/
    protected int REQUEST_CODE;  /**扫描回调接收标识*/
    protected PermissionHelper mHelper = new PermissionHelper(this);/**系统权限申请类*/
    protected Handler handler = new Handler();
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());

    public static boolean isForeground = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getLayout();
        if (layoutId != 0) {
            setContentView(layoutId);
        }

        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        TAG = this.getClass().getSimpleName();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        ButterKnife.bind(this);


        initView();
        initData();
//        initListener();
        ActivityCollector.addActivity(this); // 保存可用 Activity 集合 , 实现任意位置退出程序
//        App.getInstance().addActivity(this);

        /*      registerMessageReceiver();  // used for receive msg*/
        //关闭自动弹出输入法
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//       注册个推
        PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);

    }


    /**
     * 初始注入
     */
    protected abstract void initInject();

    /**
     * 绑定布局
     */
    protected abstract int getLayout();

    /**
     * 添加id
     */
    protected abstract void initView();

    /**
     * 添加本地数据
     */
    protected abstract void initData();


    protected <T extends View> T id(int id) {
        return (T) findViewById(id);
    }


    @Override
    protected void onResume() {
        isForeground = true;

        super.onResume();
        /*        JPushInterface.onResume(this);*/
    }


    @Override
    protected void onPause() {
        isForeground = false;

        /*        JPushInterface.onPause(this);*/
        super.onPause();
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
        /* unregisterReceiver(mMessageReceiver);*/
//        Intent resultIntent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
//        resultIntent.putExtras(bundle);
//        mContext.setResult(RESULT_OK, resultIntent);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mUnBinder.unbind();

        ActivityCollector.removeActivity(this); // 移除 Activity
    }

    @Override
    public void showError(String msg) {
        ToastUtil.s(mContext, msg);
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .build();
    }


    //for receive customer msg from jpush server
    /*    private MessageReceiver mMessageReceiver;*/
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";



    //输入框 失去焦点  关闭软键盘
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            boolean hideInputResult = isShouldHideInput(v, ev);

            if (hideInputResult) {
                v.clearFocus();
                InputMethodManager imm = (InputMethodManager) Base2Activity.this
                        .getSystemService(Activity.INPUT_METHOD_SERVICE);
                if (v != null) {
                    if (imm.isActive()) {
                        imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();

            if (event.getRawX() > left && event.getRawX() < right
                    && event.getRawY() > top && event.getRawY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }

    public void PopupView(View v, final int viewId, final String contentName) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(R.layout.content_edit_view, null);
        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        final TextView title = (TextView) contentView.findViewById(R.id.title_text);
        title.setText("修改" + contentName);
        final TextView contentNmae = (TextView) contentView.findViewById(R.id.content_name_text);
        contentNmae.setText(contentName);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final TextView content_text = (TextView) findViewById(viewId);

                TextView Btn = (TextView) contentView.findViewById(R.id.btn);

                final EditText edit = (EditText) contentView.findViewById(R.id.editText);

                Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        content_text.setText(edit.getText());
                        popupWindow.dismiss();
                    }
                });

                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        backgroundAlpha(0.5f);
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }

//    protected void setToolBar(Toolbar toolbar, String title) {
//        toolbar.setTitle(title);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm = getSupportFragmentManager();
//                if (fm != null && fm.getBackStackEntryCount() > 0) {
//                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                } else {
//                    finish();
//                }
//            }
//        });
//    }

    protected String getDataTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String s=format.format(date);
        return s;
    }

    protected String getDataTimes(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s=format.format(date);
        return s;
    }



    protected String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    protected String getTimes(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
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
