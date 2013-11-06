package fr.istic.solitaire.abstraction;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
		
		Usine factory = new CUsine();

		MonSolitaire jeu = new MonSolitaire("poil", factory);
		jeu.initialiser();
		
		
		
		
		Colonne[] mesCol = jeu.pilesAlternees;
		for(int i=0; i<mesCol.length; i++){
			f.getContentPane().add(((CColonne)mesCol[i]).getPresentation());
		}
		
		
		TasDeCartesColorees[] mesTasColor = jeu.pilesColorees;
		for(int i=0; i<mesTasColor.length; i++){
			f.getContentPane().add(((CTasDeCartesColores)mesTasColor[i]).getPresentation());
		}
		
		f.getContentPane().add(((CSabot)jeu.sabot).getPresentation());
		
		
		
		
		f.pack();
		f.setLocation(100, 100);
		f.setSize(1250, 600);
		f.setVisible(true);
	}
}
