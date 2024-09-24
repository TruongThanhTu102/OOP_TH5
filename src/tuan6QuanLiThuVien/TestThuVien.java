package tuan6QuanLiThuVien;

import java.util.Scanner;

public class TestThuVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThuVien thuVien = new ThuVien();

        try {
            // Nhập số lượng sách
            System.out.print("Nhập số lượng sách: ");
            int soLuongSach = sc.nextInt();
            sc.nextLine();  // Đọc bỏ dòng xuống

            // Nhập thông tin sách
            for (int i = 0; i < soLuongSach; i++) {
                System.out.println("Nhập loại sách (1 - Sách giáo khoa, 2 - Sách tham khảo): ");
                int loaiSach = sc.nextInt();
                sc.nextLine();  // Đọc bỏ dòng xuống

                if (loaiSach == 1) {
                    // Nhập thông tin sách giáo khoa
                    System.out.print("Nhập mã sách: ");
                    String maSach = sc.nextLine();
                    System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
                    String ngayNhap = sc.nextLine();
                    System.out.print("Nhập đơn giá: ");
                    double donGia = sc.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();  // Đọc bỏ dòng xuống
                    System.out.print("Nhập nhà xuất bản: ");
                    String nhaXuatBan = sc.nextLine();
                    System.out.print("Nhập tình trạng (moi/cu): ");
                    String tinhTrang = sc.nextLine();

                    SachGiaoKhoa sgk = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
                    thuVien.themSach(sgk);

                } else if (loaiSach == 2) {
                    // Nhập thông tin sách tham khảo
                    System.out.print("Nhập mã sách: ");
                    String maSach = sc.nextLine();
                    System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
                    String ngayNhap = sc.nextLine();
                    System.out.print("Nhập đơn giá: ");
                    double donGia = sc.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();  // Đọc bỏ dòng xuống
                    System.out.print("Nhập nhà xuất bản: ");
                    String nhaXuatBan = sc.nextLine();
                    System.out.print("Nhập thuế: ");
                    double thue = sc.nextDouble();

                    SachThamKhao stk = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, thue);
                    thuVien.themSach(stk);
                }
            }

            // Xuất danh sách sách chưa sắp xếp
            System.out.println("Danh sách sách chưa sắp xếp:");
            for (Sach sach : thuVien.getDanhSachSach()) {
                System.out.println(sach.toString());
            }

            // Sắp xếp giảm dần theo đơn giá và in ra kết quả
            thuVien.sapXepGiamDanTheoDonGia();
            System.out.println("\nSắp xếp giảm dần theo đơn giá:");
            for (Sach sach : thuVien.getDanhSachSach()) {
                System.out.println(sach.toString());
            }

            // Sắp xếp giảm dần theo số lượng và in ra kết quả
            thuVien.sapXepGiamDanTheoSoLuong();
            System.out.println("\nSắp xếp giảm dần theo số lượng:");
            for (Sach sach : thuVien.getDanhSachSach()) {
                System.out.println(sach.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
