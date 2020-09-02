package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Dados.Consulta;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class ConsultaDAO {
	private static ConsultaDAO instance = null;

	private PreparedStatement sqlinsert;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlupdate;
	private PreparedStatement sqlall;
	private PreparedStatement sqlselectcon;


	public ConsultaDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into consulta (id, valor, horario, diagnostico, id_medico, id_paciente) values (default,?,?,?,?,?) ");
			sqldelete = conn.prepareStatement("delete from consulta where id = ?");
			sqlupdate = conn.prepareStatement("update consulta set valor=?, data=?, horario=?, diagnostico=? where id = ?");
			sqlall = conn.prepareStatement("select id from consulta");
			sqlselectcon = conn.prepareStatement("select * from consulta where id = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConsultaDAO getInstance (){
			if(instance == null) 
				instance = new ConsultaDAO();
			
			return instance;
	}

	public void insert (Consulta consulta) throws InsertException {
			try {
				sqlinsert.setFloat(1, consulta.getValor());
				java.util.Date data = consulta.getHorario().getTime();
				java.sql.Timestamp sqlDate = new java.sql.Timestamp(data.getTime());
				sqlinsert.setTimestamp(2, sqlDate);
				sqlinsert.setString(3, consulta.getDiagnostico());
				sqlinsert.setInt(4, consulta.getMedico().getId());
				sqlinsert.setInt(5, consulta.getPaciente().getId());
				sqlinsert.executeUpdate();
				
				
			} catch (Exception e) {
				throw new InsertException("erro de inserção na tabela consulta");
			}
	}

	public void delete (int id) throws DeleteException {
		try {
			sqldelete.setInt(1, id);
			sqldelete.executeUpdate();
		} catch (Exception e) {
			 throw new DeleteException("erro de exclusão na tabela consulta");
		}
	}
	
	public Consulta selectCon(int id) throws SelectException {
		ResultSet rs;
		Consulta con = null;
		
		try {
			sqlselectcon.setInt(1, id);
			rs = sqlselectcon.executeQuery();
			if(rs.next()) {
				con = new Consulta();
				con.setId(rs.getInt("id"));
				con.setValor(rs.getInt("valor"));
				con.getHorario().setTime((Date)rs.getObject("horario"));
				con.setDiagnostico(rs.getString("diagnostico"));
				con.setMedico(MedicoDAO.getInstance().selectMed(rs.getInt("id_medico")));
				con.setPaciente(PacienteDAO.getInstance().selectPac(rs.getInt("id_paciente")));
			} 
		} catch (Exception e) {
			throw new SelectException("erro de selecao na tabela consulta");
		}
			return con;
	}

	public ArrayList<Consulta> selectAllCon() throws SelectException {
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		ResultSet rs;
		try {
			rs = sqlall.executeQuery();
			while (rs.next()) {
				consultas.add(selectCon(rs.getInt("id")));
			}
		} catch (Exception e) {
			throw new SelectException("erro de seleção na tabela consulta");
		}
			return consultas;
	}

	public void update (Consulta consulta) throws UpdateException {
		try {
			sqlupdate.setFloat(1, consulta.getValor());
			java.util.Date data = consulta.getHorario().getTime();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(data.getTime());
			sqlupdate.setTimestamp(2, sqlDate);
			sqlupdate.setString(3, consulta.getDiagnostico());
			sqlupdate.setInt (4, consulta.getId());
			sqlupdate.executeUpdate();
		} catch (Exception e) {
			 throw new UpdateException("erro de update na tabela consulta");
		}

	}
}
