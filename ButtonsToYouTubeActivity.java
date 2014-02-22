package com.example.playwithmusic_hw2app2;
//Karen West, 1/26/14, Playing With Music App for Assignment #2, App#2
//Taken mostly from Week4 videos, combined with new concepts learned in Week 5
//Most videos taken from YouTube
//A raw free MP3 was taken from http://beemp3s.org/download.php?file=8298852&song=Happy+New+Year
//and placed in the res/raw directory (had to create the raw directory there).

//How it works and was tested:  The URLs are specified in ButtonsToYouTubeActivity.  The "onClick" XML command in
//activity_main.xml is associated with a button, and when that button is clicked, the associated
//button-call-routine is called below.  They all go to You Tube to play music videos except
//one of them, which instead plays an MP3 song placed in the raw directory, which has a
//separate activity, the PlayRawMusicActivity.  For that raw mp3,
//you must create the mediaPlayer variable in the "onResume" routine, which is automatically
//called after "onCreate" is called by the Android OS below.  The raw mp3 song will play to
//completion if you let it.  These things will interrupt it (call onPause()):
//--hitting the stop button to call onPause()
//--switching from portrait to landscape (CTRL-F11) first stops it (onPause()) and then
//restarts it (onResume())
//--if you telnet to the emulator (telnet localhost 5554), and then make a fake call to it,
//(gsm call 1234), then the raw mp3 will stop playing (onPause() called), but once you hang up
//the call, the raw mp3 starts again (onResume())
//--if you send a fake sms message from the telnet (sms send 1234 Hello), the message is received
//by the emulator, but the music is not interrupted (onPause() is NOT called)
//--if you hit another button that calls you tube and you click it to play that music video,
//and you do a gsm call, that music video is stopped until you hang up or decline the call, and
//you have the option of restarting the music video on you tube, or hitting the ESC-key which brings
//you back to the main app of buttons interface, at which time "onResume()" is called, and the raw
//mp3 music begins again.
//--if you hit the ESC-key from the main app of buttons interface, it will take you out of this
//app so that you see the main menu of icons if you want to start another app, and the raw mp3
//music stops playing, so onPause() must have been called before going back to the main menu of
//app icons--or otherwise the music would have continued to play until it finished.

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
//import android.widget.Button;

public class ButtonsToYouTubeActivity extends Activity {
	String url_nutrocker = "http://www.youtube.com/watch?v=y30jjHw0ecw";
	String url_nutrockerleds = "http://www.youtube.com/watch?v=BljiqVj7I00";
	String url_karnevil9_1stimp_p2 = "http://www.youtube.com/watch?v=y9JZsWH3N9E";
	String url_vengalaprimavera = "http://www.youtube.com/watch?v=nmDTO3XUGZ4";
	String url_miracle = "http://www.youtube.com/watch?v=K80HN7rInvw";
	String url_barcelona = "http://www.youtube.com/watch?v=IHRd0R-uKHc";
	String url_greensleeves = "http://www.youtube.com/watch?v=DVpL7wHRwuc";
    String url_ledzeppelin_blackdog = "http://www.youtube.com/watch?v=jtN8oBjMr_E";
    WebView buttonsToYouTubeWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_buttons_to_you_tube);
		Log.e("youtubebuttons", "onCreate");
        //final Button nutRockerButton = (Button) findViewById(R.id.nutrocker);
        //wikipediaButton.setOnClickListener(new Button.OnClickListener() {
        	//public void onClick(View v) {
        		//Intent i = new Intent(Intent.ACTION_VIEW);
        		//i.setData(Uri.parse(url_nutrocker));
        		//startActivity(i);        		
        	//}
        //});

  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buttons_to_you_tube, menu);
		return true;
	}

	//emerson,lake palmer (ELP) - Nutrocker
	public void openYouTubeELPnutrocker(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_nutrocker));
		startActivity(i);
	}
				
	//Led Zeppelin - Black Dog - with photos of our dog Midnight scanned in
	//Born 8/4/94, Died 6/6/06
	public void openYouTubeLedZepBlackDog(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_ledzeppelin_blackdog));
		startActivity(i);
	}

	//karn evil 9 1st impression part 2 - emerson,lake,palmer (ELP)
	public void openYouTubeELPkarnevil9_1stimp_p2(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_karnevil9_1stimp_p2));
		startActivity(i);
	}

	//Skye Orchestra with Uli Jon Roth - Venga La Primavera
	public void openYouTubeSkyeOrchUliJonRoth(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_vengalaprimavera));
		startActivity(i);
	}
		
	//Queen's The Miracle
	public void openYouTubeQueenMiracle(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_miracle));
		startActivity(i);
	}
		
	//Freddie Mercury (from Queen) with Monserrat Caballe, opera singer
	public void openYouTubeFreddieMercuryMonserratCaballeBarcelona(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_barcelona));
		startActivity(i);
	}
	
	//Ritchie Blackmore with Rainbow - Greensleeves (old classical done rock and roll)
	public void openYouTubeRitchieBlackmoreRainbowGreensleeves(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_greensleeves));
		startActivity(i);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//check if key event was back button and if there's history
		if (buttonsToYouTubeWebView != null) {
			if ((keyCode == KeyEvent.KEYCODE_BACK) && buttonsToYouTubeWebView.canGoBack()) {
				buttonsToYouTubeWebView.goBack();
				return true;
			}
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onBackPressed() {
	    if( buttonsToYouTubeWebView != null ) {
	        if( buttonsToYouTubeWebView.canGoBack() ) {
	        	buttonsToYouTubeWebView.goBack();
	            return;
	        }
	    }

	    super.onBackPressed();
	}

}
