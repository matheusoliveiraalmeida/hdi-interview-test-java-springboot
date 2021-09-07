package br.com.hdi.exception;

public class ContatoNaoEncontradoException extends RuntimeException {
    public ContatoNaoEncontradoException(String exception) {
        super(exception);
    }
}
