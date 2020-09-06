package dados;

import java.util.ArrayList;
import java.util.List;

public class Perfeitos extends Gerador {

	public Perfeitos() {
		super();
	}
	
	@Override
	public void gerar(int quantidade) {
	int aux=0, i=0;
		while(aux!=quantidade){
			int sum=0;
			i++;
			for (int j=1; j<i;j++) {
				if (i%j == 0) {
					sum += j;
				}
			}
			if (sum == i) {
				super.getSequencia().add(i);
				aux++;
			}
		}
	}
}
