package top.trial.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class TestDemo1 {

	@Test
	public void test1() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		System.out.println(sdf.format(d));
		String s = "12345678901234567890123456789012";
		System.out.println(s.substring(24));
	}
	
	@Test
	public void test2() {
		String a = "";
		String b = "a";
		System.out.println(a.contains(b));
	}

}
