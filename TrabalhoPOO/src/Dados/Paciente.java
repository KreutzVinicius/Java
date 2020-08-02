package Dados;

public class Paciente extends Pessoas{
	private String descricao;
	private int codigoP;
	
	public Paciente(){
		super();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}
	
}
