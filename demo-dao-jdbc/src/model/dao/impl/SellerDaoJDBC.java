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
import db.DBSqlSeller;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		PreparedStatement st = null; // esse recurso foi aberto PreparedStatement e precisa ser fechado
		// após o sql , Statement.RETURN_GENERATED_KEYS retorna o valor do id inserido
		try {
			st = conn.prepareStatement( DBSqlSeller.SqlInserir() , Statement.RETURN_GENERATED_KEYS);  // chama o sql e o id inserido
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBrithDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			
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
	public void updade(Seller obj) {
		PreparedStatement st = null; // esse recurso foi aberto PreparedStatement e precisa ser fechado
		// após o sql , Statement.RETURN_GENERATED_KEYS retorna o valor do id inserido
		try {
			st = conn.prepareStatement( DBSqlSeller.SqlUpdate());  // chama o sql e o id inserido
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBrithDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			st.setInt(6, obj.getId());
			
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
			st = conn.prepareStatement(DBSqlSeller.SqlDeleteId());
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
	public Seller findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement ( DBSqlSeller.SqlFindById());  // chama o sql
			st.setInt(1, id);
			rs = st.executeQuery(); // Retorna a consulta, ou seja retorna a tabela do banco de dados

			// OBS: DE FORMA DIDÁTICA USAREMOS TODO O CODIGO AQUI, NO PROXIMO COMMIT
			// USAREMOS FUNÇÃO
			if (rs.next()) {
				// DEVIDO SELLER TER UM DEPARTAMENTO ASSOCIADO É NECESSÁRIO ESTANCIAR,
				// O DEPARTAMENTO (DEPARTMENT) E O VENDEDOR ( SELLER)

				// ESTANCIAÇÃO DEPARTMENT
				Department dep = instantiateDepartment(rs);

				// ESTANCIAÇÃO SELLER
				Seller obj = instantiateSaller(rs, dep);

				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(DBSqlSeller.findAll ()); // chama o sql
			rs = st.executeQuery(); // Retorna a consulta, ou seja retorna a tabela do banco de dados
			List<Seller> list = new ArrayList<Seller>(); // devido um departamento poder conter varios vendedores
															// criamos uma lista para armazenar os vendedores da
															// consulta

			// OBS: É IMPORTANTE QUE SE TENHA O CONTROLE DAS ASSOCIAÇÃO
			// NÃO PODE SER INSTANCIADO MAIS DE UM DEPARTAMENTO OU SEJA ESTANCIAR UM
			// DEPARTAMENTO PARA CADA VENDEDOR
			// DEVE SER ESTANCIADO SOMENTE UMA VEZ O DEPARTAMENTO E E VARIOS VENDEDORES
			// COM ISSO PODEMOS FAZER DVARISO FORMAS , MAS VAMOS USAR O MAP
			Map<Integer, Department> map = new HashMap<>();
			// Map com a chave Integer e é do tipo department e esta vazil

			while (rs.next()) { // criamos um while para poder percorrer toda a lista

				// verificar se o departamento ja existe

				Integer IdDepartment = rs.getInt("DepartmentId"); // retorna o departamento que obteve consulta caso não
																	// retorne nada o valor e null
				Department dep = map.get(IdDepartment);
				/// criamos uma variavel dep que vai receber o seguinte:
				// vamos buscar no map através do método get , o id do departamento que veio na
				/// consulta
				// rs.getInt("DepartmentId"), busca dentro de resultset o id do departamento que
				/// retornou
				// se retornar nulo, significa que o departamento não foi ainda estanciado
				// caso ja tenha alguma instancia dentro do map , deve pular e não estanciar
				/// mais o departamento
				// para isso vamso criar um if para realizar a consulta

				if (dep == null) { // se não tiver ainda estanciado , sera instanciado , caso contrário irá passar
					dep = instantiateDepartment(rs);
					map.put(IdDepartment, dep);
				}

				// ESTANCIAÇÃO SELLER
				Seller obj = instantiateSaller(rs, dep);

				list.add(obj); // adicionamos todos os vendedores da consulta na lista
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findBydepatment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE DepartmentId = ? " + "ORDER BY Name ");

			st.setInt(1, department.getId());
			rs = st.executeQuery(); // Retorna a consulta, ou seja retorna a tabela do banco de dados

			List<Seller> list = new ArrayList<Seller>(); // devido um departamento poder conter varios vendedores
															// criamos uma lista para armazenar os vendedores da
															// consulta

			// OBS: É IMPORTANTE QUE SE TENHA O CONTROLE DAS ASSOCIAÇÃO
			// NÃO PODE SER INSTANCIADO MAIS DE UM DEPARTAMENTO OU SEJA ESTANCIAR UM
			// DEPARTAMENTO PARA CADA VENDEDOR
			// DEVE SER ESTANCIADO SOMENTE UMA VEZ O DEPARTAMENTO E E VARIOS VENDEDORES
			// COM ISSO PODEMOS FAZER DVARISO FORMAS , MAS VAMOS USAR O MAP
			Map<Integer, Department> map = new HashMap<>();
			// Map com a chave Integer e é do tipo department e esta vazil

			while (rs.next()) { // criamos um while para poder percorrer toda a lista

				// verificar se o departamento ja existe

				Integer IdDepartment = rs.getInt("DepartmentId"); // retorna o departamento que obteve consulta caso não
																	// retorne nada o valor e null
				Department dep = map.get(IdDepartment);
				/// criamos uma variavel dep que vai receber o seguinte:
				// vamos buscar no map através do método get , o id do departamento que veio na
				/// consulta
				// rs.getInt("DepartmentId"), busca dentro de resultset o id do departamento que
				/// retornou
				// se retornar nulo, significa que o departamento não foi ainda estanciado
				// caso ja tenha alguma instancia dentro do map , deve pular e não estanciar
				/// mais o departamento
				// para isso vamso criar um if para realizar a consulta

				if (dep == null) { // se não tiver ainda estanciado , sera instanciado , caso contrário irá passar
					dep = instantiateDepartment(rs);
					map.put(IdDepartment, dep);
				}

				// ESTANCIAÇÃO SELLER
				Seller obj = instantiateSaller(rs, dep);

				list.add(obj); // adicionamos todos os vendedores da consulta na lista
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
