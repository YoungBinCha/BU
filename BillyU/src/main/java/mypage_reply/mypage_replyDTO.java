package mypage_reply;

import java.sql.Timestamp;

public class mypage_replyDTO {

	private int productnumber;
	private String producthost;
	private String productguest;
	private String message;
	private Timestamp curtime;
	
	public mypage_replyDTO(String producthost,String productguest,String message,Timestamp curtime,int productnumber){
		this.producthost = producthost;
		this.productguest = productguest;
		this.message = message;
		this.curtime = curtime;
		this.productnumber = productnumber;
	}

	public int getproductnumber() {
		return productnumber;
	}

	public void setproductnumber(int productnumber) {
		this.productnumber = productnumber;
	}

	public String getproducthost() {
		return producthost;
	}

	public void setproducthost(String producthost) {
		this.producthost = producthost;
	}

	public String getproductguest() {
		return productguest;
	}

	public void setproductguest(String productguest) {
		this.productguest = productguest;
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
