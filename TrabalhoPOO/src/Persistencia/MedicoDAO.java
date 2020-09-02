package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dados.Medico;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;


public class MedicoDAO {
	private static MedicoDAO instance = null;

	private PreparedStatement sqlinsert;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlupdate;
	private PreparedStatement sqlall;
	private PreparedStatement sqlselectmed;


	public MedicoDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into medico (id, especialidade, id_pessoa) values (default,?,?) ");
			sqldelete = conn.prepareStatement("delete from medico where id = ?");
			sqlupdate = conn.prepareStatement("update medico set especialidade = ?  where id = ?");
			sqlall = conn.prepareStatement("select id from medico");
			sqlselectmed = conn.prepareStatement("select * from medico where id = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MedicoDAO getInstance (){
			if(instance == null) 
				instance = new MedicoDAO();
			
			return instance;
	}

	public void insert (Medico medico) throws InsertException {
			try {
				sqlinsert.setString(1, medico.getEspecialidade());
				sqlinsert.setInt(2, medico.getIdPes());
				sqlinsert.executeUpdate();
				
				
			} catch (Exception e) {
				 throw new InsertException("erro de inserçao na tabela medico");
			}
	}

	public void delete (int id) throws DeleteException {
		try {
			sqldelete.setInt(1, id);
			sqldelete.executeUpdate();
		} catch (Exception e) {
			 throw new DeleteException("Não foi possivel deletar o medico pois ele tem consulta marcada");
		}
	}
	
	public Medico selectMed(int id) throws SelectException {
		ResultSet rs;
		Medico med = null;
		
		try {
			sqlselectmed.setInt(1, id);
			rs = sqlselectmed.executeQuery();
			if(rs.next()) {
				med = new Medico();
				med.setId(rs.getInt("id"));
				med.setNome(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getNome());
				med.setIdade(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getIdade());
				med.setCpf(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getCpf());
				med.setCidade(PessoaDAO.getInstance().selectPes(rs.getInt("id_pessoa")).getCidade());
				med.setEspecialidade(rs.getString("especialidade"));
				med.setIdPes(rs.getInt("id_pessoa"));
			} 
		} catch (Exception e) {
			throw new SelectException("erro de selecao na tabela medico");
		}
			return med;
	}

	public ArrayList<Medico> selectAllMed() throws SelectException {
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		ResultSet rs;
		try {
			rs = sqlall.executeQuery();
			while (rs.next()) {
				medicos.add(selectMed(rs.getInt("id")));
			}
		} catch (Exception e) {
			throw new SelectException("erro de seleção na tabela medico");
		}
			return medicos;
	}

	public void update (Medico medico) throws UpdateException {
		try {
			sqlupdate.setString(1, medico.getEspecialidade() );
			sqlupdate.setInt(2,  medico.getId());
			sqlupdate.executeUpdate();
		} catch (Exception e) {
			 throw new UpdateException("erro de update na tabela medico");
		}

	}
}

