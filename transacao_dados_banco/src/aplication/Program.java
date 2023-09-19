package aplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			// setAutoCommit (false);
			
			conn.setAutoCommit(false); // confirmar a operação somente quando eu commitar; não fazer isso automaticamenmte
			
			st = conn.createStatement();
		
			
			
			// Primeira situação
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 9000 WHERE DepartmentId = 1");
			
			
			
			//-----------------------------------------------
			// Simulando o erro no sistema
			int num = 3;
			if(num < 2) {
				throw new SQLException("Fake Erro");
			};
			// -----------------------------------------------
			
			
			// - 
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 6000 WHERE DepartmentId = 2");
		
			System.out.println("rows1 " + rows1 );	
			System.out.println("rows2 " + rows2 );	
			
			conn.commit(); // confirmar a tranzação
			
			
			
			
		}catch(SQLException e) {
			
			conn.rollback();  // Desfazer o que ja foi feito e retorna o banco de dados para a posição anterior 
		    System.out.println(e.getMessage());
		
			
		}
		
		finally {
			DB.closeStatement(st);			
			DB.closeConnection();
		};
		
	

	}

	public static void teste() {
		System.out.println("teste");
	};

}
