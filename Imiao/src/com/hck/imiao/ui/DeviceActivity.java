package com.hck.imiao.ui;

import android.os.Bundle;

import com.hck.imiao.R;
import com.hck.imiao.interfaces.BaseMethod;

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

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

}
