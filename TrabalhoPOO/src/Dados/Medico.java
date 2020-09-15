   package Dados;

public class Medico extends Pessoa {
	private String especialidade;
	private int idPes;
	private int id;

	public Medico(){
		super();
	}
	
	@Override
	public String toString() {
		return"id: " + id +" "+ super.toString() + ", especialidade: " + especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public int getIdPes() {
		return idPes;
	}
	public void setIdPes(int idPes) {
		this.idPes = idPes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
