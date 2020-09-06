package dados;

import java.util.ArrayList;

import sistema.Agenda;

public class Mes implements Agenda{
int mes;
String nome;
ArrayList<Dia> dias;

	public Mes (int mes, String nome) {
	this.mes = mes;
	this.nome = nome;
	dias = new ArrayList<Dia>();
	}
	
	public Mes() {
	}

	@Override
	public void showAgenda() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "\n " + nome + dias;
	}

	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Dia> getDias() {
		return dias;
	}

	public void setDias(ArrayList<Dia> dias) {
		this.dias = dias;
	}

}
