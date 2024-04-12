package daoo;

import java.util.List;

import metier.entities.Departement;

public interface IDepartementDAO {
	public voyagesave(voyagep);
	public List<Departement> DepartementParMC(String mc);
	public voyagegetDepartement(Long id);
	public voyageupdateDepartement(voyagep);
	public void deleteDepartement(Long id);
}


