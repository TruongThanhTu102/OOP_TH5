package tuan8KhoSieuThi;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        if (maHang == null || maHang.isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống");
        }
        if (tenHang == null || tenHang.isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được để trống");
        }
        if (soLuongTon < 0) {
            throw new IllegalArgumentException("Số lượng tồn phải >= 0");
        }
        if (donGia <= 0) {
            throw new IllegalArgumentException("Đơn giá phải > 0");
        }
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public abstract double tinhVAT();

    public abstract String danhGiaMucDoBanBuon();

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return String.format("|%-10s|%-20s|%-15s|%-5d|\n",
                maHang, tenHang, decimalFormat.format(donGia), soLuongTon);
    }
}