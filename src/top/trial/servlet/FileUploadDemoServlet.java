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
				DiskFileItemFactory factory = new DiskFileItemFactory();// 默认配置
				ServletFileUpload sfu = new ServletFileUpload(factory);// 使用默认配置创建核心类
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {// 是普通输入
						String itemName = item.getFieldName();
						String itemValue = item.getString("UTF-8");// 使用UTF-8编码转换
						System.out.println(itemName + "====" + itemValue);
					} else {// 是文件输入
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
				System.out.println("代码有问题吧哥哥，快看看Form表单enctype的值");
			}
		} catch (FileUploadException e) {
			throw new RuntimeException("服务器忙");
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
