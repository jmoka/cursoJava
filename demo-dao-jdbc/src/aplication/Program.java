package aplication;

import java.sql.SQLException;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws SQLException {
		Department obj = new Department(1, "livro");
		Department obj1 = new Department(2, "carros");
		System.out.println(obj);
		
		
		Seller seller = new Seller(1, "jota", "jota@gmail.com", new Date(), 300.00, obj1 );
		System.out.println(seller);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
	}

}
