package top.trial.servlet.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ShowRemoteIpTag extends TagSupport {

	
	@Override
	public int doStartTag() throws JspException {
		
		//pageContext是TagSupport类的属性
		String remoteIp = pageContext.getRequest().getRemoteAddr();
		
		try {
			pageContext.getOut().write(remoteIp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
}
