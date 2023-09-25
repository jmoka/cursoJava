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
		Department department  =  new Department();
	
		
		System.out.println("=== TESTE FindById ===");
        int depId = 3; // Substituí "dep" por "depId" para ficar mais claro
        department = departmentDao.findById(depId);
        
        if (department != null) {
            System.out.println(department);
        } else {
            System.out.println("Departamento não encontrado.");
        }
		

		System.out.println("\n=== TESTE FindAll ===");
		List <Department> list = departmentDao.findAll(); // estancia em uma lista o resultado do método finBydepartment
		System.out.println("Todos os Departamentos " );
		for(Department obj: list) { // percorre a lista e imprime o resultado		
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TESTE Insert===");
		String nomeDep = "Almoxarifado";
		department = new Department(null, nomeDep);
		departmentDao.insert(department);
		System.out.println("Novo departamento inserido = " + department.getId() );
		

		
		System.out.println("\n=== TESTE Update===");
		int id = 7;
		Department department1 = departmentDao.findById(id);
		department1.setName("Financas");
		departmentDao.updade(department1);
		System.out.println("Depertment" + " " + department1.getId() + " " +  "Para " + " " + department1.getName() + " Atualizado");
	
		
		System.out.println("\n=== TESTE Delete===");
		int id_d = 29;
		departmentDao.deleteById(id_d);
		System.out.println("Departamento com Id " + id_d + " deletado");
		
		
	}

}
