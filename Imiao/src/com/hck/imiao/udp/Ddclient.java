/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hck.imiao.udp;

import com.hck.imiao.util.LogUtil;

/**
 *
 * @author Administrator
 */
public class Ddclient  extends UDPClientBase
{
	public Ddclient(byte[] uuid, int appid, String serverAddr, int serverPort) throws Exception
        {
		super(uuid, appid, serverAddr, serverPort);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasNetworkConnection() 
        {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onPushMessage(Message message)
        {
		if(message == null)
                {
			System.out.println("msg is null");
                        ErrorLog.Log("msg is null");
                        //return;
		}
		if(message.getData() == null || message.getData().length == 0)
                {
			System.out.println("msg has no data");
                        ErrorLog.Log("msg has no data");
                        //return;
		}
                String RecStr = StringUtil.convert(message.getData());
                if(RecStr == null)
                {
                  RecStr = "";
                }
                //ErrorLog.Log(RecStr);
                if(RecStr.length()>10)
                {
                   RecStr = RecStr.substring(10);
                }
		//System.out.println(RecStr);
                ErrorLog.Log("鏀跺埌鐨勬暟鎹�:"+StringTools.hexStringToString(RecStr, 2));
                //ErrorLog.Log("hexStringToString(4):"+StringUnit.hexStringToString(RecStr, 4));
                //ErrorLog.Log(RecStr);
                System.out.print("ddddd: "+StringTools.hexStringToString(RecStr, 2));
                LogUtil.D("ddddd: "+StringTools.hexStringToString(RecStr, 2));
                LogUtil.D("ddddd222: "+new String(message.getData()));
	}

	@Override
	public void trySystemSleep() 
        {
		// TODO Auto-generated method stub
	}

	@Override
	public void onOK() {
		System.out.print("onOK: ");
		
	}

	@Override
	public void onError(String msg) {
		System.out.print("onError: "+msg);
		
	}        
}
