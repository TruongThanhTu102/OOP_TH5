package tuan8KhoSieuThi;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.TimeUnit;

public class HangSanhSu extends HangHoa{
	public String nhaSX;
	public LocalDate ngayNhapKho;
	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double gia, String nhaSX, LocalDate ngayNhapKho) {
		super(maHang, tenHang, soLuongTon, gia);
		this.nhaSX = nhaSX;
		this.ngayNhapKho = ngayNhapKho;
	}
	public String getNhaSX() {
		return nhaSX;
	}
	public void setNhaSX(String nhaSX) {
		this.nhaSX = nhaSX;
	}
	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if (ngayNhapKho.isAfter(LocalDate.now())) 
			this.ngayNhapKho = LocalDate.now();
		else 
			this.ngayNhapKho = ngayNhapKho;


	}
	@Override
	public double tinhVAT() {
		
		return gia * 0.1;
	}
	 

	@Override
	public String danhGia() {
		Period age = Period.between(ngayNhapKho, LocalDate.now());
		int days = age.getDays();
		
		if(soLuongTon > 50 && days > 10) {
			return "Bán chậm";
		}
		return "Không đánh giá.";

	}
	@Override
	public String toString() {
	    return super.toString() + String.format("%-15s|%-15s|%-20s|%-10s|", 
	                         getNhaSX(), ngayNhapKho,
	                         danhGia(), super.decimalFormat.format(tinhVAT()));
	}
	

}
