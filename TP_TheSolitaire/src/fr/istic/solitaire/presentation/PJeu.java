package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

//@description	Classe de présentation du jeu
public class PJeu {

	CJeu monControle;
	
	JFrame f;
	JPanel pnl_haut = new JPanel();
	JPanel pnl_bas = new JPanel();
	JPanel pnl_haut_left = new JPanel();
	JPanel pnl_haut_center = new JPanel();
	JPanel pnl_haut_right = new JPanel();
	
	JMenuBar mnuBarre;
	JMenu mnuMenu;
	JMenuItem mnuItem;
	
	final Border monBord1 = BorderFactory.createLoweredBevelBorder();
	final Border monBord2 = BorderFactory.createRaisedBevelBorder();
	
	final Color couleur1 = new Color(143, 143, 195);  // violet pâle
	final Color couleur2 = Color.LIGHT_GRAY;
	
	final String msgAppli = "Ceci est une version graphique du solitaire\n"
			+ "effectué en TP de GLI du M2GL de l'ISTIC (2013/2014).\n"
			+ "Il est loin d'être complet mais cela donne un aperçu\n"
			+ "de ce que l'on a appris.\n"
			+ "\n"
			+ "Marc Favereau";
	
	
	public PJeu(CJeu controle) {
		
		monControle = controle;
		
		f = new JFrame ("'Favereau-Solitaire'") ;
				
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
		
		mnuBarre = new JMenuBar();
		ActionListener gestionEvtMenu = new monMenu();
		
		mnuMenu = new JMenu("    Gestion du Jeu    ");
		mnuBarre.add(mnuMenu);
		
		mnuItem = new JMenuItem("Relancer le jeu");
		mnuItem.addActionListener(gestionEvtMenu);
		mnuMenu.add(mnuItem);
		mnuMenu.addSeparator();
		mnuItem = new JMenuItem("Quitter");
		mnuItem.addActionListener(gestionEvtMenu);
		mnuMenu.add(mnuItem);
		
		
		mnuMenu = new JMenu("    Aide    ");
		mnuBarre.add(mnuMenu);
		
		mnuItem = new JMenuItem("A propos");
		mnuItem.addActionListener(gestionEvtMenu);
		mnuMenu.add(mnuItem);
		
		new monMenu();
		
		f.setJMenuBar(mnuBarre);
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
	
	
	public void removeAllComp(){
		pnl_haut_left.removeAll();
		pnl_haut_right.removeAll();
		pnl_bas.removeAll();
		f.repaint();
	}
		

	private void configPlacementJeu(){
				
		f.pack();
		f.setLocation(100,50);
		f.setMinimumSize(new Dimension(775, 650));
		f.setSize(775, 650);
		f.setVisible(true);
	}

	public class monMenu implements ActionListener, ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)e.getSource();
			
			if(source.getText().compareTo("Relancer le jeu") == 0){
				monControle.ReinitJeu();
			}
			if(source.getText().compareTo("Quitter") == 0){
				f.dispose();
			}
			if(source.getText().compareTo("A propos") == 0){
				
				JOptionPane.showMessageDialog(f, msgAppli,
						"Infos du solitaire !!!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
