package tuan6QuanLiThuVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ThuVien {
    private ArrayList<Sach> danhSachSach;

    public ThuVien() {
        danhSachSach = new ArrayList<>();
    }

    // Thêm sách vào danh sách
    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    // Trả về danh sách sách
    public ArrayList<Sach> getDanhSachSach() {
        return danhSachSach;
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
    public ArrayList<Sach> getSachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        ArrayList<Sach> result = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                result.add(sach);
            }
        }
        return result;
    }

    // Sắp xếp giảm dần theo đơn giá
    public void sapXepGiamDanTheoDonGia() {
        Collections.sort(danhSachSach, new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                return Double.compare(s2.donGia, s1.donGia);  // Sắp xếp giảm dần
            }
        });
    }

    // Sắp xếp giảm dần theo số lượng
    public void sapXepGiamDanTheoSoLuong() {
        Collections.sort(danhSachSach, new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                return Integer.compare(s2.soLuong, s1.soLuong);  // Sắp xếp giảm dần
            }
        });
    }
}
