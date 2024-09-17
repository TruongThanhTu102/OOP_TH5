package tuan3QuanLiSinhVien;

import java.util.Scanner;

public class QuanLiSinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo 3 đối tượng sinh viên
        SinhVien sv1 = new SinhVien(1, "Nguyen Van A", 8.5f, 7.0f);
        SinhVien sv2 = new SinhVien(2, "Le Thi B", 9.0f, 8.5f);
        SinhVien sv3 = new SinhVien();

        // Nhập thông tin cho sv3 từ bàn phím
        System.out.print("Nhập mã sinh viên: ");
        int maSV = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhập điểm lý thuyết: ");
        float diemLT = scanner.nextFloat();

        System.out.print("Nhập điểm thực hành: ");
        float diemTH = scanner.nextFloat();

        sv3.setMaSV(maSV);
        sv3.setHoTen(hoTen);
        sv3.setDiemLT(diemLT);
        sv3.setDiemTH(diemTH);

        // In bảng danh sách sinh viên
        System.out.println("Danh sách sinh viên:");
        System.out.println("MSSV\tHọ tên\tĐiểm LT\tĐiểm TH\tĐiểm TB");
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);

        scanner.close();
    }
}