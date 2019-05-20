package top.trial.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUploadDemoServlet")
public class FileUploadDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadDemoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory factory = new DiskFileItemFactory();// Ĭ������
				ServletFileUpload sfu = new ServletFileUpload(factory);// ʹ��Ĭ�����ô���������
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {// ����ͨ����
						String itemName = item.getFieldName();
						String itemValue = item.getString("UTF-8");// ʹ��UTF-8����ת��
						System.out.println(itemName + "====" + itemValue);
					} else {// ���ļ�����
						InputStream in = item.getInputStream();
						String fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
						String filePath = getFilePath(getServletContext().getRealPath("/WEB-INF/files"), fileName);
						OutputStream out = new FileOutputStream(filePath);

						byte[] b = new byte[1024];
						int len = -1;
						while ((len = in.read(b)) != -1) {
							out.write(b);
						}
						out.close();
						in.close();
					}
				}
			} else {
				System.out.println("����������ɸ�磬�쿴��Form��enctype��ֵ");
			}
		} catch (FileUploadException e) {
			throw new RuntimeException("������æ");
		}

	}

	private String getFilePath(String realPath, String fileName) {
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		return realPath + "/" + fileName;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
