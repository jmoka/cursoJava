package recursividade;
public class RecursividadeExemplo {
	public static void main(String[] args) {
        int n = 10; // Número de termos da sequência Fibonacci
        System.out.println("Sequência Fibonacci com " + n + " termos:");
        for (int i = 0; i < n; i++) {
            System.out.print(calcularFibonacci(i) + " ");
        }
    }

    public static int calcularFibonacci(int n) {
        if (n <= 1) {
            return n; // Casos base: Fibonacci(0) = 0 e Fibonacci(1) = 1
        } else {
            // Chamada recursiva para Fibonacci(n-1) e Fibonacci(n-2)
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}
