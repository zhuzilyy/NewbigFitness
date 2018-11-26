package com.example.gufei.bigfitness.com.GuFei.Ui;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gufei.bigfitness.R;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomScanActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener{

	@BindView(R.id.dbv_custom)
	DecoratedBarcodeView dbvCustom;
	@BindView(R.id.btn_switch)
	Button btnSwitch;
	private CaptureManager captureManager;
	private boolean isLightOn = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_scan);
		ButterKnife.bind(this);
		if(!hasFlash()) {
			btnSwitch.setVisibility(View.GONE);
		}

		//重要代码，初始化捕获
		captureManager = new CaptureManager(this,dbvCustom);
		captureManager.initializeFromIntent(getIntent(),savedInstanceState);
		captureManager.decode();
		initData();
	}

	private void initData() {
	}

	private boolean hasFlash() {
		return getApplicationContext().getPackageManager()
				.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
	}

	@OnClick(R.id.btn_switch)
	public void onViewClicked() {
		if(isLightOn){
			dbvCustom.setTorchOff();
		}else{
			dbvCustom.setTorchOn();
		}
	}

	@Override
	public void onTorchOn() {
		isLightOn = true;
	}

	@Override
	public void onTorchOff() {
		isLightOn = false;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		captureManager.onSaveInstanceState(outState);
	}

	@Override
	protected void onResume() {
		super.onResume();
		captureManager.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		captureManager.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		captureManager.onDestroy();
	}
}
