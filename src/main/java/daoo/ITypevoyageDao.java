package daoo;

import java.util.List;

import metier.entities.typevoyage;

public interface ItypevoyageDao {
	public typevoyage save(typevoyage Ens);
	public typevoyage gettypevoyage(Long id);
	public typevoyage updatetypevoyage(typevoyage Ens);
	public void deletetypevoyage(Long id);
	public List<typevoyage> getAlltypevoyage();
}
