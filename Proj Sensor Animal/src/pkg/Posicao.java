package pkg;

import java.util.Random;

public class Posicao {
	private int x, y;
	Random rd = new Random();
	
	
	public Posicao(){
		this.x = rd.nextInt(49);
		this.y = rd.nextInt(49);
	}
	
	public Posicao(int x, int y){
		this.x = x;
		this.y = y;
	} 
	@Override
	public String toString() {
		return "posicao (" + x + "," + y + ")";
	}
		
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
