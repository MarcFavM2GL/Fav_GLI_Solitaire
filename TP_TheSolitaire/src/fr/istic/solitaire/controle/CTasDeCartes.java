package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PTasDeCartes;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;

public class CTasDeCartes extends TasDeCartes {
	
	private PTasDeCartes presentation;

	public CTasDeCartes(String nom, Usine factory) {
		super(nom, factory);
		presentation = new PTasDeCartes();
		
	}
	
	public CTasDeCartes(String nom, Usine factory, boolean avecCtrl) {
		super(nom, factory);
		if(avecCtrl){
			presentation = new PTasDeCartes(this);
		}else{
			presentation = new PTasDeCartes();
		}
	}
	
	
	
	public PTasDeCartes getPresentation(){
		return presentation;
	}
	
	public void empiler(Carte c){
		if(isEmpilable(c)){
			super.empiler(c);
				try {
					if(c==getSommet()){
						presentation.empiler(((CCarte)c).getPresentation());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		}
		
	}
	
	public void depiler() throws Exception{
		Carte s;
		s = getSommet();
		super.depiler();
		presentation.depiler(((CCarte)s).getPresentation());
	}
	
	public void configTasVisuDuDnD(){
		presentation.setMarges(0, 0);
		presentation.setDxDy(0, 25);
	}

}
