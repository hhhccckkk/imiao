package com.hck.imiao.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.hck.imiao.R;
import com.hck.imiao.udp.Ddclient.OnUDPListener;
import com.hck.imiao.udp.MyUDP;
import com.hck.imiao.util.LogUtil;
import com.hck.imiao.util.MyUtils;

public class MainActivity extends TabActivity implements
		OnCheckedChangeListener {
	private static final String HOME = "home";
	private static final String DEVICE = "device";
	private static final String USER = "user";
	private static final int HOME_TAB = 1;
	private TabHost tabHost; // tabhost对象
	private TabSpec tabSpec1, tabSpec2, tabSpec3; // 现象卡对象
	public static RadioButton button1, button2, button3; // 设置背景
	private RadioGroup radioGroup;
    private String [] dataStrings;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		addSpec();
		setListener();
		MyUDP.startUdp(new OnUDPListener() {

			@Override
			public void getMessage(String msg) {
				LogUtil.D("msgmsgmsg: "+msg);
                dataStrings=MyUtils.getStrings(msg);
                if (dataStrings!=null) {
                	startPlayerActivity(dataStrings[3]);
				}
			}
		});
	}
	private void startPlayerActivity(String token){
		Intent intent=new Intent();
		intent.putExtra("token", token);
		intent.setClass(this, PlayerActivity.class);
		startActivity(intent);
	}

	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.RadioG);
		tabHost = this.getTabHost();
		button1 = (RadioButton) findViewById(R.id.device_id);
		button2 = (RadioButton) findViewById(R.id.home_id);
		button3 = (RadioButton) findViewById(R.id.user_id);
	}

	private void setListener() { // 设置点击监听事件
		radioGroup.setOnCheckedChangeListener(this);
	}

	private void addSpec() {
		tabSpec1 = tabHost.newTabSpec(DEVICE).setIndicator(DEVICE)
				.setContent(new Intent(this, DeviceActivity.class)); //
		tabHost.addTab(tabSpec1);
		tabSpec2 = tabHost.newTabSpec(HOME).setIndicator(HOME)
				.setContent(new Intent(this, HomeActivity.class));//
		tabHost.addTab(tabSpec2);
		tabSpec3 = tabHost.newTabSpec(USER).setIndicator(USER)
				.setContent(new Intent(this, UserActivity.class));//
		tabHost.addTab(tabSpec3);
		tabHost.setCurrentTab(HOME_TAB);
		button2.setChecked(true);

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) { // 点击按钮事件
		switch (checkedId) {
		case R.id.device_id: // 点击第一个按钮
			tabHost.setCurrentTab(0); // 显示第一个选项卡，即跳到MainLeft
			changeBg(0);
			break;
		case R.id.home_id:
			changeBg(1);
			tabHost.setCurrentTab(1);// 跳到MainCenter
			break;
		case R.id.user_id:
			changeBg(2);
			tabHost.setCurrentTab(2);// 跳到MainRight
			break;
		}
	}

	private void changeBg(int tag) {
		switch (tag) {
		case 0:
			button1.setTextColor(getResources()
					.getColor(R.color.main_btn_press));
			button2.setTextColor(getResources().getColor(R.color.main_tv_color));
			button3.setTextColor(getResources().getColor(R.color.main_tv_color));
			break;
		case 1:
			button1.setTextColor(getResources().getColor(R.color.main_tv_color));
			button2.setTextColor(getResources()
					.getColor(R.color.main_btn_press));
			button3.setTextColor(getResources().getColor(R.color.main_tv_color));
			break;
		case 2:
			button1.setTextColor(getResources().getColor(R.color.main_tv_color));
			button2.setTextColor(getResources().getColor(R.color.main_tv_color));
			button3.setTextColor(getResources()
					.getColor(R.color.main_btn_press));
			break;
		default:
			break;
		}
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		MyUDP.stopUDP();
	}

}
