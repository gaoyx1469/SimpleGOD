package top.tiral.test;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {

	public static void main(String[] args) {
		
		List<String> may = new ArrayList<String>();
		String[] str = {"a","b"};
		
		may.add("1");
		
		System.out.println(may);
		
		System.out.println(may instanceof java.util.List);
		
	}
	
}
