package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Pessoa;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class PessoaDAO {
	private static PessoaDAO instance = null;
	
	private  PreparedStatement sqlinsert;
	private  PreparedStatement sqldelete;
	private  PreparedStatement sqlupdate;
	private  PreparedStatement sqlall;
	private  PreparedStatement sqlselect;
	private  PreparedStatement sqlselectcpf;
	
	public PessoaDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into pessoa (id, nome, cpf, telefone) values (default,?,?,?) ");
			sqldelete = conn.prepareStatement("delete from pessoa where id = ?");
			sqlupdate = conn.prepareStatement("update pessoa set nome = ?, telefone = ? where id = ?");
			sqlall = conn.prepareStatement("select id from pessoa");
			sqlselect = conn.prepareStatement("select * from pessoa where id = ?");
			sqlselectcpf = conn.prepareStatement("select * from pessoa where cpf = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static PessoaDAO getInstance () throws ClassNotFoundException, SQLException, SelectException {
			if(instance == null) 
				instance = new PessoaDAO();
			
			return instance;
	}
	
	public void insert (Pessoa pessoa) throws InsertException {
			try {
				sqlinsert.setString(1, pessoa.getNome() );
				sqlinsert.setString(2, pessoa.getCpf());
				sqlinsert.setInt(3, pessoa.getTelefone());
				sqlinsert.executeUpdate();
				pessoa.getEndereco().setIdPessoa(this.selectCpf(pessoa.getCpf()).getId());
				EnderecoDAO.getInstance().insert(pessoa.getEndereco());
				
			} catch (Exception e) {
				 throw new InsertException("erro de inserçao na tabela pessoa");
			}
	}
	
	public void delete (Pessoa pessoa) throws DeleteException {
		
		try {
			EnderecoDAO.getInstance().delete(pessoa.getEndereco());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			sqldelete.setInt(1, pessoa.getId());
			sqldelete.executeUpdate();
		} catch (Exception e) {
			 throw new DeleteException("erro de exclusão na tabela pessoa");
		}
	}
	
	public Pessoa select(int id) throws SelectException {
		ResultSet rs;
		Pessoa pess = null;
		
		try {
			sqlselect.setInt(1, id);
			rs = sqlselect.executeQuery();
			if(rs.next()) {
				pess = new Pessoa();
				pess.setId(rs.getInt("id"));
				pess.setNome(rs.getString("nome"));
				pess.setCpf(rs.getString("cpf"));
				pess.setTelefone(rs.getInt("telefone"));
				pess.setEndereco(EnderecoDAO.getInstance().selectPes(rs.getInt("id")));
			} 
		} catch (Exception e) {
			throw new SelectException("erro de selecao na tabela pessoa");
		}
			return pess;
	}

	public ArrayList<Pessoa> selectAll() throws SelectException {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs;
		try {
			rs = sqlall.executeQuery();
			while (rs.next()) {
				pessoas.add(select(rs.getInt("id")));
			}
		} catch (Exception e) {
			throw new SelectException("erro de seleção na tabela pessoa");
		}
			return pessoas;
	}
	

	public Pessoa selectCpf(String cpf) throws ClassNotFoundException, SelectException {
		ResultSet rs;
		Pessoa pess = new Pessoa();
		
		try {
			sqlselectcpf.setString(1, cpf);
			rs = sqlselectcpf.executeQuery();
			if(rs.next()) {
				pess = new Pessoa();
				pess.setId(rs.getInt("id"));
				pess.setCpf(rs.getString("cpf"));
				pess.setNome(rs.getString("nome"));
				pess.setEndereco(EnderecoDAO.getInstance().selectPes(rs.getInt("id")));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pess;
	}
	
	public void update (Pessoa pessoa) throws UpdateException {
		try {
			EnderecoDAO.getInstance().update(pessoa.getEndereco());
			sqlupdate.setInt(3, pessoa.getId());
			sqlupdate.setString(1, pessoa.getNome());
			sqlupdate.setInt(2, pessoa.getTelefone());
			sqlupdate.executeUpdate();
			
		} catch (Exception e) {
			 throw new UpdateException("erro de update na tabela pessoa");
		}

	}
}

