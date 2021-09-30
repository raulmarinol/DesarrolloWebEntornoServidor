
public class Main {

	public static void main(String[] args) {
		
		Pared p1 = new Pared(3.5);
		Pared p2 = new Pared(3.5);
		Pared p3 = new Pared(3.5);
		Pared p4 = new Pared(3.5);
		Pared p5 = new Pared(5.05);
		Pared p6 = new Pared(5.05);
		Pared p7 = new Pared(5.05);
		Pared p8 = new Pared(5.05);
		
		Tejado t1 = new TejadoTeja();
		Tejado t2 = new TejadoTeja();
		
		Casa c1 = new Casa(25, p1, p2, p3, p4, t1);
		Casa c2 = new Casa(25, p5, p6, p7, p8, t2);
		
		System.out.println(c1);
		System.out.println(c2);
		
		t1.darSoporte();
		
	}
}
