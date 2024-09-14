import java.util.Arrays;
import java.util.List;

public class ProcessadorTexto {
	private TabelaHash tabelaHash;
	private List<String> palavrasChave;

	public ProcessadorTexto(int tamanhoTabela) {
		this.tabelaHash = new TabelaHash(tamanhoTabela);
	}
	public void lerTexto(String texto) {
	    String[] linhas = texto.split("\n");
	    int numeroLinha = 0;

	    for (String linha : linhas) {
	        numeroLinha++;
	        
	        String[] palavras = linha.split("\\s+");

	        for (String textoPalavra : palavras) {
	            
	            textoPalavra = textoPalavra.replaceAll("[^a-zA-Z0-9-]", "");
	            String palavraNormalizada = textoPalavra.toLowerCase();
	            if (palavraNormalizada.isEmpty()) {
	                continue;
	            }
	            Palavra palavra = tabelaHash.buscarPalavra(palavraNormalizada);
	            if (palavra == null) {
	                palavra = new Palavra(palavraNormalizada);
	                tabelaHash.adicionarPalavra(palavra);
	            }
	            palavra.adicionarOcorrencia(numeroLinha);
	        }
	    }
	}


	public void lerPalavrasChave(String textoPalavrasChave) {
		palavrasChave = Arrays.asList(textoPalavrasChave.split(",\\s*"));
	}

	public TabelaHash getTabelaHash() {
		return tabelaHash;
	}

	public List<String> getPalavrasChave() {
		return palavrasChave;
	}
}
