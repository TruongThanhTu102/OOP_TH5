package tuan8KhoSieuThi;

public class HangDienMay extends HangHoa{
	public int TG_BaoHanh; 
	public double congSuat;
	public HangDienMay(String maHang, String tenHang, int soLuongTon, double gia, int tG_BaoHanh, double congSuat) {
		super(maHang, tenHang, soLuongTon, gia);
		if(TG_BaoHanh < 0) throw new IllegalArgumentException("Thời gian bảo hành phải > 0.");
		TG_BaoHanh = tG_BaoHanh;
		if(congSuat <= 0) throw new IllegalArgumentException("Công suất phải lớn hơn 0.");
		this.congSuat = congSuat;
	}
	public int getTG_BaoHanh() {
		return TG_BaoHanh;
	}
	public void setTG_BaoHanh(int tG_BaoHanh) {
		if(TG_BaoHanh > 0)
		TG_BaoHanh = tG_BaoHanh;
	}
	public double getCongSuat() {
		return congSuat;
	}
	public void setCongSuat(double congSuat) {
		if(congSuat > 0)
		this.congSuat = congSuat;
	}
	@Override
	public double tinhVAT() {
		// TODO Auto-generated method stub
		return gia * 0.1;
	}
	@Override
	public String danhGia() {
		// TODO Auto-generated method stub
		if(soLuongTon <3)
			return "Bán Được";
		return "Không có đánh giá.";
	} 
	@Override
	public String toString() {
	    return super.toString() + String.format("%-15d|%-15.2f|%-20s|%-10s|", 
	                         TG_BaoHanh, congSuat,
	                         danhGia(), super.decimalFormat.format(tinhVAT()));
	}
	
}
