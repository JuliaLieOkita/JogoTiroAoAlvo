package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Main {
	
	public static void main(String[] args) {
		
		Window janela = new Window(800, 600);
		GameImage menu = new GameImage("src/recursos/sprites/menu.png");
		Keyboard teclado = janela.getKeyboard();
		
		while(true) {
			menu.draw();
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				new Cenario1(janela);
			}
		}
		
	}

}