package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.istic.solitaire.controle.CColonne;
import fr.istic.solitaire.controle.CSabot;

public class PColonne extends JPanel{

	private PTasDeCartes tasCartesCachees, tasCartesVisibles;
	private CColonne monControle;
	RetournerCarteColonneListener retCarteListen = null;
	
	public PColonne(CColonne controle, PTasDeCartes tasCache, PTasDeCartesAlternees tasVisible) {
		
		//setLayout(new GridLayout(2, 1));
		setLayout(null);
		setBackground(new Color(250, 210, 160));
		setOpaque (true);
		monControle = controle;
		
		tasCartesCachees = tasCache;
		tasCartesVisibles = tasVisible;	
		tasCartesCachees.setBackground(new Color(245, 170, 60));
		
		add(tasCartesCachees,0);
		add(tasCartesVisibles,0);
		
		tasCartesCachees.setDxDy(0, 10);
		tasCartesVisibles.setDxDy(0, 25);
		
		tasCartesVisibles.setLocation(10, 150);;
		tasCartesCachees.setLocation(10, 10);
		System.out.println("haut : " + tasCache.getHeight());
		setSize (120,300);
		setPreferredSize(getSize());
		
		setVisible(true);
	}
	
	public void activerRetournerCarte(){
		if(retCarteListen == null){
			retCarteListen = new RetournerCarteColonneListener(monControle);
		}
		tasCartesCachees.addMouseListener(retCarteListen);
	}
	
	public void desactiverRetournerCarte(){
		tasCartesCachees.removeMouseListener(retCarteListen);
	}
	
	class RetournerCarteColonneListener implements MouseListener{

		CColonne controle;
		
		public RetournerCarteColonneListener(CColonne monControle){
			controle = monControle;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				controle.retournerCarte();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
	}
}
