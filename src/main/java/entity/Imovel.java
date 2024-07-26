package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public @Data class Imovel implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idProprietario;

    @ManyToOne
    @JoinColumn(name = "idTipoImovel")
    private TipoImovel tipoImovel;

    @Column(length = 200)
    private String logradouro;

    @Column(length = 45)
    private String bairro;

    @Column(length = 10)
    private String cep;

    @Column
    private Integer metragem;

    @Column
    private Integer dormitorios;

    @Column
    private Integer banheiros;

    @Column
    private Integer suites;

    @Column
    private Integer vagasGaragem;

    @Column(precision = 10, scale = 2)
    private Double valorAluguelSugerido;

    @OneToMany(mappedBy = "imovel")
    private Set<Locacao> locacoes;

    @OneToMany(mappedBy = "imovel")
    private Set<ServicosImovel> servicos;

    private String obs;

    public Imovel() {}
}
