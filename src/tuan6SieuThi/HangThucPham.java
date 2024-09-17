package tuan6SieuThi;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
    // Các thuộc tính
    private final String maHang;  // không được sửa, không được để rỗng
    private String tenHang;       // không được để rỗng
    private double donGia;        // phải > 0
    private Date ngaySanXuat;     // không được để rỗng
    private Date ngayHetHan;      // không được để rỗng, phải sau ngày sản xuất

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        // Kiểm tra mã hàng, không được rỗng
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        this.maHang = maHang;

        // Kiểm tra tên hàng, không được rỗng, nếu rỗng gán giá trị mặc định
        this.tenHang = (tenHang == null || tenHang.trim().isEmpty()) ? "Tên hàng mặc định" : tenHang;

        // Kiểm tra đơn giá, phải lớn hơn 0, nếu không gán giá trị mặc định là 1000
        this.donGia = (donGia > 0) ? donGia : 1000;

        // Kiểm tra ngày sản xuất và ngày hết hạn, nếu không hợp lệ gán giá trị mặc định
        if (ngaySanXuat == null || ngayHetHan == null || !ngayHetHan.after(ngaySanXuat)) {
            this.ngaySanXuat = new Date();  // Mặc định ngày hiện tại
            this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + 86400000L);  // Mặc định 1 ngày sau ngày sản xuất
        } else {
            this.ngaySanXuat = ngaySanXuat;
            this.ngayHetHan = ngayHetHan;
        }
    }

    // Constructor chỉ có mã hàng
    public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        this.maHang = maHang;
        this.tenHang = "Tên hàng mặc định";
        this.donGia = 1000;
        this.ngaySanXuat = new Date();
        this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + 86400000L);
    }

    // Getters và Setters
    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang != null && !tenHang.trim().isEmpty()) {
            this.tenHang = tenHang;
        } else {
            // Không làm gì nếu tên hàng không hợp lệ
            this.tenHang = "Tên hàng mặc định";
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            // Không làm gì nếu đơn giá không hợp lệ, hoặc gán giá trị mặc định nếu cần
            this.donGia = 1000;
        }
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat != null) {
            this.ngaySanXuat = ngaySanXuat;
        }
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan != null && ngayHetHan.after(this.ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        }
    }

    // Phương thức kiểm tra hàng thực phẩm đã hết hạn chưa
    public boolean kiemTraHetHan() {
        Date today = new Date();
        return today.after(ngayHetHan);
    }

    // Phương thức toString định dạng đơn giá và ngày tháng
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###.00");

        return "Mã hàng: " + maHang +
               ", Tên hàng: " + tenHang +
               ", Đơn giá: " + df.format(donGia) + " VND" +
               ", Ngày sản xuất: " + dateFormat.format(ngaySanXuat) +
               ", Ngày hết hạn: " + dateFormat.format(ngayHetHan);
    }
}

