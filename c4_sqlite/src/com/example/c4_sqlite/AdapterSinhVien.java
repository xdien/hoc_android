package com.example.c4_sqlite;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterSinhVien extends BaseAdapter {
	Context context;
	ArrayList<O_SinhVien> dsSinhVien;
	
	public AdapterSinhVien(Context context, ArrayList<O_SinhVien> dsSinhVien) {
		super();
		this.context = context;
		this.dsSinhVien = dsSinhVien;
	}
	@Override
	public int getCount() {
		return dsSinhVien.size();
	}
	@Override
	public Object getItem(int position) {
		return dsSinhVien.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		item_sinhVien mot_sv;
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_sinh_vien, null);
			mot_sv = new item_sinhVien();
			mot_sv.name = (TextView) convertView.findViewById(R.id.name);
			mot_sv.email = (TextView) convertView.findViewById(R.id.mail);
			mot_sv.id = (TextView) convertView.findViewById(R.id.tvid);
			convertView.setTag(mot_sv);
		}else{
				mot_sv = (item_sinhVien)convertView.getTag();
		}
		mot_sv.name.setText(dsSinhVien.get(position).ten);
		mot_sv.email.setText(dsSinhVien.get(position).diaChi);
		mot_sv.id.setText(dsSinhVien.get(position).id);
		return convertView;
	}
	class item_sinhVien{
		TextView email;
		TextView name;
		TextView id;
	}
}
