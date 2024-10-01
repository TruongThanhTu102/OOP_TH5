package tuan7QuanLiGiaoDich;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuanLi {
	public static void main(String[] args) throws ParseException {
		ArrayList<GiaoDich> danhSachGD = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Nhập số lượng giao dịch: ");
		int sl = sc.nextInt();
		 
		for(int i=0; i<sl; i++) {
			System.out.println("Nhập giao dịch thứ " +(i+1));
			System.out.println("1: Giao dịch vàng, 2: Giao dịch tiền");
			int nhap = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Nhập mã giao dịch: ");
            String maGD = sc.nextLine();
            sc.nextLine();
            System.out.println("Nhập ngày: ");
            String ngayGD = sc.nextLine();
            Date ngay = dateFormat.parse(ngayGD);
            System.out.print("Nhập đơn giá: ");
            double gia = sc.nextDouble();
            System.out.print("Nhập số lượng: ");
            int soLuong = sc.nextInt();
            sc.nextLine();
		
            if(nhap == 1) {
            	//nhập vàng
            	System.out.println("Nhập loại vàng: ");
            	String loai = sc.nextLine();
            	Vang gdVang = new Vang(maGD, ngay, gia, soLuong, loai);
                danhSachGD.add(gdVang);
            }
            else if(nhap == 2) {
            	//nhập tiền
            	System.out.println("Nhập tỉ giá: ");
            	double tiGia = sc.nextDouble();
            	sc.nextLine();
            	System.out.println("Nhập loại tiền(Vn, USD, EURO): ");
            	String loaiTien = sc.nextLine();
            	Tien gdTien = new Tien(maGD, ngay, gia, soLuong, tiGia, loaiTien);
            	danhSachGD.add(gdTien);
            }
		}
		// In danh sách giao dịch
		System.out.printf("%10s %15s %10s %10s %10s %10s\n", "Mã", "Ngày", "Giá", "Số lượng", "Loại", "Thành tiền");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		for (GiaoDich gd : danhSachGD) {
		    String ngayGD = dateFormat1.format(gd.ngayGD);
		    String loai = (gd instanceof Vang) ? ((Vang) gd).getLoai() : ((Tien) gd).getLoaiTien();
		    System.out.printf("%10s %15s %10.2f %10d %10s %10.2f\n", gd.maGD, ngayGD, gd.gia, gd.soLuong, loai, gd.thanhTien());
		}


		//tính tổng số lượng
		double tongVang = 0.0, tongTien = 0.0;
		for(GiaoDich gd : danhSachGD) {
			if(gd instanceof Vang) {
				tongVang += gd.soLuong;
			} else if(gd instanceof Tien) {
				tongTien += gd.soLuong;
			}
		}
		System.out.println("Tổng số lượng giao dịch vàng: "+ tongVang);
		System.out.println("Tổng số lượng giao dịch tiền: "+ tongTien);
		//tính trung bình thành tiền của giao dịch tiền
		double tong = 0.0;
		int dem = 0;
		for(GiaoDich gd : danhSachGD) {
			if(gd instanceof Tien) {
				tong += gd.thanhTien();
				dem++;
			}
		}
		double trungBinh = dem > 0 ? tong/dem : 0;
		System.out.println("Trung bình thành tiền của giao dịch tiền: "+ trungBinh);
		
		// xuất giao dịch > 1 tỉ
		System.out.println("Các giao dịch lớn hơn 1 tỉ: ");
		for(GiaoDich gd : danhSachGD) {
			if(gd.gia > 1000000000) {
				System.out.println(gd.toString());
			}
		}
	}
}
