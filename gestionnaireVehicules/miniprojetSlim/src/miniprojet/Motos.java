package miniprojet;

import javax.swing.ImageIcon;

public class Motos extends Vehicule{
	private static final long serialVersionUID = 1L;
	protected String modele;
		
	public Motos(String marque, String couleur, String modele,String type,ImageIcon photo) {
		super(marque, couleur, type,photo);
		this.modele=modele;
	}
	
	public String getModel(){return this.modele;}
}
