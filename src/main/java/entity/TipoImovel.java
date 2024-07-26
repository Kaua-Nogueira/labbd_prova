package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public @Data class TipoImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 256)
    private String descricao;

    @OneToMany(mappedBy = "tipoImovel")
    private Set<Imovel> imoveis;
}
