package top.trial.demo.entity;

public class GameEntity {

	public String name;
	private Double grade;
	int Level;

	public GameEntity() {
	}

	GameEntity(String name) {
		this.name = name;
	}

	private GameEntity(Double grade) {
		this.grade = grade;
	}

	public void sys() {
		System.out.println("sys");
	}

	public void method(String s) {
		System.out.println("method");
		System.out.println(s);
	}

	public String test(String s, int i) {
		return s + "--------" + i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

}
