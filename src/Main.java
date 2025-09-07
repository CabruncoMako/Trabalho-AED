import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Local do arquivo de texto
        String caminhoTexto = "C:\\Users\\pablo\\Desktop\\texto.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoTexto))) {
            System.out.println("Texto localizado\n");

            String linha;

            //Pular linha do com o exemplo
            boolean primeiraLinha = true;

            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(","); //Dividir palavras por vírgula

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
        //Failsafe para caso texto não seja localizado
        catch (FileNotFoundException e) {
            System.out.println("Texto não foi localizado");
        }
        catch (IOException e) {
            System.out.println("Algo deu errado");
        }
    }
}
