package com.example.gufei.bigfitness.com.GuFei.Ui.Scan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by Administrator on 2017/8/4.
 * 扫描页面
 */

public class ScanActivity extends BaseActivity<ScanActivityPresenter> implements ScanActivityContract.View {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
//    private CaptureFragment captureFragment;

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
//        setContentView(R.layout.activity_second);
//        captureFragment = new CaptureFragment();
        tvTitle.setText("上课打卡");

//        captureFragment.setAnalyzeCallback(analyzeCallback);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }

    @Override
    protected void initData() {

    }


    /**
     * 二维码解析回调函数
     */
//    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
//        @Override
//        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
//            Intent resultIntent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
//            bundle.putString(CodeUtils.RESULT_STRING, result);
//            resultIntent.putExtras(bundle);
//            ScanActivity.this.setResult(RESULT_OK, resultIntent);
//            ScanActivity.this.finish();
//        }
//
//        @Override
//        public void onAnalyzeFailed() {
//            Intent resultIntent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
//            bundle.putString(CodeUtils.RESULT_STRING, "");
//            resultIntent.putExtras(bundle);
//            ScanActivity.this.setResult(RESULT_OK, resultIntent);
//            ScanActivity.this.finish();
//        }
//    };

    @Override
    public void succeed(MainMsgBean testBean) {

    }

    @Override
    public void outLogin() {

    }

//    @Override
//    protected void onDestroy() {
//        captureFragment = null;
//        super.onDestroy();
//
//    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
//        bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
//        bundle.putString(CodeUtils.RESULT_STRING, "");
        resultIntent.putExtras(bundle);
        ScanActivity.this.setResult(RESULT_OK, resultIntent);
        ScanActivity.this.finish();
    }
}
