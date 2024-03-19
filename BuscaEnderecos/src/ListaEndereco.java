import Exceptions.EnderecoExitsException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListaEndereco {
    private ArrayList<Endereco> lista = new ArrayList<>();

    public void add (Endereco endereco) throws EnderecoExitsException {
        if (lista.contains(endereco)) {
            throw new EnderecoExitsException();
        } else {
            lista.add(endereco);
        }
    }

    public void imprimiJson() throws IOException {
        Gson conversorJson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = conversorJson.toJson(lista);
        FileWriter arquivoJson = new FileWriter("arquivo.json");
        arquivoJson.write(json);
        arquivoJson.close();
    }

}
