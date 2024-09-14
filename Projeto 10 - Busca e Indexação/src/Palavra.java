import java.util.LinkedHashSet;
import java.util.Set;

public class Palavra {
    private String texto;
    private Set<Integer> ocorrencias;

    public Palavra(String texto) {
        this.texto = texto.toLowerCase();
        this.ocorrencias = new LinkedHashSet<>();
    }

    public String getTexto() {
        return texto;
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.add(linha);
    }

    public Set<Integer> getOcorrencias() {
        return ocorrencias;
    }

    @Override
    public String toString() {
        return texto + " " + ocorrencias.toString().replaceAll("[\\[\\],]", "");
    }

}
