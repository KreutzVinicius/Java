package Negocios;

import java.util.ArrayList;
import java.util.Scanner;

import Dados.Consulta;
import Dados.Medico;
import Dados.Paciente;

public class Principal {
	static Scanner in = new Scanner(System.in);
	
	static Sistema sistema = new Sistema();
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	ArrayList<Medico> medicos = new ArrayList<Medico>();
	ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
	static int codigoP = 0;
	static int codigoM = 0;
	static int codigoC = 0;

	
 public static void main(String[] args) {
	 	int codigoP = 0;
		int codigoM = 0;
		int codigoC = 0;

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
	 System.out.println("Nome:");
	 paciente.setNome(in.nextLine());
	 
	 System.out.println("Idade:");
	 paciente.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("CPF:");
	 paciente.setCpf(in.nextLine());
	 System.out.println("Cidade:");
	 paciente.setCidade(in.nextLine());
	 
	 System.out.println("Descrição");
	 paciente.setDescricao(in.nextLine());
	 codigoP++;
	 paciente.setCodigoP(codigoP);
	 
	 sistema.cadastrarPaciente(paciente);
 }
 
 private static void adicionarM() {
	 Medico medico = new Medico();
	 System.out.println("Nome:");
	 medico.setNome(in.nextLine());
	 System.out.println("Idade:");
	 medico.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("CPF:");
	 medico.setCpf(in.nextLine());
	 System.out.println("Cidade:");
	 medico.setCidade(in.nextLine());
	 
	 System.out.println("Especialidade:");
	 medico.setEspecialidade(in.nextLine());
	 codigoM++;
	 medico.setCodigoM(codigoM);
	 
	 sistema.cadastrarMedico(medico);
 }
 
 private static void adicionarC() {
	 Consulta consulta = new Consulta();
	 System.out.println("Data:");
	 consulta.setData(in.nextLine());
	 System.out.println("Horario:");
	 consulta.setHorario(in.nextLine());
	 System.out.println("Valor:");
	 consulta.setValor(in.nextFloat());
	 in.nextLine();
	 System.out.println("Diagnostico:");
	 consulta.setDiagnostico(in.nextLine());
	 codigoC++;
	 consulta.setCodigoC(codigoC);
	 
	 System.out.println("escolha o medico para consulta pelo seu codigo");
	 listarM();
	 consulta.setCodigoM(in.nextInt());
	 
	 System.out.println("escolha o paciente para consulta pelo seu codigo");
	 listarP();
	 consulta.setCodigoP(in.nextInt());
	 
	 in.nextLine();
	 
	 sistema.agendarConsulta(consulta);
 }
 
 private static void  listarP() {
	ArrayList<Paciente> lista = new ArrayList<Paciente>();
	lista = sistema.buscarPacientes();
	for (Paciente a: lista) {
		System.out.println( a.getCodigoP()+"- " + a.getNome() + "\n| descrição:" + a.getDescricao());
	}
}

 private static void  listarM() {
	ArrayList<Medico> lista = new ArrayList<Medico>();
	lista = sistema.buscarMedicos();
	for (Medico a: lista) {
		System.out.println( a.getCodigoM()+ "- " + "Dr(a)." + a.getNome()+ "\n| especialidade:" + a.getEspecialidade());
	}
}

 private static void  listarC() {
	ArrayList<Consulta> lista = new ArrayList<Consulta>();
	lista = sistema.mostrarConsultas();
	for (Consulta a: lista) {
		System.out.println( a.getCodigoC()+ "- "+a.getData() + " " + a.getHorario() + "\n| codigo do medico:" + a.getCodigoM()+ "\n| codigo do paciente:" + a.getCodigoP());
	}
}

