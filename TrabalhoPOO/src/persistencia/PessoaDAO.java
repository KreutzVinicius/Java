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

	private PreparedStatement sqlinsert;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlupdate;
	private PreparedStatement sqlall;
	private PreparedStatement sqlselectpes;
	private PreparedStatement sqlselectcpf;


	public PessoaDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into pessoa (id, nome, idade, cpf, cidade) values (default,?,?,?,?) ");
			sqldelete = conn.prepareStatement("delete from pessoa where id = ?");
			sqlupdate = conn.prepareStatement("update pessoa set nome = ?, idade = ?, cidade = ?  where id = ?");
			sqlall = conn.prepareStatement("select id from pessoa");
			sqlselectpes = conn.prepareStatement("select * from pessoa where id = ?");
			sqlselectcpf = conn.prepareStatement("select id from pessoa where cpf = ? ");
		} catch (SQLException e) {
			System.out.println("Erro de Conexao");
		}
	}

	public static PessoaDAO getInstance (){
			if(instance == null) 
				instance = new PessoaDAO();
			
			return instance;
	}

	public void insert (Pessoa pessoa) throws InsertException {
			try {

				sqlinsert.setString(1,pessoa.getNome());
				sqlinsert.setInt(2,pessoa.getIdade());
				sqlinsert.setString(3,pessoa.getCpf());
				sqlinsert.setString(4,pessoa.getCidade());
				sqlinsert.executeUpdate();
				
				
			} catch (Exception e) {
				 throw new InsertException("erro de inserçao na tabela pessoa");
			}
	}

	public void delete (int id) throws DeleteException {
		try {
			sqldelete.setInt(1, id);
			sqldelete.executeUpdate();
		} catch (Exception e) {
			 throw new DeleteException("erro de exclusão na tabela pessoa");
		}
	}
	
	public Pessoa selectPes(int id) throws SelectException {
		ResultSet rs;
		Pessoa pes = null;
		
		try {
			sqlselectpes.setInt(1, id);
			rs = sqlselectpes.executeQuery();
			if(rs.next()) {
				pes = new Pessoa();
				pes.setIdPes(rs.getInt("id"));
				pes.setNome(rs.getString("nome"));
				pes.setIdade(rs.getInt("idade"));
				pes.setCpf(rs.getString("cpf"));
				pes.setCidade(rs.getString("cidade"));
			} 
		} catch (Exception e) {
			throw new SelectException("erro de selecao na tabela pessoa");
		}
			return pes;
	}
	
	public Pessoa selectCpf(String cpf) throws SelectException {
		ResultSet rs;
		Pessoa pes = null;
		
		try {
			sqlselectcpf.setString(1, cpf);
			rs = sqlselectcpf.executeQuery();
			if(rs.next()) {
				pes = this.selectPes(rs.getInt("id"));
			} 
		} catch (Exception e) {
			throw new SelectException("erro de selecao na tabela pessoa");
		}
			return pes;
	}

	public ArrayList<Pessoa> selectAllPes() throws SelectException {
		ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
		ResultSet rs;
		try {
			rs = sqlall.executeQuery();
			while (rs.next()) {
				pessoa.add(selectPes(rs.getInt("id")));
			}
		} catch (Exception e) {
			throw new SelectException("erro de seleção na tabela pessoa");
		}
			return pessoa;
	}

	public void update (Pessoa pessoa) throws UpdateException {
		try {

			
			sqlupdate.setString(1,pessoa.getNome());
			sqlupdate.setInt(2,pessoa.getIdade());
			sqlupdate.setString(3,pessoa.getCidade());
			sqlupdate.setInt(4,pessoa.getIdPes());
			sqlupdate.executeUpdate();
		} catch (Exception e) {
			 throw new UpdateException("erro de update na tabela pessoa");
		}

	}
}
