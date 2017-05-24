package user;

public class userDTO {

	private String nickname;
	private String usernumber;
	
	public userDTO(String nickname,String usernumber){
		this.nickname = nickname;
		this.usernumber = usernumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	
	
}
