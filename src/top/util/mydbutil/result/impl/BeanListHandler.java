package top.util.mydbutil.result.impl;

import java.sql.ResultSet;

import top.util.mydbutil.result.ResultSetHandler;

public class BeanListHandler<T> implements ResultSetHandler {
	
	private Class<T> clazz;
	
	
	public BeanListHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public <T> T handler(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
