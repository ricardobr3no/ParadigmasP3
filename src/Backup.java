import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Backup {

    private final String filePath;

    public Backup(String filePath) {
        this.filePath = filePath;
    }

    public String lerArquivo() {
        if (Files.exists(Paths.get(filePath))) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                return null;
            }
        } else {
            return "Arquivo não encontrado.";
        }
    }

    public void gravarDados(String data) {
        try (FileWriter fw = new FileWriter(filePath, true)) { // O segundo parâmetro 'true' permite adicionar ao arquivo
            fw.write(data);
            fw.flush(); // Força a escrita dos dados no arquivo
            System.out.println("Dados gravados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar os dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "./data/arquivo.txt"; // caminho real do seu arquivo
        Backup backup = new Backup(filePath);

        // Ler o arquivo
        String conteudo = backup.lerArquivo();
        System.out.println("Conteúdo do arquivo:\n" + conteudo);

        // Gravar dados no arquivo
        String novosDados = "Novos dados a serem adicionados.\n";
        backup.gravarDados(novosDados);
    }
}
