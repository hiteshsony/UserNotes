package EntityP;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cfg.annotations.Nullability;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String password;
	private String email;
	private Date creationTime;
	private Date lastUpdate;

	
	@OneToMany
	Set<UserNotes> notes = new HashSet<UserNotes>();

	public Set<UserNotes> getNotes() {
		return notes;
	}
	public void setNotes(Set<UserNotes> notes) {
		this.notes = notes;
	}
	public User(){
		
	}
	public User(String password,String email,Date creationTime,Date lastUpdate){
		this.password=password;
		this.email=email;
		this.creationTime = creationTime;
		this.lastUpdate = lastUpdate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
