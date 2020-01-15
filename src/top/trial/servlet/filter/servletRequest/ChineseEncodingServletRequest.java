package top.trial.servlet.filter.servletRequest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @author Gaoyx1469
 *
 */
public class ChineseEncodingServletRequest extends HttpServletRequestWrapper {

	public ChineseEncodingServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {

		String param = super.getParameter(name);

		if (param == null)
			return param;

		if ("GET".equalsIgnoreCase(super.getMethod())) {// GET请求方式
			try {
				param = new String(param.getBytes(StandardCharsets.ISO_8859_1), super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return param;
	}

}
