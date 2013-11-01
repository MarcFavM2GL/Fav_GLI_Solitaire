package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CSabot;
import fr.istic.solitaire.controle.CTasDeCartes;


public class PSabot extends JPanel /*implements DragGestureListener*/{
	
	private PTasDeCartes tasCartesCachees, tasCartesVisibles;
	private CSabot monControle;
	RetournerCarteSabotListener RetCarListen;
	RetournerTasSabotListener RetTasListen;
	
	DragSource ds;
	MyDragSourceListener myDsl;
	DragGestureEvent theInitialEvent;
	PCarte selection;
	
	public PSabot(CSabot controle, PTasDeCartes tasCache, PTasDeCartes tasVisible) {

		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		monControle = controle;
		tasCartesCachees = tasCache;
		tasCartesVisibles = tasVisible;	
		
		myDsl = new MyDragSourceListener();
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(this.tasCartesVisibles, 
												DnDConstants.ACTION_MOVE, 
												new MyDragGestureListener());
		
		
		tasCartesCachees.setBackground(Color.gray);

		add(tasCartesCachees,0);
		add(tasCartesVisibles,0);
		tasCartesVisibles.setDxDy(20, 0);
		tasCartesVisibles.setLocation(110, 10);;
		tasCartesCachees.setLocation(10, 10);
		System.out.println("haut : " + tasCache.getHeight());
		setSize (1080,140);
		setPreferredSize(getSize());
		
		setVisible(true);
		
	}
	
	public void activerRetournerCarte(){
		RetCarListen = new RetournerCarteSabotListener(monControle);
		tasCartesCachees.addMouseListener(RetCarListen);
	}
	
	public void desactiverRetournerCarte(){
		tasCartesCachees.removeMouseListener(RetCarListen);
		repaint();
	}
	
	public void activerRetournerTas(){
		RetTasListen = new RetournerTasSabotListener(monControle);
		tasCartesCachees.addMouseListener(RetTasListen);
	}
	
	public void desactiverRetournerTas(){
		tasCartesCachees.removeMouseListener(RetTasListen);
	}

	public void c2p_debutDragNDrop_NonOK(){
		
	}
	
	public void c2p_debutDragNDrop_OK(CCarte cc){
		Cursor curseur = new Cursor(Cursor.MOVE_CURSOR);
		ds.startDrag(theInitialEvent, curseur, 
						cc.getPresentation(), 
						myDsl);
	}

	
	class MyDragGestureListener implements DragGestureListener{

		@Override
		public void dragGestureRecognized(DragGestureEvent evt) {
			
			theInitialEvent = evt;
			
			PCarte pc;
			CCarte cc = null;
			
			try{
				pc = (PCarte) tasCartesVisibles.getComponentAt(evt.getDragOrigin());
				cc = pc.getControle();
			}catch(Exception e){
				
			}
			System.out.println(cc);
			monControle.p2c_debutDragNDrop(cc);			
		}
	}
	
	class MyDragSourceListener implements DragSourceListener{
	
		@Override
		public void dragDropEnd(DragSourceDropEvent dsde) {
			monControle.p2c_endDragNDrop(dsde.getDropSuccess());
		}

		@Override
		public void dragEnter(DragSourceDragEvent dsde) {}
		@Override
		public void dragExit(DragSourceEvent dse) {}
		@Override
		public void dragOver(DragSourceDragEvent dsde) {}
		@Override
		public void dropActionChanged(DragSourceDragEvent dsde) {}
	}
}

class RetournerTasSabotListener implements MouseListener{

	CSabot controle;
	public RetournerTasSabotListener(CSabot monControle) {
		controle = monControle;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		controle.retourner();
		
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

class RetournerCarteSabotListener implements MouseListener{

	CSabot controle;
	public RetournerCarteSabotListener(CSabot monControle) {
		controle = monControle;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		controle.retournerCarte();
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




