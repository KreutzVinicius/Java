package dados;

import java.util.ArrayList;

import sistema.Agenda;

public class Dia implements Agenda{
int dia;
String nome;
ArrayList<Evento> eventos;

	public Dia (int dia, String nome) {
		this.dia = dia;
		this.nome = nome;
		eventos = new ArrayList<Evento>();
	}

	public Dia() {
	}

	@Override
	public void showAgenda() {
	System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return   "\n  " + nome + " " + dia + eventos;
	}

	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

}