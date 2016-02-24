package com.example.c5_contentprovide;

import java.util.ArrayList;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AdapterDsHinh extends BaseAdapter{

	public ArrayList<String> dsHinh = new ArrayList<String>();

	private LayoutInflater inflater;
	

	public AdapterDsHinh(Context context) {
		super();
		this.dsHinh = /
						/t	/	q	az/i/f/l/t/r = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
}
