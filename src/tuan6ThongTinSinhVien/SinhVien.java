package tuan6ThongTinSinhVien;

import java.util.Arrays;
import java.util.Scanner;

// Lớp SinhVien
public class SinhVien {
    // Các thuộc tính private
    private int maSinhVien;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    // Constructor mặc định
    public SinhVien() {
        this.maSinhVien = 0;
        this.hoTen = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }

    // Constructor có tham số
    public SinhVien(int maSinhVien, String hoTen, String diaChi, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    // Getter và Setter cho từng thuộc tính
    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        // Kiểm tra số điện thoại phải có 7 chữ số
        if (soDienThoai.length() == 7 && soDienThoai.matches("\\d+")) {
            this.soDienThoai = soDienThoai;
        } else {
            throw new IllegalArgumentException("Số điện thoại phải bao gồm 7 chữ số.");
        }
    }

    // Phương thức toString để hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return "Mã sinh viên: " + maSinhVien +
               ", Họ tên: " + hoTen +
               ", Địa chỉ: " + diaChi +
               ", Số điện thoại: " + soDienThoai;
    }
}
