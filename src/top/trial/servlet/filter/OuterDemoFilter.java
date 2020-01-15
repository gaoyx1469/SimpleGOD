package top.trial.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OuterDemoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("OuterDemoFilter Before");
		chain.doFilter(request, response);
		// System.out.println("OuterDemoFilter After");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// System.out.println("OuterDemoFilter Init");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		// System.out.println("OuterDemoFilter Destroy");
		Filter.super.destroy();
	}
}
