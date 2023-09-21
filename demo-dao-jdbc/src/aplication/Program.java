package aplication;

import java.sql.SQLException;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
	}

}
