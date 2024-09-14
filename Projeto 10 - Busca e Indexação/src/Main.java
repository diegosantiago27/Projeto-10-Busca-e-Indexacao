import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Usar o classloader para carregar arquivos de recursos no classpath
        try {
            InputStream textoStream = Main.class.getResourceAsStream("/textos/texto.txt");
            InputStream palavrasChaveStream = Main.class.getResourceAsStream("/textos/palavraChave.txt");

            if (textoStream != null && palavrasChaveStream != null) {
                String textoLido = new String(textoStream.readAllBytes(), StandardCharsets.UTF_8);
                String palavrasChaveLidas = new String(palavrasChaveStream.readAllBytes(), StandardCharsets.UTF_8);

                // Processamento com os arquivos lidos
                ProcessadorTexto processadorTexto = new ProcessadorTexto(26);
                processadorTexto.lerTexto(textoLido);
                processadorTexto.lerPalavrasChave(palavrasChaveLidas);

                // Gerar índice remissivo
                TabelaHash tabelaHash = processadorTexto.getTabelaHash();
                GeradorIndiceRemissivo gerador = new GeradorIndiceRemissivo(tabelaHash, processadorTexto.getPalavrasChave());

                // Obter o resultado do índice remissivo
                String resultado = gerador.toString();

                // Escrever o resultado em um arquivo chamado "resultado.txt"
//                Path caminhoResultado = Paths.get("src/textos/resultado.txt");
//                Files.write(caminhoResultado, resultado.getBytes(StandardCharsets.UTF_8));
//
//                System.out.println("Arquivo 'resultado.txt' gerado com sucesso no pacote textos!");
                
                // Obter o caminho da pasta "Downloads" do usuário
                String pastaDownloads = System.getProperty("user.home") + "\\Downloads";

                // Definir o caminho completo para o arquivo "resultado.txt"
                Path caminhoResultado = Paths.get(pastaDownloads, "resultado.txt");

                // Escrever o resultado no arquivo
                Files.write(caminhoResultado, resultado.getBytes(StandardCharsets.UTF_8));

                System.out.println("Arquivo 'resultado.txt' gerado com sucesso na pasta Downloads!");


            } else {
                System.out.println("Erro ao carregar arquivos.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
