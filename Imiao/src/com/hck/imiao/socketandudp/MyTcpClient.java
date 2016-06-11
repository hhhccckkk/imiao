package com.hck.imiao.socketandudp;

import com.hck.imiao.util.LogUtil;

public class MyTcpClient extends TCPClientBase {

	public MyTcpClient(byte[] uuid, int appid, String serverAddr,
			int serverPort, int connectTimeout) throws Exception {
		super(uuid, appid, serverAddr, serverPort, connectTimeout);
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
		LogUtil.D(" tcp message data: "+new String(message.getData()));
	}

	@Override
	public void onConnectionSuccess() {
		LogUtil.D(" onConnectionSuccess: ");
		
	}

	@Override
	public void onConnectionFail(String errorMsg) {
		LogUtil.D(" onConnectionFail: "+errorMsg);
		
	}

}
