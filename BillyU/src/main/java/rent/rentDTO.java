package rent;

public class rentDTO {

	private int rentnum;
	private String hoster;
	private String guest;
	private int pronum;
	private String way;
	private int startdate;
	private int rentday;
	private String message;
	private int total;
	
	public rentDTO(int rentnum,String hoster,String guest,int pronum,String way,int startdate,int rentday,String message,int total){
		this.rentnum = rentnum;
		this.hoster = hoster;
		this.guest = guest;
		this.pronum = pronum;
		this.way = way;
		this.startdate = startdate;
		this.rentday = rentday;
		this.message = message;
		this.total = total;
	}
	
	public int getRentnum() {
		return rentnum;
	}
	public void setRentnum(int rentnum) {
		this.rentnum = rentnum;
	}
	
	public String getHoster() {
		return hoster;
	}

	public void setHost(String hoster) {
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
	public int getStartdate() {
		return startdate;
	}
	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}
	public int getRentday() {
		return rentday;
	}
	public void setRentday(int rentday) {
		this.rentday = rentday;
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
