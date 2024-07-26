package org.example;

import entity.Imovel;
import entity.TipoImovel;
import repository.ImovelRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria a fábrica de EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("labbd_prova");
        EntityManager em = emf.createEntityManager();

        // Cria o repositório
        ImovelRepository imovelRepository = new ImovelRepository(em);

        // Cria um novo TipoImovel para o exemplo
        TipoImovel tipoImovel = new TipoImovel();
        tipoImovel.setDescricao("Apartamento");

        // Persistir o TipoImovel
        em.getTransaction().begin();
        em.persist(tipoImovel);
        em.getTransaction().commit();

        // Cria um novo Imovel
        Imovel novoImovel = new Imovel();
        novoImovel.setIdProprietario(1);
        novoImovel.setTipoImovel(tipoImovel);
        novoImovel.setLogradouro("Rua Exemplo");
        novoImovel.setBairro("Centro");
        novoImovel.setCep("12345-678");
        novoImovel.setMetragem(100);
        novoImovel.setDormitorios(3);
        novoImovel.setBanheiros(2);
        novoImovel.setSuites(1);
        novoImovel.setVagasGaragem(2);
        novoImovel.setValorAluguelSugerido(1500.00);
        novoImovel.setObs("Imovel de teste");

        // Salva o Imovel
        em.getTransaction().begin();
        Imovel imovelSalvo = imovelRepository.salvaOuAtualiza(novoImovel);
        em.getTransaction().commit();

        // Consulta o Imovel pelo ID
        Imovel imovelConsultado = imovelRepository.porId(imovelSalvo.getId());
        System.out.println("Imovel Consultado: " + imovelConsultado);

        // Consulta todos os Imoveis
        List<Imovel> todosImoveis = imovelRepository.todos();
        todosImoveis.forEach(imovel -> System.out.println("Imovel: " + imovel));

        // Consulta por bairro
        List<Imovel> imoveisPorBairro = imovelRepository.porBairro("Centro");
        imoveisPorBairro.forEach(imovel -> System.out.println("Imovel no Centro: " + imovel));

        // Consulta por valor de aluguel sugerido
        List<Imovel> imoveisPorValor = imovelRepository.porValorAluguelSugerido(1500.00);
        imoveisPorValor.forEach(imovel -> System.out.println("Imovel com valor de aluguel sugerido de 1500.00: " + imovel));

//        // Remove o Imovel
//        em.getTransaction().begin();
//        imovelRepository.remove(imovelConsultado.getId());
//        em.getTransaction().commit();

        // Fecha o EntityManager
        em.close();
        emf.close();
    }
}
