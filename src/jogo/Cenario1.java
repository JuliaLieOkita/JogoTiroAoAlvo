package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Cenario1 {
	
	private Window janela;
	private Scene cena = new Scene();
	private Jogador jogador;
	private Keyboard teclado;
	private Alvo alvo, alvo2, alvo3;
	
	public Cenario1(Window window) {
		janela = window;
		
		cena.loadFromFile("src/recursos/scn/Cenario1.scn");
		
		jogador = new Jogador(350, 400);
		
		teclado = janela.getKeyboard();
		
		alvo = new Alvo(100, 350);
		alvo2 = new Alvo(400, 350);
		alvo3 = new Alvo(550, 500);
		
		run();
	}
	
	private void run() {
		
		while(true) {
			
			cena.moveScene(jogador);
			
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			
			jogador.draw();
			alvo.draw();
			alvo2.draw();
			alvo3.draw();
			
			jogador.disparar(janela, cena, teclado, alvo);
			jogador.disparar(janela, cena, teclado, alvo2);
			jogador.disparar(janela, cena, teclado, alvo3);
			alvo.destruir();
			alvo2.destruir();
			alvo3.destruir();
			
			janela.update();
			janela.delay(1);
			
		}
		
	}

}