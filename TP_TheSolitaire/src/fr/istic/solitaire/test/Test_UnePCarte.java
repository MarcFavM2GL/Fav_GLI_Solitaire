package fr.istic.solitaire.test;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import fr.istic.solitaire.presentation.PCarte;

public class Test_UnePCarte {

/**
 * programme de test d'une carte simple
 * @param args
 */
public static void main (String args []) {
	JFrame f = new JFrame ("Test PCarte") ;
	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
	f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

	// une carte visible
	PCarte pc = new PCarte (null, "10D");
	pc.setFaceVisible(true);
	f.getContentPane ().add(pc) ;

	// une carte cachée
	pc = new PCarte(null, "1C");
	pc.setFaceVisible(false);
	f.getContentPane ().add(pc) ;
	
	// une carte visible
	pc = new PCarte (null, "KH");
	pc.setFaceVisible(true);
	f.getContentPane ().add(pc) ;

	// une carte cachée
	pc = new PCarte(null, "1S");
	pc.setFaceVisible(false);
	f.getContentPane ().add(pc) ;

	f.pack () ;		// dimensionner le cadre
	f.setLocation(200,100);	// le positionner
	f.setVisible (true) ;	// et le rendre visible
} // main

}