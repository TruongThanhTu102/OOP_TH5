package tuan9_QLyPhongHoc;

public class PhongHoc implements IPhongHoc{
	protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) throws Exception{
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) throws Exception{
		if(maPhong == null || maPhong.isEmpty()) {
			throw new Exception("Mã phòng không được để trống!!");
		}else {
			this.maPhong = maPhong;
		}
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) throws Exception {
		if(dienTich < 0) {
			throw new Exception("Diện tích phải < 0");
		}else {
			this.dienTich = dienTich;
		}
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) throws Exception {
		if(soBongDen < 0) {
			throw new Exception("Số bóng đèn phải > 0");
		} else {
			this.soBongDen = soBongDen;
		}
	}
	
	public boolean duAnhSang() {
	    if(dienTich / soBongDen >= 10)
	    	return true;
	    return false;
	}
	@Override
	public String phongDatChuan() {
		return "Không đạt chuẩn";
	}


	@Override
	public String toString() {
		return String.format("|%-10s|%-10s|%-10.3f|%-10d", 
				getMaPhong(), getDayNha(), getDienTich(), getSoBongDen());
	}
	
	
}
