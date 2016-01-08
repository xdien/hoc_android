package com.example.baitesttraicay;

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

public class TraiCayAdapter extends BaseAdapter {
	ArrayList<O_TraiCay> dsTraiCay;
	Context context;

	public TraiCayAdapter(ArrayList<O_TraiCay> dsTraiCay, Context context) {
		super();
		this.dsTraiCay = dsTraiCay;
		this.context = context;
	}

	@Override
	public int getCount() {
		return dsTraiCay.size();
	}

	@Override
	public Object getItem(int position) {
		return dsTraiCay.get(position);
	}

	@Override
	public long getItemId(int position) {
		return dsTraiCay.get(position).id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MotTrai motTraiCay;
		if(convertView == null){
			motTraiCay = new MotTrai();
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_trai_cay, null);
			motTraiCay.hinh = (ImageView) convertView.findViewById(R.id.imgHinh);
			motTraiCay.ten = (TextView) convertView.findViewById(R.id.tvTen);
			motTraiCay.tvid = (TextView) convertView.findViewById(R.id.tvid);
			convertView.setTag(motTraiCay);
		}else{
				motTraiCay = (MotTrai)convertView.getTag();
		}
		motTraiCay.ten.setText(dsTraiCay.get(position).ten);
		motTraiCay.hinh.setBackgroundResource(dsTraiCay.get(position).hinh);
		motTraiCay.tvid.setText(dsTraiCay.get(position).id);
		return convertView;
	}
	class MotTrai{
		ImageView hinh;
		TextView ten;
		TextView tvid;
	}
}
