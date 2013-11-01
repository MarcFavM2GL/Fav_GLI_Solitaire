package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PColonne;
import solitaire.application.Tas;
import solitaire.application.Colonne;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CColonne extends Colonne{

	PColonne presentation;
	
	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		presentation = new PColonne(this,
				((CTasDeCartes)cachees).getPresentation(),
				((CTasDeCartesAlternees)visibles).getPresentation());
		
		presentation.activerRetournerCarte();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	public PColonne getPresentation(){
		return presentation;
	}
}
