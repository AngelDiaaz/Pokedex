package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;
import models.Usuario;

public class PokemonDAO {
	final String DB_URL = "jdbc:mysql://localhost/usuario_pokedex";
	final String USER = "usuarios";
	final String PASS = "usuario_pokemon";
	final String QUERY = "SELECT idpokemons, nombre, tipo, altura, peso, categoria, habilidad, url FROM pokemons";

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

//	public boolean login(String usuario, String password) {
//		final String QUERY = "SELECT usuario, password FROM usuarios " + 
//							"where usuario = '" + usuario + "' and " + 
//							"password = '" + password + "'";
//		try {
//			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(QUERY);
//			return rs.next();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
}
