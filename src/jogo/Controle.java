package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {
	
	public boolean colisao(GameObject personagem, TileInfo tile) {
		if((tile.id > 5) && personagem.collided(tile)) {
			return true;
		}
		return false;
	}

}