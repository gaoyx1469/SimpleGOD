package top.trial.servlet;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			if(ServletFileUpload.isMultipartContent(request)) {
				List<FileItem> items = sfu.parseRequest(request);
				for(FileItem item : items) {
					if(item.isFormField()) {//
						
					}else {
						
					}
				}
			}else {
				System.out.println("代码有问题吧哥哥，快看看Form表单enctype的值");
			}
		} catch (FileUploadException e) {
			throw new RuntimeException("服务器忙");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
