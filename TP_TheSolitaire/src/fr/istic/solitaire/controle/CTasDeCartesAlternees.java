package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PTasDeCartesAlternees;
import solitaire.application.Carte;
import solitaire.application.Tas;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

//@description	Classe de controle du tas de cartes alternées
public class CTasDeCartesAlternees extends TasDeCartesAlternees implements Tas {

	private PTasDeCartesAlternees presentation;
	
	public CTasDeCartesAlternees(String nom, Usine factory) {
		super(nom, factory);
		presentation = new PTasDeCartesAlternees(this);
		
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

	public void p2c_dragEnter(CTasDeCartes ctc){
		if(isEmpilable(ctc)){
			presentation.c2p_showEmpilable();
		}else{
			presentation.c2p_showNonEmpilable();
		}
	}

	public void p2c_dragExit(CTasDeCartes ctc){
		presentation.c2p_showNeutre();
	}
	
	public void p2c_drop(CTasDeCartes ctc){
		if(isEmpilable(ctc)){
			empiler(ctc);
			presentation.c2p_dropOK();
		}else{
			presentation.c2p_dropNonOK();
		}
		presentation.c2p_showNeutre();
	}
	
	public void activationInfosDrop(boolean val){
		presentation.setInfosDropVisible(val);
	}

}
