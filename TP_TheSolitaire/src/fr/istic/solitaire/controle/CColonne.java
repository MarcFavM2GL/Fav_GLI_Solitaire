package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PColonne;
import solitaire.application.Tas;
import solitaire.application.Colonne;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CColonne extends Colonne{

	PColonne presentation;
	CCarte carteDragger;
	
	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		presentation = new PColonne(this,
				((CTasDeCartes)cachees).getPresentation(),
				((CTasDeCartesAlternees)visibles).getPresentation());
		
		presentation.activerRetournerCarte();
	}
	
	public void p2c_debutDragNDrop(CCarte cc){
		try {
			if(cc == getSommet()){
				carteDragger = cc;
				depiler();
				presentation.c2p_debutDragNDrop_OK(cc);
			}else{
				presentation.c2p_debutDragNDrop_NonOK();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void p2c_endDragNDrop(boolean success){
		if(!success){
			empiler(carteDragger);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	public PColonne getPresentation(){
		return presentation;
	}
}
