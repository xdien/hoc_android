package com.example.baitesttraicay;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	public static int REQ_ADD_CODE = 11;
	ListView list;
	TraiCayDbHelper traiCatDb;
	TraiCayAdapter adt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//load danh sach trai cay tu db
		
		traiCatDb = new TraiCayDbHelper(MainActivity.this, "traicay.sql");
		list = (ListView) findViewById(R.id.mainList);
		adt = new TraiCayAdapter(traiCatDb.LayDanhSach(), MainActivity.this);
		list.setAdapter(adt);
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
		if(id == R.id.mnThem){
			Intent i = new Intent(MainActivity.this, ThemTraiCayActivity.class);
			startActivityForResult(i, REQ_ADD_CODE);
		}
		return super.onOptionsItemSelected(item);
	}
}
