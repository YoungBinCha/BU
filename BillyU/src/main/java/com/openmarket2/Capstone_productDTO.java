package com.openmarket2;

public class Capstone_productDTO {
	/*상품 공통 변수*/
	private String nickname;
	private int catnum;
	private String title;
	private String proinfo;
	private String procondition;
	private String tratype;
	private String traway;
	
	/*판매 변수*/
	private int salprice;
	
	/*대여 변수*/
	private int renprice;
	private int deposit;
	private int renday;				//이건 나중에 변수 타입 바꿔야되 date 나 이런걸로!!!!
	
	/*이미지 변수*/
	private String img;
	private String img2;
	private String img3;
	private String img4;
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public int getRenprice() {
		return renprice;
	}
	public void setRenprice(int renprice) {
		this.renprice = renprice;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getRenday() {
		return renday;
	}
	public void setRenday(int renday) {
		this.renday = renday;
	}
	public int getCatnum() {
		return catnum;
	}
	public void setCatnum(int catnum) {
		this.catnum = catnum;
	}
	public String getTratype() {
		return tratype;
	}
	public void setTratype(String tratype) {
		this.tratype = tratype;
	}
	public String getTraway() {
		return traway;
	}
	public void setTraway(String traway) {
		this.traway = traway;
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
	public int getSalprice() {
		return salprice;
	}
	public void setSalprice(int salprice) {
		this.salprice = salprice;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
