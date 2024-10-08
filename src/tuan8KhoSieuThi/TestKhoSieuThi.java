package tuan8KhoSieuThi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestKhoSieuThi {
	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    public static void nhapCung(DanhSach ds) {
	        ds.addHH(new HangThucPham("TP01", "Thịt gà", 20, 50000, LocalDate.parse("23/02/2023", dtf), LocalDate.parse("23/03/2024", dtf), "Công ty ABC"));
	        ds.addHH(new HangDienMay("DM01", "Tủ lạnh", 5, 12000000, 24, 100));
	        ds.addHH(new HangSanhSu("SS01", "Chén sứ", 100, 15000, "Công ty XYZ", LocalDate.parse("01/01/2023", dtf)));
	    }

	public static int  nhapInt(String a) {
		System.out.println(a);
		int n = sc.nextInt();
		sc.nextLine();
		return n;
	}
	public static double nhapDouble(String a) {
		System.out.println(a);
		double n = sc.nextDouble();
		sc.nextLine();
		return n;
	}
	public static String nhapString(String a) {
		System.out.println(a);
		return sc.nextLine();
	}
	
	public static void main(String[] args) throws Exception {
		
		DanhSach ds = new DanhSach();
		
		
		int choice = 0;
		do {
			System.out.println("\n-----------MENU------------\n"
				+ "1.Nhập cứng.\n"
				+ "2.Thêm hàng hóa.\n"
				+ "3.In tất cả danh sách.\n"
				+ "4.In danh sách hàng thực phẩm.\n"
				+ "5.In danh sách hàng điện máy.\n"
				+ "6.In danh sách hàng sành sứ.\n"
				+ "7.Tìm kiếm hàng hóa.\n"
				+ "8.Sắp xếp hàng hóa theo tên.\n"
				+ "9.Sắp xếp hàng hóa theo số lượng tồn.\n"
				+ "10.In các hàng thực phẩm khó bán.\n"
				+ "11.Xóa hàng hóa\n"
				+ "12.Sửa đơn giá hàng hóa\n"
				+ "0.Thoát\n");
			
			choice = nhapInt("Vui lòng nhập lựa chọn: ");
			
			switch (choice) {
			case 1: 
				nhapCung(ds);
				break;
			case 2:
				int chon = 0;
				do {
					System.out.print("Nhập loại hàng muốn nhập\n"
						+ "1.Hàng thực phẩm.\n"
						+ "2.Hàng điện máy.\n"
						+ "3.Hàng sành sứ.\n"
						+ "0.Thoát\n");
					chon = nhapInt("Nhập lựa chọn: ");
					if(chon == 0 ) break;
					String ma = nhapString("Nhập mã: ");
					String ten = nhapString("Nhập tên hàng: ");
					double gia = nhapDouble("Nhập giá:");
					int ton = nhapInt("Nhập số lượng tồn:");
					switch (chon) {
						case 1:
							String tenNCC = nhapString("Nhập tên NCC: ");
							String ngaySX = nhapString("Nhập ngày/tháng/năm sản xuất:");
							String ngayHH = nhapString("Nhập ngày/tháng/năm hết hạn:");
							HangHoa htp = new HangThucPham(ma, ten, ton, gia, LocalDate.parse(ngaySX, dtf), LocalDate.parse(ngayHH, dtf), tenNCC);
							if(ds.addHH(htp)) System.out.println("Thêm thành công.\n");
							else System.out.println("Thêm không thành công.\n");
							break;
						case 2:
							int tgbh = nhapInt("Thời gian bảo hành: ");
							double cs =nhapDouble("Nhập công suất: ");
							HangHoa hdm = new HangDienMay(ma, ten, ton, gia, tgbh, cs);
							if(ds.addHH(hdm)) System.out.println("Thêm thành công.\n");
							else System.out.println("Thêm không thành công.\n");
							break;
						case 3:
							String nsx = nhapString("Nhập Nhà SX: ");
							String ngayNK = nhapString("Nhập Ngày/Tháng/Năm nhập kho: ");
							HangHoa hss = new HangSanhSu(ma, ten, ton, gia, nsx, LocalDate.parse(ngayNK, dtf));
							if(ds.addHH(hss)) System.out.println("Thêm thành công.\n");
							else System.out.println("Thêm không thành công.\n");
							break;
						default:
							break;
					}
				}while(chon !=0 );
				break;
			case 3:
				String tthh = ds.getDSHH();
				System.out.print(tthh);
				break;
			case 4:
				String tttp = ds.getHangTP();
				System.out.print(tttp);
				break;
			case 5:
				String ttdm = ds.getHangDM();
				System.out.print(ttdm);
				break;
			case 6:
				String ttss = ds.getHangSS();
				System.out.print(ttss);
				break;
			case 7:
				String maHH = nhapString("Nhập mã hàng hóa cần tìm:");
				HangHoa hh = ds.timKiem(maHH);
				if(hh == null)
					System.out.print("Không có hàng hóa này!!");
				else
					System.out.println(hh);
				break;
			case 8:
				ds.sapXepTheoTen();
				System.out.println(ds);
				break;
			case 9:
				ds.sapXepGiamTheoSLTon();
				System.out.println(ds);
				break;
			case 10:
				String dskb = ds.getTPKhoBan();
				System.out.println(dskb);
				break;
			case 11:
				String ma = nhapString("Nhập mã hàng hóa cần xóa: ");
				if(ds.xoaHH(ma)) 
					System.out.println("Xóa thành công");
				else 
					System.out.println("Xóa không thành công");
				break;
			case 12:
				String ma2  = nhapString("Nhập mã:");
				double giaMoi  = nhapDouble("Nhập giá mới:");
				ds.suaTT(ma2, giaMoi);
				break;
			default:
				break;
			}
		}while(choice != 0);
		sc.close();
	}
}

