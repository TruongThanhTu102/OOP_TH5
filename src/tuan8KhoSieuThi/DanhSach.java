package tuan8KhoSieuThi;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSach {
	private ArrayList<HangHoa> listHH;

	public DanhSach() {
		this.listHH = new ArrayList<HangHoa>();
	}
	//thêm 1 hàng hóa vào danh sách
	public boolean addHH(HangHoa hang) {
		if(listHH.contains(hang))
			return false;
		listHH.add(hang);
		return true;
	}
	// lấy thông tin toàn bộ hàng hóa
	public String getDSHH() {
	    String ttHH = String.format("|%-10s|%-15s|%-15s|%-10s|%-15s|%-15s|%-20s|%-10s|%-10s|\n", 
	                                "Mã hàng", "Tên hàng", "Giá", "Số lượng", "Thông tin phụ 1", "Thông tin phụ 2", 
	                                "Nhà cung cấp/SX", "Đánh giá", "VAT");
	    for (HangHoa hangHoa : listHH) {
	        ttHH += "\n" + hangHoa;
	    }
	    return ttHH;
	}

	// lấy thông tin từng loại hàng hóa
	public String getHangTP() {
	    String str = String.format("|%-10s|%-15s|%-15s|%-10s|%-15s|%-15s|%-20s|%-10s|%-10s|\n", 
	                               "Mã hàng", "Tên hàng", "Giá", "Số lượng", "Ngày SX", "Ngày HH", 
	                               "Nhà cung cấp", "Đánh giá", "VAT");
	    for (HangHoa hangHoa : listHH) {
	        if (hangHoa instanceof HangThucPham) {
	            str += "\n" + hangHoa;
	        }
	    }
	    return str;
	}

	public String getHangDM() {
	    String str = String.format("|%-10s|%-15s|%-15s|%-10s|%-15s|%-15s|%-20s|%-10s|%-10s|\n", 
	                               "Mã hàng", "Tên hàng", "Giá", "Số lượng", "TG Bảo Hành", "Công suất", 
	                               "Thông tin phụ", "Đánh giá", "VAT");
	    for (HangHoa hangHoa : listHH) {
	        if (hangHoa instanceof HangDienMay) {
	            str += "\n" + hangHoa;
	        }
	    }
	    return str;
	}

	public String getHangSS() {
	    String str = String.format("|%-10s|%-15s|%-15s|%-10s|%-15s|%-15s|%-20s|%-10s|%-10s|\n", 
	                               "Mã hàng", "Tên hàng", "Giá", "Số lượng", "Nhà SX", "Ngày nhập kho", 
	                               "Thông tin phụ", "Đánh giá", "VAT");
	    for (HangHoa hangHoa : listHH) {
	        if (hangHoa instanceof HangSanhSu) {
	            str += "\n" + hangHoa;
	        }
	    }
	    return str;
	}

	// tìm kiếm hàng hóa khi biết mã hàng
	public HangHoa timKiem(String maHang) {
		for(HangHoa hangHoa : listHH) 
			if(hangHoa.getMaHang().equals(maHang))
				return hangHoa;
		return null;
		
	}
	// tìm kiếm tên hàng khi biết tên hàng
	public HangHoa timKiem1(String tenHang) {
		for(HangHoa hangHoa : listHH)
			if(hangHoa.getTenHang().equals(tenHang))
				return hangHoa;
		return null;
	}
	// sắp xếp hàng hóa tăng dần theo tên
	public void sapXepTheoTen() {
		Collections.sort(listHH, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {			
				return o1.getTenHang().compareToIgnoreCase(o2.getTenHang());
			}		
		});
	}
	// sắp xếp giảm đần theo số lượng tồn
	public void sapXepGiamTheoSLTon() {
		Collections.sort(listHH, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				return Integer.valueOf(o2.soLuongTon).compareTo(o1.soLuongTon);
			}
			
		});
	}
	//lấy thông tin các thực phẩm khó bán
		public String getTPKhoBan() {
			String str = " ";
			for(HangHoa hangHoa : listHH) 
				if((hangHoa instanceof HangThucPham) && hangHoa.danhGia().equals("Khó Bán"))
					str += "\n" + hangHoa;
			return str;
		}
	// xóa mặt hàng khi biết mã hàng
		public boolean xoaHH(String maHang) {
			for(HangHoa hangHoa : listHH)
				if(hangHoa.equals(maHang))
					return listHH.remove(hangHoa);
			return false;
		}
	// sửa thông tin đơn giá khi biết mã hàng
		public boolean suaTT(String maHang, double giaMoi) {
			HangHoa hangHoa = timKiem(maHang);
			if(hangHoa == null)
				return false;
			hangHoa.setGia(giaMoi);
			return true;
		}
		@Override
		public String toString() {
			String s = "Danh sach hang hoa:";
			for (HangHoa hangHoa : listHH) {
				s += "\n"+ hangHoa;
			}
			return s;
		}
		
}
