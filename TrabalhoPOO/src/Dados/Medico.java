package Dados;

public class Medico extends Pessoas {
	private String especialidade;
	private int codigoM;

	public Medico(){
		super();
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public int getCodigoM() {
		return codigoM;
	}
	public void setCodigoM(int codigoM) {
		this.codigoM = codigoM;
	}
	
	
}
