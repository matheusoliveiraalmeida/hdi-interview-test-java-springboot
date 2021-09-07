package br.com.hdi.builder;

import br.com.hdi.rest.response.ContatoResponse;
import br.com.hdi.rest.response.UsuarioResponse;

import java.util.function.Consumer;

public class ContatoResponseBuilder {

    public Integer id;
    public String email;
    public String telefone;
    public boolean flagPrincipal;
    public UsuarioResponse usuario;

    public ContatoResponseBuilder with(Consumer<ContatoResponseBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public ContatoResponse build() {
        return new ContatoResponse(id, email, telefone, flagPrincipal, usuario);
    }

}
