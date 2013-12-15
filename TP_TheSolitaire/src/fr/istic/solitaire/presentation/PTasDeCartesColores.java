package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.IOException;

import fr.istic.solitaire.controle.CCarte;
import fr.istic.solitaire.controle.CTasDeCartes;
import fr.istic.solitaire.controle.CTasDeCartesColores;

@SuppressWarnings("serial")
public class PTasDeCartesColores extends PTasDeCartes {

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
		
		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			
			try {
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
	
	public void c2p_dropOK(){
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	
	public void c2p_dropNonOK(){
		theFinalEvent.rejectDrop();
	}
	
	public void c2p_debutDragNDrop_NonOK(){
		
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
			valise.setLocation(1 + dsde.getX() - (valise.getWidth() / 2), 1 + dsde.getY() - 10);
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
