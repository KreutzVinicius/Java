package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Endereco;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class EnderecoDAO {
private static EnderecoDAO instance = null;

private PreparedStatement sqlinsert;
private PreparedStatement sqldelete;
private PreparedStatement sqlupdate;
private PreparedStatement sqlall;
private PreparedStatement sqlselect;
private PreparedStatement sqlselectpes;


public EnderecoDAO() {
	Connection conn = Conexao.getConexao();
	try {
		sqlinsert = conn.prepareStatement("insert into endereco (id, rua, numero, cidade, id_pessoa) values (default,?,?,?,?) ");
		sqldelete = conn.prepareStatement("delete from endereco where id = ?");
		sqlupdate = conn.prepareStatement("update endereco set rua = ?, numero = ?, cidade = ? where id = ?");
		sqlall = conn.prepareStatement("select id from endereco");
		sqlselect = conn.prepareStatement("select * from endereco where id = ?");
		sqlselectpes = conn.prepareStatement("select * from endereco where id_pessoa = ?");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static EnderecoDAO getInstance () throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) 
			instance = new EnderecoDAO();
		
		return instance;
}

public void insert (Endereco endereco) throws InsertException {
		try {
			sqlinsert.setString(1, endereco.getRua() );
			sqlinsert.setInt(2, endereco.getNumero());
			sqlinsert.setString(3, endereco.getCidade());
			sqlinsert.setInt(4,endereco.getIdPessoa()); 
			sqlinsert.executeUpdate();
			
		} catch (Exception e) {
			 throw new InsertException("erro de inserçao na tabela endereco");
		}
}

public void delete (Endereco endereco) throws DeleteException {
	try {
		sqldelete.setInt(1, endereco.getId());
		sqldelete.executeUpdate();
	} catch (Exception e) {
		 throw new DeleteException("erro de exclusão na tabela endereco");
	}
}
public Endereco select(int id) throws SelectException {
	ResultSet rs;
	Endereco end = null;
	
	try {
		sqlselect.setInt(1, id);
		rs = sqlselect.executeQuery();
		if(rs.next()) {
			end = new Endereco();
			end.setId(rs.getInt("id"));
			end.setRua(rs.getString("rua"));
			end.setNumero(rs.getInt("numero"));
			end.setCidade(rs.getString("cidade"));
			end.setIdPessoa(rs.getInt("id_pessoa"));
		} 
	} catch (Exception e) {
		throw new SelectException("erro de selecao na tabela endereco");
	}
		return end;
}

public ArrayList<Endereco> selectAll() throws SelectException {
	ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	ResultSet rs;
	try {
		rs = sqlall.executeQuery();
		while (rs.next()) {
			enderecos.add(select(rs.getInt("id")));
		}
	} catch (Exception e) {
		throw new SelectException("erro de seleção na tabela endereco");
	}
		return enderecos;
}

public void update (Endereco endereco) throws UpdateException {
	try {
		sqlupdate.setString(1, endereco.getRua() );
		sqlupdate.setInt(2, endereco.getNumero());
		sqlupdate.setString(3, endereco.getCidade());
		sqlupdate.setInt(4,  endereco.getId());
		sqlupdate.executeUpdate();
	} catch (Exception e) {
		 throw new UpdateException("erro de update na tabela endereco");
	}

}
}

