package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Container;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import fr.istic.solitaire.controle.CTasDeCartes;
import fr.istic.solitaire.controle.CTasDeCartesAlternees;
import fr.istic.solitaire.controle.CTasDeCartesColores;

public class PTasDeCartes extends JPanel implements IPTasDeCartes, Transferable{

	protected int decalX;
	protected int decalY;
	protected int nbCarte;
	boolean premiereCarteAffichee;
	protected int positionXCartePrec = 0;
	protected int positionYCartePrec = 0;
	int margeX;
	int margeY;
	CTasDeCartes monControleTas;
	
	
	protected ArrayList<PCarte> lstCarte;
	JLabel texteFond;
	
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
		setMarges(5, 15);
		
		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		setSize (PCarte.largeur + (margeX * 2),PCarte.hauteur + (margeY * 2));
		setPreferredSize (getSize ()) ;
		setBorder(BORD_SANS);
		lstCarte = new ArrayList<PCarte>();
		
		texteFond = new JLabel("poil");
		this.add(texteFond,0);
		texteFond.setVisible(true);
		texteFond.setOpaque(true);
		
		
	}
	
	public PTasDeCartes(CTasDeCartes ctrl) {		
		super();
		
		monControleTas = ctrl;
		nbCarte = 0;
		premiereCarteAffichee = true;
		setMarges(5, 10);
		
		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		setSize (PCarte.largeur + (margeX * 2),PCarte.hauteur + (margeY * 2));
		setPreferredSize (getSize ()) ;
		setBorder(BORD_SANS);
		lstCarte = new ArrayList<PCarte>();
	}
	
	public CTasDeCartes getControle(){
		return monControleTas;
	}
	
	public void depiler(PCarte pc){
		int larg;
		int haut;
		this.remove(pc);
		nbCarte = nbCarte - 1;
		lstCarte.remove(lstCarte.size() - 1);
		
		positionXCartePrec = positionXCartePrec - decalX;
		positionYCartePrec = positionYCartePrec - decalY;
		
		larg = Math.max((pc.getWidth() + positionXCartePrec + margeX), PCarte.largeur + margeX);
		haut = Math.max((pc.getHeight() + positionYCartePrec + margeY), PCarte.hauteur + margeY);
		
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
		
		if(premiereCarteAffichee){
			positionXCartePrec = margeX;
			positionYCartePrec = margeY;
		}else{
			positionXCartePrec = positionXCartePrec + decalX;
			positionYCartePrec = positionYCartePrec + decalY;
		}
		premiereCarteAffichee = false;
		
		larg = Math.max((pc.getWidth() + positionXCartePrec + margeX), PCarte.largeur + margeX);
		haut = Math.max((pc.getHeight() + positionYCartePrec + margeY), PCarte.hauteur + margeY);
		
		pc.setLocation(positionXCartePrec, positionYCartePrec);
		pc.setVisible(true);
		setSize(larg, haut);
		setPreferredSize (getSize ()) ;
		repaint();
	}
	
	public void initDecalAffichageCarte(){	
		int cmpt = lstCarte.size() - 1;
		positionXCartePrec = margeX;
		positionYCartePrec = margeY;
		premiereCarteAffichee = true;
		
		for(int i=cmpt; i>=0; i--){
			lstCarte.get(i).setVisible(false);
		}
		repaint();
	}
	
	public void setMarges(int x, int y){
		margeX = x;
		margeY = y;
		
		setSize (PCarte.largeur + (margeX * 2),PCarte.hauteur + (margeY * 2));
		setPreferredSize (getSize ()) ;
	}
	
	public void setTexteTasVide(String texte){
		texteFond.setText(texte);
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

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		Object result = null ;
		if (flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType)) {
			result = this ;
		} else if (flavor.isMimeTypeEqual (new DataFlavor (String.class, null))) {
			result = toString() ;
		} else {
			result = null ;
		}
			return (result) ;
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor data [] = new DataFlavor [2] ;
		try {
			data [0] = new DataFlavor (DataFlavor.javaJVMLocalObjectMimeType);
			data [1] = new DataFlavor (String.class, null) ;
		} catch (java.lang.ClassNotFoundException e) { }
		return (data) ;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if ((flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType))
				|| (flavor.isMimeTypeEqual (new DataFlavor (String.class, null)))) {
			return (true) ;
		} else {
			return (false) ;
		}
	}	
}
