package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public @Data class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String nome;

    @Column(length = 15)
    private String cpf;

    @Column(length = 12)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column
    private Date dtNascimento;

    @OneToMany(mappedBy = "inquilino")
    private Set<Locacao> locacoes;
}
