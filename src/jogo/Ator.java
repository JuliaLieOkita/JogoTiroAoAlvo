package jogo;

import java.awt.Point;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite {
	
	double velocidade = 1;
	int direcao = 3;
	public int vida = 90;
	
	Controle controle =  new Controle();
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
	}
	
	public void caminho(Scene cena) {
		
		Point min = new Point((int) this.x, (int) this.y);
		Point max = new Point((int) this.x + this.width, (int) this.y + this.height);
		
		Vector<?> tiles = cena.getTilesFromPosition(min, max);
		
		for(int i = 0; i < tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			
			if(controle.colisao(this, tile)) {
				if(colisaoVertical(this, tile)) {
					if(tile.y + tile.height - 2 < this.y) {
						this.y = tile.y + tile.height;
					} else if(tile.y > this.y + this.height - 2) {
						this.y = tile.y - this.height;
					}
				}
				
				if(colisaoHorizontal(this, tile)) {
					if(tile.x > this.x + this.width - 2) {
						this.x = tile.x - this.width;
					} else {
						this.x = tile.x + tile.width;
					}
				}
				
			}
		}
	}
	
	private boolean colisaoVertical(GameObject personagem, GameObject tile) {
		if(tile.x + tile.width <= personagem.x) {
			return false;
		}
		if(personagem.x + personagem.width <= tile.x) {
			return false;
		}
		return true;
	}
	
	private boolean colisaoHorizontal(GameObject personagem, GameObject tile) {
		if(tile.y + tile.height <= personagem.y) {
			return false;
		}
		if(personagem.y + personagem.height <= tile.y) {
			return false;
		}
		return true;
	}

}