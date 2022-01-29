package dao;

import java.sql.ResultSet; 
import java.sql.SQLException;
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
	
	/**
	 * Busca el tipo por su ID y si no lo encuentra devuelve NULL.
	 * @param idTipo id del tipo que queremos buscar
	 * @return
	 */

	public Tipos get(int idTipo) {
		final String QUERY = "SELECT id, nombre "
				+ "FROM tipos where id = " + idTipo;
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("id");
				var nombre = rs.getString("nombre");
				Tipos t = new Tipos(id, nombre);
				return t;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
