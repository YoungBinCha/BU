package product;

import java.sql.Timestamp;

public class proDTO {

	int pronum;
	String nickname;
	int catnum;
	String title;
	String proinfo;
	String procondition;
	String traway;
	String tratype;
	int renprice;
	int renday;
	int deposit;
	int salprice;
	String img;
	Timestamp curtime;

	public proDTO(int pronum,String nickname,int catnum,String title,String proinfo,String procondition,String traway,String tratype,int renprice,int renday,int deposit,int salprice,String img,Timestamp curtime){
		this.pronum = pronum;
		this.nickname = nickname;
		this.catnum = catnum;
		this.title = title;
		this.proinfo = proinfo;
		this.procondition = procondition;
		this.traway = traway;
		this.tratype = tratype;
		this.renprice = renprice;
		this.renday = renday;
		this.deposit = deposit;
		this.salprice = salprice;
		this.img = img;
		this.curtime = curtime;
	}
	
	public Timestamp getCurtime() {
		return curtime;
	}

	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCatnum() {
		return catnum;
	}
	public void setCatnum(int catnum) {
		this.catnum = catnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProinfo() {
		return proinfo;
	}
	public void setProinfo(String proinfo) {
		this.proinfo = proinfo;
	}
	public String getProcondition() {
		return procondition;
	}
	public void setProcondition(String procondition) {
		this.procondition = procondition;
	}
	public String getTraway() {
		return traway;
	}
	public void setTraway(String traway) {
		this.traway = traway;
	}
	public String getTratype() {
		return tratype;
	}
	public void setTratype(String tratype) {
		this.tratype = tratype;
	}
	public int getRenprice() {
		return renprice;
	}
	public void setRenprice(int renprice) {
		this.renprice = renprice;
	}
	public int getRenday() {
		return renday;
	}
	public void setRenday(int renday) {
		this.renday = renday;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getSalprice() {
		return salprice;
	}
	public void setSalprice(int salprice) {
		this.salprice = salprice;
	}

	
}
