package tuan6QuanLiThuVien;

import java.util.ArrayList;

class ThuVien {
    private ArrayList<Sach> danhSachSach;

    public ThuVien() {
        danhSachSach = new ArrayList<>();
    }

    // Thêm sách vào danh sách
    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    // Xuất danh sách sách
    public void xuatDanhSach() {
        for (Sach sach : danhSachSach) {
            System.out.println(sach.toString());
        }
    }

    // Tính tổng thành tiền sách giáo khoa
    public double tongThanhTienSachGiaoKhoa() {
        double tong = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa) {
                tong += sach.thanhTien();
            }
        }
        return tong;
    }

    // Tính tổng thành tiền sách tham khảo
    public double tongThanhTienSachThamKhao() {
        double tong = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachThamKhao) {
                tong += sach.thanhTien();
            }
        }
        return tong;
    }

    // Tính trung bình cộng đơn giá sách tham khảo
    public double trungBinhDonGiaSachThamKhao() {
        double tongDonGia = 0;
        int soLuongSachThamKhao = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachThamKhao) {
                tongDonGia += sach.donGia;
                soLuongSachThamKhao++;
            }
        }
        return soLuongSachThamKhao == 0 ? 0 : tongDonGia / soLuongSachThamKhao;
    }

    // Xuất các sách giáo khoa của nhà xuất bản X
    public void xuatSachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                System.out.println(sach.toString());
            }
        }
    }
}
