package com.example.gridsimple;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ApplicationErrorReport.AnrInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

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
		MyGridCustom adtDochoi = new MyGridCustom(dsDoChoi, MainActivity.this);
		gridview = (GridView) findViewById(R.id.gridView1);
		gridview.setAdapter(adtDochoi);
	}
}
