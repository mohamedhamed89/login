package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

	public String login() {
		if (username.equals("mohamed") && password.equals("123456")) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
			return "y";
		} else
			return "n";

	}

}
