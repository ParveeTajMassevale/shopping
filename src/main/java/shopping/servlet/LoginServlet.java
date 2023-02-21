package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.connection.DbCon;
import shopping.dao.UserDao;
import shopping.model.User;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			UserDao udao = new UserDao(DbCon.getConnection());
			password = new String(md.digest(password.getBytes(StandardCharsets.UTF_8)));
			User user = udao.userLogin(email, password);
			if (user != null) {
				out.println("user Login");
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("index.jsp");
			} else
				out.print("Login failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
