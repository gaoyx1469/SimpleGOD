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
 * 此类演示html表单数据输入后通过BeanUtils存入JavaBean中
 * 
 * @author 高宇翔
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
		// 创建JavaBean
		UserEntity ue = new UserEntity();
		// 创建输出流
		ServletOutputStream out = response.getOutputStream();
		// 输出初始状态
		System.out.println(ue.toString());
		// 设置以UTF-8方式解码请求参数的汉字，只对POST请求方式有效
		request.setCharacterEncoding("UTF-8");

		// 注册Date类型转换器
		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		// 使用populate方法将Map中数据插入JavaBean中
		try {
			BeanUtils.populate(ue, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 输出最终状态
		System.out.println(ue.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
