package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller depObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updade(Seller depObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ? ");
			
			st.setInt(1, id);
			rs = st.executeQuery(); // Retorna a consulta, ou seja retorna a tabela do banco de dados 
			
			// OBS: DE FORMA DIDÁTICA USAREMOS TODO O CODIGO AQUI, NO PROXIMO COMMIT USAREMOS FUNÇÃO
			if(rs.next()) {
				// DEVIDO SELLER TER UM DEPARTAMENTO ASSOCIADO É NECESSÁRIO ESTANCIAR,
				// O DEPARTAMENTO (DEPARTMENT) E O VENDEDOR ( SELLER)
				
				// ESTANCIAÇÃO DEPARTMENT
				Department dep = instantiateDepartment(rs);
				
				// ESTANCIAÇÃO SELLER
				Seller obj = instantiateSaller(rs, dep);					
				
				return obj;			
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
			}
	


	private Seller instantiateSaller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBrithDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);		
		return obj;
	}

	// tem que propagar a excecão
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("Depname"));
		return dep;
	}



	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

		
}
