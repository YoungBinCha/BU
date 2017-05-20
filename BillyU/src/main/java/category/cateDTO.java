package category;

public class cateDTO {
	int catnum;
	String big;
	String small;
	
	public cateDTO(int catnum,String big,String small){
		this.catnum = catnum;
		this.big = big;
		this.small = small;
	}
	public cateDTO(String big){
		this.big = big;
	}
	public cateDTO(String big,String small){
		this.big = big;
		this.small = small;
		
	}
	public int getCatnum() {
		return catnum;
	}
	public void setCatnum(int catnum) {
		this.catnum = catnum;
	}
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
		this.big = big;
	}
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
	
	
}
