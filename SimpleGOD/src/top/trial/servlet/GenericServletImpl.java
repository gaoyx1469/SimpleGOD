package top.trial.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet入门，演示GenericServlet使用，使用时配置web.xml，或者使用注解
 * 
 * @author 高宇翔
 *
 */
public class GenericServletImpl extends GenericServlet {

	public GenericServletImpl() {
		System.out.println("调用了无参构造方法");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("调用了初始化init方法");
	}

	@Override
	public void destroy() {
		System.out.println("调用了销毁destroy方法");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("调用了service方法");
		OutputStream out = res.getOutputStream();
		out.write("Hello Servlet!".getBytes());
		// 关闭输出流，但是不必要，会自动关
		// out.close();
	}

}
