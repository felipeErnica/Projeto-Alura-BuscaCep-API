import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Endereco {

    @SerializedName("cep")
    private String cep;
    @SerializedName("logradouro")
    private String logradouro;
    @SerializedName("complemento")
    private String complemento;
    @SerializedName("bairro")
    private String bairro;
    @SerializedName("localidade")
    private String localidade;
    @SerializedName("uf")
    private String uf;
    @SerializedName("ibge")
    private long ibge;
    @SerializedName("gia")
    private long gia;
    @SerializedName("ddd")
    private long ddd;
    @SerializedName("siafi")
    private long siafi;
    @SerializedName("erro")
    private boolean erro;

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return logradouro + "," + bairro + "," + localidade + "," + uf;
    }

    @Override
    public boolean equals(Object o) {
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep);
    }

    public boolean isErro() {
        return erro;
    }
}
