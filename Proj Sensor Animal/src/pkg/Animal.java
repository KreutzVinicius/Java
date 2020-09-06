package pkg;

import java.util.ArrayList;
import java.util.Random;

public class Animal implements Sujeito {
	private String nome;
	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	private Posicao posicao;
	Random rd = new Random();
	
	@Override
	public void adicionar(Observador observador) {
		observadores.add(observador);
	}
	
	@Override
	public void remover(Observador observador) {
		observadores.remove(observador);
	}
	
	@Override
	public void notificar() {
		for(Observador o :observadores)
			o.atualizar(posicao);
	}

	
	public void andarFrente() {
		posicao.setY( posicao.getY() + 1);
		notificar();
	}
	
	public void andarTras() {
		posicao.setY( posicao.getY() - 1);
		notificar();
	}
	
	public void andarDireita() {
		posicao.setX( posicao.getX() + 1);
		notificar();
	}
	
	public void andarEsquerda() {
		posicao.setX( posicao.getX() - 1);
		notificar();
	}
	public Posicao movimentar() {
		int op = rd.nextInt(3);
		
		if (op == 0) {
			andarEsquerda();
		}else {
			if(op==1) {
				andarDireita();
			}else {
				if(op==2) {
					andarFrente();
				}else {
					if (op == 3)
						andarTras();
				}
			}
		}
		
		notificar();
		return posicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Observador> getObservadores() {
		return observadores;
	}

	public void setObservadores(ArrayList<Observador> observadores) {
		this.observadores = observadores;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Random getRd() {
		return rd;
	}

	public void setRd(Random rd) {
		this.rd = rd;
	}
}
