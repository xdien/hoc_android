package com.example.c4_file;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	EditText fname, fcontent, fnameread;
	Button btnWrite, btnRead;
	TextView filecon;
	FileOperations file;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fname = (EditText) findViewById(R.id.fname);
		fcontent = (EditText) findViewById(R.id.ftext);
		fnameread = (EditText) findViewById(R.id.fnameread);
		btnWrite = (Button) findViewById(R.id.btnwrite);
		btnRead = (Button) findViewById(R.id.btnread);
		filecon = (TextView) findViewById(R.id.filecon);
		file = new FileOperations();
		btnWrite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Boolean isSucc = file.write(fname.getText().toString(),
						fcontent.getText().toString());
				if (isSucc) {
					Toast.makeText(MainActivity.this, "Ghi thanh cong",
							Toast.LENGTH_SHORT).show();
					;
				}
			}
		});
		btnRead.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content;
				content = file.read(fnameread.getText().toString());
				filecon.setText(content);
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
		if (id == R.id.mnuDanhSach) {
			// goi danh sach
			Intent intent = new Intent(this, DuyetDanhSachTruyen.class);
			startActivityForResult(intent, 1000);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		if (resultCode == RESULT_OK) {
			if (requestCode == 1000) {
				String readfilename = intent.getStringExtra("fileName");
				fnameread.setText(readfilename);
				FileOperations fop = new FileOperations();
				String text = fop.read(readfilename);
				if (text != null) {
					filecon.setText(text);
				} else {
					Toast.makeText(getApplicationContext(), "File not Found",
							Toast.LENGTH_SHORT).show();
					filecon.setText(null);
				}
			}
		}
	}
}
