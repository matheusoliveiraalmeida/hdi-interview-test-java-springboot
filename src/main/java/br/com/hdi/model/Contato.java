package br.com.hdi.model;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contatos")
@Getter
public class Contato {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String telefone;

    @Column
    private boolean flagPrincipal;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Contato() {}

    public Contato(
            Integer id,
            String email,
            String telefone,
            boolean flagPrincipal,
            Usuario usuario
    ) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.flagPrincipal = flagPrincipal;
        this.usuario = usuario;
    }

}
