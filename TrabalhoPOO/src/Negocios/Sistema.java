package Negocios;

import java.util.ArrayList;

import Dados.Consulta;
import Dados.Medico;
import Dados.Paciente;

public class Sistema {
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private ArrayList<Medico> medicos = new ArrayList<Medico>();
	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
public void cadastrarPaciente (Paciente paciente) {
	pacientes.add(paciente);
}

public void cadastrarMedico (Medico medico) {
	medicos.add(medico);
}

public void agendarConsulta (Consulta consulta) {
	consultas.add(consulta);
}

public void removerPaciente (Paciente paciente) {
	pacientes.remove(paciente);
}

public void removerMedico (Medico medico) {
	medicos.remove(medico);
}

public void removerConsulta (Consulta consulta) {
	consultas.remove(consulta);
}

public ArrayList<Paciente> buscarPacientes(){
	return pacientes;
} 

public ArrayList<Medico> buscarMedicos(){
	return medicos;
}

public ArrayList<Consulta> mostrarConsultas(){
	return consultas;
}

public void alterarPaciente (Paciente paciente, int cod) {
	for (Paciente x: pacientes) {
		if (x.getCodigoP() == cod) {
			 x.equals(paciente);
		}
	}
}

public void alterarMedico (Medico medico, int cod) {
	for (Medico x: medicos) {
		if (x.getCodigoM() == cod) {
			 x.equals(medico);
		}
	}
}


public void alterarConsulta (Consulta consulta, int cod) {
	for (Consulta x: consultas) {
		if (x.getCodigoC() == cod) {
			 x.equals(consulta);
		}
	}
}
}

