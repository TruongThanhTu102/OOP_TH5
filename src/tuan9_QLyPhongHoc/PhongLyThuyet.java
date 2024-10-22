package tuan9_QLyPhongHoc;

public class PhongLyThuyet extends PhongHoc{
	private String coMayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, String coMayChieu) throws Exception {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}
	 public String getCoMayChieu() {
		return coMayChieu;
	}
	public void setCoMayChieu(String coMayChieu) {
		this.coMayChieu = coMayChieu;
	}
	@Override
	    public String phongDatChuan() {
	        if(duAnhSang()==true && coMayChieu == "Có") {
	        	return "Đạt chuẩn";
	        }else 
	        	return "Không đạt chuẩn!";
	    }
	 @Override
		public String toString() {
		    return super.toString() + String.format("%-15s|%-10s", 
		                         getCoMayChieu(), phongDatChuan());
		}
}
