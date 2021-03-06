package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id = -1;
	private String username;
	private String password;
	private String email;
	private String gender;
	private String birth;
	private String[] hobby;
	private Date createTime;

	public User(String username, String password, String email, String gender, String birth, String[] hobby) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.hobby = hobby;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", birth=" + birth + ", hobby=" + Arrays.toString(hobby) + "]";
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
