package br.com.hdi.rest.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioRequest {

    @ApiModelProperty(value = "Documento do usuário")
    private Integer documento;

    @ApiModelProperty(value = "Nome do usuário")
    private String nome;

    @ApiModelProperty(value = "Id dos Contatos")
    private List<Integer> contatosIds;

}
