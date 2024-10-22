package tuan9_QLyPhongHoc;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) throws Exception {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}
	@Override
    public String phongDatChuan() {
        if(duAnhSang()==true && (dienTich / soMayTinh >= 1.5)) {
        	return "Đạt chuẩn";
        }else 
        	return "Không đạt chuẩn!";
    }
 @Override
	public String toString() {
	    return super.toString() + String.format("%-15d|%-10s", 
	                         getSoMayTinh(), phongDatChuan());
	}
}
