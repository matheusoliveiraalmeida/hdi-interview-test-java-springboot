package br.com.hdi.builder;

import br.com.hdi.model.Usuario;
import br.com.hdi.model.Contato;

import java.util.List;
import java.util.function.Consumer;

public class UsuarioBuilder {

    public Integer documento;
    public String nome;
    public List<Contato> contatos;

    public UsuarioBuilder with(Consumer<UsuarioBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public Usuario build() {
        return new Usuario(documento, nome, contatos);
    }

}
