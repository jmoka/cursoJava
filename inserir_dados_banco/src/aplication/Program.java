package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUE "
					+ "(?,?,?,?,?)");
					
					st.setString(1, "suely");
					st.setString(2, "suely@gmail.com");
					st.setDate(3, new java.sql.Date(sdf.parse("16/09/2023").getTime()));
					st.setDouble(4, 3000.0);
					st.setInt(5, 4);
				
					int rowAffected = st.executeUpdate();
					
					System.out.println("Cadastro Efetuado com Sucesso");
					System.out.println("Row Affected: " + rowAffected );
	
					
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		catch(ParseException p) {
			p.printStackTrace();
		}
		finally {
			DB.closeStatement(st);			
			DB.closeConnection();
		};
		
	

	}

}
