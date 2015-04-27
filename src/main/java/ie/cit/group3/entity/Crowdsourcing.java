package ie.cit.group3.entity;

import ie.cit.group3.domain.ChObject;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Group 3
 *	
 */
@Entity
@Table(name="crowdsourcing") //name of table in database
public class Crowdsourcing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
	private int id;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="user_id") //This is the foreign key
	private User user;

	String chobject_id;	//object that new description is added to
	
	
	private String description;	//user description
	private Date datestamp;		//date user added description
	private boolean flag = false;		//flag to identify that a description has been flagged as inappropriate
	private String flagusername;	//user name of person that flagged description as inappropriate
	private Date flagdate;			//date description was flagged as inappropriate
	private String adminflagreviewed;	//admin reviewed flagged description and adds option comment on review (admin can optionally change the flag status)
	private Date adminflagdate;			//date admin reviewed the flagged description
	
	
	
	
	
	public Crowdsourcing() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Crowdsourcing(String chobject_id, String description,
			Date datestamp, boolean flag, String flagusername, Date flagdate,
			String adminflagreviewed, Date adminflagdate) {
		super();
		this.chobject_id = chobject_id;
		this.description = description;
		this.datestamp = datestamp;
		this.flag = flag;
		this.flagusername = flagusername;
		this.flagdate = flagdate;
		this.adminflagreviewed = adminflagreviewed;
		this.adminflagdate = adminflagdate;
	}



	public Crowdsourcing(String user_id, String chobject_id, String description,
			Date datestamp, boolean flag, String flagusername, Date flagdate,
			String adminflagreviewed, Date adminflagdate) {
		super();
		this.user.setUsername(user_id);
		this.chobject_id = chobject_id;
		this.description = description;
		this.datestamp = datestamp;
		this.flag = flag;
		this.flagusername = flagusername;
		this.flagdate = flagdate;
		this.adminflagreviewed = adminflagreviewed;
		this.adminflagdate = adminflagdate;
	}
	public Crowdsourcing(User user, String chobject_id, String description,
			Date datestamp, boolean flag, String flagusername, Date flagdate,
			String adminflagreviewed, Date adminflagdate) {
		super();
		this.user = user;
		this.chobject_id = chobject_id;
		this.description = description;
		this.datestamp = datestamp;
		this.flag = flag;
		this.flagusername = flagusername;
		this.flagdate = flagdate;
		this.adminflagreviewed = adminflagreviewed;
		this.adminflagdate = adminflagdate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}

//	public List<ChObject> getChobjects() {
//		return chobjects;
//	}
//
//	public void setChobjects(List<ChObject> chobjects) {
//		this.chobjects = chobjects;
//	}

	//	public int getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
//	public String getChobject_id() {
//		return chobject_id;
//	}
//	public void setChobject_id(String chobject_id) {
//		this.chobject_id = chobject_id;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getFlagusername() {
		return flagusername;
	}
	public void setFlagusername(String flagusername) {
		this.flagusername = flagusername;
	}
	public Date getFlagdate() {
		return flagdate;
	}
	public void setFlagdate(Date flagdate) {
		this.flagdate = flagdate;
	}
	public String getAdminflagreviewed() {
		return adminflagreviewed;
	}
	public void setAdminflagreviewed(String adminflagreviewed) {
		this.adminflagreviewed = adminflagreviewed;
	}
	public Date getAdminflagdate() {
		return adminflagdate;
	}
	public void setAdminflagdate(Date adminflagdate) {
		this.adminflagdate = adminflagdate;
	}
	
	

}
