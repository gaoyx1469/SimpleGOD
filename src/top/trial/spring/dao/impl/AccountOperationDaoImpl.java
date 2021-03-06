package top.trial.spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.trial.spring.SpringAccountBean;
import top.trial.spring.dao.AccountOperationDao;

@Repository(value = "accountOperationDao")
public class AccountOperationDaoImpl implements AccountOperationDao {

	// 此处可注入
	@Autowired
	private QueryRunner qr;

	@Override
	public void addAccount(SpringAccountBean accountBean) {
		try {
			qr.update("INSERT INTO SG_ACCOUNT_TEST (SAT_ID,SAT_NAME,SAT_VALUE) VALUES (?,?,?)", accountBean.getSat_id(),
					accountBean.getSat_name(), accountBean.getSat_value());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(SpringAccountBean accountBean) {
		try {
			qr.update("UPDATE SG_ACCOUNT_TEST SET SAT_NAME=?,SAT_VALUE=? WHERE SAT_ID=?", accountBean.getSat_name(),
					accountBean.getSat_value(), accountBean.getSat_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(SpringAccountBean accountBean, Connection conn) {
		try {
			qr.update(conn, "UPDATE SG_ACCOUNT_TEST SET SAT_NAME=?,SAT_VALUE=? WHERE SAT_ID=?",
					accountBean.getSat_name(), accountBean.getSat_value(), accountBean.getSat_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAccount(int accountId) {
		try {
			qr.update("DELETE FROM SG_ACCOUNT_TEST WHERE SAT_ID=?", accountId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SpringAccountBean getAccountById(int accountId) {
		try {
			return qr.query("SELECT SAT_ID,SAT_NAME,SAT_VALUE FROM SG_ACCOUNT_TEST WHERE SAT_ID=?",
					new BeanHandler<SpringAccountBean>(SpringAccountBean.class), accountId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public SpringAccountBean getAccountById(int accountId, Connection conn) {
		try {
			return qr.query(conn, "SELECT SAT_ID,SAT_NAME,SAT_VALUE FROM SG_ACCOUNT_TEST WHERE SAT_ID=?",
					new BeanHandler<SpringAccountBean>(SpringAccountBean.class), accountId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SpringAccountBean> getAllAccounts() {
		try {
			return qr.query("SELECT SAT_ID,SAT_NAME,SAT_VALUE FROM SG_ACCOUNT_TEST",
					new BeanListHandler<SpringAccountBean>(SpringAccountBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
