package beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.Connection;

import connection.DBConnection;

@ManagedBean(name="registerBean")
@SessionScoped
public class registerBean {

	public registerBean() {
		// TODO Auto-generated constructor stub
	}
	private String username;
	private String password;
	private String gender;
	private String countery="moufia";
	private String city;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String Month="March";
	
	
public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
private String year="1989";
private String day="23";


	public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
	public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountery() {
		return countery;
	}
	public void setCountery(String countery) {
		this.countery = countery;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	private HashMap<String , String > cityValue;
	
	
	public HashMap<String , String > getCityValue(){
		cityValue = new HashMap<String , String >();
		if (countery.equals("moufia")){
			
			
			cityValue.put("Estanha", "Estanha");
			cityValue.put("ElBogour", "ElBogour");
			cityValue.put("Shbene", "Shbene");
			cityValue.put("Talbant", "Talbant");
			
			
			
			
		}else if(countery.equals("giza")){
			
			cityValue.put("October", "October");
			cityValue.put("Zayed", "Zayed");
			cityValue.put("Fesal", "Fesal");
			cityValue.put("Elharem", "Elharem");
		
	} else if(countery.equals("cairo")){
		
		cityValue.put("Ramses", "Ramses");
		cityValue.put("Eian Shams", "Eian Sham");
		cityValue.put("NaserCity", "NaserCity");
		cityValue.put("ElAbasya", "ElAbasya");
	
}  else{
	
	cityValue.put("SedyGaber", "SedyGaber");
	cityValue.put("Elasafra", "Elasafra");
	cityValue.put("ElNaghel", "ElNaghel");
	cityValue.put("ElAgamy", "ElAgamy");

}
		return cityValue;
	}
	
	private HashMap<Integer , Integer> yearValue ;
	public HashMap<Integer , Integer> getYearVlaue(){
		
		
		yearValue = new HashMap<Integer,Integer>();
		
		for(int i = 1960 ;i<2040 ; i++){
			
			yearValue.put(i, i);
			
		}
		return yearValue;
	}
	private HashMap<Integer,Integer> dayValue;
	public HashMap<Integer,Integer> getDayValue(){
		dayValue = new HashMap<Integer,Integer>();
		for(int i = 1 ; i<32 ; i++){
			
			dayValue.put(i, i);
		}
		return dayValue;
		
	}
	
	private static HashMap<String ,String> monthValue;
	static{
		monthValue = new HashMap<String , String>();
		monthValue.put("January", "January");
		monthValue.put("Februry", "Februry");
		monthValue.put("March", "March");
		monthValue.put("April", "April");
		monthValue.put("May", "May");
		monthValue.put("June", "June");
		monthValue.put("July", "July");
		monthValue.put("August", "August");
		monthValue.put("September", "September");
		monthValue.put("October", "October");
		monthValue.put("Novemebr", "Novemebr");
		monthValue.put("December", "December");
		
		
		
	}
	public HashMap<String , String> getMonthValue(){
		
		return monthValue;
	}
	
	//register method
	
	public String doRegister() throws ClassNotFoundException, SQLException{
		
		String date = Month + "/" + day + "/" +year ;
		String Add = countery + "-" + city ;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
		
		Connection conn = (Connection) DBConnection.getConnction();
		PreparedStatement ps = conn.prepareStatement("insert into login values (?,?,?,?,?,?)");
	     ps.setString(1, username);
	     ps.setString(2, password);
	     ps.setString(3, gender);
	     ps.setString(4, Add);
	     ps.setString(5, email);
	     ps.setString(6, date);
	     ps.executeUpdate();
	     return "m";


	
	}
}
