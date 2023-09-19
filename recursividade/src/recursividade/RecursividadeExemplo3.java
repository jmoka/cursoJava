package recursividade;

public class RecursividadeExemplo3 {
	public static void main(String[] args) {
        String palavra = "radar";
        if (ePalindromo(palavra)) {
            System.out.println(palavra + " é um palíndromo.");
        } else {
            System.out.println(palavra + " não é um palíndromo.");
        }
    }

    public static boolean ePalindromo(String palavra) {
        int tamanho = palavra.length();
        if (tamanho <= 1) {
            return true; // Casos base: Strings vazias ou de comprimento 1 são palíndromos.
        } else if (palavra.charAt(0) != palavra.charAt(tamanho - 1)) {
            return false; // Os caracteres nas extremidades não são iguais, portanto, não é um palíndromo.
        } else {
            // Chamada recursiva: Verifica se a substring excluindo os caracteres das extremidades é um palíndromo.
            return ePalindromo(palavra.substring(1, tamanho - 1));
        }
    }
}
