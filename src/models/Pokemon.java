package models;

public class Pokemon {
	
	//Propiedades
	protected int numero;
	protected String nombre;
	protected String tipo1;
	protected String tipo2;
	protected double altura;
	protected double peso;
	protected String categoria;
	protected String habilidad;
	protected String url;
	
	//Constructores
	public Pokemon(int numero, String nombre, String tipo1, String tipo2, double altura, double peso, String categoria,
			String habilidad, String url) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
		this.url = url;
			}
	
	//Para que los tipos sean string y no enums
	public Pokemon(int numero2, String nombre2, String tipo1, double altura2, double peso2, String categoria2,
			String habilidad2, String url2) {
		// TODO Auto-generated constructor stub
		this.numero = numero2;
		this.nombre = nombre2;
		this.tipo1 = tipo1;
		this.altura = altura2;
		this.peso = peso2;
		this.categoria = categoria2;
		this.habilidad = habilidad2;
		this.url = url2;
	}
	//Getters y setters

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo1() {
		return tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	@Override
	public String toString() {
		return "Pokemon [numero=" + numero + ", nombre=" + nombre + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", altura=" + altura + ", peso="
				+ peso + ", categoria=" + categoria + ", habilidad=" + habilidad + "]";
	}

		
}
