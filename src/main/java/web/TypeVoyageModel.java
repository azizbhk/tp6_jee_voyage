package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.typevoyage;

public class TypeVoyageModel {

     List<typevoyage> typevoyages  = new ArrayList<>(); 
    public List<typevoyage> gettypevoyages() {
        return this.typevoyages ;
    }

        
    public void settypevoyages(List<typevoyage> typevoyage) { 
        this.typevoyages  = typevoyage;
    }


	public TypeVoyageModel() {
		super();
	}
}
