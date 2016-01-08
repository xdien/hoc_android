package com.example.baitesttraicay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ThemTraiCayActivity extends Activity {
	EditText etName, etPath;
	Button btnAdd, btnHinh;
	TraiCayDbHelper traiCayHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_them_trai_cay);
		traiCayHelper = new TraiCayDbHelper(ThemTraiCayActivity.this, "traicay.sql");
		etName = (EditText) findViewById(R.id.etName);
		etPath = (EditText) findViewById(R.id.etPath);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnHinh = (Button) findViewById(R.id.btnSelectImg);
		btnHinh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.parse("file://" + "/sdcard/test.jpg"), "image/*");
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.them_trai_cay, menu);
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
