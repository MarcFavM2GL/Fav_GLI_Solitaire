package fr.istic.solitaire.test;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Usine;
import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CSabot;
import fr.istic.solitaire.controle.CTasDeCartes;
import fr.istic.solitaire.controle.CUsine;

public class TestUnSabotSansEvts {
	public static void main (String args []) throws Exception {
		JFrame f = new JFrame ("Test un sabot") ;
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
		
		Usine factory = new CUsine();
		CSabot sabotEnTest = new CSabot("Sabot en Test", factory);
		
		
		
		
		
		CTasDeCartes colonne1 = new CTasDeCartes("TestTas", factory);
		
		CCarte maCarte1 = new CCarte(10, 1);
		CCarte maCarte2 = new CCarte(11, 1);
		CCarte maCarte3 = new CCarte(12, 1);
		CCarte maCarte4 = new CCarte(13, 1);
		CCarte maCarte5 = new CCarte(10, 2);
		CCarte maCarte6 = new CCarte(11, 2);
		CCarte maCarte7 = new CCarte(12, 2);
		CCarte maCarte8 = new CCarte(13, 2);
		
		colonne1.empiler(maCarte5);
		colonne1.empiler(maCarte6);
		colonne1.empiler(maCarte7);
		colonne1.empiler(maCarte8);
		colonne1.empiler(maCarte1);
		colonne1.empiler(maCarte2);
		colonne1.empiler(maCarte3);
		colonne1.empiler(maCarte4);
		
		//sabotEnTest.recopier(colonne1);
		sabotEnTest.setReserve(colonne1);
		
		
		
		f.getContentPane().add(sabotEnTest.getPresentation());
		//f.getContentPane().add(colonne1.getPresentation());
		
		f.pack();
		f.setLocation(100, 100);
		f.setSize(650, 500);
		f.setVisible(true);
		
		
	}
	
}
