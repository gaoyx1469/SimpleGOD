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
 * ʹ��Servlet3.0�淶ʵ���ļ��ϴ���СDemo��δ����Ŀ¼�洢���ļ�������
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
		//��ȡ�ϴ��ļ�����
		Part part = request.getPart("f1");
		//���Content-Disposition����
		System.out.println(part.getHeader("Content-Disposition"));
		//��ȡ�����е��ļ���
		String fileName = part.getHeader("Content-Disposition").substring(
				part.getHeader("Content-Disposition").lastIndexOf("filename=\"") + 10,
				part.getHeader("Content-Disposition").length() - 1);
		System.out.println(fileName);
		//ֱ�������ָ��·������ǰ����Ŀ¼���ڡ�
		part.write(getServletContext().getRealPath("/unpackage") + "\\" + fileName);
	}

}
