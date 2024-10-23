package tuan9_QLyPhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class QuanLyPhongHoc {
	private ArrayList<PhongHoc> danhSach;
	
	public QuanLyPhongHoc() {
		danhSach = new ArrayList<>();
	}
	public void themPhongHoc(PhongHoc phong) throws Exception {
		for(PhongHoc ph : danhSach) {
			if(ph.getMaPhong().equals(phong.maPhong)) {
				throw new Exception("Mã Phòng bị trùng!!!");
			}
		}
		danhSach.add(phong);
	}
	public PhongHoc timKiem(String maPhong) {
		for(PhongHoc ph : danhSach) {
			if(ph.getMaPhong().equals(maPhong)) {
				return ph;
			}
		} 
		return null;
	}
	public String inDanhSach() {
	    StringBuilder str = new StringBuilder();
	    str.append(String.format("|%-10s|%-10s|%-10s|%-10s|%-15s|%-10s|\n", 
	            "Mã Phòng", "Dãy Nhà", "Diện Tích", "Số Bóng", "Có Máy Chiếu/60 máy", "Đạt Chuẩn"));
	    for (PhongHoc ph : danhSach) {
	        str.append(ph.toString()).append("\n");
	    }
	    return str.toString();
	}
	public String inPhongDatChuan() {
		String str = " ";
		for(PhongHoc ph : danhSach) {
			if(ph instanceof IPhongHoc && ((IPhongHoc) ph).phongDatChuan()=="Đạt chuẩn") {
				str += "\n"+ ph;
			}
		}
		return str;
	}
	public void sapXepTangTheoDayNha() {
		Collections.sort(danhSach, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha()); 
			}
		});
	}
	public void sapXepGiamTheoDienTich() {
		Collections.sort(danhSach, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return Double.valueOf(o2.dienTich).compareTo(o1.dienTich);
			}
		});
	}
	public void sapXepTangTheoSoBongDen() {
		Collections.sort(danhSach, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return Integer.valueOf(o1.soBongDen).compareTo(o2.soBongDen);
			}
		});
	}
	public boolean xoaPhongHoc(String maPhong) {
		for(PhongHoc ph : danhSach) {
			if(ph.getMaPhong().equals(maPhong)) {
				return danhSach.remove(ph);
			}
		} return false;
	}
	public int inSoLuongPhongHoc() {
		return danhSach.size();
	}
	public String inPhongCo60May() {
		String str = " ";
		for(PhongHoc ph : danhSach) {
			if(ph instanceof PhongMayTinh && ((PhongMayTinh) ph).getSoMayTinh()==60) {
				str += "\n"+ph;
			}
		} return str;
	}
}
