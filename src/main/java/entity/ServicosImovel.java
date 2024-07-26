package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public @Data class ServicosImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idProfissional")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "idImovel")
    private Imovel imovel;

    @Temporal(TemporalType.DATE)
    private Date dataServico;

    @Column(precision = 10, scale = 2)
    private Double valorTotal;

    @Column(length = 255)
    private String obs;

    public ServicosImovel() {}
}
