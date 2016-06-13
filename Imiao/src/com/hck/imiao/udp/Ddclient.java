/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hck.imiao.udp;

/**
 * 
 * @author Administrator
 */
public class Ddclient extends UDPClientBase {
	private OnUDPListener listener;

	public interface OnUDPListener {
		void getMessage(String msg);

		void onConnectionOK();

		void onConnectionFail(String error);
	}

	public Ddclient(byte[] uuid, int appid, String serverAddr, int serverPort,
			OnUDPListener listener) throws Exception {
		super(uuid, appid, serverAddr, serverPort);
		this.listener = listener;

	}

	@Override
	public boolean hasNetworkConnection() {
		return true;
	}

	@Override
	public void onPushMessage(Message message) {

		String RecStr = StringUtil.convert(message.getData());
		listener.getMessage(StringTools.hexStringToString(RecStr, 2));
	}

	@Override
	public void trySystemSleep() {
	}

	@Override
	public void onOK() {
		listener.onConnectionOK();
	}

	@Override
	public void onError(String msg) {
		//listener.onConnectionFail(msg);
	}
}
