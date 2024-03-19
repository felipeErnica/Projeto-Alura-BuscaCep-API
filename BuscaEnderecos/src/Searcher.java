import Exceptions.CepNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Searcher  {

    private HttpRequest request;
    private HttpClient client = HttpClient.newBuilder().build();
    private HttpResponse<String> response;

    public Searcher(String keyword) throws IOException, InterruptedException, CepNotFoundException {
        this.request = HttpRequest.newBuilder()
            .uri(URI.create("https://viacep.com.br/ws/" + keyword + "/json/"))
            .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 400) {
            throw new CepNotFoundException();
        }
    }

    public String toString() {
        return response.body();
    }

    public Endereco converteEndereco () throws CepNotFoundException{
        Gson gson = new GsonBuilder().create();
        Endereco endereco =  gson.fromJson(response.body(),Endereco.class);
        if (endereco.isErro()) {
            throw new CepNotFoundException();
        } else {
            return endereco;
        }
    }

    public int status() {
        return response.statusCode();
    }
}
