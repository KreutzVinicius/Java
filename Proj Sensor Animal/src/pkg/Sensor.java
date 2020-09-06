package pkg;

public class Sensor implements Observador {
	private Posicao posicaoSensor;
	private Posicao posicaoAnimal;
	
	public double calcularDistancia() {
		
		return Math.sqrt(Math.pow(posicaoAnimal.getX() - posicaoSensor.getX(),2) + Math.pow(posicaoAnimal.getY() - posicaoSensor.getY(),2));
	}

	@Override
	public void atualizar(Object objeto) {
		posicaoAnimal = (Posicao) objeto;
	}

	public Posicao getPosicaoSensor() {
		return posicaoSensor;
	}

	public void setPosicaoSensor(Posicao posicaoSensor) {
		this.posicaoSensor = posicaoSensor;
	}

	public Posicao getPosicaoAnimal() {
		return posicaoAnimal;
	}

	public void setPosicaoAnimal(Posicao posicaoAnimal) {
		this.posicaoAnimal = posicaoAnimal;
	}
	
}
