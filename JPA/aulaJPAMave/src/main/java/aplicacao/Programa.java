package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Passoa;


public class Programa {

	public static void main(String[] args) {
		//Passoa p1 = new Passoa(null, "carlos", "carlos@gmail.com");
		//Passoa p2 = new Passoa(null, "patricia", "patricia@gmail.com");
		//Passoa p3 = new Passoa(null, "luiz", "luiz@gmail.com");
		Passoa p4 = new Passoa(null, "Jolly Lika", "lika@gmail");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//em.persist(p1);
	//	em.persist(p2);
	//	em.persist(p3);
		em.persist(p4);
		
		em.getTransaction().commit();
				
		System.out.println("pronto");
	
	}

}
