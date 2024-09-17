package tuan6SieuThi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSieuThi {
    public static void main(String[] args) {
        // Định dạng ngày
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Tạo đối tượng hàng thực phẩm với dữ liệu hợp lệ
            Date ngaySanXuat = dateFormat.parse("01/09/2023");
            Date ngayHetHan = dateFormat.parse("01/12/2023");

            HangThucPham htp1 = new HangThucPham("HTP001", "Bánh mì", 15000, ngaySanXuat, ngayHetHan);

            // In thông tin của htp1 ra màn hình
            System.out.println(htp1);
            // Kết quả in ra từ phương thức toString() của đối tượng htp1

            // Kiểm tra hàng thực phẩm đã hết hạn chưa và in kết quả ra màn hình
            if (htp1.kiemTraHetHan()) {
                System.out.println("Hàng thực phẩm đã hết hạn.");
            } else {
                System.out.println("Hàng thực phẩm chưa hết hạn.");
            }

            // Tạo đối tượng hàng thực phẩm với dữ liệu không hợp lệ (ngày hết hạn trước ngày sản xuất)
            Date ngaySanXuat2 = dateFormat.parse("01/09/2023");
            Date ngayHetHan2 = dateFormat.parse("01/08/2023");

            HangThucPham htp2 = new HangThucPham("HTP002", "Sữa tươi", -5000, ngaySanXuat2, ngayHetHan2);

            // In thông tin của htp2 ra màn hình
            System.out.println(htp2);
            // Thông tin của htp2 sẽ được gán với giá trị mặc định cho đơn giá và ngày hết hạn

            // Kiểm tra hàng thực phẩm đã hết hạn chưa và in kết quả ra màn hình
            if (htp2.kiemTraHetHan()) {
                System.out.println("Hàng thực phẩm đã hết hạn.");
            } else {
                System.out.println("Hàng thực phẩm chưa hết hạn.");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
