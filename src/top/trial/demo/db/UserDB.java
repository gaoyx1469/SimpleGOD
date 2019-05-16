package top.trial.demo.db;

import java.util.ArrayList;
import java.util.List;

import top.trial.demo.entity.UserLoginEntity;


public class UserDB {
	private static List<UserLoginEntity> users= new ArrayList<UserLoginEntity>();
	
	static {
		users.add(new UserLoginEntity("abc","123","ABC"));
		users.add(new UserLoginEntity("def","456","DEF"));
		users.add(new UserLoginEntity("中文","456","中文"));
	}
	
	public static UserLoginEntity findUserByNameAndPsw(String username,String password) {
		UserLoginEntity user = null;
		for(UserLoginEntity u:users) {
			if(username.equals(u.getName()) && password.equals(u.getPassword())) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	public static UserLoginEntity findUserByName(String username) {
		UserLoginEntity user = null;
		for(UserLoginEntity u:users) {
			if(username.equals(u.getName())) {
				user = u;
				break;
			}
		}
		return user;
	}
	
}
