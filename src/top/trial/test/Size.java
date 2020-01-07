package top.trial.test;

public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

	private String description;

	private Size(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
