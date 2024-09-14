import java.util.LinkedList;
import java.util.List;

public class TabelaHash {
	private LinkedList<Palavra>[] tabela;

	@SuppressWarnings("unchecked")
	public TabelaHash(int tamanho) {
		tabela = new LinkedList[tamanho];
		for (int i = 0; i < tamanho; i++) {
			tabela[i] = new LinkedList<>();
		}
	}

	private int calcularIndice(String texto) {
		// Calcula o índice baseado na primeira letra da palavra
		return Character.toLowerCase(texto.charAt(0)) - 'a';
	}

	public void adicionarPalavra(Palavra palavra) {
		int indice = calcularIndice(palavra.getTexto());
		tabela[indice].add(palavra);
	}

	public Palavra buscarPalavra(String texto) {
	    int indice = calcularIndice(texto);
	    for (Palavra p : tabela[indice]) {
	        if (p.getTexto().equalsIgnoreCase(texto)) {
	            return p;
	        }
	    }
	    return null;
	}

	public List<Palavra> getListaPorIndice(int indice) {
		return tabela[indice];
	}

	public int getTamanho() {
		return tabela.length;
	}
}
