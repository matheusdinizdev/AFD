import java.util.HashMap;
import java.util.Set;

public class AFD {
    //private Set<String> estados;
    private Set<String> alfabeto;
    private String estadoInicial;
    private Set<String> estadosFinais;
    private HashMap<String, HashMap<String, String>> transicoes; // <estadoAtual <simbolo, proximoEstado>>

    /**
     * Construtor da classe AFD
     *
     * @param estados       Array de strings com os estados do AFD
     * @param alfabeto      Array de strings com o alfabeto do AFD
     * @param estadoInicial Estado inicial do AFD
     * @param estadosFinais Conjunto de estados finais do AFD
     */
    public AFD(String[] estados, String[] alfabeto, String estadoInicial, String[] estadosFinais) {
        this.transicoes = new HashMap<>();
        //this.estados = Set.of(estados);
        this.alfabeto = Set.of(alfabeto);
        this.estadoInicial = estadoInicial;
        this.estadosFinais = Set.of(estadosFinais);
    }

    /**
     * Adiciona uma transição ao AFD
     * @param estadoAtual Estado atual da transição
     * @param simbolo Simbolo que será consumido
     * @param proximoEstado Próximo estado após a transição ser realizada
     */
    public void adicionarTransicao(String estadoAtual, String simbolo, String proximoEstado) {
        if (!transicoes.containsKey(estadoAtual)) {
            transicoes.put(estadoAtual, new HashMap<>());
        }
        transicoes.get(estadoAtual).put(simbolo, proximoEstado);
    }

    /**
     * Verifica se uma palavra é aceita ou rejeitada pelo AFD
     * @param palavra Palavra a ser reconhecida
     * @return true se a palavra for aceita, false caso contrário
     */
    public boolean reconhecerPalavra(String palavra) {
        String estadoAtual = estadoInicial;
        for (int i = 0; i < palavra.length(); i++) {
            String simbolo = String.valueOf(palavra.charAt(i));
            if (!alfabeto.contains(simbolo)) {
                return false;
            }
            if (!transicoes.containsKey(estadoAtual) || !transicoes.get(estadoAtual).containsKey(simbolo)) {
                if (!transicoes.containsKey(estadoAtual) || !transicoes.get(estadoAtual).containsKey("-")) {
                    return false;
                }
                estadoAtual = transicoes.get(estadoAtual).get("-");
            } else {
                estadoAtual = transicoes.get(estadoAtual).get(simbolo);
            }
        }
        return estadosFinais.contains(estadoAtual);
    }

}