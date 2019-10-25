package top.util.mydbutil.result;

import java.sql.ResultSet;

public interface ResultSetHandler {
	public <T> T handler(ResultSet rs);
}
