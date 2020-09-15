package dados;

public class Paciente extends Pessoa{
	private String descricao;
	private int idPes;
	private int id;
	
	public Paciente(){
		super();
	}
	
	@Override
	public String toString() {
		return "id: " + id +" "+ super.toString() + ", descricao: " + descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
