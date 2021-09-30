package ejercicio3;



public class Presidente {
	private String nombre;
	private String apellidos;
	private int anio;
	
	private static Presidente presi = null;
	
	public Presidente(String nombre, String apellidos, int anio) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anio = anio;
	}
	

	public static Presidente getPresidente(String nombre, String apellidos, int anio) {
		if(presi == null) {
			presi = new Presidente(nombre, apellidos, anio);
		}
		return presi;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public static Presidente getPresi() {
		return presi;
	}

	public static void setPresi(Presidente presi) {
		Presidente.presi = presi;
	}

	@Override
	public String toString() {
		return "Presidente [nombre=" + nombre + ", apellidos=" + apellidos + ", anio=" + anio + "]";
	}
	
	
	

}
