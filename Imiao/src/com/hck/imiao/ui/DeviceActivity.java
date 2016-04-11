package com.hck.imiao.ui;

import com.hck.imiao.interfaces.BaseMethod;

import android.os.Bundle;

public class DeviceActivity extends BaseActivity implements BaseMethod {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device);
		initTitle();
		initView();
		getData();
		setData();
	}

	@Override
	public void initTitle() {
		initTitle("设备");

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
