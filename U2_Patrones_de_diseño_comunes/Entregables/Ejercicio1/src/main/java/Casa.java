
public class Casa {

	private int area;
	private Pared p1;
	private Pared p2;
	private Pared p3;
	private Pared p4;
	private Tejado t1;
	
	public Casa(int area, Pared p1, Pared p2, Pared p3, Pared p4, Tejado t1) {
		super();
		this.area = area;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.t1 = t1;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Pared getP1() {
		return p1;
	}
	public void setP1(Pared p1) {
		this.p1 = p1;
	}
	public Pared getP2() {
		return p2;
	}
	public void setP2(Pared p2) {
		this.p2 = p2;
	}
	public Pared getP3() {
		return p3;
	}
	public void setP3(Pared p3) {
		this.p3 = p3;
	}
	public Pared getP4() {
		return p4;
	}
	public void setP4(Pared p4) {
		this.p4 = p4;
	}
	public Tejado getT1() {
		return t1;
	}
	public void setT1(Tejado t1) {
		this.t1 = t1;
	}
	@Override
	public String toString() {
		return "Casa [area=" + area + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", t1=" + t1 + "]";
	}
	
	
}
