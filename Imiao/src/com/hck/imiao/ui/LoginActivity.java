package com.hck.imiao.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hck.imiao.R;

public class LoginActivity extends Activity {
	private EditText userNameEditText, pwdEditText;
	private String userName, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	public void initView() {
		userNameEditText = (EditText) findViewById(R.id.login_user_name);
		pwdEditText = (EditText) findViewById(R.id.login_user_pwd);
	}

	public void login(View view) {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

	public void register(View view) {
		startActivity(new Intent(this, RegisterActivity.class));
	}

	public void getPwd(View view) {

	}

}
