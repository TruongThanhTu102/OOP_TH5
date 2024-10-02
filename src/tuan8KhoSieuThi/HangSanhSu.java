package tuan8KhoSieuThi;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.10;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (soLuongTon > 50 && ngayNhapKho.isBefore(LocalDate.now().minusDays(10))) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("|%-15s|%-15s|\n", "Nhà sản xuất", "Ngày nhập") + 
               String.format("|%-15s|%-15s|\n", nhaSanXuat, ngayNhapKho);
    }
}
