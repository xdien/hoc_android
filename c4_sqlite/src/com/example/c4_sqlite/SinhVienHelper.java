package com.example.c4_sqlite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SinhVienHelper extends SQLiteOpenHelper{
	public static String DATABASE_NAME = "qlsv";
	public static String TABLE_NAME = "sinhvien";
	//key
	public static String SINHVIEN_ID = "id";
	public static String SINHVIEN_NAME = "ten";
	public static String SINHVIEN_DC = "dc";
	String CREATE_TABLE_STRING = "CREATE  TABLE "+TABLE_NAME+" ("+SINHVIEN_ID+" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "+SINHVIEN_NAME+" VARCHAR, "+SINHVIEN_DC+" TEXT)";

	public SinhVienHelper(Context context, String name, int version) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Tao bang mau
		db.execSQL(CREATE_TABLE_STRING);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exits "+TABLE_NAME);
		onCreate(db);
	}
	public void themMoi(O_SinhVien sv){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(SINHVIEN_NAME, sv.getTen());
		values.put(SINHVIEN_DC, sv.getDiaChi());
		db.insert(TABLE_NAME, null, values);
	}
	
	public int xoa(int id){
		SQLiteDatabase db = getWritableDatabase();
		return db.delete(TABLE_NAME, "id = " + id, null);
	}
	//Ham thong ke danh sach
	public ArrayList<O_SinhVien> danhSach(){
		ArrayList<O_SinhVien> dsSinhVien = new ArrayList<O_SinhVien>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cu = db.rawQuery("select * from " +TABLE_NAME, null);
		while(cu.moveToNext()){
			dsSinhVien.add(new O_SinhVien(cu.getInt(0), cu.getString(1), cu.getString(2)));
		}
		return dsSinhVien;
	}
	//Ham lay sinh vien theo id
	public O_SinhVien laySinhVien(int id){
		SQLiteDatabase db = getReadableDatabase();
		Cursor cu = db.rawQuery("select * from " +TABLE_NAME + "where id="+id, null);
		if(cu.moveToNext()){
			return new O_SinhVien(cu.getInt(0), cu.getString(1), cu.getString(2));
		}
		return null;
	}
}
