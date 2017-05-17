package sale;

public class saleDTO {

	private int salenum;
	private String hoster;
	private String guest;
	private int pronum;
	private String way;
	private String message;
	private int total;
	
	public saleDTO(int salenum,String hoster,String guest,int pronum,String way,String message,int total){
		this.salenum = salenum;
		this.hoster = hoster;
		this.guest = guest;
		this.pronum = pronum;
		this.way = way;
		this.message = message;
		this.total = total;
	}
	
	public int getSalenum() {
		return salenum;
	}
	public void setSalenum(int salenum) {
		this.salenum = salenum;
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
	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
