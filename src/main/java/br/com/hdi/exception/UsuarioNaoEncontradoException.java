package br.com.hdi.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String exception) {
        super(exception);
    }
}
