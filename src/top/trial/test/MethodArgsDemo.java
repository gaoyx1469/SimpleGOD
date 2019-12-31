package top.trial.test;

/**
 * 测试JAVA中方法参数的引用方式
 * 
 * @author Gaoyx
 *
 */
public class MethodArgsDemo {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		swap(a, b);// 经历交换，值未变
		add(a);// 经历自增，值未变

		System.out.println("a AFTER SWAP:" + a);
		System.out.println("b AFTER SWAP:" + b);

		Student tom = new Student("Tom", 15);
		Student jack = new Student("Jack", 18);

		swap(tom, jack);

		System.out.println("Tom AFTER SWAP:" + tom);
		System.out.println("Jack AFTER SWAP:" + jack);
	}

	private static void add(int a) {
		a++;
	}

	// 演示基本数据类型传进来后实际并没有改变原来的值
	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	// 演示引用数据类型传进来后实际并没有改变原来的引用
	private static void swap(Student tom, Student jack) {
		Student temp = tom;
		tom = jack;
		jack = temp;
		tom.addAge();// 引用的已是jack的对象，该对象age++
	}

}

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void addAge() {
		age++;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
