package top.trial.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// 获取Filter的初始化参数
		String encoding = filterConfig.getInitParameter("encoding");
		if (encoding == null)
			encoding = "UTF-8";

		// 设置POST请求的中文请求参数编码
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		
		// 若为GET请求方式，需要使用包装设计模式重写getParameter方法，因为get方法默认使用ISO-8859-1解码方式传送参数
		// 由于在JSP页面配置了pageEncoding="UTF-8"，get方式也是UTF-8解码，这个不用了就
		//ChineseEncodingServletRequest crequest = new ChineseEncodingServletRequest(request);
		
		chain.doFilter(request, response);
	}

}
