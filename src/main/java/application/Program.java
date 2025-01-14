package application;

import domain.Pessoas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        Pessoas p0 = new Pessoas(null, "Carlos Silv", "carlos@gmail.com");
        Pessoas p1 = new Pessoas(null, "Joaquim", "joaquim@gmail.com");
        Pessoas p2 = new Pessoas(null, "Ana mARIA", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // Consulta no banco de dados
        // O em.find busca o valor no banco dados pelo ID (chave primária)
        Pessoas p = em.find(Pessoas.class, 2);
        // Acima ele fez a pesquisa no banco de dados
        //  ele converteu a tabela do banco em objeto
        //  e instancia o objeto  JPa ajuda muito nisso que faziamos
        // manualmente

        // Apagando inforamçaõ do banco de dados, lembre-se
        // de colocar o em.getTransaction porque é uma ação de escrita no banco
       em.remove(p);
       // JPA só consegue remove uma
        // IMPORTANTE: sempre que for remover uma pessoa
        // ou você precisa ter acabo de inserir ela ai você consegue remover
        // o dado no código ou você precisa primeiro
        // buscar o dado com o método find
        // e depois usar o em.remove passando a variavel do find do id da tabela
        // como parâmetro

        System.out.println(p);

        System.out.println("Commit!");
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
