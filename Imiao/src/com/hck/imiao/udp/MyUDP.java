package com.hck.imiao.udp;

import com.hck.imiao.data.Constans;
import com.hck.imiao.udp.Ddclient.OnUDPListener;

public class MyUDP {
	
	static Ddclient myUdpClient;
	public static void startUdp(final OnUDPListener listener) {
		new Thread() {
			public void run() {
				try {
					byte[] uuid = StringUtil.hexStringToByteArray(Constans.uuID);
					myUdpClient= new Ddclient(uuid, 1,
							Constans.ID_ADDRESS, 9966,listener);
					myUdpClient.setHeartbeatInterval(3);
					myUdpClient.start();
					synchronized (myUdpClient) {
						myUdpClient.wait();
					}
				} catch (Exception e) {
					ErrorLog.Log(e.getMessage());
				}

			}
		}.start();
	}
	public static void stopUDP(){
		try {
			myUdpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
