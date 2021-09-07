package br.com.hdi.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.hdi.exception.ContatoNaoEncontradoException;
import br.com.hdi.exception.UsuarioNaoEncontradoException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler({ UsuarioNaoEncontradoException.class })
    public ResponseEntity<?> usuarioNaoEncontrado(UsuarioNaoEncontradoException usuarioNaoEncontrado){
        return ResponseEntity.status(NOT_FOUND)
                .body(usuarioNaoEncontrado.getMessage());
    }

    @ExceptionHandler({ ContatoNaoEncontradoException.class })
    public ResponseEntity<?> contatoNaoEncontrado(ContatoNaoEncontradoException contatoNaoEncontrado){
        return ResponseEntity.status(NOT_FOUND)
                .body(contatoNaoEncontrado.getMessage());
    }

}