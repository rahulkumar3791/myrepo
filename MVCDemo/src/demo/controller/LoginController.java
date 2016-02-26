package demo.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import demo.model.Authenticator;
import demo.model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;

		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticate(username, password);
		System.out.println("uname " +username+"password "+password);
		if (result.equals("success")) {
			
			System.out.println("checking condtion fine");
			rd = request.getRequestDispatcher("/success.jsp");
			User user = new User(username, password);
			request.setAttribute("user", user);
		} else {
			System.out.println("else");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

}