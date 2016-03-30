package com.hck.imiao.downapp;

import org.json.JSONObject;

import android.content.Context;

import com.hck.httpserver.JsonHttpResponseHandler;
import com.hck.httpserver.RequestParams;
import com.hck.imiao.bean.AppInfoBean;
import com.hck.imiao.net.Request;
import com.hck.imiao.util.JsonUtils;

public class UpdateUtil {
    private UpdateAppCallBack callBack;

    public interface UpdateAppCallBack {
        void backAppInfo(AppInfoBean bean);
    }

    public void isUpdate(Context context) {
        callBack = (UpdateAppCallBack) context;
        getInfo();
    }

    private void getInfo() {
        RequestParams params = new RequestParams();
        params.put("type", 1 + "");
//        Request.getAppInfo(params, new JsonHttpResponseHandler() {
//            @Override
//            public void onFinish(String url) {
//                super.onFinish(url);
//            }
//
//            @Override
//            public void onSuccess(int statusCode, JSONObject response) {
//                super.onSuccess(statusCode, response);
//
//                try {
//                    boolean isok = response.getBoolean("isok");
//                    if (isok) {
//                        AppInfoBean bAppInfoBean = JsonUtils.parse(response.getString("info"), AppInfoBean.class);
//                        callBack.backAppInfo(bAppInfoBean);
//                    }
//                } catch (Exception e) {
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable error, String content) {
//                super.onFailure(error, content);
//            }
//        });
    }

}
