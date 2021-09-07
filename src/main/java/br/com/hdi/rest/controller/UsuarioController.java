package br.com.hdi.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.hdi.rest.request.UsuarioRequest;
import br.com.hdi.rest.resource.UsuarioResource;
import br.com.hdi.rest.response.UsuarioResponse;
import br.com.hdi.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UsuarioResponse>> listAll(){
        return ResponseEntity.ok(usuarioService.listAll());
    }

    @PostMapping
    @Override
    public ResponseEntity<?> save(@RequestBody UsuarioRequest request) {
        usuarioService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Override
    public ResponseEntity<UsuarioResponse> update(@RequestBody UsuarioRequest request){
        return ResponseEntity.ok(usuarioService.update(request));
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<UsuarioResponse> searchById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(usuarioService.searchById(id));
    }

}