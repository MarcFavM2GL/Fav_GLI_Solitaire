package fr.istic.solitaire.controle;

import fr.istic.solitaire.presentation.PSabot;
import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;

public class CSabot extends Sabot{

	PSabot presentation;
	CCarte carteDragger;
	
	public CSabot(String nom, Usine factory) {
		super(nom, factory);
		presentation = new PSabot(this, 
				((CTasDeCartes)cachees).getPresentation(), 
				((CTasDeCartes)visibles).getPresentation());
	}
	
	public void setReserve(Tas t){
		super.setReserve(t);
		if(isCarteRetournable()){
			presentation.activerRetournerCarte();
			presentation.desactiverRetournerTas();
		}
	}
	
	public void retournerCarte(){
		
		try{
			presentation.initDecalageTasVisible();
			super.retournerCarte();
			super.retournerCarte();
			super.retournerCarte();
			
		} catch (Exception e) {
			System.err.println("retournerCarte dans CSabot impossible !!!");
			e.printStackTrace();
		}
		
		if(isRetournable()){
			presentation.desactiverRetournerCarte();
			presentation.activerRetournerTas();
		}
	}
	
	public void retourner(){
		try {
			super.retourner();
		} catch (Exception e) {
			System.err.println("retourner dans CSabot impossible !!!");
		}
		
		if(!isRetournable()){
			presentation.desactiverRetournerTas();
		}
		if(isCarteRetournable()){
			presentation.activerRetournerCarte();
		}
	}
	
	public void depiler(){
		try {
			super.depiler();
		} catch (Exception e) {
			System.err.println("depiler dans CSabot impossible !!!");
		}
		
		if(!isRetournable()){
			presentation.desactiverRetournerTas();
		}
	}
	
	public PSabot getPresentation(){
		return presentation;
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
