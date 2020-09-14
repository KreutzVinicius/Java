package negocio;


import java.util.ArrayList;

import dados.Pessoa;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.PessoaDAO;

public class Sistema {
	private PessoaDAO pessoaDAO = new PessoaDAO();


	public ArrayList<Pessoa> selectAll() throws SelectException {
		return pessoaDAO.selectAll();
	
	}
	
	public void inserirPessoa(Pessoa pessoa) throws InsertException, SelectException {
		pessoaDAO.insert(pessoa);
	}
	
	public void deletarPessoa(Pessoa pessoa) throws DeleteException {
		pessoaDAO.delete(pessoa);
	}
	
	public void atualizarPessoa(Pessoa pessoa) throws UpdateException{
		pessoaDAO.update(pessoa);
	}
	
	public void selecionarPessoaCpf (String cpf) throws SelectException, ClassNotFoundException{
		pessoaDAO.selectCpf(cpf);
	}
}
