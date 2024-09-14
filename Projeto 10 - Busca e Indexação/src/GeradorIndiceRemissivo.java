import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeradorIndiceRemissivo {
	private TabelaHash tabelaHash;
	private List<String> palavrasChave;

	public GeradorIndiceRemissivo(TabelaHash tabelaHash, List<String> palavrasChave) {
		this.tabelaHash = tabelaHash;
		this.palavrasChave = palavrasChave;
	}

	@Override
	public String toString() {
		List<String> indiceRemissivo = new ArrayList<>();

		for (String chave : palavrasChave) {
			Palavra palavra = tabelaHash.buscarPalavra(chave.toLowerCase());
			if (palavra != null) {
				indiceRemissivo.add(palavra.toString());
			} else {
				indiceRemissivo.add(chave + " não encontrada no texto.");
			}
		}

		// Ordena as palavras-chave em ordem alfabética
		Collections.sort(indiceRemissivo);

		StringBuilder resultado = new StringBuilder();
		for (String entrada : indiceRemissivo) {
			resultado.append(entrada).append("\n");
		}

		return resultado.toString();
	}

}
