package top.trial.test;

/**
 * ����JAVA�з������������÷�ʽ
 * 
 * @author Gaoyx
 *
 */
public class MethodArgsDemo {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		swap(a, b);// ����������ֵδ��
		add(a);// ����������ֵδ��

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

	// ��ʾ�����������ʹ�������ʵ�ʲ�û�иı�ԭ����ֵ
	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	// ��ʾ�����������ʹ�������ʵ�ʲ�û�иı�ԭ��������
	private static void swap(Student tom, Student jack) {
		Student temp = tom;
		tom = jack;
		jack = temp;
		tom.addAge();// ���õ�����jack�Ķ��󣬸ö���age++
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
