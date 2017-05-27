package product;

import java.sql.Timestamp;

public class proDTO {

	int productnumber;
	String nickname;
	int categorynumber;
	String title;
	String productinformation;
	String location;
	String productstate;
	int rentprice;
	int rentunit;
	int rentdeposite;
	String img;
	Timestamp curtime;

	public proDTO(int productnumber,String nickname,int categorynumber,String title, String location,String productinformation,String productstate,int rentprice,int rentunit,int rentdeposite,String img,Timestamp curtime){
		this.productnumber = productnumber;
		this.nickname = nickname;
		this.categorynumber = categorynumber;
		this.title = title;
		this.productinformation = productinformation;
		this.location = location;
		this.productstate = productstate;
		this.rentprice = rentprice;
		this.rentunit = rentunit;
		this.rentdeposite = rentdeposite;
		this.img = img;
		this.curtime = curtime;
	}

	public int getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCategorynumber() {
		return categorynumber;
	}

	public void setCategorynumber(int categorynumber) {
		this.categorynumber = categorynumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductinformation() {
		return productinformation;
	}

	public void setProductinformation(String productinformation) {
		this.productinformation = productinformation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProductstate() {
		return productstate;
	}

	public void setProductstate(String productstate) {
		this.productstate = productstate;
	}

	public int getRentprice() {
		return rentprice;
	}

	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}

	public int getRentunit() {
		return rentunit;
	}

	public void setRentunit(int rentunit) {
		this.rentunit = rentunit;
	}

	public int getRentdeposite() {
		return rentdeposite;
	}

	public void setRentdeposite(int rentdeposite) {
		this.rentdeposite = rentdeposite;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getCurtime() {
		return curtime;
	}

	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}
	

	
}
