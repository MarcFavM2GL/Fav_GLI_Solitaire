package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Window;
import java.awt.dnd.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CColonne;
import fr.istic.solitaire.controle.CTasDeCartes;

//@description	Classe de présentation d'une colonne
@SuppressWarnings("serial")
public class PColonne extends JPanel{

	private PTasDeCartes tasCartesCachees, tasCartesVisibles;
	private CColonne monControle;
	RetournerCarteColonneListener retCarteListen = null;
	
	DragSource ds;
	MyDragSourceListener myDsl;
	MyDragSourceMotionListener myDsMl;
	DragGestureEvent theInitialEvent;
	PCarte selection;
	Window valise = null;
	
	public PColonne(CColonne controle, PTasDeCartes tasCache, PTasDeCartesAlternees tasVisible) {
		
		setLayout(null);
		setBackground(new Color(143, 143, 195));
		setOpaque (true);
		monControle = controle;
		
		tasCartesCachees = tasCache;
		tasCartesVisibles = tasVisible;	
		tasCartesCachees.setBackground(new Color(143, 143, 195));
		
		myDsl = new MyDragSourceListener();
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(this.tasCartesVisibles, 
												DnDConstants.ACTION_MOVE, 
												new MyDragGestureListener());
		myDsMl = new MyDragSourceMotionListener();
		ds.addDragSourceMotionListener(myDsMl);
		
		add(tasCartesCachees);
		add(tasCartesVisibles,0);
		tasCartesCachees.setLocation(5, 5);
		tasCartesCachees.setDxDy(0, 10);
		tasCartesVisibles.setDxDy(0, 25);

		setSize (100,400);
		setPreferredSize(getSize());
		setVisible(true);
		repaint();
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
	
	public void c2p_debutDragNDrop_OK(CTasDeCartes ctc){
		
		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop, 
						ctc.getPresentation(), 
						myDsl);
		valise = new Window((Window) getRootPane().getParent());
		valise.add(ctc.getPresentation());
		valise.pack();valise.setVisible(true);
		validate();
		repaint();
	}
	
	@Override
	public void repaint() {
		int decalYTasVisible = 0;
		if(tasCartesCachees != null){
			decalYTasVisible = tasCartesCachees.nbCarte * tasCartesCachees.decalY;
			decalYTasVisible= 10 + decalYTasVisible;
			tasCartesVisibles.setLocation(5, decalYTasVisible);
		}
		super.repaint();
	};
	
	class MyDragSourceMotionListener implements DragSourceMotionListener{
		@Override
		public void dragMouseMoved(DragSourceDragEvent dsde) {	
			valise.setLocation(1 + dsde.getX() - (valise.getWidth() / 2), 1 + dsde.getY() - 10);
			tasCartesVisibles.repaint();
		}
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
			monControle.p2c_debutDragNDrop(cc);			
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
