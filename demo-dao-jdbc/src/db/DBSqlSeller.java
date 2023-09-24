package db;

public class DBSqlSeller {
	
	public static String SqlInserir () {
		return "INSERT INTO seller "
				+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?) ";
	};

	public static String SqlFindById () {
		return "SELECT seller.*,department.Name as DepName " 
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id " 
				+ "WHERE seller.Id = ? ";
	};
	
	public static String findAll () {
		return "SELECT seller.*,department.Name as DepName " 
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id " 
				+ "ORDER BY Name ";
	};
	
	public static String SqlUpdate () {
		return "UPDATE seller " 
				+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
				+ "WHERE Id = ? ";
	}
	
	public static String SqlDeleteId () {
		return "DELETE FROM seller "
				+ "WHERE Id = ? ";
	}
}



