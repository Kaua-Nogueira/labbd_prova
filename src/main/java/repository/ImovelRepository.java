package repository;

import entity.Imovel;

import javax.persistence.EntityManager;
import java.util.List;

public class ImovelRepository {
    private final EntityManager manager;
    private final DAOGenerico<Imovel> daoGenerico;

    public ImovelRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Imovel porId(Integer id) {
        return daoGenerico.buscaPorId(Imovel.class, id);
    }

    public Imovel salvaOuAtualiza(Imovel imovel) {
        return daoGenerico.salvaOuAtualiza(imovel);
    }

    public void remove(Integer id) {
        daoGenerico.remove(this.porId(id));
    }

    public List<Imovel> todos() {
        return daoGenerico.buscaTodos(Imovel.class);
    }

    public List<Imovel> porBairro(String bairro) {
        return manager.createQuery("from Imovel i where i.bairro = :bairro", Imovel.class)
                .setParameter("bairro", bairro)
                .getResultList();
    }

    public List<Imovel> porValorAluguelSugerido(Double valor) {
        return manager.createQuery("from Imovel i where i.valorAluguelSugerido = :valor", Imovel.class)
                .setParameter("valor", valor)
                .getResultList();
    }
}
