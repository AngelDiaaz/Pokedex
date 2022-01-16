package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PokemonDAO {
	final String DB_URL = "jdbc:mysql://localhost/usuario_pokedex";
	final String USER = "usuarios";
	final String PASS = "usuario_pokemon";
	final String QUERY = "SELECT idpokemons, nombre, tipo, altura, peso, categoria, habilidad, url FROM pokemons";

	public void infoPokemon() {
		final String QUERY = "SELECT idpokemons, nombre, tipo, altura, peso, categoria, habilidad, url FROM pokemons";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				System.out.print("Nombre: " + rs.getString("nombre"));
				System.out.println(", idpokemons: " + rs.getString("idpokemons"));
			}
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
