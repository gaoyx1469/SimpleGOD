package top.trial.struts;

import java.io.Serializable;

public class StrutsHelloWorld implements Serializable {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StrutsHelloWorld [message=" + message + "]";
	}
	
	public String sayHello() {
		message = "<h2>hello struts2</h2>";
		return StrutsResult.SUCCESS;
	}
}
