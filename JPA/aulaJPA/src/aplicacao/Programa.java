package aplicacao;

import dominio.Passoa;

public class Programa {

	public static void main(String[] args) {
		Passoa p1 = new Passoa(1, "carlos", "carlos@gmail.com");
		Passoa p2 = new Passoa(2, "patricia", "patricia@gmail.com");
		Passoa p3 = new Passoa(3, "luiz", "luiz@gmail.com");
		
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
