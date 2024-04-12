package daoo;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.typevoyage;
import metier.entities.typevoyage;
import util.JPAutil;

public class typevoyageDaoImpl implements ItypevoyageDao {
// TP6_JEE à replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
	private EntityManager entityManager = JPAutil.getEntityManager("TP6.typevoyage_JEE2");

	public typevoyage save(typevoyage col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(col);
		tx.commit();
		return col;
	}

	public typevoyage getEnseignant(Long id) {
		return entityManager.find(typevoyage.class, id);
	}




	public typevoyage updateEnseignant(typevoyage col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(col);
		tx.commit();
		return col;
	}


	
	public List<typevoyage> getAllEnseignant() {
		List<typevoyage> col = entityManager.createQuery("select c from typevoyage c").getResultList();
		return col;
	}

	@Override
	public typevoyage gettypevoyage(Long id) {
		return entityManager.find(typevoyage.class, id);

	}

	@Override
	public typevoyage updatetypevoyage(typevoyage col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(col);
		tx.commit();
		return col;
	}

	@Override
	public void deletetypevoyage(Long id) {
		typevoyage typevoyage = entityManager.find(typevoyage.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(typevoyage);
		 entityManager.getTransaction().commit();
		
		
	}

	@Override
	public List<typevoyage> getAlltypevoyage() {
		List<typevoyage> col = entityManager.createQuery("select c from typevoyage c").getResultList();
		return col;
	}
}
