package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Tipos;

public class TipoDAO extends AbstractDAO {
	
	/**
	 * Método que guarda todos los tipos de los pokemons de la base de datos en un array list, para luego poder verla en la pokedex
	 * @return ArrayList con todos los tipos de la base de datos
	 */
	
	public ArrayList<Tipos> getAll() {
		final String QUERY = "SELECT id, nombre FROM tipos";
		ArrayList<Tipos> tipos = new ArrayList<Tipos>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				tipos.add(new Tipos(id, nombre));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipos;
	}
	
}
