package com.hck.imiao.ui;

import java.util.ArrayList;
import java.util.List;

import u.aly.dv;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.hck.imiao.R;
import com.hck.imiao.adapter.DeviceAdapter;
import com.hck.imiao.bean.DeviceBean;
import com.hck.imiao.interfaces.BaseMethod;

public class DeviceActivity extends BaseActivity implements BaseMethod,
		OnClickListener {
	private List<DeviceBean> deviceBeans;
	private ListView listView;
	private DeviceAdapter deviceAdapter;
	private ImageView imageView1, imageView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device);
		initData();
		initTitle();
		initView();
		getData();
		setData();
	}

	@Override
	public void initTitle() {
		initTitle("设备");
		mTitleBar.getRightTv().setBackgroundResource(R.drawable.shebei_add);

	}

	@Override
	public void initView() {
		listView = (ListView) findViewById(R.id.device_lv);
		imageView1 = (ImageView) findViewById(R.id.device_img1);
		imageView2 = (ImageView) findViewById(R.id.device_img2);
		imageView1.setOnClickListener(this);
		imageView2.setOnClickListener(this);
	}

	@Override
	public void getData() {

	}

	@Override
	public void setData() {
		listView.setAdapter(new DeviceAdapter(deviceBeans, 1, this));
	}

	@Override
	public void initData() {
		DeviceBean deviceBean = null;
		deviceBeans = new ArrayList<DeviceBean>();
		for (int i = 0; i < 15; i++) {
			deviceBean = new DeviceBean();
			deviceBean.setContent("谁谁谁谁谁谁是水水水水");
			deviceBean.setTitle("我的猫眼" + i);
			deviceBean.setTouxiang("");
			deviceBeans.add(deviceBean);
		}

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.device_img1:
			imageView1.setImageResource(R.drawable.shebei1_ico);
			imageView2.setImageResource(R.drawable.shebei3_icn);
			listView.setAdapter(new DeviceAdapter(deviceBeans, 1, this));
			break;
		case R.id.device_img2:
			imageView1.setImageResource(R.drawable.shebei2_ico);
			imageView2.setImageResource(R.drawable.shebei4_ico);
			listView.setAdapter(new DeviceAdapter(deviceBeans, 2, this));
			break;
		default:
			break;
		}

	}

}
