package jogo;

public class Alvo extends Ator {

	public Alvo(int x, int y) {
		super("src/recursos/sprites/alvo.png", 6);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}

	public void destruir() {
		if(this.vida == 60) {
			setSequence(1, 2);
		} else if(this.vida == 30) {
			setSequence(2, 3);
		} else if(this.vida == 0) {
			setSequence(4, 6);
		}
	}
	
}