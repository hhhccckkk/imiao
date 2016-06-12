package com.hck.imiao.ui;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnErrorListener;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.os.Bundle;

import com.hck.imiao.R;
import com.hck.imiao.util.LogUtil;

public class PlayerActivity extends Activity {
	private String path;

	private VideoView mVideoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		mVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
		path = "rtmp://119.6.127.229:1935/myapp/10254A35CD5C43C5BDDDCBEF208EA0A1";
		mVideoView.setVideoPath(path);
		mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);
		mVideoView.setOnErrorListener(new OnErrorListener() {
			
			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				LogUtil.D("onErroronErroronError: "+extra);
				return false;
			}
		});
		mVideoView.requestFocus();

		mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mediaPlayer) {
				LogUtil.D("onPrepared: ");
				mediaPlayer.setPlaybackSpeed(1.0f);
				
				
			}
		});
		LogUtil.D("PlayerActivity onCreate");
	}
	
}
