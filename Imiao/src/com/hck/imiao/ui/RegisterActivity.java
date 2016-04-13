package com.hck.imiao.ui;

import android.os.Bundle;

import com.hck.imiao.R;

public class RegisterActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initTitle("注册");
	}

}
