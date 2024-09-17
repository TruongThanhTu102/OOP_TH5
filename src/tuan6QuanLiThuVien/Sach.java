package tuan6QuanLiThuVien;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Sach {
    protected String maSach;
    protected Date ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan) throws Exception {
        this.maSach = maSach;
        this.ngayNhap = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhap);
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngayNhapStr = dateFormat.format(ngayNhap);  // Định dạng ngày nhập chỉ in ra "dd/MM/yyyy"
        return "Mã sách: " + maSach + ", Ngày nhập: " + ngayNhapStr + ", Đơn giá: " + donGia + ", Số lượng: " + soLuong + ", Nhà xuất bản: " + nhaXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
}

// Lớp SachGiaoKhoa kế thừa lớp Sach
class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) throws Exception {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else if (tinhTrang.equalsIgnoreCase("cu")) {
            return soLuong * donGia * 0.5;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tình trạng: " + tinhTrang + ", Thành tiền: " + thanhTien();
    }
}

// Lớp SachThamKhao kế thừa lớp Sach
class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) throws Exception {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thuế: " + thue + ", Thành tiền: " + thanhTien();
    }
}

