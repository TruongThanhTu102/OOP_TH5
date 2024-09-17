package tuan2AccNganHang;

public class Account {
    private long accountNumber;
    private String accountName;
    private double blance;
    private final long BLANCEDEFAULT = 50000;

    // Constructor cho Account
    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.blance = BLANCEDEFAULT; // Khởi tạo số dư mặc định
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBlance() {
        return blance;
    }

    private void setBlance(double blance) {
        this.blance = blance;
    }

    public boolean deposit(double amountTienNap) throws Exception {
        if (amountTienNap > 0) {
            this.blance += amountTienNap;
            return true;
        } else {
            throw new Exception("Số tiền không được bé hơn không");
        }
    }

    @Override
    public String toString() {
        return String.format("%15d %-50s %15.2f", getAccountNumber(), getAccountName(), getBlance());
    }
}
