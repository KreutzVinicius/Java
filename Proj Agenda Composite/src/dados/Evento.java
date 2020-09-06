package dados;

import sistema.Agenda;

public class Evento implements Agenda{
int hora;
String descricao;

	public Evento(int hora, String descricao){
	this.hora = hora;
	this.descricao = descricao;
	}
	
	public Evento() {
	}

	@Override
	public void showAgenda() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return  "\n   "+ hora + "  " + descricao;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
