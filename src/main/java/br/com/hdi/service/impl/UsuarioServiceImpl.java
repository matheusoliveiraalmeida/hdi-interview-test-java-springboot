package br.com.hdi.service.impl;

import br.com.hdi.builder.ContatoResponseBuilder;
import br.com.hdi.builder.UsuarioBuilder;
import br.com.hdi.builder.UsuarioResponseBuilder;
import br.com.hdi.exception.ContatoNaoEncontradoException;
import br.com.hdi.exception.UsuarioNaoEncontradoException;
import br.com.hdi.model.Contato;
import br.com.hdi.model.Usuario;
import br.com.hdi.repository.ContatoRepository;
import br.com.hdi.repository.UsuarioRepository;
import br.com.hdi.rest.request.UsuarioRequest;
import br.com.hdi.rest.response.UsuarioResponse;
import br.com.hdi.rest.response.ContatoResponse;
import br.com.hdi.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ContatoRepository contatoRepository;

    @Autowired
    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            ContatoRepository contatoRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.contatoRepository = contatoRepository;
    }

    @Override
    public List<UsuarioResponse> listAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioResponse> usuariosResponses = new ArrayList<>(usuarios.size());
        usuarios.forEach(usuario -> usuariosResponses.add(getUsuario(usuario)));
        return usuariosResponses;
    }

    @Override
    public void save(UsuarioRequest request) {
        usuarioRepository.save(create(request));
    }

    @Override
    public UsuarioResponse update(UsuarioRequest request) {
        Optional<Usuario> usuario = usuarioRepository.findById(request.getDocumento());
        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado.");
        }

        Usuario usuarioUpdated = create(request);
        return getUsuario(usuarioRepository.save(usuarioUpdated));
    }

    @Override
    public void delete(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado.");
        }

        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponse searchById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado.");
        }

        return getUsuario(usuarioRepository.getOne(id));
    }

    private UsuarioResponse getUsuario(Usuario usuario) {
        return new UsuarioResponseBuilder()
                .with($usuario -> {
                    $usuario.documento = usuario.getDocumento();
                    $usuario.nome = usuario.getNome();
                    $usuario.contatos = getContato(usuario.getContatos());
                }).build();
    }

    private List<ContatoResponse> getContato(List<Contato> contatos) {
        List<ContatoResponse> contatosResponses = new ArrayList<>();
        contatos.forEach(contato -> contatosResponses.add(new ContatoResponseBuilder()
                .with($contato -> {
                    $contato.id = contato.getId();
                    $contato.email = contato.getEmail();
                    $contato.telefone = contato.getTelefone();
                    $contato.flagPrincipal = contato.isFlagPrincipal();
                }).build()
        ));
        return contatosResponses;
    }

    private Usuario create(UsuarioRequest request) {
        return new UsuarioBuilder()
                .with($usuario -> {
                    $usuario.documento = request.getDocumento();
                    $usuario.nome = request.getNome();
                    $usuario.contatos = getContatos(request.getContatosIds());
                }).build();
    }

    private List<Contato> getContatos(List<Integer> contatoIds) {
        List<Contato> contatos = new ArrayList<>();
        if (!isEmpty(contatoIds)) {
            contatoIds.forEach(contatoId -> {
                Optional<Contato> contato = contatoRepository.findById(contatoId);
                if (contato.isEmpty()) {
                    throw new ContatoNaoEncontradoException("Contato não encontrado.");
                }
                contatos.add(contato.get());
            });
        }
        return contatos;
    }

}
