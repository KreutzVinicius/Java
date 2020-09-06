package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import dados.Contato;

public class ListaTelefonica {
	Map<Integer, List<Contato>> agenda = new HashMap<Integer,List<Contato>>();
	
	
	
public void criarLista () {
	ArrayList<Contato> contatos;
	for(int i=1; i <=26; i++) {
		contatos= new ArrayList<Contato>();
		agenda.put (i,contatos);
	}
}
	
public void adicionarContato(Contato contato, ArrayList<Character> letras) {
	
	char aux = contato.getNome().charAt(0);
	for (Character atual: letras) {
			if (aux == atual) {
				System.out.println(letras.indexOf(atual));
				int j = letras.indexOf(atual);
				agenda.get(j+1).add(contato);
		}
	}
}

public void removerContato (int j, int i) {
	agenda.get(j+1).remove(i);
	
}
public void buscarContato(int j){
	int index = 0;
	for(Contato contato : agenda.get(j+1)) {
		System.out.println(index + ": " + contato.toString());
		index++;
		
	}

}
public void buscarContatos(ArrayList<Character> letras){
	for (Integer key : agenda.keySet()) {
		System.out.println(letras.get(key-1) + ": " + agenda.get(key).toString());
	}
}

public Map<Integer, List<Contato>> getAgenda() {
	return agenda;
}

public void setAgenda(Map<Integer, List<Contato>> agenda) {
	this.agenda = agenda;
}

}
