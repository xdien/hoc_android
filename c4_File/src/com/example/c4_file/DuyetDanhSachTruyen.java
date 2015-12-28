package com.example.c4_file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DuyetDanhSachTruyen extends Activity {
	ListView lvDsTruyen;
	ArrayList<String> dsTruyen = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_duyet_danh_sach_truyen);
		lvDsTruyen = (ListView) findViewById(R.id.listView1);
		dsTruyen = lietKeDanhSach();
		ArrayAdapter<String> adp = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, dsTruyen);
		lvDsTruyen.setAdapter(adp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.duyet_danh_sach_truyen, menu);
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

	public ArrayList<String> lietKeDanhSach() {
		final ArrayList<String> dsTruyen = new ArrayList<String>();
		File dir = new File("/sdcard/");
		dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				if (filename.indexOf(".txt") >= 0) {
					dsTruyen.add(filename);
					return true;
				} else
					return false;
			}
		});
		return dsTruyen;
	}
}
