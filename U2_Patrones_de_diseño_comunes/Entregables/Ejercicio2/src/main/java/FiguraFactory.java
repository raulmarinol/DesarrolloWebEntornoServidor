

public class FiguraFactory {

public static Figura getFigura(String figura) {
		
		if(figura.equals("Triangulo")) {
			return new Triangulo("Rojo");
		}else if(figura.equals("Rectangulo")) {
			return new Rectangulo("verde");
		}else if(figura.equals("Circulo")) {	
			return new Circulo("amarrillo");
		}else{
			return new Cuadrado("naranja");
		}		
	}
}
