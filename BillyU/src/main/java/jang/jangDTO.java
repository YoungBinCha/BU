package jang;

import java.sql.Timestamp;

public class jangDTO {

	private int cartnumber;
	private String nickname;
	private int productnumber;
	Timestamp curtime;
	
	public jangDTO(int cartnumber,String nickname,int productnumber,Timestamp curtime){
		this.cartnumber = cartnumber;
		this.nickname = nickname;
		this.productnumber = productnumber;
		this.curtime = curtime;
	}
	
	
	public Timestamp getCurtime() {
		return curtime;
	}


	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}


	public int getcartnumber() {
		return cartnumber;
	}
	public void setcartnumber(int cartnumber) {
		this.cartnumber = cartnumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getproductnumber() {
		return productnumber;
	}
	public void setproductnumber(int productnumber) {
		this.productnumber = productnumber;
	}
	
}
