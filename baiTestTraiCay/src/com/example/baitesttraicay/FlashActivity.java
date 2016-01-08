package com.example.baitesttraicay;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

public class FlashActivity extends ActionBarActivity {
	RelativeLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash);
		layout = (RelativeLayout) findViewById(R.id.flash_sreen);
		// tạo hiệu ứng rõ dần
		final AlphaAnimation in = new AlphaAnimation(0.0f, 1.0f);
		in.setDuration(2000);// thời gian thực hiện là 2 giây
		// tạo hiệu ứng mờ dần
		final AlphaAnimation out = new AlphaAnimation(1.0f, 0.0f);
		out.setDuration(1000);// thời gian chờ là 1 giây
		out.setFillAfter(true);
		in.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				layout.startAnimation(out);
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
				Intent inten =  new Intent(FlashActivity.this, MainActivity.class);
				startActivity(inten);
				overridePendingTransition(R.anim.hieu_ung_ra, R.anim.hieu_ung_vao);
			}
		});
		layout.startAnimation(in);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flash, menu);
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
