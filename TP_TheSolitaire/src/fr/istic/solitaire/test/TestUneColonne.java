package fr.istic.solitaire.test;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Usine;
import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CColonne;
import fr.istic.solitaire.controle.CSabot;
import fr.istic.solitaire.controle.CTasDeCartes;
import fr.istic.solitaire.controle.CUsine;

public class TestUneColonne {

	public static void main (String args []) throws Exception {
		JFrame f = new JFrame ("Test des colonnes") ;
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
		
		Usine factory = new CUsine();
		CColonne col1 = new CColonne("Colonne1 en Test", factory);
		CColonne col2 = new CColonne("Colonne2 en Test", factory);
		CColonne col3 = new CColonne("Colonne3 en Test", factory);
		CColonne col4 = new CColonne("Colonne4 en Test", factory);
		
		CTasDeCartes tas1 = new CTasDeCartes("TestTas1", factory);
		CTasDeCartes tas2 = new CTasDeCartes("TestTas2", factory);
		CTasDeCartes tas3 = new CTasDeCartes("TestTas3", factory);
		CTasDeCartes tas4 = new CTasDeCartes("TestTas4", factory);
		
		CCarte maCarte1 = new CCarte(10, 1);
		CCarte maCarte2 = new CCarte(11, 1);
		CCarte maCarte3 = new CCarte(12, 1);
		CCarte maCarte4 = new CCarte(13, 1);
		CCarte maCarte5 = new CCarte(10, 2);
		CCarte maCarte6 = new CCarte(11, 2);
		CCarte maCarte7 = new CCarte(12, 2);
		CCarte maCarte8 = new CCarte(13, 2);
		
		tas1.empiler(maCarte1);
		
		tas2.empiler(maCarte2);
		tas2.empiler(maCarte3);
		
		tas3.empiler(maCarte4);
		tas3.empiler(maCarte5);
		tas3.empiler(maCarte6);
		
		tas4.empiler(maCarte7);
		tas4.empiler(maCarte8);
		//tas4.empiler(maCarte1);
		//tas4.empiler(maCarte2);
		
		col1.setReserve(tas1);
		col2.setReserve(tas2);
		col3.setReserve(tas3);
		col4.setReserve(tas4);
		
		
		f.getContentPane().add(col1.getPresentation());
		f.getContentPane().add(col2.getPresentation());
		f.getContentPane().add(col3.getPresentation());
		f.getContentPane().add(col4.getPresentation());
		//f.getContentPane().add(colonne1.getPresentation());
		
		f.pack();
		f.setLocation(100, 100);
		f.setSize(650, 500);
		f.setVisible(true);
		
		Thread.sleep(1000);
		col1.retournerCarte();
		Thread.sleep(1000);
		col2.retournerCarte();
//		Thread.sleep(1000);
//		col3.retournerCarte();
//		Thread.sleep(1000);
//		col4.retournerCarte();
		
	}
	
}
