package top.trial.spring;

/**
 * Spring��ʾAOP�����JavaBean
 * 
 * @author Gaoyx
 *
 */
public class SpringAccountBean {

	private int accountId;
	private String accountName;
	private int amount;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
