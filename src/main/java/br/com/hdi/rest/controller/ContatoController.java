package br.com.hdi.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.hdi.rest.request.ContatoRequest;
import br.com.hdi.rest.resource.ContatoResource;
import br.com.hdi.rest.response.ContatoResponse;
import br.com.hdi.service.ContatoService;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController implements ContatoResource {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ContatoResponse>> listAll(){
        return ResponseEntity.ok(contatoService.listAll());
    }

    @PostMapping
    @Override
    public ResponseEntity<?> save(@RequestBody ContatoRequest request) {
        contatoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Override
    public ResponseEntity<ContatoResponse> update(@RequestBody ContatoRequest request){
        return ResponseEntity.ok(contatoService.update(request));
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<ContatoResponse> searchById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(contatoService.searchById(id));
    }

}
