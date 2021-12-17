package mainapp;

import enums.Tipo; 
import models.Pokemon;
import models.Usuario;
import ui.LoginView;
import utils.Almacen;

public class MainApp {

	public static void main(String[] args) {

		Almacen.pokemon.add(new Pokemon(172, "pichu" , Tipo.Electrico, 0.3, 2, "Ratoncito", "Electricidad Estatica"));
		Almacen.usuarios.add(new Usuario("pepe", "123456"));
		Almacen.usuarios.add(new Usuario("juan", "987654"));

		new LoginView();
	}

}
