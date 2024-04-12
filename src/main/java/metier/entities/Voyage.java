package metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Voyage")
public class Voyageimplements Serializable{
	@Id
	@Column (name="ID_Voyage")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long ID_voyage;
	@Column (name="NOM_voyage")
	private String NOM_voyage;
	private int Nb_employee;

     
		
		  private TypeVoyage TypeVoyage ;
		 
	
	public Voyage()
	{	super();
	}
	public Voyage(String NOM_Voyage, int Nb_employee , voyage voy) {
	
	this.NOM_voyage= NOM_voyage;
	this.Nb_employee = Nb_employee;
	this.setTypeVoyage(col);
	}
	
	public Long getID_voyage() {
		return ID_voyage;
	}
	public void setID_voyage(Long iD_voyage) {
		ID_voyage= iD_voyage;
	}
	public String getNOM_voyage() {
		return NOM_voyage;
	}
	public void setNOM_voyage(String nOM_voyage) {
		NOM_voyage= nOM_voyage;
	}
	public int getNb_employee() {
		return Nb_employee; 
	}
	public void setNb_employee(int nb_employee) {
		Nb_employee = nb_employee;
	}
	
	public TypeVoyage getTypeVoyage() {
		return TypeVoyage;
	}
	public void setTypeVoyage(TypeVoyage TypeVoyage) {
		this.TypeVoyage = TypeVoyage;
	}
	@Override
	public String toString() {
		return "Voyage[ID_voyage=" + ID_voyage+ ", NOM_voyage=" + NOM_voyage
				+ ", Nb_employee=" + Nb_employee + ", TypeVoyage=" + TypeVoyage + "]";
	}
	
	

	
	
}
	