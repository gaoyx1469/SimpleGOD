package top.trial.spring.service;

public interface AccountOperationAopService {

	/**
	 * ģ���˻�����������޲����޷���
	 */
	public void saveAccount();

	/**
	 * ģ���˻����²������в����޷���
	 * 
	 * @param id
	 */
	public void updateAccount(int id);

	/**
	 * ģ���˻�ɾ���������в����ַ���
	 * 
	 * @param id
	 * @return
	 */
	public int deleteAccount(int id);
}
