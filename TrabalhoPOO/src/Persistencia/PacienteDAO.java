package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dados.Paciente;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class PacienteDAO {
	private static PacienteDAO instance = null;

	private PreparedStatement sqlinsert;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlupdate;
	private PreparedStatement sqlall;
	private PreparedStatement sqlselectpas;


	public PacienteDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into paciente (id, descricao, id_pessoa) values (default,?,?) ");
			sqldelete = conn.prepareStatement("delete from paciente where id = ?");
			sqlupdate = conn.prepareStatement("update paciente set descricao = ?  where id = ?");
			sqlall = conn.prepareStatement("select id from paciente");
			sqlselectpas = conn.prepareStatement("select * from paciente where id = ?");
		} catch (SQLException e) {
			System.out.println("erro de conexao");
		}
	}

	public static PacienteDAO getInstance (){
			if(instance == null) 
				instance = new PacienteDAO();
			
			return instance;
	}

	public void insert (Paciente paciente) throws InsertException {
			try {
				sqlinsert.setString(1, paciente.getDescricao());
				sqlinsert.setInt(2, paciente.getIdPes());
				sqlinsert.executeUpdate();
				
				
			} catch (Exception e) {
				 throw new InsertException("erro de inserçao na tabela paciente");
			}
	}

	public void delete (int id) throws DeleteException {
		try {
			sqldelete.setInt(1, id);
			sqldelete.executeUpdate();
		} catch (Exception e) {
			 throw new DeleteException("Não foi possivel deletar o paciente pois ele tem consulta marcada");
		}
	}
	
	public Paciente selectPac(int id) throws SelectException {
		ResultSet rs;
		Paciente pac = null;
		
		try {
			sqlselectpas.setInt(1, id);
			rs = sqlselectpas.executeQuery();
			if(rs.next()) {
				pac = new Paciente();
				pac.setId(rs.getInt("id"));
				pac.setNome(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getNome());
				pac.setIdade(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getIdade());
				pac.setCpf(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getCpf());
				pac.setCidade(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getCidade());
				pac.setDescricao(rs.getString("descricao"));
				pac.setIdPes(rs.getInt("id_pessoa"));
				
			} 
		} catch (Exception e) {
			throw new SelectException("erro de selecao na tabela paciente");
		}
			return pac;
	}

	public ArrayList<Paciente> selectAllPac() throws SelectException {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		ResultSet rs;
		try {
			rs = sqlall.executeQuery();
			while (rs.next()) {
				pacientes.add(selectPac(rs.getInt("id")));
			}
		} catch (Exception e) {
			throw new SelectException("erro de seleção na tabela paciente");
		}
			return pacientes;
	}

	public void update (Paciente paciente) throws UpdateException {
		try {
			sqlupdate.setString(1, paciente.getDescricao() );
			sqlupdate.setInt(2,  paciente.getId());
			sqlupdate.executeUpdate();
		} catch (Exception e) {
			 throw new UpdateException("erro de update na tabela paciente");
		}

	}
}
