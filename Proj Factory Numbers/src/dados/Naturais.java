package dados;

public class Naturais extends Gerador{

	public Naturais() {
		super();
	}
	
	@Override
	public void gerar(int quantidade) {
		int aux =0;
		while(aux != quantidade) {
			aux++;
			super.getSequencia().add(aux);
		}
	}
}
