package com.example.hieuungxoay;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	RelativeLayout rela;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		// tạo hiệu ứng rõ dần 
		final AlphaAnimation in = new AlphaAnimation(0.0f, 1.0f); 
		// thời gian thực hiện là 2 giây 
		in.setDuration(2000); 
		// tạo hiệu ứng mờ dần 
		final AlphaAnimation out = new AlphaAnimation(1.0f, 0.0f); 
		// thời gian chờ là 1 giây 
		out.setDuration(1000); 
		out.setFillAfter(true); 	
		rela = (RelativeLayout) findViewById(R.id.rela);
		//rela.setAnimation(animation);
		in.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, HoaHong.class);
				startActivity(i);
				overridePendingTransition(R.anim.hieu_ung_ra, R.anim.hieu_ung_vao);
			}
		});
		out.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				rela.startAnimation(in);
			}
		});
		rela.startAnimation(out);
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
}
