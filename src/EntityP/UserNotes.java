package EntityP;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserNotes")
public class UserNotes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noteID;
	private String title;
	private String note;
	private Date creationTime;
	private Date lastUpdate;
	@ManyToOne
	private User user;

	public UserNotes() {

	}

	public UserNotes(String title, String note, Date creationTime,
			Date lastUpdate) {
		this.title = title;
		this.note = note;
		this.creationTime = creationTime;
		this.lastUpdate = lastUpdate;
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
