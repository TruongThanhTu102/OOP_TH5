package tuan8KhoSieuThi;

import java.util.ArrayList;

class QuanLyHangHoa {
    private ArrayList<HangHoa> danhSachHangHoa;

    public QuanLyHangHoa() {
        this.danhSachHangHoa = new ArrayList<>();
    }

    public boolean themHangHoa(HangHoa hangHoa) {
        for (HangHoa hh : danhSachHangHoa) {
            if (hh.maHang.equals(hangHoa.maHang)) {
                return false; // Không cần in ra tại đây, có thể xử lý trong main
            }
        }
        danhSachHangHoa.add(hangHoa);
        return true;
    }

    public String layDanhSachHangHoa() {
        StringBuilder sb = new StringBuilder();
        
        // Thêm tiêu đề
        sb.append(String.format("|%-10s|%-20s|%-15s|%-5s|\n", "Mã hàng", "Tên hàng", "Đơn giá", "SL tồn"));
        
        for (HangHoa hangHoa : danhSachHangHoa) {
            sb.append(hangHoa.toString());
        }
        return sb.toString();
    }
}
