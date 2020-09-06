package dados;

import java.util.ArrayList;
import java.util.List;

public class Abundantes extends Gerador {
	public Abundantes() {
		super();
	}
	
	@Override
	public void gerar(int quantidade) {
		int aux=0,i=0;
		while(aux != quantidade){
			i++;
			int sum=0;
			for (int j=1; j<i;j++) {
				if (i%j == 0) {
					sum += j;

				}
			}
			if (sum > i) {
				super.getSequencia().add(i);
			aux++;	
				}
			}
		}
	}
