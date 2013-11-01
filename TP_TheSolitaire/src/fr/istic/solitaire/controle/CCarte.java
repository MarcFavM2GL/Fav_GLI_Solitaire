package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PCarte;
import solitaire.application.*;

public class CCarte extends Carte{
	private PCarte presentation;
	
	public CCarte(int valeur, int couleur) {
		super(Math.min(Math.max(1, valeur), 13),
				Math.min(Math.max(couleur, 1), 4));
		presentation = new PCarte(this, valeurs[getValeur()-1] + couleurs[getCouleur()-1]);
		presentation.setFaceVisible(isFaceVisible());
		
	}

	public void setFaceVisible(boolean b){
		super.setFaceVisible(b);
		presentation.setFaceVisible(isFaceVisible());
	}
	
	public PCarte getPresentation(){
		return presentation;
	}
}
