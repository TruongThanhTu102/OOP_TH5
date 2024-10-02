package tuan7QuanLiGiaoDich;

import java.util.Date;

public class Tien extends GiaoDich{
	private double tiGia;
	private String loaiTien;
	
	public Tien(String maGD, Date ngayGD, double gia, int soLuong, double tiGia, String loaiTien) {
		super(maGD, ngayGD, gia, soLuong);
		this.tiGia = tiGia;
		this.loaiTien = loaiTien;
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		this.tiGia = tiGia;
	}

	public String getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}
	@Override
	public double thanhTien() {
		if(loaiTien.equals("USD") || loaiTien.equals("EURO")) {
			return soLuong * gia * tiGia;
		}
		return soLuong * gia;
    }
	@Override
	public String toString() {
	    return super.toString() + 
	           ", Tỉ giá: " + tiGia +
	           ", Loại tiền: " + loaiTien + 
	           ", Thành tiền: " + thanhTien();
	}
}
