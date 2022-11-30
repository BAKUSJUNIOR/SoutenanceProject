package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sati.model.TypeMateriel;
import com.sati.service.Iservice;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class TypeMaterielControllers {

	@Autowired
	Iservice service;
	private TypeMateriel typemateriel = new TypeMateriel();
	private List<TypeMateriel> listTable = new ArrayList<TypeMateriel>();
	private TypeMateriel selectedTypeMateriel = new TypeMateriel();
	
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
		this.service.addObject(typemateriel);
		this.info("Enregistrement effectuée avec succès!");
		this.annuler();
	}
	
	
	public void supprimer() {
		this.service.deleteObject(typemateriel);
		this.annuler();
		
	}
	public void selectionnerLigne() {
		setTypemateriel(selectedTypeMateriel);
		this.enregistrerBtn.setDisabled(true);
		this.annulerBtn.setDisabled(false);
	}
	
	public void annuler() {
		this.typemateriel.setNomTypemat(null);
		this.enregistrerBtn.setDisabled(true);
		this.modifierBtn.setDisabled(false);
	}
	
	public void modifier() {
		this.service.addObject(typemateriel);
		this.info("Modification effectuée avec succès!");
		this.annuler();
	}
	
	
	
	
	
//getters et setters
	public TypeMateriel getTypemateriel() {
		return typemateriel;
		
	}
	public void setTypemateriel(TypeMateriel typemateriel) {
		this.typemateriel = typemateriel;
		
	}
	@SuppressWarnings("unchecked")
	public List<TypeMateriel> getListTable() {
		listTable = service.getObjects("TypeMateriel");
		System.out.println("=================Taille de laliste: "+listTable.size());
		return listTable;
		
	}
	public void setListTable(List<TypeMateriel> listTable) {
		this.listTable = listTable;
		
	}
	public TypeMateriel getSelectedTypeMateriel() {
		return selectedTypeMateriel;
		
	}
	public void setSelectedTypeMateriel(TypeMateriel selectedTypeMateriel) {
		this.selectedTypeMateriel = selectedTypeMateriel;
		
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
	
}
