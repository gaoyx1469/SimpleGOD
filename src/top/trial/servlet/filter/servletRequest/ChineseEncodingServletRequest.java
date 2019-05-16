package top.trial.servlet.filter.servletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @author Gaoyx1469
 *
 */
public class ChineseEncodingServletRequest extends HttpServletRequestWrapper{

	public ChineseEncodingServletRequest(HttpServletRequest request) {
		super(request);
	}

}
