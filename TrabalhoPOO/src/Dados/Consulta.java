package Dados;


import java.util.Calendar;

public class Consulta {
	private int id;
	private float valor;
	private Calendar horario;
	private String diagnostico;
	private Medico medico;
	private Paciente paciente;
	
	public Consulta() {
		horario = Calendar.getInstance();
	}
	
	
	public String toString() {

		
		return "Consulta " + id + "\n valor: " + valor +" "+ horario.getTime() + ", diagnostico: " + diagnostico + "\n medico " + medico.toString() + "\n paciente " + paciente.toString();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Calendar getHorario() {
		return horario;
	}
	public void setHorario(Calendar horario) {
		this.horario = horario;
	}
	
	
}