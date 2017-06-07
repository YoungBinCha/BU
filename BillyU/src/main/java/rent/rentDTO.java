package rent;

import java.sql.Timestamp;

public class rentDTO {


	private int rentnumber;
	private String producthost;
	private String productguest;
	private int productnumber;
	private String startdate;
	private String enddate;

	private String message;
	private int totalprice;
	Timestamp curtime;
	private String flag;
	

	public rentDTO(int rentnumber,String producthost,String productguest,int productnumber,String startdate,String enddate,String message,int totalprice,Timestamp curtime,String flag){
		this.rentnumber = rentnumber;
		this.producthost = producthost;
		this.productguest = productguest;
		this.productnumber = productnumber;

		this.startdate = startdate;
		this.enddate = enddate;
		this.message = message;
		this.totalprice = totalprice;
		this.curtime = curtime;
		
		this.flag = flag;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
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
