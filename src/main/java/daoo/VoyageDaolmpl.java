package daoo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Departement;
import util.JPAutil;

public class VoyageDaolmpl implements IVoyageDAO {
	public  EntityManager entityManager=JPAutil.getEntityManager("TP6.typevoyage_JEE2");
	@Override
	public voyagesave(voyagep) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}

	
	  @Override public List<Voyaget> VoyageParMC(String  mc) {
	  List<Voyage> prods = entityManager. createQuery("select p from voyagep where p.NOM_voyagelike :mc").setParameter("mc", "%"+mc+"%").getResultList();
	  return prods; }
	 
	
	/*
	 * @Override public List<Departement> DepartementParMC(String mc) { String
	 * jpqlQuery =
	 * "SELECT p FROM voyagep WHERE p.NOM_voyageLIKE '%voyageinformatiquezzzzzzzzzz%'"
	 * ; List<Departement> prods = entityManager.createQuery(jpqlQuery,
	 * Departement.class) .getResultList();
	 * 
	 * return prods; }
	 */
	 
	@Override
	public voyagegetVoyage(Long id) {
	return entityManager.find(Voyage.class, id);
	}
	@Override
	public voyageupdateVoyage(voyagep) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(p);
	tx.commit();
	return p;
	}
	@Override
	public void deleteVoyage(Long id) {
		voyagevoyage = entityManager.find(Voyage.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(Voyage);
	entityManager.getTransaction().commit();
	}
	
	

}