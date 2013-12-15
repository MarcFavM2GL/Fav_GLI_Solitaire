package fr.istic.solitaire.controle;

import java.util.ArrayList;
import fr.istic.solitaire.presentation.PColonne;
import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Usine;

//@description	Classe de controle de la colonne
public class CColonne extends Colonne{

	PColonne presentation;
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
			
			((CTasDeCartesAlternees)visibles).activationInfosDrop(false);
			presentation.c2p_debutDragNDrop_OK(tasDragger);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void p2c_endDragNDrop(boolean success){
		((CTasDeCartesAlternees)visibles).activationInfosDrop(true);
		if(!success){
			empiler(tasDragger);
		}else{
			if(isCarteRetournable()){
				try {
					retournerCarte();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

	@Override
	public void retournerCarte() throws Exception {
		super.retournerCarte();
		//presentation.desactiverRetournerCarteSurTasVis();
	}
	
	public PColonne getPresentation(){
		return presentation;
	}
}
