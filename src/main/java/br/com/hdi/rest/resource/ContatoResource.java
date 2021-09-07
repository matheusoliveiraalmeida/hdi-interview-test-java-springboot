package br.com.hdi.rest.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import br.com.hdi.rest.request.ContatoRequest;
import br.com.hdi.rest.response.ContatoResponse;

import java.util.List;

public interface ContatoResource {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de Contatos"),
            @ApiResponse(code = 404, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Retorna uma lista de Contatos")
    ResponseEntity<List<ContatoResponse>> listAll();

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Contato salvo com sucesso"),
            @ApiResponse(code = 500, message = "Problemas na hora de salvar")
    })
    @ApiOperation(value = "Salva um Contato")
    ResponseEntity<?> save(ContatoRequest request);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra o Contato atualizado"),
            @ApiResponse(code = 404, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Atualiza as informações do Contato")
    ResponseEntity<ContatoResponse> update(ContatoRequest request);

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Não retorna nada"),
            @ApiResponse(code = 404, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Deleta um Contato")
    ResponseEntity<Void> delete(Integer id);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Contato"),
            @ApiResponse(code = 500, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Busca um Contato através do seu ID")
    ResponseEntity<ContatoResponse> searchById(Integer id);

}
