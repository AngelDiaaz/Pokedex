package mainapp;

import enums.Tipo;
import models.Pokemon;
import models.Usuario;
import ui.LoginView;
import ui.PokedexView;
import utils.Almacen;

public class MainApp {

	public static void main(String[] args) {

		Almacen.pokemon.add(new Pokemon(172, "Pichu", Tipo.Electrico, 0.3, 2, "Ratoncito", "Electricidad Estatica",
				"https://assets.pokemon.com/assets/cms2/img/pokedex/full/172.png"));
		Almacen.pokemon.add(new Pokemon(4, "Charmander", Tipo.Fuego, 0.6, 8.5, "Lagartija", "Mar Llamas",
				"https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png"));
		Almacen.pokemon.add(new Pokemon(136, "Flareon", Tipo.Fuego, 0.9, 25, "Llama", "Absorbe Fuego",
				"https://assets.pokemon.com/assets/cms2/img/pokedex/full/136.png"));

		Almacen.usuarios.add(new Usuario("pepe", "1"));
		Almacen.usuarios.add(new Usuario("juan", "9"));

		new PokedexView(null);
	}

}
