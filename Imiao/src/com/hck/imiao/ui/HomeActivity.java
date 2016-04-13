package com.hck.imiao.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.hck.imiao.R;
import com.hck.imiao.adapter.NewsAdapter;
import com.hck.imiao.bean.NewsBean;
import com.hck.imiao.interfaces.BaseMethod;
import com.hck.imiao.view.MyListview;
import com.hck.imiao.view.RemindView;

public class HomeActivity extends BaseActivity implements BaseMethod,
		OnClickListener {
	private MyListview newsLvListView;
	private NewsAdapter adapter;
	private List<NewsBean> beans;
	private ImageView intoVideoImageView, homeCallImg;
	private RemindView newsRemindView;
	private TextView newsTvTextView, peopleTextView, xiangqinTextView,
			guanliTextView;
	private TextView newNtTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initData();
		initTitle();
		initView();
		getData();
		setData();
		newsRemindView = new RemindView(this, newNtTextView);
		remind(newsRemindView, 10 + "");
	}

	private void remind(RemindView remindView, String size) {
		remindView.setText(size); // 需要显示的提醒类容
		remindView.setBadgePosition(RemindView.POSITION_TOP_RIGHT);// 显示的位置.右上角,BadgeView.POSITION_BOTTOM_LEFT,下左，还有其他几个属性
		remindView.setTextColor(Color.WHITE); // 文本颜色
		remindView.setBadgeBackgroundColor(Color.RED); // 提醒信息的背景颜色，自己设置
		remindView.setTextSize(12); // 文本大小
		remindView.setBadgeMargin(3); // 各边间隔
		remindView.show();// 只有显示

	}

	

	@Override
	public void initTitle() {
		initTitle("首页");

	}

	@Override
	public void initView() {
		newsLvListView = (MyListview) findViewById(R.id.home_lv);
		intoVideoImageView = (ImageView) findViewById(R.id.home_into_video);
		intoVideoImageView.setOnClickListener(this);
		homeCallImg = (ImageView) findViewById(R.id.home_call_img);
		homeCallImg.setOnClickListener(this);
		newsTvTextView = (TextView) findViewById(R.id.home_news);
		peopleTextView = (TextView) findViewById(R.id.home_people);
		xiangqinTextView = (TextView) findViewById(R.id.home_xiangqing);
		guanliTextView = (TextView) findViewById(R.id.home_guanli);
		newsTvTextView.setOnClickListener(this);
		peopleTextView.setOnClickListener(this);
		xiangqinTextView.setOnClickListener(this);
		guanliTextView.setOnClickListener(this);
		newNtTextView = (TextView) findViewById(R.id.home_news_nt);
	}

	@Override
	public void getData() {
		MaoYaninfoFragment fragment = new MaoYaninfoFragment();
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.home_title, fragment);
		ft.commit();
	}

	@Override
	public void setData() {
		initDatas();
		adapter = new NewsAdapter(this, beans);
		newsLvListView.setAdapter(adapter);

	}

	private void initDatas() {
		beans = new ArrayList<NewsBean>();
		NewsBean newsBean = null;
		for (int i = 0; i < 8; i++) {
			newsBean = new NewsBean();
			newsBean.setContent("发生铃声哈哈哈哈" + i);
			beans.add(newsBean);
		}
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.home_into_video:

			break;
		case R.id.home_call_img:
			break;
		case R.id.home_people:
			startActivity(new Intent(HomeActivity.this,PeopleMangerActivity.class));
			break;
		default:
			break;
		}
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	

}
