package top.trial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionSetDemoServlet")
public class SessionSetDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SessionSetDemoServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myValue = request.getParameter("myValue");
		HttpSession session = request.getSession();
		session.setAttribute("myKey", myValue);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write("<a href='/SimpleGOD/SessionGetDemoServlet'>去看看value能不能拿到</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
