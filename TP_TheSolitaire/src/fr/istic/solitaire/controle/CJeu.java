package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PJeu;
import solitaire.application.Solitaire;
import solitaire.application.Usine;

public class CJeu extends Solitaire {

	PJeu presentation;
	
	public CJeu(Usine factory) {
		super("moteurSolitaire", factory);
		presentation = new PJeu(this);
	}
	
	public void initJeu(){

		initialiser();
		
		presentation.configSabot(this.sabot);
		
		presentation.configColonne(this.pilesAlternees);
		
		presentation.configTasCartesCol(this.pilesColorees);
	}
	
	 
}
