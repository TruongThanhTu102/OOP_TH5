
package tuan6_CD;

import java.util.Arrays;
import java.util.Comparator;

public class QuanLyCD {
    private CD[] danhSachCD;
    private int soLuongCD;

    // Constructor
    public QuanLyCD(int maxSize) {
        danhSachCD = new CD[maxSize];
        soLuongCD = 0;
    }

    // Phương thức thêm CD vào danh sách
    public boolean themCD(CD cd) {
        if (soLuongCD >= danhSachCD.length) {
            System.out.println("Danh sách đã đầy.");
            return false;
        }
        for (int i = 0; i < soLuongCD; i++) {
            if (danhSachCD[i].getMaCD() == cd.getMaCD()) {
                System.out.println("Mã CD đã tồn tại.");
                return false;
            }
        }
        danhSachCD[soLuongCD++] = cd;
        return true;
    }

    // Tính số lượng CD
    public int getSoLuongCD() {
        return soLuongCD;
    }

    // Tính tổng giá thành của các CD
    public double tinhTongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < soLuongCD; i++) {
            tong += danhSachCD[i].getGiaThanh();
        }
        return tong;
    }

    // Sắp xếp giảm dần theo giá thành
    public void sapXepGiamDanTheoGiaThanh() {
        Arrays.sort(danhSachCD, 0, soLuongCD, Comparator.comparingDouble(CD::getGiaThanh).reversed());
    }

    // Sắp xếp tăng dần theo tựa CD
    public void sapXepTangDanTheoTuaCD() {
        Arrays.sort(danhSachCD, 0, soLuongCD, Comparator.comparing(CD::getTuaCD));
    }

    // Xuất toàn bộ danh sách
    public void xuatDanhSach() {
        for (int i = 0; i < soLuongCD; i++) {
            System.out.println(danhSachCD[i]);
        }
    }
}
