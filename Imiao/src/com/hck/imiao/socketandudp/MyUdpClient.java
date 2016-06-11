package com.hck.imiao.socketandudp;

import com.hck.imiao.util.LogUtil;

public class MyUdpClient extends UDPClientBase {

	public MyUdpClient(byte[] uuid, int appid, String serverAddr, int serverPort)
			throws Exception {
		super(uuid, appid, serverAddr, serverPort);
	}

	@Override
	public boolean hasNetworkConnection() {
		return true;
	}

	@Override
	public void trySystemSleep() {

	}

	@Override
	public void onPushMessage(Message message) {
		LogUtil.D("message data: " + new String(message.getData()));

	}

	@Override
	public void onConnectionSuccess() {
		LogUtil.D("onConnectionSuccess");

	}

	@Override
	public void onConnectionFail(String errorMsg) {
		LogUtil.D("onConnectionFail: " + errorMsg);

	}

}
