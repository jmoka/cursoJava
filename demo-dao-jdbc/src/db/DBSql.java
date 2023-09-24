package db;

public class DBSql {
	
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
	}
}
