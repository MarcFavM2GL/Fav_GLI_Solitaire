package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PTasDeCartesAlternees;
import solitaire.application.Carte;
import solitaire.application.Tas;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements Tas {

	private PTasDeCartesAlternees presentation;
	
	public CTasDeCartesAlternees(String nom, Usine factory) {
		super(nom, factory);
		presentation = new PTasDeCartesAlternees();
		
	}

	public PTasDeCartesAlternees getPresentation(){
		return presentation;
	}
	
	public void empiler(Carte c){
		try {
			super.empiler(c);
			if(c==getSommet()){
				presentation.empiler(((CCarte)c).getPresentation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void depiler() throws Exception{
		Carte s;
		s = getSommet();
		super.depiler();
		presentation.depiler(((CCarte)s).getPresentation());
		}
}
