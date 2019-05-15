package top.trial.xml.domain;

public class WorkerDomain {

	private String name;
	private int age;
	private boolean flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "WorkerDomain [name=" + name + ", age=" + age + ", flag=" + flag + "]";
	}

}
