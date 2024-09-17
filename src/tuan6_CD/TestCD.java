
package tuan6_CD;

import java.util.Scanner;

public class TestCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyCD quanLyCD = new QuanLyCD(10); // Giới hạn số lượng CD là 10 cho ví dụ

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Thêm CD");
            System.out.println("2. Xem số lượng CD");
            System.out.println("3. Tính tổng giá thành của các CD");
            System.out.println("4. Sắp xếp giảm dần theo giá thành");
            System.out.println("5. Sắp xếp tăng dần theo tựa CD");
            System.out.println("6. Xuất toàn bộ danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự dòng mới còn sót lại

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã CD: ");
                    int maCD = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự dòng mới còn sót lại

                    System.out.print("Nhập tựa CD: ");
                    String tuaCD = scanner.nextLine();

                    System.out.print("Nhập ca sĩ: ");
                    String caSy = scanner.nextLine();

                    System.out.print("Nhập số bài hát: ");
                    int soBaiHat = scanner.nextInt();

                    System.out.print("Nhập giá thành: ");
                    double giaThanh = scanner.nextDouble();

                    CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
                    quanLyCD.themCD(cd);
                    break;

                case 2:
                    System.out.println("Số lượng CD hiện tại: " + quanLyCD.getSoLuongCD());
                    break;

                case 3:
                    System.out.println("Tổng giá thành của các CD: " + quanLyCD.tinhTongGiaThanh());
                    break;

                case 4:
                    quanLyCD.sapXepGiamDanTheoGiaThanh();
                    System.out.println("Danh sách CD sau khi sắp xếp giảm dần theo giá thành:");
                    quanLyCD.xuatDanhSach();
                    break;

                case 5:
                    quanLyCD.sapXepTangDanTheoTuaCD();
                    System.out.println("Danh sách CD sau khi sắp xếp tăng dần theo tựa CD:");
                    quanLyCD.xuatDanhSach();
                    break;

                case 6:
                    System.out.println("Danh sách CD hiện tại:");
                    quanLyCD.xuatDanhSach();
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
