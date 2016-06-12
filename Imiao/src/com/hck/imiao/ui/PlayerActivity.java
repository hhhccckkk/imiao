package com.hck.imiao.ui;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnErrorListener;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.os.Bundle;

import com.hck.imiao.R;
import com.hck.imiao.util.LogUtil;

public class PlayerActivity extends BaseActivity {
	private String path;

	private VideoView mVideoView;
    private String token;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		initTitle("流直播界面");
		mVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
		token=getIntent().getStringExtra("token");
		path = "rtmp://119.6.127.229:1935/myapp/"+token;
		LogUtil.D("pathpathpathpath: "+path);
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
	
	private void tuiLiu(){
		
	}
	
	
}
