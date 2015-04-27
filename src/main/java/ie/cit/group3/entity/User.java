package ie.cit.group3.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Group 3
 *	
 */

@Entity  //indicates this is a JPA entity
@Table(name="user") //name of table in database
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures the ID is generated automatically and is compatible with underlying database AI implementation
	//@ManyToOne
	private int id;
	
	@OneToMany (mappedBy = "user")//(cascade={CascadeType.ALL})
	private List<Gamification> gamification;
	
	@OneToMany (mappedBy = "user")//(cascade={CascadeType.ALL})
	private List<Crowdsourcing> crowdsourcing;

	private String username;  //mapped to column named 'username'
	private String password;
	private String profilename;
	private String address1;
	private String address2;
	private String address3;
	private String email;
	private int age;
	private boolean accountstatus;
	private int pinid;
	private Date datejoined;
	
	
	
	protected User() {   //The default construct exists for JPA
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username) {
	super();
	this.username = username;
}
	
	
	
	public User(String username,
			String password, String profilename, String address1,
			String address2, String address3, String email, int age,
			boolean accountstatus, int pinid, Date datejoined, Gamification gamification) {
		super();
		this.gamification.add(gamification);
		this.username = username;
		this.password = password;
		this.profilename = profilename;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.age = age;
		this.accountstatus = accountstatus;
		this.pinid = pinid;
		this.datejoined = datejoined;
	}

	public User(String username,String password, String profilename, String address1,
			String address2, String address3, String email, int age,
			boolean accountstatus, int pinid, Date datejoined,List<Gamification> gamification) {
		super();
		this.gamification = gamification;

		this.username = username;
		this.password = password;
		this.profilename = profilename;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.age = age;
		this.accountstatus = accountstatus;
		this.pinid = pinid;
		this.datejoined = datejoined;
	}

	public List<Gamification> getGamification() {
		return gamification;
	}

	public void setGamification(List<Gamification> gamification) {
		this.gamification = gamification;
	}

	public List<Crowdsourcing> getCrowdsourcing() {
		return crowdsourcing;
	}

	public void setCrowdsourcing(List<Crowdsourcing> crowdsourcing) {
		this.crowdsourcing = crowdsourcing;
	}

	public User(Crowdsourcing crowdsourcing, String username,
			String password, String profilename, String address1,
			String address2, String address3, String email, int age,
			boolean accountstatus, int pinid, Date datejoined) {
		super();
		this.crowdsourcing.add(crowdsourcing);
		this.username = username;
		this.password = password;
		this.profilename = profilename;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.age = age;
		this.accountstatus = accountstatus;
		this.pinid = pinid;
		this.datejoined = datejoined;
	}


	public User(List<Crowdsourcing> crowdsourcing, String username,
			String password, String profilename, String address1,
			String address2, String address3, String email, int age,
			boolean accountstatus, int pinid, Date datejoined) {
		super();
		this.crowdsourcing = crowdsourcing;
		this.username = username;
		this.password = password;
		this.profilename = profilename;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.age = age;
		this.accountstatus = accountstatus;
		this.pinid = pinid;
		this.datejoined = datejoined;
	}

	public User(String username, String password, String profilename,
			String address1, String address2, String address3, String email,
			int age, boolean accountstatus, int pinid, Date datejoined) {
		super();
		this.username = username;
		this.password = password;
		this.profilename = profilename;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.age = age;
		this.accountstatus = accountstatus;
		this.pinid = pinid;
		this.datejoined = datejoined;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", profilename=" + profilename + ", address1="
				+ address1 + ", address2=" + address2 + ", address3="
				+ address3 + ", email=" + email + ", age=" + age
				+ ", accountstatus=" + accountstatus + ", pinid=" + pinid
				+ ", datejoined=" + datejoined 
				+ "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getProfilename() {
		return profilename;
	}



	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}



	public String getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	public String getAddress3() {
		return address3;
	}



	public void setAddress3(String address3) {
		this.address3 = address3;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public boolean isAccountstatus() {
		return accountstatus;
	}



	public void setAccountstatus(boolean accountstatus) {
		this.accountstatus = accountstatus;
	}



	public int getPinid() {
		return pinid;
	}



	public void setPinid(int pinid) {
		this.pinid = pinid;
	}



	public Date getDatejoined() {
		return datejoined;
	}



	public void setDatejoined(Date datejoined) {
		this.datejoined = datejoined;
	}
	
	
	
	
}
