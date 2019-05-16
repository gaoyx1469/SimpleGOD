package top.trial.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.trial.servlet.filter.servletRequest.ChineseEncodingServletRequest;

public class ChineseEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) req;
		
		ChineseEncodingServletRequest crequest = new ChineseEncodingServletRequest(request);
		
		chain.doFilter(crequest, response);
	}

}
