package br.com.hdi.builder;

import br.com.hdi.model.Contato;
import br.com.hdi.model.Usuario;

import java.util.function.Consumer;

public class ContatoBuilder {

    public Integer id;
    public String email;
    public String telefone;
    public boolean flagPrincipal;
    public Usuario usuario;

    public ContatoBuilder with(Consumer<ContatoBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public Contato build() {
        return new Contato(id, email, telefone, flagPrincipal, usuario);
    }

}
