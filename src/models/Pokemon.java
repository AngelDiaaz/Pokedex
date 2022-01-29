package models;

public class Pokemon {
	
	//Propiedades
	protected int numero;
	protected String nombre;
	protected double altura;
	protected double peso;
	protected String categoria;
	protected String habilidad;
	protected String url;
	private Tipos tipo1;
	private Tipos tipo2;
	
	//Constructores
	public Pokemon(int numero, String nombre, double altura, double peso, String categoria,
			String habilidad, String url) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
		this.url = url;
			}
	
	//Getters y setters

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
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

	public Tipos getTipo1() {
		return tipo1;
	}

	public void setTipo1(Tipos tipo1) {
		this.tipo1 = tipo1;
	}

	public Tipos getTipo2() {
		return tipo2;
	}

	public void setTipo2(Tipos tipo2) {
		this.tipo2 = tipo2;
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
		return "Pokemon [numero=" + numero + ", nombre=" + nombre + ", altura=" + altura + ", peso="
				+ peso + ", categoria=" + categoria + ", habilidad=" + habilidad + "]";
	}

		
}
