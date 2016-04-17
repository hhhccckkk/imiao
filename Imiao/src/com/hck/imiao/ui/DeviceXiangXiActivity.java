package com.hck.imiao.ui;

import com.hck.imiao.R;
import com.hck.imiao.interfaces.BaseMethod;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

public class DeviceXiangXiActivity extends BaseActivity implements BaseMethod {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device_xiangqing);
		initTitle();
		setData();
	}

	@Override
	public void initTitle() {
		initTitle("设备详情");
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
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.shebei, new MaoYaninfoFragment());
		transaction.commit();
	}

}
