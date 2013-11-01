package fr.istic.solitaire.test;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fr.istic.solitaire.controle.CCarte;

public class Test_UneCCarte {

	public static void main (String args []) {
		JFrame f = new JFrame ("Test CCarte") ;
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

		CCarte cc = new CCarte(1, 1);
		cc.setFaceVisible(true);
		f.getContentPane().add(cc.getPresentation());
		
		cc = new CCarte(6, 2);
		cc.setFaceVisible(true);
		f.getContentPane().add(cc.getPresentation());
		
		f.pack();
		f.setLocation(50, 250);
		f.setVisible(true);
		
		for(int i=0; i<10 ; i++){
			int valRand = (int)(Math.random() * 12) + 1;
			int coulRand = (int)(Math.random() * 3) + 1;
			
			System.out.println("val = " +valRand + " ,coul = " + coulRand);
			
			cc = new CCarte(valRand, coulRand);
			cc.setFaceVisible(true);
			f.getContentPane().add(cc.getPresentation());
			
			f.pack();
			f.setLocation(50, 250);
			f.setVisible(true);
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
