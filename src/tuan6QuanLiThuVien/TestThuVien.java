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

            // Xuất danh sách các loại sách
            System.out.println("Danh sách các loại sách:");
            thuVien.xuatDanhSach();

            // Tính tổng thành tiền sách giáo khoa
            System.out.println("Tổng thành tiền sách giáo khoa: " + thuVien.tongThanhTienSachGiaoKhoa());

            // Tính tổng thành tiền sách tham khảo
            System.out.println("Tổng thành tiền sách tham khảo: " + thuVien.tongThanhTienSachThamKhao());

            // Tính trung bình cộng đơn giá sách tham khảo
            System.out.println("Trung bình đơn giá sách tham khảo: " + thuVien.trungBinhDonGiaSachThamKhao());

            // Xuất các sách giáo khoa của nhà xuất bản X
            System.out.print("Nhập tên nhà xuất bản để tìm sách giáo khoa: ");
            String nhaXuatBan = sc.nextLine();
            System.out.println("Danh sách sách giáo khoa của nhà xuất bản " + nhaXuatBan + ":");
            thuVien.xuatSachGiaoKhoaNhaXuatBan(nhaXuatBan);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
