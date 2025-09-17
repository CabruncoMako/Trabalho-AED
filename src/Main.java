import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        //Ler input no console ditando o caminho do texto (AO DIGITAR CAMINHO, INCLUIR O NOME DO TEXTO E FORMATO .TXT NO FINAL)
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Digite o caminho do arquivo: ");
            String caminhoTexto = console.readLine();

            try (BufferedReader reader = new BufferedReader(new FileReader(caminhoTexto))) {
                System.out.println("Texto localizado\n");

                String linha;

                //Pular a primeira linha do exemplo
                boolean primeiraLinha = true;

                while ((linha = reader.readLine()) != null) {
                    if (primeiraLinha) {
                        primeiraLinha = false;
                        continue;
                    }

                    String[] partes = linha.split(","); // Dividir palavras por vírgula

                    //Transformar palavras e números escritos em dados
                    int id = Integer.parseInt(partes[0].trim());
                    String nome = partes[1].trim();
                    String prioridade = partes[2].trim();
                    int ciclos = Integer.parseInt(partes[3].trim());
                    boolean precisaDisco = Boolean.parseBoolean(partes[4].trim());

                    Processo p = new Processo(id, nome, prioridade, ciclos, precisaDisco);

                    System.out.println(p);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Texto não foi localizado");
            }
            catch (IOException e) {
                System.out.println("Algo deu errado ao ler o arquivo");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler entrada do usuário");
        }
    }
}
