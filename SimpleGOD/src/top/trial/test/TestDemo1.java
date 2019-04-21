package top.trial.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class TestDemo1 {

	@Test
	public void test1() {
		String s = "000";
		StringBuffer sb = new StringBuffer(s);
		StringBuilder sbs = new StringBuilder(s);
		s = null;
		sbs.append(s);
		System.out.println(sbs);
		System.out.println(s);
		
		Vector v  = new Vector();
		Hashtable ht = new Hashtable();
		HashMap hm = new HashMap();
		ConcurrentHashMap chm = new ConcurrentHashMap();
	}

}
