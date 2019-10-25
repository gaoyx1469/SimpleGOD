package top.util.mydbutil.result.impl;

import java.sql.ResultSet;

import top.util.mydbutil.result.ResultSetHandler;

public class BeanHandler<T> implements ResultSetHandler {

	private Class<T> clazz;
	
	
	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;
	}


	@Override
	public <T> T handler(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
