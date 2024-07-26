package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public @Data class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String nome;

    @Column(length = 45)
    private String profissao;

    @Column(length = 14)
    private String telefone;

    @Column(precision = 10, scale = 2)
    private Double valorHoraTrabalhada;

    @OneToMany(mappedBy = "profissional")
    private Set<ServicosImovel> servicos;

    public Profissional() {}
}
