package regist;

public class registDTO {
	
	private String nickname;
	private int categorynumber;
	private String title;
	private String productinformation;
	private String location;
	private String productstate;


	private int rentprice;
	private int rentdeposite;
	private int rentmaxdate;			
	
	
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	
	public registDTO(String nickname, int categorynumber, String title, String productinformation, String location, String productstate, int rentprice, int rentdeposite, int rentmaxdate){
		this.nickname = nickname;
		this.categorynumber = categorynumber;
		this.title = title;
		this.productinformation = productinformation;
		this.location = location;
		this.productstate = productstate;
		this.rentprice = rentprice;
		this.rentdeposite = rentdeposite;
		this.rentmaxdate = rentmaxdate;
	}
	
	public registDTO(String img1, String img2, String img3, String img4){
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
	}
	
	
	public String getImg1() {
		return img1;
	}
	public void setImg(String img1) {
		this.img1 = img1;
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
	public int getrentprice() {
		return rentprice;
	}
	public void setrentprice(int rentprice) {
		this.rentprice = rentprice;
	}
	public int getrentdeposite() {
		return rentdeposite;
	}
	public void setrentdeposite(int rentdeposite) {
		this.rentdeposite = rentdeposite;
	}
	public int getrentmaxdate() {
		return rentmaxdate;
	}
	public void setrentmaxdate(int rentmaxdate) {
		this.rentmaxdate = rentmaxdate;
	}
	public int getcategorynumber() {
		return categorynumber;
	}
	public void setcategorynumber(int categorynumber) {
		this.categorynumber = categorynumber;
	}
	public String getproductstate() {
		return productstate;
	}
	public void setproductstate(String productstate) {
		this.productstate = productstate;
	}
	public String getproductinformation() {
		return productinformation;
	}
	public void setproductinformation(String productinformation) {
		this.productinformation = productinformation;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
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
