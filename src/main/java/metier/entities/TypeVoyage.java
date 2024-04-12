package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class voyage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcol;
    private String nomcol;

    @Temporal(TemporalType.DATE)
    private Date dateAffection;
    
    @OneToMany(mappedBy = "typevoyage")


    private List<voyage> voyages;

    public typevoyage() {
        // Default constructor required by JPA
    }

    public typevoyage(String nomcol, Date dateAffection) {
        this.nomcol = nomcol;
        this.dateAffection = dateAffection;
    }

    // Getters and setters
    public Long getIdcol() {
        return idcol;
    }

    public void setIdcol(Long idcol) {
        this.idcol = idcol;
    }

    public String getNomcol() {
        return nomcol;
    }

    public void setNomcol(String nomcol) {
        this.nomcol = nomcol;
    }

    public Date getDateAffection() {
        return dateAffection; 
    }

    public void setDateAffection(Date dateAffection) {
        this.dateAffection = dateAffection;
    }

    public List<voyage> getvoyages() {
        return voyages;
    }

    public void setvoyages(List<voyage> voyages) {
        this.voyages = voyages;
    }

	@Override
	public String toString() {
		return "typevoyage [idcol=" + idcol + ", nomcol=" + nomcol + ", dateAffection=" + dateAffection + ", voyages="
				+ voyages + "]";
	}

	
    
}
