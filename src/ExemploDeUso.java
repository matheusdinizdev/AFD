import java.util.ArrayList;
import java.util.List;

public class ExemploDeUso {
    public static void main(String[] args) {
        /*
         Criação do AFD
         */
        String[] estados = {"q0", "q1", "q2"};
        String[] alfabeto = {"a", "b", "c"};
        String estadoInicial = "q0";
        String[] estadosFinais = {"q1"};

        AFD afd = new AFD(estados, alfabeto, estadoInicial, estadosFinais);

        afd.adicionarTransicao("q0", "a", "q0");
        afd.adicionarTransicao("q0", "b", "q1");
        afd.adicionarTransicao("q0", "c", "-");

        afd.adicionarTransicao("q1", "a", "q2");
        afd.adicionarTransicao("q1", "b", "q1");
        afd.adicionarTransicao("q1", "c", "-");

        afd.adicionarTransicao("q2", "a", "q1");
        afd.adicionarTransicao("q2", "b", "-");
        afd.adicionarTransicao("q2", "c", "q0");

        String[] palavras = {"a", "b", "c", "ab", "ac", "bc", "bcc", "abc"};
        List<String> palavrasAceitas = new ArrayList<>();
        List<String> palavrasRejeitadas = new ArrayList<>();

        /*
         Impressão do resultado da execução do AFD para cada palavra
         */
        for (String palavra : palavras) {
            boolean palavraReconhecida = afd.reconhecerPalavra(palavra);
            if (palavraReconhecida) {
                palavrasAceitas.add(palavra);
            } else {
                palavrasRejeitadas.add(palavra);
            }
            System.out.println("A palavra " + palavra + " foi " + (palavraReconhecida ? "aceita" : "rejeitada"));
        }
        System.out.println();

        System.out.println("Palavras aceitas: ");
        for (int i = 0; i < palavrasAceitas.size(); i++) {
            String palavra = palavrasAceitas.get(i);
            System.out.print(palavra);
            if (i < palavrasAceitas.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
                System.out.println();
            }
        }

        System.out.println("Palavras Rejeitadas: ");
        for (int i = 0; i < palavrasRejeitadas.size(); i++) {
            String palavra = palavrasRejeitadas.get(i);
            System.out.print(palavra);
            if (i < palavrasRejeitadas.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }
    }
}
