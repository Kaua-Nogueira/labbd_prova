package entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
public @Data class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idImovel")
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "idInquilino")
    private Cliente inquilino;

    @Column(precision = 10, scale = 2)
    private Double valorAluguel;

    @Column(precision = 5, scale = 2)
    private Double percentualMulta;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column
    private Boolean ativo;

    @Column(length = 255)
    private String obs;

    @OneToMany(mappedBy = "locacao")
    private Set<Aluguel> alugueis;

    public Locacao() {}
}
