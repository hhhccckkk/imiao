package com.hck.imiao.ui;

import io.vov.vitamio.Vitamio;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;

import com.hck.imiao.R;
import com.hck.imiao.data.Constans;
import com.hck.imiao.udp.Ddclient;
import com.hck.imiao.udp.ErrorLog;
import com.hck.imiao.udp.StringUtil;

public class LoginActivity extends Activity {
	private EditText userNameEditText, pwdEditText;
	private String userName, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Vitamio.isInitialized(this);
		setContentView(R.layout.activity_login);
		initView();
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
	}

	public void initView() {
		userNameEditText = (EditText) findViewById(R.id.login_user_name);
		pwdEditText = (EditText) findViewById(R.id.login_user_pwd);
	}

	public void login(View view) {
		 startActivity(new Intent(this, MainActivity.class));
		 finish();
		
	}

	private void startPlayerActivity() {
		Intent intent = new Intent();
		intent.setClass(this, PlayerActivity.class);
		startActivity(intent);
	}

	Ddclient myUdpClient;


	public void register(View view) {
		//startActivity(new Intent(this, RegisterActivity.class));
		startPlayerActivity();
	}

	public void getPwd(View view) {

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		try {
			myUdpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
