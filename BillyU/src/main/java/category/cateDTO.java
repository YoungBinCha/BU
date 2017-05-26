package category;

public class cateDTO {
	int categorynumber;
	String categorybig;
	String categorysmall;
	
	public cateDTO(int categorynumber,String categorybig,String categorysmall){
		this.categorynumber = categorynumber;
		this.categorybig = categorybig;
		this.categorysmall = categorysmall;
	}
	public cateDTO(String categorybig){
		this.categorybig = categorybig;
	}
	public cateDTO(String categorybig,String categorysmall){
		this.categorybig = categorybig;
		this.categorysmall = categorysmall;
		
	}
	public int getcategorynumber() {
		return categorynumber;
	}
	public void setcategorynumber(int categorynumber) {
		this.categorynumber = categorynumber;
	}
	public String getcategorybig() {
		return categorybig;
	}
	public void setcategorybig(String categorybig) {
		this.categorybig = categorybig;
	}
	public String getcategorysmall() {
		return categorysmall;
	}
	public void setcategorysmall(String categorysmall) {
		this.categorysmall = categorysmall;
	}
	
	
}
