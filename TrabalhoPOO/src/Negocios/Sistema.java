package Negocios;

import java.util.ArrayList;

import Dados.Consulta;
import Dados.Medico;
import Dados.Paciente;
import Dados.Pessoa;
import Persistencia.ConsultaDAO;
import Persistencia.MedicoDAO;
import Persistencia.PacienteDAO;
import Persistencia.PessoaDAO;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class Sistema {
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private ArrayList<Medico> medicos = new ArrayList<Medico>();
	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	private PacienteDAO pacienteDAO;
	private MedicoDAO medicoDAO;
	private ConsultaDAO consultaDAO;
	private PessoaDAO pessoaDAO;

public void cadastrarPessoa (Pessoa pessoa) {
		pessoaDAO = PessoaDAO.getInstance();
		
		try {
			pessoaDAO.insert(pessoa);
		}catch (InsertException e) {
			System.out.println(e.getMessage());
		}
	}
	
public void cadastrarPaciente (Paciente paciente) {
	pacienteDAO = PacienteDAO.getInstance();
	
		try {
			pacienteDAO.insert(paciente);
		}catch (InsertException e) {
			System.out.println(e.getMessage());
		}
}

public void cadastrarMedico (Medico medico) {
	medicoDAO = MedicoDAO.getInstance();
		
		try {
			medicoDAO.insert(medico);
		}catch (InsertException e) {
			System.out.println(e.getMessage());
		}
	}

public void realizarConsulta (Consulta consulta) {
	consultaDAO = ConsultaDAO.getInstance();
	
	try {
		consultaDAO.insert(consulta);
	}catch (InsertException e) {
		System.out.println(e.getMessage());
	}
}

public void removerPessoa (int id) {
	pessoaDAO = PessoaDAO.getInstance();
		
		try {
			pessoaDAO.delete(id);
		}catch (DeleteException e) {
			System.out.println(e.getMessage());
		}
}

public void removerPaciente (int id) {
	pacienteDAO = PacienteDAO.getInstance();
	
	
		try {
			pacienteDAO.delete(id);
		}catch (DeleteException e) {
			System.out.println(e.getMessage());
		}
}

public void removerMedico (int id) {
	medicoDAO = MedicoDAO.getInstance();
	
	try {
		medicoDAO.delete(id);
	}catch (DeleteException e) {
		System.out.println(e.getMessage());
	}
}

public void removerConsulta (int id) {
	consultaDAO = ConsultaDAO.getInstance();
	
	try {
		consultaDAO.delete(id);
	}catch (DeleteException e) {
		System.out.println(e.getMessage());
	}
}

public Pessoa buscarPessoa (String cpf) {
	Pessoa pessoa = new Paciente();
	pessoaDAO = PessoaDAO.getInstance();
	
	try {
		pessoa = pessoaDAO.selectCpf(cpf);
	}catch (SelectException e){
		System.out.println(e.getMessage());
	}

	return pessoa;
}

public Paciente buscarPaciente (int id) {
	Paciente paciente = new Paciente();
	pacienteDAO = PacienteDAO.getInstance();
	
	try {
		paciente = pacienteDAO.selectPac(id);
	}catch (SelectException e){
		System.out.println(e.getMessage());
	}

	return paciente;
}

public Medico buscarMedico (int id) {
	Medico medico = new Medico();
	medicoDAO = MedicoDAO.getInstance();
	
	try {
		medico = medicoDAO.selectMed(id);
	}catch (SelectException e){
		System.out.println(e.getMessage());
	}

	return medico;
}

public Consulta buscarConsulta (int id) {
	Consulta consulta = new Consulta();
	consultaDAO = ConsultaDAO.getInstance();
	
	try {
		consulta = consultaDAO.selectCon(id);
	}catch (SelectException e){
		System.out.println(e.getMessage());
	}

	return consulta;
}

public ArrayList<Paciente> buscarPacientes(){
	pacienteDAO = PacienteDAO.getInstance();
		
		try {
			pacientes = pacienteDAO.selectAllPac();
			
		}catch (SelectException e) {
			System.out.println(e.getMessage());
		}
		
		return pacientes;
} 

public ArrayList<Medico> buscarMedicos(){
	medicoDAO = MedicoDAO.getInstance();
	
	try {
		medicos = medicoDAO.selectAllMed();
		
	}catch (SelectException e) {
		System.out.println(e.getMessage());
	}
	
	return medicos;
}

public ArrayList<Consulta> mostrarConsultas(){
	consultaDAO = ConsultaDAO.getInstance();
		
		try {
			consultas = consultaDAO.selectAllCon();
			
		}catch (SelectException e) {
			System.out.println(e.getMessage());
		}
		
		return consultas;
}

public void alterarPessoa(Pessoa pessoa) {
	pessoaDAO = PessoaDAO.getInstance();
	
	try {
		pessoaDAO.update(pessoa);
	}catch (UpdateException e) {
		System.out.println(e.getMessage());
	}
}

public void alterarPaciente (Paciente paciente) {
pacienteDAO = PacienteDAO.getInstance();
	
	try {
				pacienteDAO.update(paciente);
	}catch (UpdateException e) {
		System.out.println(e.getMessage());
	}
}

public void alterarMedico (Medico medico) {
medicoDAO =MedicoDAO.getInstance();
	
	try {
				medicoDAO.update(medico);
	}catch (UpdateException e) {
		System.out.println(e.getMessage());
	}
}
public void alterarConsulta (Consulta consulta) {
consultaDAO = ConsultaDAO.getInstance();
	
	try {
				consultaDAO.update(consulta);
	}catch (UpdateException e) {
		System.out.println(e.getMessage());
	}
}
}

