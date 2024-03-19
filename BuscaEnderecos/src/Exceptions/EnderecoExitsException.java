package Exceptions;

public class EnderecoExitsException extends Exception{
    @Override
    public String getMessage() {
        return "CEP já foi adicionado!";
    }
}
