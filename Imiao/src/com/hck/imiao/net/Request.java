package com.hck.imiao.net;

import com.hck.httpserver.HCKHttpClient;
import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.httpserver.RequestParams;

public class Request {
    private static final int TIME_OUT = 5 * 1000;
    public static final int REQUEST_SUCCESS = 1;
    private static HCKHttpClient client = new HCKHttpClient();
    static {
        client.setTimeout(TIME_OUT);
    }

   

    public static void post(RequestParams params, HCKHttpResponseHandler handler) {
        client.post(Urls.MAIN_HOST_URL, params, handler);
    }

    public static void get(HCKHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        get(params, handler);
    }

    public static void get(RequestParams params, HCKHttpResponseHandler handler) {
        client.get(Urls.MAIN_HOST_URL, params, handler);
    }
    
    
  

   
}
