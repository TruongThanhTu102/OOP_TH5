package tuan8KhoSieuThi;

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh; // tháng
    private double congSuat; // KW

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (thoiGianBaoHanh < 0) {
            throw new IllegalArgumentException("Thời gian bảo hành phải >= 0");
        }
        if (congSuat <= 0) {
            throw new IllegalArgumentException("Công suất phải > 0");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.10;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (soLuongTon < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("|%-10s|%-10s|\n", "BH (tháng)", "Công suất") + 
               String.format("|%-10d|%-10.2f KW|\n", thoiGianBaoHanh, congSuat);
    }
}
