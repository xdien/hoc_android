package com.example.gridsimple;

import java.io.Console;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.ApplicationErrorReport.AnrInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String[] ds;
	GridView gridview;
	ArrayList<DoChoi> dsDoChoi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ds = getResources().getStringArray(R.array.daySo);
		dsDoChoi = new ArrayList<DoChoi>();
		dsDoChoi.add(new DoChoi(R.drawable.chuoi, "chuoi", 10000));
		dsDoChoi.add(new DoChoi(R.drawable.orange, "Cam", 12000));
		dsDoChoi.add(new DoChoi(R.drawable.toy1, "Luu dan", 109000));
		dsDoChoi.add(new DoChoi(R.drawable.toy1, "Trai chau", 10000));
		dsDoChoi.add(new DoChoi(R.drawable.toy3, "nguoi may", 90000));
		final MyGridCustom adtDochoi = new MyGridCustom(dsDoChoi, MainActivity.this);
		gridview = (GridView) findViewById(R.id.gridView1);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.w("Click dc nek", "ok!");
				Toast.makeText(MainActivity.this,((DoChoi)adtDochoi.getItem(position)).ten,Toast.LENGTH_SHORT).show();
				
			}
		});
		gridview.setAdapter(adtDochoi);
	}
}
