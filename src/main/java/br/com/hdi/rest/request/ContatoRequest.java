package br.com.hdi.rest.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequest {

    @ApiModelProperty(value = "Id do Contato")
    private Integer id;

    @ApiModelProperty(value = "E-mail do Contato")
    private String email;

    @ApiModelProperty(value = "Telefone do Contato")
    private String telefone;

    @ApiModelProperty(value = "Contato Principal")
    private boolean flagPrincipal;

    @ApiModelProperty(value = "Id do usuário")
    private Integer usuarioId;

}
