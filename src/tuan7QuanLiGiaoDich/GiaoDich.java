package tuan7QuanLiGiaoDich;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class GiaoDich {
	protected String maGD;
	protected Date ngayGD;
	protected double gia;
	protected int soLuong;
	
	abstract double thanhTien();
	
	public GiaoDich(String maGD, Date ngayGD, double gia, int soLuong) {
		super();
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.gia = gia;
		this.soLuong = soLuong;
	}
	

	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaGD() {
		return maGD;
	}

	public void setMaGD(String maGD) {
		this.maGD = maGD;
	}

	public Date getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(Date ngayGD) {
		this.ngayGD = ngayGD;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		return String.format("|%-10s|%-15s|%-10s|%-5d|\n",
				maGD, dateFormat.format(ngayGD), decimalFormat.format(gia),soLuong);
	}
	
	
}
