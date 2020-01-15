package top.trial.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

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
		PrintWriter pout = response.getWriter();
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory factory = new DiskFileItemFactory();// 默认配置
				ServletFileUpload sfu = new ServletFileUpload(factory);// 使用默认配置创建核心类
				sfu.setFileSizeMax(4 * 1024 * 1024);// 设置单文件最大大小4M
				sfu.setSizeMax(10 * 1024 * 1024);// 设置总文件最大大小10M
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {// 是普通输入
						String itemName = item.getFieldName();
						String itemValue = item.getString("UTF-8");// 使用UTF-8编码转换
						System.out.println(itemName + "====" + itemValue);
					} else {// 是文件输入
						// 得到MIME类型
						String mimeType = item.getContentType();
						// 只允许上传图片
						if (mimeType.startsWith("image")) {
							InputStream in = item.getInputStream();
							String fileName = item.getName();
							if (item.getName() == null || "".equals(item.getName().trim())) {// 空文件跳过
								continue;
							}
							fileName = fileName.substring(item.getName().lastIndexOf("\\") + 1);
							String filePath = getFilePath(getServletContext().getRealPath("/WEB-INF/files"),
									UUID.randomUUID() + "_" + fileName);// 文件放WEB-INF中，文件名添加UUID并增加两层目录结构
							OutputStream out = new FileOutputStream(filePath);

							byte[] b = new byte[1024];
							int len = -1;
							while ((len = in.read(b)) != -1) {
								out.write(b, 0, len);
							}
							out.close();
							in.close();
							item.delete();// 删除临时文件
						}
					}
				}
			} else {
				System.out.println("代码有问题吧哥哥，快看看Form表单enctype的值");
			}
		} catch (org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e) {
			// 单个文件超出大小时的异常
			pout.write("单个文件大小不能超出4M");
		} catch (org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e) {
			// 总文件超出大小时的异常
			pout.write("总文件大小不能超出10M");
		} catch (FileUploadException e) {
			throw new RuntimeException("服务器忙");
		}

	}

	private String getFilePath(String realPath, String fileName) {

		int hashCode = fileName.hashCode();
		int dir1 = hashCode & 0xf;// 0000~1111：整数0~15共16个
		int dir2 = (hashCode & 0xf0) >> 4;// 0000~1111：整数0~15共16个

		String path = realPath + "\\" + dir1 + "\\" + dir2; // WEB-INF/files/1/12
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();

		return path + "\\" + fileName;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
