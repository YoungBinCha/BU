package jang;

import java.sql.Timestamp;

public class jangDTO {

	private int jangnum;
	private String nickname;
	private int pronum;
	Timestamp curtime;
	
	public jangDTO(int jangnum,String nickname,int pronum,Timestamp curtime){
		this.jangnum = jangnum;
		this.nickname = nickname;
		this.pronum = pronum;
		this.curtime = curtime;
	}
	
	
	public Timestamp getCurtime() {
		return curtime;
	}


	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}


	public int getJangnum() {
		return jangnum;
	}
	public void setJangnum(int jangnum) {
		this.jangnum = jangnum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	
}
