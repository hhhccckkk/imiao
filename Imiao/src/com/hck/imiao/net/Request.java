package com.hck.imiao.net;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import android.content.Context;

import com.hck.httpserver.HCKHttpClient;
import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.httpserver.RequestParams;
import com.hck.imiao.util.LogUtil;

public class Request {
    private static final int TIME_OUT = 5 * 1000;
    public static final int REQUEST_SUCCESS = 1;
    private static HCKHttpClient client = new HCKHttpClient();
    static {
        client.setTimeout(TIME_OUT);
    }

   
   //+"requestType=UserJoinMeet"
    public static void post(RequestParams params, HCKHttpResponseHandler handler) {
        client.post(Urls.MAIN_HOST_URL+"requestType=UserJoinMeet", params, handler);
    }

    public static void get(HCKHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        get(params, handler);
    }

    public static void get(RequestParams params, HCKHttpResponseHandler handler) {
        client.get(Urls.MAIN_HOST_URL, params, handler);
    }
    
    
    public static void post(Context context,String body,HCKHttpResponseHandler handler){
    	  try {
			client.post(context, Urls.MAIN_HOST_URL, new StringEntity(body, "utf-8"),"application/json",handler);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			LogUtil.D("UnsupportedEncodingException: "+e);
		}
    }
    
    
  

   
}
