package fr.istic.solitaire.abstraction;

import fr.istic.solitaire.controle.CJeu;
import fr.istic.solitaire.controle.CUsine;

//@authors Marc Favereau
//@version 1.0.0

public class MonSolitaire {

	//@description	Point de lancement de l'application
	//@param		NULL
	//@return 		void 
public static void main(String[] args) {
	
	CUsine maFactory = new CUsine();
	CJeu ctrlJeu = new CJeu(maFactory);

	ctrlJeu.initJeu();

	}
}
