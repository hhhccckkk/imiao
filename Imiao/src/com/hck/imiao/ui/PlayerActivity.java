package com.hck.imiao.ui;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnErrorListener;
import io.vov.vitamio.MediaPlayer.OnInfoListener;
import io.vov.vitamio.widget.VideoView;

import java.sql.Timestamp;
import java.util.UUID;

import android.hardware.Camera.CameraInfo;
import android.os.Bundle;

import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.httpserver.RequestParams;
import com.hck.imiao.R;
import com.hck.imiao.bean.BackMessageBean;
import com.hck.imiao.data.Constans;
import com.hck.imiao.net.Request;
import com.hck.imiao.util.JsonUtils;
import com.hck.imiao.util.LogUtil;
import com.hck.imiao.util.MyUtils;
import com.jutong.live.LivePusher;
import com.jutong.live.LiveStateChangeListener;

public class PlayerActivity extends BaseActivity implements
		LiveStateChangeListener {
	private String path;
	private VideoView mVideoView;
	private String token;
	private LivePusher livePusher;
	private String UUID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		initTitle("流直播界面");
		mVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
		token = getIntent().getStringExtra("token");
		path = Constans.HOST + token;
		LogUtil.D("pathpathpathpath: " + path);
		mVideoView.setVideoPath(path);
		mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);
		mVideoView.setOnErrorListener(new OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				LogUtil.D("onErroronErroronError: " + extra);
				return false;
			}
		});
		// mVideoView.setOnInfoListener(new OnInfoListener() {
		//
		// @Override
		// public boolean onInfo(MediaPlayer mp, int what, int extra) {
		// LogUtil.D("onInfo: "+what);
		// return true;
		// }
		// });
		mVideoView.requestFocus();

		mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mediaPlayer) {
				LogUtil.D("onPrepared: ");
				mediaPlayer.setPlaybackSpeed(1.0f);
				init();
				// mediaPlayer.start();
				tuiLiu();

			}
		});
	}

	private void init() {
		livePusher = new LivePusher(this, 960, 720, 1024000, 15,
				CameraInfo.CAMERA_FACING_FRONT);
		livePusher.setLiveStateChangeListener(this);
		livePusher.prepare();
	}

	private void tuiLiu() {
		livePusher.startPusher(Constans.HOST + MyUtils.getUUID());

	}

	@Override
	public void onErrorPusher(int code) {
		LogUtil.D("onErrorPusher: " + code);
	}

	@Override
	public void onStartPusher() {
		LogUtil.D("onStartPusher: ");
		sendDataToServer();
	}

	@Override
	public void onStopPusher() {
		LogUtil.D("onStopPusher: ");

	}

	@Override
	protected void onDestroy() {
		livePusher.stopPusher();
		super.onDestroy();
	}

	/**
	 * 戴振 手机号:18140249916 密码:123321 UserToken:9444D4097E774DCCA9FD01CD53D8F745
	 * UserKey:1 关联的瞄眼设备编号:385D9A05D7694F49A8D1C5773A24AC6D 关联的瞄眼的DevKey:1
	 */
	private void sendDataToServer() {
		BackMessageBean messageBean = new BackMessageBean();
		messageBean.setPhoneNumber("18140249916");
		messageBean.setUserKey(1);

		messageBean.setMessageKey(token);
		messageBean.setUserMessage(UUID);
		messageBean
				.setSendMessageTime(new Timestamp(System.currentTimeMillis())
						.toString());
		messageBean.setRandomKey("ddddddd");
		messageBean.setUniqueID("sddddd");
		String requestParam = null;
		try {
			requestParam = JsonUtils.toString(messageBean);
		} catch (Exception e) {
		}
		LogUtil.D("requestParam: " + requestParam);
		RequestParams params = new RequestParams();
		//params.put("requestType", "UserCreateMeet");
		params.put("requestParam", requestParam);
		Request.post(params, new HCKHttpResponseHandler() {
			public void onFailure(Throwable error, String content) {
				LogUtil.D("onFailure: " + content + error);
			};

			public void onFinish(String url) {
				LogUtil.D("onFinish: " + url);
			};

			public void onSuccess(String content, String requestUrl) {

				LogUtil.D("onFinish: " + content + requestUrl);
			};
		});

	}

}
