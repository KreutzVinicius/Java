package dados;

public class Contato {
private String nome;
private int telefone;



public String getNome() {
	return nome;
}
public Contato setNome(String nome) {
	this.nome = nome;
	return null;
}
public int getTelefone() {
	return telefone;
}
public void setTelefone(int telefone) {
	this.telefone = telefone;
}
@Override
public String toString() {
	return "Nome:" + nome + ", Telefone:" + telefone  ;
}


}
