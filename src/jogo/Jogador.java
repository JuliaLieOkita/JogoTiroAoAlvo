package jogo;

import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Jogador extends Ator {
	
	public Jogador(int x, int y) {
		
		super("src/recursos/sprites/archer.png", 16);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		
	}
	
	public void controle(Window janela, Keyboard teclado) {
		
		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			if(this.x > 0)
				this.x -= velocidade;
			if(direcao != 1) {
				setSequence(5, 8);
				direcao = 1;
			}
			
		} else if(teclado.keyDown(Keyboard.RIGHT_KEY)) {
			if(this.x < janela.getWidth() - 64)
				this.x += velocidade;
			if(direcao != 2) {
				setSequence(9, 12);
				direcao = 2;
			}
			
		} else if(teclado.keyDown(Keyboard.UP_KEY)) {
			
			if(this.y > 0)
				this.y -= velocidade;
			if(direcao != 4) {
				setSequence(13, 16);
				direcao = 4;
			}
			
		} else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
			
			if(this.y < janela.getHeight() - 64)
				this.y += velocidade;
			if(direcao != 5) {
				setSequence(1, 4);
				direcao = 5;
			}
			
		}
		
	}
	
	ControleTiro tiro = new ControleTiro();
	public void disparar(Window janela, Scene cena, Keyboard teclado, Ator alvo) {
		if(teclado.keyDown(KeyEvent.VK_SPACE)) {
			tiro.addTiro(x + 8, y + 18, direcao, cena);
		}
		tiro.run(alvo);
	}

}