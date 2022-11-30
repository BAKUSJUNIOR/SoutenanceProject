package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sati.model.Magasin;
import com.sati.model.Materiels;
import com.sati.model.TypeMateriel;
import com.sati.service.Iservice;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MaterielsControllers {
	
	@Autowired 
	Iservice service;
	private Materiels materiels = new Materiels();
	private Magasin magasin = new Magasin();
	private TypeMateriel typeMateriel = new TypeMateriel();
	
	private int idMateriel;
	private int idTypemat;
	private int idMagasin;
	private String nomTypemat;
	private String nomMagasin;
	
	

	private List<Materiels> listMateriels = new ArrayList<Materiels>();
	private List<Magasin> listMagasin = new ArrayList<Magasin>();
	private List<TypeMateriel> listTypeMateriel = new ArrayList<>();
	
	private Materiels selectedMateriels = new Materiels();
	
	private CommandButton enregistrerBtn = new CommandButton();
	private CommandButton annulerBtn = new CommandButton();
	private CommandButton modifierBtn = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		modifierBtn.setDisabled(true);
	}
	
	public void info(String monMessage) {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, monMessage ,null ));
	}
	
	public void enregistrer() {
		//pousser en base de donnéees
		
		magasin = (Magasin) service.getObjectById(idMagasin, null);
		typeMateriel = (TypeMateriel) service.getObjectById(idTypemat, null);
		materiels.setMagasin(magasin);
		materiels.setTypeMateriel(typeMateriel);
		
		this.service.addObject(materiels);
		this.info("Enregistrement effectuée avec succès!");
		this.annuler();
	}
	
	
	public void supprimer() {
		this.service.deleteObject(materiels);
		this.annuler();
	}
	
	public void annuler() {
		this.materiels.setEmplacement(null);
		this.materiels.setLibelle(null);
		this.materiels.setQte(0);
		this.materiels.setReference(null);
		this.materiels.setUtilisateur(null);
		materiels.setMagasin(magasin);
		materiels.setTypeMateriel(typeMateriel);
		
	}
	
	public void modifier () {
		this.service.addObject(materiels);
		this.info("Modification effectuée avec succès!");
		this.annuler();
	}
	
	public void selectionnerLigne() {
		setMateriels(selectedMateriels);
		this.enregistrerBtn.setDisabled(true);
		this.modifierBtn.setDisabled(false);
	}
	
	//getter & setter
	public Materiels getMateriels() {
		return materiels;
		
	}
	public void setMateriels(Materiels materiels) {
		this.materiels = materiels;
		
	}
	@SuppressWarnings("unchecked")
	public List<Materiels> getListMateriels() {
		listMateriels = service.getObjects("Materiels");
		System.out.println("=================Taille de laliste: "+listMateriels.size());
		return listMateriels;
		
	}
	public void setListMateriels(List<Materiels> listMateriels) {
		this.listMateriels = listMateriels;
		
	}
	public CommandButton getEnregistrerBtn() {
		return enregistrerBtn;
		
	}
	public void setEnregistrerBtn(CommandButton enregistrerBtn) {
		this.enregistrerBtn = enregistrerBtn;
		
	}
	public CommandButton getAnnulerBtn() {
		return annulerBtn;
		
	}
	public void setAnnulerBtn(CommandButton annulerBtn) {
		this.annulerBtn = annulerBtn;
		
	}
	public CommandButton getModifierBtn() {
		return modifierBtn;
		
	}
	public void setModifierBtn(CommandButton modifierBtn) {
		this.modifierBtn = modifierBtn;
		
	}

	public Materiels getSelectedMateriels() {
		return selectedMateriels;
		
	}

	public void setSelectedMateriels(Materiels selectedMateriels) {
		this.selectedMateriels = selectedMateriels;
		
	}

	public Magasin getMagasin() {
		return magasin;
		
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
		
	}

	public TypeMateriel getTypeMateriel() {
		return typeMateriel;
		
	}

	public void setTypeMateriel(TypeMateriel typeMateriel) {
		this.typeMateriel = typeMateriel;
		
	}

	public int getIdMateriel() {
		return idMateriel;
		
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
		
	}

	public int getIdTypemat() {
		return idTypemat;
		
	}

	public void setIdTypemat(int idTypemat) {
		this.idTypemat = idTypemat;
		
	}

	public int getIdMagasin() {
		return idMagasin;
		
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
		
	}

	@SuppressWarnings("unchecked")
	public List<Magasin> getListMagasin() {
		listMagasin = service.getObjects("Magasin");
		System.out.println("=================Taille de laliste: "+listMagasin.size());
		return listMagasin;
		
	}

	public void setListMagasin(List<Magasin> listMagasin) {
		this.listMagasin = listMagasin;
		
	}

	@SuppressWarnings("unchecked")
	public List<TypeMateriel> getListTypeMateriel() {
		listTypeMateriel = service.getObjects("TypeMateriel");
		System.out.println("=================Taille de laliste: "+listTypeMateriel.size());
		return listTypeMateriel;
		
	}

	public void setListTypeMateriel(List<TypeMateriel> listTypeMateriel) {
		this.listTypeMateriel = listTypeMateriel;
		
	}

	public String getNomTypemat() {
		return nomTypemat;
		
	}

	public void setNomTypemat(String nomTypemat) {
		this.nomTypemat = nomTypemat;
		
	}

	public String getNomMagasin() {
		return nomMagasin;
		
	}

	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
		
	}


	

}
