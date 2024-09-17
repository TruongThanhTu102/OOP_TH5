package tuan1HinhChuNhaat;

import java.util.Scanner;

public class TestHCN {
	public static int nhapSoNguyen (String thongbao)
	{
		int a;
		System.out.println(thongbao);
		Scanner scr = new Scanner(System.in);
		a = scr.nextInt();
		return a;
	}
	public static HCN nhapThongTinDoiTuong()
	{
		int cd,cr;
		HCN cn;
		cd=nhapSoNguyen("Nhap Chieu Dai: ");
		cr=nhapSoNguyen("Nhap Chieu Rong: ");
		cn= new HCN(cd,cr);
		return cn;
	}
	static String tieuDe()
	{
		return String.format("%-10s %-10s %-12s %-12s ", "Chieu Dai","Chieu Rong","Dien Tich","Chu Vi");
		
	}
	public static void nhapCung()
	{
		HCN cn1,cn2,cn3;
		cn1 = new HCN(12,6);
		cn2 = new HCN(8,3);
		cn3 = new HCN(7,2);
		System.out.println(cn1);
		System.out.println(cn2);
		System.out.println(cn3);
		
	}
	public static void main(String[] args)
	{
		HCN cn1,cn2;
		System.out.println("Chuong Trinh Xu Li HCN");
		System.out.println(tieuDe());
		nhapCung();
	}
}
