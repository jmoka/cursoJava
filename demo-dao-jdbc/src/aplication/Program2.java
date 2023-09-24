package aplication;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) throws SQLException {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
		
		System.out.println("=== TESTE FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		

		System.out.println("\n=== TESTE FindByDepartment ===");
		// primeiro vamos estanciar o departamento , pois é nesserário passar como parametro para se buscar o vendedores
		// importante que se note que ao estanciar um departamento deixe em nulo o nome
		
		Department department =  new Department(2, null);
		List <Seller> list = sellerDao.findBydepatment(department); // estancia em uma lista o resultado do método finBydepartment
		for(Seller obj: list) { // percorre a lista e imprime o resultado
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TESTE FindAll===");
		//  Vamos aproveitatr a lista agora recebendo o resultado de da chamada de sellerAll		
		list = sellerDao.findAll(); // lista todos e armazena e list
		for(Seller obj: list) { // percorre a lista e imprime o resultado
			System.out.println(obj); 
		}
		
		System.out.println("\n=== TESTE Insert===");		
		Seller newSeller = new Seller(null, "lika", "lika@lika", new Date(), 4000.00,  new Department(4, null) );
		sellerDao.insert(newSeller);
		System.out.println("Novo vendedor inserido = " + newSeller.getId() );
		
		
		System.out.println("\n=== TESTE Update===");
		int id = 2;
		Seller seller1 = sellerDao.findById(8);
		System.out.println("fff  " + seller1);
		seller1.setName("Loloka");
		System.out.println(seller1);
		sellerDao.updade(seller1);
		System.out.println("Vendedor" + " " + seller1.getId() + " " +  "Para " + " " + seller1.getName() + " Atualizado");
		
		System.out.println("\n=== TESTE Delete===");
		int id_d = 31;
		sellerDao.deleteById(id_d);
		System.out.println("Vendedor com Id " + id_d + " deletado");
		
		
	}

}
