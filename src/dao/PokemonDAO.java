package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Pokemon;

public class PokemonDAO extends AbstractDAO{
	
	private TipoDAO tipoDAO;
	
	public PokemonDAO() {
		super();
		this.tipoDAO = new TipoDAO();
	}


	/**
	 * Método que guarda todos los pokemons de la base de datos en un array list, para luego poder verla en la pokedex
	 * @return ArrayList con todos los pokemons de la base de datos
	 */
	
	public ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT idpokemons, nombre, altura, peso, categoria, habilidad, url, idTipo1, idTipo2 "
				+ "FROM pokemons";
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int numero = rs.getInt("idpokemons");
				String nombre = rs.getString("nombre");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				String url = rs.getString("url");
				
				Pokemon a = new Pokemon(numero, nombre, altura, peso, categoria, habilidad, url);
				a.setTipo1(tipoDAO.get(rs.getInt("idTipo1")));
				a.setTipo2(tipoDAO.get(rs.getInt("idTipo2")));
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

		final String INSERT = "INSERT INTO pokemons (idpokemons, nombre, altura, peso, categoria, habilidad, url, idTipo1, idTipo2) "
				+ "VALUES ('" + pokemon.getNumero() + "','" + pokemon.getNombre() + "','"
				+ pokemon.getAltura() + "','" + pokemon.getPeso() + "','" + pokemon.getCategoria() + "','" + pokemon.getHabilidad()
				+ "','" + pokemon.getUrl() + "', '" + pokemon.getTipo1().getId() + "', '" + pokemon.getTipo2().getId() + "');";
		try {
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
				"', idTipo1 = '" + pokemon.getTipo1().getId() + "', idTipo2 = '" + pokemon.getTipo2().getId() + "', altura = '" + 
				pokemon.getAltura() + "', peso = '" + pokemon.getPeso() + "', categoria = '" +
				pokemon.getCategoria() + "', habilidad = '" + pokemon.getHabilidad() + "', url = '" + pokemon.getUrl() + "' WHERE idpokemons = '" 
				+ pokemon.getNumero() + "' OR nombre = '" + pokemon.getNombre() + "';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "El número de pokemon " + pokemon.getNumero()
			+ " o el nombre de " + pokemon.getNombre() + " ya está registrado en la pokedex");
		}
	}

}
