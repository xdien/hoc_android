package com.example.kdhieuungchiabai;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnChiaBai;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnChiaBai = (Button) findViewById(R.id.button1);
		btnChiaBai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				chiaBai();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void chiaBai(){
		Log.w("click dc", "ok");
		//lay do phan giai man hinh
		Display display = getWindowManager().getDefaultDisplay();
		Point diem;
		display.getSize(diem);
		int x= diem.x/2;
		int y = diem.y/2;
		//Tao hieu ung chuyen dong tu duoi len tren
		
		TranslateAnimation duoilen = new TranslateAnimation(diem.x/2, diem);
		duoilen.set
	}
}
