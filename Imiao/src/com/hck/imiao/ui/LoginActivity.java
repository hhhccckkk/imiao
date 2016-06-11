package com.hck.imiao.ui;

import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hck.imiao.R;
import com.hck.imiao.data.Constans;
import com.hck.imiao.socketandudp.MyTcpClient;
import com.hck.imiao.socketandudp.MyUdpClient;
import com.hck.imiao.socketandudp.StringUtil;
import com.hck.imiao.util.LogUtil;

public class LoginActivity extends Activity {
	private EditText userNameEditText, pwdEditText;
	private String userName, password;
	private String uuID = "c607c75d273644d8996e7efba5846a33";

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
		// startActivity(new Intent(this, MainActivity.class));
		// finish();
		 startUDP();
		//startTCP();
	}

	MyUdpClient myUdpClient;
	MyTcpClient myTcpClient;

	private void startTCP() {
		new Thread() {

			public void run() {
				LogUtil.D("startTCP runrunrun");
				try {
					byte[] uuid = StringUtil.md5Byte(uuID);
					myTcpClient = new MyTcpClient(uuid, 1, Constans.ID_ADDRESS,
							9966, 1000 * 1);
					myTcpClient.setHeartbeatInterval(10 * 5);
					myTcpClient.start();
					synchronized (myTcpClient) {
						myTcpClient.wait();
					}
					LogUtil.D("startTCP runrunrun222");
				} catch (Exception e) {
					e.printStackTrace();
					LogUtil.D("ExceptionException: "+e.toString());
					
				}
			};
		}.start();

	}

	private void startUDP() {
		new Thread() {

			public void run() {
				try {
					byte[] uuid = StringUtil.md5Byte(uuID);
					myUdpClient = new MyUdpClient(uuid, 1, Constans.ID_ADDRESS,
							9966);
					myUdpClient.setHeartbeatInterval(10 * 5);
					myUdpClient.start();
					synchronized (myUdpClient) {
						myUdpClient.wait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

	}

	public void register(View view) {
		startActivity(new Intent(this, RegisterActivity.class));
	}

	public void getPwd(View view) {

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		try {
			myUdpClient.stop();
			myTcpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
