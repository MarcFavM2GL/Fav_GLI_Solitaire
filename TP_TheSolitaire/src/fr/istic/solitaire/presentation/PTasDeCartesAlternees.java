package fr.istic.solitaire.presentation;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import fr.istic.solitaire.controle.CTasDeCartesAlternees;

public class PTasDeCartesAlternees extends PTasDeCartes implements IPTasDeCartes{

	DropTarget dropTarget;
	CTasDeCartesAlternees monControle;
	DropTargetDropEvent theFinalEvent;
	
	public PTasDeCartesAlternees(CTasDeCartesAlternees ctrl) {
		super();
		monControle = ctrl;
		setLayout (null) ;
		setBackground (Color.lightGray) ;
		setOpaque (true);
		setSize (140,300);
		setPreferredSize (getSize ()) ;
		dropTarget = new DropTarget(this, new MyDropTargetListener());
	}
	
	class MyDropTargetListener implements DropTargetListener{

		PCarte pc;
		//DropTargetDropEvent theFinalEvent;
		
		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			
			try {
				pc = (PCarte) dtde.getTransferable().getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
				monControle.p2c_dragEnter(pc.getControle());
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
			monControle.p2c_dragExit(pc.getControle());
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			theFinalEvent = dtde;
			monControle.p2c_drop(pc.getControle());
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {}
		
	}
	
	public void c2p_showEmpilable(){
		setBackground (Color.green) ;
	}
	public void c2p_showNonEmpilable(){
		setBackground (Color.red) ;
	}
	public void c2p_showNeutre(){
		setBackground (Color.lightGray) ;
	}
	public void c2p_dropOK(){
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	public void c2p_dropNonOK(){
		theFinalEvent.rejectDrop();
	}
}
