package top.trial.test;

import java.util.Arrays;

public class EnumTest {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(Size.values()));
		
		Size size1 = Enum.valueOf(Size.class, "SMALL");
		Size size2 = Enum.valueOf(Size.class, "LARGE");
		
		System.out.println(size1.ordinal());
		System.out.println(size1.getDescription());
		System.out.println(size1.compareTo(size2));
	}

}
