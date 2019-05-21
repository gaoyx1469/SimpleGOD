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
				DiskFileItemFactory factory = new DiskFileItemFactory();// Ĭ������
				ServletFileUpload sfu = new ServletFileUpload(factory);// ʹ��Ĭ�����ô���������
				sfu.setFileSizeMax(4 * 1024 * 1024);// ���õ��ļ�����С4M
				sfu.setSizeMax(10 * 1024 * 1024);// �������ļ�����С10M
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {// ����ͨ����
						String itemName = item.getFieldName();
						String itemValue = item.getString("UTF-8");// ʹ��UTF-8����ת��
						System.out.println(itemName + "====" + itemValue);
					} else {// ���ļ�����
						// �õ�MIME����
						String mimeType = item.getContentType();
						// ֻ�����ϴ�ͼƬ
						if (mimeType.startsWith("image")) {
							InputStream in = item.getInputStream();
							String fileName = item.getName();
							if (item.getName() == null || "".equals(item.getName().trim())) {// ���ļ�����
								continue;
							}
							fileName = fileName.substring(item.getName().lastIndexOf("\\") + 1);
							String filePath = getFilePath(getServletContext().getRealPath("/WEB-INF/files"),
									UUID.randomUUID() + "_" + fileName);// �ļ���WEB-INF�У��ļ������UUID����������Ŀ¼�ṹ
							OutputStream out = new FileOutputStream(filePath);

							byte[] b = new byte[1024];
							int len = -1;
							while ((len = in.read(b)) != -1) {
								out.write(b, 0, len);
							}
							out.close();
							in.close();
							item.delete();// ɾ����ʱ�ļ�
						}
					}
				}
			} else {
				System.out.println("����������ɸ�磬�쿴��Form��enctype��ֵ");
			}
		} catch (org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e) {
			// �����ļ�������Сʱ���쳣
			pout.write("�����ļ���С���ܳ���4M");
		} catch (org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e) {
			// ���ļ�������Сʱ���쳣
			pout.write("���ļ���С���ܳ���10M");
		} catch (FileUploadException e) {
			throw new RuntimeException("������æ");
		}

	}

	private String getFilePath(String realPath, String fileName) {

		int hashCode = fileName.hashCode();
		int dir1 = hashCode & 0xf;// 0000~1111������0~15��16��
		int dir2 = (hashCode & 0xf0) >> 4;// 0000~1111������0~15��16��

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
