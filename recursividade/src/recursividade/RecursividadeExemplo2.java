package recursividade;
public class RecursividadeExemplo2 {
    public static void main(String[] args) {
        int resultado = calcularFatorial(5);
        System.out.println("O fatorial de 5 e: " + resultado);
    }

    public static int calcularFatorial(int n) {
    	System.out.println(n + " nnnn");
        if (n == 0) {
            return 1;
        } else {
            // Chamada recursiva
        	System.out.println("rrrrrrrr " +n * calcularFatorial(n - 1));
            return n * calcularFatorial(n - 1);
        }
    }
}
