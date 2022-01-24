package models;

public class Tipos {
	
	//Propiedades
	private int id;
	private String nombre;
	
	//Constructor
	public Tipos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
