package com.example.c5_tong_hop;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SinhVienHelper extends SQLiteOpenHelper {
	public static String DATABASE_NAME = "qlsv";
	public static String TABLE_NAME = "sinhvien";
	// key
	public static String SINHVIEN_ID = "id";
	public static String SINHVIEN_NAME = "ten";
	public static String SINHVIEN_DC = "email";
	String CREATE_TABLE_STRING = "CREATE  TABLE " + TABLE_NAME + " ("
			+ SINHVIEN_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "
			+ SINHVIEN_NAME + " VARCHAR, " + SINHVIEN_DC + " TEXT)";

	public SinhVienHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_STRING);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exits " + TABLE_NAME);
		onCreate(db);
	}

	// Ham thong ke danh sach
	public ArrayList<O_SinhVien> danhSach() {
		ArrayList<O_SinhVien> dsSinhVien = new ArrayList<O_SinhVien>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cu = db.rawQuery("select * from " + TABLE_NAME, null);
		while (cu.moveToNext()) {
			dsSinhVien.add(new O_SinhVien(cu.getInt(0), cu.getString(1), cu
					.getString(2)));
		}
		return dsSinhVien;
	}
	public int xoa(int id){
		SQLiteDatabase db = getWritableDatabase();
		return db.delete(TABLE_NAME, "id = " + id, null);
	}
}
