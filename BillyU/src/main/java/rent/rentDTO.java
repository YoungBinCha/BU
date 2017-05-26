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
	
	
	public Timestamp getCurtime() {
		return curtime;
	}


	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}


	public void setproducthost(String producthost) {
		this.producthost = producthost;
	}


	public int getrentnumber() {
		return rentnumber;
	}
	public void setrentnumber(int rentnumber) {
		this.rentnumber = rentnumber;
	}
	
	public String getproducthost() {
		return producthost;
	}

	public void setHost(String producthost) {
		this.producthost = producthost;
	}

	public String getproductguest() {
		return productguest;
	}

	public void setproductguest(String productguest) {
		this.productguest = productguest;
	}

	public int getproductnumber() {
		return productnumber;
	}
	public void setproductnumber(int productnumber) {
		this.productnumber = productnumber;
	}
	public int getStartdate() {
		return startdate;
	}
	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}
	public int getenddate() {
		return enddate;
	}
	public void setenddate(int enddate) {
		this.enddate = enddate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int gettotalprice() {
		return totalprice;
	}
	public void settotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	
}
