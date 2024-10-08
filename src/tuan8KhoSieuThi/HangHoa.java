package tuan8KhoSieuThi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class HangHoa implements IHangHoa{
	protected String maHang, tenHang;
	protected int soLuongTon;
	protected double gia;
	
//	abstract double tinhVAT();
//	abstract String danhGia();
	public HangHoa(String maHang, String tenHang, int soLuongTon, double gia) {
		super();
		if(maHang == null || maHang.isEmpty()) throw new IllegalArgumentException("Mã hàng không được để trống!!");
		this.maHang = maHang;
		if(tenHang == null || tenHang.isEmpty()) throw new IllegalArgumentException("Tên hàng không được để trống!!");
		this.tenHang = tenHang;
		if(soLuongTon < 0) throw new IllegalArgumentException("Số lượng tồn phải lớn hơn 0.");
		this.soLuongTon = soLuongTon;
		if(gia < 0.0) throw new IllegalArgumentException("Đơn giá phải lớn hơn 0.");
		this.gia = gia;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		if(!(maHang == null || maHang.isEmpty()))
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(!(tenHang == null || tenHang.isEmpty()))
		this.tenHang = tenHang;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		if(soLuongTon >= 0)
		this.soLuongTon = soLuongTon;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		if(gia > 0.0)
		this.gia = gia;
	}
	
    @Override
	public int hashCode() {
		return Objects.hash(maHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);
	}

	DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public double tinhVAT() {
        return 0;
    }

    @Override
    public String danhGia() {
        return "Không đánh giá.";
    }

	@Override
	public String toString() {
	    return String.format("|%-10s|%-15s|%-15s|%-10d|", 
	                         maHang, tenHang, decimalFormat.format(gia), soLuongTon);
	}
		
}
