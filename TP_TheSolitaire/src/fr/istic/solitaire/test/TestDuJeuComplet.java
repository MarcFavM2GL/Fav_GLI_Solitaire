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
import fr.istic.solitaire.controle.CTasDeCartesColores;
import fr.istic.solitaire.controle.CUsine;

public class TestDuJeuComplet {

	public static void main(String[] args) {
		
		JFrame f = new JFrame ("THE 'Solitaire'") ;
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
		
		Usine factory = new CUsine();
		
		CCarte maCarteA01 = new CCarte(1, 1);
		CCarte maCarteA02 = new CCarte(2, 1);
		CCarte maCarteA03 = new CCarte(3, 1);
		CCarte maCarteA04 = new CCarte(4, 1);
		CCarte maCarteA05 = new CCarte(5, 1);
		CCarte maCarteA06 = new CCarte(6, 1);
		CCarte maCarteA07 = new CCarte(7, 1);
		CCarte maCarteA08 = new CCarte(8, 1);
		CCarte maCarteA09 = new CCarte(9, 1);
		CCarte maCarteA10 = new CCarte(10, 1);
		CCarte maCarteA11 = new CCarte(11, 1);
		CCarte maCarteA12 = new CCarte(12, 1);
		CCarte maCarteA13 = new CCarte(13, 1);
		
		CCarte maCarteB01 = new CCarte(1, 2);
		CCarte maCarteB02 = new CCarte(2, 2);
		CCarte maCarteB03 = new CCarte(3, 2);
		CCarte maCarteB04 = new CCarte(4, 2);
		CCarte maCarteB05 = new CCarte(5, 2);
		CCarte maCarteB06 = new CCarte(6, 2);
		CCarte maCarteB07 = new CCarte(7, 2);
		CCarte maCarteB08 = new CCarte(8, 2);
		CCarte maCarteB09 = new CCarte(9, 2);
		CCarte maCarteB10 = new CCarte(10, 2);
		CCarte maCarteB11 = new CCarte(11, 2);
		CCarte maCarteB12 = new CCarte(12, 2);
		CCarte maCarteB13 = new CCarte(13, 2);
		
		CCarte maCarteC01 = new CCarte(1, 3);
		CCarte maCarteC02 = new CCarte(2, 3);
		CCarte maCarteC03 = new CCarte(3, 3);
		CCarte maCarteC04 = new CCarte(4, 3);
		CCarte maCarteC05 = new CCarte(5, 3);
		CCarte maCarteC06 = new CCarte(6, 3);
		CCarte maCarteC07 = new CCarte(7, 3);
		CCarte maCarteC08 = new CCarte(8, 3);
		CCarte maCarteC09 = new CCarte(9, 3);
		CCarte maCarteC10 = new CCarte(10, 3);
		CCarte maCarteC11 = new CCarte(11, 3);
		CCarte maCarteC12 = new CCarte(12, 3);
		CCarte maCarteC13 = new CCarte(13, 3);
		
		CCarte maCarteD01 = new CCarte(1, 4);
		CCarte maCarteD02 = new CCarte(2, 4);
		CCarte maCarteD03 = new CCarte(3, 4);
		CCarte maCarteD04 = new CCarte(4, 4);
		CCarte maCarteD05 = new CCarte(5, 4);
		CCarte maCarteD06 = new CCarte(6, 4);
		CCarte maCarteD07 = new CCarte(7, 4);
		CCarte maCarteD08 = new CCarte(8, 4);
		CCarte maCarteD09 = new CCarte(9, 4);
		CCarte maCarteD10 = new CCarte(10, 4);
		CCarte maCarteD11 = new CCarte(11, 4);
		CCarte maCarteD12 = new CCarte(12, 4);
		CCarte maCarteD13 = new CCarte(13, 4);
		
		
		CColonne col1 = new CColonne("Colonne1 en Test", factory);
		CColonne col2 = new CColonne("Colonne2 en Test", factory);
		CColonne col3 = new CColonne("Colonne3 en Test", factory);
		CColonne col4 = new CColonne("Colonne4 en Test", factory);
		
		CTasDeCartes tas1 = new CTasDeCartes("TestTas1", factory);
		CTasDeCartes tas2 = new CTasDeCartes("TestTas2", factory);
		CTasDeCartes tas3 = new CTasDeCartes("TestTas3", factory);
		CTasDeCartes tas4 = new CTasDeCartes("TestTas4", factory);
		CTasDeCartes tas5 = new CTasDeCartes("TestTas5", factory);
		
		tas1.empiler(maCarteA01);
		tas1.empiler(maCarteA11);
		
		tas2.empiler(maCarteA02);
		tas2.empiler(maCarteA03);
		tas2.empiler(maCarteA12);
		
		tas3.empiler(maCarteA04);
		tas3.empiler(maCarteA05);
		tas3.empiler(maCarteA06);
		
		tas4.empiler(maCarteA07);
		tas4.empiler(maCarteA08);
		tas4.empiler(maCarteA09);
		tas4.empiler(maCarteA10);
		tas4.empiler(maCarteA13);
		
		tas5.empiler(maCarteB01);
		tas5.empiler(maCarteB02);
		tas5.empiler(maCarteB03);
		tas5.empiler(maCarteB04);
		tas5.empiler(maCarteB05);
		tas5.empiler(maCarteB06);
		tas5.empiler(maCarteB07);
		tas5.empiler(maCarteB08);
		tas5.empiler(maCarteB09);
		tas5.empiler(maCarteB10);
		tas5.empiler(maCarteB11);
		tas5.empiler(maCarteB12);
		tas5.empiler(maCarteB13);
		
		tas5.empiler(maCarteC01);
		tas5.empiler(maCarteC02);
		tas5.empiler(maCarteC03);
		tas5.empiler(maCarteC04);
		tas5.empiler(maCarteC05);
		tas5.empiler(maCarteC06);
		tas5.empiler(maCarteC07);
		tas5.empiler(maCarteC08);
		tas5.empiler(maCarteC09);
		tas5.empiler(maCarteC10);
		tas5.empiler(maCarteC11);
		tas5.empiler(maCarteC12);
		tas5.empiler(maCarteC13);
		
		tas5.empiler(maCarteD01);
		tas5.empiler(maCarteD02);
		tas5.empiler(maCarteD03);
		tas5.empiler(maCarteD04);
		tas5.empiler(maCarteD05);
		tas5.empiler(maCarteD06);
		tas5.empiler(maCarteD07);
		tas5.empiler(maCarteD08);
		tas5.empiler(maCarteD09);
		tas5.empiler(maCarteD10);
		tas5.empiler(maCarteD11);
		tas5.empiler(maCarteD12);
		tas5.empiler(maCarteD13);
		
		
		col1.setReserve(tas1);
		col2.setReserve(tas2);
		col3.setReserve(tas3);
		col4.setReserve(tas4);
		
		
		f.getContentPane().add(col1.getPresentation());
		f.getContentPane().add(col2.getPresentation());
		f.getContentPane().add(col3.getPresentation());
		f.getContentPane().add(col4.getPresentation());

		CTasDeCartesColores tasCol1 = new CTasDeCartesColores("tasColore 1", 1, factory);
		CTasDeCartesColores tasCol2 = new CTasDeCartesColores("tasColore 2", 2, factory);
		CTasDeCartesColores tasCol3 = new CTasDeCartesColores("tasColore 3", 3, factory);
		CTasDeCartesColores tasCol4 = new CTasDeCartesColores("tasColore 4", 4, factory);
		
		f.getContentPane().add(tasCol1.getPresentation());
		f.getContentPane().add(tasCol2.getPresentation());
		f.getContentPane().add(tasCol3.getPresentation());
		f.getContentPane().add(tasCol4.getPresentation());
		
		CSabot leSabot = new CSabot("sabot", factory);
		leSabot.setReserve(tas5);
		
		f.getContentPane().add(leSabot.getPresentation());
		
		f.pack();
		f.setLocation(100, 100);
		f.setSize(1250, 600);
		f.setVisible(true);
		
//		Thread.sleep(1000);
//		col1.retournerCarte();
//		Thread.sleep(1000);
//		col2.retournerCarte();
//		Thread.sleep(1000);
//		col3.retournerCarte();
//		Thread.sleep(1000);
//		col4.retournerCarte();

	}

}
