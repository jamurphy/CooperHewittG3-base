package ie.cit.group3.entity;

import ie.cit.group3.domain.ChObject;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Group 3
 *	
 */
@Entity
@Table(name="gamification") //name of table in database
public class Gamification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
	private int id;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="user_id") //This is the foreign key
	private User user;
	
	private String chobject_id;	//object that new description is added to
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="game_id") //This is the foreign key
	private GameType gametype;

	private int gamepoints;
	private Date datestamp;	
	private String tagname;	

//	@OneToOne (fetch = FetchType.EAGER)
//	@JoinColumn(name="commentid") //This is the foreign key	
//	private Comment comment;

	private String storybookid;	
	private boolean thumbup = false;
	private boolean thumbdown = false;

//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="game_id") //This is the foreign key (id)
//	private Follow follow;
	//private int follow_id;
	
	private boolean flag = false;
	private String flagusername;	
	private Date flagdate;
	private String adminflagreviewed;
	private Date adminflagdate;
	
	
	
	public Gamification() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Gamification [user=" + user + ", chobject_id=" + chobject_id
				+ ", gametype=" + gametype + ", gamepoints=" + gamepoints
				+ ", datestamp=" + datestamp + ", tagname=" + tagname
				+ ", storybookid=" + storybookid + ", thumbup=" + thumbup
				+ ", thumbdown=" + thumbdown + ", follow=" + /*follow +*/ ", flag="
				+ flag + ", flagusername=" + flagusername + ", flagdate="
				+ flagdate + ", adminflagreviewed=" + adminflagreviewed
				+ ", adminflagdate=" + adminflagdate + "]";
	}



	/*public Gamification(User user, String chobject_id, GameType gametype,
			int gamepoints, Date datestamp, String tagname, String storybookid,
			boolean thumbup, boolean thumbdown, Follow follow, boolean flag,
			String flagusername, Date flagdate, String adminflagreviewed,
			Date adminflagdate) {
		super();
		this.user = user;
		this.chobject_id = chobject_id;
		this.gametype = gametype;
		this.gamepoints = gamepoints;
		this.datestamp = datestamp;
		this.tagname = tagname;
		this.storybookid = storybookid;
		this.thumbup = thumbup;
		this.thumbdown = thumbdown;
		this.follow = follow;
		this.flag = flag;
		this.flagusername = flagusername;
		this.flagdate = flagdate;
		this.adminflagreviewed = adminflagreviewed;
		this.adminflagdate = adminflagdate;
	}
*/


	public Gamification(User user, String chobject_id, GameType gametype,
			int gamepoints, Date datestamp, String tagname, String storybookid,
			boolean thumbup, boolean thumbdown, boolean flag,
			String flagusername, Date flagdate, String adminflagreviewed,
			Date adminflagdate) {
		super();
		this.user = user;
		this.chobject_id = chobject_id;
		this.gametype = gametype;
		this.gamepoints = gamepoints;
		this.datestamp = datestamp;
		this.tagname = tagname;
		this.storybookid = storybookid;
		this.thumbup = thumbup;
		this.thumbdown = thumbdown;
		this.flag = flag;
		this.flagusername = flagusername;
		this.flagdate = flagdate;
		this.adminflagreviewed = adminflagreviewed;
		this.adminflagdate = adminflagdate;
	}



	public Gamification(User user, String chobject_id, int gamepoints,
			Date datestamp, String tagname, String storybookid,
			boolean thumbup, boolean thumbdown, boolean flag,
			String flagusername, Date flagdate, String adminflagreviewed,
			Date adminflagdate) {
		super();
		this.user = user;
		this.chobject_id = chobject_id;
		this.gamepoints = gamepoints;
		this.datestamp = datestamp;
		this.tagname = tagname;
		this.storybookid = storybookid;
		this.thumbup = thumbup;
		this.thumbdown = thumbdown;
		this.flag = flag;
		this.flagusername = flagusername;
		this.flagdate = flagdate;
		this.adminflagreviewed = adminflagreviewed;
		this.adminflagdate = adminflagdate;
	}



	public GameType getGametype() {
		return gametype;
	}



	public void setGametype(GameType gametype) {
		this.gametype = gametype;
	}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getChobject_id() {
		return chobject_id;
	}



	public void setChobject_id(String chobject_id) {
		this.chobject_id = chobject_id;
	}



	public int getGamepoints() {
		return gamepoints;
	}



	public void setGamepoints(int gamepoints) {
		this.gamepoints = gamepoints;
	}



	public Date getDatestamp() {
		return datestamp;
	}



	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}



	public String getTagname() {
		return tagname;
	}



	public void setTagname(String tagname) {
		this.tagname = tagname;
	}



	public String getStorybookid() {
		return storybookid;
	}



	public void setStorybookid(String storybookid) {
		this.storybookid = storybookid;
	}



	public boolean isThumbup() {
		return thumbup;
	}



	public void setThumbup(boolean thumbup) {
		this.thumbup = thumbup;
	}



	public boolean isThumbdown() {
		return thumbdown;
	}



	public void setThumbdown(boolean thumbdown) {
		this.thumbdown = thumbdown;
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
