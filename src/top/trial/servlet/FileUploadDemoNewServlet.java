package top.trial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 使用Servlet3.0规范实现文件上传，小Demo，未做分目录存储和文件重命名
 */
@WebServlet("/FileUploadDemoNewServlet")
@MultipartConfig
public class FileUploadDemoNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取上传文件部分
		Part part = request.getPart("f1");
		// 输出Content-Disposition属性
		System.out.println(part.getHeader("Content-Disposition"));
		// 截取到其中的文件名
		String fileName = part.getHeader("Content-Disposition").substring(
				part.getHeader("Content-Disposition").lastIndexOf("filename=\"") + 10,
				part.getHeader("Content-Disposition").length() - 1);
		System.out.println(fileName);
		// 直接输出到指定路径，【前提是目录存在】
		part.write(getServletContext().getRealPath("/unpackage") + "\\" + fileName);
	}

}
