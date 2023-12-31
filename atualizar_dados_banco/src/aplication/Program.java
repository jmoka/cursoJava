package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
					
					st.setDouble(1, 1000.00);
					st.setInt(2, 4);
					
					
					int rowAffected = st.executeUpdate();
					
					System.out.println("Atualizacao feita com Sucesso");
					System.out.println("Row Affected: " + rowAffected );
	
					
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			DB.closeStatement(st);			
			DB.closeConnection();
		};
		
	

	}

}
