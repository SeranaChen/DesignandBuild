package webProject.vo;

public class UserInfo {

	private int userid;
	   private String username;
	   private String password;
	    private String passwordagain;
		private String Gender;
		private String Age;
		private String Tel;
		private String Email;
	   
	public String getUsername() {
		   return username;
	   }
	   public String getPassword() {
		return password;
	}
	   public void setPassword(String password) {
		this.password = password;
	}
	   public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordagain() {
		return passwordagain;
	}
	public void setPasswordagain(String passwordagain) {
		this.passwordagain = passwordagain;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String string) {
		Age = string;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		
		Tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	   
	   
	   }


	
