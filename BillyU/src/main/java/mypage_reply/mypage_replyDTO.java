package mypage_reply;

import java.sql.Timestamp;

public class mypage_replyDTO {

	private int pronum;
	private String hoster;
	private String guest;
	private String message;
	private Timestamp curtime;
	
	public mypage_replyDTO(String hoster,String guest,String message,Timestamp curtime,int pronum){
		this.hoster = hoster;
		this.guest = guest;
		this.message = message;
		this.curtime = curtime;
		this.pronum = pronum;
	}

	public int getPronum() {
		return pronum;
	}

	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	public String getHoster() {
		return hoster;
	}

	public void setHoster(String hoster) {
		this.hoster = hoster;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCurtime() {
		return curtime;
	}

	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}
	
	
}
