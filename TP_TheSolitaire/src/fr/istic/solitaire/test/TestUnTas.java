package fr.istic.solitaire.test;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Usine;
import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CTasDeCartes;

public class TestUnTas {
	public static void main (String args []) throws Exception {
		JFrame f = new JFrame ("Test un tas") ;
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
		
		Usine factory = new Usine();
		CTasDeCartes colonne1 = new CTasDeCartes("TestTas", factory);
		
		CCarte maCarte1 = new CCarte(10, 1);
		CCarte maCarte2 = new CCarte(11, 1);
		CCarte maCarte3 = new CCarte(12, 1);
		CCarte maCarte4 = new CCarte(13, 1);
		CCarte maCarte5 = new CCarte(10, 1);
		CCarte maCarte6 = new CCarte(11, 1);
		CCarte maCarte7 = new CCarte(12, 1);
		CCarte maCarte8 = new CCarte(13, 1);
		
		maCarte1.setFaceVisible(true);
		maCarte2.setFaceVisible(true);
		maCarte3.setFaceVisible(true);
		maCarte4.setFaceVisible(true);
		maCarte5.setFaceVisible(false);
		maCarte6.setFaceVisible(false);
		maCarte7.setFaceVisible(false);
		maCarte8.setFaceVisible(false);
		
		f.getContentPane().add(colonne1.getPresentation());
		
		f.pack();
		f.setLocation(200, 100);
		f.setSize(200, 400);
		f.setVisible(true);
		
		colonne1.empiler(maCarte5);
		Thread.sleep(500);
		colonne1.empiler(maCarte6);
		Thread.sleep(500);
		colonne1.empiler(maCarte7);
		Thread.sleep(500);
		colonne1.empiler(maCarte8);
		Thread.sleep(500);
		colonne1.empiler(maCarte1);
		Thread.sleep(500);
		colonne1.empiler(maCarte2);
		Thread.sleep(500);
		colonne1.empiler(maCarte3);
		Thread.sleep(500);
		colonne1.empiler(maCarte4);
		
		Thread.sleep(500);
		colonne1.depiler();
		
		Thread.sleep(500);
		colonne1.depiler();
		Thread.sleep(500);
		colonne1.depiler();
		Thread.sleep(500);
		colonne1.depiler();
		Thread.sleep(500);
		colonne1.depiler();
		Thread.sleep(500);
		colonne1.depiler();
		Thread.sleep(500);
		colonne1.depiler();
		Thread.sleep(500);
		colonne1.depiler();
		
	}
	
}
