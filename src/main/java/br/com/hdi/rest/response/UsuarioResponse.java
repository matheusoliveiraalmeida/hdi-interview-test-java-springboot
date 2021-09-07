package br.com.hdi.rest.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class UsuarioResponse {

    @ApiModelProperty(value = "Documento do usuário")
    private Integer documento;

    @ApiModelProperty(value = "Nome do usuário")
    private String nome;

    @ApiModelProperty(value = "Contatos do usuário")
    private List<ContatoResponse> contatos;

    public UsuarioResponse(
            Integer documento,
            String nome,
            List<ContatoResponse> contatos
    ) {
        this.documento = documento;
        this.nome = nome;
        this.contatos = contatos;
    }

}
