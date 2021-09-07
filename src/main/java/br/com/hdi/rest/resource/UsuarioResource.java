package br.com.hdi.rest.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import br.com.hdi.rest.request.UsuarioRequest;
import br.com.hdi.rest.response.UsuarioResponse;

import java.util.List;

public interface UsuarioResource {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de usuários"),
            @ApiResponse(code = 404, message = "Usuario não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Retorna uma lista de usuários")
    ResponseEntity<List<UsuarioResponse>> listAll();

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario salvo com sucesso"),
            @ApiResponse(code = 500, message = "Problemas na hora de salvar")
    })
    @ApiOperation(value = "Salva um usuário")
    ResponseEntity<?> save(UsuarioRequest request);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra o usuário atualizado"),
            @ApiResponse(code = 404, message = "Usuario não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Atualiza as informações do usuário")
    ResponseEntity<UsuarioResponse> update(UsuarioRequest request);

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Não retorna nada"),
            @ApiResponse(code = 404, message = "Usuario não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Deleta um usuário")
    ResponseEntity<Void> delete(Integer id);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o usuário"),
            @ApiResponse(code = 500, message = "Usuario não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Busca um usuário através do seu ID")
    ResponseEntity<UsuarioResponse> searchById(Integer id);

}
