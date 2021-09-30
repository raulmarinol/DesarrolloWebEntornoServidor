package ejercicio3;

public class Main {
	public static void main(String[] args) {
		
		Presidente p1 = Presidente.getPresidente("Pepe","López",2000);
		
		System.out.println(p1);
		
				
		Presidente p2 = Presidente.getPresidente("Juan","López",2000);
		System.out.println(p2);
		
	}

}
