package Exceptions;

public class CepNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Não foi possível encontrar o CEP informado!";
    }
}
