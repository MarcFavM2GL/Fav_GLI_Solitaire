package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Window;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CSabot;
import fr.istic.solitaire.controle.CTasDeCartes;


public class PSabot extends JPanel{
	
	private PTasDeCartes tasCartesCachees, tasCartesVisibles;
	private CSabot monControle;
	RetournerCarteSabotListener RetCarListen;
	RetournerTasSabotListener RetTasListen;
	
	DragSource ds;
	MyDragSourceListener myDsl;
	MyDragSourceMotionListener myDsMl;
	DragGestureEvent theInitialEvent;
	PCarte selection;
	Window valise = null;
	
	
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
		myDsMl = new MyDragSourceMotionListener();
		ds.addDragSourceMotionListener(myDsMl);
		
		
		tasCartesCachees.setBackground(Color.gray);
		tasCartesVisibles.setBackground(Color.YELLOW);

		add(tasCartesCachees,0);
		add(tasCartesVisibles,0);
		tasCartesVisibles.setDxDy(20, 0);
		tasCartesVisibles.setLocation(110, 10);;
		tasCartesCachees.setLocation(10, 10);
		//System.out.println("haut : " + tasCache.getHeight());
		
		/*
		tasCartesCachees.setSize(100, 110); 
		tasCartesCachees.setPreferredSize(tasCartesCachees.getSize());
		tasCartesVisibles.setSize(950, 110);
		tasCartesVisibles.setPreferredSize(tasCartesVisibles.getSize());
		*/
		
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
		//Cursor curseur = new Cursor(Cursor.MOVE_CURSOR);
		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop, 
						cc.getPresentation(), 
						myDsl);
		valise = new Window((Window) getRootPane().getParent());
		valise.add(cc.getPresentation());
		valise.pack();valise.setVisible(true);
		validate();
		repaint();
		
	}

	class MyDragSourceMotionListener implements DragSourceMotionListener{

		@Override
		public void dragMouseMoved(DragSourceDragEvent dsde) {	
			valise.setLocation(1 + dsde.getX(), 1 + dsde.getY());
			tasCartesVisibles.repaint();
		}
	}
	
	
	class MyDragGestureListener implements DragGestureListener{

		@Override
		public void dragGestureRecognized(DragGestureEvent evt) {
			
			theInitialEvent = evt;
			
			PCarte pc;
			CCarte cc = null;
			if(tasCartesVisibles.nbCarte > 0){
				try{
					pc = (PCarte) tasCartesVisibles.getComponentAt(evt.getDragOrigin());
					cc = pc.getControle();
				}catch(Exception e){
					
				}
				System.out.println(cc);
				monControle.p2c_debutDragNDrop(cc);	
			}		
		}
	}
	
	class MyDragSourceListener implements DragSourceListener{
	
		@Override
		public void dragDropEnd(DragSourceDropEvent dsde) {
			monControle.p2c_endDragNDrop(dsde.getDropSuccess());
			valise.setVisible(false);
			validate();
			repaint();
		}

		@Override
		public void dragEnter(DragSourceDragEvent dsde) {}
		@Override
		public void dragExit(DragSourceEvent dse) {
			repaint();
		}
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




