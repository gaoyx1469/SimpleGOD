package top.trial.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InnerDemoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("InnerDemoFilter Before");
		chain.doFilter(request, response);
		// System.out.println("InnerDemoFilter After");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// System.out.println("InnerDemoFilter Init");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		// System.out.println("InnerDemoFilter Destroy");
		Filter.super.destroy();
	}

}
