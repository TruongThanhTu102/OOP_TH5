package tuan6ThongTinSinhVien;

import java.util.Arrays;
import java.util.Scanner;

public class QuanLySinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng sinh viên
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Nhận newline sau nextInt

        // Khởi tạo mảng sinh viên
        SinhVien[] danhSachSinhVien = new SinhVien[n];

        // Nhập thông tin cho từng sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");

            System.out.print("Mã sinh viên: ");
            int maSinhVien = scanner.nextInt();
            scanner.nextLine(); // Nhận newline sau nextInt

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();

            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();

            System.out.print("Số điện thoại (7 chữ số): ");
            String soDienThoai = scanner.nextLine();

            // Khởi tạo đối tượng sinh viên và thêm vào mảng
            danhSachSinhVien[i] = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai);
        }

        // Sắp xếp danh sách sinh viên theo mã sinh viên tăng dần
        Arrays.sort(danhSachSinhVien, (sv1, sv2) -> sv1.getMaSinhVien() - sv2.getMaSinhVien());

        // Xuất danh sách sinh viên ra màn hình
        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv);
        }

        scanner.close();
    }
}