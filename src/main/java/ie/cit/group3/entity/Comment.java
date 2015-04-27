package ie.cit.group3.entity;
/*
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
@Table(name="comment") //name of table in database
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
//	@OneToOne
	private int id;
	
	@OneToOne (fetch = FetchType.EAGER, mappedBy = "comment")
	private Gamification gamification;
	
	private String commenttext;
	
	
	public Comment(String commenttext) {
		super();
		this.commenttext = commenttext;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commenttext=" + commenttext + "]";	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	
	

}
*/