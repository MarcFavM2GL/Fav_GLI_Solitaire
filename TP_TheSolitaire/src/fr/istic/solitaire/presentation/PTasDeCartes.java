package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.istic.solitaire.controle.CTasDeCartes;

public class PTasDeCartes extends JPanel implements IPTasDeCartes{

	protected int decalX;
	protected int decalY;
	protected int nbCarte;
	
	//protected CTasDeCartes ct;
	protected ArrayList<PCarte> lstCarte;
	
//	public PTasDeCartes(){
//		super();
//	}
	
	public PTasDeCartes() {
		super();
		//ct = controle;
		nbCarte = 0;
		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		//setSize (500,200);
		//setPreferredSize (getSize ()) ;
		
		
	}
	
	public void depiler(PCarte pc){
		this.remove(pc);
		nbCarte = nbCarte - 1;
		setSize(pc.getWidth() +20, (pc.getHeight() + (nbCarte - 1)*decalY + 20));
		setPreferredSize (getSize ()) ;
	}
	
	public void empiler(PCarte pc){
		this.add(pc, 0);
		nbCarte = nbCarte + 1;
		pc.setLocation(10 + decalX * (nbCarte - 1), 10 + decalY * (nbCarte - 1));
		setSize((pc.getWidth() + (nbCarte - 1)*decalX + 20), (pc.getHeight() + (nbCarte - 1)*decalY + 20));
		setPreferredSize (getSize ()) ;
	}
	
	public void setDxDy(int x, int y){
		decalX = x;
		decalY = y;
	}
}
