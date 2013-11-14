package fr.istic.solitaire.abstraction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import solitaire.application.Colonne;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CColonne;
import fr.istic.solitaire.controle.CSabot;
import fr.istic.solitaire.controle.CTasDeCartes;
import fr.istic.solitaire.controle.CTasDeCartesColores;
import fr.istic.solitaire.controle.CUsine;

public class MonSolitaire extends Solitaire {
	
public MonSolitaire(String nom, Usine fabrique) {
		super(nom, fabrique);
	}

public static void main(String[] args) {
		
		JFrame f = new JFrame ("THE 'Favereau-Solitaire'") ;
		
		JPanel pnl_haut = new JPanel();
		JPanel pnl_bas = new JPanel();
		JPanel pnl_haut_left = new JPanel();
		JPanel pnl_haut_center = new JPanel();
		JPanel pnl_haut_right = new JPanel();
		
		final Border monBord1 = BorderFactory.createLoweredBevelBorder();
		final Border monBord2 = BorderFactory.createRaisedBevelBorder();
		
		final Color couleur1 = new Color(143, 143, 195);  // violet pâle
		final Color couleur2 = Color.LIGHT_GRAY;
		
		
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
		
		Usine factory = new CUsine();
		MonSolitaire jeu = new MonSolitaire("moteurSolitaire", factory);
		jeu.initialiser();
		
		pnl_haut_left.add(((CSabot)jeu.sabot).getPresentation());
		
		TasDeCartesColorees[] mesTasColor = jeu.pilesColorees;
		for(int i=0; i<mesTasColor.length; i++){
			//f.getContentPane().add(((CTasDeCartesColores)mesTasColor[i]).getPresentation());
			pnl_haut_right.add(((CTasDeCartesColores)mesTasColor[i]).getPresentation());
		}
		
		Colonne[] mesCol = jeu.pilesAlternees;
		for(int i=0; i<mesCol.length; i++){
			//f.getContentPane().add(((CColonne)mesCol[i]).getPresentation());
			pnl_bas.add(((CColonne)mesCol[i]).getPresentation());
		}
		
		f.pack();
		f.setLocation(100,50);
		f.setMinimumSize(new Dimension(775, 650));
		f.setSize(775, 650);
		f.setVisible(true);
	}
}
