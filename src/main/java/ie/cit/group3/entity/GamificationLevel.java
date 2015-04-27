package ie.cit.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Group 3
 *	
 */
@Entity
@Table(name="gamificationlevel") //name of table in database
public class GamificationLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
	private int level_id;
	
	private int levelpoints;
	private String levelname;
	
	
	
	public GamificationLevel() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "GamificationLevel [level_id=" + level_id + ", levelpoints="
				+ levelpoints + ", levelname=" + levelname + "]";
	}



	public int getLevel_id() {
		return level_id;
	}



	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}



	public int getLevelpoints() {
		return levelpoints;
	}



	public void setLevelpoints(int levelpoints) {
		this.levelpoints = levelpoints;
	}



	public String getLevelname() {
		return levelname;
	}



	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	
}


