package com.example.gridsimple;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridCustom extends BaseAdapter {
	ArrayList<DoChoi> dsDochoi;
	Context context;
	
	public MyGridCustom(ArrayList<DoChoi> dsDochoi, Context context) {
		super();
		this.dsDochoi = dsDochoi;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dsDochoi.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dsDochoi.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ItemDoChoi motDoChoi;
		if(convertView == null){
			motDoChoi = new ItemDoChoi();
			LayoutInflater infla = ((Activity)context).getLayoutInflater();
			convertView = infla.inflate(R.layout.mot_do_choi, parent, false);
			motDoChoi.hinh = (ImageView) convertView.findViewById(R.id.imHinh);
			motDoChoi.ten = (TextView) convertView.findViewById(R.id.tvTen);
			motDoChoi.gia = (TextView) convertView.findViewById(R.id.tvGia);
			convertView.setTag(motDoChoi);
		}else {
			motDoChoi = (ItemDoChoi)convertView.getTag();
		}
		motDoChoi.hinh.setImageResource(dsDochoi.get(position).hinh);
		motDoChoi.ten.setText(dsDochoi.get(position).ten);
		motDoChoi.gia.setText(dsDochoi.get(position).gia+"");
		return convertView;
	}
	class ItemDoChoi{
		ImageView hinh;
		TextView ten;
		TextView gia;
	}
}
