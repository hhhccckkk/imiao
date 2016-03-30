package com.hck.imiao.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hck.imiao.view.MyToast;
import com.hck.imiao.view.TitleBar;
import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends Activity {
	 protected TitleBar mTitleBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	@Override
	public void setContentView(int layout) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		initTitleBar();
		ViewGroup root = getRootView();
		View paramView = getLayoutInflater().inflate(layout, null);
		root.addView(mTitleBar, LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		root.addView(paramView, LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		super.setContentView(root);
	}

	public void setContentView(View view) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		initTitleBar();
		ViewGroup root = getRootView();
		View paramView = view;
		root.addView(mTitleBar, LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		root.addView(paramView, LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		super.setContentView(root);
	}

	private ViewGroup getRootView() {
		LinearLayout localLinearLayout = new LinearLayout(this);
		localLinearLayout.setOrientation(LinearLayout.VERTICAL);
		return localLinearLayout;
	}

	private void initTitleBar() {
		mTitleBar = new TitleBar(this);
	}

	public TitleBar getTitleBar() {
		return mTitleBar;
	}

	public String getStringData(int id) {
		return getResources().getString(id);
	}

	public void initTitle(String content) {
		mTitleBar.setTitleContent(content);

	}

	public void startActivity(Class<?> class1) {
		startActivity(new Intent(this, class1));
	}

	public void showGetDataError() {
		MyToast.showCustomerToast("网络异常，获取数据失败");
	}


	

}
