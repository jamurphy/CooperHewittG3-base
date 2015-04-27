package ie.cit.group3.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Group 3
 *	
 */
@Entity
@Table(name="gametype") //name of table in database
public class GameType {
	
	@Id //indicate primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
	private int game_id;
	
	@OneToOne (fetch = FetchType.EAGER, mappedBy = "gametype")
	private Gamification gamification;
	
	private int gamepoints;
	private String gamename;
	
	
	public GameType(int gamepoints, String gamename) {
		super();
		this.gamepoints = gamepoints;
		this.gamename = gamename;
	}

	public GameType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GameType [game_id=" + game_id + ", gamepoints=" + gamepoints
				+ ", gamename=" + gamename + "]";
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public int getGamepoints() {
		return gamepoints;
	}

	public void setGamepoints(int gamepoints) {
		this.gamepoints = gamepoints;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	
	
	
}


