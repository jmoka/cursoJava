package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import db.DB;
import db.DBSqlDepatment;
import db.DBSqlSeller;
import db.DbException;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null; // esse recurso foi aberto PreparedStatement e precisa ser fechado
		// após o sql , Statement.RETURN_GENERATED_KEYS retorna o valor do id inserido
		try {
			st = conn.prepareStatement( DBSqlDepatment.SqlInserir(), Statement.RETURN_GENERATED_KEYS);  // chama o sql e o id inserido
			st.setString(1, obj.getName());
					
			// testar para saber se retornou um resultado
			// EXUTAR O COMANDO E ARMAZENA O RSULTADO NA VARIÁVEL , O RETORNO É NUMERIOCO			
			 int rowAffected = st.executeUpdate(); // executa o comando sql			
			 if(rowAffected > 0 ) {
				 // Abre o recurso ResulteSet , o mesmo precisa ser fechado após a acão
				 ResultSet rs = st.getGeneratedKeys(); // recebe o resultado novo id iserido, recurso deve ser fechado
				 if(rs.next()) {
					 int id = rs.getInt(1); // armazena o resultado que vem na primeira poção para id
					 obj.setId(id); // seta o id do obj para o novo id armazenado
					}
				 	
				 	DB.closeResultSet(rs); // fechando o recurso que foi aberto no if
				 							
			}
			 else {
				 throw new DbException("Erro !! Nenhuma linha Afetada");
			 }	 	
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	};

	@Override
	public void updade(Department obj) {
		PreparedStatement st = null; // esse recurso foi aberto PreparedStatement e precisa ser fechado
		// após o sql , Statement.RETURN_GENERATED_KEYS retorna o valor do id inserido
		try {
			st = conn.prepareStatement( DBSqlDepatment.SqlUpdate());  // chama o sql e o id inserido
			st.setString(1, obj.getName());
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(DBSqlDepatment.SqlDeleteId());
			st.setInt(1, id);
			int rows = st.executeUpdate();
			if(rows == 0) {
				throw new DbException("Id nao tem no banco de dados , corrija a numeracao");
			};						
		}
		catch(SQLException e){
			throw new DbException("Vendedor não delatado , erro ao deletar");
		}
		finally{
			DB.closeStatement(st);
		}

	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement ( DBSqlDepatment.SqlFindById());  // chama o sql
			st.setInt(1, id);
			rs = st.executeQuery(); // Retorna a consulta, ou seja retorna a tabela do banco de dados

			// OBS: DE FORMA DIDÁTICA USAREMOS TODO O CODIGO AQUI, NO PROXIMO COMMIT
			// USAREMOS FUNÇÃO
			if (rs.next()) {
				// DEVIDO SELLER TER UM DEPARTAMENTO ASSOCIADO É NECESSÁRIO ESTANCIAR,
				// O DEPARTAMENTO (DEPARTMENT) E O VENDEDOR ( SELLER)

				// ESTANCIAÇÃO DEPARTMENT
				 return instantiateDepartment(rs);
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	// tem que propagar a excecão
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("id"));
		dep.setName(rs.getString("name"));
		return dep;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<Department>();
		try {
			st = conn.prepareStatement(DBSqlDepatment.findAll()); // chama o sql
			rs = st.executeQuery(); // Retorna a consulta, ou seja retorna a tabela do banco de dados
			
			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setName(rs.getString("name"));
				list.add(department);			
			}			
			
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	

}
