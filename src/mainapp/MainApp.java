package mainapp;

import enums.Tipo;
import models.Pokemon;
import ui.LoginView;
import utils.Almacen;

public class MainApp {

	public static void main(String[] args) {
		
		//Añadimos tres pokemon al array list de pokemon
		Almacen.pokemon.add(new Pokemon(172, "Pichu", Tipo.Electrico, 0.3, 2, "Ratoncito", "Electricidad Estatica",
				"https://assets.pokemon.com/assets/cms2/img/pokedex/full/172.png"));
		Almacen.pokemon.add(new Pokemon(4, "Charmander", Tipo.Fuego, 0.6, 8.5, "Lagartija", "Mar Llamas",
				"https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png"));
		Almacen.pokemon.add(new Pokemon(136, "Flareon", Tipo.Fuego, 0.9, 25, "Llama", "Absorbe Fuego",
				"https://assets.pokemon.com/assets/cms2/img/pokedex/full/136.png"));

		new LoginView(); //Llamamo a la funcion login view para que se nos abra el programa
	}

}
