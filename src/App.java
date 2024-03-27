import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os estados separados por espaços: ");
        String[] estados = sc.nextLine().split(" ");

        System.out.println("Digite o alfabeto separado por espaços: ");
        String[] alfabeto = sc.nextLine().split(" ");

        System.out.println("Digite o estado inicial: ");
        String estadoInicial = sc.nextLine();

        System.out.println("Digite os estados finais separados por espaços: ");
        String[] estadosFinais = sc.nextLine().split(" ");

        AFD afd = new AFD(estados, alfabeto, estadoInicial, estadosFinais);

        System.out.println("Defina as funções de transição: (se não houver transição, digite - (hífen))");
        for (String estado : estados) {
            for (String simbolo : alfabeto) {
                System.out.print("Transição " + estado + " consumindo " + simbolo + ": ");
                String proximoEstado = sc.nextLine();
                if (!proximoEstado.equals("-")) {
                    afd.adicionarTransicao(estado, simbolo, proximoEstado);
                }
            }
        }

        System.out.println("Digite a palavra a ser reconhecida: ");
        String palavra = sc.nextLine();
        boolean palavraReconhecida = afd.reconhecerPalavra(palavra);
        System.out.println("A palavra foi " + (palavraReconhecida ? "aceita" : "rejeitada"));

        sc.close();
    }
}