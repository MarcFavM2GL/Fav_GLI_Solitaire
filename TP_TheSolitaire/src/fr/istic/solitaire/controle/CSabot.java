package fr.istic.solitaire.controle;

import java.util.ArrayList;

import fr.istic.solitaire.presentation.PSabot;
import solitaire.application.Carte;
import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;

//@description	Classe de controle du sabot
public class CSabot extends Sabot{

	PSabot presentation;
	CCarte carteDragger;
	CTasDeCartes tasDragger;
	
	public CSabot(String nom, Usine factory) {
		super(nom, factory);
		presentation = new PSabot(this, 
				((CTasDeCartes)cachees).getPresentation(), 
				((CTasDeCartes)visibles).getPresentation());
	}
	
	public void setReserve(Tas t){
		super.setReserve(t);
		if(isCarteRetournable()){
			presentation.activerRetournerCarte();
			presentation.desactiverRetournerTas();
		}
	}
	
	public void retournerCarte(){
		
		try{
			presentation.initDecalageTasVisible();
			super.retournerCarte();
			super.retournerCarte();
			super.retournerCarte();
			
		} catch (Exception e) {
			System.err.println("retournerCarte dans CSabot impossible !!!");
			e.printStackTrace();
		}
		
		if(isRetournable()){
			presentation.desactiverRetournerCarte();
			presentation.activerRetournerTas();
		}
	}
	
	public void retourner(){
		try {
			super.retourner();
		} catch (Exception e) {
			System.err.println("retourner dans CSabot impossible !!!");
		}
		
		if(!isRetournable()){
			presentation.desactiverRetournerTas();
		}
		if(isCarteRetournable()){
			presentation.activerRetournerCarte();
		}
	}
	
	public void depiler(){
		try {
			super.depiler();
		} catch (Exception e) {
			System.err.println("depiler dans CSabot impossible !!!");
		}
		
		if(!isRetournable()){
			presentation.desactiverRetournerTas();
		}
	}
	
	public PSabot getPresentation(){
		return presentation;
	}

	public void p2c_debutDragNDrop(CCarte cc){
		
		ArrayList<Carte> listeCartesRecup = new ArrayList<Carte>();
		
		try {
			
			tasDragger = new CTasDeCartes("tmp", new CUsine(), true);
			tasDragger.configTasVisuDuDnD();
			
			while(cc != getSommet()){
				listeCartesRecup.add(getSommet());
				depiler();
			}
			listeCartesRecup.add(getSommet());
			depiler();
			
			for(int i = (listeCartesRecup.size() - 1); i >= 0; i--){
				tasDragger.empiler(listeCartesRecup.get(i));
			}
			
			presentation.c2p_debutDragNDrop_OK(tasDragger);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void p2c_endDragNDrop(boolean success){
		if(!success){
			empiler(tasDragger);
		}
	}
	
}
