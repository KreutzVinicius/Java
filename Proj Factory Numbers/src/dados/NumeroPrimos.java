package dados;

import java.util.ArrayList;
import java.util.List;

public class NumeroPrimos extends Gerador {

	public NumeroPrimos() {
		super();
	}
	
	@Override
	public void gerar(int quantidade) {
		int i=2, aux = 0;
		while(aux != quantidade){
			
			int div=0;
			
				for (int j = 2;j<= Math.sqrt(i);j++)
				if (i%j==0) {
					div++;
				}
				if (div == 0) {
					super.getSequencia().add(i);
					aux++;
					
				}
				i++;	
			}
		}
	}

