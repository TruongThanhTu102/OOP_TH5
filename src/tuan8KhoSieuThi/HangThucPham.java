package tuan8KhoSieuThi;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (ngayHetHan.isBefore(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất");
        }
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.05;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (soLuongTon > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format("|%-15s|%-10s|%-10s|\n", "Nhà cung cấp", "NSX", "HSD") + 
               String.format("|%-15s|%-10s|%-10s|\n", nhaCungCap, ngaySanXuat, ngayHetHan);
    }
}
