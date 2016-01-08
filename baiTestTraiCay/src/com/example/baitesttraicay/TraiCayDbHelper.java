package com.example.baitesttraicay;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TraiCayDbHelper extends SQLiteOpenHelper {
	public static String TABLE_NAME= "TraiCay";
	//
	public static String TABLE_COL_USER= "ten";
	public static String TABLE_COL_IMG= "hinh";
	public TraiCayDbHelper(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String TAO_DL = "CREATE  TABLE "+TABLE_NAME+" (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "+TABLE_COL_USER+" VARCHAR, "+TABLE_COL_IMG+" DOUBLE)";
		db.execSQL(TAO_DL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop if exits "+TABLE_NAME);
		onCreate(db);
	}
	//Ham lay danh sach trai cay
	public ArrayList<O_TraiCay> LayDanhSach(){
		ArrayList<O_TraiCay> dsTraiCay;
		dsTraiCay = new ArrayList<O_TraiCay>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cu = db.rawQuery("select id,"+TABLE_COL_USER+","+TABLE_COL_IMG+" from "+TABLE_NAME, null);
		while (cu.moveToNext()) {
			dsTraiCay.add(new O_TraiCay(cu.getInt(0), cu.getString(1), cu.getInt(2)));
		}
		return dsTraiCay;
	}
	//Ham them trai cay moi
	public void themTraiCay(O_TraiCay traiCay){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(TABLE_COL_IMG, traiCay.hinh);
		values.put(TABLE_COL_USER, traiCay.ten);
		db.insert(TABLE_NAME, null, values);
	}
	//Ham xoa trai cai
	public void xoa(int id){
		SQLiteDatabase db = getWritableDatabase();
		db.delete(TABLE_NAME, "id = " +id, null);
	}
}
