package Apresentacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Dados.Consulta;
import Dados.Medico;
import Dados.Paciente;
import Dados.Pessoa;
import Negocios.Sistema;

public class Principal {
	static Scanner in = new Scanner(System.in);
	
	static Sistema sistema = new Sistema();

 public static void main(String[] args) {
	menu();
}
 
 private static void menu() { // menu principal
		int opcao = 1;

		while (opcao != 0){
			
			System.out.print("\n");
			System.out.println("1- Cadastrar paciente");
			System.out.println("2- Cadastrar medico");
			System.out.println("3- Agendar consulta");
			System.out.println("4- Buscar paciente");
			System.out.println("5- Buscar medico");
			System.out.println("6- Mostrar consultas");
			System.out.println("7- Remover paciente");
			System.out.println("8- Remover medico");
			System.out.println("9- Cancelar consulta");
			System.out.println("10- Alterar cadastro paciente");
			System.out.println("11- Alterar cadastro medico");
			System.out.println("12- Alterar consulta");
			System.out.println("\n");
			
			opcao = in.nextInt();
			in.nextLine();
			
			switch (opcao) {
			case 1:
				adicionarP();
				break;
			case 2:
				adicionarM();
				break;
			case 3:
				adicionarC();
				break;
			case 4:
				listarP();
				break;
			case 5:
				listarM();
				break;
			case 6:
				listarC();
				break;
			case 7:
				removerP();
				break;
			case 8:
				removerM();
				break;
			case 9:
				removerC();
				break;
			case 10:
				alterarP();
				break;
			case 11:
				alterarM();
				break;
			case 12:
				alterarC();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Invalida!");
				break;
			}
		} while (opcao != 0);
	} 
 
 private static void adicionarP() {

	 Paciente paciente = new Paciente();
	 Pessoa pessoa = new Pessoa();
	 
	 System.out.println("Nome:");
	 pessoa.setNome(in.nextLine());
	 System.out.println("Idade:");
	 pessoa.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("CPF:");
	 pessoa.setCpf(in.nextLine());
	 System.out.println("Cidade:");
	 pessoa.setCidade(in.nextLine());
	 
	 System.out.println("Descrição");
	 paciente.setDescricao(in.nextLine());
	 
	 sistema.cadastrarPessoa(pessoa);
	 paciente.setIdPes(sistema.buscarPessoa(pessoa.getCpf()).getId());
	 sistema.cadastrarPaciente(paciente);
 }
 
 private static void adicionarM() {
	 
	 Medico medico = new Medico();
	 Pessoa pessoa = new Pessoa();
	 
	 System.out.println("Nome:");
	 pessoa.setNome(in.nextLine());
	 System.out.println("Idade:");
	 pessoa.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("CPF:");
	 pessoa.setCpf(in.nextLine());
	 System.out.println("Cidade:");
	 pessoa.setCidade(in.nextLine());
	 
	 System.out.println("Especialidade:");
	 medico.setEspecialidade(in.nextLine());
	 
	 sistema.cadastrarPessoa(pessoa);
	 medico.setIdPes(sistema.buscarPessoa(pessoa.getCpf()).getId());
	 sistema.cadastrarMedico(medico);
 }
 
 private static void adicionarC() {
	Consulta consulta = new Consulta();
	String data = new String();
	 
	 
	System.out.println("Horario: formato dd/mm/yyyy hh:mm");
	
	data = in.nextLine();
	SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Date dataFormatada;
	try {
		dataFormatada = dtf.parse(data);
		 consulta.getHorario().setTime(dataFormatada);
	} catch (ParseException e) {
		System.out.println("erro de formatação da data");
		return;
	}

	 System.out.println("Valor:");
	 consulta.setValor(in.nextFloat());
	 in.nextLine();
	 System.out.println("Diagnostico:");
	 consulta.setDiagnostico(in.nextLine());
 
	 System.out.println("escolha o medico para consulta pelo seu codigo");
	 listarM();
	 consulta.setMedico(sistema.buscarMedico(in.nextInt()));
	 in.nextLine();
	 
	 System.out.println("escolha o paciente para consulta pelo seu codigo");
	 listarP();
	 consulta.setPaciente(sistema.buscarPaciente(in.nextInt()));
	 in.nextLine();
	 
	 sistema.realizarConsulta(consulta);
 }
 
