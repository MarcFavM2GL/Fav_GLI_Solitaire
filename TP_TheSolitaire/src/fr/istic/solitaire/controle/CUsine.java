package fr.istic.solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.DoubleTas;
import solitaire.application.Sabot;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

//@description	Classe de controle de l'usine
public class CUsine extends Usine{
	
	@Override
	public Solitaire newSolitaire(String nom, Usine factory){
		return new CSolitaire(nom, factory);
	}
	
	public Carte newCarte(int valeur, int couleur){
		return new CCarte(valeur, couleur);
	}
	
	public TasDeCartes newTasDeCartes(String name, Usine factory){
		return new CTasDeCartes(name, factory);	
	}
	
	public TasDeCartes newTasDeCartes(String name, Usine factory, boolean avecCtrl){
		return new CTasDeCartes(name, factory, avecCtrl);	
	}
	
	public TasDeCartesAlternees newTasDeCartesAlternees(String name, Usine factory){
		return new CTasDeCartesAlternees(name, factory);
	}
	
	public TasDeCartesColorees newTasDeCartesColorees(String name,int color, Usine factory){
		return new CTasDeCartesColores(name, color, factory);
		
	}
	
	public Sabot newSabot(String name, Usine factory){
		return new CSabot(name, factory);	
	}
	
	public Colonne newColonne(String name, Usine factory){
		return new CColonne(name, factory);
	}

	public DoubleTas newDoubleTas(TasDeCartes cache, TasDeCartes visible){
		return new DoubleTas(cache, visible);
	}
}
