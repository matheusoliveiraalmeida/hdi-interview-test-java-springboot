package br.com.hdi.service;

import java.util.List;

import br.com.hdi.rest.request.ContatoRequest;
import br.com.hdi.rest.response.ContatoResponse;

public interface ContatoService {

    List<ContatoResponse> listAll();

    void save(ContatoRequest request);

    ContatoResponse update(ContatoRequest request);

    void delete(Integer id);

    ContatoResponse searchById(Integer id);

}
