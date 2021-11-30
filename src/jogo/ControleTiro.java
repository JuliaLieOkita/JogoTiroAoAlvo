package jogo;

import java.util.LinkedList;
import jplay.Scene;

public class ControleTiro {
	
	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void addTiro(double x, double y, int caminho, Scene cena) {
		Tiro tiro = new Tiro(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
	}
	
	public void run(Ator alvo) {
		for(int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			
			if(tiro.collided(alvo)) {
				tiro.x = 10000;
				alvo.vida -= 30;
			}
		}
	}

}