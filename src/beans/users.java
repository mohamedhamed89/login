package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;

@ManagedBean(name="users")
@SessionScoped
public class users {

	public users() {
		// TODO Auto-generated constructor stub
		//isCheck();
	}
	
  private String user;
  private String password;
  private boolean checkbox;
  private String vitualCheck;
  HttpServletRequest request;
  
  
  public String logout(){
	  ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
	  
	  return "login?faces-redirect=true";
  }

public String getUser() {
	
	return user;
}
public void setUser(String user) {
	this.user = user;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isCheckbox() {
	return checkbox;
}
public void setCheckbox(boolean checkbox) {
	this.checkbox = checkbox;
}
public String isLogin(){
	if(user.equals("mohamed")){
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("un", user);
		return "yes";
	}else
	
	return "no";
}
public void isCheck(){
	
	FacesContext fc = FacesContext.getCurrentInstance();
	Cookie[] cookieArr = ((HttpServletRequest)(fc.getExternalContext().getRequest())).getCookies();
	if(cookieArr!=null && cookieArr.length>0){
		for(int i=0 ; i<cookieArr.length;i++){
			String cName = cookieArr[i].getName();
			String cValue = cookieArr[i].getValue();
			if(cName.equals("cUser")){
				setUser(cValue);
				
			}else if(cName.equals("cPassword")){
				
				setPassword(cValue);
			}else if(cName.equals("cVitualCheck")){
				
				setVitualCheck(cValue);
				if(getVitualCheck().equals(false)){
					setUser(null);
					setPassword(null);
					setCheckbox(false);
					
				}else if (getVitualCheck().equals("true")){
					setCheckbox(true);
				}
				
				
				
			}
			
			
		}
		
		
		
		
		
		
	}
	
	
}





public String getVitualCheck() {
	return vitualCheck;
}
public void setVitualCheck(String vitualCheck) {
	this.vitualCheck = vitualCheck;
}
}
