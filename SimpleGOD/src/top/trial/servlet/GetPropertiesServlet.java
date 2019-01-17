package top.trial.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.util.properties.PropertiesUtil;

public class GetPropertiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetPropertiesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得配置文件绝对路径
		String path1 = getServletContext().getRealPath("/WEB-INF/testDemo.properties");
		String path2 = getServletContext().getRealPath("/WEB-INF/classes/rootDemo.properties");
		String path3 = getServletContext().getRealPath("/WEB-INF/classes/top/trial/test/TestDemo.properties");
		// 取得Properties对象
		Properties p1 = new Properties();
		p1.load(new FileInputStream(path1));
		Properties p2 = new Properties();
		p2.load(new FileInputStream(path2));
		Properties p3 = new Properties();
		p3.load(new FileInputStream(path3));
		// 获取propertiesName的值并输出
		String value1 = p1.getProperty("propertiesName") + "*******" + "\r\n";
		String value2 = p2.getProperty("propertiesName") + "*******" + "\r\n";
		String value3 = p3.getProperty("propertiesName") + "*******" + "\r\n";

		String value4 = PropertiesUtil.getPropertiesValue("rootDemo", "propertiesName");
		String value5 = PropertiesUtil.getPropertiesValue("top/trial/test/TestDemo", "propertiesName");
		String value6 = PropertiesUtil.getPropertiesValue("top.trial.test.TestDemo", "propertiesName");
		response.getOutputStream().write(value1.getBytes());
		response.getOutputStream().write(value2.getBytes());
		response.getOutputStream().write(value3.getBytes());
		response.getOutputStream().write(value4.getBytes());
		response.getOutputStream().write(value5.getBytes());
		response.getOutputStream().write(value6.getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
