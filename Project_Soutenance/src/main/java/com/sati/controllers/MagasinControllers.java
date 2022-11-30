package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sati.model.Magasin;
import com.sati.service.Iservice;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MagasinControllers {

	@Autowired 
	Iservice service;
	private Magasin magasin = new Magasin();
	
	
	private List<Magasin> listTable = new ArrayList<Magasin>();
	private Magasin selectedMagasin = new Magasin();
	
	
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
		this.service.addObject(magasin);
		this.info("Enregistrement effectuée avec succès!");
		this.annuler();
	}
	
	public void supprimer() {
		this.service.deleteObject(magasin);
		this.annuler();
	}
	
	public void annuler() {
		this.magasin.setNomMagasin(null);
		this.enregistrerBtn.setDisabled(true);
		this.modifierBtn.setDisabled(false);
	}
	
	public void modifier() {
		this.service.addObject(magasin);
		this.info("Modification effectuée avec succès!");
		this.annuler();
	}
	
	public void selectionnerLigne() {
		setMagasin(selectedMagasin);
		this.enregistrerBtn.setDisabled(true);
		this.modifierBtn.setDisabled(false);
	}
	
	//getter & setter
	public Magasin getMagasin() {
		return magasin;
		
	}
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
		
	}
	@SuppressWarnings("unchecked")
	public List<Magasin> getListTable() {
		listTable = service.getObjects("Magasin");
		System.out.println("=================Taille de laliste: "+listTable.size());
		return listTable;
		
	}
	public void setListTable(List<Magasin> listTable) {
		this.listTable = listTable;
		
	}
	public Magasin getSelectedMagasin() {
		return selectedMagasin;
		
	}
	public void setSelectedMagasin(Magasin selectedMagasin) {
		this.selectedMagasin = selectedMagasin;
		
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
