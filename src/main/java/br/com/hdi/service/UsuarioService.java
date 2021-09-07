package br.com.hdi.service;

import java.util.List;

import br.com.hdi.rest.request.UsuarioRequest;
import br.com.hdi.rest.response.UsuarioResponse;

public interface UsuarioService {

    List<UsuarioResponse> listAll();

    void save(UsuarioRequest request);

    UsuarioResponse update(UsuarioRequest request);

    void delete(Integer id);

    UsuarioResponse searchById(Integer id);

}
