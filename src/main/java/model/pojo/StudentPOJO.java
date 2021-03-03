package model.pojo;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class StudentPOJO{
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private int sid;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	private List<String> courses;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
