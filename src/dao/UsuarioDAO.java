package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.Usuario;

public class UsuarioDAO {

	final String DB_URL = "jdbc:mysql://localhost/usuario_pokedex";
	final String USER = "usuarios";
	final String PASS = "usuario_pokemon";
	final String QUERY = "SELECT usuario, password FROM usuarios";
	private Usuario usuario;
	private Connection con;

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

	public boolean login(String usuario, String password) {
		final String QUERY = "SELECT usuario, password FROM usuarios " + "where usuario = '" + usuario + "' and "
				+ "password = '" + password + "'";
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
	
  
     
   

	public void registrar(String usuario, String password) {
		
		 PreparedStatement ps;
	        String sql;
	        this.usuario.setUsuario(usuario);
	        this.usuario.setPassword(password);
	        try{
	            con = getConexion();
	            sql = "insert into usuarios(usuario, password) values('" + usuario + "', '" + password + "')";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, this.usuario.getUsuario());
	            ps.setString(2, this.usuario.getPassword());
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
	}

}
