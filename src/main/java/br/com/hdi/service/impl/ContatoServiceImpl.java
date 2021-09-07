package br.com.hdi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hdi.builder.ContatoBuilder;
import br.com.hdi.builder.ContatoResponseBuilder;
import br.com.hdi.builder.UsuarioResponseBuilder;
import br.com.hdi.exception.ContatoNaoEncontradoException;
import br.com.hdi.exception.UsuarioNaoEncontradoException;
import br.com.hdi.model.Contato;
import br.com.hdi.model.Usuario;
import br.com.hdi.repository.ContatoRepository;
import br.com.hdi.repository.UsuarioRepository;
import br.com.hdi.rest.request.ContatoRequest;
import br.com.hdi.rest.response.ContatoResponse;
import br.com.hdi.rest.response.UsuarioResponse;
import br.com.hdi.service.ContatoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ContatoServiceImpl(
            ContatoRepository contatoRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.contatoRepository = contatoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<ContatoResponse> listAll() {

        List<Contato> contatos = contatoRepository.findAll();

        List<ContatoResponse> contatosResponse = new ArrayList<>(contatos.size());
        contatos.forEach(contato -> contatosResponse.add(get(contato)));
        return contatosResponse;
    }

    @Override
    public void save(ContatoRequest request) {
        contatoRepository.save(create(request));
    }

    @Override
    public ContatoResponse update(ContatoRequest request) {
        return get(contatoRepository.save(create(request)));
    }

    @Override
    public void delete(Integer id) {
        Optional<Contato> contato = contatoRepository.findById(id);

        if (contato.isEmpty()) {
            throw new ContatoNaoEncontradoException("Contato não encontrado.");
        }

        contatoRepository.deleteById(id);
    }

    @Override
    public ContatoResponse searchById(Integer id) {
        Optional<Contato> contato = contatoRepository.findById(id);

        if (contato.isEmpty()) {
            throw new ContatoNaoEncontradoException("Contato não encontrado.");
        }

        return get(contatoRepository.getOne(id));
    }

    private ContatoResponse get(Contato contato) {
        return new ContatoResponseBuilder()
                .with($contato -> {
                    $contato.id = contato.getId();
                    $contato.email = contato.getEmail();
                    $contato.telefone = contato.getTelefone();
                    $contato.flagPrincipal = contato.isFlagPrincipal();
                    $contato.usuario = getUsuario(contato.getUsuario());
                }).build();
    }

    private UsuarioResponse getUsuario(Usuario usuario) {
        return new UsuarioResponseBuilder()
                .with($usuario -> {
                    $usuario.documento = usuario.getDocumento();
                    $usuario.nome = usuario.getNome();
                }).build();
    }

    private Contato create(ContatoRequest request) {
        return new ContatoBuilder()
                .with($contato -> {
                    $contato.id = request.getId();
                    $contato.email = request.getEmail();
                    $contato.telefone = request.getEmail();
                    $contato.flagPrincipal = request.isFlagPrincipal();
                    $contato.usuario = getUsuario(request.getUsuarioId());
                }).build();
    }

    private Usuario getUsuario(Integer usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);

        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado.");
        }

        return usuario.get();
    }

}
