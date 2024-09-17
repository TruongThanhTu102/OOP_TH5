package tuan4Accountt;

public class AccountArr {
	private Account[] accounts;
	public int size = 0;
	
	public AccountArr() {
		super();
		this.accounts = new Account[1];
	}
	public AccountArr(int initCapacity) {
		this.accounts = new Account[initCapacity];
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public boolean isExistingAccNumber(long accountNumber) {
		for(int i = 0; i < size; i++)
			if(accountNumber == accounts[i].getNumOfAcc())
				return true;
		return false;
	}
	public Account[] copyArray(Account[] arr, int length) {
		Account[] newArr = new Account[length]; 
	    for (int i = 0; i < size; i++)
	        newArr[i] = arr[i];
	    return newArr;
	}
	public void add(Account acc) throws Exception{
		if(!isExistingAccNumber(acc.getNumOfAcc())) {
			if(size == accounts.length)
				accounts = copyArray(accounts, size*2);
			accounts[size++] = acc;
		}else
			throw new Exception("Số tài khoản này đã tồn tại.");
		
	}
	public int indexOfAccount(long accountNumber) {
		for(int i = 0; i < size; i++)
			if(accounts[i].getNumOfAcc() == accountNumber)
				return i;
		return -1;
	}
	public Account getAccountByAccNumber(long accountNumber) {
		int index = indexOfAccount(accountNumber); 
		return (index != -1)? accounts[index]: null;
	}
	public void delete(long accountNumber) throws Exception {
		int i = indexOfAccount(accountNumber); 
		if(i != -1) {
			for(; i < size-1; i++)
				accounts[i] = accounts[i+1];
			size--;
		}else
			throw new Exception("Không tìm thấy tài khoản");
	}
	public void update(Account acc) throws Exception {
		int index = indexOfAccount(acc.getNumOfAcc());
		if(index != -1)
			accounts[index] = acc;
		else
			throw new Exception("Không tìm thấy tài khoản");
	}
	public Account[] sortByAccountNumber() {
		Account[] sortedArr = copyArray(accounts, size);
		Account temp;
		int n = size;
	    for (int i = 0; i < n - 1; i++)
	        for (int j = 0; j < n - i - 1; j++)
	            if (sortedArr[j].getNumOfAcc() > sortedArr[j + 1].getNumOfAcc()) {
	                temp = sortedArr[j];
	                sortedArr[j] = sortedArr[j + 1];
	                sortedArr[j + 1] = temp;
	            }
		return sortedArr;
	}
}
