package com.example.cauhinhungdungsharepreferent;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener  {
	
	Button btnDangNhap, btnThoat;
	EditText etPass, etUser;
	TextView tvThongBao;
	SharedPreferences pref; //bien chua thong tin SharedPreferences
	SharedPreferences.Editor edPref;//Bien dung de bat su kien thay doi
	
	String prefUser, prefPass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
		btnThoat = (Button) findViewById(R.id.btnThoat);
		etPass = (EditText) findViewById(R.id.etPass);
		etUser = (EditText) findViewById(R.id.etUser);
		tvThongBao = (TextView) findViewById(R.id.tvThongBao);
		
		//doc du lieu cau hinh
		pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
		edPref = pref.edit();
		//doc gia tri tu file xml
		prefUser = pref.getString("user", "");
		prefPass = pref.getString("pass", "");
		btnDangNhap.setOnClickListener(this);
		btnThoat.setOnClickListener(this);
		capNhatGiaoDien();
	}
	private void capNhatGiaoDien(){
		if(prefPass.equalsIgnoreCase("") || prefUser.equalsIgnoreCase("")){
			//An thong bao va btnThoat
			btnThoat.setVisibility(View.GONE);
			tvThongBao.setVisibility(View.GONE);
			//Hien thi thong bao 
			etPass.setVisibility(View.VISIBLE);
			etUser.setVisibility(View.VISIBLE);
			btnDangNhap.setVisibility(View.VISIBLE);
		}else{
			if(prefPass.equalsIgnoreCase("xdien")  && prefUser.equalsIgnoreCase("xdien")){
				//An form dang nhap
				etPass.setVisibility(View.GONE);
				etUser.setVisibility(View.GONE);
				btnDangNhap.setVisibility(View.GONE);
				//hien thi thong bao
				btnThoat.setVisibility(View.VISIBLE);
				tvThongBao.setVisibility(View.VISIBLE);
				tvThongBao.setText("Xin chao: " +prefUser);;
			}
		}
	}
	@Override
	public void onClick(View v) {
		Log.w("asdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "click");
		//neu bam nut dang nhap kiem tra bien truyen vao
		if(v.getId() == R.id.btnDangNhap){
			if(etUser.getText().toString().equalsIgnoreCase("xdien")  && 
					etPass.getText().toString().equalsIgnoreCase("xdien")){
				prefPass = etPass.getText().toString();
				prefUser = etUser.getText().toString();
				edPref.putString("user", prefUser);
				edPref.putString("pass", prefPass);
				
				edPref.commit();
			}else{
				//Khong dung ten dang nhap xoa chu
				etPass.setText("");
				etUser.setText("");
			}
		}
		if(v.getId() == R.id.btnThoat){
			//xoa cac cai dat
			prefPass = "";
			prefUser = "";
			edPref.clear();
			edPref.apply();
		}
		capNhatGiaoDien();
	}
}
