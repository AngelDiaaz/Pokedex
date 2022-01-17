package dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsuarioDAO {

	final String DB_URL = "jdbc:mysql://localhost/usuario_pokedex";
	final String USER = "usuarios";
	final String PASS = "usuario_pokemon";
	final String QUERY = "SELECT usuario, password FROM usuarios";

	public void consulta() {
		final String QUERY = "SELECT usuario, password FROM usuarios";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				System.out.print("Usuario: " + rs.getString("usuario"));
				System.out.println(", Password: " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean login(Usuario usuario) {
		final String QUERY = "SELECT usuario, password FROM usuarios " + "where usuario = '" + usuario.getUsuario() + "' and "
				+ "password = '" + usuario.getPassword() + "'";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysq l.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
	
  
     
   

	public void registrar(Usuario usuario) {
		
		final String INSERT = "INSERT INTO usuarios (usuario,password)"
				+ " VALUES ('"+ usuario.getUsuario() + "','"+ usuario.getPassword() +"');";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
