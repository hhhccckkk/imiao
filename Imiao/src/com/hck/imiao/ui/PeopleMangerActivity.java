package com.hck.imiao.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.hck.imiao.R;
import com.hck.imiao.interfaces.BaseMethod;

public class PeopleMangerActivity extends BaseActivity implements BaseMethod,
		OnClickListener {
	private TextView titleRighTextView;
	private TextView userTextView, shengqingTextView;
	private Fragment fragment;
	private PeopleFragment peopleFragment;
	private MaoYaninfoFragment maoYaninfoFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_people_manger);
		initView();
		initTitle();
		initData();
		setData();
	}

	

	@Override
	public void initTitle() {
		initTitle("成员管理");

	}

	@Override
	public void initView() {
		titleRighTextView = getTitleBar().getRightTv();
		titleRighTextView.setText("编辑");
		userTextView = (TextView) findViewById(R.id.people_users);
		shengqingTextView = (TextView) findViewById(R.id.people_shengqing_nes);
		userTextView.setOnClickListener(this);
		shengqingTextView.setOnClickListener(this);
	}

	@Override
	public void getData() {

	}

	@Override
	public void setData() {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.people_content, peopleFragment);
		transaction.replace(R.id.people_maoyan, maoYaninfoFragment);
		transaction.commit();
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.people_users:
			changeTvState(1);
			break;
		case R.id.people_shengqing_nes:
			changeTvState(2);
			break;
		case R.id.right_btn:
			break;
		default:
			break;
		}

	}

	private void changeTvState(int tag) {
		switch (tag) {
		case 1:
			userTextView.setBackgroundColor(getResources().getColor(
					R.color.main_huise));
			shengqingTextView.setBackgroundColor(getResources().getColor(
					R.color.white));
			break;
		case 2:
			userTextView.setBackgroundColor(getResources().getColor(
					R.color.white));
			shengqingTextView.setBackgroundColor(getResources().getColor(
					R.color.main_huise));
			break;
		default:
			break;
		}
	}

	public void switchContent(Fragment to) {
		if (fragment != to) {
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			if (!to.isAdded()) {
				transaction.hide(fragment).add(R.id.people_content, to)
						.commit();
			} else {
				transaction.hide(fragment).show(to).commit();
			}
			fragment = to;
		}

	}



	@Override
	public void initData() {
		peopleFragment = new PeopleFragment();
		maoYaninfoFragment = new MaoYaninfoFragment();
		
	}

}
