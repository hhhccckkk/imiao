package com.hck.imiao.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity implements
		OnCheckedChangeListener {
	private static final String HOME = "home";
	private static final String DEVICE = "device";
	private static final String USER = "user";
	private TabHost tabHost; // tabhost对象
	private TabSpec tabSpec1, tabSpec2, tabSpec3; // 现象卡对象
	public static RadioButton button1, button2, button3; // 设置背景
	private RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		initView();
		addSpec();
		setListener();
	}

	private void initView() {
		// radioGroup = (RadioGroup) findViewById(R.id.RadioG);
		// tabHost = this.getTabHost();
		// button1 = (RadioButton) findViewById(R.id.home_id);
		// button2 = (RadioButton) findViewById(R.id.lift_id);
		// button3 = (RadioButton) findViewById(R.id.more_id);
	}

	private void setListener() { // 设置点击监听事件
		radioGroup.setOnCheckedChangeListener(this);
	}

	private void addSpec() {
		// tabSpec1 = tabHost.newTabSpec(HOME).setIndicator(HOME)
		// .setContent(new Intent(this, MainLeft.class)); //
		// 点击第一个button，跳转到哪个activity（点击跳到MainLeft界面）
		// tabHost.addTab(tabSpec1);
		// tabSpec2 = tabHost.newTabSpec(LIFT).setIndicator(LIFT)
		// .setContent(new Intent(this, MainCenter.class));//
		// 点击第2个button，跳转到哪个activity
		// tabHost.addTab(tabSpec2);
		// tabSpec3 = tabHost.newTabSpec(MORE).setIndicator(MORE)
		// .setContent(new Intent(this, MainRight.class));//
		// 点击第3个button，跳转到哪个activity
		// tabHost.addTab(tabSpec3);

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) { // 点击按钮事件
		switch (checkedId) {
		// case R.id.home_id: // 点击第一个按钮
		// tabHost.setCurrentTab(0); // 显示第一个选项卡，即跳到MainLeft
		// break;
		// case R.id.lift_id:
		// tabHost.setCurrentTab(1);// 跳到MainCenter
		// break;
		// case R.id.more_id:
		// tabHost.setCurrentTab(2);// 跳到MainRight
		// break;
		}

	}

}
