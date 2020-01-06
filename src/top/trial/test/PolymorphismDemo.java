package top.trial.test;

/**
 * 多态下子类与父类的引用问题测试
 * 
 * @author Gaoyx
 *
 */
public class PolymorphismDemo {
	public static void main(String[] args) {
		Child[] children = new Child[3];
		Father[] fathers = children;// 运用多态，赋值给父类数组
		//fathers[0] = new Father("Tom");// 这里会报运行时错误ArrayStoreException，编译器认可，但是实际是new Child[3]，运行时会有问题
		fathers[1] = new Child("Tom", "1");
		fathers[2] = new Child("Tom", "2");

		for (Father father : fathers) {
			System.out.println(father);
		}
	}
}

class Father {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Father(String name) {
		super();
		this.name = name;
	}

	public Father() {
		super();
	}

	@Override
	public String toString() {
		return "Father [name=" + name + "]";
	}

}

class Child extends Father {
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Child(String name, String lastName) {
		super(name);
		this.lastName = lastName;
	}

	public Child() {
		super();
	}

	public Child(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Child [lastName=" + lastName + "]";
	}
}
