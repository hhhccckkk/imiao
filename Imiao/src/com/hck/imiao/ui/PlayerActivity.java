package com.hck.imiao.ui;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.os.Bundle;

import com.hck.imiao.R;

public class PlayerActivity extends Activity {
     private String path;
     //private HashMap<string, string=""> options;
     private VideoView mVideoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
	    // mVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
	     path = "rtmp://rrbalancer.broadcast.tneg.de:1935/pw/ruk/ruk";
	     /*options = new HashMap<>();
	     options.put(rtmp_playpath, );
	     options.put(rtmp_swfurl, );
	     options.put(rtmp_live, 1);
	     options.put(rtmp_pageurl, );*/
	     mVideoView.setVideoPath(path);
	     mVideoView.setMediaController(new MediaController(this));
	     mVideoView.requestFocus();

	     mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
	         @Override
	         public void onPrepared(MediaPlayer mediaPlayer) {
	             mediaPlayer.setPlaybackSpeed(1.0f);
	         }
	     });
	}
}
