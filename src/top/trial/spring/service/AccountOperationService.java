package top.trial.spring.service;

import java.math.BigDecimal;
import java.util.List;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationService {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void deleteAccount(int accountId);

	SpringAccountBean getAccountById(int accountId);

	List<SpringAccountBean> getAllAccounts();

	/**
	 * ��ʾת�˹��̣�������汾
	 * 
	 * @param sourceId
	 *            ת����ID
	 * @param targetId
	 *            ת�뷽ID
	 * @param amount
	 *            ת�˽��
	 */
	void transfer(int sourceId, int targetId, BigDecimal amount);

	/**
	 * ��ʾת�˹��̣�������汾,����TransactionUtil����������ز�������service�㿪�������ȡ���ӣ������Ӵ���dao�㣬
	 * dbutils��queryRunner������÷���ʱ����ָ�����ӡ������������أ�ʹ�ö�̬������Ż�
	 * 
	 * @param sourceId
	 *            ת����ID
	 * @param targetId
	 *            ת�뷽ID
	 * @param amount
	 *            ת�˽��
	 */
	void transferTransaction(int sourceId, int targetId, BigDecimal amount);
}
