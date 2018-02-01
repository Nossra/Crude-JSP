package viewmodel;

public class LoginViewModel {
	private String username;
	private String name;
	
	public LoginViewModel() {
		
	}
	
	public LoginViewModel(String username, String name) {
		this.setUsername(username);
		this.setName(name);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
