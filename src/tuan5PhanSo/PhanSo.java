package tuan5PhanSo;

public class PhanSo{
	private float tu;
	private float mau;
	public PhanSo(float tu, float mau) {
		super();
		if(mau==0) {
			throw new IllegalArgumentException("Mau so khong the bang 0");
		}
		
		this.tu = tu;
		this.mau = mau;
		toigian();
	}
	public PhanSo() {
		super();
		
	}
	public float getTu() {
		return tu;
	}
	public void setTu(float tu) {
		this.tu = tu;
	}
	public float getMau() {
		return mau;
	}
	public void setMau(float mau) {
		this.mau = mau;
	}
public float Ucln(float a, float b) {
	while(b !=0) {
		float tmp= b;
		b = a%b;
		a= tmp;
	}
	return Math.abs(a);
}
public void toigian() {
	float ucln = Ucln(tu,mau);
	tu /= ucln;
	mau /= ucln;
}
public PhanSo nghichDao() {
    if (tu == 0) {
        throw new ArithmeticException("Phân số có tử số bằng 0 không có nghịch đảo");
    }
    return new PhanSo(mau, tu);
}

public PhanSo cong(PhanSo khac) {
    float tuMoi = this.tu * khac.mau + this.mau * khac.tu;
    float mauMoi = this.mau * khac.mau;
    return new PhanSo(tuMoi, mauMoi);
}

public PhanSo tru(PhanSo khac) {
    float tuMoi = this.tu * khac.mau - this.mau * khac.tu;
    float mauMoi = this.mau * khac.mau;
    return new PhanSo(tuMoi, mauMoi);
}

public PhanSo nhan(PhanSo khac) {
    float tuMoi = this.tu * khac.tu;
    float mauMoi = this.mau * khac.mau;
    return new PhanSo(tuMoi, mauMoi);
}

public PhanSo chia(PhanSo khac) {
    if (khac.tu == 0) {
        throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0");
    }
    return this.nhan(khac.nghichDao());
}

public boolean soSanh(PhanSo khac, double saiSo) {
    double giaTriThis = (double) this.tu / this.mau;
    double giaTriKhac = (double) khac.tu / khac.mau;
    return Math.abs(giaTriThis - giaTriKhac) < saiSo;
}
@Override
public String toString() {
	return "PhanSo [" + tu + ", " + mau + "]";
}

 }