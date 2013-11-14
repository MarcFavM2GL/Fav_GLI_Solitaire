package fr.istic.solitaire.controle;

import java.util.ArrayList;
import java.util.Iterator;

import fr.istic.solitaire.presentation.PColonne;
import solitaire.application.Carte;
import solitaire.application.Tas;
import solitaire.application.Colonne;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CColonne extends Colonne{

	PColonne presentation;
	CCarte carteDragger;
	CTasDeCartes tasDragger;
	
	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		presentation = new PColonne(this,
				((CTasDeCartes)cachees).getPresentation(),
				((CTasDeCartesAlternees)visibles).getPresentation());
		
		presentation.activerRetournerCarte();
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
		}else{
			if(isCarteRetournable()){
				presentation.activerRetournerCarteSurTasVis();
			}
		}
	}

	@Override
	public void retournerCarte() throws Exception {
		super.retournerCarte();
		presentation.desactiverRetournerCarteSurTasVis();
	}
	
	public PColonne getPresentation(){
		return presentation;
	}
}
