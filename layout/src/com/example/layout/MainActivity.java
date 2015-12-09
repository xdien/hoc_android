package com.example.layout;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.sax.TextElementListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText etHoTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHoTen  = (EditText) findViewById(R.id.editText1);
    }
    public void show(View vs){
    	/*LayoutInflater inlaInflater = getLayoutInflater();
    	View v = inlaInflater.inflate(R.layout.hien_thi, (ViewGroup) findViewById( R.id.aa));
    	TextView text = (TextView) v.findViewById(R.id.textView1);
    	text.setText("asdgjkaskgjdsakgjkaskjasd");
    	Toast t = new Toast(MainActivity.this);//getconext
    	t.setDuration(Toast.LENGTH_LONG);
    	t.setView(v);
    	//t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    	t.show();*/
    	
    	//MediaPlayer pl = MediaPlayer.create(MainActivity.this, R.raw.sleepsway);
    	//pl.start();
    	Log.w("Click nek", "Cliccccccc");
    	Button btnDangNhap = (Button) vs.findViewById(R.id.button1);
    	String str = btnDangNhap.getText().toString();
    	if(str.equalsIgnoreCase("")){
    		etHoTen.setError("Ten dang nhap khong duoc rong");
    	}else{
    		etHoTen.setError("asdiygusdguii dybngn ");
    	}
    }
}
