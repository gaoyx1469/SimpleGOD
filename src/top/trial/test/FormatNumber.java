package top.trial.test;

public class FormatNumber {

	public static void main(String[] args) {
		String a = "55.00";
		String b = "55.50";
		String c = "50.55";
		String d = "50.01";
		
		System.out.println(format(a));
		System.out.println(format(b));
		System.out.println(format(c));
		System.out.println(format(d));
	}

	private static String format(String num) {
		
		num = num.replaceAll("0+?$", "");
		num = num.replaceAll("[.]$", "");
		return num;
	}
	
	

}
