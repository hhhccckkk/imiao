package com.hck.imiao.ui;

import com.hck.imiao.interfaces.BaseMethod;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PeopleMangerActivity extends BaseActivity implements BaseMethod,
		OnClickListener {
	private TextView titleRighTextView;
	private TextView userTextView, shengqingTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_people_manger);
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
					R.color.black));
			shengqingTextView.setBackgroundColor(getResources().getColor(
					R.color.white));
			break;
		case 2:
			userTextView.setBackgroundColor(getResources().getColor(
					R.color.white));
			shengqingTextView.setBackgroundColor(getResources().getColor(
					R.color.black));
			break;
		default:
			break;
		}
	}

}
