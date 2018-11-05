package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="logoutBean")
@SessionScoped
public class logoutBean {

	public logoutBean() {
		// TODO Auto-generated constructor stub
	}
public String logout(){
	((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
	
	return "logout";
} 
}