 private static void  listarP() {
	ArrayList<Paciente> lista = new ArrayList<Paciente>();
	lista = sistema.buscarPacientes();
	for (Paciente a: lista) {
		System.out.println(a.toString());
	}
}

 private static void  listarM() {
	ArrayList<Medico> lista = new ArrayList<Medico>();
	lista = sistema.buscarMedicos();
	for (Medico a: lista) {
		System.out.println( a.toString());
	}
}

 private static void  listarC() {
	ArrayList<Consulta> lista = new ArrayList<Consulta>();
	lista = sistema.mostrarConsultas();
	for (Consulta a: lista) {
		System.out.println( a.toString());
	}
}

 private static void removerP() {	
	listarP();
	System.out.println("digite o codigo do paciente que deseja remover");
	Paciente paciente = sistema.buscarPaciente(in.nextInt());
	in.nextLine();

	sistema.removerPaciente(paciente.getId());
	sistema.removerPessoa(paciente.getIdPes());
}		

 private static void removerM() {
	listarM();
	System.out.println("digite o codigo do medico que deseja remover");
	int cod = in.nextInt();
	in.nextLine();

	sistema.removerMedico(cod);
		
 	}

 private static void removerC() {	
		listarC();
		System.out.println("digite o codigo da consulta que deseja desmarcar");
		int cod = in.nextInt();
		in.nextLine();

		sistema.removerConsulta(cod);
	}
 
 private static void alterarP() {
	 listarP();
	 
	 System.out.println("digite o codigo do paciente que deseja alterar");
	 Paciente paciente = sistema.buscarPaciente(in.nextInt());
	
	 System.out.println("voce esta alterando os dados do paciente " + paciente.getNome());
	 System.out.println("Idade:");
	 paciente.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("Cidade:");
	 paciente.setCidade(in.nextLine());
	 
	 System.out.println("Descrição: ");
	 paciente.setDescricao(in.nextLine());
	 
	 sistema.alterarPessoa(paciente);
	 sistema.alterarPaciente(paciente);
}
 
 private static void alterarM() {
	 listarM();
	 
	 System.out.println("digite o codigo do medico que deseja alterar");
	 Medico medico = sistema.buscarMedico(in.nextInt());

	 System.out.println("voce esta alterando os dados do paciente " + medico.getNome());
	 System.out.println("Idade:");
	 medico.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("Cidade:");
	 medico.setCidade(in.nextLine());
	 
	 System.out.println("Especialidade:");
	 medico.setEspecialidade(in.nextLine());

	 sistema.alterarPessoa(medico);
	 sistema.alterarMedico(medico);	
}
	
 
private static void alterarC() {
	listarC();
	System.out.println("digite o codigo da consulta que deseja alterar");
	Consulta consulta = sistema.buscarConsulta(in.nextInt());
	in.nextLine();
	String data = new String();
	 
	 
	System.out.println("Horario: formato dd/mm/yyyy hh:mm");
	
	data = in.nextLine();
	SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Date dataFormatada;
	try {
		dataFormatada = dtf.parse(data);
		 consulta.getHorario().setTime(dataFormatada);
	} catch (ParseException e) {
		System.out.println("erro de formatação da data");
		return;
	}
	 
	 
	 System.out.println("Valor:");
	 consulta.setValor(in.nextFloat());
	 in.nextLine();
	 System.out.println("Diagnostico:");
	 consulta.setDiagnostico(in.nextLine());
	 
	 System.out.println("escolha o medico para consulta pelo seu codigo");
	 listarM();
	 consulta.setMedico(sistema.buscarMedico(in.nextInt()));
	 in.nextLine();
	 System.out.println("escolha o paciente para consulta pelo seu codigo");
	 listarP();
	 consulta.setPaciente(sistema.buscarPaciente(in.nextInt()));
	 
	 in.nextLine();
	 
	 sistema.alterarConsulta(consulta);

}
 
}
 
