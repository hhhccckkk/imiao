package com.hck.imiao.ui;

import android.os.Bundle;

import com.hck.imiao.interfaces.BaseMethod;

public class UserActivity extends BaseActivity implements BaseMethod {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initTitle();
		initView();
		getData();
		setData();
	}

	@Override
	public void initTitle() {
		initTitle("用户");
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
