package com.hck.imiao.ui;

import android.os.Bundle;

import com.hck.imiao.R;
import com.hck.imiao.interfaces.BaseMethod;

public class DeviceMangerActivity extends BaseActivity implements BaseMethod {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device_manger);
		initTitle();
	}

	@Override
	public void initTitle() {
		initTitle("设备管理");
	}

	@Override
	public void initData() {

	}

	@Override
	public void initView() {

	}

	@Override
	public void getData() {

	}

	@Override
	public void setData() {

	}

}
