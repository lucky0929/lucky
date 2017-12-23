package model;

public class NaverProfile {

	public String id;
	public String name;
	public String nickName;
	public String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "NaverProfile [id=" + id + ", name=" + name + ", nickName=" + nickName + ", email=" + email + "]";
	}
	
	
	
}
