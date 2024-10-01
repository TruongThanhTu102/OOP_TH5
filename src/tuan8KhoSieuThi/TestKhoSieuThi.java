package tuan8KhoSieuThi;

import java.time.LocalDate;

public class TestKhoSieuThi {
    public static void main(String[] args) {
        QuanLyHangHoa quanLy = new QuanLyHangHoa();
        
        // Thêm hàng thực phẩm
        HangThucPham tp = new HangThucPham("TP01", "Sữa", 10, 20000, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), "Vinamilk");
        if (!quanLy.themHangHoa(tp)) {
            System.out.println("Mã hàng TP01 đã tồn tại!");
        }
        
        // Thêm hàng điện máy
        HangDienMay dm = new HangDienMay("DM01", "Máy lạnh", 2, 10000000, 12, 2.5);
        if (!quanLy.themHangHoa(dm)) {
            System.out.println("Mã hàng DM01 đã tồn tại!");
        }
        
        // Thêm hàng sành sứ
        HangSanhSu ss = new HangSanhSu("SS01", "Bát sứ", 100, 50000, "Gốm sứ Bát Tràng", LocalDate.of(2023, 9, 1));
        if (!quanLy.themHangHoa(ss)) {
            System.out.println("Mã hàng SS01 đã tồn tại!");
        }

        // In danh sách hàng hóa từ lớp main
        System.out.println("Danh sách hàng hóa:");
        System.out.println(quanLy.layDanhSachHangHoa());
    }
}
