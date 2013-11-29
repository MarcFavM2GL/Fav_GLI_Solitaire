package fr.istic.solitaire.abstraction;

import solitaire.application.Usine;
import fr.istic.solitaire.controle.CJeu;
import fr.istic.solitaire.controle.CUsine;


public class MonSolitaire {

public static void main(String[] args) {
		
	
	CUsine maFactory = new CUsine();
	CJeu ctrlJeu = new CJeu(maFactory);

	ctrlJeu.initJeu();

	
		
	/*
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
		jeu = new MonSolitaire("moteurSolitaire", factory);
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
		
		*/
	}
}
