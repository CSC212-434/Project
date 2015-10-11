
public class circle {

	double cy,cx,r;
	String id,style;
	public circle(double cy, double cx, double r, String id,
			String style) {
		super();
		this.cy = cy;
		this.cx = cx;
		this.r = r;
		this.id = id;
		this.style = style;
		
	}
		public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getCy() {
		return cy;
	}
	public void setCy(String cy) {
		this.cy = cy;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	
}
