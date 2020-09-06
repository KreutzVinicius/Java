package dados;

import java.util.ArrayList;
import java.util.List;

public abstract class Gerador {
	
	private List<Integer> sequencia=new ArrayList<Integer>();
	
	public abstract void gerar(int quantidade);
	
	public List<Integer> getSequencia() {
		return sequencia;
	}
	
	@Override
	public String toString() {
		return "" + sequencia;
	}

}
