package apresentacao;

import java.util.Scanner;

import dados.Endereco;
import dados.Pessoa;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class Main {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Scanner in = new Scanner(System.in);
		int aux;
		
		int op = 1;
		
		while (op!= 0) {
		System.out.println("1- cadastrar pessoa\n2- remover pessoa\n3- atualizar pessoa\n4- mostrar todos\n0- sair ");
		op = in.nextInt();
		in.nextLine();
		
		switch (op) {
			case 1: 
				Pessoa pessoa = new Pessoa();
				Endereco endereco = new Endereco();
				System.out.println("nome");
				pessoa.setNome(in.nextLine());
				System.out.println("cpf");
				pessoa.setCpf(in.nextLine());
				System.out.println("telefone");
				pessoa.setTelefone(in.nextInt());
				in.nextLine();
				
				System.out.println("rua");
				endereco.setRua(in.nextLine());
				System.out.println("numero");
				endereco.setNumero(in.nextInt());
				in.nextLine();
				System.out.println("cidade");
				endereco.setCidade(in.nextLine());
				
				pessoa.setEndereco(endereco);
				try {
					sistema.inserirPessoa(pessoa);
				} catch (InsertException e) {
					e.printStackTrace();
				} catch (SelectException e) {
					e.printStackTrace();
				}
				break;
				
			case 2:
				try {
					for (Pessoa p : sistema.selectAll()) {
						System.out.println(p.toString());
					}
				} catch (SelectException e){
					e.printStackTrace();
				}
				System.out.println("digite o id de quem deseja remover");
				aux = in.nextInt();
				in.nextLine();
				
				try {
					for (Pessoa p : sistema.selectAll()) {
						if (p.getId() == aux )
							sistema.deletarPessoa(p);
					}
				} catch (SelectException | DeleteException e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					for (Pessoa p : sistema.selectAll()) {
						System.out.println(p.toString());
					}
				} catch (SelectException e){
					e.printStackTrace();
				}
				System.out.println("digite o id de quem deseja alterar");
				aux = in.nextInt();
				in.nextLine();
				
				try {
					for (Pessoa p : sistema.selectAll()) {
						if (p.getId() == aux ) {
							System.out.println("nome");
							p.setNome(in.nextLine());
							System.out.println("telefone");
							p.setTelefone(in.nextInt());
							in.nextLine();
							System.out.println("rua");
							p.getEndereco().setRua(in.nextLine());
							System.out.println("numero");
							p.getEndereco().setNumero(in.nextInt());
							in.nextLine();
							System.out.println("cidade");
							p.getEndereco().setCidade(in.nextLine());
							try {
								sistema.atualizarPessoa(p);
							} catch (UpdateException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (SelectException e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					for (Pessoa p : sistema.selectAll()) {
						System.out.println(p.toString());
					}
				} catch (SelectException e) {
					e.printStackTrace();
				}
				break;
				
			}
		}
		in.close();
	}
}

