package tuan5PhanSo;

public class TestPhanSo {
	public static void main(String[] args) {
        // Tạo các đối tượng phân số
        PhanSo ps1 = new PhanSo(2, 3);
        PhanSo ps2 = new PhanSo(5, 6);

        // Hiển thị các phân số
        System.out.println("Phân số 1: " + ps1);
        System.out.println("Phân số 2: " + ps2);

        // Cộng
        PhanSo ps3 = ps1.cong(ps2);
        System.out.println("Phân số sau khi cộng: " + ps3);

        // Trừ
        PhanSo ps4 = ps1.tru(ps2);
        System.out.println("Phân số sau khi trừ: " + ps4);

        // Nhân
        PhanSo ps5 = ps1.nhan(ps2);
        System.out.println("Phân số sau khi nhân: " + ps5);

        // Chia
        PhanSo ps6 = ps1.chia(ps2);
        System.out.println("Phân số sau khi chia: " + ps6);

        // So sánh
        PhanSo ps7 = new PhanSo(4, 6);
        System.out.println("Phân số 1 và Phân số 2 có bằng nhau không? " + ps1.soSanh(ps2, 0.0001));
        System.out.println("Phân số 1 và Phân số 7 có bằng nhau không? " + ps1.soSanh(ps7, 0.0001));
    }
}