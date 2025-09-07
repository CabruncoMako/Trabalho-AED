import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Local do arquivo de texto
        String caminhodotexto = "C:\\Users\\pablo\\Desktop\\dimmy.txt";

        //Leitor e printador do texto
        try(BufferedReader reader = new BufferedReader(new FileReader(caminhodotexto))){
            System.out.println("Texto localizado\n");

            String linha;
            while((linha = reader.readLine()) != null){
                System.out.println(linha);
            }
        }

        //Failsafe para caso o programa não localize o .txt
        catch (FileNotFoundException e){
            System.out.println("Texto não foi localizado");
        }
        catch (IOException e){
            System.out.println("Algo deu errado");
        }
    }
}