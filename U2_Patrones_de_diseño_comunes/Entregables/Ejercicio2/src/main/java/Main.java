
public class Main {

	public static void main(String[] args) {
		Figura a = FiguraFactory.getFigura("Circulo"); 
		
		a.dibujarFigura();
		System.out.println(a.getColor());
		
		Figura b = FiguraFactory.getFigura("Cuadrado"); 
		b.dibujarFigura();
		System.out.println(b.getColor());
		
		Figura c = FiguraFactory.getFigura("Rectangulo"); 
		c.dibujarFigura();
		System.out.println(c.getColor());
		
		Figura d = FiguraFactory.getFigura("Triangulo"); 
		d.dibujarFigura();
		System.out.println(d.getColor());
		
	}
}
