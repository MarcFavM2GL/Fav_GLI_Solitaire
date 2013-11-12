package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Container;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import fr.istic.solitaire.controle.CTasDeCartes;

public class PTasDeCartes extends JPanel implements IPTasDeCartes{

	protected int decalX;
	protected int decalY;
	protected int nbCarte;
	boolean premiereCarteAffichee;
	protected int positionXCartePrec;
	protected int positionYCartePrec;

	protected ArrayList<PCarte> lstCarte;
	
	final Border BORD_NEUTRE = BorderFactory.createLineBorder(Color.GRAY, 3);
	final Border BORD_OK = BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(Color.GREEN, 3), "OK");
	final Border BORD_KO = BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(Color.RED, 3), "NON");
	final Border BORD_SANS = BorderFactory.createEmptyBorder();
	
	
	public PTasDeCartes() {
		super();
		
		nbCarte = 0;
		premiereCarteAffichee = true;
		positionXCartePrec = 5;
		positionYCartePrec = 10;
		
		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		setSize (PCarte.largeur + 10,PCarte.hauteur + 20);
		setPreferredSize (getSize ()) ;
		setBorder(BORD_SANS);
		lstCarte = new ArrayList<PCarte>();
	}
	
	public void depiler(PCarte pc){
		int larg;
		int haut;
		this.remove(pc);
		nbCarte = nbCarte - 1;
		lstCarte.remove(lstCarte.size() - 1);
		
		positionXCartePrec = positionXCartePrec - decalX;
		positionYCartePrec = positionYCartePrec - decalY;
		larg = Math.max((pc.getWidth() + positionXCartePrec + 10), PCarte.largeur + 10);
		haut = Math.max((pc.getHeight() + positionYCartePrec), PCarte.hauteur + 20);
		
		setSize(larg, haut);
		setPreferredSize (getSize ()) ;
		repaint();
	}
	
	public void empiler(PCarte pc){
		int larg;
		int haut;
		
		this.add(pc, 0);
		lstCarte.add(pc);
		
		nbCarte = nbCarte + 1;
		
		if(!premiereCarteAffichee){
			positionXCartePrec = positionXCartePrec + decalX;
			positionYCartePrec = positionYCartePrec + decalY;
		}
		premiereCarteAffichee = false;
		
		larg = Math.max((pc.getWidth() + positionXCartePrec + 10), PCarte.largeur + 10);
		haut = Math.max((pc.getHeight() + positionYCartePrec), PCarte.hauteur + 20);
		
		pc.setLocation(positionXCartePrec, positionYCartePrec);
		pc.setVisible(true);
		setSize(larg, haut);
		setPreferredSize (getSize ()) ;
		repaint();
	}
	
	public void initDecalAffichageCarte(){	
		int cmpt = lstCarte.size() - 1;
		positionXCartePrec = 5;
		positionYCartePrec = 10;
		premiereCarteAffichee = true;
		
		for(int i=cmpt; i>=0; i--){
			lstCarte.get(i).setVisible(false);
		}
		repaint();
	}
	
	public void setDxDy(int x, int y){
		decalX = x;
		decalY = y;
	}

	public void c2p_showEmpilable(){
		setBorder(BORD_OK);
	}
	public void c2p_showNonEmpilable(){
		setBorder(BORD_KO);
	}
	public void c2p_showNeutre(){
		setBorder(BORD_SANS);
	}
	
	@Override
	public void repaint() {
		super.repaint();
		Container lukejeSuisTonPere = getParent();
		if(lukejeSuisTonPere != null){
			lukejeSuisTonPere.repaint();
		}
	}	
}
