package dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Pokemon;

public class PokemonDAO {
	final String DB_URL = "jdbc:mysql://localhost/usuario_pokedex";
	final String USER = "usuarios";
	final String PASS = "usuario_pokemon";
	final String QUERY = "SELECT idpokemons, nombre, tipo, altura, peso, categoria, habilidad, url FROM pokemons";

	/**
	 * Método que guarda todos los pokemons de la base de datos en un array list, para luego poder verla en la pokedex
	 * @return ArrayList con todos los pokemons de la base de datos
	 */
	
	public ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT idpokemons, nombre, tipo, altura, peso, categoria, habilidad, url "
				+ "FROM pokemons";
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int numero = rs.getInt("idpokemons");
				String nombre = rs.getString("nombre");
				String tipo = rs.getString("tipo"); // Dejo nulo hasta que nos expliquen en clase
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				String url = rs.getString("url");
				Pokemon a = new Pokemon(numero, nombre, tipo, altura, peso, categoria, habilidad, url);
				pokemons.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemons;

	}
	
	/**
	 * Añade un nuevo pokemon a la base de datos
	 * @param pokemon Pokemon que queremos añadir
	 */

	public void registrar(Pokemon pokemon) {

		final String INSERT = "INSERT INTO pokemons (idpokemons, nombre, tipo, altura, peso, categoria, habilidad, url) "
				+ "VALUES ('" + pokemon.getNumero() + "','" + pokemon.getNombre() + "','" + pokemon.getTipo() + "','"
				+ pokemon.getAltura() + "','" + pokemon.getPeso() + "','" + pokemon.getCategoria() + "','" + pokemon.getHabilidad()
				+ "','" + pokemon.getUrl() + "');";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Elimina un pokemon de la base de datos
	 * @param pokemon Pokemon que queremos eliminar
	 */
	
	public void eliminar(Pokemon pokemon) {
		 final String DELETE = "DELETE FROM pokemons WHERE idpokemons = '" + pokemon.getNumero() + "';";

			 try {
					Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(DELETE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	/**
	 * Modifica un pokemon de la base de datos
	 * @param pokemon Pokemon que queremos modificar
	 */
	
	public void modificar(Pokemon pokemon) {
		final String UPDATE = "UPDATE pokemons SET idpokemons = '" + pokemon.getNumero() + "', nombre = '" + pokemon.getNombre() + 
				"', tipo = '" + pokemon.getTipo() + "', altura = '" + pokemon.getAltura() + "', peso = '" + pokemon.getPeso() + "', categoria = '" +
				pokemon.getCategoria() + "', habilidad = '" + pokemon.getHabilidad() + "', url = '" + pokemon.getUrl() + "' WHERE idpokemons = '" 
				+ pokemon.getNumero() + "' OR nombre = '" + pokemon.getNombre() + "';";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "El número de pokemon " + pokemon.getNumero()
			+ " o el nombre de " + pokemon.getNombre() + " ya está registrado en la pokedex");
		}
	}

}
