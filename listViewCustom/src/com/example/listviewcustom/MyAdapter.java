package com.example.listviewcustom;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	ArrayList<NgonNgu> arrNgonNgu;
	Context context;

	public MyAdapter(ArrayList<NgonNgu> arrNgonNgu, Context context) {
		super();
		this.arrNgonNgu = arrNgonNgu;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrNgonNgu.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrNgonNgu.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ItemNgonNgu ingonngu;
		if (convertView == null) {
			ingonngu = new ItemNgonNgu();
			LayoutInflater inflat = ((Activity) context).getLayoutInflater();
			convertView = inflat.inflate(R.layout.item_list, parent, false);
			ingonngu.txThongBao = (TextView) convertView
					.findViewById(R.id.textView1);
			ingonngu.cbTrangThai = (CheckBox) convertView
					.findViewById(R.id.checkBox1);
			convertView.setTag(ingonngu);
		} else {
			ingonngu = (ItemNgonNgu) convertView.getTag();
		}
		ingonngu.txThongBao.setText(arrNgonNgu.get(position).ten);
		return convertView;
	}

	class ItemNgonNgu {
		public TextView txThongBao;
		public CheckBox cbTrangThai;

	}

}
