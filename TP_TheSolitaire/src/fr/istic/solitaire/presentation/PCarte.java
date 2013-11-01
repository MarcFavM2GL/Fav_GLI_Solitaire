package fr.istic.solitaire.presentation;

//import solitaire.controle.* ;
import java.awt.* ;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.* ;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.swing.* ;

import solitaire.application.Carte;
import fr.istic.solitaire.controle.CCarte;

/**
* Composant Présentation d'une carte
*/
public class PCarte extends JPanel implements Transferable, Serializable {

  protected CCarte controle ;		// contrôleur associé
  protected JLabel face, dos ;
  protected ImageIcon icone ;			// image de la face
  protected static ImageIcon iconeDos;	// image du dos
  public static int largeur, hauteur ;

  /**
   * initialiser une carte
   * @param chaine : nom de la carte (exemple "3H" = 3 Heart)
   */
  //public PCarte (final String chaine, final CCarte controle) {
  public PCarte (CCarte control, final String chaine) {
	
	this.controle = control ;
	// image de la face 
	icone = new ImageIcon(ClassLoader.getSystemResource("ressources/" + chaine + ".gif"));
	face = new JLabel (icone) ;
	add (face) ;
	face.setLocation (0, 0) ;
	face.setSize (largeur, hauteur) ;

	// image du dos
	dos = new JLabel (iconeDos) ;
	add (dos) ;
	dos.setLocation (0, 0) ;
	dos.setSize (largeur, hauteur) ;

	// le JPanel
	setLayout (null) ;
	setBackground (Color.black) ;
	setOpaque (true);
	setSize (face.getSize ()) ;
	setPreferredSize (getSize ()) ;
	setFaceVisible(false);
  } // constructeur

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




} // PCarte
