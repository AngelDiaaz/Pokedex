package utils;

import java.util.ArrayList;

import models.Pokemon;
import models.Usuario;

public class Almacen {
	
	/**
	 * Array List para almacenar los pokemon que queremos que se guarden en la pokedex
	 */
	
	public static ArrayList<Pokemon> pokemon = new ArrayList <Pokemon>();
	
	/**
	 * Array List para almacenar el usuario y poder acceder a la pokedex
	 */
	
	public static ArrayList<Usuario> usuarios = new ArrayList <Usuario>();

}
