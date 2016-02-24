package com.example.c5_tong_hop;

public class O_SinhVien {
	int id;
	String ten;
	String diaChi;
	public O_SinhVien(int id, String ten, String diaChi) {
		this.id = id;
		this.ten = ten;
		this.diaChi = diaChi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
