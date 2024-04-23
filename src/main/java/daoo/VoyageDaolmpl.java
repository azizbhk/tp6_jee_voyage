package daoo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.voyage;
import util.JPAutil;

public class voyageDaolmpl implements IvoyageDAO {
	public  EntityManager entityManager=JPAutil.getEntityManager("TP6.typevoyage_JEE2");
	@Override
	public voyagesave(voyagep) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}

	
	  @Override public List<voyage> voyageParMC(String  mc) {
	  List<voyage> prods = entityManager. createQuery("select p from voyagep where p.NOM_voyagelike :mc").setParameter("mc", "%"+mc+"%").getResultList();
	  return prods; }
	 
	
	/*
	 * @Override public List<voyage> voyageParMC(String mc) { String
	 * jpqlQuery =
	 * "SELECT p FROM voyagep WHERE p.NOM_voyageLIKE '%voyageinformatiquezzzzzzzzzz%'"
	 * ; List<voyage> prods = entityManager.createQuery(jpqlQuery,
	 * voyage.class) .getResultList();
	 * 
	 * return prods; }
	 */
	 
	@Override
	public voyagegetvoyage(Long id) {
	return entityManager.find(voyage.class, id);
	}
	@Override
	public voyageupdatevoyage(voyagep) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(p);
	tx.commit();
	return p;
	}
	@Override
	public void deletevoyage(Long id) {
		voyagevoyage = entityManager.find(voyage.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(voyage);
	entityManager.getTransaction().commit();
	}
	
	

}
