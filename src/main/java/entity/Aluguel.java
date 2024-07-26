package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public @Data class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idLocacao")
    private Locacao locacao;

    @Column
    private Date dataVencimento;

    @Column(precision = 10, scale = 2)
    private Double valorPago;

    @Column
    private Date dataPagamento;

    @Column
    private String obs;
}
