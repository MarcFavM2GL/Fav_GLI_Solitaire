package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CTasDeCartes;
import fr.istic.solitaire.controle.CTasDeCartesColores;
import fr.istic.solitaire.presentation.PSabot.MyDragGestureListener;
import fr.istic.solitaire.presentation.PSabot.MyDragSourceListener;
import fr.istic.solitaire.presentation.PSabot.MyDragSourceMotionListener;

public class PTasDeCartesColores extends PTasDeCartes implements IPTasDeCartes{

	DropTarget dropTarget;
	CTasDeCartesColores monControle;
	DropTargetDropEvent theFinalEvent;
	
	DragSource ds;
	MyDragSourceListener myDsl;
	MyDragSourceMotionListener myDsMl;
	DragGestureEvent theInitialEvent;
	PCarte selection;
	Window valise = null;
	
	public PTasDeCartesColores(CTasDeCartesColores ctrl) {
		super();	
		monControle = ctrl;
		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		//setSize (140,300);
		setPreferredSize (getSize ()) ;
		dropTarget = new DropTarget(this, new MyDropTargetListener());
	
		myDsl = new MyDragSourceListener();
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(this, 
												DnDConstants.ACTION_MOVE, 
												new MyDragGestureListener());
		myDsMl = new MyDragSourceMotionListener();
		ds.addDragSourceMotionListener(myDsMl);
	
	
	}

	class MyDropTargetListener implements DropTargetListener{

		PCarte pc;
		PTasDeCartes ptc;
		//DropTargetDropEvent theFinalEvent;
		
		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			
			try {
				//pc = (PCarte) dtde.getTransferable().getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
				ptc = (PTasDeCartes) dtde.getTransferable().getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
				monControle.p2c_dragEnter(ptc.getControle());
			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void dragExit(DropTargetEvent dte) {
			monControle.p2c_dragExit();
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			theFinalEvent = dtde;
			monControle.p2c_drop(ptc.getControle());
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {}
		
	}
	
	/*public void c2p_showEmpilable(){
		setBackground (Color.green) ;
	}
	public void c2p_showNonEmpilable(){
		setBackground (Color.red) ;
	}
	public void c2p_showNeutre(){
		setBackground (Color.lightGray) ;
	}*/
	public void c2p_dropOK(){
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	public void c2p_dropNonOK(){
		theFinalEvent.rejectDrop();
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
	

	class MyDragSourceMotionListener implements DragSourceMotionListener{

		@Override
		public void dragMouseMoved(DragSourceDragEvent dsde) {	
			valise.setLocation(1 + dsde.getX(), 1 + dsde.getY());
			repaint();
		}
	}
	
	class MyDragGestureListener implements DragGestureListener{

		@Override
		public void dragGestureRecognized(DragGestureEvent evt) {
			
			theInitialEvent = evt;
			
			PCarte pc;
			CCarte cc = null;
			if(nbCarte > 0){
				try{
					pc = (PCarte) getComponentAt(evt.getDragOrigin());
					cc = pc.getControle();
				}catch(Exception e){
					
				}
				System.out.println(cc);
				monControle.p2c_debutDragNDrop(cc);	
			}		
		}
	}
	
	
	
}
