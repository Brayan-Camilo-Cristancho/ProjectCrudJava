package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon im;

	public PanelImagen() {
		
	}
	
	public void paint (Graphics g) {
		Dimension tam = getSize();
		im =  new ImageIcon(getClass().getResource("/imagenes/imagen3.jpg"));
		g.drawImage(im.getImage(), 0,0 , 884, 561, null);
		setOpaque(false);
		super.paint(g);
	}

	public ImageIcon getIm() {
		return im;
	}

	public void setIm(ImageIcon im) {
		this.im = im;
	}

	
	
}