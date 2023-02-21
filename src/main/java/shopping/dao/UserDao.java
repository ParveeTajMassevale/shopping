package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shopping.model.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public UserDao(Connection con) {
		this.con =con;
	}
	public User userLogin(String email,String password) {
		User user = null;
		try {
			query = "Select * from users where email = ? and password = ?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println();
			e.getMessage();
		}
		return user;
	}
	public boolean userRegister(String name,String email,String password) {
		boolean result = false;
		try {
			query = "insert into users (name,email,password) values(?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, password);
			pst.executeUpdate();
			result = true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return result;
	}
}
