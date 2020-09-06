package apresentacao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dados.Contato;
import negocio.ListaTelefonica;


public class Main {
	
	static Scanner in = new Scanner(System.in);
	static ArrayList<Character> letras = new ArrayList<Character>(Arrays.asList('A','B','C','D','E',
			'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
				
	
public static void main(String[] args) {
	ListaTelefonica lista = new ListaTelefonica();
	lista.criarLista();
	int op = -1;
	while (op != 0) {
	 System.out.println("escolha uma opcao");
	 System.out.println("0- sair");
	 System.out.println("1- criar contato ");
	 System.out.println("2- remover contato ");
	 System.out.println("3- exibir contatos");

	 
	 op = in.nextInt();
	 in.nextLine();
	 
	 switch (op) {
	 case 0:
		 break;
		 
	 case 1:
		novoContato(lista);
		 break;
	 case 2:
		removerContato(lista);
		 break;
	 case 3:
		exibirContato(lista);
		 break;
	 	}
	}
}
public static void novoContato(ListaTelefonica lista){
	Contato contato = new Contato();
	System.out.println("Nome: ");
	contato.setNome(in.nextLine());
	contato.setNome(contato.getNome().substring(0,1).toUpperCase() + contato.getNome().substring(1).toLowerCase());
	System.out.println("Numero: ");
	contato.setTelefone(in.nextInt());
	in.nextLine();
	lista.adicionarContato(contato, letras);
}

public static void removerContato(ListaTelefonica lista) {
	
	System.out.println("digite a inicial do contato que deseja remover");
	char letra = in.next().charAt(0);
	for (Character atual: letras) {
		if (Character.valueOf(letra).compareTo(Character.valueOf(atual)) == 0) {
			int j = letras.indexOf(atual);
			if(lista.getAgenda().get(j+1).isEmpty()) {
				System.out.println("lista vazia");
			}
			else {
				lista.buscarContato(j);
				System.out.println("Digite o index do contato que deseja remover");
				int i = in.nextInt();
				lista.removerContato(j,i);
			}
	}
}

	
}
public static void exibirContato(ListaTelefonica lista) {
	lista.buscarContatos(letras);
}

}

