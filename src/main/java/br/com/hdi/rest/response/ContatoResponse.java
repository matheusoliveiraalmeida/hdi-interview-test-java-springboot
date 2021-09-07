package br.com.hdi.rest.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class ContatoResponse {

    @ApiModelProperty(value = "Id do Contato")
    private Integer id;

    @ApiModelProperty(value = "E-mail do Contato")
    private String email;

    @ApiModelProperty(value = "Telefone do Contato")
    private String telefone;

    @ApiModelProperty(value = "Contato Principal")
    private boolean flagPrincipal;

    @ApiModelProperty(value = "Contato do Usuario")
    private UsuarioResponse usuario;

    public ContatoResponse(
            Integer id,
            String email,
            String telefone,
            boolean flagPrincipal,
            UsuarioResponse usuario
    ) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.flagPrincipal = flagPrincipal;
        this.usuario = usuario;
    }

}
