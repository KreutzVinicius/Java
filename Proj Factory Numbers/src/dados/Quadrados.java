package dados;

import java.util.ArrayList;
import java.util.List;

public class Quadrados extends Gerador{
	public Quadrados() {
		super();
	}
	
	@Override
	public void gerar(int quantidade) {
		int  i=1,aux=0;
		while (aux != quantidade){
			if(Math.sqrt(i)-Math.floor(Math.sqrt(i))==0) {
				super.getSequencia().add(i);
				aux++;
				
			}
			i++;
		}
	}
	
}
