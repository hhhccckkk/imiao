package com.hck.imiao.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.hck.imiao.data.Constans;
import com.hck.imiao.udp.Ddclient.OnUDPListener;
import com.hck.imiao.udp.MyUDP;

public class MessageService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		startUDPConnection();
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		return super.onStartCommand(intent, flags, startId);
	}

	private void startUDPConnection() {
		MyUDP.startUdp(new OnUDPListener() {

			@Override
			public void getMessage(String msg) {
				Intent intent = new Intent();
				intent.setAction(Constans.ACTION_GET_MESSAGE);
				intent.putExtra("type", Constans.KEY_UDP_GET_MESSAGE);
				intent.putExtra("msg", msg);
				sendBroadcast(intent);
			}

			@Override
			public void onConnectionOK() {
				Intent intent = new Intent();
				intent.setAction(Constans.ACTION_GET_MESSAGE);
				intent.putExtra("type", Constans.KEY_UDP_CONNECTION_OK);
				sendBroadcast(intent);
			}

			@Override
			public void onConnectionFail(String error) {
				Intent intent = new Intent();
				intent.setAction(Constans.ACTION_GET_MESSAGE);
				intent.putExtra("type", Constans.KEY_UDP_CONNECTION_ERROR);
				sendBroadcast(intent);
			}
		});
	}

}
