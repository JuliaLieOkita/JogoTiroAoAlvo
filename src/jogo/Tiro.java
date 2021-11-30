package jogo;

import jplay.Sprite;

public class Tiro extends Sprite {

	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
	
	static final int VELOCIDADE_TIRO = 2;
	int caminho = STOP;
	int direcao = 3;
	
	public Tiro(double x, double y, int caminho) {
		super("src/recursos/sprites/arrow.png", 12);
		this.caminho = caminho;
		this.x = x;
		this.y = y;
	}

	public void mover() {
		if(caminho == LEFT) {
			this.x -= VELOCIDADE_TIRO;
			if(direcao != 1) {
				setSequence(4, 6);
			}
		}
		if(caminho == RIGHT) {
			this.x += VELOCIDADE_TIRO;
			if(direcao != 2) {
				setSequence(7, 9);
			}
		}
		if(caminho == UP) {
			this.y -= VELOCIDADE_TIRO;
			if(direcao != 4) {
				setSequence(1, 3);
			}
		}
		if(caminho == DOWN || caminho == STOP) {
			this.y += VELOCIDADE_TIRO;
			if(direcao != 5) {
				setSequence(10, 12);
			}
		}
	}
	
}