package models;

import enums.Tipo;

public class Pokemon {
	
	//Propiedades
	protected int numero;
	protected String nombre;
	protected Tipo tipo;
	protected double altura;
	protected double peso;
	protected String categoria;
	protected String habilidad;
	protected String url;
	
	//Constructores
	public Pokemon(int numero, String nombre, Tipo tipo, double altura, double peso, String categoria,
			String habilidad, String url) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo = tipo;
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

	public Tipo getTipo() {
		return tipo;
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

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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

		
}
