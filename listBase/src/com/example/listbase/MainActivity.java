package com.example.listbase;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String[] dstrai = {"ab c", "cam" , "quich", "oi"};
	ListView listV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listV = (ListView) findViewById(R.id.listView1);
		//set adapter
		ArrayAdapter<String> dtp = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dstrai);
		listV.setAdapter(dtp);
		listV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, dstrai[position], Toast.LENGTH_LONG).show();
			}
		});
	}
}
