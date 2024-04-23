package daoo;

import java.util.List;

import metier.entities.voyage;

public interface IvoyageDAO {
	public voyagesave(voyagep);
	public List<voyage> voyageParMC(String mc);
	public voyagegetvoyage(Long id);
	public voyageupdatevoyage(voyagep);
	public void deletevoyage(Long id);
}


