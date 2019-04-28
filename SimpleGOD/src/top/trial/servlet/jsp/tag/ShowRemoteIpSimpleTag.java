package top.trial.servlet.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowRemoteIpSimpleTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException{
		PageContext pc =(PageContext)getJspContext();
		try {
			pc.getOut().write(pc.getRequest().getRemoteAddr());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
