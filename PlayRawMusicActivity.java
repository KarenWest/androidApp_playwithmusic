package com.example.playwithmusic_hw2app2;
//Karen West, part of Assignment #2, App#2, 1/26/14
//See other Java activity for comments here, the ButtonsToYouTubeActivity.java
//rather than this one, since I put them all in one place, one file.

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
//import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class PlayRawMusicActivity extends Activity {
	MediaPlayer TThappyNewYear;
	WebView playRawMusicWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		//playRawMusicWebView = (WebView) findViewById(R.id.playwithmusic_webview);
		//playRawMusicWebView.getSettings().setBuiltInZoomControls(true);

		setContentView(R.layout.activity_play_raw_music);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play_raw_music, menu);
		return true;
	}	
	
	// Tarja Turunen's (TT's) Happy New Year - button press can play raw mp3
	//since you tube version is not for mobile devices
	public void playRawTThavearottennewyear(View v) {
		Log.e("play raw music", "playRawTThappynewyear!");
		this.onResume();
	}
	
	public void stopRawTThavearottennewyear(View v) {
		Log.e("play raw music", "stopRawTThappynewyear!");
		this.onPause();
	}

	
	@Override
	protected void onResume() {
		Log.e("play raw music", "onResume!");
		TThappyNewYear = MediaPlayer.create(this, R.raw.tarja_turunen_henkays_ikuisuudesta_happy_new_year);
		TThappyNewYear.setLooping(true);
		TThappyNewYear.start();
		super.onResume();
	}
	@Override
	protected void onPause() {
		Log.e("play raw music", "onPause!");
		TThappyNewYear.stop();
		TThappyNewYear.release();
		super.onPause();
	}
	
	//@Override
	//public boolean onKeyDown(int keyCode, KeyEvent event) {
		//check if key event was back button and if there's history
		//if (playRawMusicWebView != null) {
			//if ((keyCode == KeyEvent.KEYCODE_BACK) && playRawMusicWebView.canGoBack()) {
				//playRawMusicWebView.goBack();
				//return true;
			//}
		//}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		//return super.onKeyDown(keyCode, event);
	//}
	
	//@Override
	//public void onBackPressed() {
	    //if( playRawMusicWebView != null ) {
	        //if( playRawMusicWebView.canGoBack() ) {
	        	//playRawMusicWebView.goBack();
	            //return;
	        //}
	    //}

	    //super.onBackPressed();
	//}


}
