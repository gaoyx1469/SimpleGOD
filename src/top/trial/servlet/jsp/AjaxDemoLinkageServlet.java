package top.trial.servlet.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import top.util.xml.Dom4JUtil;

/**
 * 二级联动支撑Servlet
 * @author Gaoyx
 *
 */

@WebServlet("/AjaxDemoLinkageServlet")
public class AjaxDemoLinkageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provinces = "";
		try {
			Document dom = Dom4JUtil.getDocument(getServletContext().getRealPath("/WEB-INF/example/linkage.xml"));
			List<Node> nodeList = dom.selectNodes("//province");//获取province
			if(nodeList != null) {
				for(Node node:nodeList) {
					Element element = (Element) node;
					provinces += element.valueOf("@name");
					provinces += "|";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print(provinces);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		String province = request.getParameter("province");
		try {
			Document dom = Dom4JUtil.getDocument(getServletContext().getRealPath("/WEB-INF/example/linkage.xml"));
			Node provinceNode = dom.selectSingleNode("//province[@name='"+province+"']");//获取province且name属性值为上送参数值的Node节点
			String xml = provinceNode.asXML();
			response.getWriter().print(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
