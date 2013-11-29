package fr.istic.solitaire.controle;

import javax.swing.JEditorPane;

import fr.istic.solitaire.abstraction.MonSolitaire;
import fr.istic.solitaire.presentation.PTasDeCartesColores;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.application.TasDeCartesColorees;

public class CTasDeCartesColores extends TasDeCartesColorees {

	private PTasDeCartesColores presentation;
	CCarte carteDragger;
	CTasDeCartes tasDragger;
	
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

	public void p2c_dragEnter(CTasDeCartes ctc){
		
		try {
			if(ctc.getNombre() != 1){
				presentation.c2p_showNonEmpilable();
			}else{
				if(isEmpilable(ctc.getSommet())){
					presentation.c2p_showEmpilable();
				}else{
					presentation.c2p_showNonEmpilable();
				}
			}
		} catch (Exception e) {
			System.err.println("Erreur dans CTasDeCartesColores --- p2c_dragEnter");
		}
	}
	

	public void p2c_dragExit(){
		presentation.c2p_showNeutre();
	}
	
	public void p2c_drop(CTasDeCartes ctc){
		try {
			if(ctc.getNombre() != 1){
				presentation.c2p_dropNonOK();
			}else{
				if(isEmpilable(ctc.getSommet())){
					empiler(ctc.getSommet());
					presentation.c2p_dropOK();
				}else{
					presentation.c2p_dropNonOK();
				}
			}
		} catch (Exception e) {
			System.err.println("Erreur dans CTasDeCartesColores --- p2c_drop");
		}
		presentation.c2p_showNeutre();
	}

	public void p2c_debutDragNDrop(CCarte cc){
		
		try {
			tasDragger = new CTasDeCartes("tmp", new CUsine(), true);
			tasDragger.configTasVisuDuDnD();
			
			if(cc == getSommet()){
				carteDragger = cc;
				depiler();
				tasDragger.empiler(cc);
				presentation.c2p_debutDragNDrop_OK(tasDragger);
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
