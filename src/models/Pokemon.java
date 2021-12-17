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
	
	//Constructores
	public Pokemon(int numero, String nombre, Tipo tipo, double altura, double peso, String categoria,
			String habilidad) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo = tipo;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
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

	@Override
	public String toString() {
		return "Pokemon [numero=" + numero + ", nombre=" + nombre + ", tipo=" + tipo + ", altura=" + altura + ", peso="
				+ peso + ", categoria=" + categoria + ", habilidad=" + habilidad + "]";
	}
	

	
	
	
}
