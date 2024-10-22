package tuan9_QLyPhongHoc;

import java.util.Scanner;

public class testPhongHoc {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        QuanLyPhongHoc ds = new QuanLyPhongHoc();
        int choice;
        do {
            Menu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character.
            switch (choice) {
                case 1:
                    nhapCung(ds);
                    break;
                case 2:
                    timPhongHocTheoMa(ds);
                    break;
                case 3:
                    inDanhSach(ds);
                    break;
                case 4:
                    inDanhSachPhongDatChuan(ds);
                    break;
                case 5:
                    sapXepTangTheoDayNha(ds);
                    break;
                case 6:
                    sapXepGiamTheoDienTich(ds);
                    break;
                case 7:
                    sapXepTangTheoSoBongDen(ds);
                    break;
                case 8:
                    xoaPhongHoc(ds);
                    break;
                case 9:
                    inTongSoPhong(ds);
                    break;
                case 10:
                    inDanhSachPhongMayCo60May(ds);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void Menu() {
        System.out.println("====== Phòng Học ======");
        System.out.println("1. Thêm phòng học");
        System.out.println("2. Tìm phòng học theo mã");
        System.out.println("3. In danh sách phòng học");
        System.out.println("4. In phòng học đạt chuẩn");
        System.out.println("5. Sắp xếp theo dãy nhà");
        System.out.println("6. Sắp xếp theo diện tích giảm dần");
        System.out.println("7. Sắp xếp theo số bóng đèn");
        System.out.println("8. Xóa phòng học");
        System.out.println("9. In tổng số phòng học");
        System.out.println("10. In danh sách phòng máy có 60 máy");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void nhapCung(QuanLyPhongHoc ds) throws Exception {
        ds.themPhongHoc(new PhongLyThuyet("LT101", "A1", 100.0, 10, "Có"));
        ds.themPhongHoc(new PhongMayTinh("MT201", "B2", 120.0, 12, 60));
        ds.themPhongHoc(new PhongThiNghiem("TN301", "C3", 150.0, 15, "Hóa học", true, 30));
        System.out.println("Đã thêm các phòng học mẫu vào danh sách.");
    }

    public static void timPhongHocTheoMa(QuanLyPhongHoc ds) {
        System.out.print("Nhập mã cần tìm: ");
        String ma = scanner.nextLine();
        PhongHoc ph = ds.timKiem(ma);
        if (ph == null) {
            System.out.println("Không tìm thấy phòng học có mã: " + ma);
        } else {
            System.out.println("Thông tin phòng học:");
            System.out.println(ph);
        }
    }

    public static void inDanhSach(QuanLyPhongHoc ds) {
        System.out.println("Danh sách phòng học:");
        System.out.println(ds.inDanhSach());
    }

    public static void inDanhSachPhongDatChuan(QuanLyPhongHoc ds) {
        System.out.println("Danh sách phòng học đạt chuẩn:");
        System.out.println(ds.inPhongDatChuan());
    }

    public static void sapXepTangTheoDayNha(QuanLyPhongHoc ds) {
        ds.sapXepTangTheoDayNha();
        System.out.println("Danh sách phòng học sau khi sắp xếp theo dãy nhà:");
        System.out.println(ds.inDanhSach());
    }

    public static void sapXepGiamTheoDienTich(QuanLyPhongHoc ds) {
        ds.sapXepGiamTheoDienTich();
        System.out.println("Danh sách phòng học sau khi sắp xếp theo diện tích giảm dần:");
        System.out.println(ds.inDanhSach());
    }

    public static void sapXepTangTheoSoBongDen(QuanLyPhongHoc ds) {
        ds.sapXepTangTheoSoBongDen();
        System.out.println("Danh sách phòng học sau khi sắp xếp theo số bóng đèn:");
        System.out.println(ds.inDanhSach());
    }

    public static void xoaPhongHoc(QuanLyPhongHoc ds) {
        System.out.print("Nhập mã phòng cần xóa: ");
        String maXoa = scanner.nextLine();
        if (ds.xoaPhongHoc(maXoa)) {
            System.out.println("Xóa thành công phòng học có mã: " + maXoa);
        } else {
            System.out.println("Không tìm thấy phòng học để xóa.");
        }
    }

    public static void inTongSoPhong(QuanLyPhongHoc ds) {
        System.out.println("Tổng số phòng học hiện tại: " + ds.inSoLuongPhongHoc());
    }

    public static void inDanhSachPhongMayCo60May(QuanLyPhongHoc ds) {
        System.out.println("Danh sách phòng máy tính có 60 máy:");
        System.out.println(ds.inPhongCo60May());
    }
}
