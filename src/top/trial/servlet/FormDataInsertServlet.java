package top.trial.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import top.trial.demo.entity.UserEntity;

/**
 * ������ʾhtml�����������ͨ��BeanUtils����JavaBean��
 * 
 * @author ������
 *
 */
@WebServlet("/FormDataInsertServlet")
public class FormDataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormDataInsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����JavaBean
		UserEntity ue = new UserEntity();
		// ���������
		ServletOutputStream out = response.getOutputStream();
		// �����ʼ״̬
		System.out.println(ue.toString());
		// ������UTF-8��ʽ������������ĺ��֣�ֻ��POST����ʽ��Ч
		request.setCharacterEncoding("UTF-8");

		// ע��Date����ת����
		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		// ʹ��populate������Map�����ݲ���JavaBean��
		try {
			BeanUtils.populate(ue, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �������״̬
		System.out.println(ue.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
