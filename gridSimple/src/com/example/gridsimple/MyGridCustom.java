package com.example.gridsimple;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
	public View getView(final int position, View convertView, ViewGroup parent) {
		ItemDoChoi motDoChoi;
		if(convertView == null){
			motDoChoi = new ItemDoChoi();
			LayoutInflater infla = ((Activity)context).getLayoutInflater();
			convertView = infla.inflate(R.layout.mot_do_choi, parent, false);
			motDoChoi.hinh = (ImageView) convertView.findViewById(R.id.imHinh);
			motDoChoi.ten = (TextView) convertView.findViewById(R.id.tvTen);
			motDoChoi.gia = (TextView) convertView.findViewById(R.id.tvGia);
			motDoChoi.btnMua = (Button) convertView.findViewById(R.id.btnMua);
			convertView.setTag(motDoChoi);
		}else {
			motDoChoi = (ItemDoChoi)convertView.getTag();
		}
		motDoChoi.hinh.setImageResource(dsDochoi.get(position).hinh);
		motDoChoi.ten.setText(dsDochoi.get(position).ten);
		motDoChoi.gia.setText(dsDochoi.get(position).gia+"");
		motDoChoi.btnMua.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				hienThiDoVat(dsDochoi.get(position));
			}
		});
		return convertView;
	}
	private void hienThiDoVat(DoChoi doChoi){
		AlertDialog.Builder dialog = new Builder(context);
		dialog.setTitle("Mon hang");
		dialog.setIcon(context.getResources().getDrawable(doChoi.hinh));
		dialog.setMessage("Ten: " + doChoi.ten+ "\n" + "Gia: "+doChoi.gia);
		dialog.setPositiveButton("dong", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
		});
		dialog.show();
	}
	class ItemDoChoi{
		ImageView hinh;
		TextView ten;
		TextView gia;
		Button btnMua;
	}
}
