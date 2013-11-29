package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.TasDeCartes;
import fr.istic.solitaire.controle.CColonne;
import fr.istic.solitaire.controle.CJeu;
import fr.istic.solitaire.controle.CSabot;
import fr.istic.solitaire.controle.CTasDeCartesColores;

public class PJeu {

	CJeu monControle;
	
	JFrame f;
	JPanel pnl_haut = new JPanel();
	JPanel pnl_bas = new JPanel();
	JPanel pnl_haut_left = new JPanel();
	JPanel pnl_haut_center = new JPanel();
	JPanel pnl_haut_right = new JPanel();
	
	final Border monBord1 = BorderFactory.createLoweredBevelBorder();
	final Border monBord2 = BorderFactory.createRaisedBevelBorder();
	
	final Color couleur1 = new Color(143, 143, 195);  // violet pâle
	final Color couleur2 = Color.LIGHT_GRAY;
	
	
	public PJeu(CJeu controle) {
		
		monControle = controle;
		
		f = new JFrame ("THE 'Favereau-Solitaire'") ;
				
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.getContentPane ().setBackground(couleur1);

		pnl_haut.add(pnl_haut_left);
		pnl_haut.add(pnl_haut_center);
		pnl_haut.add(pnl_haut_right);
		f.getContentPane().add(pnl_haut);
		f.getContentPane().add(pnl_bas);
		
		pnl_haut_center.setSize(100, 50);
		pnl_haut_center.setPreferredSize(pnl_haut_center.getSize());
		pnl_haut_left.setBorder(monBord1);
		pnl_haut_right.setBorder(monBord2);
		pnl_haut.setBackground(couleur1);
		pnl_bas.setBackground(couleur1);
		pnl_haut_center.setBackground(couleur1);
	}
	
	public void configSabot(Sabot ctrlSabot){
		pnl_haut_left.add(((CSabot)ctrlSabot).getPresentation());
		configPlacementJeu();
	}
	
	public void configTasCartesCol(TasDeCartes[] mesTasColor){
		for(int i=0; i<mesTasColor.length; i++){
			pnl_haut_right.add(((CTasDeCartesColores)mesTasColor[i]).getPresentation());
			configPlacementJeu();
		}
	}
	
	public void configColonne(Colonne[] mesCol){
		for(int i=0; i<mesCol.length; i++){
			pnl_bas.add(((CColonne)mesCol[i]).getPresentation());
			configPlacementJeu();
		}
	}

	private void configPlacementJeu(){
				
		f.pack();
		f.setLocation(100,50);
		f.setMinimumSize(new Dimension(775, 650));
		f.setSize(775, 650);
		f.setVisible(true);
	}

	
}
