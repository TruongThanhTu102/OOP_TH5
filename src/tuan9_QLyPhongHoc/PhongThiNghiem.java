package tuan9_QLyPhongHoc;

public class PhongThiNghiem extends PhongHoc{
	  private String chuyenNganh;
	  private int sucChua;
	  private boolean coBonRua;
	  public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh,
			  boolean coBonRua, int sucChua) throws Exception {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.coBonRua = coBonRua;
		this.sucChua = sucChua;
	}
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public boolean isCoBonRua() {
		return coBonRua;
	}
	public void setCoBonRua(boolean coBonRua) {
		this.coBonRua = coBonRua;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	@Override
    public String phongDatChuan() {
        if(duAnhSang()==true && coBonRua ) {
        	return "Đạt chuẩn";
        }else 
        	return "Không đạt chuẩn!";
    }
 @Override
	public String toString() {
	    return super.toString() + String.format("|%-27s|%-10s|", isCoBonRua(),
	                          phongDatChuan());
	}
}
