package top.trial.servlet.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.trial.servlet.filter.servletRequest.ChineseEncodingServletRequest;

public class ChineseEncodingFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		// ��ȡFilter�ĳ�ʼ������
		String encoding = filterConfig.getInitParameter("encoding");
		if (encoding == null)
			encoding = "UTF-8";

		// ����POST��������������������
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		
		// ��ΪGET����ʽ����Ҫʹ�ð�װ���ģʽ��дgetParameter��������Ϊget����Ĭ��ʹ��ISO-8859-1���뷽ʽ���Ͳ���
		// �����Ϊɶget��ʽҲ��UTF-8���룬��������˾�
		// ChineseEncodingServletRequest crequest = new ChineseEncodingServletRequest(request);
		
		chain.doFilter(request, response);
	}

}
