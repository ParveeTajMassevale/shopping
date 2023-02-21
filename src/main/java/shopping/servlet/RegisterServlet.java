package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.connection.DbCon;
import shopping.dao.UserDao;
import shopping.model.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String name = request.getParameter("register-name");
			String email = request.getParameter("register-email");
			String password = request.getParameter("register-password");
			UserDao udao = new UserDao(DbCon.getConnection());
			password = new String(md.digest(password.getBytes(StandardCharsets.UTF_8)));
			boolean result = udao.userRegister(name,email,password);
			if(result) {
				out.println("index.jsp");
			}
			else {
				out.println("Registration failed. User Already existed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
