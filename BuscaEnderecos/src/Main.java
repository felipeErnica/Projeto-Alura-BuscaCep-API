import Exceptions.CepNotFoundException;
import Exceptions.EnderecoExitsException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        System.out.println("Digite um CEP:");
        String busca = new Scanner(System.in).nextLine();
        ListaEndereco listaEnderecos = new ListaEndereco();

        while (!busca.equals("0")) {
            try {
                Searcher pesquisaEndereco = new Searcher(busca);
                Endereco endereco =  pesquisaEndereco.converteEndereco();
                System.out.println(endereco.toString());
                listaEnderecos.add(endereco);
            }
            catch (IOException | InterruptedException | CepNotFoundException | EnderecoExitsException e) {
                System.out.println("ERRO!");
                System.out.println(e.getMessage());
            }

            System.out.println("Digite um CEP:");
            busca = new Scanner(System.in).nextLine();
        }

        try {
            listaEnderecos.imprimiJson();
            System.out.println("Arquivo impresso com sucesso!");
        } catch (IOException e) {
            e.getMessage();
        }

    }
}