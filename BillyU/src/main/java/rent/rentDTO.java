package rent;

import java.sql.Timestamp;

public class rentDTO {


	private int rentnumber;
	private String producthost;
	private String productguest;
	private int productnumber;
	private int startdate;
	private int enddate;

	private String message;
	private int totalprice;
	Timestamp curtime;
	

	public rentDTO(int rentnumber,String producthost,String productguest,int productnumber,int startdate,int enddate,String message,int totalprice,Timestamp curtime){
		this.rentnumber = rentnumber;
		this.producthost = producthost;
		this.productguest = productguest;
		this.productnumber = productnumber;

		this.startdate = startdate;
		this.enddate = enddate;
		this.message = message;
		this.totalprice = totalprice;
		this.curtime = curtime;
	}


	public int getRentnumber() {
		return rentnumber;
	}


	public void setRentnumber(int rentnumber) {
		this.rentnumber = rentnumber;
	}


	public String getProducthost() {
		return producthost;
	}


	public void setProducthost(String producthost) {
		this.producthost = producthost;
	}


	public String getProductguest() {
		return productguest;
	}


	public void setProductguest(String productguest) {
		this.productguest = productguest;
	}


	public int getProductnumber() {
		return productnumber;
	}


	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}


	public int getStartdate() {
		return startdate;
	}


	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}


	public int getEnddate() {
		return enddate;
	}


	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}


	public Timestamp getCurtime() {
		return curtime;
	}


	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}
	
	
	
	
	
}
