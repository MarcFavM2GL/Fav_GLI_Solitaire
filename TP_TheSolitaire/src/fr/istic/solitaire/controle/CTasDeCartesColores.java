package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PTasDeCartesColores;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.application.TasDeCartesColorees;

public class CTasDeCartesColores extends TasDeCartesColorees {

	private PTasDeCartesColores presentation;
	CCarte carteDragger;
	
	public CTasDeCartesColores(String nom, int couleur, Usine factory) {
		super(nom, couleur, factory);
		presentation = new PTasDeCartesColores(this);
	}

	public PTasDeCartesColores getPresentation(){
		return presentation;
	}
	
	public void empiler(Carte c){
		if(isEmpilable(c)){
			super.empiler(c);
			presentation.empiler(((CCarte)c).getPresentation());	
		}
	}
	
	public void depiler() throws Exception{
		Carte s;
		s = getSommet();
		super.depiler();
		presentation.depiler(((CCarte)s).getPresentation());
	}

	public void p2c_dragEnter(CCarte cc){
		if(isEmpilable(cc)){
			presentation.c2p_showEmpilable();
		}else{
			presentation.c2p_showNonEmpilable();
		}
	}

	public void p2c_dragExit(CCarte cc){
		presentation.c2p_showNeutre();
	}
	
	public void p2c_drop(CCarte cc){
		if(isEmpilable(cc)){
			empiler(cc);
			presentation.c2p_dropOK();
		}else{
			presentation.c2p_dropNonOK();
		}
		presentation.c2p_showNeutre();
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

}
