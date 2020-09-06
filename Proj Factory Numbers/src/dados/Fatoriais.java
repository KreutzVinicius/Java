package dados;

import java.util.ArrayList;
import java.util.List;

public class Fatoriais extends Gerador{

	public Fatoriais() {
		super();
	}
	
	@Override
	public void gerar(int quantidade) {
		int i=0,sum=1, aux=0;
		while (aux != quantidade) {
			i++;
			sum *= i;
			 super.getSequencia().add(sum);
			 aux++;
			}
		}
	}
