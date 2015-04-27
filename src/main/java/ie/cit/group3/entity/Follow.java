package ie.cit.group3.entity;
/*
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

*//**
 * @author Group 3
 *	
 *//*
@Entity
@Table(name="follow") //name of table in database
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
	private int id;
	
//	@OneToOne (fetch = FetchType.EAGER, mappedBy = "follow")
//	private Gamification gamification;
	
	private String followingid;
	
	private String followerid;
	
	private Date datestamp;
	
	


	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Follow(int id, Gamification gamification, String followingid,
			String followerid) {
		super();
		this.id = id;
//		this.gamification = gamification;
		this.followingid = followingid;
		this.followerid = followerid;
	}


	public Follow(String followingid, String followerid) {
		super();
		this.followingid = followingid;
		this.followerid = followerid;
//		this.datestamp = datestamp;
	}

	

	@Override
	public String toString() {
		return "Follow [id=" + id + ", followingid=" + followingid
				+ ", followerid=" + followerid + ", datestamp=" + datestamp
				+ "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFollowingid() {
		return followingid;
	}


	public void setFollowingid(String followingid) {
		this.followingid = followingid;
	}


	public String getFollowerid() {
		return followerid;
	}


	public void setFollowerid(String followerid) {
		this.followerid = followerid;
	}


	public Date getDatestamp() {
		return datestamp;
	}


	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	
	
	
	
}*/