package dao;

import java.sql.Connection;
import java.sql.Statement;

public  abstract class AbstractDAO {
	
	protected final String DB_URL = "jdbc:mysql://localhost/usuario_pokedex";
	protected final String USER = "usuarios";
	protected final String PASS = "usuario_pokemon";
	
	protected Connection conn;
	protected Statement stmt;
	
//	public AbstractDAO() {
//		try {
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}
//	}
}
