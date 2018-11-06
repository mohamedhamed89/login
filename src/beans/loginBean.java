package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import connection.DBConnection;

@ManagedBean(name = "loginbean")
@SessionScoped
public class loginBean {

	public loginBean() {
		// TODO Auto-generated constructor stub
	}

	private String username;
	private String password;
	private boolean checkBox;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

	public String login() throws ClassNotFoundException, SQLException {
		String log = select();
		return log;

	}
	
	public String select() throws ClassNotFoundException, SQLException{
		
		 Connection conn = DBConnection.getConnction();
		 
		 PreparedStatement ps = conn.prepareStatement("select * from login where username = ? and pass = ?");
		  ps.setString(1, username);
		  ps.setString(2, password);
		  ResultSet rs=ps.executeQuery();
		  if(rs.next()){
			  conn.close();
			  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
			  return "y";
			  
		  }else
			  conn.close();
			  return "n";
		  
		  
		
	}

}
