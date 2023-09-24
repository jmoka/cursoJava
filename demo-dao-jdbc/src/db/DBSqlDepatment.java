package db;

public class DBSqlDepatment {
	
	public static String SqlInserir() {
        return "INSERT INTO department (Name) VALUES (?)";
    }

    public static String SqlFindById() {
        return "SELECT * FROM department WHERE Id = ?";
    }

    public static String findAll() {
        return "SELECT * FROM department ORDER BY Name";
    }

    public static String SqlUpdate() {
        return "UPDATE department SET Name = ? WHERE Id = ?";
    }

    public static String SqlDeleteId() {
        return "DELETE FROM department WHERE Id = ?";
    }
}



