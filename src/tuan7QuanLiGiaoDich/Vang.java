package tuan7QuanLiGiaoDich;

import java.util.Date;

public class Vang extends GiaoDich{
	private String loai;

	public Vang(String maGD, Date ngayGD, double gia, int soLuong, String loai) {
		super(maGD, ngayGD, gia, soLuong);
		this.loai = loai;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	@Override
    public double thanhTien() {
        return soLuong * gia;
    }
	@Override
	public String toString() {
	    return super.toString() 
	            + " Loại vàng: " + loai + 
	            ", Thành tiền: " + thanhTien();
	}
}

