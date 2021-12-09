package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Instanciar os objetos
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Persistir os objetos no banco
		//em.getTransaction().begin();		
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);		
		//em.getTransaction().commit();
		
		//Buscar um dado no banco pelo id
		//Pessoa p = em.find(Pessoa.class, 2);
		//System.out.println(p);
		
		//Apagar uma pessoa do banco, para isso tem que ser uma entidade monitorada
		//(acabou de ser inserida ou acabou de ser buscada)
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!!!");
		em.clear();
		emf.close();
	}

}
