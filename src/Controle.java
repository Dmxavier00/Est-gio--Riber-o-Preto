import java.util.Scanner;

public class Controle {
    private Scanner scanner = new Scanner(System.in);

    public void exibeMenu() {

        var opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    
                    0 - Sair.
                    1 - Verificar se o número pertence ou não a sequência de Fibonacci.
                    2 - Verificar a existência da letra ‘a’, além de informar a quantidade de vezes em que ela ocorre.
                    
                    Escolha uma opçao:""");

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    verificaFibonacci();
                    break;
                case 2:
                    verificarString();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }
    }

    private void verificarString() {
        System.out.println("Digite uma String: ");
        var messagem = scanner.nextLine();
        int contador = 0;

        for (int i = 0; i < messagem.length(); i++) {
            char letra = messagem.charAt(i);
            if (letra == 'a' || letra == 'A') {
                contador++;
            }
        }
        if (contador > 0) {
            System.out.println("A letra 'a' ou 'A' foi encontrada " + contador + " vezes.");
        } else {
            System.out.println("A letra 'a' ou 'A' não foi encontrada.");
        }
    }

    private void verificaFibonacci() {
        System.out.println("Digite um número para verificar: ");
        var numero = scanner.nextInt();

        if (Fibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

    }

    public static boolean Fibonacci(int numero) {
        int num1 = 0;
        int num2 = 1;

        while (num1 <= numero) {
            if (num1 == numero) {
                return true;
            }
            int proximoNum = num1;
            num1 = num2;
            num2 = proximoNum + num2;
        }
        return false;
    }

}