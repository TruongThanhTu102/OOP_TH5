package tuan3QuanLiSinhVien;

class SinhVien {
    // Các thuộc tính private
    private int maSV;
    private String hoTen;
    private float diemLT;
    private float diemTH;

    // Constructor mặc định
    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }

    // Constructor với đầy đủ thông tin
    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    // Getter và Setter cho maSV
    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    // Getter và Setter cho hoTen
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    // Getter và Setter cho diemLT
    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        this.diemLT = diemLT;
    }

    // Getter và Setter cho diemTH
    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        this.diemTH = diemTH;
    }

    // Phương thức tính điểm trung bình
    public float tinhDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    // Phương thức toString để diễn tả đối tượng ở dạng chuỗi
    @Override
    public String toString() {
        return String.format("%d\t%s\t%.2f\t%.2f\t%.2f", maSV, hoTen, diemLT, diemTH, tinhDiemTB());
    }
}
