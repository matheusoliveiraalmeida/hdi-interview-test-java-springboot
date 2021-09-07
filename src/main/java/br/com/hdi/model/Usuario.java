package br.com.hdi.model;


import lombok.Getter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "usuarios")
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer documento;

    @Column
    private String nome;

    @OneToMany(mappedBy = "usuario", cascade = { PERSIST, REMOVE }, fetch = LAZY)
    private List<Contato> contatos;

    public Usuario() {}

    public Usuario(
            Integer documento,
            String nome,
            List<Contato> contatos
    ) {
        this.documento = documento;
        this.nome = nome;
        this.contatos = contatos;
    }

}
