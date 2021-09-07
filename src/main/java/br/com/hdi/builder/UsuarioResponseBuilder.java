package br.com.hdi.builder;


import java.util.List;
import java.util.function.Consumer;

import br.com.hdi.rest.response.ContatoResponse;
import br.com.hdi.rest.response.UsuarioResponse;

public class UsuarioResponseBuilder {

    public Integer documento;
    public String nome;
    public String celular;
    public String endereco;
    public String cpf;
    public List<ContatoResponse> contatos;

    public UsuarioResponseBuilder with(Consumer<UsuarioResponseBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public UsuarioResponse build() {
        return new UsuarioResponse(documento, nome, contatos);
    }

}
