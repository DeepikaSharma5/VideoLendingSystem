package newpackage;

public class User {
	int Userid;
	String first_name;
	String contact_no;
	String email;
	String passsword;
	String cnfrmpwd;
	
	public User() {
		super();
		
	}
	public User(int Userid, String first_name, String contact_no, String email, String passsword, String cnfrmpwd) {
		super();
		this.Userid = Userid;
		this.first_name = first_name;
		this.contact_no = contact_no;
		this.email = email;
		this.passsword = passsword;
		this.cnfrmpwd = cnfrmpwd;
	}

	public User(String first_name, String contact_no, String email, String passsword, String cnfrmpwd) {
		super();
		this.first_name = first_name;
		this.contact_no = contact_no;
		this.email = email;
		this.passsword = passsword;
		this.cnfrmpwd = cnfrmpwd;
	}
	
	public User(String email, String passsword) {
		super();
		this.email = email;
		this.passsword = passsword;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int Userid) {
		this.Userid = Userid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	public String getCnfrmpwd() {
		return cnfrmpwd;
	}
	public void setCnfrmpwd(String cnfrmpwd) {
		this.cnfrmpwd = cnfrmpwd;
	}
	
	
	
	
}
