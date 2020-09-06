package dados;

import java.util.ArrayList;

import sistema.Agenda;

public class Ano implements Agenda {
	int ano;
	ArrayList<Mes> meses;
	
	public Ano (int ano) {
		this.ano = ano;
		meses = new ArrayList<Mes>();
	}
	
	public Ano() {
	}

	@Override
	public void showAgenda() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return ""+ ano + meses;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public ArrayList<Mes> getMeses() {
		return meses;
	}

	public void setMeses(ArrayList<Mes> meses) {
		this.meses = meses;
	}
}
