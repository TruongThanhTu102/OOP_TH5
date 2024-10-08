package tuan8KhoSieuThi;

import java.time.LocalDate;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySX, ngayHH;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double gia, LocalDate ngaySX, LocalDate ngayHH, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, gia);
        if (ngayHH.isBefore(ngaySX)) throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất!!");
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(LocalDate ngaySX) {
        this.ngaySX = ngaySX;
    }

    public LocalDate getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(LocalDate ngayHH) {
        this.ngayHH = ngayHH;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return gia * 0.05;
    }

    @Override
    public String danhGia() {
        if (soLuongTon > 0 && ngayHH.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-15s|%-15s|%-20s|%-10s|%-10s|", 
                ngaySX, ngayHH, getNhaCungCap(), danhGia(), super.decimalFormat.format(tinhVAT()));
    }
}

