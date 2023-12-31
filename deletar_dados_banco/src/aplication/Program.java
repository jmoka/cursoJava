package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityExeption;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM department " + "WHERE " + "Id = ?");

			st.setInt(1, 6);

			int rowAffected = st.executeUpdate();

			System.out.println("Deletado o Departamento");
			System.out.println("Row Affected: " + rowAffected);

		} catch (SQLException e) {
			String msg = "Nao foi possivel Deletar o Campo Pai, verifique se nao possui chave estrangeira associada";

			throw new DbIntegrityExeption(msg);

		}

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		;

	}

}
