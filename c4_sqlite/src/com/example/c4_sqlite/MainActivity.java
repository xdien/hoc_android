package com.example.c4_sqlite;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	SinhVienHelper sinhvienDb;
	ArrayList<O_SinhVien> dsSinhVien;
	ListView list;
	AdapterSinhVien adt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dsSinhVien = new ArrayList<O_SinhVien>();
		sinhvienDb = new SinhVienHelper(MainActivity.this, "qlsv", 1);
		sinhvienDb.themMoi(new O_SinhVien(0, "xdien", "vinh long"));
		dsSinhVien = sinhvienDb.danhSach();
		// dua len listview
		list = (ListView) findViewById(R.id.listView1);
		adt = new AdapterSinhVien(MainActivity.this, dsSinhVien);
		list.setAdapter(adt);
		registerForContextMenu(list);

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//idSinhVienChon = position;
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

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id;
		id = item.getItemId();
		if (id == R.id.mnXoa) {
			// Chay ham xoa
			// sinhvienDb.xoa(id)
			/*AdapterContextMenuInfo info = (AdapterContextMenuInfo)	item.getMenuInfo();
			View view = info.targetView;
			TextView tvId = ((TextView)view);
			Log.w("id la" , tvId.getText().toString());
			lamMoi();*/
			
		}
		if (id == R.id.mnUpdate) {
			// Chay ham update
		}
		return super.onContextItemSelected(item);
	}
	//ham lam moi
	private void  lamMoi(){
		list.setAdapter(null);;
		dsSinhVien = sinhvienDb.danhSach();
		adt = new AdapterSinhVien(MainActivity.this, dsSinhVien);
		list.setAdapter(adt);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.menu_sinhvien, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
