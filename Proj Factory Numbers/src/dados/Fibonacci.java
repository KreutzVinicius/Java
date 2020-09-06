package dados;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends Gerador{

	public Fibonacci() {
		super();
	}
	
	@Override
	public void gerar(int quantidade){
		int a = 0, b=1,c;
		super.getSequencia().add(b);
		int aux=1;
		while(aux != quantidade) {
			 c = a + b ;
			 super.getSequencia().add(c);
			aux++;
			a=b;
			b=c;
			
		}
	}
	
}
