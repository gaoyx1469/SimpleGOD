package top.util.mydbutil;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import top.util.mydbutil.result.ResultSetHandler;

/**
 * ���ݿ����������
 * @author Gaoyx
 *
 */
public class MyDBUtil {
	//����Դ
	private DataSource dataSource;

	//����Դע��
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//�Ƿ�ʹconnection���̰߳�
	private Boolean useCurrentConnection = false;

	//�Ƿ�ʹconnection���̰߳�ע��
	public void setUseCurrentConnection(Boolean useCurrentConnection) {
		this.useCurrentConnection = useCurrentConnection;
	}
	
	public Connection getCurrentConnection() {
		return DataSourceUtils.getCurrentConnection(dataSource,useCurrentConnection);
	}
	
	public void releaseConnection() {
		DataSourceUtils.releaseConnection(getCurrentConnection());
	}
	
	public MyDBUtil() {
		
	}

	public MyDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public MyDBUtil(DataSource dataSource, Boolean useCurrentConnection) {
		super();
		this.dataSource = dataSource;
		this.useCurrentConnection = useCurrentConnection;
	}
	
	
	public int update(String sql,Object...params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getCurrentConnection();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int count = pmd.getParameterCount();
			if(count > 0) {
				if(params == null) {
					throw new IllegalArgumentException("δ�������");
				}
				if(count != params.length) {
					throw new IllegalArgumentException("���������������");
				}
				for(int i = 0; i< count;i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			
			return ps.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			close(conn,ps,null);
		}
	}
	
	public <T> T query(String sql,ResultSetHandler rsd,Object...params) {
		// TODO
		return null;
	}

	private void close(Connection conn, PreparedStatement ps, Object object) {
		// TODO Auto-generated method stub
		
	}
}
