package fr.istic.solitaire.presentation;

import java.awt.* ;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.* ;

import fr.istic.solitaire.controle.CCarte;

//@description	Classe de présentation d'une carte
@SuppressWarnings("serial")
public class PCarte extends JPanel implements Transferable/*, Serializable*/ {
	
	protected CCarte controle ;
	protected JLabel face, dos ;
	protected ImageIcon icone ;
	protected static ImageIcon iconeDos;
	public static int largeur, hauteur ;

	/**
	 * @description (constructeur) initialiser une presentation de carte
	 * @param control : controleur de la carte,
	 * 					passage par injection
	 * @param chaine : nom de la carte (exemple "3H" = 3 Heart)
	 */
	public PCarte (CCarte control, final String chaine) {
		
		this.controle = control ;
		icone = new ImageIcon(ClassLoader.getSystemResource("ressources/" + chaine + ".gif"));
		face = new JLabel (icone) ;
		add (face) ;
		face.setLocation (0, 0) ;
		face.setSize (largeur, hauteur) ;

		dos = new JLabel (iconeDos) ;
		add (dos) ;
		dos.setLocation (0, 0) ;
		dos.setSize (largeur, hauteur) ;

		setLayout (null) ;
		setBackground (Color.black) ;
		setOpaque (true);
		setSize (face.getSize ()) ;
		setPreferredSize (getSize ()) ;
		setFaceVisible(false);
	}

	/**
	 * changer la visibilité de la carte
	 * @param faceVisible : vrai si la face est visible, faux sinon
	 */
	public void setFaceVisible (boolean faceVisible) {
		face.setVisible(faceVisible);
		dos.setVisible(!faceVisible);
	}

	public final CCarte getControle () {
		return (controle) ;
	}

	public ImageIcon getIcone () {
		return icone ;
	}

	/**
     initialiser l'image du dos et les dimensions d'une PCarte
	 */
	static {
		iconeDos = new ImageIcon(ClassLoader.getSystemResource("ressources/dos.jpg")) ;
		largeur = iconeDos.getIconWidth () + 4;
		hauteur = iconeDos.getIconHeight () + 4;
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
		throws UnsupportedFlavorException, IOException {
		
		Object result = null ;
		if (flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType)) {
			result = this ;
		} else if (flavor.isMimeTypeEqual (new DataFlavor (String.class, null))) {
			result = toString() ;
		} else {
			result = null ;
		}
		return (result) ;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor data [] = new DataFlavor [2] ;
		try {
			data [0] = new DataFlavor (DataFlavor.javaJVMLocalObjectMimeType);
			data [1] = new DataFlavor (String.class, null) ;
		} catch (java.lang.ClassNotFoundException e) { }
		return (data) ;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if ((flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType))
			|| (flavor.isMimeTypeEqual (new DataFlavor (String.class, null)))) {
			return (true) ;
		} else {
			return (false) ;
		}
	}
}
