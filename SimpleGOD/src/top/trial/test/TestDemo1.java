package top.trial.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

public class TestDemo1 {

	@Test
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
		Calendar c = Calendar.getInstance();
		ArrayList<String> list = new ArrayList();

		for (int i = 1; i < 7; i++) {
			String date = sdf.format(c.getTime());
			list.add(date);
			c.add(Calendar.MONTH, -1);
		}
		
		for(String sys : list) {
			System.out.println(sys);
		}
	}

}
