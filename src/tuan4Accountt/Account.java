package tuan4Accountt;

public class Account {
	private long numOfAcc;
	private String name;
	private double balance;
	private static final double RATE = 0.035;
	
	public long getNumOfAcc() {
		return numOfAcc;
	}
	public void setNumOfAcc(long numOfAcc) {
		this.numOfAcc = numOfAcc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public Account(long numOfAcc, String name, double balance) {
		super();
		this.setNumOfAcc(numOfAcc);
		this.setName(name);
		this.setBalance(balance);
	}
	public Account(long numOfAcc, String name) {
		super();
		this.setNumOfAcc(numOfAcc);
		this.setName(name);
		this.balance = 50000;
		
	}
	@Override
	public String toString() {
		String str = String.format("%-20d %-30s %-20.2f", getNumOfAcc(), getName(), getBalance());
		return str;
	}
	public void deposit(double amount) throws Exception {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new Exception ("Số tiền gửi không hợp lệ. Vui lòng thử lại.");
        }
    }

	public void withdraw(double amount, double withdrawalFee) throws Exception{
        if (amount > 0) {
            if (amount + withdrawalFee <= balance) {
                balance -= (amount + withdrawalFee);
            } else {
                throw new Exception("Số dư không đủ. Vui lòng thử lại.");
            }
        } else {
            throw new Exception("Số tiền rút không hợp lệ. Vui lòng thử lại.");
        }
    }
	public void maturity() {
		this.balance += this.balance*RATE;
	}
	public void transfer(Account destinationAccount, double amount) throws Exception {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                destinationAccount.deposit(amount);
            } else {
                throw new Exception("Số dư không đủ. Vui lòng thử lại.");
            }
        } else {
        	throw new Exception("Số chuyển không hợp lệ. Vui lòng thử lại.");
        }
    }
}
