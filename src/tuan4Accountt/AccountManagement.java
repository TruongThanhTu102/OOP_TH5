package tuan4Accountt;

import java.util.Scanner;
public class AccountManagement {
	static Scanner sn;
	static AccountArr accountList;
	public static String inputString(String s) {
		String str;
		System.out.print(s);
		sn = new Scanner(System.in);
		str = sn.nextLine();
		return str;
	}
	public static int inputInt(String s) {
		int numInt;
		System.out.print(s);
		sn = new Scanner(System.in);
		numInt = sn.nextInt();
		return numInt;
	}
	public static long inputLong(String s) {
		long numLong;
		System.out.print(s);
		sn = new Scanner(System.in);
		numLong = sn.nextInt();
		return numLong;
	}
	public static double inputDouble(String s) {
		double numDouble;
		System.out.print(s);
		sn = new Scanner(System.in);
		numDouble = sn.nextFloat();
		return numDouble;
	}
	public static void createDefaultAccountList() throws Exception {
	    Account[] accounts = {
	        new Account(1017020607, "Lê Hoàng Bảo"),
	        new Account(1017046087, "Tạ Văn Ơn", 5000000),
	        new Account(1017061096, "Cù Văn Cần", 1000000),
	        new Account(1017030708, "Bao Bao", 300000)
	    };

	    for (Account account: accounts) {
	        accountList.add(account);
	    }
	}
	public static Account createAccount() throws Exception {
		Account acc;
		long accountNumber;
		String  name;
		double balance;
		accountNumber = inputLong("Nhập số tài khoản: ");
		while(accountList.isExistingAccNumber(accountNumber)) {
			System.out.println("Số tài khoản đã tồn tại.");
			accountNumber = inputLong("Vui lòng nhập lại: ");
		}
		name = inputString("Nhập tên tài khoản: ");
		balance = inputDouble("Nhập số tiền khởi tạo cho tài khoản: ");
		acc = new Account(accountNumber, name, balance);
		return acc;
	}
	public static void deleteAccount() throws Exception{
		long accountNumber = inputInt("Nhập số tài khoản cần xoá: ");
		Account acc = accountList.getAccountByAccNumber(accountNumber);
		if(acc != null) {
			System.out.printf("%-20s %-30s %-20s\n", "Số tài khoản", "Họ và tên", "Số Dư");
			System.out.println(acc);
			String confirm = inputString("\nBạn có chắc muốn xoá tài khoản này không?(y/n): ");
			if(confirm.equalsIgnoreCase("y")) {
				accountList.delete(accountNumber);
				System.out.println("Đã xoá thành công.");
			}else 
				System.out.println("Xoá thất bại.");
		}else
			System.out.println("Không tìm thấy tài khoản.");
	}
	public static void updateAccount() throws Exception{
		long accountNumber = inputInt("\nNhập số tài khoản cần sửa: ");
		Account acc = accountList.getAccountByAccNumber(accountNumber);
		if(acc != null) {
			System.out.println("\nTrước khi sửa: ");
			System.out.printf("%-20s %-30s %-20s\n", "Số tài khoản", "Họ và tên", "Số Dư");
			System.out.println(acc);
			String name = inputString("\nNhập tên tài khoản mới: ");
			double balance = inputDouble("Nhập số dư mới: ");
			acc.setName(name);
			acc.setBalance(balance);
			accountList.update(acc);
		}else
			System.out.println("Không tìm thấy tài khoản.");
	}
	public static void deposit() throws Exception{
		double amount;
		long accountNumber = inputLong("\nNhập số tài khoản cần nạp: ");
		Account acc = accountList.getAccountByAccNumber(accountNumber);
		if(acc != null) {
			amount = inputDouble("Nhập số tiền cần nạp: ");
			acc.deposit(amount);
			System.out.println("--- Nạp thành công!!! ---");
		}else
			System.out.println("Không tìm thấy tài khoản.");
	}
	public static void withdraw() throws Exception{
		double amount, fee;
		long accountNumber = inputLong("\nNhập số tài khoản cần rút: ");
		Account acc = accountList.getAccountByAccNumber(accountNumber);
		if(acc != null) {
			amount = inputDouble("Nhập số tiền cần rút: ");
			fee = inputDouble("Nhập tiền phí để rút: ");
			try{
				acc.withdraw(amount, fee);
				System.out.println("--- Rút thành công!!! ---");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}else
			System.out.println("Không tìm thấy tài khoản.");
	}
	public static void maturity() {
		long accountNumber = inputLong("\nNhập số tài khoản muốn đáo hạn: ");
		Account acc = accountList.getAccountByAccNumber(accountNumber);
		if(acc != null) {
			acc.maturity();
			System.out.println("--- Đáo hạn thành công!!! ---");
		}else
			System.out.println("Không tìm thấy tài khoản.");
	}
	public static void transfer() throws Exception{
		double amount;
		long accountNumber1 = inputLong("\nNhập số tài khoản chuyển: ");
		long accountNumber2 = inputLong("Nhập số tài khoản nhận: ");
		Account sender = accountList.getAccountByAccNumber(accountNumber1);
		Account receiver = accountList.getAccountByAccNumber(accountNumber2);
		if(sender != null & receiver != null) {
			amount = inputDouble("Nhập số tiền cần chuyển: ");
			try{
				sender.transfer(receiver, amount);
				System.out.println("--- Chuyển tiền thành công!!! ---");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}else
			System.out.println("Không tìm thấy tài khoản.");
	}
	public static void displayAccountFound() {
		long accountNumber = inputLong("\nNhập số tài khoản muốn hiện thị: ");
		Account acc = accountList.getAccountByAccNumber(accountNumber);
		if(acc != null) {
			System.out.printf("%-20s %-30s %-20s\n", "Số tài khoản", "Họ và tên", "Số Dư");
			System.out.println(acc);
		}else
			System.out.println("Không tìm thấy tài khoản");
	}
	public static void displayTitle() {
		String title = String.format("\t%-7s %-20s %-30s %-20s", "STT", "Số tài khoản", "Họ và tên", "Số Dư");
		System.out.println(title);
	}
	public static void displayAccount(Account[] list) {
		displayTitle();
		for(int i = 0; i < accountList.size; i++) {
			System.out.printf("\t%-7d ", i+1);
			System.out.println(list[i]);
		}
	}
	public static void displayAccountList() {
		Account[] allAccount = accountList.getAccounts();
		displayAccount(allAccount);
	}
	public static int menu() {
	    String[] options = {
	        "In cứng danh sách tài khoản",
	        "Thêm tài khoản",
	        "Sửa danh sách tài khoản",
	        "Xoá tài khoản theo số tài khoản",
	        "Tìm kiếm tài khoản theo số tài khoản",
	        "Xuất danh sách tài khoản",
	        "Xuất danh sách sắp xếp theo số tài khoản",
	        "Nạp tiền",
	        "Rút tiền",
	    	"Đáo hạn",
	    	"Chuyển khoản",
	        "Thoát"
	    };
	    System.out.println("\n\t********************************");
	    System.out.println("\t** Chương Trình Quản lý tài khoản **");
	    for (int i = 0; i < options.length; i++)
	    	System.out.printf("\t* %d. %s%n", i + 1, options[i]);
	    System.out.println("\t********************************");
	    int option = inputInt("Chọn: ");
	    return option;
	}
	public static void main(String[] args) throws Exception{
		accountList = new AccountArr();
		int choice;
		Account acc;
		do {
			choice = menu();
			switch(choice) {
			case 1:
				createDefaultAccountList();
				displayAccountList();
				break;
			case 2:
				acc = createAccount();
				accountList.add(acc);
				break;
			case 3:
				updateAccount();
				break;
			case 4:
				deleteAccount();
				break;
			case 5:
				displayAccountFound();
				break;
			case 6:
				displayAccountList();
				break;
			case 7:
				Account[] sortedAccountList = accountList.sortByAccountNumber();
				displayAccount(sortedAccountList);
				break;
			case 8: 
				displayAccountList();
				deposit();
				break;
			case 9: 
				displayAccountList();
				withdraw();
				break;
			case 10: 
				displayAccountList();
				maturity();
				break;
			case 11: 
				displayAccountList();
				transfer();
				break;
			case 12:
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		}while(choice != 12);
	System.out.println("Đã Kết Thúc Chương Trình!!!");
	sn.close();
	}
}