 private static void removerP() {
	ArrayList<Paciente> lista = new ArrayList<Paciente>();
	
	listarP();
	System.out.println("Cuidado! Remover um paciente do sistema nao excluirá suas consultas previamente marcadas");
	System.out.println("digite o codigo do paciente que deseja remover");
	int cod = in.nextInt();
	
	lista = sistema.buscarPacientes();
	for (Paciente a: lista) {
		if (a.getCodigoP() == cod ){
			sistema.removerPaciente(a);
			}		
		}
 	}

 private static void removerM() {
	ArrayList<Medico> lista = new ArrayList<Medico>();
	
	listarM();
	System.out.println("Cuidado! Remover um medico do sistema nao excluirá suas consultas previamente marcadas");
	System.out.println("digite o codigo do medico que deseja remover");
	int cod = in.nextInt();
	
	lista = sistema.buscarMedicos();
	for (Medico a: lista) {
		if (a.getCodigoM() == cod ){
			sistema.removerMedico(a);
			}		
		}
 	}

 private static void removerC() {
		ArrayList<Consulta> lista = new ArrayList<Consulta>();
		
		listarC();
		System.out.println("digite o codigo da consulta que deseja desmarcar");
		int cod = in.nextInt();
		
		lista = sistema.mostrarConsultas();
		for (Consulta a: lista) {
			if (a.getCodigoC() == cod ){
				sistema.removerConsulta(a);
			}		
		}
	}
 
 private static void alterarP() {
	 ArrayList<Paciente> lista = new ArrayList<Paciente>();
	 listarP();
	 
	 System.out.println("digite o codigo do paciente que deseja alterar");
	 int cod = in.nextInt();
		
		lista = sistema.buscarPacientes();
		for (Paciente a: lista) {
			if (a.getCodigoP() == cod ){
	 System.out.println("voce esta alterando os dados do paciente " + a.getNome());
	 System.out.println("Idade:");
	 a.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("Cidade:");
	 a.setCidade(in.nextLine());
	 
	 System.out.println("Digite uma breve descrição dos sintomas");
	 a.setDescricao(in.nextLine());
	 
	 
	 sistema.alterarPaciente(a, cod);
			}
		}
	}
 
 private static void alterarM() {
	 ArrayList<Medico> lista = new ArrayList<Medico>();
	 listarM();
	 
	 System.out.println("digite o codigo do medico que deseja alterar");
	 int cod = in.nextInt();
		
		lista = sistema.buscarMedicos();
		for (Medico a: lista) {
			if (a.getCodigoM() == cod ){


	 System.out.println("voce esta alterando os dados do paciente " + a.getNome());
	 System.out.println("Idade:");
	 a.setIdade(in.nextInt());
	 in.nextLine();
	 System.out.println("Cidade:");
	 a.setCidade(in.nextLine());
	 
	 System.out.println("Especialidade:");
	 a.setEspecialidade(in.nextLine());
	 
	 sistema.alterarMedico(a, cod);
			}
		}
	}
 
private static void alterarC() {
	 ArrayList<Consulta> lista = new ArrayList<Consulta>();
	 listarC();
	 
	 System.out.println("digite o codigo da consulta que deseja alterar");
	 int cod = in.nextInt();
		
		lista = sistema.mostrarConsultas();
		for (Consulta a: lista) {
			if (a.getCodigoC() == cod ){
	
	
	 System.out.println("Data:");
	 a.setData(in.nextLine());
	 System.out.println("Horario:");
	 a.setHorario(in.nextLine());
	 System.out.println("Valor:");
	 a.setValor(in.nextFloat());
	 in.nextLine();
	 System.out.println("Diagnostico:");
	 a.setDiagnostico(in.nextLine());
	 codigoC++;
	 a.setCodigoC(codigoC);
	 
	 System.out.println("escolha o medico para consulta pelo seu codigo");
	 listarM();
	 a.setCodigoM(in.nextInt());
	 
	 System.out.println("escolha o paciente para consulta pelo seu codigo");
	 listarP();
	 a.setCodigoP(in.nextInt());
	 
	 in.nextLine();
	 
	 sistema.alterarConsulta(a, cod);
			}
		}
	}
 
}
 
